// File that contains all functions that will help us work with the board

// Generates a board full of dead cells (0)
function generateEmptyBoard(rows, columns) {
    generatedBoard = new Array(rows);
    for (i=0; i<rows; i++) { 
        generatedBoard[i]=new Array(columns);
        for (j=0; j<columns; j++) { 
            generatedBoard[i][j]=0;
        }
    }
    return generatedBoard; //returns bidimensional array
}
// Generated board with a random number of cells alive
function generateRandomBoard(rows, columns){
    generatedBoard=new Array(rows);
    for (let i = 0; i < rows; i++) {
        generatedBoard[i]=new Array(columns);
        for (let j = 0; j < columns; j++) {
            generatedBoard[i][j]=(Math.random()<0.3)?1:0; //each cell has a 10% chance of spawning alive
        }
    }
    return generatedBoard;
}
// Shows board from an universe in console
function showBoard(board) {
    for (i=0; i < board.length; i++) { 
        console.log(board[i].toString());
    }
}
/*   Board to JSON and back   */
// Board to JSON formatted string
function boardToJSON(board){
    return JSON.stringify(board);
}
// JSON file to board
async function JSONFileToBoard(ruta) {
    JSONstring = await fetch(ruta);
    return JSONToBoard(JSONstring);
}
// JSON formatted string to board
async function JSONToBoard(JSONstring) {
    return JSON.parse(JSONstring);
}
/*                            */

/* Series of functions that checks if every cell is worth of living */
// This function updates a board into the next state
function nextIteration(boardInput) {
    nextState = duplicateBoard(boardInput);
    for (rows = 0; rows < boardInput.length; rows++) {
        for (columns = 0; columns < boardInput[rows].length; columns++) {
            // we call the update function with the input board because it remains unaltered
            nextState[rows][columns] = updateState(boardInput, rows, columns);
        }
    }
    return nextState;
}
function updateState(boardInput, row, column) {
    livingCells = countLivingCells(boardInput, row, column);
    if (boardInput[row][column] == 1) {
        // Any live cell with two or three live neighbours survives.
        if (livingCells == 2 || livingCells == 3) return 1;
    }
    if (boardInput[row][column] == 0) {
        // Any dead cell with three live neighbours becomes a live cell.
        if (livingCells == 3) return 1;
    }
    // All other live cells die in the next generation. Similarly, all other dead cells stay dead.
    return 0;
}
function countLivingCells(boardInput, row, column) {
    livingCells=0;
    // Iterates from row-1, column -1, until row+1, column+1 and ignores itself
    for (i = row-1; i <= row+1; i++) {
        for (j = column-1; j <= column+1; j++) {
            if (checkBorders(boardInput, i, j)) continue; //case out of bounds
            if (row == i && column == j) continue; //case center cell
            if (boardInput[i][j] == 1) livingCells++;
        }
    }
    return livingCells;
}
function checkBorders(boardInput, row, column) {
    maxrows=boardInput.length;
    maxcolumns=boardInput[0].length;
    if (row==-1 || row==maxrows) {
        return true;
    } else if (column==-1 || column==maxcolumns) {
        return true;
    }
    else {
        return false;
    }
}
/* End of pack */
function duplicateBoard(boardInput) {
    generatedBoard = new Array(boardInput.length);
    for (i=0; i<boardInput.length; i++) { 
        generatedBoard[i]=new Array(boardInput[i].length);
        for (j=0; j<boardInput[i].length; j++) { 
            generatedBoard[i][j]=boardInput[i][j];
        }
    }
    return generatedBoard;
}

// Function that send json to backend to update the file containing the board
function sendBoardToBackend(boardInput){
    let boardJSON=JSON.stringify(boardInput); //converts board to json so we can send it to php
    
    var xhr = new XMLHttpRequest();
    var url = "../server/src/post-board.php";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var data = JSON.stringify(boardJSON);
    xhr.send(data);
    /*$.ajax({
        url: '../server/cositas.php',
        type: "POST",
        dataType:'json',
        data: boardJSON,
        success: function(data){
            console.log(data);
        }
    });*/
}

//let ruta = "../server/src/Assets/PreestablishedScenarios/scenario1.json";
function getBoardfromBackend(ruta) {
    return fetch(ruta).then(function(response){
        if (response.ok) {
            return response.json();
        }
    })
    .then(function(data){
        let boardReceived=data;
        //showBoard(board);
        board=boardReceived;
        drawBoard(board);
    });
    //.catch(console.log("API call failed"));
}

// Function that return the alive cells count
function quantesVives(items) { //For call this function you need pass an array
	let comptadorVives = 0;
	for(let fila = 0; fila <= items.length - 1; fila++){
	    for(let columna = 0; columna <= items[0].length - 1; columna++){
            if(items[fila][columna] == 1){
                comptadorVives = comptadorVives + 1;
            }
	    }
	}

	return comptadorVives;
}