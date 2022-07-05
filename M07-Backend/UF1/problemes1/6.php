<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    //http://localhost/problemes1/6.php/?hour=4&min=7&sec=30
    $hour=$_GET["hour"];
    $min=$_GET["min"];
    $sec=$_GET["sec"];

    if ($hour<00 || $hour>23) {
        echo("Wrong hour");
    }
    elseif ($min<00 || $min>59) {
        echo("Wrong minutes");
    }
    elseif ($sec<00 || $sec>59) {
        echo("Wrong seconds");
    }
    else {
        $sec++;
        if ($sec==60) {
            $sec=00;
            $min++;
            if ($min==60) {
                $min=00;
                $hour++;
                if ($hour==24) {
                    $hour=00;
                }
            }
        }
        echo($hour.":".$min.":".$sec);
    }
    ?>
</body>
</html>