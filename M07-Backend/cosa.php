<?php
include_once 'App.php';
$url = $_GET["url"];
$url = rtrim($url, "/");
$params = explode('/', $url);

$app = new App($params);
?>