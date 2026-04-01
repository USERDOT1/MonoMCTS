
public class AdvanceToCard extends Card {
	int tileToAdvanceToIndex;
	public final Boolean passGo;
	public AdvanceToCard(String name, int tileToAdvanceToIndex, Boolean passGo) {
		super(name);
		this.tileToAdvanceToIndex = tileToAdvanceToIndex;
		this.passGo = passGo;
	}
	public AdvanceToCard(String name, int tileToAdvanceToIndex) {
		super(name);
		this.tileToAdvanceToIndex = tileToAdvanceToIndex;
		this.passGo = true;
	}
	
	public void execute(Player player) {
		player.moveTo(tileToAdvanceToIndex,true);
	}
	
}
