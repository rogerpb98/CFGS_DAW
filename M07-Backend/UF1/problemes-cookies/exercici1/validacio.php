<?php
// define variables and set to empty values
$user = $passwd = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $user = test_input($_POST["user"]);
  $pwd = test_input($_POST["pwd"]);
  if ($user==$pwd) {
    setcookie('user', $user, time()+(24*60*60));
    setcookie('password', $pwd, time()+(24*60*60));
  }
  header("Location: informacio1.php"); 
  exit();
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>