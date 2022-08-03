import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel implements Runnable{
    private boolean running = false;
    Thread gameThread;
    GameBoard gameBoard = new GameBoard();
    StartButton startButton = new StartButton(Constants.SCREEN_WIDTH+Constants.GAP, Constants.GAP, 200, 50, gameBoard);
    int counter = 1;
    public MyPanel(){

        this.setPreferredSize(new Dimension(Constants.SCREEN_WIDTH + Constants.OPTIONS_WIDTH, Constants.SCREEN_HEIGHT));
        this.setBackground(new Color(0xe3dac9));
        this.setDoubleBuffered(true);
        for(int row = 0; row<Constants.NODES_ROWS; row++){
            for(int col = 0; col<Constants.NODES_COLUMNS; col++){
                this.addMouseListener(gameBoard.getBoard()[row][col]);
            }
        }

        this.addMouseListener(startButton);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        Graphics2D g;
        while(gameThread!=null){
            update();
            repaint();
        }
    }
    public void update(){
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int row = 0; row<Constants.NODES_ROWS; row++){
            for(int col = 0; col<Constants.NODES_COLUMNS; col++){
                if(gameBoard.getBoard()[row][col].isAlive()){
                    g2.setColor(Color.black);
                } else {
                    g2.setColor(Color.white);
                }
                g2.fillRect(col*(Constants.NODES_SIZE+Constants.GAP)+Constants.GAP/2, row*(Constants.NODES_SIZE+Constants.GAP)+Constants.GAP/2, Constants.NODES_SIZE, Constants.NODES_SIZE);
            }
        }
        g2.setColor(Color.gray);
        g2.fillRect(startButton.getX(), startButton.getY(), startButton.getWidth(), startButton.getHeight());

    }
}
