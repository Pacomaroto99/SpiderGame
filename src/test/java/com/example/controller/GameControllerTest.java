package com.example.controller;


import com.example.model.OneRoundRequest;
import com.example.model.ManyRoundsRequest;
import com.example.service.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @Test
    public void givenOneRoundRequest_whenSingleRound_thenCallsGameService() {
        String gameName = "spiderGame";
        int stake = 11;
        OneRoundRequest request = new OneRoundRequest(gameName, stake);

        gameController.singleRound(request);

        verify(gameService, times(1)).playAGame(request);
    }

    @Test
    public void givenManyRoundsRequest_whenManyRounds_thenCallsGameService() {
        String gameName = "spiderGame";
        int numberOfRounds = 3;
        ManyRoundsRequest request = new ManyRoundsRequest(gameName, List.of(11, 22, 33), numberOfRounds);

        gameController.manyRounds(request);

        verify(gameService, times(1)).playManyRounds(request);
    }
}
