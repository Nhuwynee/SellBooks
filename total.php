<?php
include "connect.php";
?>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='./assets/img/iconlogo.jpg' rel='icon' type='image/x-icon' />
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="./assets/css/toast-message.css">
    <link href="./assets/font/font-awesome-pro-v6-6.2.0/css/all.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="./assets/css/admin-responsive.css">
</head>
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

.section {
    background: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    width: 100%;
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
.section{
    margin-left: 260px; /* Đẩy nội dung sang phải, ngang với chiều rộng sidebar */
    padding: 30px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    max-width: 1200px;
}
h1 {
    text-align: center;
    color: #333;
    font-size: 32px; /* Tăng cỡ chữ cho h1 */
}

h2 {
    color: #333;
    font-size: 30px; /* Tăng cỡ chữ cho h2 */
}

table {
    width: 100%;
    margin: 20px 0;
    border-collapse: collapse;
    font-size: 25px; /* Tăng cỡ chữ trong bảng */
}

table, th, td {
    border: 1px solid #ddd;
}

th, td {
    padding: 12px; /* Tăng khoảng cách cho các ô trong bảng */
    text-align: left;
    font-size: 25px; /* Cỡ chữ cho nội dung của các ô */
}

th {
    background-color: #007bff; /* Màu xanh dương */
    color: white; /* Chữ màu trắng */
    font-size: 28px; /* Tăng cỡ chữ cho tiêu đề cột */
}

table tr:nth-child(even) {
    background-color: #f9f9f9;
}


</style>
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
                    <li class="sidebar-list-item tab-content ">
                        <a href="products.php" class="sidebar-link">
                            <div class="sidebar-icon"><i class="fa-light fa-pot-food"></i></div>
                            <div class="hidden-sidebar">Sản phẩm</div>
                        </a>
                    </li>
                    <li class="sidebar-list-item tab-content ">
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
                    <li class="sidebar-list-item tab-content action">
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
    <!-- Thống kê tổng doanh thu theo tháng -->
    <h2>Tổng doanh thu theo tháng</h2>
    <?php
    // Lấy tổng doanh thu theo tháng
    $sql = "SELECT 
                YEAR(o.orderTime) AS year, 
                MONTH(o.orderTime) AS month, 
                SUM(oi.number * b.price) AS total_revenue
            FROM orders o
            INNER JOIN orderitem oi ON o.IdOrder = oi.idOrder
            INNER JOIN book b ON oi.idBook = b.idBook
            WHERE o.orderStatus = 'Đã giao' 
            GROUP BY YEAR(o.orderTime), MONTH(o.orderTime)
            ORDER BY YEAR(o.orderTime) DESC, MONTH(o.orderTime) DESC";

    $result = mysqli_query($conn, $sql);
    echo "<table border='1' class='table'>
            <tr>
                <th>Năm</th>
                <th>Tháng</th>
                <th>Tổng doanh thu</th>
            </tr>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>
                <td>{$row['year']}</td>
                <td>{$row['month']}</td>
                <td>" . number_format($row['total_revenue'], 0, ',', '.') . " VNĐ</td>
              </tr>";
    }
    echo "</table>";
    ?>

    <!-- Thống kê số lượng sách bán ra -->
    <h2>Số lượng sách bán ra</h2>
    <?php
    // Thống kê số lượng sách bán ra
    $sql = "SELECT 
                b.title AS book_title, 
                SUM(oi.number) AS total_quantity
            FROM orderitem oi
            INNER JOIN book b ON oi.idBook = b.idBook
            INNER JOIN orders o ON oi.idOrder = o.idOrder
            WHERE o.orderStatus = 'Đã giao'
            GROUP BY b.idBook
            ORDER BY total_quantity DESC";

    $result = mysqli_query($conn, $sql);
    echo "<table border='1' class='table'>
            <tr>
                <th>Tên sách</th>
                <th>Số lượng bán ra</th>
            </tr>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>
                <td>{$row['book_title']}</td>
                <td>{$row['total_quantity']}</td>
              </tr>";
    }
    echo "</table>";
    ?>

    <!-- Thống kê tồn kho sách -->
    <h2>Thống kê tồn kho sách</h2>
    <?php
    // Thống kê tồn kho sách
    $sql = "SELECT 
                b.title AS book_title, 
                b.inStock AS current_stock
            FROM book b";

    $result = mysqli_query($conn, $sql);
    echo "<table border='1' class='table'>
            <tr>
                <th>Tên sách</th>
                <th>Tồn kho hiện tại</th>
            </tr>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>
                <td>{$row['book_title']}</td>
                <td>{$row['current_stock']}</td>
              </tr>";
    }
    echo "</table>";
    ?>

    <!-- Thống kê số đơn hàng theo trạng thái -->
    <h2>Số đơn hàng theo trạng thái</h2>
    <?php
    // Thống kê số đơn hàng theo trạng thái (Đang giao, Đã giao, Đã hủy)
    $sql = "SELECT 
                o.orderStatus, 
                COUNT(o.idOrder) AS total_orders
            FROM orders o
            GROUP BY o.orderStatus";

    $result = mysqli_query($conn, $sql);
    echo "<table border='1' class='table'>
            <tr>
                <th>Trạng thái</th>
                <th>Số đơn hàng</th>
            </tr>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>
                <td>{$row['orderStatus']}</td>
                <td>{$row['total_orders']}</td>
              </tr>";
    }
    echo "</table>";
    ?>
        </div>
</div>

</body>
</html> 