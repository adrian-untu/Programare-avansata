package Lab7.compulsory;

public class Tile {
    private final char letter;
    private final int points;

    @Override
    public String toString() {
        return letter +
                " - " + points;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    public Tile(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

}
