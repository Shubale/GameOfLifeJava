import javax.swing.*;
import java.awt.Graphics2D;


public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Game of Life");

        MyPanel gamePanel = new MyPanel();

        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }
}
