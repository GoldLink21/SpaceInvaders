import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private int boardWidth = 500, boardHeight = 500;
    public Board(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.BLACK);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
        setTitle("Space Invaders");
        setLocationRelativeTo(null);
    }
}
