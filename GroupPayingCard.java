import java.util.ArrayList;
public class GroupPayingCard extends Card {
	int othersPayAmount;
	ArrayList<Player> players;
	public GroupPayingCard(String name, int othersPayAmount, ArrayList<Player> players) {
		super(name);
		this.othersPayAmount = othersPayAmount;
		this.players = players;
	}
	
	public void execute(Player player) {
		for(int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
			if (othersPayAmount > 0) {
				GameControl.playerMoneyExchange(players.get(playerIndex), player, othersPayAmount);
			}
			else {
				GameControl.playerMoneyExchange(player,players.get(playerIndex), Math.abs(othersPayAmount));
			}
		}
	}
}
