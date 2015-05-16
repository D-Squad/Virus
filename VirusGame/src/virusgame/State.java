package virusgame;

import java.awt.Graphics2D;

/**
 *
 * @author Damian Suski
 */
public abstract class State {
    
    public abstract void draw(Graphics2D g);
    public abstract void update();
    
}
