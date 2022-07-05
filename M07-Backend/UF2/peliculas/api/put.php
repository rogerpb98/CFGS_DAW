<?php
//curl -X PUT -d '{"id":1701, "titol": "pelitest", "any": "1900"}' localhost/M07/UF2/peliculas/api/put.php
include_once "config.php";
if ($_SERVER["REQUEST_METHOD"] == "PUT") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];
    $titol = $data["titol"];
    $any = $data["any"];
    
    $sql = "INSERT INTO PELICULA (ID, TITULO, ANYO) VALUES(".$id.", '".$titol."', ".$any.")";
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