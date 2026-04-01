import java.util.ArrayList;
import java.util.Collections;

public class Board{
	private ArrayList<Card> communityChestCards = generateCommunityChestCards();
	private ArrayList<Card> chanceCards = generateChanceCards();
	public Tile[] tiles;
	
	
	public Board(Dice gameDice) {
		tiles = generateBoard(communityChestCards,chanceCards,gameDice);
	}
	public static ArrayList<Card> generateChanceCards(){
		ArrayList<Card> chanceCards = new ArrayList<Card>();
		chanceCards.add(new PayPerHouseHotelCard("MAKE GENERAL REPAIRS",25,100));
		//chanceCards.add(new ()); // MOVE BACK 3 SPACES
		chanceCards.add(new AdvanceToCard("ADVANCE TO GO",0));
		//chanceCards.add(new ()); // Move to NEAREST RAILROAD Pay OWNER TWICE
		chanceCards.add(new AdvanceToCard("ADVANCE TO ILLINOIS AVENUE",24)); //
		chanceCards.add(new AdvanceToCard("TAKE A RIDE ON THE READING",5));
		chanceCards.add(new AdvanceToCard("TAKE A WALK ON THE BOARD WALK",39));
		chanceCards.add(new AdvanceToCard("ADVANCE TO ST. CHARLES PLACE",11));
		chanceCards.add(new AdvanceToCard("GO DIRECTLY TO JAIL",30,false));
		//Advance to nearest utility + pay 10 times dice roll
		chanceCards.add(new GetOutOfJailFreeCard());
		//MOVE TO NEAREST RAIROAD x2 duplicate
		chanceCards.add(new MonetaryOffsetCard("BUILDING AND LOAN MATURES",150));
		chanceCards.add(new MonetaryOffsetCard("BANK PAYS YOU DIVIDEND",50));
		chanceCards.add(new MonetaryOffsetCard("PAY POOR TAX",15));
		return chanceCards;
	}
	public static ArrayList<Card> generateCommunityChestCards(){
		ArrayList<Card> communityChestCards = new ArrayList<Card>();
		communityChestCards.add(new PayPerHouseHotelCard("ASSESSED FOR STREET REPAIRS",40,115));
		communityChestCards.add(new MonetaryOffsetCard("SECOND PRIZE IN BEAUTY CONTEST",10));
		communityChestCards.add(new MonetaryOffsetCard("BANK ERROR IN YOUR FAVOR",200));
		communityChestCards.add(new MonetaryOffsetCard("LIFE INSURANCE MATURES",100));
		communityChestCards.add(new MonetaryOffsetCard("RECEIVE FOR SERVICES",25));
		communityChestCards.add(new MonetaryOffsetCard("FROM SALE OF STOCK",45));
		communityChestCards.add(new MonetaryOffsetCard("XMAS FUND MATURES",100));
		communityChestCards.add(new MonetaryOffsetCard("INCOME TAX REFUND",20));
		communityChestCards.add(new MonetaryOffsetCard("PAY SCHOOL TAX",-150));
		communityChestCards.add(new MonetaryOffsetCard("PAY HOSPITAL",-100));
		communityChestCards.add(new MonetaryOffsetCard("YOU INHERIT",100));
		communityChestCards.add(new MonetaryOffsetCard("DOCTORS FEE",-50));
		communityChestCards.add(new AdvanceToCard("GO TO JAIL",10,false));
		communityChestCards.add(new AdvanceToCard("ADVANCE TO GO",0));
		communityChestCards.add(new GetOutOfJailFreeCard());
		
		
		return communityChestCards;
	}
    public static Tile[] generateBoard(ArrayList<Card> communityChestCards, ArrayList<Card> chanceCards, Dice gameDice){
    	Tile[] newBoardTiles = new Tile[40];
        for(int i = 0;i<40;i++){
            if (i == 0){
            	newBoardTiles[i] = new GoTile(i);
            }
            else if (i == 1){
            	newBoardTiles[i] = new PropertyTile(i,"MEDITERRANEAN AVENUE",0,new int[]{2,10,30,90,160,250},50,30);
            }
            else if (i == 2) {
            	newBoardTiles[i] = new CommunityChestTile(i,communityChestCards);
            }
            else if (i == 3){
            	newBoardTiles[i] = new PropertyTile(i,"BALTIC AVENUE",0,new int[]{4,20,60,180,320,450},50,30);
            }
            else if (i == 4) {
            	newBoardTiles[i] = new IncomeTaxTile(i);
            }
            else if (i == 5) {
            	newBoardTiles[i] = new RailroadTile(i,"READING RAILROAD");
            }
            else if (i == 6){
            	newBoardTiles[i] = new PropertyTile(i,"ORIENTAL AVENUE",1,new int[]{6,30,90,270,400,550},50,50);
            }
            else if (i == 7) {
            	newBoardTiles[i] = new ChanceTile(i,chanceCards);
            }
            else if (i == 8){
            	newBoardTiles[i] = new PropertyTile(i,"VERMONT AVENUE",1,new int[]{6,30,90,270,400,550},50,50);
            }
            else if (i == 9){
            	newBoardTiles[i] = new PropertyTile(i,"CONNECTICUT AVENUE",1,new int[]{8,40,100,300,450,600},50,60);
            }
            else if (i == 10) {
            	newBoardTiles[i] = new JailTile(i);
            }
            else if (i == 11){
            	newBoardTiles[i] = new PropertyTile(i,"SAINT CHARLES PLACE",2,new int[]{8,40,100,300,450,600},100,60);
            }
            else if (i == 12) {
            	newBoardTiles[i] = new UtilityTile(i,"ELECTRIC COMPANY",gameDice);
            }
            else if (i == 13){
            	newBoardTiles[i] = new PropertyTile(i,"STATES AVENUE",2,new int[]{8,40,100, 300,450,600},100,60);
            }
            else if (i == 14){
            	newBoardTiles[i] = new PropertyTile(i,"VIRGINIA AVENUE",2,new int[]{12,60,180,500,700,900},100,80);
            }
            else if (i == 15) {
            	newBoardTiles[i] = new RailroadTile(i, "PENNSYLVANIA RAILROAD");
            }
            else if (i == 16){
            	newBoardTiles[i] = new PropertyTile(i,"SAINT JAMES PLACE",3,new int[]{14,70,200,550,750,950},100,90);
            }
            else if (i == 17) {
            	newBoardTiles[i] = new CommunityChestTile(i,communityChestCards);
            }
            else if (i == 18){
            	newBoardTiles[i] = new PropertyTile(i,"TENNESSEE AVENUE",3,new int[]{14,70,200,550,750,950},100,90);
            }
            else if (i == 19){
            	newBoardTiles[i] = new PropertyTile(i,"NEW YORK AVENUE",3,new int[]{16,80,220,600,800,1000},100,100);
            }
            else if (i == 20) {
            	newBoardTiles[i] = new FreeParkingTile(i);
            }
            else if (i == 21){
            	newBoardTiles[i] = new PropertyTile(i,"KENTUCKY AVENUE",4,new int[]{18,90,250,700,875,1050},150,110);
            }
            else if (i == 22) {
            	newBoardTiles[i] = new ChanceTile(i,chanceCards);
            }
            else if (i == 23){
            	newBoardTiles[i] = new PropertyTile(i,"INDIANA AVENUE",4,new int[]{18,90,250,700,875,1050},150,110);
            }
            else if (i == 24){
            	newBoardTiles[i] = new PropertyTile(i,"ILLINOIS AVENUE",4,new int[]{20,100,300,750,925,1100},150,120);
            }
            else if (i == 25) {
            	newBoardTiles[i] = new RailroadTile(i,"B. & O. RAILROAD");
            }
            else if (i == 26){
            	newBoardTiles[i] = new PropertyTile(i,"ATLANTIC AVENUE",5,new int[]{22,110,330,800,975,1150},150,130);
            }
            else if (i == 27){
            	newBoardTiles[i] = new PropertyTile(i,"VENTNOR AVENUE",5,new int[]{22,110,330,800,975,1150},150,130);
            }
            else if (i == 28) {
            	newBoardTiles[i] = new UtilityTile(i,"WATER WORKS",gameDice);
            }
            else if (i == 29){
            	newBoardTiles[i] = new PropertyTile(i,"MARVIN GARDENS",5,new int[]{24,120,360,850,1025,1200},150,140);
            }
            else if (i == 30) {
            	newBoardTiles[i] = new GoToJailTile(i);
            }
            else if (i == 31){
            	newBoardTiles[i] = new PropertyTile(i,"PACIFIC AVENUE",6,new int[]{26,130,390,900,1100,1275},200,150);
            }
            else if (i == 32){
            	newBoardTiles[i] = new PropertyTile(i,"NORTH CAROLINA AVENUE",6,new int[]{26,130,390,900,1100,1275},200,150);
            }
            else if (i == 33) {
            	newBoardTiles[i] = new CommunityChestTile(i,communityChestCards);
            }
            else if (i == 34){
            	newBoardTiles[i] = new PropertyTile(i,"PENNSYLVANIA AVENUE",6,new int[]{28,150,450,1000,1200,1400},200,160);
            }
            else if (i == 35) {
            	newBoardTiles[i] = new RailroadTile(i,"SHORT LINE");
            }
            else if (i == 36) {
            	newBoardTiles[i] = new ChanceTile(i,chanceCards);
            }
            else if (i == 37){
            	newBoardTiles[i] = new PropertyTile(i,"PARK PLACE",7,new int[]{35,175,500,1100,1300,1500},200,175);
            }
            else if (i == 38) {
            	newBoardTiles[i] = new LuxuryTaxTile(i);
            }
            else if (i == 39){
            	newBoardTiles[i] = new PropertyTile(i,"BOARDWALK",7,new int[]{50,200,600,1400,1700,2000},200,200);
            }
        }
		return newBoardTiles;
    }
    public Tile getTileAt(int index){
        return tiles[index];
    }
    public void shuffleChanceCards(){
    	Collections.shuffle(chanceCards);
    }
    public void shuffleCommunityChestCards(){
    	Collections.shuffle(communityChestCards);
    }
    public void shuffleAllCards() {
    	shuffleChanceCards();
    	shuffleCommunityChestCards();
    }
    
    public void addChanceCard(Card card) {
    	chanceCards.add(card);
    }
    
    public void addCommunityChestCard(Card card) {
    	communityChestCards.add(card);
    }
}
