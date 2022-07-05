# GameofLife #

## INSTRUCTIONS FOR RUNNING IN LOCALHOST

1. Clone the repository in  
/var/www/html

2. (marc explica mejor esto) para obtener la base de datos basta con hacer un source con la ruta de la base de datos he instalar phpmyAdmin para una mejor visualización

3. Open your browser and write the next url:  
http://localhost/GameofLife/client/index.html

## SPRINT 1 IMPLEMENTATIONS

 Basic HTML to display the state of the project

* Button to Play/Pause the game, as the game is not finished right now, we just use it with a counter that increments every iteration to know it works correctly.

* Created universe using board filled with 0 (dead cells) and 1 (alive cells) with dynamic width and height.

* Created the canvas that will show up the board on screen.

* Game rules (currently lacks the ability to evaluate cells at the borders of the board).


## SPRINT 2 IMPLEMENTATIONS

* Fixed game rules so it evaluates cells at the borders too.

* We realised doing everything in the backend might cause scaling problems if there are too many clients doing petitions to the server, so we decided to bring the game logic to the front end (translated from php to javascript) and only leave a few functions to get board from the few jsons stored in the servers that we have, and send board from client to the server.

* We implemented buttons to increase/decrease game speed (it caps at 50 and 1000 ms intervals).

* We finally learned how to do calls to the backend using fetch function in javascript, that will enable us to get the json files to load preestablished scenarios.

* Function to count alive cells in the board in the current iteration.

* Added dropdown menu to chose between Empty/Random Board or one of the preestablished boards we have in the server.

## SPRINT 3 IMPLEMENTATIONS

* Refactor of the functions that handled the Play/Pause/Speeds buttons for better readability and ease of implementation with other functionalities.

* The game now works (it loops and updates in every iteration to the next state correctly).

* Better HTML structure and CSS.

* Interactive cells: you can click in the canvas to change the state of a cell (known bug: sometimes it changes the state of a cell not corresponding to coordinates clicked, we believe its because of different screen resolutions as we work with pixels)