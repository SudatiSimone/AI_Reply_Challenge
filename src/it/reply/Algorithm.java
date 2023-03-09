package it.reply;

import it.reply.model.*;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    public SnakeOut solve(Header h, Snakes snakes, Grid grid) {
        SnakeOut snakeOut = new SnakeOut();
        //snakes.lenghtList.stream().forEach(s -> {
            List<Cell> cells = new ArrayList<>();
            cells.add(new Cell(0, 0, false));
            cells.add(new Cell(1, 0, false));
            cells.add(new Cell(2, 0, false));
            cells.add(new Cell(2, 1, true));
            cells.add(new Cell(7, 2, false));
            cells.add(new Cell(8, 2, false));
            cells.add(new Cell(9, 2, false));
            snakeOut.positions.put(0, cells);
            cells = new ArrayList<>();
            cells.add(new Cell(1,1, false));
            cells.add(new Cell(2,1, true));
            cells.add(new Cell(3, 4, false));
            cells.add(new Cell(4, 4, false));
            cells.add(new Cell(5, 4, false));
            cells.add(new Cell(6, 4, false));
            snakeOut.positions.put(1, cells);
            cells = new ArrayList<>();
            cells.add(new Cell(7,1, false));
            cells.add(new Cell(7,2, true));
            cells.add(new Cell(3, 4, false));
            cells.add(new Cell(2, 4, false));
            snakeOut.positions.put(2, cells);
            cells = new ArrayList<>();
            cells.add(new Cell(9,0, false));
            cells.add(new Cell(9,5, true));
            cells.add(new Cell(8, 5, false));
            snakeOut.positions.put(3, cells);
            /*for (int i=0; i<h.rowNr; i++) {
                for (int j=0; j<h.colNr; i++) {

                }
                snakeOut.positions.put(i);
            }*/
        //});

        return snakeOut;
    }
}
