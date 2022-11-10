package com.example.courseologybackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = new Random().nextLong();
    private String name;
    private long elixir;
    private String rarity;
    private String attribute;
    private String count;
    private String targets;
    private String range;
    private String url;
    private String description;

    public Game() {

    }

    public Game(long id, String name, long elixir, String rarity, String attribute, String count, String targets, String range, String url, String description) {
        this.id = id;
        this.name = name;
        this.elixir = elixir;
        this.rarity = rarity;
        this.attribute = attribute;
        this.count = count;
        this.targets = targets;
        this.range = range;
        this.url = url;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getElixir() {
        return elixir;
    }

    public void setElixir(long elixir) {
        this.elixir = elixir;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTargets() {
        return targets;
    }

    public void setTargets(String targets) {
        this.targets = targets;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
