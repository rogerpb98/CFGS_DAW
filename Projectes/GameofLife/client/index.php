<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game of Life</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body onload="loadDropdown()">
    <?php
    if (!(isset($_COOKIE['user']))) {
        header("Location: login.php"); 
        exit();
    }
    ?>
    <div id="top-bar">
        <form id="form" onSubmit="return false"> <!--prevents reload on submit-->
            <p>Select Board: <select id="board-selector"></select></p>
            <div id="dimensions">
                <input type="text" name="canvasrows" id="canvasrows" placeholder="rows"></input>    
                <input type="text" name="canvascols" id="canvascols" placeholder="columns"></input>    
            </div>
            <button type="submit" onclick="boardGeneration()">Generate Board</button>
        </form>
        <div id="game-info">
            <p>rows <textarea id="rows" type="number" readonly value="patata"></textarea></p>
            <p>columns <textarea id="columns" type="number" readonly value="patata"></textarea></p>
            <p>time <textarea id="timer" type="number" readonly value="patata"></textarea></p>
            <p>alive <textarea id="alive" type="number" readonly value="patata"></textarea></p>
        </div>
    </div>
    
    <canvas id="boardCanvas" width="1500" height="750" onclick="interactiveCells()"></canvas>

    <div id="game-buttons">
        <button class="speed-buttons" onclick="speedDown()">-</button>
        <button id ="play-button" onclick="playOrPause()">PLAY</button>
        <button class="speed-buttons" onclick="speedUp()">+</button>
    </div>   
    <script src="js/board-utils.js"></script> <!--No dependancies-->
    <script src="js/dropdown.js"></script> <!--No dependancies-->
    <script src="js/canvas.js"></script>
    <script src="js/life.js"></script>
    <script src="js/play-pause.js"></script>
    
</body>
</html>