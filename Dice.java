public class Dice{
	public int dice1 = 6;
	public int dice2 = 6;
	public int rollDice() {
		dice1 = (int) (Math.random()*6) + 1;
		dice2 = (int) (Math.random()*6) + 1;
		return dice1+dice2;
	}
	
	public int getDiceValue() {
		return dice1+dice2;
	}
	
	public Boolean isDoubles() {
		if (dice1 == dice2) {
			return true;
		}
		return false;
	}
}