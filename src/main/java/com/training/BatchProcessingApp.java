package com.training;

import com.training.utils.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchProcessingApp {
    public static void main(String[] args) {
        // Generate data
        DataGenerator.generateDataToFile("generated-data/data",".csv",1000);
        
        // Run batch processing
        System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApp.class, args)));
    }
}
