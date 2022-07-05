<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .article-box {
      margin: 1px;
      padding:2px;
      border: 1px solid black;
    }
  </style>
</head>
<body>
  <?php
  if (!(isset($_COOKIE['user']) && isset($_COOKIE['password']))) {
    header("Location: login.php"); 
    exit();
  }
  if (isset($_COOKIE['articles']) && isset($_COOKIE['prices'])) {
    $articles = json_decode($_COOKIE['articles']);
    $prices = json_decode($_COOKIE['prices']);
  }
  else {
    header("Location: tenda.php"); 
    exit();
  }
  for ($i=0; $i < count($articles); $i++) { 
    echo "<div class='article-box'>";
    echo "<p>Article: ".$articles[$i]."</p>";
    echo "<p>Preu: ".$prices[$i]."€</p>";
    echo "</div>";
  }
  echo "Total: ".array_sum($prices)."€";
  echo "<form action='confirmarCompra.php' method='post'>
          <input type='submit' name='confirmarCompra' value='Confirmar Compra'/>
        </form>";

  function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
  }
  ?>
</body>
</html>