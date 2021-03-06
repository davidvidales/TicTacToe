package tictactoe;
import java.util.*;

public class Board {   
    private int boardSize;
    private int winCondition;
    private char[][] content;
    private final int continueGame = -2;
    private final int drawGame = -1;
        
    public Board(int size) {
        content = new char[size][size];
        boardSize = size;
        winCondition = size;
        
        for (char[] y: content) {
            Arrays.fill(y, ' ');
        }
    }
    
    public int getBoardSize() {
        return boardSize;
    }
    
    public int getWinCondition() {
        return winCondition;
    }
    
    public void setWinCondition(int newWinCondition) {
        winCondition = newWinCondition;
    }
    
    public char getCell(int y, int x) {
        return content[y][x];
    }
    
    public void setCell(int y, int x, char newMark) {
        content[y][x] = newMark;
    }
    
    public int getState(ArrayList<Player> players) {
        int winner = getWidthOrHeightWinner(players);
        if (winner != continueGame) {
            return winner;
        }
        
        winner = getDiagonalsWinner(players);
        if (winner != continueGame) {
            return winner;
        }
        
        if (isDraw()) {
            return drawGame;
        }
        return continueGame;
    }
    
    public int getWidthOrHeightWinner(ArrayList<Player> players) {
        String width = "";
        String height = "";
        
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                width += content[y][x];
                height += content[x][y];
            }

            for (int player = 0; player < players.size(); player++) {
                if (width.contains(players.get(player).getWinCondition()) || height.contains(players.get(player).getWinCondition())) {
                    return player;
                }
            }
            width = "";
            height = "";
        }
        return continueGame;
    }

    public int getDiagonalsWinner(ArrayList<Player> players) {    
        String firstDia = "";
        String secondDia = "";
        
        for (int i = boardSize - winCondition, j = 0; j <= boardSize - winCondition;) {   
            for (int y = i, x = j; y < boardSize && x < boardSize; y++, x++) {
                firstDia += content[y][x];
                secondDia += content[y][boardSize - x - 1];
            }
            
            for (int player = 0; player < players.size(); player++) {
                if (firstDia.contains(players.get(player).getWinCondition()) || secondDia.contains(players.get(player).getWinCondition())) {
                    return player;
                }
            }
            firstDia = "";
            secondDia = "";
            
            if (i == 0) {
                j++;
            } else i--;
        }
        return continueGame;
    }

    public boolean isDraw() {
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                if (content[y][x] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void reset() {
        for (char[] row : content) {
            Arrays.fill(row, ' ');
        }
    }
    
    public void drawBoard(int turn, ArrayList<Player> players) {
        drawGameStats(turn, players);
        System.out.print("\n\n    ");
        drawXlegends();
        System.out.print("\n\n");        

        for (int Ycoordinate = 1; Ycoordinate <= boardSize; Ycoordinate++) {
            drawYlegend(Ycoordinate);
            drawCell(Ycoordinate);
        }
    }
    
    private void drawGameStats(int turn, ArrayList<Player> players) {
        System.out.print("\n" + winCondition + " in a row - turn: " + turn + "\n\n- ");
        
        for (int i = 0; i < players.size(); i++) {
            System.out.print("(" + players.get(i).getMark() + ")" + players.get(i).getName() + " " + players.get(i).getPoints() + " - ");
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
    
    private void drawYlegend(int y) {
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
                System.out.print("\n    ");
            }
        }

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
    
    public Board getCopy() {
        Board boardOut = new Board(boardSize);
        boardOut.setWinCondition(winCondition);
        
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                boardOut.setCell(y, x, content[y][x]);
            }
        }
        return boardOut;
    }
    
    public int evaluateBoard(ArrayList<Player> playersIn, Board boardIn, int playerIn) {   
        if (boardIn.getState(playersIn) == 1) {
            return 100;
        } else if (boardIn.getState(playersIn) > -1) {
            return -100;
        } else {
            return 0;
        }
    }
    
    public ArrayList<Move> getPossibleMoves() {
        ArrayList<Move> movesOut = new ArrayList<Move>();
        
        for (int y = 0 ; y < getBoardSize(); y++) {
            for (int x = 0 ; x < getBoardSize(); x++) {
                if(!isCellTaken(y, x)) {
                    movesOut.add(new Move(y, x));
                }
            }
        }
        return movesOut;
    }
}