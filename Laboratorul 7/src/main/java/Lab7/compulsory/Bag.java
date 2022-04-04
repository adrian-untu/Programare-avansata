package Lab7.compulsory;
import java.util.*;
public class Bag {
    private final List<Tile> letters = new ArrayList<>();
    public Bag() {
        for (char c = 'A'; c < 'Z'; c++) {
            Random random = new Random();
            int points = random.nextInt(10);
            points++;
            letters.add(new Tile(c, points));
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            Random random = new Random();
            int positions = random.nextInt(letters.size());
            extracted.add(letters.get(positions));
            letters.remove(positions);
        }
        return extracted;
    }
}
