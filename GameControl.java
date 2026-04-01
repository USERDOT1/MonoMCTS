
public class GameControl {
	public static void playerMoneyExchange(Player fromPlayer, Player toPlayer, int amount) {
		if (fromPlayer.getMoney() >= amount) {
			fromPlayer.subtractMoney(amount);
			toPlayer.addMoney(amount);
		}
		else {
			//BANKRUPTCY!!! (or morgaging selling housing ect.)
		}
	}
	
	public static void playerBankMoneyExchange(Player fromPlayer, int amount) {
		if (fromPlayer.getMoney() >= amount) {
			fromPlayer.subtractMoney(amount);
		}
		else {
			//BANKRUPTCY!!! (or morgaging selling housing ect.)
		}
		
	}
	
	public static void playerAssetsExchange(Player fromPlayer, Player toPlayer, Asset[] assets) {
		for(int assetIndex = 0; assetIndex < assets.length; assetIndex++) {
			fromPlayer.assets.remove(assets[assetIndex]);
			toPlayer.assets.add(assets[assetIndex]);
		}
		
	}
}
