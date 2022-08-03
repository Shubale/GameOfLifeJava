import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button implements MouseListener {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    public void printButton(){}

    public boolean inBounds(int mouseX, int mouseY){
        return mouseY > y && mouseY < y + height && mouseX > x && mouseX < x + width;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
}
