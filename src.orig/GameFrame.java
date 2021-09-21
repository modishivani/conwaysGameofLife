import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    GameBoard gameBoard;
    ButtonPanel buttonPanel;

    public GameFrame() {
        super();

        //name
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(974,827);


        this.setLayout(new BorderLayout());
        this.gameBoard = new GameBoard(this);
        this.add(this.gameBoard, BorderLayout.CENTER);

        this.buttonPanel = new ButtonPanel(gameBoard);
        this.add(this.buttonPanel, BorderLayout.SOUTH);


        this.showFrame();
    }

    public void showFrame() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }
}
