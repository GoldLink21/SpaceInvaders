import java.awt.*;

public interface Move {
    public void move();
    public void paint(Graphics g);
    public void setPosition(int x,int y);
    public Rectangle getBounds();

}
