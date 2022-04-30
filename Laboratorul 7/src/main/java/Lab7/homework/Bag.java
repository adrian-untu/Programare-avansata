package Lab7.homework;

import java.util.*;

public class Bag {
    private final List<Tile> letters = new ArrayList<>(); // declare a collection for tiles
    private String sequence;

    public Bag(String sequence) {
        int i = 0;
        while(i < sequence.length()-3){
            char a = sequence.charAt(i);
            if(Character.isDigit(sequence.charAt(i+3))){
                int points = Character.getNumericValue(sequence.charAt(i+2)) * 10 + Character.getNumericValue(sequence.charAt(i+3));
                letters.add(new Tile(a, points));
                i += 6;
            }
            else {
                int points = Character.getNumericValue(sequence.charAt(i + 2));
                letters.add(new Tile(a, points));
                i += 5;
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }

            int rand = new Random().nextInt(letters.size());

            extracted.add(letters.get(rand));
            letters.remove(rand);
        }
        return extracted;
    }

    public List<Tile> getLetters() {
        return letters;
    }
}
