package virusgame;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Damian Suski
 */
public class Host extends JPanel implements KeyListener,MouseListener,Runnable{
    
    public static Dimension screensize;
    
    private Thread thread;
    private boolean running;
    private int FPS=30;
    private int count;
    
    private State currentState;
    
    public Host(Dimension screensize) {
        this.screensize=screensize;
        setFocusable(true);
        requestFocus();
    }
    
    public void addNotify() {
		super.addNotify();
		if(thread == null) {
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
    
    @Override
    public void run() {
       running=true;
       currentState=new Menu();
       
       long start;
       long elapsed;
       long wait;
       
       //Temporary Thread Fix 
       //Actual FPS is NOT at 30. Does not directly correspond to variable.
       while(running){
           update();
           repaint();
           
           count++;
           System.out.println(count);
           try{
                Thread.sleep((long) FPS);
           }catch(Exception e){e.printStackTrace();}
       }   
    }
    
    public void paint(Graphics2D g){
        super.paint(g);
        currentState.draw(g);
        g.dispose();
    }
    
    private void update(){
        
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        KeyBoard.KeyPressed(ke.getKeyCode(),true);
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        KeyBoard.KeyPressed(ke.getKeyCode(),false);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
