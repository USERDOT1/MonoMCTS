
public class IncomeTaxTile extends Tile {
	public IncomeTaxTile(int position) {
		super("INCOME TAX",position);
	}
	public void land(Player player) {
		if (Math.round((double) player.getMoney() / 10) > 200) {
			GameControl.playerBankMoneyExchange(player, 200);
		}
		else {
			GameControl.playerBankMoneyExchange(player,(int) Math.round((double) player.getMoney() / 10));
		}
	}
}
