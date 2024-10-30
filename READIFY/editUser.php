
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
    $this_id = $_GET['this_id'];
    // echo $this_id;
    $sql = "Select * from Users where IdUser= $this_id ";
    $query = mysqli_query($conn,$sql);
    $row = mysqli_fetch_assoc($query);

    //khi nhấn nút edit
    
    if (isset($_POST['btn'])){
        $name =$_POST['name'];

        if (isset($_FILES['img']) && $_FILES['img']['error'] == UPLOAD_ERR_OK){ //không có ảnh mới đc cập nhật
            //chỉ lấy tên hình ảnh để lưu DB
            $img=$_FILES['img']['name']; 
            //lấy hình ảnh để past vào file img của mình
            $img_tmp_name = $_FILES['img']['tmp_name'];
            move_uploaded_file($img_tmp_name, 'img/'.$img);
        }
        else
        {
            $img = $row['image'];
        }
    
        $phone=$_POST['phone'];
        $address=$_POST['address'];
        $level=$_POST['level'];
        $sql = "update Users set name='$name', phone='$phone', address='$address', avatarImage = '$img', level=$level where IdUser ='$this_id'";
        mysqli_query($conn,$sql);
      
         header('location: users.php');
    }
?>
<div class="form-container">
<form action="editUser.php?this_id=<?php echo $this_id; ?>" method="post" enctype="multipart/form-data" class="product-form">
        <p>Ảnh đại diện</p>
        <span><img width="50px" height="50px" src="img/<?php echo $row['avatarImage'] ?>" alt=""></span>
         <input type="file" name="img">
        <p>Họ và tên</p>
        <input type="text" name="name" value="<?php echo $row['name'];?>"> 
        <p>Số điện thoại</p>
        <input type="text" name="phone" value="<?php echo $row['phone'];?>"> 
        <p>Địa chỉ</p>
        <input type="text" name="address" value="<?php echo $row['address'];?>"> 
        <p>Level</p>
        <input type="text" name="level" value="<?php echo $row['level'];?>"> 
    <button id="submit" name="btn">Edit</button>
</form> 
</div>
</body>
</html>