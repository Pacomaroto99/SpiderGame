package com.example.service;

import com.example.model.GameFactory;
import com.example.model.contract.Game;
import com.example.model.dto.ManyRoundsRequest;
import com.example.model.dto.ManyRoundsResponse;
import com.example.model.dto.OneRoundRequest;
import com.example.model.dto.OneRoundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameFactory factory;

//    public GameService(GameFactory factory) {
//        this.factory = factory;
//    }

    public OneRoundResponse playAGame(OneRoundRequest request){
        return factory.getGame(request.getGameName(), request.getStake()).start();
    }

    public ManyRoundsResponse playManyRounds(ManyRoundsRequest request){
        Game game = factory.getGame(request.getGameName(), request.getStake());
        int allStakes = 0;
        int allWins = 0;

        for (int i = 0; i < request.getNumberOfRounds(); i++) {
            allStakes += request.getStake();
            allWins += game.start().getTotalWin();
        }
        return new ManyRoundsResponse(allStakes, allWins) ;
    }
}
