package com.rest.banking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {

    @Test
    public void testCreditCard(){
        CreditCard creditCard = new CreditCard();

        creditCard.setCid(1L);
        creditCard.setCardNumber("13579086421");
        creditCard.setCardHolderName("Kalyan");
        creditCard.setExpiryDate("07/2027");

        assertEquals(1L, creditCard.getCid());
        assertEquals("13579086421", creditCard.getCardNumber());
        assertEquals("Kalyan", creditCard.getCardHolderName());
        assertEquals("07/2027", creditCard.getExpiryDate());

    }
}
