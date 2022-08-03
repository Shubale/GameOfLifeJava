import java.lang.reflect.Array;
import java.util.Arrays;

public class GameBoard {
    private Node[][] board;
    public GameBoard(){
        board = new Node[Constants.NODES_COLUMNS][Constants.NODES_ROWS];
        for(int row = 0; row<Constants.NODES_ROWS; row++){
            for(int col = 0; col<Constants.NODES_COLUMNS; col++){
                board[row][col] = new Node(col*(Constants.GAP+Constants.NODES_SIZE), row*(Constants.GAP+Constants.NODES_SIZE), this, false);
            }
        }
    }
    public void updateGameBoard(){
        Node[][] newBoard = new Node[Constants.NODES_COLUMNS][Constants.NODES_ROWS];
        for(int row = 0; row<Constants.NODES_ROWS; row++){
            for(int col = 0; col<Constants.NODES_COLUMNS; col++){
                //System.out.print(board[row][col].countNeighbours(this));
                if(board[row][col].isAlive()){
                    if(board[row][col].countNeighbours(this) == 2 || board[row][col].countNeighbours(this) == 3) {
                        newBoard[row][col] = new Node(col*(Constants.GAP+Constants.NODES_SIZE), row*(Constants.GAP+Constants.NODES_SIZE), this, true);
                    } else {
                        newBoard[row][col] = new Node(col*(Constants.GAP+Constants.NODES_SIZE), row*(Constants.GAP+Constants.NODES_SIZE), this, false);
                    }
                } else {
                    if(board[row][col].countNeighbours(this) == 3) {
                        newBoard[row][col] = new Node(col*(Constants.GAP+Constants.NODES_SIZE), row*(Constants.GAP+Constants.NODES_SIZE), this, true);
                    } else {
                        newBoard[row][col] = new Node(col*(Constants.GAP+Constants.NODES_SIZE), row*(Constants.GAP+Constants.NODES_SIZE), this, false);
                    }
                }
            }
            //System.out.println();
        }
        for(int row = 0; row<Constants.NODES_ROWS; row++){
            for(int col = 0; col<Constants.NODES_COLUMNS; col++){
                this.board[row][col].setAlive(newBoard[row][col].isAlive());
            }
        }
    }

    public void printBoard(){
        for(int row = 0; row<Constants.NODES_ROWS; row++){
            for(int col = 0; col<Constants.NODES_COLUMNS; col++){
                System.out.print(board[row][col].isAlive()+" ");
            }
            System.out.println();
        }
    }
    public void setBoard(Node[][] nodesArray) {
        this.board = nodesArray;
    }

    public Node[][] getBoard() {
        return board;
    }
}
