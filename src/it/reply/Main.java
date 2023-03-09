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

        System.out.println("Commit Lorenzo Fratini");
        System.out.println("Commit Nicola Levorato");
        System.out.println("Commit Fra");

        String inputDirectory = "src/it/reply/input";
        String outputDirectory = "src/it/reply/output";
        List<String> inputFiles = Arrays.asList("01","04");

        for(String file : inputFiles) {
            Algorithm algo = new Algorithm();
            System.out.println("FILE: " + file);

            // Parse input
            InputParser inputParser = new InputParser(inputDirectory + "/" + file);
            Header pandora = inputParser.parseHeader();
            Snakes snakes = inputParser.parseSnakes();
            Grid grid = inputParser.parseGrid(inputParser.parseHeader());
            inputParser.close();

            // Parse output
            //OutputParser outputParser = new OutputParser(outputDirectory + "/" + file + "_out");
            //outputParser.parseOutput(indexes);
            //outputParser.close();
        }
    }
}
