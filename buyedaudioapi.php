<?php
include "connect.php";

$idUser = isset($_GET['idUser']) ? intval($_GET['idUser']) : null;

if ($idUser) {
    $query = "SELECT DISTINCT book.* FROM book
              INNER JOIN orderitem ON book.idBook = orderitem.idBook
              INNER JOIN orders ON orderitem.idOrder = orders.idOrder
              WHERE book.URLaudioBook IS NOT NULL 
                AND book.URLaudioBook != '' 
                AND orders.idUser = ? 
                AND orders.orderStatus = 'Đã giao'"; 
                
    $stmt = $conn->prepare($query);
    
    if (!$stmt) {
        die("Lỗi chuẩn bị truy vấn: " . $conn->error);
    }
    
    $stmt->bind_param("i", $idUser);
    $stmt->execute();
    $result = $stmt->get_result();

    $data = [];
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $data[] = $row;
        }
    }
    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($data);
} else {
    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode([]);
}
$stmt->close();
$conn->close();
?>
