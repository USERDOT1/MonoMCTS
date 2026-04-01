
public class GetOutOfJailFreeCard extends Card {
	
	public GetOutOfJailFreeCard() {
		super("GET OUT OF JAIL FREE");
	}
	
	public void execute(Player player) {
		player.assets.add(new GetOutOfJailFreeCardAsset());
	}
}
