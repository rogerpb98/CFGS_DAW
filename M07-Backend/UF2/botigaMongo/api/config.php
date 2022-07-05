<?php
    require 'vendor/autoload.php';
    
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

    $con = new MongoDB\Client("mongodb://localhost:27017");
    //$cliente = $con->botiga->client;
    //$producto = $con->botiga->producte;

    //$result = $cliente->insertOne( [ 'item' => 'producto1', 'cantidad' => '200' ] );
    //$document = $cliente->findOne(['item' => 'producto1']);
    
    
    //var_dump($document);

    //echo($con);
    /*
    try { 
        $con = new PDO("mysql:host=".$host.";dbname=".$db, $user, $password);// or die ("could not connect to DB");
        $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }
    catch (PDOException $e) {
        die ($e->getMessage());
    }
    */
?>