public class Property extends Asset{
    public final int colourGroup;
    public final int[] rents;
    public final int buildingCost;
    public final int morgageValue;

    public boolean morgaged = false;

    public int houseNumber = 0;
    public Boolean hasHotel = false;



    public Property(String name, int colourGroup, int[] rents, int buildingCost, int morgageValue){
    	super(name);
    	this.colourGroup = colourGroup;
    	this.rents = rents;
    	this.buildingCost = buildingCost;
    	this.morgageValue = morgageValue;
    }

    public void improve(){
        if (houseNumber != 4 && hasHotel != true) {
            houseNumber += 1;
        }
        else{
            houseNumber = 0;
            hasHotel = true;
        }
    }
    
    public int getRent() {
    	if (hasHotel) {
    		return rents[5];
    	}
    	else {
    		return rents[houseNumber];
    	}
    }
    
    
}
