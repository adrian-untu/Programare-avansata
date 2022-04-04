package Lab6.homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ControlPanel extends JPanel{
    final MainFrame frame;
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton exit = new JButton("Exit");

    //create all buttons (Load, Exit, etc.)
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(load);
        add(save);
        add(exit);
        exit.addActionListener(this::exitGame);
        save.addActionListener(this::saveAsPNG);
    }

    private void saveAsPNG(ActionEvent actionEvent) {
        RenderedImage renderedImage = frame.canvas.image;

        File file = new File("./MyGame.png");

        try {
            ImageIO.write(renderedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
