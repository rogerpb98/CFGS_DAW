<?php
//curl -X GET localhost/M07/UF2/botiga/api/producto/select-by-id.php?id=1
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $id = $_GET["id"];
    $response = array();
    
    $sql = $con->prepare("SELECT * FROM PRODUCTO WHERE ID = ?");
    $sql->bind_param("i",$id);
    $sql->execute();
    $sql->bind_result($id,$nombre,$categoria,$desc,$precio,$foto1,$foto2,$foto3,$pdate,$visited,$client);
    while ($sql->fetch()) {
        $response["id"] = $id;
        $response["nombre"] = $nombre;
        $response["categoria"] = $categoria;
        $response["descripcion"] = $desc;
        $response["precio"] = $precio;
        $response["foto1"] = $foto1;
        $response["foto2"] = $foto2;
        $response["foto3"] = $foto3;
        $response["pdate"] = $pdate;
        $response["visited"] = $visited;
        $response["client"] = $client;
        $producto++;
    }
    echo json_encode($response);
}
$con->close();
?>