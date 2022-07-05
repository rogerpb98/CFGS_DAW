// https://leafletjs.com/examples/quick-start/
var map = L.map('map').setView([35.925710, -27.708312], 13);

L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 4,
    minZoom: 2,
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
/************************************/
function paintMarker(color) {
    return {
        color: color,
        fillColor: '#f03',
        fillOpacity: 0.5,
        radius: 5000
    };
}
function addMarker(meteorite) {
    let latitud = (meteorite.reclat) ? parseFloat(meteorite.reclat) : null ;
    let longitud = (meteorite.reclong) ? parseFloat(meteorite.reclong) : null;
    let masa = parseFloat(meteorite.mass);
    if (latitud && longitud) {
        let marker;
        if ( masa <= 1000 ) {
            marker = L.circle([latitud, longitud], paintMarker("green") ).addTo(map);
        }
        else if ( masa > 1000 && masa <= 100000 ) {
            marker = L.circle([latitud, longitud], paintMarker("orange")).addTo(map);
        }
        else if ( masa > 100000 ) {
            marker = L.circle([latitud, longitud], paintMarker("red")).addTo(map);
        }
        else return;
        marker.bindPopup(`Nombre: ${meteorite.name} Masa: ${meteorite.mass/1000}(Kg)`).openPopup();
    }
}
