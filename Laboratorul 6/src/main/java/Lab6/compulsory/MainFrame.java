package Lab6.compulsory;

import javax.swing.*;
import java.awt.*;
import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    JInternalFrame frame;
    int rows, cols;
    public MainFrame(int rows, int cols) {
        super("Adrian's drawing app");
        this.rows = rows;
        this.cols = cols;
        init(rows, cols);
    }

    private void init(int rows, int cols) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this, rows, cols);
        configPanel = new ConfigPanel(this, rows, cols);
        controlPanel = new ControlPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(controlPanel,BorderLayout.SOUTH);
        pack();
    }
}
