package Lab7.homework;

import java.util.*;

public class Game {
    private final Bag bag = new Bag("A-9, B-2, C-2, D-4, E-12, F-2, G-3, H-2, I-9, J-1, K-1, L-4, M-2, N-6, O-8, P-2, Q-1, R-6, S-4, T-6, U-4, V-2, W-2, X-1, Y-2, Z-1");
    private final Board board = new Board();
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    private long startTime;
    private Player currentPlayer;
    private int index;
    private Player winner;
    private Thread t;
    public boolean stop = false;

    public static void main(String[] args) {
        Game game = new Game();

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        game.play();
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        startTime = System.nanoTime();

        index = 0;
        currentPlayer = players.get(index);

        t = new Thread(new Timekeeper());
        t.setDaemon(true);//success is here now
        t.start();

        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public void getNextPlayer() {
        index++;

        if (index == players.size())
            index = 0;

        currentPlayer = players.get(index);

        if(!t.isAlive()) {
            stop = true;
            System.out.println("Time limit reached!");
        }
    }

    public int getIndex() {
        return index;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public long getStartTime() {
        return startTime;
    }
}
