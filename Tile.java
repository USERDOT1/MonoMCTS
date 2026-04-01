public class Tile{
    public final String name;
    public final int position;

    public Tile(String name, int position){
        this.name = name;
        this.position = position;
    }

    public int getDeductOnLand(){
        return 0;
    }
    
    public void land(Player player) {
    	
    }

    public String toString(){
        return name+" at "+position;
    }
}
