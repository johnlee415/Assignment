package client;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.io.BufferedReader;
import java.io.FileReader;


public class MainMenu extends JFrame{
    static int seconds=0;
    static int Miliseconds=0;
    static boolean state=true;
   

    public MainMenu(){
        
     
        
        //Font f = new Font("Serif", Font.BOLD, 30);
        
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,900,1000);
        JLabel name = new JLabel("Main Menu");
        name.setForeground(Color.BLUE);
        name.setBounds(200,25,400,50);
        //setFont(f);
        add(name);
       JLabel second=new JLabel("0.0");
        JLabel Milisecond=new JLabel("0.0");
       second.setForeground(Color.BLUE);
       second.setBounds(101,25,400,50);
       add(second);
       add(Milisecond);
          Milisecond.setForeground(Color.BLUE);
      Milisecond.setBounds(150,25,400,50);
       
        
        JPanel login = new JPanel();
        
        login.setLayout(null);
        login.setSize(400,350);
        login.setBackground(new Color(0,0,0,60));
        
        JTextField username = new JTextField();
    
        username.setBounds(50,50,300,50);
        //username.setBackground(new color.....);
        login.add(username);
       
        JButton play = new JButton("Play");
        play.setBounds(50,250,100,50);
        //signin.setBackground(new color.....);
        login.add(play);
        play.addActionListener(new java.awt.event.ActionListener() {
          @Override  public void actionPerformed(java.awt.event.ActionEvent evt) {
              String Name=username.getText().toString();
             
             
              int Time=0;
              int id=1000;
              String ranktype="no";
              
             
                  try {
                      FileWriter writer= new FileWriter("C:\\Users\\WellPLY\\Downloads\\PacmanGame (2)\\PacmanGame (4)\\PacmanGame\\src\\client\\PlayerList.txt",true);
                       PrintWriter pw=new PrintWriter(writer);
                        if(username.getText().trim().isEmpty()){
                  JOptionPane.showMessageDialog(rootPane, "Please Enter Your Name");
                   System.exit(0);
              
                        }         
                        
                        else{    new client.startBoard();
                         try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\WellPLY\\Downloads\\PacmanGame (2)\\PacmanGame (4)\\PacmanGame\\src\\client\\PlayerList.txt"))) {
             String line="";
              int g=0;
             while( (line= br.readLine())!= null){
                   String tmp[]=line.split("-");
                   int idd=Integer.parseInt(tmp[0]);
                System.out.print(idd);
                 g++;
                 
             }
                    id+=g;   
                                
                        
                              pw.print(id+"-"+Name+"-"+Time+"-"+ranktype+"\n");
                                  JOptionPane.showMessageDialog(rootPane, "success");}
                                       
                         
                        
                    
                  
                   
                     
                 
                                  writer.close();
                                  state= true;
                                  Thread t= new Thread(){
                                      public void run(){
                                          for(;;){
                                              if(state==true){
                                                 
                                                      try {
                                                          sleep(1);
                                                          if(Miliseconds>1000){
                                                              Miliseconds=0;
                                                              seconds++;
                                                          }
                                                           if(seconds>60){
                                                            
                                                              seconds++;
                                                          }
                                                           Milisecond.setText(":"+Miliseconds);
                                                           Miliseconds++;
                                                           second.setText(":"+seconds);

                                                           
                                                      } 
                                                      
                                                              catch (InterruptedException ex) {
                                                          Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                                                              }
                                                  }else{ break; }
                                              }
                                          }
                                  };
                                  t.start();
                        }            
        
                           
                                  
                                          
                                                      
                                                      
                                                                       
                                                      
                                                      
                                                     
                                                      
                                                      
                                                      
                                                                   
                                                      
                                                      
                                                      
                              
                                      
                                 
            } catch (IOException ex) {
                      JOptionPane.showMessageDialog(rootPane, "Failed");
                  }
}
                
        });
          JButton stop = new JButton("stop");
        stop.setBounds(250,300,40,50);
        //signin.setBackground(new color.....);
        login.add(stop);
        stop.addActionListener(new java.awt.event.ActionListener() {
          @Override  public void actionPerformed(java.awt.event.ActionEvent evt) {
              state=false;
             
        
          } });
        
        
         
             
             
    
        
          
        JButton leaderboard = new JButton("Leaderboard");
        leaderboard.setBounds(150,250,125,50);
        //signin.setBackground(new color.....);
        login.add(leaderboard);
        
        
        
        JButton quit = new JButton("Quit");
        quit.setBounds(275,250,100,50);
        //signin.setBackground(new color.....);
        login.add(quit);
        
        login.setBounds(250,175,400,350);
          JLabel Time= new JLabel("00");
          login.add(Time);
        
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon background_image = new ImageIcon("C:\\Users\\WellPLY\\Downloads\\PacmanGame (2)\\PacmanGame (4)\\PacmanGame\\src\\image\\PacmanHeader1.png");
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        //Image img = background_image.getImage();
        //Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        //background_image = new ImageIcon(temp_img);
        
        background.add(login);
        background.setBounds(0,0,900,600); 
        add(background);
        
        setVisible(true);
        
     
             
        //leaderboard.addActionListener(e -> new Leaderboard());
        quit.addActionListener(e -> System.exit(0));
        leaderboard.addActionListener(new java.awt.event.ActionListener() {
          @Override  public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                  new client.shortestTime();
              } catch (IOException ex) {
                  Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
              }
             
             
        
          } });
    
       
                      
  
    
        
        
    }
        
    
    public static void main(String[] args) {
        new MainMenu();
       
        
    }}