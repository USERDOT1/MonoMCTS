import java.util.ArrayList;
import java.util.Scanner;
public class GameRunner{
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Dice gameDice = new Dice();
		Board gameBoard = new Board(gameDice);
		ArrayList<Player> players = new ArrayList<Player>();
		System.out.println("Input amount of players: ");
		int playerNumber = input.nextInt();
		input.nextLine();
		for(int playerCreationIndex = 0; playerCreationIndex < playerNumber;playerCreationIndex++) {
			System.out.println("Enter the name of player "+(playerCreationIndex+1)+": ");
			players.add(new Player(input.nextLine(),gameBoard,gameDice));
		}
		gameBoard.addCommunityChestCard(new GroupPayingCard("GRAND OPERA OPENING",50,players));
		gameBoard.addChanceCard(new GroupPayingCard("ELECTED CHAIRMAN OF THE BOARD",-50,players));
		gameBoard.shuffleAllCards();
		
		for (int i = 0; i < 5000000;i++) {
			System.out.println(players.get(0));
			players.get(0).moveBy(gameDice.rollDice());
		}
		input.close();
	}
	
	
}