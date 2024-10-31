
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='./assets/img/iconlogo.jpg' rel='icon' type='image/x-icon' />
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="./assets/css/toast-message.css">
    <link href="./assets/font/font-awesome-pro-v6-6.2.0/css/all.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="./assets/css/admin-responsive.css">
    <title>Quản lý cửa hàng</title>
</head>

<body>

    <div class="container">
        <aside class="sidebar open">
            <div class="top-sidebar">
            <a href="#" class="channel-logo"><img src="./assets/img/login.png" alt="Channel Logo" style="width: 200px; height: auto;"></a>

            </div>
            <div class="middle-sidebar">
                <ul class="sidebar-list">
                    <li class="sidebar-list-item tab-content">
                        <a href="index.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-house"></i></div>
                            <div class="hidden-sidebar">Trang tổng quan</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item tab-content">
                        <a href="products.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-pot-food"></i></div>
                            <div class="hidden-sidebar">Sản phẩm</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item tab-content active">
                        <a href="users.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-users"></i></div>
                            <div class="hidden-sidebar">Khách hàng</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item tab-content">
                        <a href="orders.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-basket-shopping"></i></div>
                            <div class="hidden-sidebar">Đơn hàng</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item tab-content">
                        <a href="total.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-chart-simple"></i></div>
                            <div class="hidden-sidebar">Thống kê</div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="bottom-sidebar">
                <ul class="sidebar-list">
                    <li class="sidebar-list-item user-logout">
                        <a href="./index.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-thin fa-circle-chevron-left"></i></div>
                            <div class="hidden-sidebar">Trang chủ</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item user-logout">
                        <a href="#" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-circle-user"></i></div>
                            <div class="hidden-sidebar" id="name-acc"></div>
                        </a>
                    </li>
                    <li class="sidebar-list-item user-logout">
                        <a href="./index.php" class="sidebar-link" id="logout-acc">
                            <div class="sidebar-icon"><i class="fa-light fa-arrow-right-from-bracket"></i></div>
                            <div class="hidden-sidebar">Đăng xuất</div>
                        </a>
                    </li>
                </ul>
            </div>
        </aside>
         <div class="section">
                <div class="admin-control">
                    <div class="admin-control-left">
                        <select name="tinh-trang-user" id="tinh-trang-user" >
                            <option value="2">Tất cả</option>
                            <option value="1">Hoạt động</option>
                            <option value="0">Bị khóa</option>
                        </select>
                    </div>
                    <div class="admin-control-center">
                        <form action="users.php" method="GET" class="form-search">
                            <input id="form-search-user" type="text" class="form-search-input" placeholder="Tìm kiếm khách hàng..." name="noidung">
                            <button type="submit" class="search-btn" name="btn">
                                <i class="fa-light fa-magnifying-glass"></i>
                            </button>
                        </form>
                    </div>
                        <?php
                        if (isset($_GET['btn'])) {
                            $noidung = $_GET['noidung'];
                         }
                        else {
                            $noidung = null;
                        }
                        ?>
                        <div class="admin-control-right">
                        <a href="addUser.php" class="btn-control-large" id="btn-add-user">
                            <i class="fa-light fa-plus"></i>
                            <span>Thêm khách hàng</span>
                        </a>
                    </div>
                </div>
                <div class="table">
                    <table width="100%">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Ảnh đại diện</td>
                                <td>Họ và tên</td>
                                <td>Số điện thoại</td>
                                <td>Địa chỉ</td>
                                <td>Level</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                        <?php
                            include "connect.php";
                            if ($noidung == null) {
                            $sql = "SELECT * FROM users";}
                            else {
                                $sql = "SELECT * FROM users where name like '%$noidung%'";
                            }
                            $result =mysqli_query($conn,$sql);
                            while($row = mysqli_fetch_array($result)){
                            ?>
                         
                            <tr>
                                <td><?php echo $row['IdUser'] ?></td>
                                <td><img width= "50" height = "50" src="img/<?php echo $row['avatarImage'] ?>" alt=""></td>
                                <td><?php echo $row['name'] ?></td>
                                <td><?php echo $row['phone'] ?></td>
                                <td><?php echo $row['address'] ?></td>
                                <td><?php echo $row['level']?></td>
                                <td class="control control-table">
                               <a href="editUser.php?this_id=<?php echo $row['IdUser']?>"> <button class="btn-edit" id="edit-account" ><i class="fa-light fa-pen-to-square"></i></button></a>
                               <a href="deleteUser.php?this_id=<?php echo $row['IdUser']?>"> <button class="btn-delete" id="delete-account"><i class="fa-regular fa-trash"></i></button></a>
                                </td>
                            </tr>
                        <?php  } ?>
                        </tbody>
                        <br>
                    </table>
                </div>
            </div>
    </div>
</body>
</html>