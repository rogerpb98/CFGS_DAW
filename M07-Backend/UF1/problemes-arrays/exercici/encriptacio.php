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
    $missatgeErr = $clauErr = "";
    $missatge = $clau = "";

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (empty($_POST["missatge"])) {
            $missatgeErr = "User is required";
        } else {
            $missatge = test_input($_POST["missatge"]);
        }
        if (empty($_POST["clau"])) {
            $clauErr = "Password is required";
        } else {
            $clau = test_input($_POST["clau"]);
        }
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
        Introdueix un missatge: 
        <input type="text" id="missatge" name="missatge">
        <span class="error">* <?php echo $missatgeErr;?></span>
        <br><br>
        Clau:
        <input type="text" id="clau" name="clau" pattern="^[1-3]{8}$">
        <span class="error">* <?php echo $clauErr;?></span>
        <br><br>
        <input type="submit" value="Submit">
    </form>
    <!---------------------------------------------------->
    <?php
    $invertit = strrev($missatge);
    echo "<br>";
    echo ("String invertido: ".$invertit);
    echo "<br>";
    for ($i=0; $i < strlen($invertit)-1; $i++) { 
        if ($i%2==0 && $i!==strlen($invertit)) {
            $swap=$invertit[$i+1];
            $invertit[$i+1]=$invertit[$i];
            $invertit[$i]=$swap;
        }
    }
    echo ("String con las letras intercambiadas: ".$invertit);
    echo "<br>";
    $claus=[
        ['a','b','c','d'],
        ['e','f','g','h'],
        ['i','j','k','l'],
        ['m','n','ñ','o'],
        ['p','q','r','s'],
        ['t','u','v','w'],
        ['x','y','z','.'],
        [',',' ','?','!'],
    ];
    for ($i=0; $i < strlen($invertit); $i++) { 
        $caracter=$invertit[$i];
        for ($arrays=0; $arrays < count($claus); $arrays++) { //iteramos por los arrays de claus
            for ($item=0; $item < count($claus[$arrays]); $item++) { 
                $before=$claus[$arrays][$item];
                if (strtolower($caracter)==$before) {
                    $sumador=$clau[$arrays]; //extrae cuantos caracteres toca avanzar la letra actual
                    if (ctype_upper($invertit[$i])) { // Mantiene las mayusculas
                        $claus[$arrays][($item+$sumador)%4]=strtoupper($claus[$arrays][($item+$sumador)%4]);
                    }
                    $invertit[$i]=$claus[$arrays][($item+$sumador)%4];
                }
            }
        }
        //$invertit[$i]=$claus[$i][$clau[$i]];
    }
    // 13213121  o!ndMua olH m,ñaNvb?mjG
    echo ("String con el algoritmo de encriptacion completo: ".$invertit);
    echo "<br>";
    ?>
</body>
</html>
