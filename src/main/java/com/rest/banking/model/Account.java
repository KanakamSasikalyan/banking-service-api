package com.rest.banking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accid;

    @Enumerated(EnumType.STRING)
    private AccountType acctype;

    private Double balance;
    private String currency;
    private String branchcode;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private DebitCard debitCard;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private CreditCard creditCard;

    public Account(){

    }

    public Account(AccountType acctype, Double balance, String currency, String branchcode, String status, Customer customer, CreditCard creditCard, DebitCard debitCard) {
        this.acctype = acctype;
        this.balance = balance;
        this.currency = currency;
        this.branchcode = branchcode;
        this.status = status;
        this.customer = customer;
        this.creditCard = creditCard;
        this.debitCard = debitCard;
    }

    public Long getAccid() {
        return accid;
    }

    public void setAccid(Long accid) {
        this.accid = accid;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accid=" + accid +
                ", acctype=" + acctype +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", branchcode='" + branchcode + '\'' +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", creditCard=" + creditCard +
                ", debitCard=" + debitCard +
                '}';
    }
}
