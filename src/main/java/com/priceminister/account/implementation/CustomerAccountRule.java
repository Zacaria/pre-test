/*
 * =============================================================================
 *
 *   PRICE MINISTER APPLICATION
 *   Copyright (c) 2000 Babelstore.
 *   All Rights Reserved.
 *
 *   $Source$
 *   $Revision$
 *   $Date$
 *   $Author$
 *
 * =============================================================================
 */
package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccountRule implements AccountRule {

    private Double minimumBalance;

    public CustomerAccountRule(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public boolean withdrawPermitted(Double resultingAccountBalance) {
        return resultingAccountBalance >= minimumBalance;
    }

    public Double getMinimumBalance() {
        return minimumBalance;
    }
}
