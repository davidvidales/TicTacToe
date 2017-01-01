package tictactoe;
import java.util.*;

public class AIplayer extends Player{
    final int depth = 5;
    
    public AIplayer(String newName, int newPlayerNumber, char newMark) {
        super(newName, newPlayerNumber, newMark);
    }
    
    public Move selectMove(ArrayList<Player> playersIn, Board boardIn) {
        ArrayList<Move> possibleMoves = boardIn.getPossibleMoves();
        Move bestMove = possibleMoves.get(0);
        int bestMinimax = -10001;
   
        for(int i = 0; i < possibleMoves.size(); i++){
            Board tempBoard = boardIn.getCopy();
            tempBoard.setCell(possibleMoves.get(i).getY(), possibleMoves.get(i).getX(), 'O');
            int minimax = minimax(tempBoard, depth, 0, playersIn);
            
            if(minimax > bestMinimax){
                bestMove = possibleMoves.get(i);
                bestMinimax = minimax;
            }
        }
        return bestMove;
    }

    public int minimax(Board boardIn, int depthIn, int playerNumberIn, ArrayList<Player> playersIn) {
        if (depthIn < 1 || boardIn.getState(playersIn) >= -1) {
            int score = boardIn.evaluateBoard(playersIn, boardIn, playerNumberIn);
            return score;
        }
        
        if (playerNumberIn == 1) {
            int maxValue = -10000;
            ArrayList<Board> childs = getChildren(boardIn, 1);
            for (int i = 0; i < childs.size(); i++){
                Board child = childs.get(i);
                int value = minimax(child, depthIn-1, 0, playersIn);
                maxValue = Math.max(maxValue, value);
            }
            return maxValue;
        } else {
            int minValue = 10000;
            ArrayList<Board> childs = getChildren(boardIn, 0);
            for (int i = 0; i<childs.size(); i++){
                Board child = childs.get(i);
                int value = minimax(child, depthIn-1, 1, playersIn);
                minValue = Math.min(minValue, value);
            }
            return minValue;
        }
    }
    
    public ArrayList<Board> getChildren(Board boardIn, int playerNumberIn){
        ArrayList<Board> childrenOut = new ArrayList<Board>();
        ArrayList<Move> possibleMoves = boardIn.getPossibleMoves();
        
        for(int i = 0; i < possibleMoves.size(); i++){
            Board tempBoard = boardIn.getCopy();
            
            int x = possibleMoves.get(i).getX();
            int y = possibleMoves.get(i).getY();
            char mark = (playerNumberIn == 0) ? 'X' : 'O';
            tempBoard.setCell(y, x, mark);
            childrenOut.add(tempBoard);
        }
        return childrenOut;
    }
}