<?php
    header('Access-Control-Allow-Origin: *');
    header('Access-Control-Allow-Methods: POST, GET, DELETE, PUT, PATCH, OPTIONS');
    header('Access-Control-Allow-Headers: token, Content-Type');
    header('Access-Control-Max-Age: 1728000');
    header('Content-Length:0');
    header('Content-Type: text/plain');

    $host = "hl765.dinaserver.com";
    $user = "wp-db961b7704907";
    $password = "tjU2tXvo";
    $db = "wp_db961b77049075b3";

    $con = mysqli_connect($host, $user, $password, $db) or die ("could not connect to DB");

    if($con){
        //echo "ok";
    }else{
        echo "ko";
    }
?>