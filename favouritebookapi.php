<?php
include "connect.php";

$idUser = isset($_GET['idUser']) ? intval($_GET['idUser']) : null;
if ($idUser) {
    $query = "SELECT book.* FROM book
              WHERE book.idBook IN (
                  SELECT idBook FROM favouritebook WHERE idUser = ?
              )";
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
    } else {
        $data = []; 
    }
    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($data);
} else {
    echo json_encode([]);
}

$stmt->close();
$conn->close();
?>