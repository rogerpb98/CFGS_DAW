<?php
//curl -X POST -d '{"name":"Roger", "interpret": "Rogelio Perez", "casa": "Gryffindor"}' localhost/Hibridas/examen/src/back/insert.php
include "config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {

    $response = array();

    $name = $_POST["name"];
    $interpret = $_POST["interpret"];
    $casa = $_POST["casa"];
    $img = "";
    $favs = 0;

    $sql = $con->prepare("INSERT INTO characters_perez (personaje, casaDeHogwarts, interpretado_por, imagen, favs) VALUES (?,?,?,?,?)");
    $sql->bind_param("ssssi",$name,$casa,$interpret,$img,$favs);

    $sql->execute();
    if (!($sql->affected_rows===0)) {
        $response["message"] = "OK";
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
    
}

?>