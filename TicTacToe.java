package tictactoe;
import java.util.*;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    static Random rng = new Random();
   
    public static void main(String[] args) {
        
        int boardSize;
        int boardState;
        int winCondition;
        final int continueGame = 0;
        final int p1win = 1;
        final int p2win = 2;

        char p1char = 'X';
        char p2char = 'O';
        int y = 0;
        int x = 0;
        char activePlayer = p1char;
        Move move = null;
        String input;
        //ArrayList<Integer> sequenceY = new ArrayList<Integer>();
        //ArrayList<Integer> sequenceX = new ArrayList<Integer>();
        
        Player p1 = null;
        Player p2 = null;
        
        System.out.print("Name of player 1 (AI1 for computer): ");
        input = scan.nextLine();
        
        if (input.equalsIgnoreCase("AI1")) {
            p1 = new AIplayer(input, p1char);
        } else {
            p1 = new Player(input, p1char);
        }
        System.out.print("Name of player 2 (AI2 for computer): ");
        input = scan.nextLine();
        
        if (input.equalsIgnoreCase("AI2")) {
            p2 = new AIplayer(input, p2char);
        } else {
            p2 = new Player(input, p2char);
        }    
        
        System.out.print("Size of board (3-999): ");

        boardSize = getAnInteger(3, 999);
        Board board = new Board(boardSize);
        winCondition = boardSize;
        
        if (boardSize > 4) {
            System.out.print("Win condition (4-" + boardSize + "): ") ;
            winCondition = getAnInteger(4, boardSize);     
        }
        
        p1.setWinCondition(winCondition);
        p2.setWinCondition(winCondition);

        do {
            System.out.print("\n\n\n");
            boardState = board.getState(p1.getWinCondition(), p2.getWinCondition());
            
            if (boardState != continueGame) {
                board.drawBoard(winCondition, p1.getName(), p1.getPoints(), p2.getName(), p2.getPoints());

                if (boardState == p1win) {
                    System.out.println("\n" + p1.getName() + " won!");
                    p1.addPoints(1);
                } else if (boardState == p2win) {
                    System.out.println("\n" + p2.getName() + " won!");
                    p2.addPoints(1);
                } else {

                System.out.println( "\n" + "It's a draw!");
                }
                
                board.reset();
                boardState = continueGame;
            }
            board.drawBoard(winCondition, p1.getName(), p1.getPoints(), p2.getName(), p2.getPoints());
    
            if (activePlayer == p1char) {
                System.out.println("\n- " + p1.getName() + " -");
            } else {
                System.out.println("\n- " + p2.getName() + " -");    
            }
            //if ((activePlayer == p1char && p1.getAI()) || activePlayer == p2char && p2.getAI()) {
                
  
                
                
                
                
                
                
            //} else {
            
            do {
                move = Player.makeMove(boardSize);

                if (board.isCellTaken(move.getY(), move.getX())) {
                    System.out.println("That spot is taken, try again");
                }   
            } while (board.isCellTaken(move.getY(), move.getX()));
            board.addChar(move.getY(), move.getX(), activePlayer);    
            //}

            activePlayer = switchPlayer(activePlayer, p1char, p2char);
        } while (true);
        
    }
    
    public static char switchPlayer(char activePlayer, char p1char, char p2char) {
        if (activePlayer == p1char) {
            return p2char;
        }
        return p1char;
    }
    
    public static int getAnInteger(int minValue, int maxValue) {
        int input = 0;
        final String notNumberError = "That's not a valid number, try again: " + "\n";
        
        do {
            try {
                input = scan.nextInt();
            } catch (InputMismatchException error) {      
                scan.next();
            }
            
            if (input >= minValue && input <= maxValue) {
                return input;
            }
            System.out.print(notNumberError);
        } while (true);
    }
}