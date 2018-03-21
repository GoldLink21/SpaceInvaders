import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame{

    static Board board;

    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setResizable(false);
        setVisible(true);
        setTitle("Space Invaders");
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    Data.setSpacePressed(true);
                    if(Data.isPlay())
                        board.shootLaser();
                }if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    Data.setPLeft(true);
                }if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    Data.setPRight(true);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    Data.setPRight(false);
                }if(e.getKeyCode()==KeyEvent.VK_LEFT) {
                    Data.setPLeft(false);
                }if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    Data.setSpacePressed(false);
                    if (Data.isMenu() || Data.isEnd()) {
                        if(Data.isMenu())
                            board.setup();
                        Data.toggleMenu();
                    }
                }if(e.getKeyCode()==KeyEvent.VK_P&&!(Data.isMenu()||Data.isEnd()))
                    Data.togglePause();
            }

        });
    }

    public static void main(String[]args){
        new Game();
    }
}
