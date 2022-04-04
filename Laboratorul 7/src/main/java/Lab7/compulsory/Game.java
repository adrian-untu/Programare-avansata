package Lab7.compulsory;
import java.util.*;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public Board getBoard() {
        return this.board;
    }

    public Bag getBag() {
        return this.bag;
    }
}
