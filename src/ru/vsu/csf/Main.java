package ru.vsu.csf;

public class Main {

    public static void main(String[] args) {
	    Game g = new Game();

        while (!g.isOver()) {
            printStats(g);
            g.makeGuess();
        }
        printStats(g);

    }

    private static void printStats(Game g) {
        g.getGameStatistics().forEach(System.out::println);
    }
}