package it.reply.parser;

import java.io.*;
import java.util.List;

public class OutputParser {
    public BufferedWriter bw;

    public OutputParser(String file) throws FileNotFoundException {
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
    }

    public void parseOutput(List<Integer> indexes) throws IOException {
        for(int index : indexes) {
            bw.write(index + "\n");
        }
    }

    public void close() throws IOException {
        bw.close();
    }
}