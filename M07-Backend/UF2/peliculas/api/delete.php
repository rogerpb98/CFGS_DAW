<?php
//curl -X DELETE -d '{"id":1701}' localhost/M07/UF2/peliculas/api/delete.php
include_once "config.php";
if ($_SERVER["REQUEST_METHOD"] == "DELETE") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];
    //only works if there's no dependancies
    $sql = "DELETE FROM PELICULA WHERE ID=".$id;
    if ($con->query($sql)) {
        $response["message"] = "OK";
        $response["operation"] = $sql;
    } else {
        $response["message"] = "KO";
    }
    echo json_encode($response);
}
$con->close();
?>