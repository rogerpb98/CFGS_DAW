<?php
//curl -X GET localhost/Hibridas/Pokemon/src/backend/pokemons/select-pokemon-by-id.php?name=Test1
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $name = $_GET["name"];
    $response = array();

    $sql = $con->prepare("SELECT * FROM POKEMON WHERE NAME = ?");
    $sql->bind_param("s",$name);
    $sql->execute();
    $sql->bind_result($name,$type1,$type2,$height,$width,$image);
    
    if ($sql->fetch()) {
        $response["name"] = $name;
        $response["type"] = [$type1, $type2];
        $response["height"] = $height;
        $response["weight"] = $width;
        $response["image"] = $image;
        $response["respuesta"]="OK";
    }else {
        $response["respuesta"]="KO";
    }

    echo json_encode($response);
}
$con->close();
?>