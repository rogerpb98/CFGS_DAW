<?php
//curl -X POST -d '{"numero":5}' localhost/M07/UF2/cosa/php/factorial.php
$redis = new Redis();
$redis->connect('127.0.0.1', '6379');
//$redis->auth('roger');
//echo "Server is running: ".$redis->ping();
//$redis->set(0, 1);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    
    $input = file_get_contents('php://input');
    $data = json_decode($input, true);
    $response = array();

    $numero = $data["numero"];
    $total=1;
    $start = microtime(true); //start timer
    ($redis->get(0)) ? $redis->set(0, 1) : null;
    ($redis->get(1)) ? $redis->set(1, 1) : null;
    $consulta = $redis->get($numero);
    if ($consulta) { //If its cached it grabs the value from the cache
        $total = $consulta;
    } else { //otherwise it calculates it
        for ($i=2; $i <= $numero ; $i++) { 
            $total=$total*$i;
            $redis->set($i, $total);
            sleep(2);
        }
    }

    $response["respuesta"]=$total;
    $time_elapsed_secs = microtime(true) - $start; //calculate time
    $response["retardo"]=$time_elapsed_secs;

    echo json_encode($response);
}

?>