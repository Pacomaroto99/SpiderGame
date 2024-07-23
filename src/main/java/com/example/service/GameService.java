package com.example.service;

import com.example.exception.InvalidStakeException;
import com.example.exception.NonExistingGameException;
import com.example.model.GameFactory;
import com.example.model.contract.Game;
import com.example.model.dto.ManyRoundsRequest;
import com.example.model.dto.ManyRoundsResponse;
import com.example.model.dto.OneRoundRequest;
import com.example.model.dto.OneRoundResponse;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameFactory factory;

    public GameService(GameFactory factory) {
        this.factory = factory;
    }

    public OneRoundResponse playAGame(OneRoundRequest request){

        Game game = factory.getGame(request.getGameName(), request.getStake());
        validateGameName(request.getGameName());
        validateGameStake(request.getStake());

        return game.start();
    }

    public ManyRoundsResponse playManyRounds(ManyRoundsRequest request){
        Game game;
        int allStakes = 0;
        int allWins = 0;

        validateGameName(request.getGameName());
        if (request.getNumberOfRounds() != request.getStakes().size()){
            throw new InvalidStakeException("Stake array size must be equal to number of rounds");
        }

        for (int i = 0; i < request.getNumberOfRounds(); i++) {
            validateGameStake(request.getStakes().get(i));
            game  = factory.getGame(request.getGameName(), request.getStakes().get(i));
            allStakes += request.getStakes().get(i);
            allWins += game.start().getTotalWin();
        }
        return new ManyRoundsResponse(allStakes, allWins) ;
    }

    private static void validateGameName(String request) {
        if (!request.equalsIgnoreCase("spiderGame") ||
                request.isEmpty() ||
                request.isBlank()) {

            throw new NonExistingGameException("Game name is not valid");
        }
    }

    private static void validateGameStake(int stake) {
        if (stake % 11 != 0 || stake <= 0){
            throw new InvalidStakeException("Stake must be 11 or divisible by 11");
        }
    }
}
