async function enviarAlBack() {
  let texto = document.getElementById("text").value;
  console.log(texto);
  let data = {
    "numero": parseInt(texto)
  };
  console.log(data.numero);
  try {
    const response = await fetch("./php/factorial.php", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    const datos = await response.json();
    console.log(datos);
    document.getElementById("result").innerHTML=datos.respuesta;
  } catch (error) {
      console.log(error);
  }
}