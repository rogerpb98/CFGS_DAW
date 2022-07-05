<?php
if (!(isset($_COOKIE['user']) && isset($_COOKIE['password']))) {
  header("Location: login.php"); 
  exit();
}
// define variables and set to empty values
$articles = $prices = array();
$article = $price = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["article"]) || empty($_POST["price"])) {
    header("Location: tenda.php"); 
    exit();
  }
  else {
    $article = test_input($_POST["article"]);
    $price = test_input($_POST["price"]);
    // if the cookie exist, we import its data into the array we gonna update it with
    if (isset($_COOKIE['articles']) && isset($_COOKIE['prices'])) {
      $articles = json_decode($_COOKIE['articles']);
      $prices = json_decode($_COOKIE['prices']);
    }
    array_push($articles, $article);
    array_push($prices, $price);
    setcookie('articles', json_encode($articles), time()+(24*60*60));
    setcookie('prices', json_encode($prices), time()+(24*60*60));
  }
}
header("Location: tenda.php"); 
exit();

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>