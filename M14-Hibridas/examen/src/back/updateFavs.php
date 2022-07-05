<?php
//curl -X POST -d '{ "favs":5, "id":6 }' localhost/Hibridas/examen/src/back/updateFavs.php
include "config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();


    $favs = $data["favs"];
    $id = $data["id"];

    
    $sql = $con->prepare("UPDATE characters_perez SET favs=? WHERE id=?");
    $sql->bind_param("ii",$favs,$id);
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