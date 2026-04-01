
public class RailroadTile extends Tile {
	private final Railroad linkedRailroad;
	public RailroadTile(int position, String name) {
		super(name,position);
		linkedRailroad = new Railroad(name);
		
	}
	
	public void land(Player player) {
		if (linkedRailroad.owner != null) {
			if (linkedRailroad.owner != player) {
				GameControl.playerMoneyExchange(player, linkedRailroad.owner , linkedRailroad.getRent());
			}
		}
		
	}
}
