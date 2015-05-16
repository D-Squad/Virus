package virusgame;

import java.util.ArrayList;

/**This is the abstract class which will represent all in game infectable objects e.g. Computers, servers etc
 *As of right now only 10 factions can be in one node. This can be changed as needed later.
 * @author Damian Suski
 */
public class Node {
    
    public static final int PERSONAL_COMPUTER=1;
    public static final int BUSINESS_COMPUTER=2;
    public static final int SECURED_NETWORK=3;
    public static final int OPEN_NETWORK=4;
    public static final int GOVERNMENT_NETWORK=5;
    public static final int SERVER=6;
    
    //For seperate category (Internet)
    public static final int WEBSITE=7;
    public static final int SEARCH_ENGINE=8;
    public static final int DATA_BASE=9;
    
    private int x,y,currentMoney,supplyMoney,maxProcessing;
    private int[][] inhabitants= new int[10][];
    private boolean visible;
    private ArrayList <Node> neighbors; 
    private int type;
    
    public Node(int x, int y, int type){
        this.type=type;
        this.x=x;
        this.y=y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
}
