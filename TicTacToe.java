package tictactoe;
import java.util.*;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    static Random rng = new Random();
   
    public static void main(String[] args) {
        
        int boardState;
        int numberOfPlayers = 2;
        final int continueGame = 0;
        final int p1win = 1;
        final int p2win = 2;
        final int pointsPerWin = 1;
        //final char p1char = 'X';
        //final char p2char = 'O';
        char[] marks = {'X', 'O', 'A', 'B', 'C'};
        int activePlayer = 0;
        //Player p1 = null;
        //Player p2 = null;
        String input;
        Move move = null;
        ArrayList<Player> players = new ArrayList<Player>();
        
        //ArrayList<Integer> sequenceY = new ArrayList<Integer>();
        //ArrayList<Integer> sequenceX = new ArrayList<Integer>();
        
        //setupPlayers();
        //setupBoard();
        System.out.print("Size of board (3-999): ");
        Board board = new Board(getAnInteger(3, 999));
                
        if (board.getBoardSize() > 4) {
            System.out.print("Win condition (4-" + board.getBoardSize() + "): ") ;
            board.setWinCondition(getAnInteger(4, board.getBoardSize()));     
        }
        
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Name of player " + (i + 1) + " (AI for computer): ");
            input = scan.nextLine();
            
            if (input.equalsIgnoreCase("AI")) {
                players.add(new AIplayer(input, marks[i]));
            } else {
                players.add(new Player(input, marks[i]));
            }
            players.get(i).setWinCondition(board.getWinCondition());
        }

        do {
            System.out.print("\n\n\n");

            board.drawBoard(players);    
            System.out.println("\n- " + players.get(activePlayer).getName() + " -");

            //if ((activePlayer == p1char && p1.getAI()) || activePlayer == p2char && p2.getAI()) {
                

                
                
            //} else {
            
            do {
                move = Player.makeMove(board.getBoardSize());

                if (board.isCellTaken(move.getY(), move.getX())) {
                    System.out.println("That spot is taken, try again");
                }   
            } while (board.isCellTaken(move.getY(), move.getX()));
            board.addChar(move.getY(), move.getX(), players.get(activePlayer).getMark());    
            //}
            
            boardState = board.getState(players.get(0).getWinCondition(), players.get(1).getWinCondition());
            
            if (boardState != continueGame) {
                board.drawBoard(players);

                if (boardState == p1win) {
                    System.out.println("\n" + players.get(0).getName() + " won!");
                    players.get(0).addPoints(pointsPerWin);
                } else if (boardState == p2win) {
                    System.out.println("\n" + players.get(1).getName() + " won!");
                    players.get(1).addPoints(pointsPerWin);
                } else {
                    System.out.println( "\n" + "It's a draw!");
                }
                board.reset();
            }
            activePlayer = switchPlayer(activePlayer, numberOfPlayers);
        } while (true);   
    }
    
    public static int switchPlayer(int activePlayer, int numberOfPlayers) {
        activePlayer++;
        if (activePlayer == numberOfPlayers) {
            activePlayer = 0;
        }
        return activePlayer;
    }
    
    public static int getAnInteger(int minValue, int maxValue) {
        int input = 0;
        final String notNumberError = "That's not a valid number, try again: ";
        
        do {
            try {
                input = scan.nextInt();
                scan.nextLine();
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