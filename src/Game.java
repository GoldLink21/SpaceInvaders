import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame{

    Board board;

    public boolean left,right;

    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
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
                    board.shootLaser();
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                super.keyReleased(e);

            }
        });

    }

    public static void main(String[]args){
        Game game = new Game();
        game.board.setup();
    }
}
