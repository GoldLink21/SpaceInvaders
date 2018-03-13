import java.awt.*;

public class Enemy extends Entity{
    public Enemy(int x,int y){
        super(Color.BLUE,x,y,15,15);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawOval(x,y,width,height);
    }

    //@Override
    //public void setPosition(int x,int y){ }

    @Override
    public void move(int boardWidth, int boardHeight){

    }
}
