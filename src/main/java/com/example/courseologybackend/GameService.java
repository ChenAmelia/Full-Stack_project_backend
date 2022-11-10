package com.example.courseologybackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    //CREATE
    public void addCard(Game game) {
        gameRepository.save(game);
    }

    //READ

    public List<Game> getAllCards() {
        return gameRepository
                .findAll();
    }

    public Game getCardById(long id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isEmpty()) {
            throw new GameNotFoundException();
        }
        return game.get();
    }

    public Game getRandomCard() {
        List<Game> cards = gameRepository.findAll();
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }



    public List<Long> getCardIds() {
        return gameRepository.getDistinctIds();

//        List<Game> cards = gameRepository.findAll();

//        return cards.stream()
//                .map(Game::getId)
//                .collect(Collectors.toList());
    }

    public List<Game> getCardByName(String name){
        List<Game> cards = gameRepository.findAll();
        return cards
                .stream()
                .filter(game -> game.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Game> getCardByRarity(String rarity) {
        List<Game> cards = gameRepository.findAll();
        return cards
                .stream()
                .filter(game -> game.getRarity().equalsIgnoreCase(rarity))
                .collect(Collectors.toList());
    }

    public List<Game> getCardByTargets(String targets) {
        List<Game> cards = gameRepository.findAll();
        return cards
                .stream()
                .filter(game -> game.getTargets().equalsIgnoreCase(targets))
                .collect(Collectors.toList());
    }

    //UPDATE
    public void updateCard(Game newGame, long id) {
        if(!gameRepository.existsById(id)) {
            throw new GameNotFoundException();
        }
        newGame.setId(id);
        gameRepository.save(newGame);
    }

    //DELETE
    public void deleteCardById(long id) {
        if(!gameRepository.existsById(id)) {
            throw new GameNotFoundException();
        }
        gameRepository.deleteById(id);
    }



}
