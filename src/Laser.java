import java.awt.*;

public class Laser extends Entity{
    private final int SPEED = 5,pWidth=5,pHeight=15,eWidth=5,eHeight=5;

    private int type;

    private int[][]laserCoords={{x,x+pWidth,x+pWidth/2},{y+pHeight,y+pHeight,y}};

    public Laser(Player player){
        super(Color.GREEN,player.getX()+(player.getWidth()/2)-3,player.getY()-20,5,15);
        type=0;
    }

    public Laser(Enemy enemy){
        super(Color.CYAN,enemy.getX()+enemy.getWidth()/4,enemy.getY(),5,5);
        type=1;
    }

    public int getType(){return type;}

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
        g.setColor(color);
        
        g.fillRect(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawRect(x,y,width,height);

        //g.fillPolygon(laserCoords[0],laserCoords[1],3);
    }
}
