package com.example.game;

import com.example.game.contract.Game;
import com.example.model.OneRoundResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpiderGameTest {
    String gameName = "spiderGame";
    int stake = 11;
    SpiderGame game;

    @BeforeEach
    void setup() {
        game = new SpiderGame(gameName, stake);
    }

    @Test
    public void givenValidGameState_whenStart_thenReturnsCorrectResponse() {
        OneRoundResponse response = game.start();
        OneRoundResponse response1 = game.start();

        assertNotNull(response);
        assertEquals(gameName, response.getGameName());
        assertEquals(stake, response.getStake());
        assertNotEquals(response1.getTotalWin(), response.getTotalWin()); // not always true
        assertTrue(response.getTraceOfGame().contains("AB"));
        assertTrue(response.getTraceOfGame().contains("CE"));
    }

    @Test
    public void givenDifferentRandomValues_whenStart_thenReturnsCorrectResponse() {
        OneRoundResponse response = game.start();

        assertNotNull(response);
        assertEquals(gameName, response.getGameName());
        assertEquals(stake, response.getStake());

        assertTrue(response.getTotalWin() >= 0);
        assertTrue(response.getTraceOfGame().contains("A"));
        assertTrue(response.getTraceOfGame().contains("B"));
        assertTrue(response.getTraceOfGame().contains("C"));
        assertTrue(response.getTraceOfGame().contains("E"));
    }
}
