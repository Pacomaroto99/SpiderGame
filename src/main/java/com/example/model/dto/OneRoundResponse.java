package com.example.model.dto;

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

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getStake() {
        return stake;
    }

    public void setStake(int stake) {
        this.stake = stake;
    }

    public int getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(int totalWin) {
        this.totalWin = totalWin;
    }

    public String getTraceOfGame() {
        return traceOfGame;
    }

    public void setTraceOfGame(String traceOfGame) {
        this.traceOfGame = traceOfGame;
    }
}
