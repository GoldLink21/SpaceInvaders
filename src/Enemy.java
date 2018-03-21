import java.awt.*;

public class Enemy extends Entity{
    private final int SPEED = 4,downAmount = 15;

    public Enemy(int x,int y){super(Color.BLUE,x,y,15,15);}

    private void drawAndFillPoly(int[]x,int[]y,int n,Color color,Graphics g){
        g.setColor(color);
        g.fillPolygon(x,y,n);
        g.setColor(Color.WHITE);
        g.drawPolygon(x,y,n);
    }

    public void moveDown(int boardHeight){
        if(Data.getEnemyLowY()<3*boardHeight/4)
            y+=downAmount;
        if(Data.isEnemyRight())
            x-=10;
        else
            x+=10;
    }

    @Override
    public void move(int boardWidth, int boardHeight){
        if(Data.isEnemyRight())
            x+=SPEED;
        else
            x-=SPEED;

        if(x<0&&!Data.isToSwitch()&&!Data.isEnemyRight()){
            Data.setToSwitch(true);
        }else if(x+width>boardWidth&&!Data.isToSwitch()&&Data.isEnemyRight()){
            Data.setToSwitch(true);
        }
    }

    @Override
    public void paint(Graphics g){
        fancyShip(g);
    }

    private void simpleCircle(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,width,height);
        g.setColor(Color.WHITE);
        g.drawOval(x,y,width,height);
    }

   private void fancyShip(Graphics g){
        //Wings
       int xP2[]={x+width/2,x,x+width/2,x+width};
       int yP2[]={y-height/2,y-5*height/4,y-height,y-5*height/4};
       drawAndFillPoly(xP2,yP2,4,Color.GRAY,g);

       //Body
       int xP1[] = {x+width/2,x+width/4,x+3*width/4};
       int yP1[]={y,y-height,y-height};
       drawAndFillPoly(xP1,yP1,3,color,g);
   }


}
