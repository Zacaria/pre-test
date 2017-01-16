package com.priceminister.account;

public class IllegalAmountException extends Exception {

    private Double amount;

    public IllegalAmountException(Double illgalAmount) {
        this.amount = illgalAmount;
    }

    public String toString() {
        return "Illegal amount:" + amount;
    }
}
