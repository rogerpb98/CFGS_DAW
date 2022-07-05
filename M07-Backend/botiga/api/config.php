<?php
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Methods: POST, GET, DELETE, PUT, PATCH, OPTIONS');
    header('Access-Control-Allow-Headers: token, Content-Type');
    header('Access-Control-Max-Age: 1728000');
    header('Content-Length:0');
    header('Content-Type: text/plain');

    $host = "localhost";
    $user = "roger";
    $password = "roger";
    $db = "botiga";
    
    $con = new mysqli($host, $user, $password, $db) or die ("could not connect to DB");
?>