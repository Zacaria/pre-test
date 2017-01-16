package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.CustomerAccountRule;

public class CustomerAccountRuleTest {

    AccountRule rule;
    Double minimumBalance = -10.0;

    @Before
    public void setUp() {
        rule = new CustomerAccountRule(minimumBalance);
    }

    /**
     * This may look like a dumb test
     * But if the init logic changes
     * The test will still be here
     */
    @Test
    public void testRuleInitialization() {
        assertEquals(minimumBalance, rule.getMinimumBalance());
    }

    /**
     * Tests the rule when the given balance is allowed
     */
    @Test
    public void testWithdrawPermitted () {
        Double greaterAccountBalanceThanPermitted = 5.0;
        boolean permitted = rule.withdrawPermitted(greaterAccountBalanceThanPermitted);
        assertTrue(permitted);
    }

    /**
     * Tests the rule when the given balance is not allowed
     */
    @Test
    public void testWithdrawNotPermitted () {
        Double lowerAccountBalanceThanPermitted = -15.0;
        boolean permitted = rule.withdrawPermitted(lowerAccountBalanceThanPermitted);
        assertFalse(permitted);
    }
}
