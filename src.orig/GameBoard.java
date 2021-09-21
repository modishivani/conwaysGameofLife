import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel implements ActionListener {
    int rows = 45;
    int cols = 60;
    int cellSize = 16;
    Grid grid;
    Timer timer;
    private int speed;
    boolean run;
    int counter;
    GameFrame gf;

    public GameBoard(GameFrame frame) {
        this.gf = frame;
        this.setBackground(Color.BLACK);
        this.grid = new Grid(rows, cols);
        this.counter = 0;

        this.speed = 40;
        this.timer = new Timer(1000 - (this.speed * 10), this);
        this.timer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.grid.paint(g, cellSize);
    }

    public void run(Boolean r) {
        this.run = r;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (run) {
            this.repaint();
            this.grid.advance();
            counter++;
            gf.buttonPanel.updateIterationCounter(counter);
        }
    }

    public void changeSpeed(int value) {
        this.speed = value;
        this.timer.setDelay(1000 - (this.speed * 10));
    }
}
