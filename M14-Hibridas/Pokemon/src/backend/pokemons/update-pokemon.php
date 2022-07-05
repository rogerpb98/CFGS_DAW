<?php
//[outdated]curl -X PUT -d '{"name":"Turtwig", "type": ["planta", "agua"], "height": "145", "weight": "165", image: "images/turtwig.png"}' localhost/Hibridas/Pokemon/src/backend/pokemons/insert-pokemon.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    //$input = file_get_contents('php://input');
    //$data = json_decode($input, true);
    $response = array();

    $name = $_POST["name"];
    $type1 = $_POST["type1"];
    $type2 = $_POST["type2"];
    $height = $_POST["height"];
    $weight = $_POST["weight"];
    $image = $_FILES["image"];

    $filename = $name.".png";
    $target_dir = "/var/www/html/Hibridas/Pokemon/src/assets/pokemons/";
    $target_file = $target_dir . basename($filename);
    unlink($target_file);

    $response["upload"] = include_once 'upload-image.php';
    $response["image"] = $image;

    $sql = $con->prepare("UPDATE POKEMON SET TYPE1=?, TYPE2=?, HEIGHT=?, WEIGHT=?, IMAGE=? WHERE NAME=?");
    $sql->bind_param("ssddss",$type1,$type2,$height,$weight,$filename,$name);
    $sql->execute();
    if (!($sql->affected_rows===0)) {
        $response["message"] = "OK";
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$con->close();
?>