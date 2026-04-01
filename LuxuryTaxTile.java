
public class LuxuryTaxTile extends Tile {
	public LuxuryTaxTile(int position) {
		super("LUXURY TAX",position);
	}
	public void land(Player player) {
		GameControl.playerBankMoneyExchange(player, 75);
	}
}
