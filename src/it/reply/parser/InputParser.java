package it.reply.parser;

import it.reply.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public BufferedReader br;

    public InputParser(String file) throws FileNotFoundException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    }

    public Header parseHeader() throws IOException {
        String headerLine = br.readLine();
        String[] splits = headerLine.split(" ");
        Header header = new Header();
        header.colNr = Integer.parseInt(splits[0]);
        header.rowNr = Integer.parseInt(splits[1]);
        header.snakeNr = Integer.parseInt(splits[2]);
        return header;
    }

    public Snakes parseSnakes() throws IOException {
        Snakes snakes = new Snakes();
        String snakesLengthLine = br.readLine();
        String[] splits = snakesLengthLine.split(" ");
        List<Integer> lengths = new ArrayList<>();
        for(int j = 0; j < splits.length; j++) {
            lengths.add(Integer.parseInt(splits[j]));
        }
        snakes.lenghtList = lengths;
        return snakes;
    }

    public Grid parseGrid(Header header) throws IOException {
        Grid v = new Grid(header.rowNr, header.colNr);
        for (int i = 0; i < header.rowNr; i++) {
            String demonLine = br.readLine();
            String[] splits = demonLine.split(" ");
            for (int j = 0; j < header.colNr; i++) {
                GridElem gridElem = new GridElem();
                if ("*".equals(splits[j].charAt(0))) {
                    gridElem.isWarmhole=true;
                    gridElem.relevance=0;
                } else {
                    gridElem.isWarmhole=false;
                    gridElem.relevance=Integer.parseInt(splits[j]);
                }
                gridElem.isPresent=false;
                v.e[i][j] = gridElem;
            }
        }
        return v;
    }

    public void close() throws IOException {
        br.close();
    }
}