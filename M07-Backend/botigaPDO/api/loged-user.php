<?php 
    session_start();
    $response["user"] = $_SESSION['user'];
    
    echo json_encode($response);
?>