package com.example.controller;

import com.example.model.dto.ManyRoundsRequest;
import com.example.model.dto.ManyRoundsResponse;
import com.example.model.dto.OneRoundRequest;
import com.example.model.dto.OneRoundResponse;
import com.example.service.GameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping()
    public OneRoundResponse singleRound(@Validated @RequestBody OneRoundRequest oneRoundRequest) {
        return gameService.playAGame(oneRoundRequest);
    }

    @PostMapping("/many")
    public ManyRoundsResponse manyRounds(@Validated @RequestBody ManyRoundsRequest manyRoundsRequest) {
        return gameService.playManyRounds(manyRoundsRequest);
    }
}
