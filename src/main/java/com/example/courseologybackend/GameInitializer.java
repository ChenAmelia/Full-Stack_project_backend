package com.example.courseologybackend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.*;


@Component
public class GameInitializer {
    private final GameRepository gameRepository;

    @Value("classpath:cards.json")
    private Resource resourceFile;

    @Autowired
    public GameInitializer(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void init() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(resourceFile.getFile())) {
            Object obj = jsonParser.parse(reader);

            JSONArray jsonArray = (JSONArray) obj;

            for (Object card : jsonArray) {
                JSONObject cardJSON = (JSONObject) card;

                long id = (long) cardJSON.get("id");

                String name = (String) cardJSON.get("name");
                long elixir = (long) cardJSON.get("elixir");
                String rarity = (String) cardJSON.get("rarity");
                String attribute = (String) cardJSON.get("attribute");
                String count= (String) cardJSON.get("count");
                String targets = (String) cardJSON.get("targets");
                String range= (String) cardJSON.get("range");
                String url = (String) cardJSON.get("img_url");
                String description= (String) cardJSON.get("description");

                // HOW CAN WE USE THIS DATA?
                gameRepository.addCard(new Game(id, name, elixir, rarity, attribute, count, targets, range, url, description));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
