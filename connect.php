<?php
    $server = 'localhost';
    $user ='root';
    $pass = '';
    $database = 'READIFY3';
    $port = 3307;

    $conn = new mysqli($server,$user,$pass,$database,$port);

    if($conn){
        mysqli_query($conn, "SET NAMES 'utf8'");
    }
    else
    echo 'Kết nối không thành công';
?>