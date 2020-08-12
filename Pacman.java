package Main;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Pacman extends JFrame{
    //public 
    
    public static final int WIDTH = 600, HEIGHT = 640;
    private JPanel panel = new JPanel();
  
    Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
    private final JLabel holdShapeLabelBorder = new JLabel("");
  
    private JFrame frame;
    
    public static void main(String[] args) {
    	new ScreenControl();
    }
    
  
    
    private void setUpPopUpWindow(JFrame frame) {
    	Status.setStatus("wait");
    	
        Object[] options = {"Yes, please",
        "No!! play Again "};
        int n = JOptionPane.showOptionDialog(frame,
        		"Game over. Return to Main Menu?",
        		"Game Over",
        		JOptionPane.YES_NO_OPTION,
        		JOptionPane.QUESTION_MESSAGE,
        		null,     //do not use a custom Icon
        		options,  //the titles of buttons
        		null); //default button title
        
       
        
        
    }

	
    
  
    
    public enum Status{
    	menu,play,stop,wait;
    	
    	static Status s;
    	
    	public static String getStatus() {
    		return s.name();
    	}
    	public static void setStatus(String temp) {
    		s = Status.valueOf(temp);
    	}
    }  
}


