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

        //Iterando sui serpenti
        for (Integer l : serpenti) {

            cells = new ArrayList<>();

            //iterare sulla lunghezza del serpente
            for (Integer j =0; j < l; ++j){

                gridElem = Utils.startFreeGridElem(h, grid);

                if (j == 0) {
                    currCell = new Cell(gridElem.indexColumn, gridElem.indexRow, gridElem.isWarmhole);
                    cells.add(currCell);
                } else {
                    GridElem gridElem1 = Utils.nextBestMove(grid, gridElem.indexColumn, gridElem.indexRow, h.rowNr - 1, h.colNr - 1);
                    currCell = new Cell(gridElem1.indexColumn, gridElem1.indexRow, gridElem1.isWarmhole);
                    cells.add(currCell);
                }
            }

            snakeOut.paths.put(l, cells);

        }

        return snakeOut;
    }
}
