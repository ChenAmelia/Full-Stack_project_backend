## Full-Stack project -- backend
## Content
* [Introduction](#introduction)
* [Description](#description)
* [Example of use](#example-of-use)
* [Project Status](#project-status)

## Introduction
At the end of the 12-week course in _nology, we try to complete a full-stack project using everything we've learned. The theme I chose was a game called crash Royale.
Clash royale is a tower rush video game which puts players in games featuring two or four players(1V1 or 2V2). Players need to use the cards to destroy the most opposing towers, with the destruction of the "King's Tower" being an instantaneous win.
On the web page, I listed all the cards they've had so far, and let players filter cards by different attributes, as well as search for cards by card name, and click on a card to see more details.


Here's the link of Github repository: https://github.com/ChenAmelia/MineswepperGame

Here's the link of live page: https://chenamelia.github.io/MineswepperGame/
	
## Description
The project is created with:
* Java
* Postman
* MySQLWorkbench

First, use css to build a 10*10 grid as minesweeper grid and define the width and height. Then add id to each square (100 in total) using Javascript. Define the number of bombs and empty squares and pass through to square array as two parameters. Make sure the bomb and empty squares are shuffled randomly and will change each time the page is refreshed. When position of bomb and empty squares are set, add function when left or right click the square. When left click each square, if the square contains bomb, then the game will be terminated and alert game over; if the square doesn't contains a bomb, then the square will display the number of bombs around it, minimum to 1, maximum to 8. If there are no bombs around, then no number shows on the square but will keep checking other squares around it until check a bomb or a numbered square. I use recursion command to achieve the neighbor check. It's similar with bomb check command but the difference is, the bomb check command will only check other 8 squares and will stop immediately, but the neighboring check won't stop until a bomb square or a numbered square. I also use a Javascript inner function called setTimeOut to make the neighboring check looks like expand to other square.

When player right click on the square, the square will be flagged with a pink ribbon and add a class "flagged". If players right click the square again, then the "flagged" class will be removed and the pink ribbon will be removed as well.

Finally, the program need to check if the game is over or the player win the game. The game over program is simple. When click on a square with a class of bomb, then terminate the game and alert "Game Over". When players mark all the bomb with pink ribbon accurately, which means the square with both "checked" class and "flagged" class will equal to the amount of bombs, then alert "You win!".

## Example of use
The grid is a 10*10 grid with 100 square within.

<img width="250" alt="empty-grid" src="https://user-images.githubusercontent.com/109622201/187748785-59b34038-0acc-45ba-bdd9-fe99ccd835db.png">

When left click a square, it will show the status of the square, numbered, bomb square or empty.

<img width="250" alt="Screenshot 2022-08-31 at 19 08 17" src="https://user-images.githubusercontent.com/109622201/187749310-52315a41-296e-4b2b-b3f4-f77c3794cc2b.png">

When there is an area that has no bombs, the empty square will expand automatically untill check a numbered square or bomb square.

<img width="250" alt="expand" src="https://user-images.githubusercontent.com/109622201/187749510-46687cff-9ce7-491c-87ea-71cf072213ec.png">

When right click the square, the square will be flagged and the bombs-left count will show the number of bombs left on the left bottom side. If the player right click a flagged suqare, the flag will be removed and the bombs-left area will restore the number.

<img width="250" alt="flagged 1" src="https://user-images.githubusercontent.com/109622201/187749969-8e1a0727-e667-459b-8118-c0080299ecba.png">
<img width="250" alt="flagged 2" src="https://user-images.githubusercontent.com/109622201/187749993-4086401c-5e60-40eb-9056-48cc22361558.png">

When click a bomb square, the game will be terminated and alert "Game Over" with a band in the middle.

<img width="250" alt="gameover" src="https://user-images.githubusercontent.com/109622201/187750337-b81bc58c-efda-4dfd-819b-bfc83ffdde6e.png">

When check and flag all the bomb squares, the player will be checked as win and the page alert "You Win!"

<img width="250" alt="win" src="https://user-images.githubusercontent.com/109622201/187750594-2982b7fe-b9a3-43ba-b292-3898909c6b50.png">


## Project Status
The game project is currently running normally, and two higher difficulty levels, 20*20 (Medium) and 30*30(hard), will be added in the future.
