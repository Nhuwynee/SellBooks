<?php

include "connect.php";
$id = isset($_GET['id']) ? intval($_GET['id']) : null;


if ($id) {
    $query = "SELECT * FROM users WHERE IdUser= $id";
} else {
    $query = "SELECT * FROM users"; 
}
$result = $conn->query($query);

$data = array();

if ($result->num_rows > 0) {
    if ($id && $result->num_rows == 1) {
        $data = $result->fetch_assoc(); 
    } else {
        while ($row = $result->fetch_assoc()) {
            $data[] = $row;
        }
    }
} else {
    echo "Không có dữ liệu";
}

header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($data);

$conn->close();

?>