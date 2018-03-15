import java.awt.*;

public class Player extends Entity {

    private final int SPEED = 5;

    public Player(int x,int y,int width,int height){
        super(Color.RED,x,y,width,height);
    }

    @Override
    public void paint(Graphics g){
        //Lower bound
        g.setColor(color);
        g.fillRect(x-width/2,y+3*height/4,2*width,height/4);
        g.setColor(Color.WHITE);
        g.drawRect(x-width/2,y+3*height/4,2*width,height/4);

        //Center Box
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawRect(x,y,width,height);

        //Vertical Box
        g.setColor(color);
        g.fillRect(x+width/2,y+height/2,width/4,3*height/2);
        g.setColor(Color.WHITE);
        g.drawRect(x+width/2,y+height/2,width/4,3*height/2);

    }

    @Override
    public void move(int boardWidth,int boardHeight){
        if(Data.ispRight()&&x+width<boardWidth)
            x+=SPEED;
        if(Data.ispLeft()&&x>0)
            x-=SPEED;
    }
}
