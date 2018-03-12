import java.awt.*;

public class Entity implements Move{
    int x,y,width,height;
    Color color;

    public Entity(Color color,int x, int y, int width, int height){
        setPosition(x,y);
        this.color = color;
        this.width=width;
        this.height=height;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    @Override
    public void move() {

    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void setPosition(int x, int y){
        this.x=x-width/2;
        this.y=y-height/2;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
