package model;

/**
 * @author Adi
 */
public class Cell {
    public enum Value {
        EMPTY, NOUGHT, CROSS;
    }
    private Value content;
    private int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }
    
    public void clear() {
        content = Value.EMPTY;
    }
    
    public Value getContent() {
        return content;
    }

    public void setContent(Value content) {
        this.content = content;
    }

    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean isEmpty() {
        return this.content == Value.EMPTY;
    }
}