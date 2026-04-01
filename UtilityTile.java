
public class UtilityTile extends Tile {
	public final Utility linkedUtility;
	public UtilityTile(int position, String name, Dice gameDice) {
		super(name, position);
		linkedUtility = new Utility(name, gameDice);
	}
}
