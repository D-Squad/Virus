package virusgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Damian Suski
 */
public class Game extends State{
    
    public static final int MODE_PANDEMIC=1;
    public static final int MODE_GOVERNMENT=2;
    public static final int MODE_FINANCE=3;
    public static final int MODE_CELEBRITY=4;
    public static final int MODE_TERRORIST=5;
    
    public static int gameType;
    public static ArrayList <Virus> viruses;
    public static ArrayList <Government> governments;
    public static ArrayList <Node> nodes;
    
    //Procedural Generation of Nodes
    private final int NODE_AMOUNT=100;
    private final int SPREAD_FACTOR=5;
    private final int NODE_VARIETY=1;
    private final int NODE_SPACE=10;
    
    public Game(int gameType){
        this.gameType=gameType;
        init();
    }
    
    private void init(){
        viruses=new ArrayList();
        governments=new ArrayList();
        nodes=new ArrayList();
        generateNodes();
    }
    
    @Override
    public void draw(Graphics2D g) {
        for(Node node : nodes){
            g.setColor(Color.blue);
            g.drawRect((int)node.getX()-10, (int)node.getY()-10, 20, 20);
        }
    }

    @Override
    public void update() {
    }
    
    //Generates all of the objects
    private void generateNodes(){
        Node playernode=new Node(500,500,Node.PERSONAL_COMPUTER);
        nodes.add(playernode);
        
        Random r = new Random();
        int neighbors=r.nextInt(5)+1;
        
        for(int i=0;i<neighbors;i++){
            int x=playernode.getX();
            int y=playernode.getY();
            while(!nodeCheck(x,y)){
                x=playernode.getX()+(r.nextInt(30)-15)*SPREAD_FACTOR;
                y=playernode.getY()+(r.nextInt(30)-15)*SPREAD_FACTOR;
            }
            Node node  = new Node(x,y,Node.PERSONAL_COMPUTER);
            nodes.add(node);
            System.out.println("Node added");
        }
    }
    
    private boolean nodeCheck(int x, int y){
        for(Node node : nodes){
            if(node.getX()==x)
                return false;
            if(node.getY()==y)
                return false;
        }
        return true;
    }
    
    public void handleInput(){
        
    }
}
