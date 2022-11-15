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


Here's the link of front-end in Github repository: 

Here's the link of live page: 
	
## Description
The project is created with:
* Java
* Postman
* MySQLWorkbench

This is the backend repository of the full-stack project.

To build up the backend, the first step is to ceate a json file with all cards' information in it. The best way is to find the API of Clash Royale, but I don't have the access permission, so I choose to create a json file by myself to store all the card information.

Next, use Java and springboot frame to synchronize the card information in the json file to Java. In this process, in addition to using Java, MySQLWorkbench and Postman are also required to deploy data in Java. First, import the json file as a table into the workbench, and then use the @CrossOrigin annotation in Java to request to import the data into Java. After the workbench successfully imports the json file and runs successfully, the established database can be used in Java.

<img width="500" alt="MySQL-table" src="https://user-images.githubusercontent.com/109622201/201999337-176bc681-06b8-4bae-94c3-94c0b177cf31.png">

In order to get data by various requirments, I need to write functions in Java, such as list all cards, get one random card, get card by a specific attribute or delete a card by its id, etc. Then run the Java and the result will be displayed in postman.


## Example of use

List all cards in the sequence of ids.

<img width="500" alt="postman-allcards" src="https://user-images.githubusercontent.com/109622201/202001818-41800633-03a1-4670-8d60-68cb0d0c372a.png">

Search for one card by id.

<img width="500" alt="postman-id7" src="https://user-images.githubusercontent.com/109622201/202001994-c4eb5b9a-faa4-4b33-9d51-f27802bb9a1f.png">
<img width="500" alt="postman-id87" src="https://user-images.githubusercontent.com/109622201/202002008-6ffa873c-5957-4489-a9e1-47a6aecc448c.png">

Display one card randomly.

<img width="500" alt="postman-random1" src="https://user-images.githubusercontent.com/109622201/202002074-69962dcc-23e4-46cc-aa65-d59258e4c334.png">

<img width="500" alt="postman-random2" src="https://user-images.githubusercontent.com/109622201/202002087-db50db5d-6e6c-4a72-83d8-084dd33a4a44.png">

Display all cards with rarity of "Epic".

<img width="500" alt="rarity" src="https://user-images.githubusercontent.com/109622201/202003525-b4d8ef1e-8c36-4dd1-bb6b-e21a24beeb54.png">


## Project Status

