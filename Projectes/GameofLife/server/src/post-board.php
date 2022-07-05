<?php
    // Future way to get the board from the backend (stored in a json) to send to client
    namespace App;
    $board = $_GET['board'];
    updateJSON($file);
    // get content from JSON file - RetrieveJSON('/Assets/PreestablishedScenarios/scenario1.json')
    function updateBoard($board) {
        return file_get_contents(__DIR__."./Assets/tablero.json", json_encode($board));
    }
?>