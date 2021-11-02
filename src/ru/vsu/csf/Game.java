package ru.vsu.csf;

import ru.vsu.csf.stats.GameStats;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public static final int INITIAL_MARBLES_COUNT = 10;

    private final Player[] players = new Player[2];

    private int currentPlayer;

    public Game() {
        players[0] = new Player("Player 1", INITIAL_MARBLES_COUNT);
        players[1] = new Player("Player 2", INITIAL_MARBLES_COUNT);
        currentPlayer = 0;
    }

    public boolean isOver() {
        return players[0].getMarblesCount() == 0 || players[1].getMarblesCount() == 0;
    }

    public void makeGuess() {
        if (isOver()) {
            throw new IllegalStateException("Game is over");
        }

        for (Player p : players) {
            p.bet();
        }

        Guess guess = players[currentPlayer].makeGuess();

        int nextPlayer = (currentPlayer + 1) % 2;

        if (players[nextPlayer].isGuessCorrect(guess)) {
            players[currentPlayer].takeMarbles(players[nextPlayer]);
        } else {
            players[nextPlayer].takeMarbles(players[currentPlayer]);
        }

        currentPlayer = nextPlayer;
    }

    public List<GameStats> getGameStatistics() {

        return Arrays.stream(players)
                .map(p -> new GameStats(p.name, p.getMarblesCount())).collect(Collectors.toList());
    }

}