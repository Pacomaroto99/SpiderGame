package com.example.model.dto;

public class ManyRoundsResponse {
    private int sumOfAllStakes;
    private int sumOfAllWins;

    public ManyRoundsResponse(int sumOfAllStakes, int sumOfAllWins) {
        this.sumOfAllStakes = sumOfAllStakes;
        this.sumOfAllWins = sumOfAllWins;
    }

    public int getSumOfAllStakes() {
        return sumOfAllStakes;
    }

    public int getSumOfAllWins() {
        return sumOfAllWins;
    }
}
