import java.awt.*;

public interface Move {
    public void move(int boardWidth,int boardHeight);
    public void paint(Graphics g);
    public void setPosition(int x,int y);
    public Rectangle getBounds();

}
