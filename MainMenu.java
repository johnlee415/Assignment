package Main;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel{
    private BufferedImage background;
    private JFrame frame;

    private JButton play;
    private JButton leaderboard;
    private JButton quit;

    private int buttonsWidth;
    private int buttonsHeight;

    private int yOffset;
    private int spacing;
    
    public MainMenu(JFrame frame){
        super.setLayout(null);
        this.buttonsWidth = 185;
        this.buttonsHeight = 65;
        this.yOffset = (int)((double)ScreenControl.JFRAME_HEIGHT / 2.8);
        this.spacing = (int)(this.buttonsHeight * 1.5f);
        this.frame = frame;
        this.play = new JButton("PLAY");
        this.play.setFont(ScreenControl.mainFont);
        this.leaderboard = new JButton("LEADERBOARD");
        this.leaderboard.setFont(ScreenControl.mainFont);
        this.quit = new JButton("QUIT");
        this.quit.setFont(ScreenControl.mainFont);
        
       
     


        super.add(this.play);
        super.add(this.leaderboard);
        super.add(this.quit);
        
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, null);
        ScreenControl.paintInfo(g);
    }
}
    
