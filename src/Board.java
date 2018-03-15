import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    private int boardWidth = 700, boardHeight = 500;

    private int pFireDelay = 350,eFireDelay = 800;

    private final int ROWS = 5,COL = 15;

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
        for(int i=0;i<entities.size();i++){
            entities.remove(i);
        }
        Data.setLives(4);
        entities.add(0,new Player(boardWidth/2,boardHeight-40,15,15));
        for(int i=0;i<ROWS;i++) {
            for (int j = 0; j < COL; j++) {
                entities.add(new Enemy(j * 25, (i + 1) * 25));
            }
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

    public boolean checkEnd(){
        if(Data.getLives()<1) {
            for(int i=0;i<entities.size();i++)
                entities.remove(i);
            return true;
        }for(int i=1;i<entities.size();i++)
            if(entities.get(i)instanceof Enemy)
                return false;
        return true;
    }

    public void removeEntities(){
        if(entities.size()>1)
            for(int i=1;i<entities.size();i++)
                if(entities.get(i).toRemove())
                    entities.remove(i);
    }

    public void checkCollisions(){

        //Player Laser and Enemies
        for(int i=1;i<entities.size();i++) {
            for (int j = 1; j < entities.size(); j++)
                if ((i != j) && (entities.get(i) instanceof Enemy) && (entities.get(j) instanceof Laser))
                    if (entities.get(i).collidesWith(entities.get(j)))
                        if (((Laser) entities.get(j)).getType() == 0) {
                            entities.get(j).setToRemove();
                            entities.get(i).setToRemove();
                            eFireDelay += 5;
                        }
        }

        //Player and Enemy Laser
        for(int i=1;i<entities.size();i++) {
            if(entities.get(i)instanceof Laser&&((Laser) entities.get(i)).getType()==1){
                if(entities.get(i).collidesWith(entities.get(0))){
                    Data.decreaseLives();
                    entities.remove(i);
                }
            }
        }

    }

    public void getEnemyY(){
        Data.setEnemyLowY(0);
        for(int i=1;i<entities.size();i++){
            if(entities.get(i)instanceof Enemy){
                if(entities.get(i).getY()>Data.getEnemyLowY()){
                    Data.setEnemyLowY(entities.get(i).getY());
                }
            }
        }
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        g2d.drawString(s, width/2 - stringLen/2 + XPos, YPos);
    }

    private void printCentered(String s,Font font,int y,Graphics g){
        g.setFont(font);
        printSimpleString(s,getWidth(),0,y,g);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font titleFont = new Font("TimesRoman",Font.PLAIN,35);
        Font subTitleFont = new Font("TimesRoman",Font.PLAIN,20);
        if(Data.isPlay()) {
            for (int i = 0; i < entities.size(); i++)
                entities.get(i).paint(g);
            g.setFont(subTitleFont);
            g.drawString("Lives: "+Integer.toString(Data.getLives()),10,15);
        }else if(Data.isMenu()){
            printCentered("Menu",titleFont,getHeight()/4,g);
        }else if(Data.isPause()){
            printCentered("Pause",titleFont,getHeight()/4,g);
        }else if(Data.isEnd()){
            printCentered("End",titleFont,getHeight()/4,g);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Data.isPlay()) {
            enemyLaser();
            for (int i = 0; i < entities.size(); i++)
                entities.get(i).move(getWidth(), getHeight());
            if (Data.isToSwitch()) {
                Data.setToSwitch(false);
                Data.switchDirection();
                for (int i = 1; i < entities.size(); i++)
                    if (entities.get(i) instanceof Enemy)
                        ((Enemy) entities.get(i)).moveDown();
            }
            checkCollisions();
            removeEntities();
            getEnemyY();
            if(checkEnd())
                Data.toggleEnd();
        }
        repaint();
    }
}
