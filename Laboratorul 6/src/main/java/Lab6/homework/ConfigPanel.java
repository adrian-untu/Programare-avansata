package Lab6.homework;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner[] spinners = new JSpinner[2];
    JButton button;
    JButton create = new JButton("Create");
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinners[0] = new JSpinner(new SpinnerNumberModel(5, 2, 100, 1));

        //create spinners for rows and cols, and the button
        spinners[1] = new JSpinner(new SpinnerNumberModel(5, 2, 100, 1));
        button = new JButton("Create");

        add(label); //JPanel uses FlowLayout by default

        for (JSpinner spinner : spinners) {
            add(spinner);
        }

        add(button);

        button.addActionListener(this::newGame);
    }

    public int getRows() {
        return (int) spinners[0].getValue();
    }

    public int getCols() {
        return (int) spinners[1].getValue();
    }

    private void newGame(ActionEvent e) {
        frame.remove(frame.canvas);
        frame.createGame();
    }

}