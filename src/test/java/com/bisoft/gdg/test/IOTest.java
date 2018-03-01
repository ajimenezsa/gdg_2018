package com.bisoft.gdg.test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;

import com.bisoft.gdg.io.BsvParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author ajimenez, created on 28/02/18.
 */
public class IOTest {


    @Test
    public void readTest() throws Exception{
        BsvParser parser = new BsvParser();
        URL resource = IOTest.class.getResource("/example.in");
        String path = resource.getPath();
        List<String> result = parser.readData(path);
        Assert.assertEquals("3 5 1 6", result.get(0));
        Assert.assertEquals("TTTTT", result.get(1));
        Assert.assertEquals("TMMMT", result.get(2));
        Assert.assertEquals("TTTTT", result.get(3));
    }


    @Test
    public void writeTest() throws IOException {
        BsvParser parser = new BsvParser();
        String filePath = "/tmp/gdg_IOTest_"+ UUID.randomUUID().toString().substring(0,5);

        List<String> testData = new ArrayList<>();
        Random random = new Random();
        int lines = random.nextInt(10)+1;
        for(int i = 0; i < lines; i ++ ){
            int columns = random.nextInt(10)+1;
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < columns; j++){
                row.append(String.valueOf(random.nextInt())).append(" ");
            }
            testData.add(row.toString().trim());
        }
        parser.writeData(filePath, testData);

        List<String> read = parser.readData(filePath);


        Assert.assertEquals(testData, read);
    }



}
