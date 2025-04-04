package com.rest.banking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "debit_card")
public class DebitCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long did;

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    @OneToOne
    @JoinColumn(name = "accid", nullable = false)
    @JsonBackReference
    private Account account;

    public DebitCard(){}

    public DebitCard(String cardNumber, String cardHolderName, String expiryDate, Account account) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.account = account;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "did=" + did +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", account=" + account +
                '}';
    }
}
