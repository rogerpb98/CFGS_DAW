
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
    //http://localhost/problemes1/1.php/?numero=5
    if ($_GET["numero"]%2==0) {
        echo "parell";
    }
    else {
        echo "senar";
    }
    ?>
</body>
</html>