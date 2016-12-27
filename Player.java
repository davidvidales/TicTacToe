package tictactoe;
import static tictactoe.TicTacToe.getAnInteger;

public class Player {       
    private String name;
    private char mark;
    private String winCondition = "";
    private int points;
    
    public Player(String startName, char newMark) {
        name = startName;
        mark = newMark;
    }
    
    public String getName() {
        return name;
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
    
    public static Move makeMove(int boardSize) {
        System.out.print("X: ");
        int x = getAnInteger(1, boardSize) - 1;

        System.out.print("Y: ");
        int y = getAnInteger(1, boardSize) - 1;
        return new Move(y, x);
    }
}

class Move {
    private int y;
    private int x;

    Move(int newY, int newX) {
        y = newY;
        x = newX;
    }
    
    public int getY() {
        return y;
    }
    
    public int getX() {
        return x;
    }
}