<?php
include "connect.php";

$conn->set_charset("utf8");

$idUser = isset($_GET['idUser']) ? intval($_GET['idUser']) : 0;

$query = "SELECT * FROM users WHERE idUser = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("i", $idUser);
$stmt->execute();
$result = $stmt->get_result();

header('Content-Type: application/json; charset=UTF-8');
if ($result->num_rows > 0) {
    echo json_encode($result->fetch_assoc(), JSON_UNESCAPED_UNICODE);
} else {
    echo json_encode(null);
}

$stmt->close();
$conn->close();
?>
