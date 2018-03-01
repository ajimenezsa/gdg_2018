package com.bisoft.gdg.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ajimenez, created on 28/02/18.
 */
public class BsvParser {


    public List<String> readData(String filePath) throws IOException{
        return readFile(new File(filePath));
    }

    public void writeData(String filePath, List<String> data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for(String dataLine : data) {
            bw.write(dataLine.trim());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    private List<String> readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> result = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            result.add(line);
        }
        return result;
    }

}
