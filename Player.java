
package player;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {
    private int lives;
    private int xAxis;
    private int yAxis;
    private String imagePath;
    private boolean isAlive;
    
    public int getLives(){
        return lives;
    }
    
    public void setLives(int lives){
        this.lives = lives;
    }
    
    public Player(int lives, int xAxis, int yAxis, String imagePath, boolean isActive){
        super();
        this.setLives(lives);
        this.setxAxis(xAxis);
        this.setyAxis(yAxis);
        this.setImagePath(imagePath);
        this.setAlive(isAlive);
    }
    
    public int getxAxis(){
        return xAxis;
    }
    
    public void setxAxis(int xAxis){
        //remain on screen when alive 
        if(isAlive)
        {
            //window == 500 pixel // 470
            if(this.xAxis >= 500)
            {
                this.xAxis = 500;
            }
            else if(this.xAxis <= 0)
            {
                this.xAxis = 0;
            }
            else
                this.xAxis = xAxis;
        }
        else 
        {
            this.xAxis = xAxis;
        }
        
    }
    
    public int getyAxis(){
        return yAxis;
    }
    
    public void setyAxis(int yAxis){
         if(isAlive)
        {
            //window == 300 pixel // 470
            if(this.yAxis >= 300)
            {
                this.yAxis = 300;
            }
            else if(this.yAxis <= 0)
            {
                this.yAxis = 0;
            }
            else
                this.yAxis = yAxis;
        }
        else 
        {
            this.yAxis = yAxis;
        }
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
}
