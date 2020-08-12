package Main;

import javax.swing.*;
import java.awt.*;

public class ScreenControl extends JFrame{
    static final int JFRAME_WIDTH = 600;
    static final int JFRAME_HEIGHT = 640;
    static Font info;
    static Font mainFont;

    public ScreenControl(){
        JFrame frame = new JFrame("Pacman");
        ScreenControl.info = new Font("Dialog", Font.BOLD, 15);
        ScreenControl.mainFont = new Font("Dialog", Font.BOLD, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainMenu(frame));
        frame.setPreferredSize(new Dimension(JFRAME_WIDTH, JFRAME_HEIGHT));
        centerWindow(frame);
        frame.pack();
        //frame.setResizable(false);
        frame.setVisible(true);
        //board.requestFocus();
    }

    public static void centerWindow(JFrame f){
        Dimension windowSize = f.getPreferredSize();
        Dimension pos = Toolkit.getDefaultToolkit().getScreenSize();

        int dx = (pos.width / 2) - (windowSize.width / 2);
        int dy = (pos.height / 2) - (windowSize.height / 2);
        f.setLocation(dx, dy);

    }

    public static void loadScene(JFrame frame, JPanel panel){
        frame.setContentPane(panel);
        frame.invalidate();
        frame.validate();
        frame.dispose();
        panel.requestFocus();
    }
    
    public static void loadScene(JFrame frame, JFrame frame2){
    	try {
    		frame.setContentPane(frame2);
            frame.invalidate();
            frame.validate();
            frame.dispose();
            frame2.requestFocus();
    	}catch(Exception ex) {
    		
    	}
        
    }

    public static void paintInfo(Graphics g){
        int x = 5;
        int y = 590;
        g.setColor(Color.WHITE);
        g.setFont(ScreenControl.info);
        g.drawString("Author: OoiWeiHao", x, y);
    }
}
