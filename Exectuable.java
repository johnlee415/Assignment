/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Exectuable extends JFrame {
    
    
   
    public Exectuable() {
        
        
        Board board = new Board(); 
        add(board);
        
        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
   

    public static void main(String[] args) {
        
        Exectuable game = new Exectuable();
        
        

    }
}
