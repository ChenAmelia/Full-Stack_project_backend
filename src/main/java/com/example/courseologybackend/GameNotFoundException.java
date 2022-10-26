package com.example.courseologybackend;

public class GameNotFoundException extends RuntimeException{
    public GameNotFoundException() {
        super("Card has not been found.");
    }
}
