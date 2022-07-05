<?php
//curl -X POST -d '{"limit":"10", "offset":"0"}' 'localhost/Hibridas/Pokemon/src/backend/pokemons/read.php'
include_once "../config.php";

$input = file_get_contents('php://input');
$data = json_decode($input, true);

$limit = $data["limit"];
$offset = $data["offset"];

function fetchData($endpoint) {
    $request_url = $endpoint;
    $curl = curl_init($request_url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    $response = curl_exec($curl);
    curl_close($curl);
    $response = json_decode($response);
    return $response;
}
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    //'https://pokeapi.co/api/v2/pokemon?limit=151';//1118
    $list = fetchData("https://pokeapi.co/api/v2/pokemon?limit=$limit&offset=$offset");
    $response = array();
    foreach ($list->results as $pokemon) {
        $data = fetchData($pokemon->url);
        //id, name, weight, height, sprites->front_default, types[]->type->name
        $types = array();
        for ($i=0; $i < count($data->types); $i++) { 
            array_push($types, $data->types[$i]->type->name);
        }
        $obj = new stdClass();
        $obj->id = $data->id;
        $obj->name = $data->name;
        $obj->weight = $data->weight;
        $obj->height = $data->height;
        $obj->sprite = $data->sprites->front_default;
        $obj->types = $types;
        array_push($response, $obj);
    }
    echo json_encode($response);
}
?>