
package ultimatetictactoe;

/**
 *
 * @author Devon Schweizer
 */
public class UltimateTicTacToe{
    
    //Attributes
    private TicTacToe tl; private TicTacToe tm; private TicTacToe tr;
    private TicTacToe ml; private TicTacToe mm; private TicTacToe mr;
    private TicTacToe bl; private TicTacToe bm; private TicTacToe br;
    private int boardslocked[];
    private int winner;
    
    //Constructors
    public UltimateTicTacToe(){
        tl = new TicTacToe();tm = new TicTacToe();tr = new TicTacToe();
        ml = new TicTacToe();mm = new TicTacToe();mr = new TicTacToe();
        bl = new TicTacToe();bm = new TicTacToe();br = new TicTacToe();
        winner = 0;
        boardslocked = new int[]{0,0,0,0,0,0,0,0,0};
    }
    
    //Methods
    /** checkWinner check the combination of the overall board see if the is to winner
     * @return 1 if the first player has won, 2 if the second player has won, and 0 if there is no winner
     */
    public int checkWinner(){
        //checks tl tm tr
        if(tl.checkWinner() == 1 && tm.checkWinner() == 1 && tr.checkWinner() == 1)
            winner = 1;   
        else if(tl.checkWinner() == 2 && tm.checkWinner() == 2 && tr.checkWinner() == 2)
            winner = 2;
        //checks tl mm br
        else if(tl.checkWinner() == 1 && mm.checkWinner() == 1 && br.checkWinner() == 1)
            winner = 1;
        else if(tl.checkWinner() == 2 && mm.checkWinner() == 2 && br.checkWinner() == 2)
            winner = 2;
        //checks tl ml bl
        else if(tl.checkWinner() == 1 && ml.checkWinner() == 1 && bl.checkWinner() == 1)
            winner = 1;
        else if(tl.checkWinner() == 2 && ml.checkWinner() == 2 && bl.checkWinner() == 2)
            winner = 2;
        //checks tm mm bm
        else if(tm.checkWinner() == 1 && mm.checkWinner() == 1 && bm.checkWinner() == 1)
            winner = 1;
        else if(tm.checkWinner() == 2 && mm.checkWinner() == 2 && bm.checkWinner() == 2)
            winner = 2;
        //checks tr mr br
        else if(tr.checkWinner() == 1 && mr.checkWinner() == 1 && br.checkWinner() == 1)
            winner = 1;
        else if(tr.checkWinner() == 2 && mr.checkWinner() == 2 && br.checkWinner() == 2)
            winner = 2;
        //checks tr mm bl
        else if(tr.checkWinner() == 1 && mm.checkWinner() == 1 && bl.checkWinner() == 1)
            winner = 1;
        else if(tr.checkWinner() == 2 && mm.checkWinner() == 2 && bl.checkWinner() == 2)
            winner = 2;
        //checks ml mm mr
        else if(ml.checkWinner() == 1 && mm.checkWinner() == 1 && mr.checkWinner() == 1)
            winner = 1;
        else if(ml.checkWinner() == 2 && mm.checkWinner() == 2 && mr.checkWinner() == 2)
            winner = 2;
        //checks bl bm br
        else if(bl.checkWinner() == 1 && bm.checkWinner() == 1 && br.checkWinner() == 1)
            winner = 1;
        else if(bl.checkWinner() == 2 && bm.checkWinner() == 2 && br.checkWinner() == 2)
            winner = 2;
        
        return winner;
    }
    /** checkDraw checks if their is a draw
     * @return returns true if the game is a draw, false if it is not a draw
     */
    public boolean checkDraw(){
        for(int i = 0; i < 9; i++){
            if(boardslocked[i] != 2){
                return false;
            }
        }
        return true;
    }
    // 0 = unlcoked
    // 1 = locked but not won or a draw
    // 2 = locked because of win or draw
    public void makeMove(String board, int spot){
        System.out.println("In make move");
        if(board.equals("tl") && tl.canMakeMove(spot) && boardslocked[0]==0){
            System.out.println("In make move tl");
            tl.makeMove(spot);//attempts to make move
            //loops through the loackedboard
            //if the board is 0 it is unlocked, it then locks all unlocked boards
            //if the board is 2, then the board is locked, and all available boards are unlocked
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
                          tm.nextTurn();tr.nextTurn();
            ml.nextTurn();mm.nextTurn();mr.nextTurn();
            bl.nextTurn();bm.nextTurn();br.nextTurn();
                    
        }
        else if(board.equals("tm") && tm.canMakeMove(spot)&& boardslocked[1]==0){
            tm.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();              tr.nextTurn();
            ml.nextTurn();mm.nextTurn();mr.nextTurn();
            bl.nextTurn();bm.nextTurn();br.nextTurn();
        }
        else if(board.equals("tr") && tr.canMakeMove(spot) && boardslocked[2]==0){
            tr.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();
            ml.nextTurn();mm.nextTurn();mr.nextTurn();
            bl.nextTurn();bm.nextTurn();br.nextTurn();
        }
        else if(board.equals("ml") && ml.canMakeMove(spot) && boardslocked[3]==0){
            ml.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();tr.nextTurn();
                          mm.nextTurn();mr.nextTurn();
            bl.nextTurn();bm.nextTurn();br.nextTurn();
        }
        else if(board.equals("mm") && mm.canMakeMove(spot) && boardslocked[4]==0){
            mm.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0);
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();tr.nextTurn();
            ml.nextTurn();              mr.nextTurn();
            bl.nextTurn();bm.nextTurn();br.nextTurn();
        }
        else if(board.equals("mr") && mr.canMakeMove(spot) && boardslocked[5]==0){
            mr.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();tr.nextTurn();
            ml.nextTurn();mm.nextTurn();
            bl.nextTurn();bm.nextTurn();br.nextTurn();
        }
        else if(board.equals("bl") && bl.canMakeMove(spot) && boardslocked[6]==0){
            bl.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();tr.nextTurn();
            ml.nextTurn();mm.nextTurn();mr.nextTurn();
                          bm.nextTurn();br.nextTurn();
        }
        else if(board.equals("bm") && bm.canMakeMove(spot) && boardslocked[7]==0){
            bm.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();tr.nextTurn();
            ml.nextTurn();mm.nextTurn();mr.nextTurn();
            bl.nextTurn();              br.nextTurn();
        }
        else if(board.equals("br") && br.canMakeMove(spot) && boardslocked[8]==0){
            br.makeMove(spot);
            for(int i = 0; i < 9; i++){
                if(boardslocked[i]==0)
                    boardslocked[i] = 1;
            }
            if(boardslocked[spot] == 2){
                for(int i = 0; i < 9; i++){
                    if(boardslocked[spot] == 1)
                        boardslocked[i] = 0;
                }
            }
            else
                boardslocked[spot] = 0;
            
            tl.nextTurn();tm.nextTurn();tr.nextTurn();
            ml.nextTurn();mm.nextTurn();mr.nextTurn();
            bl.nextTurn();bm.nextTurn();
        }
                                   //when this was == completely broken
        if(tl.getObjects()== 9 || tl.checkWinner() != 0){
            boardslocked[0] = 2;
        }
        else if(tm.getObjects()== 9 || tm.checkWinner() != 0){
            boardslocked[1] = 2;
        }
        else if(tr.getObjects()== 9 || tr.checkWinner() != 0){
            boardslocked[2] = 2;
        }
        else if(ml.getObjects()== 9 || ml.checkWinner() != 0){
            boardslocked[3] = 2;
        }
        else if(mm.getObjects()== 9 || mm.checkWinner() != 0){
            boardslocked[4] = 2;
        }
        else if(mr.getObjects()== 9 || mr.checkWinner() != 0){
            boardslocked[5] = 2;
        }
        else if(bl.getObjects()== 9 || bl.checkWinner() != 0){
            boardslocked[6] = 2;
        }
        else if(bm.getObjects()== 9 || bm.checkWinner() != 0){
            boardslocked[7] = 2;
        }
        else if(br.getObjects()== 9 || br.checkWinner() != 0){
            boardslocked[8] = 2;
        }
        System.out.println(boardslocked[0]+""+boardslocked[1]+""+boardslocked[2]
                +""+boardslocked[3]+""+boardslocked[5]+""+boardslocked[6]+""+boardslocked[6]
                +""+boardslocked[7]+""+boardslocked[8]);
    }

    /** toString outputs a visual representation of the board
     * @return a visual representation of the board
     */
    @Override
    public String toString(){
        String output =
                 ""+tl.getBoard(0)+"   "+tl.getBoard(1)+"   "+tl.getBoard(2)+ "|"+tm.getBoard(0)+"   "+tm.getBoard(1)+"   "+tm.getBoard(2)+ "|"+tr.getBoard(0)+"   "+tr.getBoard(1)+"   "+tr.getBoard(2)+"\n"
                +""+tl.getBoard(3)+"   "+tl.getBoard(4)+"   "+tl.getBoard(5)+ "|"+tm.getBoard(3)+"   "+tm.getBoard(4)+"   "+tm.getBoard(5)+ "|"+tr.getBoard(3)+"   "+tr.getBoard(4)+"   "+tr.getBoard(5)+"\n"
                +""+tl.getBoard(6)+"   "+tl.getBoard(7)+"   "+tl.getBoard(8)+ "|"+tm.getBoard(6)+"   "+tm.getBoard(7)+"   "+tm.getBoard(8)+ "|"+tr.getBoard(6)+"   "+tr.getBoard(7)+"   "+tr.getBoard(8)+"\n"
                +"-----------------------------\n"   
                +""+ml.getBoard(0)+"   "+ml.getBoard(1)+"   "+ml.getBoard(2)+ "|"+mm.getBoard(0)+"   "+mm.getBoard(1)+"   "+mm.getBoard(2)+ "|"+mr.getBoard(0)+"   "+mr.getBoard(1)+"   "+mr.getBoard(2)+"\n"
                +""+ml.getBoard(3)+"   "+ml.getBoard(4)+"   "+ml.getBoard(5)+ "|"+mm.getBoard(3)+"   "+mm.getBoard(4)+"   "+mm.getBoard(5)+ "|"+mr.getBoard(3)+"   "+mr.getBoard(4)+"   "+mr.getBoard(5)+"\n"
                +""+ml.getBoard(6)+"   "+ml.getBoard(7)+"   "+ml.getBoard(8)+ "|"+mm.getBoard(6)+"   "+mm.getBoard(7)+"   "+mm.getBoard(8)+ "|"+mr.getBoard(6)+"   "+mr.getBoard(7)+"   "+mr.getBoard(8)+"\n"
                +"-----------------------------\n"
                +""+bl.getBoard(0)+"   "+bl.getBoard(1)+"   "+bl.getBoard(2)+ "|"+bm.getBoard(0)+"   "+bm.getBoard(1)+"   "+bm.getBoard(2)+ "|"+br.getBoard(0)+"   "+br.getBoard(1)+"   "+br.getBoard(2)+"\n"
                +""+bl.getBoard(3)+"   "+bl.getBoard(4)+"   "+bl.getBoard(5)+ "|"+bm.getBoard(3)+"   "+bm.getBoard(4)+"   "+bm.getBoard(5)+ "|"+br.getBoard(3)+"   "+br.getBoard(4)+"   "+br.getBoard(5)+"\n"
                +""+bl.getBoard(6)+"   "+bl.getBoard(7)+"   "+bl.getBoard(8)+ "|"+bm.getBoard(6)+"   "+bm.getBoard(7)+"   "+bm.getBoard(8)+ "|"+br.getBoard(6)+"   "+br.getBoard(7)+"   "+br.getBoard(8)+"\n"
                ;            
        return output;
    }
    /**
     * @return 
     */
    public int getTurn(){
        return tl.getTurn();
    }
}