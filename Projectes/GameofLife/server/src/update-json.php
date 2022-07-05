<?php
    // Future way to send JSON containing board to backend and store in a file
    namespace App;
    $JSONBoard = $_POST['JSONBoard'];
    updateJSON($JSONboard);
    function updateJSON($JSONboard) {
        $file = fopen(__DIR__."/Assets/tablero.json", "w");
        fwrite($file, $JSONboard);
        fclose($file);
    }
?>