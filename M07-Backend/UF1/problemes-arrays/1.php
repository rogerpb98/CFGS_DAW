<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .error {color: #FF0000;}
    </style>
</head>
<body>
    <?php
    // define variables and set to empty values
    $firstErr = $secondErr = $thirdErr = $fourthErr = $fifthErr = $sixthErr = $seventhErr = $eighthErr = "";
    $first = $second = $third = $fourth = $fifth = $sixth = $seventh = $eighth = "";
    $supera=false;
    $notes = array();

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (empty($_POST["first"])) {
            $firstErr = "Introduce una nota";
        } else {
            $first = (int) test_input($_POST["first"]);
            echo gettype($first);
            if ($first<0 || $first >10) {
                $firstErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $first);
        }
        if (empty($_POST["second"])) {
            $secondErr = "Introduce una nota";
        } else {
            $second = test_input($_POST["second"]);
            if ($second<0 || $second >10) {
                $secondErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $second);
        }
        if (empty($_POST["third"])) {
            $thirdErr = "Introduce una nota";
        } else {
            $third = test_input($_POST["third"]);
            if ($third<0 || $third >10) {
                $thirdErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $third);
        }
        if (empty($_POST["fourth"])) {
            $fourthErr = "Introduce una nota";
        } else {
            $fourth = test_input($_POST["fourth"]);
            if ($fourth<0 || $fourth >10) {
                $fourthErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $fourth);
        }
        if (empty($_POST["fifth"])) {
            $fifthErr = "Introduce una nota";
        } else {
            $fifth = test_input($_POST["fifth"]);
            if ($fifth<0 || $fifth >10) {
                $fifthErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $fifth);
        }
        if (empty($_POST["sixth"])) {
            $sixthErr = "Introduce una nota";
        } else {
            $sixth = test_input($_POST["sixth"]);
            if ($sixth<0 || $sixth >10) {
                $sixthErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $sixth);
        }
        if (empty($_POST["seventh"])) {
            $seventhErr = "Introduce una nota";
        } else {
            $seventh = test_input($_POST["seventh"]);
            if ($seventh<0 || $seventh >10) {
                $seventhErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $seventh);
        }
        if (empty($_POST["eighth"])) {
            $eighthErr = "Introduce una nota";
        } else {
            $eighth = test_input($_POST["eighth"]);
            if ($eighth<0 || $eighth >10) {
                $eighthErr = "La nota debe estar entre 0 y 10";
            }
            else array_push($notes, $eighth);
        }
    }
    $media = array_sum($notes)/count($notes);
    if ($media>=5) {
        $supera=true;
    }

    function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
    }
    ?>
    <!---------------------------------------------------->
    <p><span class="error">* required field</span></p>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        Nota 1:
        <input type="text" id="first" name="first">
        <span class="error">* <?php echo $firstErr;?></span>
        <br><br>
        Nota 2:
        <input type="text" id="second" name="second">
        <span class="error">* <?php echo $secondErr;?></span>
        <br><br>
        Nota 3:
        <input type="text" id="third" name="third">
        <span class="error">* <?php echo $thirdErr;?></span>
        <br><br>
        Nota 4:
        <input type="text" id="fourth" name="fourth">
        <span class="error">* <?php echo $fourthErr;?></span>
        <br><br>
        Nota 5:
        <input type="text" id="fifth" name="fifth">
        <span class="error">* <?php echo $fifthErr;?></span>
        <br><br>
        Nota 6:
        <input type="text" id="sixth" name="sixth">
        <span class="error">* <?php echo $sixthErr;?></span>
        <br><br>
        Nota 7:
        <input type="text" id="seventh" name="seventh">
        <span class="error">* <?php echo $seventhErr;?></span>
        <br><br>
        Nota 8:
        <input type="text" id="eighth" name="eighth">
        <span class="error">* <?php echo $eighthErr;?></span>
        <br><br>
        <input type="submit" value="Submit">
    </form>
    <!---------------------------------------------------->
    <?php
    echo "<h2>Informe:</h2>";
    echo ($supera)?"supera el modul":"no supera el modul";
    echo "<br>";
    echo "nota 1: ".$notes[0];
    echo "<br>";
    echo "nota 2: ".$notes[1];
    echo "<br>";
    echo "nota 3: ".$notes[2];
    echo "<br>";
    echo "nota 4: ".$notes[3];
    echo "<br>";
    echo "nota 5: ".$notes[4];
    echo "<br>";
    echo "nota 6: ".$notes[5];
    echo "<br>";
    echo "nota 7: ".$notes[6];
    echo "<br>";
    echo "nota 8: ".$notes[7];
    echo "<br>";
    echo "nota final (media): ".$media;
    echo "<br>";
    echo "nota màxima: ".max($notes);
    echo "<br>";
    echo "nota mínima: ".min($notes);
    echo "<br>";
    ?>
</body>
</html>
