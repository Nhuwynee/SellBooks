<?php

include "connect.php";
$id = isset($_GET['id']) ? intval($_GET['id']) : null;


if ($id) {
    $query = "SELECT b.*, c.*, u.*
FROM book b
JOIN cart c ON b.idBook = c.idBook
JOIN users u ON c.idUser = u.idUser
WHERE c.idUser = $id";

} else {
    $query = "SELECT b.*, c.*, u.*
FROM book b
JOIN cart c ON b.idBook = c.idBook
JOIN users u ON c.idUser = u.idUser"; 
}
$result = $conn->query($query);

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

$conn->close();

?>