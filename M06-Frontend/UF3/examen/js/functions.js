let data = [{
        "ciutat": "Barcelona",
        "districtes": [
            {"districte": "Ciutat Vella","barris": ["El Gòtic", "La Barceloneta", "La Ribera"]},
            {"districte": "Eixample","barris": ["Fort Pienc", "Sagrada Família", "Sant Antoni", "Dreta de l'Eixample"]},
            {"districte": "Sant Marti","barris": ["El Camp de l'Arpa", "El Clot", "Poblenou", "La Verneda"]}
        ]
    },
    {
        "ciutat": "Tarragona",
        "districtes": [
            {"districte": "Centre Ciutat","barris": ["La Part Alta", "Verge del Carme", "Barris Maritims"]},
            {"districte": "Ponent","barris": ["Torreforta", "Bonavista", "La Canonja"]},
            {"districte": "Llevant","barris": ["El Miracle", "Els Músics", "Cala Romana", "La Mora"]}
        ]
    }
];

window.addEventListener("load", main);

function validarNom(string) {
    if (string===null || string.match(/^ *$/)) {
        return false;
    }
    return true;
}

function populateCities() {
    let arrCiutats='';
    data.forEach(element => {
        arrCiutats+=`<option value="${element.ciutat}">${element.ciutat}</option>`;
    });
    ciutat.innerHTML=arrCiutats;
    populateDistricts()
    check();
}

function populateDistricts() {
    let arrDistricts='';
    data.forEach(element => {
        if (ciutat.value==element.ciutat) {
            element.districtes.forEach(dist => {
                arrDistricts+=`<option value="${dist.districte}">${dist.districte}</option>`;
            });
        }
    });
    districte.innerHTML=arrDistricts;
    populateBarris()
}
data.forEach((item, i) => {

});

function populateBarris() {
    let arrBarris='';
    data.forEach(element => {
        if (ciutat.value==element.ciutat) {
            element.districtes.forEach(dist => {
                if (districte.value==dist.districte) {
                    dist.barris.forEach(brri => {
                        arrBarris+=`<option value="${brri}">${brri}</option>`;
                    });
                }
            });
        }
    });
    barri.innerHTML=arrBarris;
}

function check() {
    if (!!ciutat.value && !!via.value && !!nomCarrer.value && !!Number.isInteger(parseInt(numCarrer.value))) {
        return true;
    } else {
        return false;
    }
}

function main() {
    loadMap();

    document.querySelector("button[type=submit]").addEventListener("click", validateForm);
    
    let nom = document.getElementById('nom')
    let preu = document.getElementById('preu')
    let ciutat = document.getElementById('ciutat')
    let districte = document.getElementById('districte')
    let barri = document.getElementById('barri')
    let via = document.getElementById('via')
    let nomCarrer = document.getElementById('nomCarrer')
    let numCarrer = document.getElementById('numCarrer')
    let pis = document.getElementById('pis')
    let escala = document.getElementById('escala')
    let porta = document.getElementById('porta')
    let cp = document.getElementById('cp')
    let lat = document.getElementById('lat')
    let lng = document.getElementById('lng')
    
    
    nom.addEventListener("focusout", (event) => {
        if (validarNom(nom.value)) {
            null;
        } else {
            alert('El camp "Nom" no pot estar buit.')
        }
    });
    preu.addEventListener("focusout", (event) => {
        preuInput=preu.value
        console.log(preuInput)
        if (preuInput.trim()=='' || isNaN(preuInput)) {
            alert('El camp "Preu" ha de ser numeric i no pot estar buit.')
        } else if (preuInput>1000000 || preuInput<20000) {
            alert(`El camp "Preu" ha d'estar entre 20.000 i 1.000.000`)
        }
    });
    populateCities();
    ciutat.addEventListener("change", (event) => {
        populateDistricts();
    });
    districte.addEventListener("change", (event) => {
        populateBarris();
    });
    via.addEventListener("change", (event) => {
        if (check())
            geocodeAddress()
    });
    nomCarrer.addEventListener("focusout", (event) => {
        if (check())
            geocodeAddress()
    });
    numCarrer.addEventListener("focusout", (event) => {
        if (check())
            geocodeAddress()
    });
}


// MAP FUNCTIONS

function loadMap() {

    map = L.map('map').setView([41.388, 2.159], 10);
    L.esri.basemapLayer('Topographic').addTo(map);

}

// GET LAT+LONG FROM ADRESS
function geocodeAddress() {

    let address = getAddress();
    L.esri.Geocoding.geocode().text(address).run(function (err, results, response) {
        if (!err) {
            latitude = results.results[0].latlng.lat;
            longitude = results.results[0].latlng.lng;
            console.log("lat =" + latitude + ", lng = " + longitude);

            // Add marker
            lat.value=latitude;
            lng.value=longitude;
            // L.marker([latitude, longitude]).addTo(map);
        } else {
            console.log(err);
            alert("Geocoding was not successful for the following reason: " + err);
        }
    });
}

function getAddress() {

    let viaText = via.options[via.selectedIndex].text;

    let address = `${viaText} ${nomCarrer.value} ${numCarrer.value} ${ciutat.value}`;
    console.log("address = " + address);
    return address;
}

function validateForm() {
    if (validarNom(nom.value) && Number.isInteger(parseInt(preu.value)) && preu.value >= 20000 && preu.value <= 1000000 && check()) {
        
        L.marker([lat.value, lng.value]).addTo(map);

    } else {
        alert('Campos sin rellenar')
    }
}