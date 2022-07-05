<?php
//curl -X GET localhost/M07/UF2/botiga/api/producto/select-all-products.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $response = array();
    
    $sql = $con->prepare("SELECT * FROM PRODUCTO");
    $sql->execute();
    $sql->bind_result($id,$nombre,$categoria,$desc,$precio,$foto1,$foto2,$foto3,$pdate,$visited,$client);
    echo $id;
    $producto=0;
    while ($sql->fetch()) {
        $response[$producto]["id"] = $id;
        $response[$producto]["nombre"] = $nombre;
        $response[$producto]["categoria"] = $categoria;
        $response[$producto]["descripcion"] = $desc;
        $response[$producto]["precio"] = $precio;
        $response[$producto]["foto1"] = $foto1;
        $response[$producto]["foto2"] = $foto2;
        $response[$producto]["foto3"] = $foto3;
        $response[$producto]["pdate"] = $pdate;
        $response[$producto]["visited"] = $visited;
        $response[$producto]["client"] = $client;
        $producto++;
    }
    echo json_encode($response);
}
$con->close();
?>