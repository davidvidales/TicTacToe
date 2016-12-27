package tictactoe;

public class AIplayer extends Player{

    public AIplayer(String startName, char newMark) {
        super(startName, newMark);
    }

    public static void move() {
                       
                //int i = 0;
                //int tempY;
                //int tempX;
                
                
                //do {
                /*repeat = true;
                    boolean aiWon = false;
                    boolean opponentWouldWin = false;
                    
                    for (tempX = 0, tempY = 0; tempY < boardSize && !aiWon; tempX++) {
                        if (!board.isCellTaken(tempY, tempX))
                            if (board.winCheck(tempY, tempX, activePlayer, winCondition)) {
                            y = tempY;
                            x = tempX;
                            board.addChar(y, x, activePlayer);
                            aiWon = true;
                            
                            } else if (board.winCheck(tempY, tempX, switchPlayer(activePlayer), winCondition) && !aiWon) {
                                y = tempY;
                                x = tempX;
                                opponentWouldWin = true;
                                }
                            if (tempX == boardSize - 1) {
                                tempX = -1;
                                tempY++;
                        }
                    }*/
                    
                    
                    /*if (!aiWon) {
                        for (int i = 0; i < sequenceX.size() && !opponentWouldWin; i++) {
                            y = emptyY.get(i);
                            x = emptyX.get(i);
                            board.addChar(y, x, activePlayer);
                            
                            for (tempX = 0, tempY = 0; tempY < boardSize && !opponentWouldWin; tempX++) {
                                if (!board.isCellTaken(tempY, tempX)) {

                                    if (board.winCheck(tempY, tempX, switchPlayer(activePlayer), winCondition)) {
                                        y = tempY;
                                        x = tempX;
                                        board.addChar(y, x, activePlayer);
                                        opponentWouldWin = true;
                                    }
                                }
                                if (tempX == boardSize - 1) {
                                    tempX = -1;
                                    tempY++;
                                }
                            }
                            board.removeChar(emptyY.get(i), emptyX.get(i));
                        }
                    }
                    if (!aiWon && !opponentWouldWin) {
                        y = rng.nextInt(boardSize - 1 + 1);
                        x = rng.nextInt(boardSize - 1 + 1);
                        board.addChar(y, x, activePlayer);
                        System.out.println("RANDOM"); 
                    }
                    
                    aiWon = false;
                    opponentWouldWin = false;*/
                    
                    
                    
                    /*do {

                        i++;
                        tempX++;
                        //System.out.println("Innanför loopen tempY: " + tempY + " tempX: " + tempX + " Y: " + y + " X: " + x + " I: " + i);
                        
                        if (tempX == boardSize) {
                            tempX = 0;
                            tempY++;
                        }
                        if (!board.isCellTaken(tempY, tempX)) {
                            emptyY.add(tempY);
                            emptyX.add(tempX);
                        
                            if (board.winCheck(tempY, tempX, activePlayer, winCondition)) {
                                y = tempY;
                                x = tempX;
                                aiWon = true;
                            } else if (board.winCheck(tempY, tempX, switchPlayer(activePlayer), winCondition) && !aiWon) {
                                y = tempY;
                                x = tempX;
                                opponentWillWin = true;
                            }
                        }
                    } while (!aiWon && i != boardSize * boardSize);*/
                    
                    /*if (!aiWon && !opponentWillWin) {
                        y = emptyY.get(0);
                        x = emptyX.get(0);
                        board.addChar(y, x, activePlayer); //Lägger till tecknet i cellen 
                        
                        
                    }*/
                    
                    /*aiWon = false;
                    opponentWon = false;
                    
                    for (int l = 0; l < emptyX.size(); l++) {
                        System.out.print("Y : " + emptyY.get(l));
                        System.out.println(" X : " + emptyX.get(l));
                        
                    }

                    emptyY.clear();
                    emptyX.clear();*/
                    
                    
                    //board.addChar(y, x, activePlayer); //Lägger till tecknet i cellen
                //System.out.println("Utanför loopen  tempY: " + tempY + " tempX: " + tempX + " Y: " + y + " X: " + x + " I: " + i);
                //} while (!board.winCheck(y, x, activePlayer) && i != boardSize * boardSize);  
                
                /*while (board.isCellTaken(y, x)) {
                    y = rng.nextInt(boardSize - 1 + 1);
                    x = rng.nextInt(boardSize - 1 + 1);
                    System.out.println("RANDOM");
            }*/
//if (board.winCheck(y, x, activePlayer)) {
                    
                    
                    
                    
                    /*for (; y < boardSize - 1 && repeat == true;) {
                        y++;
                        
                        for (; x < boardSize - 1 && repeat == true;) {
                            x++;
                            
                            if (board.takenCell(y, x) == false) {
                                
                                repeat = false;
                                break;
                            }
                        }
                                               if (board.takenCell(y, x) == false) {
                            
                            repeat = false;
                            break;
                        }
 
                    }*/
                    //y = rng.nextInt(boardSize - 1 + 1); Helt random
                    //x = rng.nextInt(boardSize - 1 + 1);

                
                //if (board.winCheck(y, x, activePlayer))
    }
}

