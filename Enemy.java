package entity;
import client.tBoard;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Enemy  {
    
    private int xAxis;
    private int yAxis;
    private String imagePath;
    private ImageIcon ghostImg;
   
     public Enemy(int xAxis, int yAxis, String imagePath){
        
        this.setxAxis(xAxis);
        this.setyAxis(yAxis);
        this.setImagePath(imagePath);
        
    }

    public Enemy() {
        
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
    
    
    public void loadGhostImage(){
            
        ghostImg = new ImageIcon("C:\\Users\\ACER\\Desktop\\PacmanGame (5)\\PacmanGame\\src\\image\\ghost(right).jpg") ;

    }
    
    
    }
    



