<?php
//El seguent curl hauria de retornar una PS4, no funciona
//curl -X GET "localhost/M07/UF2/botiga/api/producto/select-filtered.php?categoria=Cons&nombre=P&desc=P&pmin=0&pmax=1000"
//curl -X GET "localhost/M07/UF2/botiga/api/producto/select-filtered.php?categoria=_&nombre=P&desc=_&pmin=_&pmax=_"
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "GET") {
    $response = array();
    ($_GET["categoria"]=="_") ? $cat = "%" : $cat = '%'.$_GET["categoria"].'%';
    ($_GET["nombre"]=="_") ? $name = "%" : $name = '%'.$_GET["nombre"].'%';
    ($_GET["desc"]=="_") ? $descr = "%" : $descr = '%'.$_GET["desc"].'%';
    ($_GET["pmin"]=="_") ? $pmin = 0 : $pmin = $_GET["pmin"];
    ($_GET["pmax"]=="_") ? $pmax = 99999999999 : $pmax = $_GET["pmax"];

    //echo $cat, $name, $descr, $pmin, $pmax;
    $sql = $con->prepare("SELECT * FROM PRODUCTO WHERE CATEGORIA LIKE ? && NOMBRE LIKE ? && DESCRIPCION LIKE ? && PRECIO > ? && PRECIO < ?");

    $sql->bind_param("sssii",$cat, $name, $descr, $pmin, $pmax);
    
    $sql->execute();
    $sql->bind_result($id,$nombre,$categoria,$desc,$precio,$foto1,$foto2,$foto3,$pdate,$visited,$client);
    
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