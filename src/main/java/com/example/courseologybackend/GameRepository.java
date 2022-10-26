package com.example.courseologybackend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GameRepository {

    private final List<Game> cards = new ArrayList<>();

    //CREATE
    public void addCard(Game game) {
        cards.add(game);
    }

    //READ
    public List<Game> getAllCards() {
        return cards;
    }

    public Game getCardById(long id) {
        for(Game game: cards) {
            if(game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    public Game getRandomCard() {
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }

    //UPDATE
    public Game updateCard(Game newGame, long id) {
        newGame.setId(id);
        cards.set(cards.indexOf(getCardById(id)), newGame);
        return newGame;
    }

    //DELETE
    public boolean deleteCardById(long id) {
        if(getCardById(id) == null) {
            return false;
        }
        cards.remove(getCardById(id));
        return true;
    }

    public boolean hasCard(long id) {
        for(Game game: cards) {
            if(game.getId() == id) {
                return true;
            }
        }
        return false;
    }


}
