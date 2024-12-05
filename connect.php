<?php
    $server = 'localhost';
    $user = 'root';
    $pass = '';
    $database = 'READIFY4';
    $port = 3307;

    $conn = new mysqli($server, $user, $pass, $database, $port);

    if ($conn->connect_error) {
        die('Kết nối không thành công: ' . $conn->connect_error);
    } else {
        $conn->set_charset("utf8mb4");
    }

?>
