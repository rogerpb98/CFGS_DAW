<?php
//curl -X POST -d '{"id":"1", "name":"bulbasaur", "weight":"69", "height":"7", "sprite":"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", "types":["grass","poison"]}' localhost/Hibridas/Pokemon/src/backend/pokemons/insert-pokemon.php
include_once "../config.php";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $id = $data["id"];
    //echo($id);
    $name = $data["name"];
    //echo($name);
    $types = $data["types"];
    $types = ('["'.implode('","',$types).'"]');
    //echo($types);
    $height = $data["height"];
    //echo($height);
    $weight = $data["weight"];
    //echo($weight);
    $image = $data["sprite"];
    //echo($image);
    
    /*
    $name = $_POST["name"];
    $type1 = $_POST["type1"];
    $type2 = $_POST["type2"];
    $height = $_POST["height"];
    $weight = $_POST["weight"];
    $image = $_FILES["image"];

    // ../../assets/pokemons/
    $filename = $name.".png";
    $target_dir = "/var/www/html/Hibridas/Pokemon/src/assets/pokemons/";
    $target_file = $target_dir . basename($filename);

    $response["upload"] = include_once 'upload-image.php';
    $response["image"] = $image;
    */

    $sql = $con->prepare("INSERT INTO `POKEMON` VALUES (?,?,?,?,?,?)");
    $sql->bind_param("issdds",$id,$name,$types,$height,$weight,$image);
    
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