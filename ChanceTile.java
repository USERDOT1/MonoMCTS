import java.util.ArrayList;
public class ChanceTile extends Tile{
	private final ArrayList<Card> chanceCards;
	public ChanceTile(int position, ArrayList<Card> chanceCards) {
		super("CHANCE",position);
		this.chanceCards = chanceCards;
	}
	public void land(Player player) {
		Card pickedCard = chanceCards.get(0);
		pickedCard.execute(player);
		chanceCards.remove(pickedCard); //Removes card from top
		chanceCards.add(pickedCard); //Adds card to bottom
		
	}
	
	public void land(Player player, Card pickedCard) {
		if (pickedCard.name != "GET OUT OF JAIL FREE"){
			chanceCards.remove(pickedCard);
			pickedCard.execute(player);
		}
		else {
			chanceCards.remove(pickedCard);
			pickedCard.execute(player);
		}
	}
}