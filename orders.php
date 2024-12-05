
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
    <style>
        body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
}

.section-product-all {
    background: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    width: 90%;
    max-width: 1200px;
}
    .sidebar {
    position: fixed;
    top: 0;
    left: 0;
    height: 100vh;
    width: 250px; /* Chiều rộng sidebar */
    background-color: #fff;
    color: #fff;
    padding: 20px;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
    z-index: 1000; /* Đảm bảo sidebar luôn nằm trên */
}
.section-product-all{
    margin-left: 260px; /* Đẩy nội dung sang phải, ngang với chiều rộng sidebar */
    padding: 30px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    max-width: 1200px;
}
    </style>
</head>

<body>

    <div class="container">
        <aside class="sidebar open">
            <div class="top-sidebar">
            <a href="#" class="channel-logo"><img src="./assets/img/login.png" alt="Channel Logo" style="width: 150px; height: auto;"></a>

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
                    <li class="sidebar-list-item tab-content">
                        <a href="users.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-users"></i></div>
                            <div class="hidden-sidebar">Khách hàng</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item tab-content active">
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
<div class="section-product-all">
                <div class="admin-control">
                    <div class="admin-control-left">
                    <form method="GET" action="">
                        <select name="trang-thai" id="trang-thai" onchange="this.form.submit()">
                            <option value="tat-ca" <?= isset($_GET['trang-thai']) && $_GET['trang-thai'] == 'tat-ca' ? 'selected' : '' ?>>Tất cả</option>
                            <option value="da-giao" <?= isset($_GET['trang-thai']) && $_GET['trang-thai'] == 'da-giao' ? 'selected' : '' ?>>Đã giao</option>
                            <option value="dang-giao" <?= isset($_GET['trang-thai']) && $_GET['trang-thai'] == 'dang-giao' ? 'selected' : '' ?>>Đang giao</option>
                            <option value="da-huy" <?= isset($_GET['trang-thai']) && $_GET['trang-thai'] == 'da-huy' ? 'selected' : '' ?>>Đã hủy</option>
                        </select>
                    </form>
                    </div>
                    <?php
                    if (isset($_GET['trang-thai'])) {
                        $trangthai = $_GET['trang-thai'];}
                        else {
                            $trangthai = null;
                        }
                    ?>
                    <div class="admin-control-center">
                        <form action="orders.php" method="GET" class="form-search">
                            <input id="form-search-user" type="text" class="form-search-input" placeholder="Tìm kiếm mã đơn hàng" name="noidung">
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
                  
                </div>
                <div class="table">
                    <table width="100%">
                        <thead>
                            <tr>
                                <td>Mã đơn hàng</td>
                                <td>Avatar</td>
                                <td>Tên người đặt</td>
                                <td>Thời gian</td>
                                <td>Điểm thưởng</td>
                                <td>Trạng thái</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                        <?php
                            include "connect.php";
                            if ($noidung == null && $trangthai == null) {
                            $sql = "SELECT orders.IdOrder, users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                    FROM orders
                                    INNER JOIN users ON orders.idUser = users.idUser order by IdOrder";}
                            else if ($trangthai != NULL){
                                switch ($trangthai) {
                                    case 'tat-ca':
                                        $sql = "SELECT orders.IdOrder, users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                                FROM orders
                                                INNER JOIN users ON orders.idUser = users.idUser order by IdOrder;";
                                        break;
                                    case 'da-giao':
                                        $sql = "SELECT orders.IdOrder,users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                                FROM orders
                                                INNER JOIN users ON orders.idUser = users.idUser WHERE orderStatus = 'Đã giao' order by IdOrder";
                                        break;
                                    case 'dang-giao':
                                        $sql = "SELECT orders.IdOrder,users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                                FROM orders
                                                INNER JOIN users ON orders.idUser = users.idUser WHERE orderStatus = 'Đang giao' order by IdOrder";
                                        break;
                                    case 'da-huy':
                                        $sql = "SELECT orders.IdOrder,users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                                FROM orders
                                                INNER JOIN users ON orders.idUser = users.idUser WHERE orderStatus = 'Đã hủy' order by IdOrder";
                                        break;
                                    default:
                                        $sql = "SELECT orders.IdOrder,users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                                FROM orders
                                                INNER JOIN users ON orders.idUser = users.idUser order by IdOrder;"; 
                                        break;
                                }
                            }
                            else if ($noidung != null) {
                                $sql = "SELECT orders.IdOrder,users.avatarImage as avatarImage, users.name AS names, orders.orderTime, orders.pointOfOrder, orders.orderStatus
                                    FROM orders
                                    INNER JOIN users ON orders.idUser = users.idUser where orders.IdOrder = $noidung";
                            }
                            $result =mysqli_query($conn,$sql);
                            while($row = mysqli_fetch_array($result)){
                            ?>
                           <tr onclick="window.location='order_details.php?idOrder=<?php echo $row['IdOrder']; ?>';">
                                <td><?php echo $row['IdOrder'] ?></td>
                                <td><img width="50" height="50" src="img/<?php echo $row['avatarImage'] ?>" alt=""></td>
                                <td><?php echo $row['names'] ?></td>
                                <td><?php echo $row['orderTime'] ?></td>
                                <td><?php echo $row['pointOfOrder'] ?></td>
                                <td><?php echo $row['orderStatus'] ?></td>                               
                            </tr>
                            <?php } ?>
                        </tbody>
                    </table>
                </div>
    </div>
</body>
</html>