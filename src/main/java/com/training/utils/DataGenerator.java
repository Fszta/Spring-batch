package com.training.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.util.UUID.randomUUID;

public class DataGenerator {

    private static final Logger log = LoggerFactory.getLogger(DataGenerator.class);

    /**
     * Run data generation & save it to file
     * @param fileName name of the file
     * @param fileExtension file extension, ie : csv / txt
     * @param nbSamples number of samples to generate
     */
    static public void generateDataToFile(String fileName, String fileExtension, Integer nbSamples) {
        log.info("Generate " + nbSamples + " transactions samples inside "+ fileName + fileExtension);
        List<TransactionSample> generatedTransactions = generateTransactions(nbSamples);
        writeDataToCsv(generatedTransactions,fileName,fileExtension);
    }

    /**
     * Create transactions samples
     * @param numberOfSamples number of samples to generate
     * @return array of transaction
     */
    static private List<TransactionSample> generateTransactions(Integer numberOfSamples) {
        List<TransactionSample> transactions = new ArrayList<>();
        Random r = new Random();

        for (int i=0; i<numberOfSamples; i++) {
            TransactionSample transaction = new TransactionSample(
                    randomUUID(),
                    r.nextInt(65536)-32768,
                    System.currentTimeMillis() +r.nextInt(10000)
            );
            transactions.add(transaction);
        }

        return transactions;
    }

    /**
     * Write transactions data to file
     * @param transactionsData arrayList of transactions
     * @param fileName name of the file
     * @param fileExtension extension of the file ie .csv, .txt
     * @throws IOException
     */
    static private void writeDataToCsv(List<TransactionSample> transactionsData,
                                       String fileName, String fileExtension) {

        final String fileNameWithExtension = fileName + fileExtension;

        try(FileWriter fw = new FileWriter(fileNameWithExtension, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            for (Iterator<TransactionSample> i =  transactionsData.iterator(); i.hasNext();) {
                TransactionSample transaction = i.next();
                out.println(
                        transaction.accountId + "," + transaction.amount + "," + transaction.timestamp
                );
            }
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}

class TransactionSample {
    UUID accountId;
    Integer amount;
    Long timestamp;

    TransactionSample(UUID accountId, Integer amount, Long timestamp) {
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = timestamp;
    }
}