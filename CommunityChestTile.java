import java.util.ArrayList;
import java.util.Random;
public class CommunityChestTile extends Tile{
	private final ArrayList<Card> communityChestCards;
	public CommunityChestTile(int position, ArrayList<Card> communityChestCards) {
		super("COMMUNITY CHEST",position);
		this.communityChestCards = communityChestCards;
	}
	public void land(Player player) {
		Card pickedCard = communityChestCards.get(0);
		pickedCard.execute(player);
		communityChestCards.remove(pickedCard); //Removes card from top
		communityChestCards.add(pickedCard); //Adds card to bottom
		
	}
	
	public void land(Player player, Card pickedCard) {
		if (pickedCard.name != "GET OUT OF JAIL FREE"){
			communityChestCards.remove(pickedCard);
			pickedCard.execute(player);
		}
		else {
			communityChestCards.remove(pickedCard);
			pickedCard.execute(player);
		}
	}
}