 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class game extends JPanel implements KeyListener {
   
   private game g;
    private int speed = 10;
   private int XAXIS_OF_GHOST = 10;
   private int YAXIS_OF_GHOST = 10;
   public int widthOfScene = 510;
   public int heightOfScene = 333;
   
   private JFrame window = new JFrame("PACMAN");
   private ImageIcon background = new ImageIcon("C:\\Users\\Bolt\\Documents\\NetBeansProjects\\Assignment\\src\\image\\rsz_background.jpg");
   Player player = new Player(5, 10, 10, "C:\\Users\\Bolt\\Desktop\\Player\\src\\image\\right.png", true,null);
   private ghost g1 = new ghost(XAXIS_OF_GHOST +20 ,YAXIS_OF_GHOST + 100,"C:\\Users\\Bolt\\Documents\\NetBeansProjects\\Assignment\\src\\image\\ghost(right).jpg",true,this,player);
   private ghost g2 = new ghost(XAXIS_OF_GHOST +100 ,YAXIS_OF_GHOST + 200,"C:\\Users\\Bolt\\Documents\\NetBeansProjects\\Assignment\\src\\image\\ghost(right).jpg",true,this,player);
   public game()
   {
        
        this.setFocusable(true);
        this.addKeyListener(this);
        window.add(this);
        Thread thread = new Thread(g1);
        thread.start();
        Thread thread2 = new Thread(g2);
        thread2.start();
        window.setSize(widthOfScene,heightOfScene);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
   }
   
   
      @Override
    public void paint(Graphics g){
        g.drawImage(background.getImage(), 0, 0, null);
        player.drawPlayer(g);
       g1.drawPlayer(g);
       g2.drawPlayer(g);
    } 
   
   
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
 @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.setxAxis(player.getxAxis() + speed);
            player.setImagePath("C:\\Users\\Bolt\\Desktop\\Player\\src\\image\\right.png");
            this.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.setImagePath("C:\\Users\\Bolt\\Desktop\\Player\\src\\image\\left.png");
            player.setxAxis(player.getxAxis() - speed);
            this.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setImagePath("C:\\Users\\Bolt\\Desktop\\Player\\src\\image\\up.png");
            player.setyAxis(player.getyAxis() - speed);
            this.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setImagePath("C:\\Users\\Bolt\\Desktop\\Player\\src\\image\\down.png");
            player.setyAxis(player.getyAxis() + speed);
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    }


    
    

