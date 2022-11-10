package com.example.courseologybackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    GameService gameService;

    @ExceptionHandler
    public String handleException(GameNotFoundException exception) {
        return exception.getMessage();
    }


    //CREATE

    @PostMapping("/cards")
    public Game createCard(@RequestBody Game game) {
        gameService.addCard(game);
        return game;
    }

    //READ

    @GetMapping("/cards/ids")
    //Get all cards ids
    public List<Long> getCardIds() {
        return gameService.getCardIds();
    }

    //http://localhost:8080/cards => get list if all cards
    //http://localhost:8080/cards?name=golem  => get the card by its name(golem)
    //Can filter the card list by any value

    @GetMapping("/cards")
    public List<Game> getCards(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String rarity,
                               @RequestParam(required = false) String targets) {

        if(!(name == null)){
            return gameService.getCardByName(name);
        } else if (!(rarity == null)) {
            return gameService.getCardByRarity(rarity);
        } else if (!(targets == null)) {
            return gameService.getCardByTargets(targets);
        }

        return gameService.getAllCards();
//        if(rarity == null) {
//            return gameService.getAllCards();
//        }
//        //return gameService.getCardByName(name);
//        return gameService.getCardByRarity(rarity);
    }


    @GetMapping("/cards/{id}")
    //Get only one card by the card's unique id
    public Game getCardById(@PathVariable long id) {
        return gameService.getCardById(id);
    }

    @GetMapping("/cards/random")
    //Get a random card
    public Game getRandomCard() {
        return gameService.getRandomCard();
    }

    //DELETE
    @DeleteMapping("/cards/{id}")
    //Delete a card by its id
    public String deleteCardById(@PathVariable int id) {
        gameService.deleteCardById(id);
        return "Deleted Card";
    }



    //UPDATE
    @PutMapping("/cards/{id}")
    public Game updateCard(@PathVariable int id, @RequestBody Game newGame) {
        newGame.setId(id);
        gameService.updateCard(newGame, id);
        return newGame;
    }

}
