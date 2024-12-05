<?php
// connect.php: Kết nối với cơ sở dữ liệu
include 'connect.php';

// Lấy dữ liệu JSON từ request
$data = json_decode(file_get_contents("php://input"), true);

// Kiểm tra nếu tất cả các thông tin cần thiết đều có
if (isset($data['idUser']) && isset($data['idBook']) && isset($data['number'])) {
    $userId = $data['idUser'];
    $bookId = $data['idBook'];
    $quantity = $data['number'];

    // Kiểm tra nếu cặp (idUser, idBook) đã tồn tại trong giỏ hàng
    $checkSql = "SELECT * FROM Cart WHERE idUser = '$userId' AND idBook = '$bookId'";
    $checkResult = mysqli_query($conn, $checkSql);

    if (mysqli_num_rows($checkResult) > 0) {
        // Nếu đã có, thực hiện cập nhật số lượng
        $updateSql = "UPDATE Cart SET number ='$quantity' WHERE idUser = '$userId' AND idBook = '$bookId'";
        
        if (mysqli_query($conn, $updateSql)) {
            // Trả về phản hồi thành công khi cập nhật số lượng
            echo json_encode(["status" => "success", "message" => "Sản phẩm đã được cập nhật số lượng trong giỏ hàng."]);
        } else {
            // Trả về lỗi nếu cập nhật không thành công
            echo json_encode(["status" => "error", "message" => "Không thể cập nhật số lượng sản phẩm trong giỏ hàng."]);
        }
    } else {
        // Nếu chưa có, thực hiện thêm mới
        $insertSql = "INSERT INTO Cart (idUser, idBook, number) VALUES ('$userId', '$bookId', '$quantity')";
        
        if (mysqli_query($conn, $insertSql)) {
            // Trả về phản hồi thành công khi thêm mới
            echo json_encode(["status" => "success", "message" => "Sản phẩm đã được thêm vào giỏ hàng."]);
        } else {
            // Trả về lỗi nếu thêm mới không thành công
            echo json_encode(["status" => "error", "message" => "Không thể thêm sản phẩm vào giỏ hàng."]);
        }
    }
} else {
    // Nếu dữ liệu không hợp lệ
    echo json_encode(["status" => "error", "message" => "Dữ liệu không hợp lệ."]);
}
?>
