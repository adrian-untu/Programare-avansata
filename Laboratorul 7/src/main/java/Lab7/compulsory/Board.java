package Lab7.compulsory;
import java.util.*;
public class Board {
    private final List<String> board = new ArrayList<>();

    public synchronized void addWord(Player player, String word) {
        board.add(word);
        System.out.println(player.getName() + ": " + word);
    }
}