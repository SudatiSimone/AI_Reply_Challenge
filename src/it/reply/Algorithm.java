package it.reply;

import it.reply.model.*;
import it.reply.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    public SnakeOut solve(Header h, Snakes snakes, Grid grid) {

        SnakeOut snakeOut = new SnakeOut();

//        // ordino i serpenti per lunghezza
//        snakes.lenghtList.stream()
//            .sorted((int1, int2) ->{
//            return int1>int2;
//        });

        // per ogni serpente
        List<Integer> serpenti = snakes.lenghtList;
        List<Cell> cells = new ArrayList<>();
        GridElem gridElem = null;
        Cell currCell = null;
        int i = 0;

        //Iterando sui serpenti
        for (Integer l : serpenti) {

            cells = new ArrayList<>();

            //iterare sulla lunghezza del serpente
            for (Integer j =0; j < l; j++){



                if (j == 0) {
                    gridElem = Utils.startFreeGridElem(h, grid);
                    currCell = new Cell(gridElem.indexColumn, gridElem.indexRow, false);
                    cells.add(currCell);
                    grid.e[gridElem.indexRow][gridElem.indexColumn].isPresent = true;
                } else {
                    GridElem gridElem1 = Utils.nextBestMove(grid, currCell.row, currCell.column, h.rowNr -1, h.colNr -1);
                    currCell = new Cell(gridElem1.indexColumn, gridElem1.indexRow, false);
                    cells.add(currCell);
                    grid.e[gridElem1.indexRow][gridElem1.indexColumn].isPresent = true;
                }
            }

            snakeOut.paths.put(i, cells);
            i = i + 1;

        }

        return snakeOut;
    }
}
