import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    private int boardWidth = 700, boardHeight = 500;

    private int pFireDelay = 200,eFireDelay = 400;

    Timer timer;
    ArrayList<Entity>entities = new ArrayList<>();

    private long currentMoment,lastMoment,enemyCurrent,enemyLast;

    public Board(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60,this);
        timer.start();

    }

    public void setup(){
        entities.add(0,new Player(boardWidth/2,boardHeight/2,15,15));
        for(int i=0;i<15;i++){
            entities.add(new Enemy(i*20,15));
        }
        enemyLast = System.currentTimeMillis();
    }

    public void shootLaser(){
        currentMoment = System.currentTimeMillis();
        if(currentMoment - lastMoment > pFireDelay){
            entities.add(new Laser((Player)entities.get(0)));
            lastMoment = System.currentTimeMillis();
        }
    }

    public void enemyLaser(){
        enemyCurrent = System.currentTimeMillis();
        if(enemyCurrent-enemyLast>(eFireDelay/2*Math.random())+eFireDelay/2){
            if(entities.size()>1) {
                int enemyChoice;
                do{
                    enemyChoice = ((int) ((entities.size()-1) * Math.random())+1);
                    if(entities.get(enemyChoice)instanceof Enemy) {
                        entities.add(new Laser((Enemy) entities.get(enemyChoice)));
                        enemyLast = System.currentTimeMillis();
                    }
                }while(!(entities.get(enemyChoice)instanceof Enemy));
            }
        }
    }

    public void removeEntities(){
        if(entities.size()>1)
        for(int i=1;i<entities.size();i++){
            if(entities.get(i).toRemove())
                entities.remove(i);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i =0;i<entities.size();i++){
            entities.get(i).paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enemyLaser();
        for(int i=0;i<entities.size();i++)
            entities.get(i).move(getWidth(),getHeight());
        if(Data.isToSwitch()) {
            Data.setToSwitch(false);
            Data.switchDirection();
            for(int i=1;i<entities.size();i++){
                if(entities.get(i) instanceof Enemy)
                    ((Enemy) entities.get(i)).moveDown();
            }
        }
        removeEntities();
        repaint();
    }
}
