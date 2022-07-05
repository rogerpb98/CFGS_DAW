<?php
//El seguent curl hauria de retornar una PS4, no funciona
//curl -X GET localhost/M07/UF2/botigaPDO/api/producto/select-filtered.php?categoria="Cons"&nombre="P"&desc=","&pmin=0&pmax=1000
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $response = array();

    ($_GET["categoria"]=="_") ? $cat = "%" : $cat = '%'.$_GET["categoria"].'%';
    ($_GET["nombre"]=="_") ? $name = "%" : $name = '%'.$_GET["nombre"].'%';
    ($_GET["desc"]=="_") ? $descr = "%" : $descr = '%'.$_GET["desc"].'%';
    ($_GET["pmin"]=="_") ? $pmin = 0 : $pmin = $_GET["pmin"];
    ($_GET["pmax"]=="_") ? $pmax = 99999999999 : $pmax = $_GET["pmax"];

    $sql = "SELECT * FROM PRODUCTO WHERE CATEGORIA LIKE ? && NOMBRE LIKE ? && DESCRIPCION LIKE ? && PRECIO > ? && PRECIO < ?";
    $statement = $con->prepare($sql);
    $statement->execute(array($cat, $name, $descr, $pmin, $pmax));
    
    $producto=0;
    while ($fila=$statement->fetch(PDO::FETCH_ASSOC)) {
        $response[$producto]["id"] = $fila["ID"];
        $response[$producto]["nombre"] = $fila["NOMBRE"];
        $response[$producto]["categoria"] = $fila["CATEGORIA"];
        $response[$producto]["descripcion"] = $fila["DESCRIPCION"];
        $response[$producto]["precio"] = $fila["PRECIO"];
        $response[$producto]["foto1"] = $fila["FOTO1"];
        $response[$producto]["foto2"] = $fila["FOTO2"];
        $response[$producto]["foto3"] = $fila["FOTO3"];
        $response[$producto]["pdate"] = $fila["PUBLICATION_DATE"];
        $response[$producto]["visited"] = $fila["VISITED"];
        $response[$producto]["client"] = $fila["CLIENT_USER"];
        $producto++;
    }
    echo json_encode($response);
}
$statement->closeCursor();
?>