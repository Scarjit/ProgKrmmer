package beleg1;

public class Board {
    private Card[] board = new Card[5];
    int Round = 0;
    //constructor
    public Board(){
    }

    //methods
    protected void setBoardCard(Card card, int cardNum){
        this.board[cardNum] = card;
    }

    protected Card getBoardCard(int cardNum){
        return this.board[cardNum];
    }

    protected int boardSize(){
        return board.length;
    }

    protected void printBoard(){
        System.out.println("[GAME] The board contains the following cards:");
        for(int i =0; i<Round;i++){
            System.out.println(i+1 + ": " + getBoardCard(i).printCard());
        }
        System.out.println("\n");
    }


}