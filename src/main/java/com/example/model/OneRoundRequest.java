package com.example.model;

public class OneRoundRequest {
    private String gameName;
    private int stake;

    public OneRoundRequest(String gameName, int stake) {
        this.gameName = gameName;
        this.stake = stake;
    }

    public String getGameName() {
        return gameName;
    }

    public int getStake() {
        return stake;
    }
}
