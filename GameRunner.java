import java.util.ArrayList;
import java.util.Scanner;
public class GameRunner{
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Dice gameDice = new Dice();
		Board gameBoard = new Board(gameDice);
		ArrayList<Player> players = new ArrayList<Player>();
		Player user;
		System.out.println("Input amount of players (including you): ");
		int playerNumber = input.nextInt();
		input.nextLine();
		System.out.println("Now entering agent creator. To instantiate self, type name as: \"self\".");
		for(int playerCreationIndex = 0; playerCreationIndex < playerNumber;playerCreationIndex++) {
			System.out.println("Enter the name of player "+(playerCreationIndex+1)+" (Turn Order): ");
			players.add(new Player(input.nextLine(),gameBoard,gameDice));
			if (!players.get(playerCreationIndex).name.equals("self")) {
				System.out.println("Enter the propertyGroup0Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup0Bias = input.nextDouble();
				input.nextLine();//Eats up the return character
				System.out.println("Enter the propertyGroup1Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup1Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the propertyGroup2Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup2Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the propertyGroup3Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup3Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the propertyGroup4Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup4Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the propertyGroup5Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup5Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the propertyGroup6Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup6Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the propertyGroup7Bias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).propertyGroup7Bias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the railroadBias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).railroadBias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the utilityBias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).utilityBias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the leaderTradeBias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).leaderTradeBias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the tradeBias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).tradeBias = input.nextDouble();
				input.nextLine();
				System.out.println("Enter the jailStayBias of player "+(playerCreationIndex+1)+":");
				players.get(playerCreationIndex).jailStayBias = input.nextDouble();
				input.nextLine();
			}
			else {
				players.get(playerCreationIndex).isAgent = false;
				user = players.get(playerCreationIndex);
			}
			
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