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
    //http://localhost/problemes1/2.php/?days=4
    $days=$_GET["days"];
    $months=0;
    $years=0;

    $months=$days/30;
    $days=$days%30;
    $years=$months/12;
    $months=$months%12;
    echo ($years. " years, ".$months." months, ".$days." days");
    ?>
</body>
</html>