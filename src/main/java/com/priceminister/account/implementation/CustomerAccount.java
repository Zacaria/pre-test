package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance = 0.0;

    public void add(Double addedAmount) throws IllegalAmountException {
        if(addedAmount == null || addedAmount <= 0.0) {
            throw new IllegalAmountException(addedAmount);
        }
        balance = balance + addedAmount;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
    		throws IllegalBalanceException, IllegalAmountException {
        if(withdrawnAmount == null) {
            throw new IllegalAmountException(withdrawnAmount);
        }

        Double newAmount = balance - withdrawnAmount;
        if(!rule.withdrawPermitted(newAmount)) {
            throw new IllegalBalanceException(newAmount);
        }

        return newAmount;
    }

    public Double getBalance() {
        return balance;
    }
}
