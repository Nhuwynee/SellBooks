<?php
include "connect.php";  // Kết nối cơ sở dữ liệu

// Lấy các tham số từ query string
$idUser = isset($_GET['IdUser']) ? intval($_GET['IdUser']) : null;

if ($idUser) {
    // Truy vấn đơn hàng có IdOrder lớn nhất của IdUser
    $query = "SELECT o.IdOrder, o.IdUser, o.orderTime, o.orderCost, o.orderStatus, 
                     u.name, u.phone, u.address 
              FROM orders o
              JOIN users u ON o.IdUser = u.IdUser
              WHERE o.IdUser = ? 
              ORDER BY o.IdOrder DESC 
              LIMIT 1";

    $stmt = $conn->prepare($query);
    $stmt->bind_param("i", $idUser);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($row = $result->fetch_assoc()) {
        // Trả về JSON cho đơn hàng lớn nhất
        header('Content-Type: application/json; charset=UTF-8');
        echo json_encode($row);
        exit;
    } else {
        echo json_encode(["message" => "No order found"]);
        exit;
    }
}

echo json_encode(["message" => "Invalid user ID"]);
$stmt->close();  // Đóng câu lệnh chuẩn bị
$conn->close();  // Đóng kết nối cơ sở dữ liệu
?>
