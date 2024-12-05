<?php
// Kết nối đến cơ sở dữ liệu (thay đổi thông tin kết nối phù hợp)
include "connect.php";

// Lấy idOrder từ yêu cầu (có thể là GET hoặc POST tùy vào trường hợp)
$idOrder = $_GET['idOrder']; // Giả sử bạn nhận được idOrder qua phương thức GET

// Câu truy vấn SQL để lấy dữ liệu từ cả hai bảng orders và orderitem theo idOrder
$sql = " SELECT orders.*, orderitem.* ,users.*, book.*
    FROM orders
    INNER JOIN orderitem ON orders.idOrder = orderitem.idOrder
    INNER JOIN book on orderitem.idBook = book.idBook
    INNER JOIN users on orders.idUser = users.idUser
    WHERE orders.idOrder = ?";

// Sử dụng Prepared Statements để tránh SQL Injection
$stmt = $conn->prepare($sql);

// Gán giá trị cho tham số ? trong câu truy vấn
$stmt->bind_param("i", $idOrder);

// Thực thi câu truy vấn
$stmt->execute();

// Lấy kết quả
$result = $stmt->get_result();

$data = array();

if ($result->num_rows > 0) {
  
        while ($row = $result->fetch_assoc()) {
            $data[] = $row;
        }

} else {
    echo "Không có dữ liệu";
}

header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($data);


// Đóng kết nối
$stmt->close();
$conn->close();
?>
