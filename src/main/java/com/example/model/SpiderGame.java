package com.example.model;

import com.example.model.contract.Game;
import com.example.model.dto.OneRoundResponse;

import java.util.Random;

import static java.lang.String.valueOf;

public class SpiderGame implements Game {
    private String gameName;
    private int stake;

    public SpiderGame(String gameName, int stake) {
        this.gameName = gameName;
        this.stake = stake;
    }

    @Override
    public OneRoundResponse start() {
        StringBuilder traceOfGame = new StringBuilder("A");
        int numIndex = 0;
        String index = "A";
        int totalWin = 0;
        Random rand = new Random();

        while (!index.equals("E")) {//E for end
            switch (index) {
                case "A" -> {
                    totalWin += stake / 11;
                    index = "B";
                    traceOfGame.append(index);
                }
                case "B" -> {
                    numIndex = rand.nextInt("CCA".length());
                    totalWin += stake / 11;
                    index = valueOf("CCA".charAt(numIndex));
                    traceOfGame.append(index);
                }
                case "C" -> {
                    totalWin += stake / 11;
                    numIndex = rand.nextInt("BBE".length());
                    index = valueOf("BBE".charAt(numIndex));
                    traceOfGame.append(index);
                }
            }
        }

        return new OneRoundResponse(gameName, stake, totalWin, traceOfGame.toString());
    }
}
