
public class MonetaryOffsetCard extends Card{
	private final int amount;
	public MonetaryOffsetCard(String name, int amount){
		super(name);
		this.amount = amount;
	}
	
	public void execute(Player player) {
		if (amount > 0) {
			player.addMoney(amount);
		}
		else {
			GameControl.playerBankMoneyExchange(player, amount);
		}
	}
}
