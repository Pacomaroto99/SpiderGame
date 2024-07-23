package com.example.controller;

import com.example.model.dto.ManyRoundsRequest;
import com.example.model.dto.ManyRoundsResponse;
import com.example.model.dto.OneRoundRequest;
import com.example.model.dto.OneRoundResponse;
import com.example.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public OneRoundResponse singleRound(@RequestBody OneRoundRequest oneRoundRequest) {
        return gameService.playAGame(oneRoundRequest);
    }

    @GetMapping("/many")
    public ManyRoundsResponse manyRounds(@RequestBody ManyRoundsRequest manyRoundsRequest) {
        return gameService.playManyRounds(manyRoundsRequest);
    }
}
