<?php
$dir_subida = 'uploads/';
$fichero_subido = $dir_subida . basename($_FILES['myFile']['name']);
if (move_uploaded_file($_FILES['myFile']['tmp_name'], $fichero_subido)) {   
    echo "El fichero es válido y se subió con éxito. <br>";
} 
else {    
    echo "¡Error! <br>";
}
echo 'Más información de depuración: <br>';
print_r($_FILES);
?>