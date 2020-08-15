package gamemap;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameMap extends JFrame {

    public GameMap() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new board());
        
        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 420);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new GameMap();
            ex.setVisible(true);
        });
    }
}