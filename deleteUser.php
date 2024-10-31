<?php
    include "connect.php";
    $this_id = $_GET['this_id'];
    echo $this_id;
    $sql = "Delete from Users where IdUser = $this_id";
    mysqli_query($conn,$sql);
    header('location: users.php');
?>