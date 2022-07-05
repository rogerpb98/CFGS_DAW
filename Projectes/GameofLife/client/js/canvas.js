
let c = document.getElementById("boardCanvas");
let ctx = c.getContext("2d");
function assertBoard() {
    let elem = document.getElementById("board-selector");
    // Case when the board is generated via inputs
    if (elem.value=="Empty Board" || elem.value=="Random Board") {
        let rows = document.getElementById("canvasrows").value;
        let columns = document.getElementById("canvascols").value;
        if (elem.value=="Empty Board") {
            board = generateEmptyBoard(rows, columns);
        }
        else {
            board = generateRandomBoard(rows, columns);
        }
        drawBoard(board);
    }
    // Case when you use predefined board
    else {
        file = "../server/src/Assets/PreestablishedScenarios/"+elem.value;
        getBoardfromBackend(file);
    }
}
function drawBoard(array) {
    
    //ctx.clearRect(0, 0, canvas.width, canvas.height);
    
    ctx.lineWidth = 0.5;
    ctx.strokeStyle = 'black';
    /*Inicializar dos variables en el pixel x0,y0 del canvas, que usaremos para
    delimitar el area donde empieza a dibujarse cada cuadrado*/
    let x=0;
    let y=0;
    for (let i = 0; i < array.length; i++) {
        for (let a = 0; a < array[0].length; a++){
            if (array[i][a] == 0) {
                ctx.beginPath();
                ctx.rect(x, y, 20, 20);
                ctx.fillStyle = "white";
                ctx.fill();
                ctx.stroke();    
            } else {
                ctx.beginPath();
                ctx.rect(x, y, 20, 20);
                ctx.fillStyle = "black";
                ctx.fill();
                ctx.stroke();
            }
            x=x+20;
        }
        y=y+20;
        x=0;
    }
}

function interactiveCells(){
    if(board == undefined){
        return;
    }

    var boardWidth = board[0].length * 20;
    var boardHeight = board.length * 20;
    console.log("Anchura tablero: " + boardWidth);
    console.log("Altura tablero: " + boardHeight);

    c.onclick = 
    function(e) {
        var clickX = e.clientX;
        var clickY = e.clientY;

        console.log("X: " + clickX);
        console.log("Y: " + clickY);

        //Correct difference with pixels
        var differenceX = clickX/20 * 3.68;
        var differenceY = clickY/20 * 4.48;
        clickX = Math.round(clickX - differenceX);
        clickY = Math.round(clickY - differenceY);

        console.log("X CORREGIDO: " + clickX);
        console.log("Y CORREGIDO: " + clickY);

        //print cell
        ctx.lineWidth = 0.5;
        ctx.strokeStyle = 'black';
        let row;
        let column;
        for(var i = clickX; i<= boardWidth && i>=0;i--){
            if(i%20 == 0){
                for(var z = clickY; z<= boardHeight && z>=0;z--){
                    if(z%20 == 0){
                        row = Math.trunc(clickY/20);  //this two lines catch the position of cell in array
                        column = Math.trunc(clickX/20);

                        if(board[row][column] == 1){

                            ctx.beginPath();
                            ctx.rect(i, z, 20, 20);
                            ctx.fillStyle = "white";
                            ctx.fill();
                            ctx.stroke();
                            board[row][column] = 0; //change cell state
                        }
                        else{
                            ctx.beginPath();
                            ctx.rect(i, z, 20, 20);
                            ctx.fillStyle = "black";
                            ctx.fill();
                            ctx.stroke();
                            board[row][column] = 1; //change cell state
                        }                        
                        return;
                    }
                }
            }
            continue;
        }
    };
}