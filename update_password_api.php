<?php
require 'connect.php'; // Kết nối DB

$data = json_decode(file_get_contents("php://input"), true);

// Kiểm tra nếu tất cả các thông tin cần thiết đều có
if (isset($data['phone']) && isset($data['newPassword']) ) {
    $phone = $data['phone'];
    $newPassword = $data['newPassword'];

    // Cập nhật mật khẩu trong cơ sở dữ liệu
    $updateSql = "UPDATE users SET password = '$newPassword' WHERE phone = '$phone'";
    if (mysqli_query($conn, $updateSql)) {
        // Trả về phản hồi thành công khi cập nhật số lượng
        echo json_encode(["status" => "success", "message" => "Sản phẩm đã được cập nhật số lượng trong giỏ hàng."]);
    } else {
        // Trả về lỗi nếu cập nhật không thành công
        echo json_encode(["status" => "error", "message" => "Không thể cập nhật số lượng sản phẩm trong giỏ hàng."]);
    }
    $stmt->close();
} else {
    echo json_encode(["status" => "error", "message" => "Dữ liệu không hợp lệ."]);
}
?>
