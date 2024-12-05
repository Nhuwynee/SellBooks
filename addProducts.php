<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='./assets/img/iconlogo.jpg' rel='icon' type='image/x-icon' />
    <link rel="stylesheet" href="assets/css/editProducts.css">
    <link rel="stylesheet" href="./assets/css/toast-message.css">
    <link href="./assets/font/font-awesome-pro-v6-6.2.0/css/all.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="./assets/css/admin-responsive.css">
    <title>Quản lý cửa hàng</title>
</head>
<body>
<?php
    include "connect.php";
  
    // Khi nhấn nút thêm sách
    if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['btn'])) {
        $title = $_POST['title'];
        $author = $_POST['author'];
        $category = $_POST['category'];
        $price = $_POST['price'];
        $inStock = $_POST['inStock'];
        $description = $_POST['description'];
        $review = $_POST['review'];
        $detailAuthor = $_POST['detailAuthor'];
        $point = $_POST['point'];
        $isActive = $_POST['isActive'];

        // Xử lý hình ảnh
        $img = $_FILES['image']['name'];
        $img_tmp_name = $_FILES['image']['tmp_name'];
        move_uploaded_file($img_tmp_name, 'img/' . $img);

        // Xử lý file audiobook
        $audioFile = $_FILES['audioBookFile']['name'];
        $audio_tmp_name = $_FILES['audioBookFile']['tmp_name'];
        move_uploaded_file($audio_tmp_name, 'mp3/' . $audioFile);

        // Xử lý file đọc thử
        $readingSampleFile = $_FILES['readingSample']['name'];
        $readingSample_tmp_name = $_FILES['readingSample']['tmp_name'];
        move_uploaded_file($readingSample_tmp_name, 'sampleRead/' . $readingSampleFile); 

        $sql = "INSERT INTO Book (title, author, category, price, inStock, description, 
                review, detailAuthor, pointOfBook, imgResource, URLaudioBook, sampleRead, isActive) 
                VALUES ('$title', '$author', '$category', '$price', '$inStock', '$description', 
                '$review', '$detailAuthor', '$point', '$img', '$audioFile', '$readingSampleFile', '$isActive')";

        // Thực thi câu lệnh SQL
        if (mysqli_query($conn, $sql)) {
            header('Location: products.php'); // Chuyển hướng đến trang sách
            exit(); // Dừng thực hiện script sau khi chuyển hướng
        } else {
            echo "Error adding record: " . mysqli_error($conn); // Hiển thị lỗi nếu có
        }
    }
?>
<div class="form-container">
<h2>Thêm sách</h2>
    <form action="addProducts.php" method="post" enctype="multipart/form-data" class="product-form">
        <div class="form-row">
            <div class="form-column">
                <div class="field-group">
                    <p>Tên sách</p>
                    <input type="text" name="title" required> 
                </div>
                <div class="field-group">
                    <p>Tác giả</p>
                    <input type="text" name="author" required> 
                </div>
                <div class="field-group">
                    <p>Giá</p>
                    <input type="text" name="price" required> 
                </div>
                <div class="field-group">
                    <p>Chi tiết</p>
                    <textarea name="description" required></textarea>
                </div>
            </div>

            <div class="form-column">
                <div class="field-group">
                    <p>Ảnh bìa</p>
                    <input type="file" name="image" required>
                </div>
                <div class="field-group">
                    <p>Thể loại</p>
                    <input type="text" name="category" required> 
                </div>
                <div class="field-group">
                    <p>Trong kho</p>
                    <input type="number" name="inStock" required> 
                </div>
                <div class="field-group">
                    <p>Đánh giá</p>
                    <textarea name="review" required></textarea>
                </div>
                <div class="field-group">
                    <p>Điểm</p>
                    <input type="number" name="point" required> 
                </div>
                <div class="field-group">
                    <p>Về tác giả</p>
                    <textarea name="detailAuthor" required></textarea>
                </div>
            </div>
        </div>
        <div class="field-group">
            <p>File audiobook (nếu có)</p>
            <input type="file" name="audioBookFile">
        </div>
        <div class="field-group">
            <p>Đọc thử (file Word)</p>
            <input type="file" name="readingSample" accept=".doc,.docx">
        </div>
        <div class="field-group">
            <p>Hiển thị</p>
            <select name="isActive">
                <option value="1">Hoạt động</option>
                <option value="0">Không hoạt động</option>
            </select>
        </div>
        <button id="submit" name="btn">Thêm</button>
    </form> 
</div>
</body>
</html>
