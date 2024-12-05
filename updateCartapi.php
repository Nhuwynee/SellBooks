<?php
include 'connect.php';

$data = json_decode(file_get_contents("php://input"), true);

if (isset($data['idUser']) && isset($data['idBook']) && isset($data['number'])) {
    $userId = intval($data['idUser']);
    $bookId = intval($data['idBook']);
    $quantity = intval($data['number']);

    // Chuẩn bị câu lệnh SQL để cập nhật số lượng sách trong giỏ hàng dựa trên idUser và idBook
    $stmt = $conn->prepare("UPDATE Cart SET number = ? WHERE idUser = ? AND idBook = ?");
    $stmt->bind_param("iii", $quantity, $userId, $bookId);

    // Thực hiện truy vấn và kiểm tra kết quả
    if ($stmt->execute()) {
        echo json_encode(["status" => "success", "message" => "Cập nhật số lượng thành công."]);
    } else {
        echo json_encode(["status" => "error", "message" => "Cập nhật số lượng thất bại."]);
    }

    // Đóng câu lệnh chuẩn bị
    $stmt->close();
} else {
    echo json_encode(["status" => "error", "message" => "Dữ liệu không hợp lệ."]);
}

// Đóng kết nối cơ sở dữ liệu
$conn->close();
?>
