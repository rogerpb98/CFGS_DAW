<?php
//curl -X POST -d '{"id":1, "titol": "pelitest", "any": "1900"}' localhost/M07/UF2/peliculas/api/post.php
include_once "config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];
    $titol = $data["titol"];
    $any = $data["any"];

    $sql = "UPDATE PELICULA SET TITULO = '".$titol."', ANYO = ".$any." WHERE ID = ".$id;
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