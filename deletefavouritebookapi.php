<?php

include 'connect.php';

if (isset($_GET['idUser']) && isset($_GET['idBook'])) {
    $userId = intval($_GET['idUser']);
    $bookId = intval($_GET['idBook']);

    if (!$conn) {
        http_response_code(500); 
        echo json_encode([
            "status" => "error",
            "message" => "Kết nối cơ sở dữ liệu thất bại."
        ]);
        exit;
    }

    $stmt = $conn->prepare("DELETE FROM favouritebook WHERE idUser = ? AND idBook = ?");
    $stmt->bind_param("ii", $userId, $bookId);

   
    if ($stmt->execute()) {
        http_response_code(200); 
        echo json_encode([
            "status" => "success",
            "message" => "Sách đã được xóa khỏi danh sách yêu thích."
        ]);
    } else {
        http_response_code(500); 
        echo json_encode([
            "status" => "error",
            "message" => "Không thể xóa sách khỏi danh sách yêu thích."
        ]);
    }

    $stmt->close();
    $conn->close();
} else {
    http_response_code(400); 
    echo json_encode([
        "status" => "error",
        "message" => "Dữ liệu không hợp lệ. Vui lòng kiểm tra idUser và idBook."
    ]);
}


?>
