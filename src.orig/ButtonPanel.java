import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ButtonPanel extends JPanel {
    JButton playPause;
    String play;
    String pause;
    GameBoard board;
    JSlider speedSlider;
    JLabel speedText;
    JPanel sliderPanel;
    JPanel counterPanel;
    JLabel iterationCounter;
    int speedMin = 10;
    int speedMax = 100;
    int speedDefault = 50;

    public ButtonPanel(GameBoard board) {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10,10,10,10));
        this.setBackground(Color.pink);

        this.board = board;

        this.playPause = new JButton();
        this.play = "   Play Game   ";
        this.pause = " Pause Game ";

        this.playPause.setText(play);
        this.playPause.setFont(playPause.getFont().deriveFont(18f));
        this.playPause.setOpaque(false);


        this.speedSlider = new JSlider(JSlider.HORIZONTAL, speedMin, speedMax, speedDefault);

        this.add(playPause, BorderLayout.CENTER);
        this.add(sliderPanel(), BorderLayout.EAST);
        this.add(counterPanel(), BorderLayout.WEST);

        playPauseActions();
        speedSliderActions();
    }

    private void playPauseActions() {
        this.playPause.addActionListener(e -> {
            if (playPause.getText() == play) {
                playPause.setText(pause);
                board.run(true);
            } else {
                board.run(false);
                playPause.setText(play);
            }
        });
    }

    private void speedSliderActions() {
        this.speedSlider.addChangeListener(e -> {
            board.changeSpeed(this.speedSlider.getValue());
        });
    }

    private JPanel sliderPanel() {
        this.sliderPanel = new JPanel();
        this.sliderPanel.setLayout(new BorderLayout());
        this.sliderPanel.setBorder(new EmptyBorder(5,100,5,5));
        this.sliderPanel.setOpaque(false);

        this.speedSlider.setMajorTickSpacing(10);
        this.speedSlider.setMinorTickSpacing(5);
        this.speedSlider.setOpaque(false);

        this.speedText = new JLabel("   Change Game Speed ");
        this.speedText.setForeground(Color.black);
        this.speedText.setFont(speedText.getFont().deriveFont(18f));

        this.sliderPanel.add(speedSlider, BorderLayout.CENTER);
        this.sliderPanel.add(speedText, BorderLayout.SOUTH);

        return this.sliderPanel;
    }

    private JPanel counterPanel() {
        this.counterPanel = new JPanel();
        this.counterPanel.setLayout(new BorderLayout());
        this.counterPanel.setBorder(new EmptyBorder(5,5,5,130));
        this.counterPanel.setOpaque(false);

        JLabel counterLabel = new JLabel("Iteration Counter: ");
        counterLabel.setFont(playPause.getFont().deriveFont(18f));
        this.iterationCounter = new JLabel("0");
        this.iterationCounter.setFont(playPause.getFont().deriveFont(18f));


        this.counterPanel.add(counterLabel, BorderLayout.WEST);
        this.counterPanel.add(this.iterationCounter, BorderLayout.CENTER);

        return this.counterPanel;

    }

    public void updateIterationCounter(int count) {
        this.iterationCounter.setText(Integer.toString(count));
    }
}
