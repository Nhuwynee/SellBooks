<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Origin: *");

include "connect.php";

// Kiểm tra kết nối
if ($conn->connect_error) {
    http_response_code(500);  // Trả về lỗi server nếu không thể kết nối
    echo json_encode(["error" => "Kết nối thất bại: " . $conn->connect_error]);
    exit;
}

// Đọc dữ liệu JSON từ client
$data = json_decode(file_get_contents("php://input"), true);

// Kiểm tra dữ liệu JSON hợp lệ
if (!$data) {
    http_response_code(400);  // Trả về lỗi nếu dữ liệu không hợp lệ
    echo json_encode(["error" => "Dữ liệu JSON không hợp lệ"]);
    exit;
}

// Kiểm tra dữ liệu bắt buộc có trong JSON
if (!isset($data['IdUser'], $data['pointOfOrder'], $data['orderDetails'], $data['point']) || !is_array($data['orderDetails'])) {
    http_response_code(400);  // Trả về lỗi nếu thiếu dữ liệu hoặc dữ liệu không hợp lệ
    echo json_encode(["error" => "Dữ liệu không hợp lệ"]);
    exit;
}

// Lấy dữ liệu từ client
$idUser = $data['IdUser']; // Chú ý 'IdUser' thay vì 'idUser'
$poitOfOrder = $data['pointOfOrder'];
$orderTime = date("Y-m-d H:i:s"); // Thời gian hiện tại
$orderStatus = "Đang giao"; // Trạng thái mặc định
$orderDetails = $data['orderDetails']; // Danh sách chi tiết đơn hàng
$point = $data['point']; // Lấy giá trị điểm từ Android

// Bắt đầu giao dịch
$conn->begin_transaction();

try {
    // 1. Chèn vào bảng `orders`
    $sql_order = "INSERT INTO orders (IdUser, orderTime, pointOfOrder, orderStatus) VALUES (?, ?, ?, ?)";
    $stmt_order = $conn->prepare($sql_order);
    if (!$stmt_order) {
        throw new Exception("Lỗi khi chuẩn bị câu lệnh SQL cho bảng orders");
    }
    $stmt_order->bind_param("isss", $idUser, $orderTime, $poitOfOrder, $orderStatus);

    if (!$stmt_order->execute()) {
        throw new Exception("Lỗi khi chèn vào bảng orders: " . $stmt_order->error);
    }

    // Lấy ID của đơn hàng vừa chèn
    $idOrder = $conn->insert_id;

    // 2. Chèn vào bảng `order_details`
    $sql_order_details = "INSERT INTO orderitem (idOrder, idBook, number) VALUES (?, ?, ?)";
    $stmt_details = $conn->prepare($sql_order_details);
    if (!$stmt_details) {
        throw new Exception("Lỗi khi chuẩn bị câu lệnh SQL cho bảng order_details");
    }

    foreach ($orderDetails as $detail) {
        if (!isset($detail['idBook'], $detail['number'])) {
            throw new Exception("Thiếu dữ liệu trong orderDetails");
        }

        $idBook = $detail['idBook'];
        $number = $detail['number'];

        $stmt_details->bind_param("iii", $idOrder, $idBook, $number);

        if (!$stmt_details->execute()) {
            throw new Exception("Lỗi khi chèn vào bảng order_details: " . $stmt_details->error);
        }
    }

    // 3. Cập nhật điểm cho người dùng trong bảng `user`
    $sql_update_points = "UPDATE users SET point = ? WHERE IdUser = ?";
    $stmt_update_points = $conn->prepare($sql_update_points);
    if (!$stmt_update_points) {
        throw new Exception("Lỗi khi chuẩn bị câu lệnh SQL cho bảng user");
    }

    // Cập nhật điểm cho người dùng
    $stmt_update_points->bind_param("ii", $point, $idUser);

    if (!$stmt_update_points->execute()) {
        throw new Exception("Lỗi khi cập nhật điểm cho người dùng: " . $stmt_update_points->error);
    }

    // 4. Xóa các mục trong bảng `cart` sau khi tạo đơn hàng thành công
    $sql_delete_cart = "DELETE FROM cart WHERE IdUser = ?";
    $stmt_delete_cart = $conn->prepare($sql_delete_cart);
    if (!$stmt_delete_cart) {
        throw new Exception("Lỗi khi chuẩn bị câu lệnh SQL cho bảng cart");
    }

    $stmt_delete_cart->bind_param("i", $idUser);

    if (!$stmt_delete_cart->execute()) {
        throw new Exception("Lỗi khi xóa mục trong bảng cart: " . $stmt_delete_cart->error);
    }

    // Commit giao dịch
    $conn->commit();

    // Trả về mã trạng thái thành công
    http_response_code(200); // OK
    echo json_encode(["success" => "Đơn hàng đã được tạo thành công và giỏ hàng đã được xóa"]);

} catch (Exception $e) {
    // Rollback nếu xảy ra lỗi
    $conn->rollback();
    http_response_code(500); // Internal Server Error
    echo json_encode(["error" => "Lỗi khi thực thi: " . $e->getMessage()]);
} finally {
    // Đóng kết nối
    if (isset($stmt_order)) $stmt_order->close();
    if (isset($stmt_details)) $stmt_details->close();
    if (isset($stmt_delete_cart)) $stmt_delete_cart->close();
    if (isset($stmt_update_points)) $stmt_update_points->close();
    $conn->close();
}
?>
