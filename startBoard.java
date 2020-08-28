package client;

import javax.swing.*;


public class startBoard extends JFrame {
    
    
    public startBoard() {
        
        tBoard board = new tBoard(); 
        add(board);
        
        setTitle("Pacman");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(370, 430);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args){
        startBoard go = new startBoard();
    }
    
}
