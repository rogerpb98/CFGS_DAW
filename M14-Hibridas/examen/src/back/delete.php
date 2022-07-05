<?php

include "config.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];

    $sql = $con->prepare("DELETE FROM characters_perez WHERE id = ?");
    $sql->bind_param("s",$id);
    
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