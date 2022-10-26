package com.example.courseologybackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    //CREATE
    public void addCard(Game game) {
        gameRepository.addCard(game);
    }

    //READ

    public List<Game> getAllCards() {
        return gameRepository.getAllCards();
    }

    public Game getCardById(long id) {
        if(gameRepository.hasCard(id)) {
            return gameRepository.getCardById(id);
        }

        throw new GameNotFoundException();
    }

    public Game getRandomCard() {
        return gameRepository.getRandomCard();
    }

    //UPDATE
    public void updateCard(Game newGame, long id) {
        if(gameRepository.hasCard(id)) {
            gameRepository.updateCard(newGame, id);
        }
        throw new GameNotFoundException();
    }

    //DELETE
    public void deleteCardById(long id) {
        if(gameRepository.hasCard(id)) {
            gameRepository.deleteCardById(id);
        }
        throw new GameNotFoundException();
    }

    public List<Long> getCardIds() {
        List<Game> cards = gameRepository.getAllCards();
        List<Long> ids = cards
                .stream()
                .map(game -> game.getId())
                .distinct()
                .collect(Collectors.toList());
        return ids;
    }

    public List<Game> getCardByName(String name){
        List<Game> cards = gameRepository.getAllCards()
                .stream()
                .filter(game -> game.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return cards;
    }

    public List<Game> getCardByRarity(String rarity) {
        List<Game> cards = gameRepository.getAllCards()
                .stream()
                .filter(game -> game.getRarity().equalsIgnoreCase(rarity))
                .collect(Collectors.toList());
        return cards;
    }



}
