/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe;

import java.util.Scanner;

/**
 *
 * @author Devon Schweizer
 */
public class UTTT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UltimateTicTacToe game = new UltimateTicTacToe();
        
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String board;
        int spot;
        while(true){
            System.out.println(game.toString());
            System.out.println("Turn "+game.getTurn());
            System.out.println("Make your move:");
            board = scan1.nextLine();
            spot = scan2.nextInt();
            
            game.makeMove(board, spot);
            
            if(game.checkDraw()){
                System.out.println("The game is a draw");
                break;
            }
            if(game.checkWinner()==1){
                System.out.println("Player 1 has won the game");
                break;
            }
            else if(game.checkWinner()==2){
                System.out.println("Player 2 has won the game");
                break;
            }
        }    
    }   
}
