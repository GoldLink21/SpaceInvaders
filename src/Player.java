import java.awt.*;

public class Player extends Entity {

    private final int SPEED = 5;

    public Player(int x,int y){super(Color.RED,x,y,30,30);}

    private void drawAndFillPoly(int[]x,int[]y,int n,Color color,Graphics g){
        g.setColor(color);
        g.fillPolygon(x,y,n);
        g.setColor(Color.WHITE);
        g.drawPolygon(x,y,n);
    }

    @Override
    public void paint(Graphics g){

        //Wings
        int xP2[]={x+width/2,x,x+width/2,x+width};
        int yP2[]={y+height/2,y+5*height/4,y+height,y+5*height/4};
        drawAndFillPoly(xP2,yP2,4,Color.GRAY,g);

        //Body
        int xP1[] = {x+width/2,x+width/4,x+3*width/4};
        int yP1[]={y,y+height,y+height};
        drawAndFillPoly(xP1,yP1,3,color,g);
    }

    @Override
    public void move(int boardWidth,int boardHeight){
        if(Data.ispRight()&&x+width<boardWidth)
            x+=SPEED;
        if(Data.ispLeft()&&x>0)
            x-=SPEED;
    }
}
