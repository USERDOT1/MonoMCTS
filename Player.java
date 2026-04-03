import java.util.ArrayList;
public class Player{
    private int money = 1500;
    public int position = 0;
    public final String name;
    
    public ArrayList<Asset> assets = new ArrayList<>();

    public Tile tileOn;
    
    private final Board gameBoard;
    private final Dice gameDice;
    
    public double propertyGroup0Bias;
    public double propertyGroup1Bias;
    public double propertyGroup2Bias;
    public double propertyGroup3Bias;
    public double propertyGroup4Bias;
    public double propertyGroup5Bias;
    public double propertyGroup6Bias;
    public double propertyGroup7Bias;
    
    public double railroadBias;
    public double utilityBias;
    public double leaderTradeBias; // 1.0 is rational, 1.2 is a suck up, 0.8 is looking out for the underdogs
    public double tradeBias; //1.2 gets scammed, 0.8 is hesitant
    public double jailStayBias;
    
    public Boolean isAgent = true;

    public Player(String name, Board gameBoard, Dice gameDice){
        this.name = name;
        this.gameBoard = gameBoard;
        tileOn = gameBoard.getTileAt(position); // Should be the GO tile
        this.gameDice = gameDice;
    }

    public void moveBy(int amount){
    	if (position + amount > 39) {
        	addMoney(200);
        }
    	position = (position+amount)%40;
        tileOn = gameBoard.getTileAt(position);
        System.out.println(name+" moves by "+amount+" landing on "+tileOn);
        tileOn.land(this);
        
        
    }
    
    public void moveTo(int index, Boolean passGo) {
    	if (position > index && passGo) {
    		addMoney(200);
    	}
    	position = index;
    	tileOn = gameBoard.getTileAt(position);
    	tileOn.land(this);
    }
    
    public String toString() {
    	return name+" is on "+tileOn.name+" and has "+money+" monopoly bucks";
    }
    
    public void subtractMoney(int amount) {
    	money -= amount;
    }
    
    public void addMoney(int amount) {
    	money += amount;
    }
    
    public int getMoney() {
    	return money;
    }
}
