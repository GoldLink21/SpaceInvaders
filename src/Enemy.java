import java.awt.*;

public class Enemy extends Entity{
    public Enemy(int x,int y,int width,int height){
        super(Color.BLUE,x,y,width,height);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawOval(x,y,width,height);
    }
}
