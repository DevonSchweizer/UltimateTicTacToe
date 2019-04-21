/** TicTacToe
 * Allows for a Player v. Player game of TicTacToe.
 */
package ultimatetictactoe;
/**
 * @author Devon Schweizer
 */
public class TicTacToe {
    //Attributes-------------------------------------------------------------
    private int[] board;
    private int winner;
    private int turn;
    private int objects;
    //Constructor-------------------------------------------------------------
    public TicTacToe(){
    board =new int[]{0,0,0,0,0,0,0,0,0};
    winner = 0;
    turn = 1;
    objects = 0;
    }
    //Methods----------------------------------------------------------------
    
    /** checkWinner checks to see if a player has won the board
     * @return - 0 if there is no current winner, 1 if player one is the
     * winner, and 2 if player two is the winner 
     */
    public int checkWinner(){
        //checks 0 1 2
        if(board[0] == 1 && board[1] == 1 && board[2] == 1)
            winner = 1;   
        else if(board[0] == 2 && board[1] == 2 && board[2] == 2)
            winner = 2;
        //checks 0 4 8
        else if(board[0] == 1 && board[4] == 1 && board[8] == 1)
            winner = 1;
        else if(board[0] == 2 && board[4] == 2 && board[8] == 2)
            winner = 2;
        //checks 0 3 6
        else if(board[0] == 1 && board[3] == 1 && board[6] == 1)
            winner = 1;
        else if(board[0] == 2 && board[2] == 2 && board[6] == 2)
            winner = 2;
        //checks 1 4 7
        else if(board[1] == 1 && board[4] == 1 && board[7] == 1)
            winner = 1;
        else if(board[1] == 2 && board[4] == 2 && board[7] == 2)
            winner = 2;
        //checks 2 5 8
        else if(board[2] == 1 && board[5] == 1 && board[8] == 1)
            winner = 1;
        else if(board[2] == 2 && board[5] == 2 && board[8] == 2)
            winner = 2;
        //checks 2 4 6
        else if(board[2] == 1 && board[4] == 1 && board[6] == 1)
            winner = 1;
        else if(board[2] == 2 && board[4] == 2 && board[6] == 2)
            winner = 2;
        //checks 3 4 5
        else if(board[3] == 1 && board[4] == 1 && board[5] == 1)
            winner = 1;
        else if(board[3] == 2 && board[4] == 2 && board[5] == 2)
            winner = 2;
        //checks 6 7 8
        else if(board[6] == 1 && board[7] == 1 && board[8] == 1)
            winner = 1;
        else if(board[6] == 2 && board[7] == 2 && board[8] == 2)
            winner = 2;
        
        return winner;
    }
    
    /**canMakeMove checks to see if the move is valid
     * @param move the location that the player wants to place their mark
     * @return true if the move is valid, false if it is not
     */
    public boolean canMakeMove(int move){
        return board[move] == 0;
    }
    
    /**makeMove makes the current players move if it is valid
     * @param move the location that the player wants to place their mark
     */
    public void makeMove(int move){
        if(canMakeMove(move)){
            if(turn%2 == 1)
                board[move] = 1;
            else if(turn%2 == 0)
                board[move] = 2;
            nextTurn();
            objects++;
        }
    }
    /** nextTurn increments the turn
     * 
     */
    public void nextTurn(){
        turn++;
    }   
    
    /**getPlayerTurn checks to see chick players turn it is
     * @return 1 if player 1 has the current move, 2 if player 
     *  2 has the current move, 0 if error
     */
    public int getPlayerTurn(){
        switch (turn % 2) {
            case 1:
                return 1;
            case 0:
                return 2;
            default:
                return 0;
        }
    }
    
    /** getTurn gets the current turn
     * @return the turn that is currently being played
     */
    public int getTurn(){
        return turn;
    }
    
    /** toString creates and prints out a string representation of the game
     * @return a string representation of the board
     */
    @Override
    public String toString(){
        String output =  
                  "{"+board[0]+"   "+board[1]+"   "+board[2]+"}\n"
                + "{"+board[3]+"   "+board[4]+"   "+board[5]+"}\n"
                + "{"+board[6]+"   "+board[7]+"   "+board[8]+"}\n";
        
        return output;
    }
    
    /** checkDraw checks to see if the board is a draw
     * @return  true if the board is a draw, false if it is not
     */
    public boolean checkDraw(){
        return objects == 9;
    }
    
    /** getBoard gets the value at a location in the board
     * @param spot the location on the board the is being checked
     * @return the value of the spot on the board
     */
    public int getBoard(int spot){
        return board[spot];
    }
    
    /** getObjects returns the number of objects on the board
     * @return the number of objects placed on the board
     */
    public int getObjects(){
        return objects;
    }
}
