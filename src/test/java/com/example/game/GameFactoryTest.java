package com.example.game;

import com.example.game.contract.Game;
import com.example.model.OneRoundResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GameFactoryTest {
    GameFactory factory = new GameFactory();

    @Test
    public void givenValidGameName_whenGetGame_thenReturnsSpiderGame() {

        Game game = factory.getGame("spiderGame", 110);
        OneRoundResponse finishedGame = game.start();

        assertNotNull(game);
        assertInstanceOf(SpiderGame.class, game);
        assertEquals("spiderGame", finishedGame.getGameName());
        assertEquals(110, finishedGame.getStake());
    }

    @Test
    public void givenInvalidGameName_whenGetGame_thenReturnsNull() {

        Game game = factory.getGame("invalidGame", 100);

        assertNull(game);
    }

    @Test
    public void givenNullGameName_whenGetGame_thenReturnsNull() {

        Game game = factory.getGame(null, 100);

        assertNull(game);
    }

    @Test
    public void givenEmptyGameName_whenGetGame_thenReturnsNull() {

        Game game = factory.getGame("", 100);

        assertNull(game);
    }

    @Test
    public void givenGameNameWithDifferentCase_whenGetGame_thenReturnsSpiderGame() {

        Game game = factory.getGame("SpiderGame", 100);
        OneRoundResponse finishedGame = game.start();

        assertNotNull(game);
        assertInstanceOf(SpiderGame.class, game);
        assertEquals("SpiderGame", finishedGame.getGameName());
        assertEquals(100, finishedGame.getStake());
    }
}
