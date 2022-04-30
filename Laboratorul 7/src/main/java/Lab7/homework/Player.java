package Lab7.homework;

import java.io.*;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private final String name;
    public Game game;
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private int k;
    private boolean running = true;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    private boolean submitWord() {
        System.out.println(game.getBag().getLetters().size() + " tiles left");

        Integer result = threadLocal.get();
        System.out.println("You have to extract " + result + " tiles");

        if (game.getBag().getLetters().size() < result) {
            System.out.println("Bag does not have enough tiles left!");
            result = game.getBag().getLetters().size();
        }

        List<Tile> extracted = game.getBag().extractTiles(result);

        System.out.println("You have extracted " + result + " tiles");

        if (extracted.isEmpty()) {
            return false;
        }

        System.out.println(name + "'s turn");
        System.out.println("You have the following tiles: " + extracted);
        System.out.println("Type here:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = null;

        try {
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean key1 = true;
        int i = 0, points = 0;

        while (key1 && i < word.length()) {
            for (i = 0; i < word.length(); i++) {
                boolean key2 = false;
                for (Tile tile : extracted) {
                    if (word.charAt(i) == tile.getLetter()) {
                        key2 = true;
                        points = points + tile.getPoints();
                        break;
                    }
                }

                if (!key2) {
                    key1 = false;
                    break;
                }
            }
        }

        if (!key1) System.out.println("Word has different letters!");

        if (key1 && game.getDictionary().isWord(word)) {
            game.getBoard().addWord(this, word);

            points = points * word.length();
            System.out.println("You gained: " + points + " points.");

            score = score + points;
            System.out.println("Total score is: " + score);

            k = word.length();
        } else {
            System.out.println("Word was not found!");
        }

        // make the player sleep 50 ms
        try {
            sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (game.getBag().getLetters().isEmpty()) {
            running = false;
        }

        return true;
    }

    @Override
    public void run() {
        threadLocal.set(7);

        while (running && !game.stop) {
            waitForOthers(game.getPlayers().indexOf(this));
            if (submitWord()) {
                threadLocal.set(k);
                System.out.println("Next time, you will extract " + threadLocal.get() + " tiles.");
            }
            game.getNextPlayer();
        }

        System.out.println("Game has ended!");

        Player winner = game.getPlayers().get(0);

        for (Player player : game.getPlayers()) {
            if (player.getScore() > winner.getScore())
                winner = player;
        }

        System.out.println(winner.getName() + "has won!");
    }

    private void waitForOthers(int indexOf) {
        synchronized (game) {
            game.notifyAll();
            while (game.getIndex() != indexOf && !game.stop) {
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getScore() {
        return score;
    }
}
