/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class MainMenu extends JFrame{

    public MainMenu(){
        
        //Font f = new Font("Serif", Font.BOLD, 30);
        
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,900,1000);
        JLabel name = new JLabel("Example");
        name.setForeground(Color.BLUE);
        name.setBounds(200,25,400,50);
        //setFont(f);
        add(name);
        
        
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setSize(400,350);
        login.setBackground(new Color(0,0,0,60));
        
        JTextField username = new JTextField("Enter Name");
        username.setBounds(50,50,300,50);
        //username.setBackground(new color.....);
        login.add(username);
        
        
        JButton play = new JButton("Play");
        play.setBounds(50,250,100,50);
        //signin.setBackground(new color.....);
        login.add(play);
        
        
        JButton leaderboard = new JButton("Leaderboard");
        leaderboard.setBounds(150,250,125,50);
        //signin.setBackground(new color.....);
        login.add(leaderboard);
        
        
        JButton quit = new JButton("Quit");
        quit.setBounds(275,250,100,50);
        //signin.setBackground(new color.....);
        login.add(quit);
        
        login.setBounds(250,175,400,350);
        
        
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon background_image = new ImageIcon("C:\\Users\\user\\Desktop\\DSA\\Pacman\\src\\Images\\PacmanHeader1.png");
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        //Image img = background_image.getImage();
        //Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        //background_image = new ImageIcon(temp_img);
        
        background.add(login);
        background.setBounds(0,0,900,600); 
        add(background);
        
        setVisible(true);
        
        //play.addActionListener(e ->  new LevelAssign());
        //leaderboard.addActionListener(e -> new Leaderboard());
        quit.addActionListener(e -> System.exit(0));
    }
    public static void main(String[] args) {
        new MainMenu();
    }
    
}
