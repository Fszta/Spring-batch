package com.training.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TransactionItemProcessor implements ItemProcessor<Transaction,Transaction> {

    private static final Logger log = LoggerFactory.getLogger(TransactionItemProcessor.class);

    @Override
    public Transaction process(Transaction transaction) {
        String transactionType;

        if(transaction.getAmount() < 0) {
            transactionType = "debit";
        } else {
            transactionType = "credit";
        }
        transaction.setTransactionType(transactionType);
        final Transaction transactionWithType = transaction;

        log.info("Defining transaction type: " + transactionType);
        return transactionWithType;
    }
}
