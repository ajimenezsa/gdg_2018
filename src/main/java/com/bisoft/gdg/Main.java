package com.bisoft.gdg;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final int MAX_ITERATION = 10000;


    public static void main(String[] args) {
        Main m = new Main();
        try {
            URL data = Main.class.getResource("/small.in");
            m.processData(data.getPath());
        } catch (Exception e) {
            logger.error("Error processing problem ", e);
        }
    }



    int solutionIterations = 0;

    private void processData(String fileDataPath) throws Exception {
        logger.info("Starting process for file "+fileDataPath);




    }




}
