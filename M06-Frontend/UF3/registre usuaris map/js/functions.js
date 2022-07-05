window.onload = function () {
    generateMap()

    document.querySelector("button[type=submit]").addEventListener("click", validateForm);

    document.getElementById("nom").addEventListener("blur",validateNom);
    document.getElementById("cognoms").addEventListener("blur",validateCognom);
    document.getElementById("dni").addEventListener("blur",validateDNI);
    document.getElementById("email").addEventListener("blur",validateEmail);
    document.getElementById("telefon").addEventListener("blur",validateTelefon);

    document.getElementById("btnUsername").addEventListener("click",generateUsername);
}

function validateForm(e){
    if (!validateNom() || !validateCognom() || !validateDNI() 
        || !validateEmail() || !validateTelefon()){
        e.preventDefault();
    }
}

function validateNom(){
    var nomInput = document.getElementById("nom");
    return validateInput(nomInput,"El nom no pot estar buit");
}

function validateCognom(){
    var cognomsInput = document.getElementById("cognoms");
    return validateInput(cognomsInput,"Els cognoms no poden estar buits");
}

function validateDNI(){
    let dniInput = document.getElementById("dni");
    return validateInput(dniInput,"El format del DNI no es valid",isValidDNI)
}

function validateEmail(){
    let emailInput = document.getElementById("email");
    return validateInput(emailInput,"El format del email no es valid",isValidEmail)
}

function validateTelefon(){
    let phoneInput = document.getElementById("telefon");
    return validateInput(phoneInput,"El format del telefon no es valid",isValidPhone)
}

function generateUsername(){
  
    let nom = document.getElementById("nom").value;
    let cognoms = document.getElementById("cognoms").value.replace(" ","").toLowerCase();
    let dni = document.getElementById("dni").value;
  
    let username = nom.substr(0,1).toLowerCase() + 
                   cognoms[0].toUpperCase() + cognoms.substr(1,3) +
                   dni[0] + dni[2] + dni[4] + dni[6];
    
    document.getElementById("username").value=username;
  }

// COMMON FUNCTIONS

function validateInput(input,err_message,isInputValid){

    let is_input_valid = arguments.length > 2 ? isInputValid(input.value) : true;

    if (input.value && is_input_valid){
        setSuccess(input);
        return true;
    } 
    setError(input,err_message);
    return false;
}

function setSuccess(input){
	input.className = "form-control is-valid";
}

function setError(input, message){

    input.className = "form-control is-invalid";
    input.nextElementSibling.innerHTML = message;
}

function isValidDNI(dni){

    const re = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKET]{1}$/g;

    if (!re.test(dni)) return false;

    // Check last letter
    let lastLetter = dni.substr(dni.length-1, dni.lenght);
    let index = parseInt(dni.substr(0, 8)) % 23;

    const dniLetters = 'TRWAGMYFPDXBNJZSQVHLCKET';
    if (dniLetters.charAt(index) == lastLetter) return true;

    return false;
}

function isValidEmail(email){

    const re = /^\w+(\.\w+)*@\w+(\.\w+){1,2}$/g;
    return re.test(email);
}

function isValidPhone(phone){

    const re = /^[^0]\d{8}$/g;
    return re.test(phone);
}

function generateMap() {
    var map = L.map('map').setView([41.3879, 2.16992], 13);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 15,
        minZoom: 15,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1Ijoicm9nZXJwYjk4IiwiYSI6ImNreTh6Y3VqODAxZGwydXA0dDA5emM1MngifQ.mzj9oEzGlCAcKTS5vKJi0w'
    }).addTo(map);
    /*prevenir arrastre fuera de limites*/
    let southWest = L.latLng(-89.98155760646617, -180)
    let northEast = L.latLng(89.99346179538875, 180);
    let bounds = L.latLngBounds(southWest, northEast);

    map.setMaxBounds(bounds);
    map.on('drag', function() {
        map.panInsideBounds(bounds, { animate: false });
    });
}