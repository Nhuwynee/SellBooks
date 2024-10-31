
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='./assets/img/iconlogo.jpg' rel='icon' type='image/x-icon' />
    <link rel="stylesheet" href="assets/css/addUser.css">
    <link rel="stylesheet" href="./assets/css/toast-message.css">
    <link href="./assets/font/font-awesome-pro-v6-6.2.0/css/all.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="./assets/css/admin-responsive.css">
    <title>Quản lý cửa hàng</title>
</head>
<body>
<?php
    include "connect.php";
    if(isset($_POST['btn'])){
        $name =$_POST['name'];
        $pas = $_POST['pass'];
        //chỉ lấy tên hình ảnh để lưu DB
        $img=$_FILES['img']['name']; 
        //lấy hình ảnh để past vào file img của mình
        $img_tmp_name = $_FILES['img']['tmp_name'];

        $phone=$_POST['phone'];
        $address=$_POST['address'];
        $level=$_POST['level'];
        $sql = "Insert into Users (password, name, phone, address, avatarImage,level)
                values ('$pas','$name','$phone','$address','$img',$level)";
        mysqli_query($conn,$sql);

        move_uploaded_file($img_tmp_name, 'img/'.$img);
        header("location: users.php");
    }
?>
<div class="form-container">
    <form action="addUser.php" method="post" enctype="multipart/form-data" class="product-form">
        <p>Ảnh đại diện</p>
        <input type="file" name="img" required>
        <p>Họ và tên</p>
        <input type="text" name="name" required>
        <p>Password</p>
        <input type="password" name="pass" required>
        <p>Số điện thoại</p>
        <input type="text" name="phone" required>
        <p>Địa chỉ</p>
        <input type="text" name="address" required>
        <p>Level</p>
        <input type="text" name="level" required>
   <button id="submit" name="btn">Thêm</button>
    </form>
</div>
</body>
