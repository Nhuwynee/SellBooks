<?php

include "connect.php";  // Kết nối cơ sở dữ liệu

// Lấy các tham số từ query string
$idOrder = isset($_GET['idOrder']) ? intval($_GET['idOrder']) : null;
$idUser = isset($_GET['idUser']) ? intval($_GET['idUser']) : null;

// Câu truy vấn cơ sở dữ liệu
if ($idOrder) {
    // Lấy thông tin đơn hàng theo `idOrder`
    $query = "SELECT * FROM `orders` WHERE IdOrder = $idOrder";
} elseif ($idUser) {
    // Lấy tất cả đơn hàng của một người dùng theo `idUser`
    $query = "SELECT * FROM `orders` WHERE IdUser = $idUser";
} else {
    // Lấy tất cả đơn hàng
    $query = "SELECT * FROM `orders`";
}

$result = $conn->query($query);
$data = array();

// Xử lý kết quả truy vấn
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $data[] = $row;  // Thêm từng đơn hàng vào mảng dữ liệu
    }
} else {
    echo json_encode(["message" => "No orders found"]);
    exit;
}

// Trả về dữ liệu dưới dạng JSON
header('Content-Type: application/json; charset=UTF-8');
echo json_encode($data);

$conn->close();  // Đóng kết nối cơ sở dữ liệu

?>
