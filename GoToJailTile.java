
public class GoToJailTile extends Tile {
	public GoToJailTile(int position) {
		super("GO TO JAIL",position);
	}
	public void land(Player player) {
		player.moveTo(10, false);
	}
}
