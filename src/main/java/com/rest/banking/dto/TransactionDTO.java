package com.rest.banking.dto;

import com.rest.banking.model.TransactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TransactionDTO {
    private Long transFrom;
    private Long transTo;
    private Double amount;
    private TransactionType transactionType;

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
}
