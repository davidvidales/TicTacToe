package tictactoe;
import java.util.*;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);
    static int activePlayer = 0;
    static int turn = 1;
    static final int numberOfPlayers = 2;
    static final int pointsPerWin = 1;
    static final int minBoardSize = 3;
    static final int maxBoardSize = 999;
    static final char[] marks = {'X', 'O', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'
    , 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z'};
    static Board board = setupBoard();
    static ArrayList<Player> players = setupPlayers();
    
    public static void main(String[] args) {
        while (true) {
            drawTurn();
            playerMoves();
            winCheck();
            switchPlayer();
        }
    }
    //TEST
    public static Board setupBoard() {
        System.out.print("Size of board (" + minBoardSize + "-" + maxBoardSize + "): ");
        Board board = new Board(getAnInteger(minBoardSize, maxBoardSize));
        
        if (board.getBoardSize() > minBoardSize) {
            System.out.print("Win condition ("+ minBoardSize + "-" + board.getBoardSize() + "): ") ;
            board.setWinCondition(getAnInteger(minBoardSize, board.getBoardSize()));     
        }
        return board;
    }
    
    public static ArrayList<Player> setupPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
         
        for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
            System.out.print("Name of player " + marks[playerNumber] + " (AI for computer): ");
            String newName = scan.nextLine();

            if (newName.equalsIgnoreCase("AI")) {
                players.add(new AIplayer(newName, playerNumber, marks[playerNumber]));
            } else {
                players.add(new Player(newName, playerNumber, marks[playerNumber]));
            }
            players.get(playerNumber).setWinCondition(board.getWinCondition());
        }
        return players;
    }
    
    public static void drawTurn() {
        System.out.print("\n\n\n");
        board.drawBoard(turn, players);    
        System.out.println("\n- (" + players.get(activePlayer).getMark() + ")" + players.get(activePlayer).getName() + " -");     
    }
    
    public static void playerMoves() {
        Move move = null;

        do {
            move = players.get(activePlayer).selectMove(players, board);
            if (board.isCellTaken(move.getY(), move.getX())) {
                System.out.println("That spot is taken, try again.");
            }   
        } while (board.isCellTaken(move.getY(), move.getX()));
        board.setCell(move.getY(), move.getX(), players.get(activePlayer).getMark());
        turn++;
    }
    
    public static void winCheck() {
        final int continueGame = -2;
        final int drawGame = -1;
        int boardState = board.getState(players);

        if (boardState != continueGame) {
            board.drawBoard(turn, players);

            if (boardState != drawGame) {
                System.out.println("\n" + players.get(activePlayer).getName() + " won!");
                players.get(activePlayer).addPoints(pointsPerWin);
            } else {
                System.out.println("\n" + "It's a draw!");
            }
            board.reset();
            turn = 1;
        }
    }
    
    public static void switchPlayer() {
        activePlayer++;

        if (activePlayer == numberOfPlayers) {
            activePlayer = 0;
        }
    }
    
    public static int getAnInteger(int minValue, int maxValue) {
        int input = 0;
        
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
            System.out.print("That's not a valid number, try again: ");
        } while (true);
    }
}