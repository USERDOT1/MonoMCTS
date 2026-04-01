public class PropertyTile extends Tile{
    public final Property linkedProperty;
    public PropertyTile(int position, String name, int propertyGroup, int[] rents, int buildingCost, int morgageValue){
        super(name,position);
        linkedProperty = new Property(name, propertyGroup, rents, buildingCost, morgageValue);
    }
    public int getDeductOnLand(){
        if (linkedProperty.hasHotel)
        {
            return linkedProperty.rents[5];
        }
        else{
            return linkedProperty.rents[linkedProperty.houseNumber];
        }
    }
    
    public void land(Player player) {
    	if (linkedProperty.owner != null) {
    		if (linkedProperty.owner != player) {
    			GameControl.playerMoneyExchange(player, linkedProperty.owner, linkedProperty.getRent());
    		}
    	}
    }
    
    public String toString(){
        if (linkedProperty.hasHotel){
            if (linkedProperty.owner != null){
                return name+" at "+" is owned by "+linkedProperty.owner.name+" and has a hotel";
            }
            else{
                return name+" at "+position+" is unowned";
            }

        }
        else{
            if (linkedProperty.owner != null){
                return name+" at "+position+" is owned by "+linkedProperty.owner.name+" and has "+linkedProperty.houseNumber+" houses";
            }
            else{
                return name+" at "+position+" is unowned";
            }
        }

    }
}
