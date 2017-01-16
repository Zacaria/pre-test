package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance = 0.0;

    public void add(Double addedAmount) throws IllegalAmountException {
        if(addedAmount == null || addedAmount <= 0.0) {
            throw new IllegalAmountException(addedAmount);
        }
        this.balance = this.balance + addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
        // TODO Auto-generated method stub
        return null;
    }

}
