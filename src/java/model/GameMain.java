package model;

import java.util.List;

/**
 * @author Adi
 */
public class GameMain {
    
    public static final int DEFAULT_SIZE = 3;
    private Board board;
    private GameState currentState;
    private boolean nextMoveCross;

    public GameMain() {
        initGame(DEFAULT_SIZE);
    }
    
    public void initGame(int size) {
        currentState = GameState.PLAYING;
        nextMoveCross = true;
        if (board == null) {
            board = new Board(size);
        } else if(size != board.getCells().length) {
            board = new Board(size);
        } else {
            board.init();
        }
    }
    
    public void markTile(String id) {
        setCellValue(board.getCell(id));
    }
    
    private void setCellValue(Cell cell) {
        if (isGameOver() || !cell.isEmpty()) {
            return;
        }
        
        cell.setContent(nextMoveCross ? Cell.Value.CROSS : Cell.Value.NOUGHT);
        nextMoveCross = !nextMoveCross;
        
        currentState = evaluateWinValue(cell);
    }
    
    public boolean isGameOver() {
        return !currentState.isPlaying();
    }
    
    private GameState evaluateWinValue(Cell cell) {
        if (board.hasWon(cell.getContent(), cell.getRow(), cell.getCol()))
            return cell.getContent() == Cell.Value.CROSS ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        if (board.isFull()) {
            return GameState.DRAW;
        }
        return GameState.PLAYING;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isNextMoveCross() {
        return nextMoveCross;
    }
}