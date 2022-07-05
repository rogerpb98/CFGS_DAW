<?php
    // Future way to get the board from the backend (stored in a json) to send to client
    namespace App;
    $file = $_GET['file'];
    $board=RetrieveJSON($file);
    echo $board;
    // get content from JSON file - RetrieveJSON('/Assets/PreestablishedScenarios/scenario1.json')
    function RetrieveJSON($ruta) {
        return file_get_contents(__DIR__.$ruta);
    }
?>