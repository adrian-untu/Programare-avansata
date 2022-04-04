package Lab6.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    public int[][] matrix;
    int stoneSize = 20;
    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics
    int counter = 0;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    final void init(int rows, int cols) {
        matrix = new int[frame.configPanel.getRows()][frame.configPanel.getCols()];
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        paintGrid();
        graphics.drawImage(image, 0, 0, this);
    }

    public void paintSticks(Node o1, Node o2) {
        offscreen.setStroke(new BasicStroke(3));

        offscreen.setColor(Color.BLACK);

        int x1, y1, x2, y2;

        x1 = padX + o1.getCol() * cellWidth;
        y1 = padY + o1.getRow() * cellHeight;

        if (o1.getRow() == o2.getRow()) {
            x2 = x1 + cellWidth;
            y2 = y1;
        } else {
            x2 = x1;
            y2 = y1 + cellHeight;
        }

        offscreen.drawLine(x1, y1, x2, y2);

        offscreen.setStroke(new BasicStroke(0));
    }

    public void paintStones(int x, int y) {
        counter++;
        switch(counter%2){
            case 0:
                offscreen.setColor(Color.RED);
                break;
            case 1:
                offscreen.setColor(Color.BLUE);
                break;
            default:
        }

        x = x / cellWidth;
        y = y / cellHeight;

        int a = padX + x * cellWidth;
        int b = padY + y * cellHeight;

        offscreen.fillOval(a - stoneSize / 2, b - stoneSize / 2, stoneSize, stoneSize);
    }

    private void paintGrid() {
        offscreen.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            offscreen.drawLine(x1, y1, x2, y1);
        }
        //vertical lines
        for (int columns = 0; columns < cols; columns++) {
            int y1 = padY;
            int x1 = padX + columns * cellWidth;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x1, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }
}
