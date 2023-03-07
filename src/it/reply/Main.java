package it.reply;

import it.reply.model.Demon;
import it.reply.model.Pandora;
import it.reply.parser.InputParser;
import it.reply.parser.OutputParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Commit Lorenzo Fratini");

        String inputDirectory = "src/it/reply/input";
        String outputDirectory = "src/it/reply/output";
        List<String> inputFiles = Arrays.asList("01","04");

        for(String file : inputFiles) {
            Algorithm algo = new Algorithm();
            System.out.println("FILE: " + file);

            // Parse input
            InputParser inputParser = new InputParser(inputDirectory + "/" + file);
            Pandora pandora = inputParser.parsePandora();
            List<Demon> demons = inputParser.parseDemons(pandora);
            inputParser.close();

            // Solutioning
            List<Integer> indexes = algo.solve(pandora, demons);

            // Parse output
            OutputParser outputParser = new OutputParser(outputDirectory + "/" + file + "_out");
            outputParser.parseOutput(indexes);
            outputParser.close();
        }
    }
}
