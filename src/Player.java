import java.awt.*;

public class Player extends Entity {

    private final int SPEED = 5;

    public Player(int x,int y,int width,int height){
        super(Color.RED,x,y,width,height);
    }

    @Override
    public void paint(Graphics g){
        //Lower bound
        g.setColor(Color.GRAY);
        g.fillRect(x,y+3*height/4,width,height/4);
        g.setColor(Color.WHITE);
        g.drawRect(x,y+3*height/4,width,height/4);

        //Center Box
        g.setColor(color);
        g.fillRect(x+width/4,y+height/5,width/2,height);
        g.setColor(Color.WHITE);
        g.drawRect(x+width/4,y+height/5,width/2,height);


        //Vertical Box
        g.setColor(Color.GRAY);
        g.fillRect(x+(7*width/16),y-height/4,width/8,3*height/2);
        g.setColor(Color.WHITE);
        g.drawRect(x+(7*width/16),y-height/4,width/8,3*height/2);


    }

    @Override
    public void move(int boardWidth,int boardHeight){
        if(Data.ispRight()&&x+width<boardWidth)
            x+=SPEED;
        if(Data.ispLeft()&&x>0)
            x-=SPEED;
    }
}
