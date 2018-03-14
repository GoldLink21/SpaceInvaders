import java.awt.*;

public class Player extends Entity {

    private final int SPEED = 5;

    public Player(int x,int y,int width,int height){
        super(Color.RED,x,y,width,height);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawRect(x,y,width,height);
    }

    @Override
    public void move(int boardWidth,int boardHeight){
        if(Data.ispRight()&&x+width<boardWidth)
            x+=SPEED;
        if(Data.ispLeft()&&x>0)
            x-=SPEED;
    }
}
