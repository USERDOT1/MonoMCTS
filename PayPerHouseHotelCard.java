public class PayPerHouseHotelCard extends Card{
	private final int pricePerHouse;
	private final int pricePerHotel;

	public PayPerHouseHotelCard(String name, int pricePerHouse, int pricePerHotel){
		super(name);
		this.pricePerHouse = pricePerHouse;
		this.pricePerHotel = pricePerHotel;
	}

	@Override
	public void execute(Player player){
		int cost = 0;

		for(int i = 0; i < player.assets.size(); i++){
			if(player.assets.get(i) instanceof Property){
				Property property = (Property) player.assets.get(i);

				if(property.hasHotel){
					cost += pricePerHotel;
				}else{
					cost += pricePerHouse * property.houseNumber;
				}
			}
		}

		GameControl.playerBankMoneyExchange(player, cost);
	}
}