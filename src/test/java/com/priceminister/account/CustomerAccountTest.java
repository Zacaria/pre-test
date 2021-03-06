package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule(-50.0);
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        Double zeroBalance = 0.0;
        assertEquals(zeroBalance, customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() throws IllegalAmountException {
        // Valid value
        Double positiveAmount = 15.99;

        customerAccount.add(positiveAmount);
        assertEquals(positiveAmount, customerAccount.getBalance());
    }

    /**
     * Adds a negative value to the account 
     * And checks that IllegalAmountException exception is thrown
     */
    @Test(expected=IllegalAmountException.class)
    public void testAddNegativeAmount() throws IllegalAmountException {
        Double negativeAmount = -15.99;
        customerAccount.add(negativeAmount);
    }

    /**
     * Adds a null value to the account 
     * And checks that IllegalAmountException exception is thrown
     */
    @Test(expected=IllegalAmountException.class)
    public void testAddNullAmount() throws IllegalAmountException {
        customerAccount.add(null);
    }

    /**
     * Tests that a lower amount than the authorized balance
     * Returns the new balance
     * And removes the given amount from the balance
     * @throws IllegalBalanceException
     */
    @Test
    public void testWithdrawAndReportBalance () throws IllegalBalanceException, IllegalAmountException {
        Double lowerAmountThanMinimumBalance = 25.0;
        Double expectedNewBalance = -25.0;
        Double newBalance = customerAccount.withdrawAndReportBalance(lowerAmountThanMinimumBalance, rule);

        assertEquals(expectedNewBalance, newBalance);
    }


    /**
     * Tests that an illegal withdrawal throws the expected exception.
     */
    @Test(expected=IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException, IllegalAmountException {
        Double greaterAmountThanMinimumBalance = 100.0;
        customerAccount.withdrawAndReportBalance(greaterAmountThanMinimumBalance, rule);
    }

    /**
     * Tests that a null amount withdrawal throws the expected exception.
     */
    @Test(expected=IllegalAmountException.class)
    public void testNullWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException, IllegalAmountException {
        customerAccount.withdrawAndReportBalance(null, rule);
    }
}
