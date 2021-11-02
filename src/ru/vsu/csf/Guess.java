package ru.vsu.csf;

import java.util.Random;

public enum Guess {
    ODD(1),
    EVEN(0);

    private final int remainder;

    Guess(int remainder) {
        this.remainder = remainder;
    }

    public boolean isCorrect(int number) {
        return number % 2 == remainder;
    }

    public static Guess makeGuess(){
        if (new Random().nextInt(2) == 0) {
            return Guess.EVEN;
        }
        return Guess.ODD;

    }
}