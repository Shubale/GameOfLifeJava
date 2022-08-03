import java.awt.*;
import java.awt.event.MouseEvent;

public class Node extends Button {
    private GameBoard board;
    private boolean alive;
    private int neighboursNumber;
    private int cordX;
    private int cordY;

    public Node(int x, int y, GameBoard board, boolean alive){
        this.alive = alive;
        this.neighboursNumber = 0;
        this.x = x;
        this.y = y;
        this.width = Constants.NODES_SIZE;
        this.height = Constants.NODES_SIZE;
        this.cordX = x/(Constants.GAP+Constants.NODES_SIZE);
        this.cordY = y/(Constants.GAP+Constants.NODES_SIZE);
        this.board = board;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(this.inBounds(e.getX(), e.getY())){
            this.alive = !this.alive;
            System.out.println("Node (" + cordX + ", " + cordY + ") has " + countNeighbours(board) + " neighbours is " + this.alive);
            //board.printBoard();
        }
    }

    public int countNeighbours(GameBoard board){
        this.neighboursNumber = 0;
        int colStart = cordX - 1, colEnd = cordX + 1;
        int rowStart = cordY - 1, rowEnd = cordY + 1;

        if(cordX == 0)
            colStart = 0;
        if(cordX == Constants.NODES_ROWS - 1)
            colEnd = cordX;

        if(cordY == 0)
            rowStart = 0;
        if(cordY == Constants.NODES_COLUMNS - 1)
            rowEnd = cordY;

        //System.out.println("Selected cords are: " + cordX + ", " + cordY);
        //System.out.println("Selected desitnations are: " + rowStart + ", " + rowEnd + " | " + colStart + ", " + colEnd);
        for(int row = rowStart; row <= rowEnd; row++){
            for(int col = colStart; col <= colEnd; col++){
                //System.out.println("(" + col + ", " + row + ") is " + board.getBoard()[row][col].isAlive());
                if(board.getBoard()[row][col].isAlive()) {
                    //System.out.println("Found neighbour at (" + col + ", " + row + ")");
                    neighboursNumber++;
                }

            }
        }
        if(this.isAlive()){
            neighboursNumber--;
        }
        return neighboursNumber;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setNeighboursNumber(int neighboursNumber) {
        this.neighboursNumber = neighboursNumber;
    }

    public void setBoard(GameBoard gameBoard) { this.board = gameBoard; };

    public boolean isAlive(){
        return alive;
    }

    public int getNeighboursNumber() {
        return neighboursNumber;
    }


}
