package Lab6.compulsory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel label;
    JSpinner spinner_rows,spinner_columns;
    int rows, cols;
    JButton create = new JButton("Create");
    public ConfigPanel(MainFrame frame, int rows, int cols) {
        this.frame = frame;
        this.rows = rows;
        this.cols = cols;
        init(rows, cols);
    }
    private void init(int rows, int cols) {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinner_rows = new JSpinner(new SpinnerNumberModel(rows, 2, 100, 1));
        spinner_columns= new JSpinner(new SpinnerNumberModel(cols, 2, 100, 1));

        //create spinners for rows and cols, and the button
        add(label); //JPanel uses FlowLayout by default
        add(spinner_rows);
        add(spinner_columns);
        add(create);
        create.addActionListener(this::newGame);
    }
    private void newGame(ActionEvent e) {
        frame.dispose();
        frame = new MainFrame((Integer) spinner_rows.getValue(), (Integer) spinner_columns.getValue());
        frame.setVisible(true);
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

}
