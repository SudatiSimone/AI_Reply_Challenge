package it.reply;

import it.reply.model.Grid;
import it.reply.model.Header;
import it.reply.model.Snakes;
import it.reply.parser.InputParser;
import it.reply.parser.OutputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputDirectory = "src/it/reply/input";
        String outputDirectory = "src/it/reply/output";
        List<String> inputFiles = Arrays.asList("00");

        for(String file : inputFiles) {
            Algorithm algo = new Algorithm();
            System.out.println("FILE: " + file);

            // Parse input
            InputParser inputParser = new InputParser(inputDirectory + "/" + file);
            Header header = inputParser.parseHeader();
            Snakes snakes = inputParser.parseSnakes();
            Grid grid = inputParser.parseGrid(header);
            inputParser.close();

            Algorithm algorithm = new Algorithm();

            SnakeOut snakeOut = algorithm.solve(header, snakes, grid);

            // Parse output
            //OutputParser outputParser = new OutputParser(outputDirectory + "/" + file + "_out");
            //outputParser.parseOutput(indexes);
            //outputParser.close();

            //Print
            GridElem cell = Utils.nextBestMove(grid, 2, 9, 5, 9);
            System.out.println("Riga: " + cell.indexRow);
            System.out.println("Colonna: " + cell.indexColumn);
            OutputParser outputParser = new OutputParser(outputDirectory + "/" + file + "_out");
            outputParser.parseOutput(snakeOut, header.snakeNr, header.colNr, header.rowNr);
            outputParser.close();
        }
    }
}
