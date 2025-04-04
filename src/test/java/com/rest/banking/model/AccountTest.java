package com.rest.banking.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {

    @Test
    public void testConstructor(){
        Account account = new Account(AccountType.SAVINGS, 10.d, "INR", "SBI000123", "ACTIVE", new Customer(), new CreditCard(), new DebitCard());
        assertNotNull(account);
    }

    @Test
    public void testAccount(){
        Account account = new Account();
        AccountType accountType = AccountType.SAVINGS;
        account.setAccid(1L);
        account.setBalance(10000d);
        account.setAcctype(accountType);
        account.setStatus("ACTIVE");
        account.setBranchcode("HDFC00001");
        account.setCurrency("INR");
        account.setCreditCard(new CreditCard());
        account.setDebitCard(new DebitCard());

        assertEquals(1L, account.getAccid());
        assertEquals(10000d, account.getBalance());
        assertEquals(AccountType.SAVINGS, account.getAcctype());
        assertEquals("ACTIVE", account.getStatus());
        assertEquals("HDFC00001", account.getBranchcode());
        assertEquals("INR", account.getCurrency());
        assertNotNull(account.getCreditCard());
        assertNotNull(account.getDebitCard());
    }

    @Test
    public void testToString(){
        Account account = new Account();
        AccountType accountType = AccountType.SAVINGS;
        account.setAccid(1L);
        account.setBalance(10000d);
        account.setAcctype(accountType);
        account.setStatus("ACTIVE");
        account.setBranchcode("HDFC00001");
        account.setCurrency("INR");
        account.setCreditCard(new CreditCard());
        account.setDebitCard(new DebitCard());

        String expectedResult = "Account{accid=1, " +
                "acctype=SAVINGS, " +
                "balance=10000.0, " +
                "currency='INR', " +
                "branchcode='HDFC00001', " +
                "status='ACTIVE', " +
                "customer=null, " +
                "creditCard=CreditCard{cid=null, " +
                "cardNumber='null', " +
                "cardHolderName='null', " +
                "expiryDate='null', account=null}, " +
                "debitCard=DebitCard{did=null, " +
                "cardNumber='null', " +
                "cardHolderName='null', " +
                "expiryDate='null', " +
                "account=null}}";

        assertEquals(expectedResult, account.toString());
    }
}
