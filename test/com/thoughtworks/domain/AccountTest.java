package com.thoughtworks.domain;

import com.thoughtworks.util.HibernateUtil;
import com.thoughtworks.util.Today;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AccountTest {
    private Customer customer;

    @Before
    public void setUpCustomer() throws Exception {
        customer = new Customer();
        customer.setCustomerNumber(999999L);
        customer.setName("Mike");
        customer.setCity("Chicago");
        customer.setPhoneAreaCode("773");
        customer.setPhoneNumber("3322111");
        HibernateUtil.saveDomainObject(customer);
    }

    @After
    public void removeCustomer() throws Exception {
        HibernateUtil.removeDomainObject(customer);
    }

    @Test
    public void shouldCreateAccount() {
        Account account = createAccount();
        HibernateUtil.saveDomainObject(account);
        assertNotNull("Account should have a ID", account.getId());
        cleanUp(account);
    }

    private void cleanUp(Account account) {
        HibernateUtil.removeDomainObject(account);
    }

    @Test
    public void shouldUpdateExistingAccount() throws Exception {
        Account accountToUpdate = createAccount();
        HibernateUtil.saveDomainObject(accountToUpdate);
        accountToUpdate.setClosedOn(new Today().day());
        HibernateUtil.updateDomainObject(accountToUpdate);
        Account retrivedAccount = new Account();
        retrivedAccount = (Account) HibernateUtil.load(retrivedAccount, accountToUpdate.getId());
        assertTrue("Invalid closed on date", new Today().isSameDayAs(retrivedAccount.getClosedOn()));
        cleanUp(retrivedAccount);
    }

    @Test
    public void shouldNotCreateAccountWithoutCustomer() throws Exception {
        Account account = createAccount();
        account.setCustomerPOId(100000000000L);
        try {
            HibernateUtil.saveDomainObject(account);
            fail("Account should have a customer");
        } catch (Exception e) {
            // Expected
        }
    }

    private Account createAccount() {
        Account account = new Account();
        account.setAccountNumber("99999999");
        account.setAccountType("Checking");
        account.setBalance(new BigDecimal("10.00"));
        account.setEffectiveSince(new Today().past());
        account.setOpenedOn(new Today().past());
        account.setCustomerPOId(customer.getId());
        return account;
    }
}
