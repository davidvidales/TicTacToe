package tictactoe;

public class Move {
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
