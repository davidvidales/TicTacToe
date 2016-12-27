package tictactoe;
import java.util.*;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
   
    public static void main(String[] args) {
        final int numberOfPlayers = 2;
        final int pointsPerWin = 1;
        final int minBoardSize = 3;
        final int maxBoardSize = 999;
        final int continueGame = -2;
        final int drawGame = -1;        
        final char[] marks = {'X', 'O', 'A', 'B', 'C'};
        
        int activePlayer = 0;
        Move move = null;
        ArrayList<Player> players = new ArrayList<Player>();
        
        System.out.print("Size of board (" + minBoardSize + "-" + maxBoardSize + "): ");
        Board board = new Board(getAnInteger(minBoardSize, maxBoardSize));
        
        if (board.getBoardSize() > minBoardSize) {
            System.out.print("Win condition ("+ minBoardSize + "-" + board.getBoardSize() + "): ") ;
            board.setWinCondition(getAnInteger(minBoardSize, board.getBoardSize()));     
        }
        
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Name of player " + (i + 1) + " (AI for computer): ");
            String newName = scan.nextLine();
            
            if (newName.equalsIgnoreCase("AI")) {
                players.add(new AIplayer(newName, marks[i]));
            } else {
                players.add(new Player(newName, marks[i]));
            }
            players.get(i).setWinCondition(board.getWinCondition());
        }

        do {
            System.out.print("\n\n\n");
            board.drawBoard(players);    
            System.out.println("\n- " + players.get(activePlayer).getName() + " -");

            do {
                move = Player.makeMove(board.getBoardSize());

                if (board.isCellTaken(move.getY(), move.getX())) {//fixa
                    System.out.println("That spot is taken, try again.");
                }   
            } while (board.isCellTaken(move.getY(), move.getX()));
            board.addChar(move.getY(), move.getX(), players.get(activePlayer).getMark());    
            //}
            
            int boardState = board.getState(players);
            
            if (boardState != continueGame) {
                board.drawBoard(players);

                if (boardState != drawGame) {
                    System.out.println("\n" + players.get(activePlayer).getName() + " won!");
                    players.get(activePlayer).addPoints(pointsPerWin);
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