package com.example.model;

public class ManyRoundsResponse {
    private int sumOfAllStakes;
    private int sumOfAllWins;
    private float rtp;

    public ManyRoundsResponse(int sumOfAllStakes, int sumOfAllWins) {
        this.sumOfAllStakes = sumOfAllStakes;
        this.sumOfAllWins = sumOfAllWins;
        this.rtp = (float) sumOfAllWins / sumOfAllStakes;
    }

    public int getSumOfAllStakes() {
        return sumOfAllStakes;
    }

    public int getSumOfAllWins() {
        return sumOfAllWins;
    }

    public float getRtp() {
        return rtp;
    }
}
