package com.example.model.dto;

import java.util.List;

public class ManyRoundsRequest {
    private String gameName;
    private List<Integer> stakes;
    private int numberOfRounds;

    public ManyRoundsRequest(String gameName, List<Integer> stakes, int numberOfRounds) {
        this.gameName = gameName;
        this.stakes = stakes;
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public String getGameName() {
        return gameName;
    }

    public List<Integer> getStakes() {
        return stakes;
    }
}
