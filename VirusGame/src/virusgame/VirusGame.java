package virusgame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Damian Suski
 */
public class VirusGame {

    /**
     * 
     */
    
    public VirusGame(){
        JFrame window = new JFrame("Virus");
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        
            window.add(new Host(screensize));
		
            window.setResizable(false);
            window.setSize(screensize);

            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new VirusGame();
    }
    
}
