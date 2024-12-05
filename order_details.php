
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
        /* General Styles */
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

.order-container {
    background: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    width: 90%;
    max-width: 800px;
}
/* Sidebar cố định */
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

/* Nội dung chính */
.order-container {
    margin-left: 260px; /* Đẩy nội dung sang phải, ngang với chiều rộng sidebar */
    padding: 30px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    max-width: 1200px;
}


h1, h2 {
    color: #333;
    margin-bottom: 15px;
}

p {
    margin: 5px 0;
    color: #555;
}

/* Table Styles */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
}

table th, table td {
    text-align: left;
    padding: 10px;
    border: 1px solid #ddd;
}

table th {
    background-color: #f8f8f8;
    color: #333;
}

table tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

tfoot .total-label {
    text-align: right;
    font-weight: bold;
    padding-right: 10px;
}

tfoot .total-price {
    font-weight: bold;
    color: #d9534f;
}

/* Buttons */
.order-actions {
    margin-top: 20px;
    display: flex;
    justify-content: space-between;
}

.btn {
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

.btn-back {
    background-color: #007bff;
    color: #fff;
}

.btn-print {
    background-color: #28a745;
    color: #fff;
}

.btn:hover {
    opacity: 0.9;
}
.order-status {
    margin: 20px 0; /* Khoảng cách với các phần khác */
    display: flex;
    align-items: center;
    gap: 10px;
}

.order-status label {
    font-weight: bold;
    margin-right: 10px;
}

.order-status select {
    width: 200px;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}

    </style>
</head>

<body>

    <div class="order-container">
    <h1>Chi tiết đơn hàng</h1>
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
<div class="section product-all">
<div class="customer-info">
<?php
    include "connect.php";
    
    // Lấy id đơn hàng từ URL
    $this_id = $_GET['idOrder'];
    
    // Kiểm tra nếu form được gửi đi
    if (isset($_POST['update-status'])) {
        // Lấy trạng thái mới từ form
        $newStatus = $_POST['orderStatus'];

        // Cập nhật trạng thái đơn hàng trong cơ sở dữ liệu
        $sql = "UPDATE orders SET orderStatus = '$newStatus' WHERE IdOrder = '$this_id'";
        $result = mysqli_query($conn, $sql);

        if ($result) {
            echo "<script>alert('Cập nhật trạng thái đơn hàng thành công!');</script>";
        } else {
            echo "<script>alert('Cập nhật trạng thái đơn hàng thất bại.');</script>";
        }
       
    }

    // Lấy thông tin khách hàng và đơn hàng
    $sql = "SELECT orderitem.*, book.*, users.*, orders.* FROM orderitem 
            INNER JOIN book on book.idBook = orderitem.idBook
            INNER JOIN orders on orders.IdOrder = orderitem.idOrder
            INNER JOIN users on users.IdUser = orders.IdUser
            WHERE orderitem.idOrder = '$this_id' LIMIT 1";
    $result = mysqli_query($conn, $sql);
    while ($row = mysqli_fetch_array($result)) {
        $status = $row['orderStatus'];
?>
    <!-- Hiển thị thông tin khách hàng và chi tiết đơn hàng -->
    <h2>Thông tin khách hàng</h2>
    <p><strong>Họ và tên:</strong> <?php echo $row['name']; ?></p>
    <p><strong>Số điện thoại:</strong> <?php echo $row['phone']; ?></p>
    <p><strong>Địa chỉ:</strong> <?php echo $row['address']; ?></p>

    <div class="order-status">
    <form method="POST" action="">
        <label for="order-status">Trạng thái đơn hàng:</label>
        <select id="order-status" name="orderStatus" class="form-control">
            <option value="Đang giao" <?php echo isset($row['orderStatus']) && $row['orderStatus'] == 'Đang giao' ? 'selected' : ''; ?>>Đang giao</option>
            <option value="Đã giao" <?php echo isset($row['orderStatus']) && $row['orderStatus'] == 'Đã giao' ? 'selected' : ''; ?>>Đã giao</option>
            <option value="Đã huỷ" <?php echo isset($row['orderStatus']) && $row['orderStatus'] == 'Đã huỷ' ? 'selected' : ''; ?>>Đã huỷ</option>
        </select>
        <button type="submit" name="update-status" class="btn btn-print">Cập nhật</button>
    </form>
</div>
<?php } ?>

        
        <!-- Order Details -->
        <div class="order-details">
            <h2>Chi tiết sản phẩm</h2>
            <table>
                <thead>
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Hình ảnh</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Thành tiền</th>
                    </tr>
                </thead>
                <tbody>
                <?php
                            include "connect.php";
                             $this_id = $_GET['idOrder'];
                                $sql = "SELECT orderitem.*, book.*, users.*, orders.* FROM orderitem 
                                INNER JOIN book on book.idBook = orderitem.idBook
                                INNER JOIN orders on orders.IdOrder = orderitem.idOrder
                                INNER JOIN users on users.IdUser = orders.IdUser
                                where orderitem.idOrder = '$this_id'";
                            $result =mysqli_query($conn,$sql);
                            $point = 0;
                            $total = 0;
                            while($row = mysqli_fetch_array($result)){
                                $itemTotal = $row['number'] * $row['price']; // Tính thành tiền cho mỗi món
                                $total += $itemTotal;
                                $point = $row['pointOfOrder'];
                            ?>
                            
                            <tr>
                                <td><?php echo $row['title'] ?></td>
                                <td><img width= "50" height = "50" src="img/books/<?php echo $row['imgResource'] ?>" alt=""></td>
                                <td><?php echo $row['number'] ?></td>
                                <td><?php echo number_format($row['price'], 0, ',', '.') . ' VND' ?></td>
                                <td><?php echo number_format($row['number'] * $row['price'], 0, ',', '.') . ' VND' ?></td>
                            </tr>
                        <?php  } ?>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4" class="total-label">Tổng tiền:</td>
                        <td class="total-price"><?php echo number_format($total, 0, ',', '.') . ' VND'; ?></td>
                        </tr>
                    <tr>
                    <tr>
                        <td colspan="4" class="total-label">Điểm:</td>
                        <td class="total-price"><?php echo $point ?></td>
                        </tr>
                    <tr>
                        <td colspan="4" class="total-label">Thành tiền:</td>
                        <td class="total-price"><?php echo number_format($total -  $point, 0, ',', '.') . ' VND'; ?></td>  
                  </tr>
                </tfoot>
            </table>
        </div>

        <!-- Order Actions -->
        <div class="order-actions">
        <a href="orders.php" class="btn btn-back">Quay lại</a>
        </div>
    </div> 
              
    </div>
</body>
</html>