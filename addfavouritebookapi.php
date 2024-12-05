<?php
include 'connect.php';
$data = json_decode(file_get_contents("php://input"), true);

if (isset($data['idUser']) && isset($data['idBook'])) {
    $userId = $data['idUser'];
    $bookId = $data['idBook'];

    $sql = "INSERT INTO favouritebook (idUser, idBook) VALUES ('$userId', '$bookId')";

    if (mysqli_query($conn, $sql)) {

        echo json_encode(["status" => "success", "message" => "Sản phẩm đã được thêm vào yêu thích."]);
    } else {
        echo json_encode(["status" => "error", "message" => "Không thể thêm sản phẩm vào yêu thích."]);
    }
} else {
    echo json_encode(["status" => "error", "message" => "Dữ liệu không hợp lệ."]);
}
?>
