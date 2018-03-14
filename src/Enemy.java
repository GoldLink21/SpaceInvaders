import java.awt.*;

public class Enemy extends Entity{
    private final int SPEED = 5,downAmount = 5;

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
        if(Data.isEnemyRight())
            x+=SPEED;
        else
            x-=SPEED;

        if(x<0&&!Data.isToSwitch()&&!Data.enemyRight) {
            Data.setToSwitch(true);
        }else if(x+width>boardWidth&&!Data.isToSwitch()&&Data.enemyRight) {
            Data.setToSwitch(true);
        }
    }

    public void moveDown(){
        y+=downAmount;
        if(Data.isEnemyRight())
            x-=10;
        else
            x+=10;
    }
}
