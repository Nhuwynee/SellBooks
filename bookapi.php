<?php

include "connect.php";  // Database connection

// Check for various query parameters
$id = isset($_GET['id']) ? intval($_GET['id']) : null;
$category = isset($_GET['category']) ? $_GET['category'] : null;
$getCategories = isset($_GET['getCategories']) ? $_GET['getCategories'] : null; 

// Fetch categories
if ($getCategories) {
    $query = "SELECT DISTINCT category FROM book";
    $result = $conn->query($query);
    
    $data = array();  
    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $data[] = $row['category'];  
        }
    } else {
        echo json_encode(["message" => "No categories found"]);
        exit;
    }
    header('Content-Type: application/json; charset=UTF-8');
    echo json_encode($data);  
    $conn->close();
    exit;  
}

// Fetch book details or books by category
if ($id) {
    $query = "SELECT * FROM book WHERE idBook = $id";
} elseif ($category) {
    $query = "SELECT * FROM book WHERE category = '$category'";
} else {
    $query = "SELECT * FROM book";  
}

$result = $conn->query($query);
$data = array();  

if ($result->num_rows > 0) {
    if ($id && $result->num_rows == 1) {
        $data = $result->fetch_assoc();  // Single book by ID
    } else {
        while ($row = $result->fetch_assoc()) {
            $data[] = $row;  // Add books to the array
        }
    }
} else {
    echo json_encode(["message" => "No books found"]);
    exit;
}

header('Content-Type: application/json; charset=UTF-8');
echo json_encode($data);  

$conn->close();  
?>