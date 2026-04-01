import java.util.ArrayList;

public class GameRunner{
	
	public static void main(String[] args) {
		Dice gameDice = new Dice();
		Board gameBoard = new Board(gameDice);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Samuel Holden",gameBoard,gameDice));
		gameBoard.addCommunityChestCard(new GroupPayingCard("GRAND OPERA OPENING",50,players));
		gameBoard.addChanceCard(new GroupPayingCard("ELECTED CHAIRMAN OF THE BOARD",-50,players));
		gameBoard.shuffleAllCards();
		
		
		System.out.println(players.get(0));
		players.get(0).moveBy(gameDice.rollDice());
		System.out.println(players.get(0));
		players.get(0).moveBy(gameDice.rollDice());
		System.out.println(players.get(0));
		players.get(0).moveBy(gameDice.rollDice());
		System.out.println(players.get(0));
		players.get(0).moveBy(gameDice.rollDice());
		System.out.println(players.get(0));
		players.get(0).moveBy(gameDice.rollDice());
		System.out.println(players.get(0));
	}
	
	
}