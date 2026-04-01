import java.util.ArrayList;
public class Player{
    private int money = 1500;
    public int position = 0;
    public final String name;
    
    public ArrayList<Asset> assets = new ArrayList<>();

    public Tile tileOn;
    
    private final Board gameBoard;
    private final Dice gameDice;
    

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
