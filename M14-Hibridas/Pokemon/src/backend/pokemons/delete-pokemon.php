<?php
//curl -X POST -d '{"name":"Turtwig"}' localhost/Hibridas/Pokemon/src/backend/pokemons/delete-pokemon.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $name = $data["name"];

    $filename = $name.".png";
    $target_dir = "/var/www/html/Hibridas/Pokemon/src/assets/pokemons/";
    $target_file = $target_dir . basename($filename);
    unlink($target_file);

    $sql = $con->prepare("DELETE FROM POKEMON WHERE NAME = ?");
    $sql->bind_param("s",$name);
    
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