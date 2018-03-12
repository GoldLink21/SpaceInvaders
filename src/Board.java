import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    private int boardWidth = 700, boardHeight = 500;

    Timer timer;
    ArrayList<Entity>entities = new ArrayList<>();

    private long currentMoment,lastMoment;

    public Board(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60,this);
        timer.start();

    }

    public void setup(){
        entities.add(0,new Player(boardWidth/2,boardHeight/2,15,15));
    }

    public void shootLaser(){
        currentMoment = System.currentTimeMillis();
        if(currentMoment - lastMoment > 200){
            entities.add(new Laser((Player)entities.get(0)));
            lastMoment = System.currentTimeMillis();
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

        for(int i=0;i<entities.size();i++)
            entities.get(i).move();
        repaint();
    }
}
