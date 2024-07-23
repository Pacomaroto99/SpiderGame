package com.example.model.dto;

public class ManyRoundsRequest extends OneRoundRequest{
    private int numberOfRounds;

    public ManyRoundsRequest(String gameName, int stake, int numberOfRounds) {
        super(gameName, stake);
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }
}
