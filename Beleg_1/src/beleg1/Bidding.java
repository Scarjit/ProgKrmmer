package beleg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Bidding {
	static int pool;
	static int[] PlayerMoney;
	static boolean[] PlayerAllin;
	static boolean cheat = false;
	public Bidding(){
	}
	public static void Bid(int playerint){
		PlayerMoney = new int[playerint];
		for(int i=0;i<playerint;i++){
			PlayerMoney[i] = 1000;
		}
		PlayerAllin = new boolean[playerint];
	}
	protected static void addBid(int playerint){
		int bidvalue = 0;
		String userInput = "";
		//System.out.println("[DEBUG] Addbid deadplayer: "+Hand.getDeadplayers(playerint));
		if(PlayerAllin[playerint]!=true && Hand.getDeadplayers(playerint)==false){
			System.out.println("\n-----------------------------------------");
			TexasHoldEm.print("[GAME] Player " + (playerint) + " currently has " + PlayerMoney[playerint] + " Moneyunits");
			TexasHoldEm.print("[GAME] Enter Bid:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				userInput = br.readLine();
			} catch (IOException ioe) {
				TexasHoldEm.print("[Error] IO error trying to read input!");
				System.exit(1);
			}
			try {
				bidvalue = Integer.parseInt(userInput);
			} catch (NumberFormatException nfe) {
				TexasHoldEm.print("[Error] Input provided is not a valid Integer!");
				TexasHoldEm.print("[GAME] Detected Cheating, going allin");
				PlayerAllin[playerint] = true;
				bidvalue = PlayerMoney[playerint];
				cheat = true;
			}
			if (bidvalue<1 && cheat != true){
				TexasHoldEm.print("[Error] Too small bid, passing");
				bidvalue = 0;
			}
			if (bidvalue>PlayerMoney[playerint] && cheat != true){
				TexasHoldEm.print("[Error] Too large bid, going allin");
				PlayerAllin[playerint] = true;
				bidvalue = PlayerMoney[playerint];
			}
			PlayerMoney[playerint] = PlayerMoney[playerint] - bidvalue;
			TexasHoldEm.print("[GAME] Added " + bidvalue + " to the Pool");
			pool = pool + bidvalue;
			TexasHoldEm.print("[GAME] Current pool :" + pool);
			cheat = false;
		}
	}
}
