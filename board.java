package gamemap;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class board extends JPanel implements ActionListener {

    private Dimension d;
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

    private final Color dotColor = new Color(192, 192, 0);
    private Color mazeColor;

    private Image ii;
    private int score;
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    private final short levelData[] = {
        19, 26, 18, 26, 18, 18, 18, 26, 18, 18, 26, 26, 26, 26, 22,
        21, 0, 21, 0, 17, 16, 20, 0, 17, 20, 0, 0, 0, 0, 21,
        17, 26, 16, 26, 16, 16, 20, 0, 17, 20, 0, 19, 18, 26, 20,
        21, 0, 21, 0, 17, 16, 20, 0, 17, 20, 0, 25, 28, 0, 21,
        17, 18, 16, 18, 16, 16, 20, 0, 17, 20, 0, 0, 0, 0, 21,
        17, 24, 24, 24, 24, 24, 28, 0, 25, 24, 18, 18, 18, 18, 20,
        21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 24, 24, 24, 20,
        17, 18, 18, 18, 18, 18, 22, 0, 19, 22, 0, 0, 0, 0, 21,
        17, 16, 16, 16, 16, 16, 20, 0, 17, 16, 18, 18, 22, 0, 21,
        17, 24, 24, 24, 24, 16, 20, 0, 17, 16, 24, 24, 28, 0, 21,
        21, 0, 0, 0, 0, 17, 16, 26, 16, 20, 0, 0, 0, 0, 21,
        17, 18, 18, 22, 0, 17, 28, 0, 25, 16, 18, 18, 22, 0, 21,
        17, 24, 24, 28, 0, 21, 0, 0, 0, 17, 24, 24, 28, 0, 21,
        21, 0, 0, 0, 0, 17, 22, 0, 19, 20, 0, 0, 0, 0, 21,
        25, 26, 26, 26, 26, 24, 24, 26, 24, 24, 26, 26, 26, 26, 28
    };

    private short[] screenData;
    private Timer timer;

    public board() {

        initVariables();
        initBoard();
    }
    
    private void initBoard() {

        setFocusable(true);

        setBackground(Color.black);
    }

    private void initVariables() {

        screenData = new short[N_BLOCKS * N_BLOCKS];
        mazeColor = new Color(0, 0, 255);
        d = new Dimension(400, 400);
        
        timer = new Timer(40, this);
        timer.start();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        initGame();
    }

    private void drawScore(Graphics2D g) {

        String s;

        g.setFont(smallFont);
        g.setColor(new Color(50, 205, 50));
        s = "Score: " + score;
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);
    }
  
    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(mazeColor);
                g2d.setStroke(new BasicStroke(2));

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(dotColor);
                    g2d.fillRect(x + 11, y + 11, 2, 2);
                }

                i++;
            }
        }
    }

    private void initGame() {

        score = 0;
        initLevel();
    }

    private void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, d.width, d.height);

        drawMaze(g2d);
        drawScore(g2d);

        g2d.drawImage(ii, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
