package it.reply.utils;

import it.reply.model.*;

import java.util.concurrent.ScheduledExecutorService;

public class Utils {

    public static GridElem startFreeGridElem(Header header, Grid grid) {
        GridElem gridElem = new GridElem();
        int max = grid.e[0][0].relevance;

        for (int i = 0; i < header.rowNr - 1; ++i) {
            for (int j = 0; j < header.colNr - 1; ++j) {
                if (!grid.e[i][j].isPresent && max < grid.e[i][j].relevance) {
                    max = grid.e[i][j].relevance;
                    gridElem.indexRow = i;
                    gridElem.indexColumn = j;
                }
            }
        }
        gridElem.isPresent = true;
        return gridElem;
    }

    public static boolean canMoves(Snake snake) {
        return snake.length > 0;
    }

    public static boolean isCellFilled(GridElem cell) {
        return cell.isPresent;
    }

    public static GridElem moveRight(Grid grid, Integer i, Integer j) {
        return grid.e[i][j + 1];
    }

    public static GridElem nextBestMove(Grid grid, Integer rowIndex, Integer columnIndex, Integer rows, Integer columns) {
        Integer max = -10001;
        GridElem nextCell = new GridElem();

        if (rowIndex - 1 < 0) {
            if (!grid.e[rows][columnIndex].isPresent && grid.e[rows][columnIndex].relevance > max) {
                max = grid.e[rows][columnIndex].relevance;
                nextCell.indexRow = rows;
                nextCell.indexColumn = columnIndex;
            }
        } else {
            if (!grid.e[rowIndex - 1][columnIndex].isPresent && grid.e[rowIndex - 1][columnIndex].relevance > max) {
                max = grid.e[rowIndex - 1][columnIndex].relevance;
                nextCell.indexRow = rowIndex - 1;
                nextCell.indexColumn = columnIndex;
            }
        }

        if (rowIndex + 1 > rows) {
            if (!grid.e[0][columnIndex].isPresent && grid.e[0][columnIndex].relevance > max) {
                max = grid.e[0][columnIndex].relevance;
                nextCell.indexRow = 0;
                nextCell.indexColumn = columnIndex;
            }
        } else {
            if (!grid.e[rowIndex + 1][columnIndex].isPresent && grid.e[rowIndex + 1][columnIndex].relevance > max) {
                max = grid.e[rowIndex + 1][columnIndex].relevance;
                nextCell.indexRow = rowIndex + 1;
                nextCell.indexColumn = columnIndex;
            }
        }

        if (columnIndex - 1 < 0) {
            if (!grid.e[rowIndex][columns].isPresent && grid.e[rowIndex][columns].relevance > max) {
                max = grid.e[rowIndex][columns].relevance;
                nextCell.indexRow = rowIndex;
                nextCell.indexColumn = columns;
            }
        } else {
            if (!grid.e[rowIndex][columnIndex - 1].isPresent && grid.e[rowIndex][columnIndex - 1].relevance > max) {
                max = grid.e[rowIndex][columnIndex - 1].relevance;
                nextCell.indexRow = rowIndex;
                nextCell.indexColumn = columnIndex - 1;
            }
        }

        if (columnIndex + 1 > columns) {
            if (!grid.e[rowIndex][0].isPresent && grid.e[rowIndex][0].relevance > max) {
                max = grid.e[rowIndex][0].relevance;
                nextCell.indexRow = rowIndex;
                nextCell.indexColumn = 0;
            }
        } else {
            if (!grid.e[rowIndex][columnIndex + 1].isPresent && grid.e[rowIndex][columnIndex + 1].relevance > max) {
                max = grid.e[rowIndex][columnIndex + 1].relevance;
                nextCell.indexRow = rowIndex;
                nextCell.indexColumn = columnIndex + 1;
            }
        }
        nextCell.isPresent = true;
        return nextCell;
    }

}
