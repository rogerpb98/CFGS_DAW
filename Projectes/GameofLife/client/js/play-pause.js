// Requires button with ID="play_pause" and onclick="funcionCambio()"
let intervalID;
let ticker = 200; // default speed (miliseconds)

function playOrPause() {
    if (document.getElementById("play-button").innerHTML =="PLAY") {
        document.getElementById("play-button").innerHTML = "PAUSE";
        start(ticker);
        document.getElementById("form").style.display = "none";
        document.getElementById("game-info").style.marginLeft = "auto";
    }
    else {
        document.getElementById("play-button").innerHTML = "PLAY";
        clearInterval(intervalID);
    }
}
function speedUp() {
    // speeds up the timer by 50ms/inverval (caps at 50ms)
    if (ticker>50) ticker-=50;
    updateSpeed();
}
function speedDown() {
    // slows down the timer by 50ms/inverval (caps at 400ms)
    if (ticker<400) ticker+=50;
    updateSpeed();
}
function updateSpeed() {
    if(document.getElementById("play-button").innerHTML == "PAUSE") {
        start(ticker);
    }
    else {
        clearInterval(intervalID);
    }
}
function start() {
    clearInterval(intervalID);
    intervalID = setInterval(timer, ticker);
}