package com.example.controller;

import com.example.model.dto.ManyRoundsRequest;
import com.example.model.dto.ManyRoundsResponse;
import com.example.model.dto.OneRoundRequest;
import com.example.model.dto.OneRoundResponse;
import com.example.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The spider find his path", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = OneRoundResponse.class))}),})
    @PostMapping()
    public OneRoundResponse singleRound(@Validated @RequestBody OneRoundRequest oneRoundRequest) {
        return gameService.playAGame(oneRoundRequest);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The spider find his path", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ManyRoundsResponse.class))}),})
    @PostMapping("/many")
    public ManyRoundsResponse manyRounds(@Validated @RequestBody ManyRoundsRequest manyRoundsRequest) {
        return gameService.playManyRounds(manyRoundsRequest);
    }
}
