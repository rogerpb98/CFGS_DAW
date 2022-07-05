let precio="default";
let fecha="default";
let listaProductos;
function mostrarProductos(datos) {
  let productos = '';
  datos.forEach(producto => {
    productos += "<a href='detalle.php?id="+producto.id+"'><h2>"+producto.nombre+"</h2><p>"+producto.descripcion+"</p><img src='"+producto.foto1+"' alt='foto1' /><p>Precio: "+producto.precio+"€</p><p>"+producto.pdate+"</p></a>";
  });

  document.getElementById("articles").innerHTML = productos;
}
function ordenarPrecio() {
  listaProductos.sort((a, b) => {
    return a.precio - b.precio;
  });
  if (precio==="default") {
    precio="altered";
  }else {
    precio="default";
    listaProductos = listaProductos.reverse();
  }
  mostrarProductos(listaProductos);
}
function ordenarFecha() {
  listaProductos.sort((a, b) => {
    return new Date(b.pdate) - new Date(a.pdate);
  });
  if (fecha==="default") {
    fecha="altered";
  }else {
    fecha="default";
    listaProductos = listaProductos.reverse();
  }
  mostrarProductos(listaProductos);
}
function clearInputs() {
    let elements = document.getElementsByTagName("input");
    for (let i=0; i < elements.length; i++) {
        if (elements[i].type == "text") {
            elements[i].value = "";
        }
    }
}
async function registerUser() {
    let user = document.getElementById("user").value;
    let pwd = document.getElementById("pwd").value;
    let nombre = document.getElementById("nombre").value;
    let apellido = document.getElementById("apellido").value;
    if (document.getElementById("user").value=="" || document.getElementById("pwd").value=="" || document.getElementById("nombre").value=="") {
        console.log("ERROR");
    }
    else {
        if (document.getElementById("apellido").value!="") {
            //con apellido
            data = {
                "user": user,
                "pwd": sha1(user+pwd),
                "nombre": nombre,
                "apellido": apellido
            };
        } else {
            //sin apellido
            data = {
                "user": user,
                "pwd": sha1(user+pwd),
                "nombre": nombre
            };
        }
        clearInputs();
        try {
            const response = await fetch("../api/cliente/insert-user.php", {
                method: "PUT",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });
            console.log(response);
        } catch (error) {
            console.log(error);
        } finally {
            location.reload();
        }
    }
}
async function loginUser() {
    let user = document.getElementById("user").value;
    let pwd = document.getElementById("pwd").value;
    data = {
        "user": user,
        "pwd": sha1(user+pwd)
    };
    clearInputs();
    try {
        const response = await fetch("../api/cliente/login.php", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        console.log(response);
    } catch (error) {
        console.log(error);
    } finally {
        location.reload();
    }
}
async function addProduct() {
  let nombre = document.getElementById("nombre").value;
  let categoria = document.getElementById("categoria").value;
  let descripcion = document.getElementById("descripcion").value;
  let precio = document.getElementById("precio").value;
  let imagen1 = document.getElementById("imagen1").value;
  let imagen2 = document.getElementById("imagen2").value;
  let imagen3 = document.getElementById("imagen3").value;
  let fotos = [];
  let user = document.getElementById("username").innerHTML;
  (imagen1!="") ? fotos.push(imagen1) : console.log();
  (imagen2!="") ? fotos.push(imagen2) : console.log();
  (imagen3!="") ? fotos.push(imagen3) : console.log();
  data = {
    "user": user,
    "nombre": nombre,
    "categoria": categoria,
    "desc": descripcion,
    "precio": precio,
    "fotos": fotos
  };
  console.log(data);
  
  clearInputs();
  
  try {
    const response = await fetch("../api/producto/insert-product.php", {
      method: "PUT",
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });
    const datos = await response.json();
    console.log(datos);
  } catch (error) {
      console.log(error);
  } finally {
      location.reload();
  }
  
}
async function showAllProducts() {
  try {
    const response = await fetch("../api/producto/select-all-products.php", {
      method: "GET",
      headers: {
          'Content-Type': 'application/json'
      }
    });
    //console.log(response);
    const datos = await response.json();
    listaProductos = datos;
    console.log(datos);
    mostrarProductos(datos)
  } catch (error) {
      console.log(error);
  } /*finally {
      location.reload();
  }*/
}
async function filtrar() {
  try {
    let cat = (document.getElementById("categoria").value==="") ? "_" : document.getElementById("categoria").value;
    let name = (document.getElementById("name").value==="") ? "_" : document.getElementById("name").value;
    let desc = (document.getElementById("descripcion").value==="") ? "_" : document.getElementById("descripcion").value;
    let minPrice = (document.getElementById("minprice").value==="") ? "_" : document.getElementById("minprice").value;
    let maxPrice = (document.getElementById("maxprice").value==="") ? "_" : document.getElementById("maxprice").value;
    console.log(cat, name, desc, minPrice, maxPrice)
    const response = await fetch('../api/producto/select-filtered.php?categoria='+cat+'&nombre='+name+'&desc='+desc+'&pmin='+minPrice+'&pmax='+maxPrice, {
      method: "GET",
      headers: {
          'Content-Type': 'application/json'
      }
    });
    //console.log(response);
    const datos = await response.json();
    listaProductos = datos;
    console.log(datos);
    mostrarProductos(datos)
  } catch (error) {
      console.log(error);
  } /*finally {
      location.reload();
  }*/
}
async function showDetalle(id) {
  try {
      const response = await fetch("../api/producto/select-by-id.php?id="+id+"", {
          method: "GET",
          headers: {
              'Content-Type': 'application/json'
          }
      });
      console.log(id);
      //console.log(response);
      const datos = await response.json();
      console.log(datos);
      let producto = '';
      producto += "<h2>"+datos.nombre+"</h2><p>"+datos.descripcion+"</p><p>Precio: "+datos.precio+"€</p><p>Vendedor: "+datos.client+"</p>";
      (datos.foto1) ? producto+="<img src='"+datos.foto1+"' alt='foto1' />" : console.log("no hay foto1");
      (datos.foto2) ? producto+="<img src='"+datos.foto2+"' alt='foto2' />" : console.log("no hay foto2");
      (datos.foto3) ? producto+="<img src='"+datos.foto3+"' alt='foto3' />" : console.log("no hay foto3");

      document.getElementById("article").innerHTML = producto;
      
  } catch (error) {
      console.log(error);
  } /*finally {
      location.reload();
  }*/
}



//sha1 encryption algorithm
function sha1 (str) {
    //  discuss at: https://locutus.io/php/sha1/
    // original by: Webtoolkit.info (https://www.webtoolkit.info/)
    // improved by: Michael White (https://getsprink.com)
    // improved by: Kevin van Zonneveld (https://kvz.io)
    //    input by: Brett Zamir (https://brett-zamir.me)
    //      note 1: Keep in mind that in accordance with PHP, the whole string is buffered and then
    //      note 1: hashed. If available, we'd recommend using Node's native crypto modules directly
    //      note 1: in a steaming fashion for faster and more efficient hashing
    //   example 1: sha1('Kevin van Zonneveld')
    //   returns 1: '54916d2e62f65b3afa6e192e6a601cdbe5cb5897'
    let hash
    try {
      const crypto = require('crypto')
      const sha1sum = crypto.createHash('sha1')
      sha1sum.update(str)
      hash = sha1sum.digest('hex')
    } catch (e) {
      hash = undefined
    }
    if (hash !== undefined) {
      return hash
    }
    const _rotLeft = function (n, s) {
      const t4 = (n << s) | (n >>> (32 - s))
      return t4
    }
    const _cvtHex = function (val) {
      let str = ''
      let i
      let v
      for (i = 7; i >= 0; i--) {
        v = (val >>> (i * 4)) & 0x0f
        str += v.toString(16)
      }
      return str
    }
    let blockstart
    let i, j
    const W = new Array(80)
    let H0 = 0x67452301
    let H1 = 0xEFCDAB89
    let H2 = 0x98BADCFE
    let H3 = 0x10325476
    let H4 = 0xC3D2E1F0
    let A, B, C, D, E
    let temp
    // utf8_encode
    str = unescape(encodeURIComponent(str))
    const strLen = str.length
    const wordArray = []
    for (i = 0; i < strLen - 3; i += 4) {
      j = str.charCodeAt(i) << 24 |
        str.charCodeAt(i + 1) << 16 |
        str.charCodeAt(i + 2) << 8 |
        str.charCodeAt(i + 3)
      wordArray.push(j)
    }
    switch (strLen % 4) {
      case 0:
        i = 0x080000000
        break
      case 1:
        i = str.charCodeAt(strLen - 1) << 24 | 0x0800000
        break
      case 2:
        i = str.charCodeAt(strLen - 2) << 24 | str.charCodeAt(strLen - 1) << 16 | 0x08000
        break
      case 3:
        i = str.charCodeAt(strLen - 3) << 24 |
          str.charCodeAt(strLen - 2) << 16 |
          str.charCodeAt(strLen - 1) <<
        8 | 0x80
        break
    }
    wordArray.push(i)
    while ((wordArray.length % 16) !== 14) {
      wordArray.push(0)
    }
    wordArray.push(strLen >>> 29)
    wordArray.push((strLen << 3) & 0x0ffffffff)
    for (blockstart = 0; blockstart < wordArray.length; blockstart += 16) {
      for (i = 0; i < 16; i++) {
        W[i] = wordArray[blockstart + i]
      }
      for (i = 16; i <= 79; i++) {
        W[i] = _rotLeft(W[i - 3] ^ W[i - 8] ^ W[i - 14] ^ W[i - 16], 1)
      }
      A = H0
      B = H1
      C = H2
      D = H3
      E = H4
      for (i = 0; i <= 19; i++) {
        temp = (_rotLeft(A, 5) + ((B & C) | (~B & D)) + E + W[i] + 0x5A827999) & 0x0ffffffff
        E = D
        D = C
        C = _rotLeft(B, 30)
        B = A
        A = temp
      }
      for (i = 20; i <= 39; i++) {
        temp = (_rotLeft(A, 5) + (B ^ C ^ D) + E + W[i] + 0x6ED9EBA1) & 0x0ffffffff
        E = D
        D = C
        C = _rotLeft(B, 30)
        B = A
        A = temp
      }
      for (i = 40; i <= 59; i++) {
        temp = (_rotLeft(A, 5) + ((B & C) | (B & D) | (C & D)) + E + W[i] + 0x8F1BBCDC) & 0x0ffffffff
        E = D
        D = C
        C = _rotLeft(B, 30)
        B = A
        A = temp
      }
      for (i = 60; i <= 79; i++) {
        temp = (_rotLeft(A, 5) + (B ^ C ^ D) + E + W[i] + 0xCA62C1D6) & 0x0ffffffff
        E = D
        D = C
        C = _rotLeft(B, 30)
        B = A
        A = temp
      }
      H0 = (H0 + A) & 0x0ffffffff
      H1 = (H1 + B) & 0x0ffffffff
      H2 = (H2 + C) & 0x0ffffffff
      H3 = (H3 + D) & 0x0ffffffff
      H4 = (H4 + E) & 0x0ffffffff
    }
    temp = _cvtHex(H0) + _cvtHex(H1) + _cvtHex(H2) + _cvtHex(H3) + _cvtHex(H4)
    return temp.toLowerCase()
}