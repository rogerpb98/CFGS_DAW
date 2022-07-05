let board = new Array();
let counter = 0; // Number of iterations the universe went through
function timer() {
    alive = quantesVives(board);
    // We can have a div with ID result for testing purposes (counter)
    document.getElementById("timer").innerHTML  = counter;
    document.getElementById("alive").innerHTML  = quantesVives(board);
    document.getElementById("rows").innerHTML  = board.length;
    document.getElementById("columns").innerHTML  = board[0].length;
    counter++;
    board = nextIteration(board);
    drawBoard(board);
}
function boardGeneration() {
    document.getElementById("game-buttons").style.visibility = "visible";
    assertBoard();
}