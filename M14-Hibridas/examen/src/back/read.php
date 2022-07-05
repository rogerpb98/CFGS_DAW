<?php

include "config.php";

//curl -X GET localhost/Hibridas/examen/src/back/read.php
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $response = array();
    
    $sql = $con->prepare("SELECT * FROM characters_perez");
    $sql->execute();
    $sql->bind_result($id,$personaje,$casaDeHogwarts,$interpretado_por,$imagen,$favs);
    $character=0;
    while ($sql->fetch()) {
        $response[$character]["id"] = $id;
        $response[$character]["personaje"] = $personaje;
        $response[$character]["casaDeHogwarts"] = $casaDeHogwarts;
        $response[$character]["interpretado_por"] = $interpretado_por;
        $response[$character]["imagen"] = $imagen;
        $response[$character]["favs"] = $favs;
        $character++;
    }
    echo json_encode($response);
}
$con->close();

?>