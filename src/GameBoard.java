import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JPanel implements ActionListener, MouseListener {
    int rows = 45;
    int cols = 60;
    int cellSize = 16;
    Grid grid;
    Timer timer;
    private int speed;
    boolean run;
    GameFrame gf;

    public GameBoard(GameFrame frame) {
        this.gf = frame;
        this.setBackground(Color.BLACK);
        this.grid = new Grid(rows, cols);

        this.speed = 40;
        this.timer = new Timer(1000 - (this.speed * 10), this);
        this.timer.start();
        this.addMouseListener(this);

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
            this.gf.buttonPanel.iterateCounter();
        }
    }

    public void changeSpeed(int value) {
        this.speed = value;
        this.timer.setDelay(1000 - (this.speed * 10));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        int col = p.x/cellSize;
        int row = p.y/cellSize;
        Cell c = this.grid.getCell(row, col);
        if (c.isAlive()) {
            c.setCurrentGen(false);
        } else {
            c.setCurrentGen(true);
        }

        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void reset() {

    }
}
