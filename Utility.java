
public class Utility extends Asset {
	Dice gameDice;
	public Utility(String name, Dice gameDice) {
		super(name);
		this.gameDice = gameDice;
	}
	
	public int getRent() {
		int numberOfUtilities = 0;
		for(int assetIndex = 0; assetIndex < owner.assets.size();assetIndex++) {
			if (owner.assets.get(assetIndex) instanceof Railroad) {
				numberOfUtilities++;
			}
		}
		if (numberOfUtilities == 1) {
			return 4*gameDice.getDiceValue();
		}
		else {
			return 10*gameDice.getDiceValue();
		}
	}
}
