package tictactoe;
import java.util.*;

public class Board {
    
    private int boardSize;
    private int turn = 1;
    private char[][] content;
    private final int continueGame = 0;
    private final int p1win = 1;
    private final int p2win = 2;
    private final int draw = 3;
    
    
    public Board(int size) {
        content = new char [size][size];
        boardSize = content.length;
        for (char[] y: content) {
            Arrays.fill(y, ' ');
        }
    }
    
    public int getState(String p1winCondition, String p2winCondition) {
        String width = "";
        String height = "";
        String leftUp = "";
        String rightUp = "";
        String leftDown = "";
        String rightDown = "";
        
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                width += content[y][x];
                height += content[x][y];
            }
            for (int i = y, x = 0; i >= 0; i--, x++) {
                leftUp += content[i][x];
                rightUp += content[i][boardSize - 1 - x];
                leftDown += content[boardSize - 1 - i][x];
                rightDown += content[boardSize - 1 - i][boardSize - 1 - x];
            }
            
            if (
                width.contains(p1winCondition) ||
                height.contains(p1winCondition) ||
                leftUp.contains(p1winCondition) ||
                rightUp.contains(p1winCondition) ||
                leftDown.contains(p1winCondition) ||
                rightDown.contains(p1winCondition)) {
                return p1win;
            } else if (
                width.contains(p2winCondition) ||
                height.contains(p2winCondition) ||
                leftUp.contains(p2winCondition) ||
                rightUp.contains(p2winCondition) ||
                leftDown.contains(p2winCondition) ||
                rightDown.contains(p2winCondition)) {
                return p2win;
            }
            width = "";
            height = "";
            leftUp = "";
            rightUp = "";
            leftDown = "";
            rightDown = "";
        }
        
        if (turn > boardSize * boardSize) {
            return draw;
        }
        return continueGame;
    }
    
    public void reset() {
        
        for (char[] row : content) {
            Arrays.fill(row, ' ');
        }
        turn = 1;
    }
    
    public void drawBoard(int winCondition, String player1name, int player1points, String player2name, int player2points) {
        System.out.println("\n" + winCondition + " in a row - turn: " + turn);
        System.out.print("\n" + player1name + " " + player1points + " - " + player2name + " " + "\n\n    ");
        
        drawXlegends();
        System.out.print("\n\n");        

        for (int Ycoordinate = 1; Ycoordinate <= boardSize; Ycoordinate++) {
            drawYlegends(Ycoordinate);
            drawCell(Ycoordinate);
        }
    }
    
    private void drawXlegends() {
        for (int x = 1; x <= boardSize; x++) {
            if (x < 10) {
                System.out.print(" " + x + "  ");
            } else if (x < 100) {
                System.out.print(" " + x + " ");
            } else {
                System.out.print(x + " ");
            }
        }
    }
    
    private void drawYlegends(int y) {
        if (y < 10) {
            System.out.print(y + "   ");
        } else if (y < 100) {
            System.out.print(y + "  ");
        } else {
            System.out.print(y + " ");
        }
    }
    
    private void drawCell(int y) {
        for (int x = 0; x < boardSize; x++) {
            System.out.print(" " + content[y-1][x] + " ");

            if (x < boardSize - 1) {
                System.out.print("|");
            } else {
                System.out.println();
            }
        }
        System.out.print ("    ");

        if (y < boardSize) {
            for (int x = 0; x < boardSize; x++) {
                if (x < boardSize - 1) {
                    System.out.print("---+");
                } else {
                    System.out.println("---");
                }
            }
        }    
    }
    
    public boolean isCellTaken(int y, int x) {
        return (content[y][x] != ' ');
    }
    
    public void addChar(int y, int x, char activePlayer) {
        content[y][x] = activePlayer;
        turn ++;
    }
    
    public void removeChar(int y, int x) {
        content[y][x] = ' ';
    }
    
    public int minimax(int iterations) {
        
        
        return 0;
    }
}