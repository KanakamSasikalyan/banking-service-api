package com.rest.banking.dto;

import com.rest.banking.model.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AccountDTO {
    @Enumerated(EnumType.STRING)
    private AccountType acctype;

    private Double balance;
    private String currency;
    private String branchcode;
    private String status;

    public AccountType getAcctype() {
        return acctype;
    }

    public void setAcctype(AccountType acctype) {
        this.acctype = acctype;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
