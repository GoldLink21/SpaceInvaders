import java.awt.*;

public class Laser extends Entity{
    private final int SPEED = 5;

    private int type;

    public Laser(Player player){
        super(Color.GREEN,player.getX(),player.getY(),10,5);
        type=0;
    }

    public Laser(Enemy enemy){
        super(Color.CYAN,enemy.getX(),enemy.getY(),10,5);
        type=1;
    }

    @Override
    public void move(){
        if(type==0)
            this.y-=SPEED;
        else if(type==1)
            this.y+=SPEED;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawRect(x,y,width,height);
    }
}
