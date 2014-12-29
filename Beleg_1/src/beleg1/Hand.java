package beleg1;

import java.util.Arrays;
import java.util.TreeMap;

public class Hand {
	private Card[] availableCards = new Card[7];
	static int[] points;
	private final static short ONE = 1;
	private final static short TWO = 2;
	private final static short THREE = 3;
	private final static short FOUR = 4;
	static int currentPlayer = 0;
	static int numPlayers = 0;
	static boolean check = false;
	static Object[] pointsort;
	static Object[] playersort;
	int maxpoints = 0;
	static int[] winner;
	int localpool = Bidding.pool;
	int winners = 0;
	int cash = 0;
	private static boolean[] deadplayers;
	TreeMap<String,Integer> coreboard = new TreeMap<String,Integer>();
	public Hand(){
	}

	public static boolean getDeadplayers(int i) {
		return deadplayers[i];
	}

	public static void setDeadplayers(boolean[] deadplayers) {
		Hand.deadplayers = deadplayers;
	}

	public static void handini(int playerint){
		if(TexasHoldEm.restart==false){
			deadplayers = new boolean[playerint];
		}
		points = new int[playerint];
		playersort = new Object[playerint];
		pointsort = new Object[playerint];
		winner = new int[playerint];
		for(int i=0;i<playerint;i++){
			points[i] = 42;
			playersort[i] = 42;
			pointsort[i] = 42;
			winner[i] = 42;
			if(TexasHoldEm.restart==false){
				//System.out.println("[DEBUG] Reseting deadplayer");
				deadplayers[i] = false;
			}
		}
	}
	protected void addMaxPlayer(int i){
		numPlayers = i;
	}
	protected void addPlayer(int i){
		currentPlayer = i;
	}
	protected void addCard(Card card, int i){
		availableCards[i] = card;
	}

	protected Card getCard(int i){
		return availableCards[i];
	}

	protected int numCards(){
		return availableCards.length;
	}

	protected void sortByRank(){
		Arrays.sort(availableCards, new rankComparator());
	}

	protected void sortBySuit(){
		Arrays.sort(availableCards, new suitComparator());
	}

	protected void sortBySuitThenRank(){
		Arrays.sort(availableCards, new suitComparator());
		Arrays.sort(availableCards, new rankComparator());
	}

	protected void sortByRankThenSuit(){
		Arrays.sort(availableCards, new rankComparator());
		Arrays.sort(availableCards, new suitComparator());
	}

	protected String evaluateHand(){
		String handResult = new String();
		short[] rankCounter = new short[13];
		short[] suitCounter = new short[4];

		// initializations
		for (int i=0;i<rankCounter.length;i++){
			rankCounter[i] =0;
		}

		for (int i=4;i<suitCounter.length;i++){
			suitCounter[i] = 0;
		}

		// Loop through sorted cards and total ranks
		for(int i=0; i<availableCards.length;i++){
			rankCounter[ availableCards[i].getRank() ]++;
			suitCounter[ availableCards[i].getSuit() ]++;
		}

		//sort cards for evaluation
		this.sortByRankThenSuit();

		// hands are already sorted by rank and suit for royal and straight flush checks.
		// check for royal flush
		check = false;
		handResult = evaluateRoyal(rankCounter, suitCounter);
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 10000;
			check = false;
		}
		// check for straight flush
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateStraightFlush(rankCounter, suitCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 9000;
			check = false;
		}
		// check for four of a kind
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateFourOfAKind(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 8000;
			check = false;
		}
		// check for full house
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateFullHouse(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 7000;
			check = false;
		}
		// check for flush
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateFlush(rankCounter, suitCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 6000;
			check = false;
		}
		// check for straight
		if (handResult == null || handResult.length() == 0){
			this.sortByRank();
			handResult = evaluateStraight(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 5000;
			check = false;
		}
		// check for three of a kind
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateThreeOfAKind(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 4000;
			check = false;
		}
		// check for two pair
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateTwoPair(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 3000;
			check = false;
		}
		// check for one pair
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateOnePair(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 2000;
			check = false;
		}
		// check for highCard
		if (handResult == null || handResult.length() == 0){
			handResult = evaluateHighCard(rankCounter);
		}
		if (check == true){
			points[currentPlayer] = points[currentPlayer] + 1000;
			check = false;
		}
		String playerHighCard = evaluateHighCard(rankCounter);
		playerHighCard = playerHighCard.substring(11);
		switch (playerHighCard){
		case "Ass":
			points[currentPlayer] = points[currentPlayer] + 13;
			break;
		case "König":
			points[currentPlayer] = points[currentPlayer] + 12;
			break;
		case "Dame":
			points[currentPlayer] = points[currentPlayer] + 11;
			break;
		case "Bube":
			points[currentPlayer] = points[currentPlayer] + 10;
			break;
		case "10":
			points[currentPlayer] = points[currentPlayer] + 9;
			break;
		case "9":
			points[currentPlayer] = points[currentPlayer] + 8;
			break;
		case "8":
			points[currentPlayer] = points[currentPlayer] + 7;
			break;
		case "7":
			points[currentPlayer] = points[currentPlayer] + 6;
			break;
		case "6":
			points[currentPlayer] = points[currentPlayer] + 5;
			break;
		case "5":
			points[currentPlayer] = points[currentPlayer] + 4;
			break;
		case "4":
			points[currentPlayer] = points[currentPlayer] + 3;
			break;
		case "3":
			points[currentPlayer] = points[currentPlayer] + 2;
			break;
		case "2":
			points[currentPlayer] = points[currentPlayer] + 1;
			break;
		}
		if(currentPlayer+1==numPlayers){
			System.out.println("[GAME] Player " + currentPlayer + " hand value: " + handResult);
			//DEBUG print all raw scores
			System.out.println("\n-----------------------------------------");
			System.out.println("[GAME] The Round has come to an end:");
			coreboard = BSortWinnerScoreboard.generateScoreboard(points);
			//TEST func to output player in right order
			//System.out.println("Winners: " + coreboard.keySet());
			playersort = coreboard.keySet().toArray();
			pointsort = coreboard.values().toArray();
			//END TEST
			//BEGINN GET WINNER
			for(int i=0;i<playersort.length;i++){
				boolean flag = false;
				int currentpoints = (int) pointsort[i];
				String currplayer = playersort[i].toString();
				int currentplayer = Integer.parseInt(currplayer);
				if(currentpoints>maxpoints && getDeadplayers(i)==false){
					for(int ia = 0;ia<playersort.length;ia++){
						winner[ia] = 42;
					}
					winner[i] = currentplayer;
					maxpoints = currentpoints;
					flag = true;
				}
				if(currentpoints==maxpoints && flag==false && getDeadplayers(i)==false){
					winner[i] = currentplayer;
					maxpoints = currentpoints;
				}
				flag = false;
			}
			for (int element : winner) {
				if(element!=42){
					winners++;
				}
			}
			if(winners==0){
				//for(int i=0;i<winner.length;i++){
				//	System.out.println("[DEBUG]" + winner[i]);
				//}
				System.out.println("[DEBUG] Something went horrible wrong.");
				System.out.println("[GAME] NOBODY WON");
				System.exit(0);
			}
			cash = (int) (Math.floor(localpool/winners));
			//END GETWINNER
			//BEGINN PRINT WINNER
			if(winners==1){
				for(int b=0;b<winner.length;b++){
					if(winner[b]!=42){
						System.out.println("[GAME] The Winner is: Player " + winner[b]);
						System.out.println("[GAME] Winning " + cash + " MoneyUnits");
						Bidding.PlayerMoney[winner[b]] = Bidding.PlayerMoney[winner[b]]+cash;
					}
				}
			}
			if(winners!=1){
				System.out.println("[GAME] The Winners are:");
				for(int b=0;b<winner.length;b++){
					if(winner[b]!=42){
						System.out.println("Player" + winner[b]);
						Bidding.PlayerMoney[winner[b]] = Bidding.PlayerMoney[winner[b]]+cash;
					}
				}
				System.out.println("[GAME] Winning " + cash + " MoneyUnits\n");
			}
		}
		System.out.println("\n-----------------------------------------");
		if(currentPlayer+1!=numPlayers){
			return handResult;
		}
		else{
			try {
				for(int i=0;i<numPlayers;i++){
					if(Bidding.PlayerMoney[i]==0){
						System.out.println("[GAME] Player" + i + " is eliminated;");
						deadplayers[i] = true;
					}
				}
				int d=0;
				for(boolean x : deadplayers){
					if(x==false){
						d++;
					}
				}
				//System.out.println("[DEBUG] Living Players: " + d);
				if(d==1){
					System.out.println("\n\n=========================================");
					System.out.println("=========================================");
					System.out.println("[GAME] The Game is over !\n");
					for (int element : winner) {
						if(element!=42){
							System.out.println("[GAME] The Winner is: Player " + element);
							System.out.println("[GAME] Winning " + cash + " MoneyUnits");
							System.out.println("=========================================");
							System.out.println("=========================================");
							System.exit(0);
						}
					}
				}
				Restart.restart(numPlayers);
				TexasHoldEm.main(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	private String evaluateRoyal(short[] rankCounter, short[] suitCounter){
		String result = "";

		if ((rankCounter[9] >= 1 &&
				rankCounter[10] >= 1 &&
				rankCounter[11] >= 1 &&
				rankCounter[12] >= 1 &&
				rankCounter[0] >= 1)
				&& (suitCounter[0] > 4 || suitCounter[1] > 4 ||
						suitCounter[2] > 4 || suitCounter[3] > 4)){
			royalSearch:
				for (int i=0;i<3;i++){

					if (availableCards[i].getRank() == 0){
						for (int j=1;j<4-i;j++){
							if ((availableCards[i+j].getRank() == 9 &&
									availableCards[i+j+1].getRank() == 10 &&
									availableCards[i+j+2].getRank() == 11 &&
									availableCards[i+j+3].getRank() == 12)
									&&
									(availableCards[i].getSuit() == availableCards[i+j].getSuit() &&
									availableCards[i].getSuit() == availableCards[i+j+1].getSuit() &&
									availableCards[i].getSuit() == availableCards[i+j+2].getSuit() &&
									availableCards[i].getSuit() == availableCards[i+j+3].getSuit())){
								result = "Royal Flush!! Suit: " + Card.suitAsString(availableCards[i].getSuit());
								check = true;
								break royalSearch;
							}
						}
					}
				}
		}

		return result;
	}

	private String evaluateStraightFlush(short[] rankCounter, short[] suitCounter){
		String result = "";

		if (suitCounter[0] > 4 || suitCounter[1] > 4 ||
				suitCounter[2] > 4 || suitCounter[3] > 4){

			for (int i=availableCards.length-1;i>3;i--){
				if ((availableCards[i].getRank()-ONE == availableCards[i-ONE].getRank() &&
						availableCards[i].getRank()-TWO == availableCards[i-TWO].getRank() &&
						availableCards[i].getRank()-THREE == availableCards[i-THREE].getRank() &&
						availableCards[i].getRank()-FOUR == availableCards[i-FOUR].getRank())
						&&
						(availableCards[i].getSuit() == availableCards[i-ONE].getSuit() &&
						availableCards[i].getSuit() == availableCards[i-TWO].getSuit() &&
						availableCards[i].getSuit() == availableCards[i-THREE].getSuit() &&
						availableCards[i].getSuit() == availableCards[i-FOUR].getSuit())){
					result = "Straight Flush!! " + Card.rankAsString(availableCards[i].getRank()) + " high of " + Card.suitAsString(availableCards[i].getSuit());
					check = true;
					break;
				}
			}
		}

		return result;
	}

	private String evaluateFourOfAKind(short[] rankCounter){
		String result = "";

		for (int i=0;i<rankCounter.length;i++){
			if (rankCounter[i] == FOUR){
				result = "Four of a Kind, " + Card.rankAsString(i) +"'s";
				check = true;
				break;
			}
		}

		return result;
	}

	private String evaluateFullHouse(short[] rankCounter){
		String result = "";
		short threeOfKindRank = -1;
		short twoOfKindRank = -1;

		for (int i=rankCounter.length;i>0;i--){
			if ((threeOfKindRank < (short)0) || (twoOfKindRank < (short)0)){
				if ((rankCounter[i-ONE]) > 2){
					threeOfKindRank = (short) (i-ONE);
				}
				else if ((rankCounter[i-ONE]) > 1){
					twoOfKindRank = (short)(i-ONE);
				}
			}
			else
			{
				break;
			}
		}

		if ((threeOfKindRank >= (short)0) && (twoOfKindRank >= (short)0)){
			result = "Full House: " + Card.rankAsString(threeOfKindRank) + "'s full of " + Card.rankAsString(twoOfKindRank) + "'s";
			check = true;
		}

		return result;
	}

	private String evaluateFlush(short[] rankCounter, short[] suitCounter){
		String result = "";

		if (suitCounter[0] > 4 || suitCounter[1] > 4 ||
				suitCounter[2] > 4 || suitCounter[3] > 4){

			for (int i=availableCards.length-1;i>3;i--){
				if (availableCards[i].getSuit() == availableCards[i-ONE].getSuit() &&
						availableCards[i].getSuit() == availableCards[i-TWO].getSuit() &&
						availableCards[i].getSuit() == availableCards[i-THREE].getSuit() &&
						availableCards[i].getSuit() == availableCards[i-FOUR].getSuit()){
					result = "Flush!! " + Card.rankAsString(availableCards[i].getRank()) + " high of " + Card.suitAsString(availableCards[i].getSuit());
					check = true;
					break;
				}
			}
		}


		return result;
	}

	private String evaluateStraight(short[] rankCounter){
		String result = "";

		for (int i=rankCounter.length;i>4;i--){
			if ((rankCounter[i-1] > 0) &&
					(rankCounter[i-2] > 0) &&
					(rankCounter[i-3] > 0) &&
					(rankCounter[i-4] > 0) &&
					(rankCounter[i-5] > 0)){
				result = "Straight " + Card.rankAsString(i-1) + " high";
				check = true;
				break;
			}
		}
		return result;
	}

	private String evaluateThreeOfAKind(short[] rankCounter){
		String result = "";

		for (int i=rankCounter.length;i>0;i--){
			if (rankCounter[i-1] > 2){
				result = "Three of a Kind " + Card.rankAsString(i-1) + "'s";
				check = true;
				break;
			}
		}
		return result;
	}

	private String evaluateTwoPair(short[] rankCounter){
		String result = "";
		short firstPairRank = -1;
		short secondPairRank = -1;

		for (int i=rankCounter.length;i>0;i--){
			if ((firstPairRank < (short)0) || (secondPairRank < (short)0)){
				if (((rankCounter[i-ONE]) > 1) && (firstPairRank < (short)0)){
					firstPairRank = (short) (i-ONE);
				}
				else if ((rankCounter[i-ONE]) > 1){
					secondPairRank = (short)(i-ONE);
				}
			}
			else
			{
				break;
			}
		}

		if ((firstPairRank >= (short)0) && (secondPairRank >= (short)0)){
			if (secondPairRank == (short)0){
				result = "Two Pair: " + Card.rankAsString(secondPairRank) + "'s and " + Card.rankAsString(firstPairRank) + "'s";
				check = true;
			}
			else
			{
				result = "Two Pair: " + Card.rankAsString(firstPairRank) + "'s and " + Card.rankAsString(secondPairRank) + "'s";
				check = true;
			}
		}

		return result;
	}

	private String evaluateOnePair(short[] rankCounter){
		String result = "";

		for (int i=rankCounter.length;i>0;i--){
			if((rankCounter[i-ONE]) > 1){
				result = "One Pair: " + Card.rankAsString(i-ONE) + "'s";
				check = true;
				break;
			}
		}
		return result;
	}

	private String evaluateHighCard(short[] rankCounter){
		String result = "";

		for (int i=rankCounter.length;i>0;i--){
			if((rankCounter[i-ONE]) > 0){
				result = "High Card: " + Card.rankAsString(i-ONE);
				check = true;
				break;
			}
		}
		return result;
	}

}