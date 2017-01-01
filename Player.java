package tictactoe;
import java.util.*;
import static tictactoe.TicTacToe.getAnInteger;

public class Player {       
    private String name;
    private String winCondition = "";
    private char mark;
    private int points;
    private int playerNumber;
    
    public Player(String newName, int newPlayerNumber, char newMark) {
        name = newName;
        playerNumber = newPlayerNumber;
        mark = newMark;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPlayerNumber() {
        return playerNumber;
    }
    
    public char getMark() {
        return mark;
    }
    
    public String getWinCondition() {
        return winCondition;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public void setWinCondition(int newWinCondition) {
        for (int i = 0; i < newWinCondition; i++) {
            winCondition += mark;
        }
    }
    
    public void addPoints(int newPoints) {
        points += newPoints;
    }
    
    public Move selectMove(ArrayList<Player> players, Board board) {
        System.out.print("X: ");
        int x = getAnInteger(1, board.getBoardSize()) - 1;

        System.out.print("Y: ");
        int y = getAnInteger(1, board.getBoardSize()) - 1;
        return new Move(y, x);
    }
}