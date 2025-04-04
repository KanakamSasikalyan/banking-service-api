package com.rest.banking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    public void testTransaction(){
        Transaction transaction = new Transaction();

        transaction.setTransFrom(1L);
        transaction.setTransTo(2L);
        transaction.setAmount(10000d);
        transaction.setTransId(1234567L);
        transaction.setTransactionType(TransactionType.CREDIT_CARD);

        assertEquals(1L, transaction.getTransFrom());
        assertEquals(2L, transaction.getTransTo());
        assertEquals(10000d, transaction.getAmount());
        assertEquals(1234567L, transaction.getTransId());
        assertEquals(TransactionType.CREDIT_CARD, transaction.getTransactionType());
    }
}
