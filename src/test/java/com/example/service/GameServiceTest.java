package com.example.service;

import com.example.exception.InvalidStakeException;
import com.example.exception.NonExistingGameException;
import com.example.game.GameFactory;
import com.example.game.SpiderGame;
import com.example.model.ManyRoundsRequest;
import com.example.model.ManyRoundsResponse;
import com.example.model.OneRoundRequest;
import com.example.model.OneRoundResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GameFactory factory;

    @InjectMocks
    private GameService service;

    @Test
    public void givenValidRequest_whenPlayAGame_thenReturnsResponse() {
        String gameName = "spiderGame";
        int stake = 11;
        OneRoundRequest request = new OneRoundRequest(gameName, stake);
        SpiderGame mockGame = mock(SpiderGame.class);
        OneRoundResponse mockResponse = new OneRoundResponse(gameName, stake, 3, "ABCE");

        when(factory.getGame(gameName, stake)).thenReturn(mockGame);
        when(mockGame.start()).thenReturn(mockResponse);

        OneRoundResponse response = service.playAGame(request);

        assertNotNull(response);
        assertEquals(gameName, response.getGameName());
        assertEquals(stake, response.getStake());
        assertEquals(3, response.getTotalWin());
        assertEquals("ABCE", response.getTraceOfGame());
    }

    @Test
    public void givenInvalidGameName_whenPlayAGame_thenThrowsException() {
        String invalidGameName = "invalidGame";
        int stake = 11;
        OneRoundRequest request = new OneRoundRequest(invalidGameName, stake);

        assertThrows(NonExistingGameException.class, () -> service.playAGame(request));
    }

    @Test
    public void givenInvalidStake_whenPlayAGame_thenThrowsException() {
        String gameName = "spiderGame";
        int invalidStake = 10;
        OneRoundRequest request = new OneRoundRequest(gameName, invalidStake);

        assertThrows(InvalidStakeException.class, () -> service.playAGame(request));
    }

    @Test
    public void givenValidManyRoundsRequest_whenPlayManyRounds_thenReturnsResponse() {
        String gameName = "spiderGame";
        List<Integer> stakes = List.of(11, 22, 33);
        ManyRoundsRequest request = new ManyRoundsRequest(gameName, stakes, stakes.size());
        SpiderGame mockGame = mock(SpiderGame.class);
        OneRoundResponse mockResponse1 = new OneRoundResponse(gameName, 11, 3, "AB");
        OneRoundResponse mockResponse2 = new OneRoundResponse(gameName, 22, 6, "ABCDE");
        OneRoundResponse mockResponse3 = new OneRoundResponse(gameName, 33, 9, "ABCDEE");

        when(factory.getGame(gameName, 11)).thenReturn(mockGame);
        when(factory.getGame(gameName, 22)).thenReturn(mockGame);
        when(factory.getGame(gameName, 33)).thenReturn(mockGame);
        when(mockGame.start()).thenReturn(mockResponse1).thenReturn(mockResponse2).thenReturn(mockResponse3);

        ManyRoundsResponse response = service.playManyRounds(request);

        assertNotNull(response);
        assertEquals(66, response.getSumOfAllStakes());
        assertEquals(18, response.getSumOfAllWins());
    }

    @Test
    public void givenMismatchedRoundsAndStakes_whenPlayManyRounds_thenThrowsException() {
        String gameName = "spiderGame";
        List<Integer> stakes = List.of(11, 22);
        ManyRoundsRequest request = new ManyRoundsRequest(gameName, stakes, 3);

        assertThrows(InvalidStakeException.class, () -> service.playManyRounds(request));
    }

    @Test
    public void givenInvalidStakeInManyRounds_whenPlayManyRounds_thenThrowsException() {
        String gameName = "spiderGame";
        List<Integer> stakes = List.of(10);
        ManyRoundsRequest request = new ManyRoundsRequest(gameName, stakes, 3);

        assertThrows(InvalidStakeException.class, () -> service.playManyRounds(request));
    }
}
