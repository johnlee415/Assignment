package client;
import ADT.ArrayQueuePacman;
import ADT.LinkedListPacman;
import ADT.LinkedQueueMap;
import entity.Enemy;
import entity.Player;
import entity.Map;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class tBoard extends JPanel implements KeyListener{
    private Dimension d;
   
    private final Color dotColor = new Color(192, 192, 0);
    private Color mazeColor;

    private Image ii;
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private boolean levelEnd = false;
    
    private boolean inGame = true;
    private boolean dying = false;
    private final int MAX_GHOSTS = 8;
    private int N_GHOSTS = 2;
    private int[] dx, dy;
    private int ghostSpeeds = 1;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy;
    private Image ghost;
    private int currentSpeed = 1;
    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private int xAxisG= 0 * BLOCK_SIZE;
    private int yAxisG = 0 * BLOCK_SIZE;
    Enemy g = new Enemy();    
    public int widthOfScene = 510;
    
    

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
    
    private final short levelData1[] = {
        19, 26, 26, 26, 18, 18, 22, 0,  19, 18, 18, 26, 26, 26, 22,
        21, 0,  0,  0,  17, 16, 20, 0,  17, 16, 20,  0,  0,  0, 21,
        21, 0,  19, 26, 16, 16, 20, 0,  17, 16, 16, 26, 22,  0, 21,
        21, 0,  21,  0, 17, 16, 20, 0,  17, 16, 20,  0, 21,  0, 21,
        21, 0,  17, 26, 16, 16, 20, 0,  17, 16, 16, 26, 20,  0, 21,
        21, 0,  21,  0, 17, 16, 16,26,  16, 16, 20,  0, 21,  0, 21,
        21, 0,  21,  0, 17, 16, 16,21,  16, 16, 20,  0, 21,  0, 21,
        17, 26, 20,  0, 17, 24, 28, 0,  25, 24, 20,  0, 17, 26, 20,
        21, 0,  21,  0, 21,  0,  0, 0,   0,  0, 21,  0, 21,  0, 21,
        21, 0,  21,  0, 17, 18, 22, 0,  19, 18, 20,  0, 21,  0, 21,
        21, 0,  17, 26, 16, 16, 16,26,  16, 16, 16, 26, 20,  0, 21,
        21, 0,  21,  0, 17, 16, 20, 0,  17, 16, 20,  0, 21,  0, 21,
        21, 0,  25, 26, 16, 16, 20, 0,  17, 16, 16, 26, 28,  0, 21,
        21, 0,  0,   0, 17, 16, 20, 0,  17, 16, 20,  0,  0,  0, 21,
        25, 26, 26, 26, 24, 24, 28, 0,  25, 24, 24, 26, 26, 26, 28};
    
    
    private short[] screenData;
    
    
    private ImageIcon pacmanUp = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\up.png");
    private ImageIcon pacmanDown = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\down.png");
    private ImageIcon pacmanRight = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\right.png");
    private ImageIcon pacmanLeft = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\left.png");
    private ImageIcon ghostImg= new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\left.png");
    private int pacman_x = 0 * BLOCK_SIZE;
    private int pacman_y = 0 * BLOCK_SIZE;
    private int pacmand_x, pacmand_y;
    private int req_dx, req_dy, view_dx, view_dy;
    private final int speed = 1;

    LinkedListPacman dotList = new LinkedListPacman();
    
    
    ArrayQueuePacman<Player> pacman = new ArrayQueuePacman<Player>();
    
    
    LinkedQueueMap<Map> map = new LinkedQueueMap<Map>();
    
    
    
    
    public tBoard() {
       
        initVariables();
        initBoard();
        
        this.setFocusable(true);
        this.addKeyListener(this);
        
    }
    
    private void initBoard() {
        setFocusable(true);
        setBackground(Color.black);
    }

    private void initVariables() {
        
        for ( int i = 0; i < pacman.getLength(); i ++ )
        {
            pacman.enqueue(new Player( pacman_x, pacman_y, "C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\right.png", true, speed));
        }
        
        for (int i = 0; i < levelData.length; i++)
        {
            map.enqueue(new Map(levelData[i]));
        }
        
        
        screenData = new short[N_BLOCKS * N_BLOCKS];
        mazeColor = new Color(0, 0, 225); 
        d = new Dimension(400, 400);
        
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeeds = 1;
        dx = new int[4];
        dy = new int[4];

    }

    @Override
    public void addNotify() {
        super.addNotify();
        initGame();
    }

    private void checkMaze() {
        boolean finished = true;

        if(dotList.chckAllEaten(1))
        {
            finished = false;
        }
        else 
        {
            dotList.clear();
            map.clear();
            nextLevel();
            initGame();
       }
    }
    
    private void nextLevel(){
        for (int i = 0; i < levelData1.length; i++)
        {
            map.enqueue(new Map(levelData1[i]));
        }
        levelEnd = true;
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
        int dx = 1;
        for (short a = 0; a < N_GHOSTS; a++) {
            ghost_y[a] = 4 * BLOCK_SIZE;
            ghost_x[a] = 4 * BLOCK_SIZE;
            ghost_dy[a] = 0;
            ghost_dx[a] = dx;
            dx = -dx;
            ghostSpeeds = 1;
        }
        N_GHOSTS = 2;
        currentSpeed = 1;
        
        
        for (int i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            
            screenData[i] = map.getFront().getArray();
            map.dequeue();
            
            
            if(screenData[i] / 16 == 1 )
            {
                dotList.storeDots(1);
            }
            else{
                dotList.storeDots(0);
            }
        }
        
        
        req_dx = 0;
        req_dy = 0;
        view_dx = -1;
        view_dy = 0;
    }

    private void playGame(Graphics2D g2d) {
        
      
        
         if (pacman.isEmpty())
         {
             death(g2d);
         }
         else if(levelEnd == true )
         {
             showLevelEnd(g2d);
         }else
         {
             movePacman();
             drawPlayer(g2d);
             moveGhosts(g2d);
             checkMaze();
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
        
        
        
        if (inGame) {
            playGame(g2d);
        } 
        else if (levelEnd == true )
        {
            showLevelEnd(g2d);
        }
        else {
            showIntroScreen(g2d);
        }
        
        
        for (int i = 0; i < pacman.getPacmanLeft(); i++) {
                g2d.drawImage(pacmanRight.getImage(), i * 28 + 8, SCREEN_SIZE + 1, this);
        }
        

        g2d.drawImage(ii, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                }
        }
                    

    private void movePacman() {

        int pos;
        short ch;


        if (pacman.getFront().getxAxis() % BLOCK_SIZE == 0 && pacman.getFront().getyAxis() % BLOCK_SIZE == 0) {
            pos = pacman.getFront().getxAxis() / BLOCK_SIZE + N_BLOCKS * (int) (pacman.getFront().getyAxis() / BLOCK_SIZE);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
            }
            
            dotList.replace(pos + 1 , 0);
            

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacmand_x = req_dx;
                    pacmand_y = req_dy;
                    view_dx = pacmand_x;
                    view_dy = pacmand_y;
                }
            }

            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }
        
        
        
        
        
        int setxAxis = pacman.getFront().getxAxis() + pacman.getFront().getSpeed() * pacmand_x;
        int setyAxis = pacman.getFront().getyAxis() + pacman.getFront().getSpeed() * pacmand_y;
        pacman.getFront().setxAxis(setxAxis);
        pacman.getFront().setyAxis(setyAxis);
    }
    
     public void drawPlayer(Graphics g){
         
        if (view_dx == -1) {
            g.drawImage(pacmanLeft.getImage() ,pacman.getFront().getxAxis()  , pacman.getFront().getyAxis() , null);
        } else if (view_dx == 1) {
            g.drawImage(pacmanRight.getImage() ,pacman.getFront().getxAxis() , pacman.getFront().getyAxis(), this);
        } else if (view_dy == -1) {
            g.drawImage(pacmanUp.getImage() ,pacman.getFront().getxAxis()  , pacman.getFront().getyAxis(), this);
        } else {
            g.drawImage(pacmanDown.getImage() ,pacman.getFront().getxAxis()  , pacman.getFront().getyAxis(), this);
        }
        this.repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
    
    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
    
    private void death(Graphics2D g2d) {

        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

        String s = "You are dead.";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
        
    }
    
    private void showIntroScreen(Graphics2D g2d) {

        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

        String s = "You are dead.";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
    }
    
    private void showLevelEnd(Graphics2D g2d) {

        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

        String s = "Congratulations ! You passed all level. ";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
    }
    
    private void moveGhosts(Graphics2D g2d) {

        short i;
        int pos;
        int count;

        for (i = 0; i < N_GHOSTS; i++) {
            if (ghost_x[i] % BLOCK_SIZE == 0 && ghost_y[i] % BLOCK_SIZE == 0) 
            {
                pos = ghost_x[i] / BLOCK_SIZE + N_BLOCKS * (int) (ghost_y[i] / BLOCK_SIZE);

                count = 0;

                if ((screenData[pos] & 1) == 0 && ghost_dx[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghost_dy[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghost_dx[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghost_dy[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        ghost_dx[i] = 0;
                        ghost_dy[i] = 0;
                    } else {
                        ghost_dx[i] = -ghost_dx[i];
                        ghost_dy[i] = -ghost_dy[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghost_dx[i] = dx[count];
                    ghost_dy[i] = dy[count];
                }

            }

            ghost_x[i] = ghost_x[i] + (ghost_dx[i] * ghostSpeeds);
            ghost_y[i] = ghost_y[i] + (ghost_dy[i] * ghostSpeeds);
            drawGhost(g2d, ghost_x[i] + 1, ghost_y[i] + 1);
            
            
            if(pacman.isEmpty())
            {
                death(g2d);
            }else{
                
                if (pacman.getFront().getxAxis() > (ghost_x[i] - 12) && pacman.getFront().getxAxis() < (ghost_x[i] + 12)
                    && pacman.getFront().getyAxis() > (ghost_y[i] - 12) && pacman.getFront().getyAxis() < (ghost_y[i] + 12)
                    && inGame){
                    pacman.dequeue();
                    inGame = true;
                }
            }
            
        }
    }
    
    private void drawGhost(Graphics g, int x, int y) {
        g.drawImage(ghostImg.getImage(), x, y, this);
    }

}
