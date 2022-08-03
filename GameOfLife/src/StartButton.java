import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartButton extends Button  {
    private boolean running;
    private GameBoard board;
    private double updatesPerSecond = 1.0;
    StartButton(int x, int y, int width, int height, GameBoard board){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.running = false;
        this.board = board;
    }

    @Override
    public void printButton(){
        if(running){

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.inBounds(e.getX(), e.getY())){
            //board.printBoard();
            //System.out.println("Start button(" + e.getX() + ", " + e.getY() + ")");
            board.updateGameBoard();
        }

    }

}
