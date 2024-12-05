
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
    $this_id = $_GET['this_id'];
    $sql = "Select * from Book where idBook= $this_id ";
    $query = mysqli_query($conn,$sql);
    $row = mysqli_fetch_assoc($query);

    //khi nhấn nút edit
    if (isset($_POST['btn'])) {
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
        if (isset($_FILES['image']) && $_FILES['image']['error'] == UPLOAD_ERR_OK) {
            $img = $_FILES['image']['name'];
            $img_tmp_name = $_FILES['image']['tmp_name'];
            move_uploaded_file($img_tmp_name, 'img/books' . $img);
        } else {
            $img = $row['imgResource']; 
        }
    
        // Xử lý file audiobook
        if (isset($_FILES['audioBookFile']) && $_FILES['audioBookFile']['error'] == UPLOAD_ERR_OK) {
            $audioFile = $_FILES['audioBookFile']['name'];
            $audio_tmp_name = $_FILES['audioBookFile']['tmp_name'];
            move_uploaded_file($audio_tmp_name, 'mp3/' . $audioFile);
        } else {
            $audioFile = $row['URLaudioBook']; // Giữ nguyên file audiobook hiện tại
        }
    
        // Xử lý file đọc thử
        if (isset($_FILES['readingSample']) && $_FILES['readingSample']['error'] == UPLOAD_ERR_OK) {
            $readingSampleFile = $_FILES['readingSample']['name'];
            $readingSample_tmp_name = $_FILES['readingSample']['tmp_name'];
            move_uploaded_file($readingSample_tmp_name, 'sampleRead/' . $readingSampleFile); 
        } else {
            $readingSampleFile = $row['sampleRead']; // Giữ nguyên file đọc thử hiện tại
        }
    
        $sql = "UPDATE book SET title='$title', author='$author', category='$category', 
                price='$price', inStock='$inStock', description='$description', 
                review='$review', detailAuthor='$detailAuthor', pointOfBook='$point', 
                imgResource='$img', URLaudioBook='$audioFile', sampleRead='$readingSampleFile', 
                isActive='$isActive' WHERE idBook='$this_id'";
    
        // Thực thi câu lệnh SQL
        if (mysqli_query($conn, $sql)) {
            header('Location: products.php'); // Chuyển hướng đến trang sách
            exit(); // Dừng thực hiện script sau khi chuyển hướng
        } else {
            echo "Error updating record: " . mysqli_error($conn); // Hiển thị lỗi nếu có
        }
      
    }
?>
<div class="form-container">
<h2>Chỉnh sửa sách</h2>
    <form action="editProducts.php?this_id=<?php echo $this_id; ?>" method="post" enctype="multipart/form-data" class="product-form">
        <div class="form-row">
            <div class="form-column">
                <div class="field-group">
                    <p>ID sách</p>
                    <input type="text" name="id" value="<?php echo $row['idBook'];?>"> 
                </div>
                <div class="field-group">
                    <p>Tên sách</p>
                    <input type="text" name="title" value="<?php echo $row['title'];?>"> 
                </div>
                <div class="field-group">
                    <p>Tác giả</p>
                    <input type="text" name="author" value="<?php echo $row['author'];?>"> 
                </div>
                <div class="field-group">
                    <p>Giá</p>
                    <input type="text" name="price" value="<?php echo $row['price'];?>"> 
                </div>
                <div class="field-group">
                    <p>Chi tiết</p>
                    <textarea name="description"><?php echo $row['description'];?></textarea>
                </div>
            </div>

            <div class="form-column">
                <div class="field-group">
                    <p>Ảnh bìa</p>
                    <span><img width= "50" height = "50" src="img/books/<?php echo $row['imgResource'] ?>" alt=""></span>
                    <input type="file" name="image">
                </div>
                <div class="field-group">
                    <p>Thể loại</p>
                    <input type="text" name="category" value="<?php echo $row['category'];?>"> 
                </div>
                <div class="field-group">
                    <p>Trong kho</p>
                    <input type="number" name="inStock" value="<?php echo $row['inStock'];?>"> 
                </div>
                <div class="field-group">
                    <p>Đánh giá</p>
                    <textarea name="review"><?php echo $row['review'];?></textarea>
                </div>
                <div class="field-group">
                    <p>Điểm</p>
                    <input type="number" name="point" value="<?php echo $row['pointOfBook'];?>"> 
                </div>
                <div class="field-group">
                    <p>Về tác giả</p>
                    <textarea name="description"><?php echo $row['detailAuthor'];?></textarea>
                </div>
            </div>
        </div>
        <!-- Các trường còn lại -->
        <div class="field-group">
            <p>File audiobook (nếu có)</p>
            <audio controls>
                <source src="mp3/<?php echo $row['URLaudioBook']; ?>" type="audio/mpeg">
            </audio>
            <input type="file" name="audioBookFile">
        </div>
        <div class="field-group">
            <?php $readingSampleFile = $row['sampleRead']; ?>
            <p>Đọc thử (file Word)</p>
            <?php if (!empty($readingSampleFile)): ?>
                <p>Tên file: 
                    <a href="sampleRead/<?php echo $readingSampleFile; ?>" target="_blank">
                        <?php echo $readingSampleFile; ?>
                    </a>
                </p>
            <?php else: ?>
                <p>Không có file đọc thử.</p>
            <?php endif; ?>
            <input type="file" name="readingSample" accept=".doc,.docx">
        </div>
        <div class="field-group">
            <p>Hiển thị</p>
            <select name="isActive">
                <option value="1" <?php echo $row['isActive'] == 1 ? 'selected' : ''; ?>>Hoạt động</option>
                <option value="0" <?php echo $row['isActive'] == 0 ? 'selected' : ''; ?>>Không hoạt động</option>
            </select>
        </div>
        <button id="submit" name="btn">Edit</button>
    </form> 
</div>
</body>
</html>