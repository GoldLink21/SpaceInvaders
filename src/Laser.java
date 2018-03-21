import java.awt.*;

public class Laser extends Entity{
    private final int SPEED = 5,pWidth=5,pHeight=15,eWidth=5,eHeight=5;

    private int type;

    public Laser(Player player){
        super(Color.GREEN,player.getX()+(player.getWidth()/2),player.getY()-10,8,15);
        type=0;
    }

    public Laser(Enemy enemy){
        super(Color.CYAN,enemy.getX()+enemy.getWidth()/2,enemy.getY(),8,8);
        type=1;
    }

    public int getType(){return type;}

    @Override
    public Rectangle getBounds(){
        if(type==0)
            return new Rectangle(x-width/2,y-height,width,height);
        else
            return new Rectangle(x-width/2,y,width,height);
    }

    @Override
    public void move(int boardWidth,int boardHeight){
        if(type==0)
            this.y-=SPEED;
        else if(type==1)
            this.y+=SPEED;

        if(y<0||y+height>boardHeight)
            toRemove=true;
    }

    @Override
    public void paint(Graphics g){
        int nPoints = 3;
        int xPoints[] = {x,x-width/2,x+width/2};
        int yPoints[]={y+height,y,y};

        if(type==0) yPoints[0]=y-height;

        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, nPoints);
        g.setColor(Color.WHITE);
        g.drawPolygon(xPoints, yPoints, nPoints);
    }
}
