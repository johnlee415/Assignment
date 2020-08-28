package entity;


import javax.swing.JOptionPane;


public class Player {
    private int xAxis;
    private int yAxis;
    private String imagePath;
    private boolean isAlive;
    private int speed;
    
    
   
    public Player( int xAxis, int yAxis, String imagePath, boolean isAlive, int speed){
        super();
        this.setxAxis(xAxis);
        this.setyAxis(yAxis);
        this.setImagePath(imagePath);
        this.setAlive(isAlive);
        this.setSpeed(speed);
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
    
    public int getSpeed()
    {
        return this.speed;
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}

