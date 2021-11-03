package ru.vsu.csf;

import java.util.concurrent.ThreadLocalRandom;

public class Player {

    public final String name;
    private int marblesCount;
    private int bet = -1;

    public Player(String name, int marblesCount) {
        this.name = name;
        this.marblesCount = marblesCount;
    }

    public Player(String name) {
        this(name, ThreadLocalRandom.current().nextInt(21)+5);
    }

    public int getMarblesCount() {
        return marblesCount;
    }

    public void bet() {
        bet = ThreadLocalRandom.current().nextInt(marblesCount)+1;
//        System.out.println("Bet "+name+" "+bet);
    }

    public Guess makeGuess() {
        return Guess.makeGuess();
    }

    public boolean isGuessCorrect(Guess guess) {
        boolean playersGuess = guess.isCorrect(bet);
//        System.out.println("Guessed "+guess+": "+name+" "+playersGuess);
        return playersGuess;
    }

    public void takeMarbles(Player player) {
          marblesCount = marblesCount + player.remove(bet);
    }

    private int remove(int amount) {
        int min = Math.min(amount, marblesCount);
        marblesCount = marblesCount - min;
        return min;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", marblesCount=" + marblesCount +
                ", bet=" + bet +
                '}';
    }
}