package model;

/**
 * @author Adi
 */
public class Board {
    public static final int DEFAULT_SIZE = 3;
    
    Cell[][] cells;

    public Board() {
        this(DEFAULT_SIZE);
    }

    public Board(int size) {
        cells = new Cell[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell getCell(String id) {
        String[] temp = id.split("-");
        int row = Integer.valueOf(temp[0]);
        int col = Integer.valueOf(temp[1]);
        return cells[row][col];
    }
    
    public void init() {
        for (Cell[] cell : cells) {
            for (Cell c : cell) {
                c.clear();
            }
        }
    }
    
    public boolean isFull() {
        for (Cell[] cell : cells) {
            for (Cell c : cell) {
                if (c.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean hasWon(Cell.Value seed, int seedRow, int seedCol) {
        int r = 0;
        int c = 0;
        int d = 0;
        int rd = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[seedRow][i].getContent() == seed)
                r++;
            if (cells[i][seedCol].getContent() == seed)
                c++;
            if (cells[i][i].getContent() == seed)
                d++;
            if (cells[i][(cells.length-1)-i].getContent() == seed)
                rd++;
        }
        return r == cells.length || c == cells.length || d == cells.length || rd == cells.length;
    }

    public Cell[][] getCells() {
        return cells;
    }
}