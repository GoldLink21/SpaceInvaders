import javax.swing.*;

public class Game extends JPanel{
    Board board;
    public Game(){
        
        board = new Board();
        add(board);
    }
}
