package beleg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TexasHoldEm {
	static int numPlayers = 0;
	static boolean restart = false;
	public static void main(String[] args) throws Exception {
		// vars
		Deck holdemDeck = new Deck();
		int cardCounter = 0;
		int boardCounter = 0;
		Board board = new Board();
		// initializations
		if(restart==false){
			numPlayers = getNumberOfPlayers();
		}
		Player[] player = new Player[numPlayers];
		holdemDeck.shuffle();
		if(restart==false){
			Bidding.Bid(numPlayers);
		}
		Hand.handini(numPlayers);
		//BSortWinnerScoreboard.IniScoreboard(numPlayers);
		// Initialize players
		for (int i=0;i<numPlayers;i++){
			player[i] = new Player();
		}
		// Main processing
		// Deal cards to players
		for (int i=0;i<2;i++){
			for (int j=0;j<numPlayers;j++){
				player[j].setCard(holdemDeck.getCard(cardCounter++), i);
			}
		}
		for (int i=0;i<numPlayers;i++){
			player[i].printPlayerCards(i);
		}
		// Leaving blinds out (rule problems)
		playerrotation();
		// Start dealing board
		// deal flop
		for (int i=0; i<3;i++){
			board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);
			board.Round = board.Round + 1;
		}
		print("[GAME] Board: ");
		board.printBoard();
		playerrotation();
		// deal turn
		board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);
		board.Round = board.Round + 1;
		print("[GAME] Board: ");
		board.printBoard();
		playerrotation();
		// deal river
		board.setBoardCard(holdemDeck.getCard(cardCounter++), boardCounter++);
		board.Round = board.Round + 1;
		print("[GAME] Board: ");
		board.printBoard();
		playerrotation();
		//------------------------
		// end dealing board
		//------------------------
		print("[GAME] The Board is Complete...");

		board.printBoard();
		print("[GAME] The player cards are the following:\n");
		for (int i=0;i<numPlayers;i++){
			player[i].printPlayerCards(i);
		}
		for (int i=0;i<numPlayers;i++){
			Hand handToEval = new Hand();

			for (int j=0;j<player[i].holeCardsSize();j++){
				handToEval.addCard(player[i].getCard(j),j);
			}

			for (int j=player[i].holeCardsSize();j<(player[i].holeCardsSize()+board.boardSize());j++){
				handToEval.addCard(board.getBoardCard(j-player[i].holeCardsSize()),j);
			}
			handToEval.addPlayer(i);
			handToEval.addMaxPlayer(numPlayers);
			String hand = handToEval.evaluateHand();
			if(hand!=null){
				print("[GAME] Player " + (i) + " hand value: " + hand);
			}

		}

	}
	protected static int getNumberOfPlayers() throws Exception{
		int intPlayers = 0;
		String userInput = "";
		print("[GAME] Enter number of players (1-22):");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			userInput = br.readLine();
		} catch (IOException ioe) {
			print("[Error] IO error trying to read input!");
			System.exit(1);
		}
		try {
			intPlayers = Integer.parseInt(userInput);
		} catch (NumberFormatException nfe) {
			print("[Error] Input provided is not a valid Integer!");
			System.exit(1);
		}
		if (intPlayers==42){
			print("[DEV] Answer to the Ultimate Question of Life, the Universe, and Everything");
			System.exit(42);
		}
		if ((intPlayers<1) || (intPlayers>22)){
			print("[Error] Number of players must be an integer between 1 and 22");
			System.exit(1);
		}
		return intPlayers;
	}
	public static void print(Object args) {
		System.out.println(args.toString());
	}
	public static void playerrotation(){
		for (int i=0;i<numPlayers;i++){
			Bidding.addBid(i);
		}
	}
}