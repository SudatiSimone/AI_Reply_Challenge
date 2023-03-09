package it.reply.parser;

import it.reply.model.Cell;
import it.reply.model.SnakeOut;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class OutputParser {
    public BufferedWriter bw;

    public OutputParser(String file) throws FileNotFoundException {
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
    }

    public void parseOutput(SnakeOut snakeOut, Integer snakeNumber, Integer columnNumber, Integer rowNumber) throws IOException {

        // Itero sui serpenti
        for (int i = 0; i < snakeNumber; ++i) {

            if (Optional.ofNullable(snakeOut.paths.get(i)).isPresent()) {

                if (snakeOut.paths.get(i).size() > 0) {

                    List<Cell> path = snakeOut.paths.get(i);
                    int size = snakeOut.paths.get(i).size();

                    // Mettere la prima posizione
                    bw.write(path.get(0).column + " " + path.get(0).row + " ");

                    // Iterare sulle posizioni del singolo serprente
                    for (int j = 0; i < size - 1; ++i) {

                        //Se non è un buco
                        if (!path.get(j).isWormholeEntry){
                            String direction = calculateDirectionNoBuchi(path.get(j), path.get(j + 1), columnNumber, rowNumber);
                            bw.write(" " + direction);
                        }else { //Se è un buco
                            // qua inserire integer della destinazione
                            Cell destCell = path.get(j + 1);
                            bw.write(" " + destCell.column + " " + destCell.row);
                        }

                    }

                    bw.write("\n");

                }
            }

        }
    }

    public String calculateDirectionNoBuchi(Cell beforeCell, Cell afterCell, Integer numCol, Integer numRow) {

        String dir = "R";
        if ((beforeCell.column == afterCell.column + 1 && beforeCell.row == afterCell.row)
            || (beforeCell.column == numCol - 1 && afterCell.column == 0 && beforeCell.row == afterCell.row)) {
            dir = "R";
        } else if ((beforeCell.column == afterCell.column - 1 && beforeCell.row == afterCell.row)
            || (beforeCell.column == 0 && afterCell.column == numCol - 1 && beforeCell.row == afterCell.row)) {
            dir = "L";
        } else if ((beforeCell.row == afterCell.row + 1 && beforeCell.column == afterCell.column)
            || (beforeCell.row == 0 && afterCell.row == numRow - 1 && beforeCell.column == afterCell.column)) {
            dir = "U";
        } else if ((beforeCell.row == afterCell.row - 1 && beforeCell.column == afterCell.column)
            || (beforeCell.row == numRow - 1 && afterCell.row == 0 && beforeCell.column == afterCell.column)) {
            dir = "D";
        }
        return dir;
    }

    public void close() throws IOException {
        bw.close();
    }
}