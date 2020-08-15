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
import java.util.Random;
/**
 *
 * @author Bolt
 */
public class ghost implements Runnable {
    private game g;
    private Player p;
    Random random = new Random();
    public int direction = 1;
    private int xAxis;
    private int yAxis;
    private String imagePath;
    private boolean isAlive;
    
     public ghost(int xAxis, int yAxis, String imagePath, boolean isActive,game g, Player p){
        super();
         
        this.g = g;
        this.p = p;
        this.setxAxis(xAxis);
        this.setyAxis(yAxis);
        this.setImagePath(imagePath);
        this.setAlive(isAlive);
    }
     
     
    public void kill()
    {
        Rectangle pacmanReact = new Rectangle(p.getxAxis(),p.getyAxis(),25,25);
         Rectangle ghostReact = new Rectangle(this.getxAxis(),this.getyAxis(),20,25);
        System.out.println("Ghost X :" +getxAxis());
        System.out.println("Ghost Y :" +getyAxis());
        System.out.println("GOOD X :" +p.getxAxis());
        System.out.println("Ghost Y :" +p.getyAxis());
        
         if(pacmanReact.contains(ghostReact))
         {
             JOptionPane.showMessageDialog(null,"You Died !");
            
             System.exit(0);
         }
    }
   
    public int getxAxis(){
        return xAxis;
    }
    
    public void setxAxis(int xAxis){
        this.xAxis = xAxis;
    }
    
    public int getyAxis(){
        return yAxis;
    }
    
    public void setyAxis(int yAxis){
        this.yAxis = yAxis;
    }
    
    
    public String getImagePath(){
        return imagePath;
    }
    
    public void setImagePath(String imagePath){
        if(imagePath == null )
            JOptionPane.showMessageDialog(null, "Invalid String");
        else if(imagePath.length() == 0)
            JOptionPane.showMessageDialog(null, "String empty");
        else 
            this.imagePath = imagePath;
    }
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }
    
    public void drawPlayer(Graphics g){
        ImageIcon img = new ImageIcon(imagePath);
        g.drawImage(img.getImage(), xAxis, yAxis, null);
  
        
    }

    @Override
    public void run() {
      
        
         while(true)
        {
           try{
               Thread.sleep(random.nextInt(100));
           }catch(Exception e)
           {
               JOptionPane.showMessageDialog(null, "Thread interupted");
               System.exit(1);
           }
          if(getxAxis() <= new Random().nextInt(100))
               direction = 1;
          else if(getxAxis() >= new Random().nextInt(g.widthOfScene - 60))
              direction = -1;
          kill();
          setxAxis(getxAxis() + 3 * direction);
          g.repaint();
          
        }
        
        
   
    }
    }

