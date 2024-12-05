<?php
include "connect.php"; 

// Lấy dữ liệu từ ứng dụng Android (json)
$data = json_decode(file_get_contents("php://input"), true);

// Kiểm tra xem dữ liệu có đầy đủ không
if (isset($data['name']) && isset($data['phone']) && isset($data['address']) && isset($data['password'])) {
    $name = trim($data['name']);
    $phone = trim($data['phone']);
    $address = trim($data['address']);
    $password = $data['password'];
    $avatarImage = 'avatar_10.jpg';
    $level = 2;

    // Kiểm tra xem tên người dùng đã tồn tại chưa
    $checkQuery = "SELECT * FROM users WHERE name = ?";
    $checkStmt = $conn->prepare($checkQuery);
    $checkStmt->bind_param("s", $name);
    $checkStmt->execute();
    $checkResult = $checkStmt->get_result();

    if ($checkResult->num_rows > 0) {
        http_response_code(409);
        echo json_encode(["success" => false, "message" => "Tên người dùng đã tồn tại."]);
    } else {
        $query = "INSERT INTO users (name, phone, address, password, avatarImage, level) VALUES (?, ?, ?, ?, ?, ?)";
        $stmt = $conn->prepare($query);
        $stmt->bind_param("sssssi", $name, $phone, $address, $password, $avatarImage, $level);

        if ($stmt->execute()) {
            http_response_code(200);
            echo json_encode(["success" => true, "message" => "Đăng ký thành công."]);
        } else {
            http_response_code(500);
            echo json_encode(["success" => false, "message" => "Đăng ký thất bại."]);
        }

        $stmt->close();
    }

    $checkStmt->close();
    $conn->close();
} else {
    http_response_code(400); // Lỗi dữ liệu đầu vào
    echo json_encode(["success" => false, "message" => "Thiếu dữ liệu cần thiết."]);
}
?>
