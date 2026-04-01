
public class Railroad extends Asset {
	private int[] rents = {25,50,100,200};
	//private int[] 
	public int getRent() {
		int numberOfRailroads = 0;
		for(int assetIndex = 0; assetIndex < owner.assets.size();assetIndex++) {
			if (owner.assets.get(assetIndex) instanceof Railroad) {
				numberOfRailroads++;
			}
		}
		return rents[numberOfRailroads];
	}
	public Railroad(String name) {
		super(name);
	}
}
