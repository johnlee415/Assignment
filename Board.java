/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author USER
 */
public class Board extends JPanel implements KeyListener{
    private Dimension d;
   
    private final Color dotColor = new Color(192, 192, 0);
    private Color mazeColor;

    private Image ii;
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    LinkedList dotList = new LinkedList();
    //private testingBoard testboard;
    //private final short levelData[] = testboard.getBoard();
    
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
   
    private ImageIcon pacmanUp = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\up.png");
    private ImageIcon pacmanDown = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\down.png");
    private ImageIcon pacmanRight = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\right.png");
    private ImageIcon pacmanLeft = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\left.png");
    
    //pacman position 
    private int pacman_x = 8 * BLOCK_SIZE;
    private int pacman_y = 11 * BLOCK_SIZE;
    
    private int pacmand_x, pacmand_y;
    private int view_dx, view_dy;
    private int speed = 1 ;
        
    
    private Player player = new Player(5, pacman_x, pacman_y, "C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\right.png", true);
    

    
    public Board() {
       
        initVariables();
        initBoard();
        
        this.setFocusable(true);
        this.addKeyListener(this);
        
        //for(int i = 0; i < BLOCK_SIZE * BLOCK_SIZE; i++)
        //{
         //   dotList.storeDots(levelData[i]);
            
        //}
        
        //System.out.println(dotList);
        
        
        
    }
    
    private void initBoard() {

        setFocusable(true);
        setBackground(Color.black);
    }

    private void initVariables() {

        screenData = new short[N_BLOCKS * N_BLOCKS];
        mazeColor = new Color(5, 100, 5);
        d = new Dimension(400, 400);

    }

    @Override
    public void addNotify() {
        super.addNotify();

        initGame();
    }

 

    private void checkMaze() {

        short i = 0;
        boolean finished = true;

        while (i < N_BLOCKS * N_BLOCKS && finished) {

            if ((screenData[i] & 48) != 0) {
                finished = false;
            }

            i++;
        }

        if (finished) {



            initGame();
        }
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

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
            
            dotList.storeDots(screenData[i]);
            //dotList.chckDots()
        }
        
        System.out.println(dotList);
        
       
        pacmand_x = 0;
        pacmand_y = 0;
        view_dx = 0;
        view_dy = 0;
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
        
        
        //PLAYER CLASS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        movePacman();
        drawPlayer(g);

        g2d.drawImage(ii, 5, 5, this);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

    @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    view_dx = -1;
                    view_dy = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    view_dx = 1;
                    view_dy = 0;
                } else if (key == KeyEvent.VK_UP) {
                    view_dx = 0;
                    view_dy = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    view_dx = 0;
                    view_dy = 1;
                }
        }
                    
    
    private void movePacman() {
        
        
        
        
        
        int pos;
        short ch;

        
        //if (pacman_x % BLOCK_SIZE == 0 && pacman_y % BLOCK_SIZE == 0) {
          //  pos = pacman_x / BLOCK_SIZE + N_BLOCKS * (int) (pacman_y / BLOCK_SIZE);
          
          
        if (player.getxAxis() % BLOCK_SIZE == 0 && player.getyAxis() % BLOCK_SIZE == 0) {
            //pos = 8 + 15 * 11
            pos = player.getxAxis() / BLOCK_SIZE + N_BLOCKS * (int) (player.getyAxis() / BLOCK_SIZE);
            ch = screenData[pos];
            
            //System.out.println(pos);
            //System.out.println(ch);

            //if ((ch & 16) != 0) {
            //    screenData[pos] = (short) (ch & 15);
            //    dotList.replace(screenData[pos], 0);
            //}

            if (view_dx != 0 || view_dy != 0) {
                if (!((view_dx == -1 && view_dy == 0 && (ch & 1) != 0)
                        || (view_dx == 1 && view_dy == 0 && (ch & 4) != 0)
                        || (view_dx == 0 && view_dy == -1 && (ch & 2) != 0)
                        || (view_dx == 0 && view_dy == 1 && (ch & 8) != 0))) {
                    
                    //pacmand_x = -1, 1, 0
                    //pacmand_y = -1, 1, 0
                    pacmand_x = view_dx;
                    pacmand_y = view_dy;
                    
                    //view_dx = pacmand_x;
                    //view_dy = pacmand_y;
                }
            }

            // 撞墙
            if ((pacmand_x == -1 && pacmand_y == 0 && (ch & 1) != 0)
                    || (pacmand_x == 1 && pacmand_y == 0 && (ch & 4) != 0)
                    || (pacmand_x == 0 && pacmand_y == -1 && (ch & 2) != 0)
                    || (pacmand_x == 0 && pacmand_y == 1 && (ch & 8) != 0)) {
                pacmand_x = 0;
                pacmand_y = 0;
            }
        }
        
        // pacmand_x = -1, 1, 0
        // 7 = 7 + 1 * 1
        //player.setxAxis(pos);
        //pacman_x = pacman_x + speed * pacmand_x;
        //pacman_y = pacman_y + speed * pacmand_y;
        player.setxAxis((player.getxAxis() + speed * pacmand_x));
        player.setyAxis((player.getyAxis() + speed * pacmand_y));
        
    }
    
     public void drawPlayer(Graphics g){
        
        if (view_dx == -1) {
            g.drawImage(pacmanLeft.getImage() ,player.getxAxis()  , player.getyAxis(), this);
        } else if (view_dx == 1) {
            g.drawImage(pacmanRight.getImage() ,player.getxAxis() , player.getyAxis(), this);
            //player.setImagePath("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\right.png");
        } else if (view_dy == -1) {
            g.drawImage(pacmanUp.getImage() ,player.getxAxis() , player.getyAxis(), this);
        } else {
            g.drawImage(pacmanDown.getImage() ,player.getxAxis() , player.getyAxis(), this);
        }
        this.repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
    
    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    
    /*@Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                player.setxAxis(player.getxAxis() + speed);
                player.setImagePath("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\right.png");
                break;
            case KeyEvent.VK_LEFT:
                player.setImagePath("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\left.png");
                player.setxAxis(player.getxAxis() - speed);
                break;
            case KeyEvent.VK_UP:
                player.setImagePath("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\up.png");
                player.setyAxis(player.getyAxis() - speed);
                break;
            case KeyEvent.VK_DOWN:
                player.setImagePath("C:\\Users\\USER\\Documents\\NetBeansProjects\\Player\\src\\image\\down.png");
                player.setyAxis(player.getyAxis() + speed);
                break;
            default:
                break;
        }
        this.repaint();
    }*/

    
    
    
    
    

    
    
}
