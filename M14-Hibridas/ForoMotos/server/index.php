<?php
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Methods: *');
    header('Access-Control-Allow-Headers: *');
    header('Access-Control-Max-Age: 1728000');
    
    // No tocar
    include_once('app.php');
    $url = $_GET['url'];
    $url = rtrim($url, '/');
    $params = explode('/',$url);
    $body = json_decode(file_get_contents('php://input'));
    $x_api_key = "";
    if ($_SERVER['x-api-key']) {
        $x_api_key = $_SERVER['x-api-key'];
    }
    $app = new App($params, $body, $_SERVER['REQUEST_METHOD'], $x_api_key);
?>