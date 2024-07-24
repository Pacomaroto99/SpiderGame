package com.example.game;

import com.example.game.contract.Game;

public class GameFactory {

    public Game getGame(String gameName, int stake) {
        if (gameName.equalsIgnoreCase("spiderGame")) {
            return new SpiderGame(gameName, stake);
        }
        return null; //here can also be added validation
    }
}
