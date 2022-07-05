<?php
    // script to get an array with all the scenarios (names only)
    namespace App;
    $path = "./Assets/PreestablishedScenarios/";
    $files = array();
    if ($handle = opendir($path)) {
        while (false !== ($file = readdir($handle))) {
            if ('.' === $file) continue;
            if ('..' === $file) continue;

            array_push($files, $file);
        }
        closedir($handle);
    }
    sort($files);
    array_unshift($files, "Empty Board");
    array_push($files, "Random Board");
    echo json_encode($files);
?>