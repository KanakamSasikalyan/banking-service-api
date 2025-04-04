package com.rest.banking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_cd")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transId;
    private Long transFrom;
    private Long transTo;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public Transaction(){
        //default constructor
    }

    public Transaction(Long transFrom, Long transTo, Double amount, TransactionType transactionType) {
        this.transFrom = transFrom;
        this.transTo = transTo;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public Long getTransFrom() {
        return transFrom;
    }

    public void setTransFrom(Long transFrom) {
        this.transFrom = transFrom;
    }

    public Long getTransTo() {
        return transTo;
    }

    public void setTransTo(Long transTo) {
        this.transTo = transTo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId=" + transId +
                ", transFrom=" + transFrom +
                ", transTo=" + transTo +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }
}
