package com.example.model;

public class OneRoundResponse {
    private String gameName;
    private int stake;
    private int totalWin;
    private String traceOfGame;

    public OneRoundResponse(String gameName, int stake, int totalWin, String traceOfGame) {
        this.gameName = gameName;
        this.stake = stake;
        this.totalWin = totalWin;
        this.traceOfGame = traceOfGame;
    }

    public String getGameName() {
        return gameName;
    }

    public int getStake() {
        return stake;
    }

    public int getTotalWin() {
        return totalWin;
    }

    public String getTraceOfGame() {
        return traceOfGame;
    }
}
