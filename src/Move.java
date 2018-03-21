import java.awt.*;

public interface Move {
    void move(int boardWidth,int boardHeight);
    void paint(Graphics g);
    void setPosition(int x,int y);
    Rectangle getBounds();

}
