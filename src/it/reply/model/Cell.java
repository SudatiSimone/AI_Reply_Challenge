package it.reply.model;

public class Cell {
    public int row;
    public int column;
    public boolean isWormholeEntry;

    public Cell(int column, int row, boolean isWormholeEntry) {
        this.row = row;
        this.column = column;
        this.isWormholeEntry = isWormholeEntry;
    }
}
