package beleg1;

public class Restart {
	public static void restart(int numPlayers){
		TexasHoldEm.print("\n[GAME] Going to next Round, please wait\n");
		TexasHoldEm.restart = true;
		TexasHoldEm.numPlayers = numPlayers;
		Bidding.pool = 0;
		Bidding.cheat = false;
		for(int i=0;i<numPlayers;i++){
			Bidding.PlayerAllin[i] = false;
		}
		Hand.check = false;
	}
}
