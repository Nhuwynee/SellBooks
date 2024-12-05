<?php
include "connect.php";

$data = json_decode(file_get_contents("php://input"), true);

$idUser = $data['idUser'];
$name = $data['name'];
$phone = $data['phone'];
$address = $data['address'];

$query = "UPDATE users SET name = ?, phone = ?, address = ? WHERE idUser = ?";
$stmt = $conn->prepare($query);
$stmt->bind_param("sssi", $name, $phone, $address, $idUser);
$response = $stmt->execute();

echo json_encode(["success" => $response]);

$stmt->close();
$conn->close();
?>
