package Lab6.homework;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    GameLogic gameLogic;

    public MainFrame() {
        super("Adrian's Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);

        //invoke the layout manager
        pack();

        gameLogic = new GameLogic(this);
    }

    public void createGame() {
        canvas = new DrawingPanel(this);
        add(canvas, CENTER);

        //invoke the layout manager
        pack();

        gameLogic = new GameLogic(this);
    }
}