<?php
// connect.php: Kết nối với cơ sở dữ liệu
$server = 'localhost';
$user = 'root';
$pass = '';
$database = 'READIFY4';
$port = 3307;

// Kết nối MySQLi
$conn = new mysqli($server, $user, $pass, $database, $port);

if ($conn->connect_error) {
    die('Kết nối không thành công: ' . $conn->connect_error);
} else {
    $conn->set_charset("utf8mb4");
}

// Kiểm tra nếu yêu cầu là phương thức DELETE
if ($_SERVER['REQUEST_METHOD'] == 'DELETE') {

    // Kiểm tra tham số idBook và idUser từ URL
    if (isset($_GET['idBook']) && isset($_GET['idUser'])) {
        $bookId = $_GET['idBook'];  // Lấy idBook từ URL
        $userId = $_GET['idUser'];  // Lấy idUser từ URL

        // Câu truy vấn SQL để xóa sách khỏi giỏ hàng theo idBook và idUser
        $query = "DELETE FROM cart WHERE idBook = ? AND idUser = ?";

        // Chuẩn bị câu truy vấn
        if ($stmt = $conn->prepare($query)) {
            // Ràng buộc tham số vào câu truy vấn
            $stmt->bind_param('ii', $bookId, $userId);  // 'ii' là kiểu dữ liệu của idBook và idUser (int)

            // Thực thi câu truy vấn và kiểm tra kết quả
            if ($stmt->execute()) {
                // Nếu xóa thành công, trả về mã trạng thái 200 và thông báo thành công
                http_response_code(200);
                echo json_encode(["message" => "Book successfully removed from the cart."]);
            } else {
                // Nếu có lỗi khi xóa, kiểm tra lỗi SQL
                http_response_code(400);
                echo json_encode(["message" => "Failed to remove book from cart. Error: " . $stmt->error]);
            }

            // Đóng câu truy vấn sau khi thực thi
            $stmt->close();
        } else {
            // Nếu không chuẩn bị được câu truy vấn
            http_response_code(400);
            echo json_encode(["message" => "Failed to prepare SQL query."]);
        }
    } else {
        // Nếu không có idBook hoặc idUser, trả về mã lỗi 400 và thông báo lỗi
        http_response_code(400);
        echo json_encode(["message" => "Invalid or missing idBook or idUser. Please provide valid idBook and idUser."]);
    }

} else {
    // Nếu phương thức không phải là DELETE, trả về mã lỗi 405
    http_response_code(405); // Method Not Allowed
    echo json_encode(["message" => "Method Not Allowed. Use DELETE method."]);
}
?>
