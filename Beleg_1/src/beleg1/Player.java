package beleg1;

public class Player {
    private Card[] holeCards = new Card[2];
    public Player(){
    }

    public Player(Card card1, Card card2){
        holeCards[0] = card1;
        holeCards[1] = card2;
    }

    protected void setCard(Card card, int cardNum){
        holeCards[cardNum] = card;
    }

    protected Card getCard(int cardNum){
        return holeCards[cardNum];
    }

    protected int holeCardsSize(){
        return holeCards.length;
    }

    protected void printPlayerCards(int playerNumber){
        System.out.println("[GAME] Player " + (playerNumber) + " cards:");
        for (int i=0;i<2;i++){
            System.out.println(holeCards[i].printCard());
        }
        System.out.println("\n");
    }
}