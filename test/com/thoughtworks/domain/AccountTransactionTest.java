package com.thoughtworks.domain;

import com.thoughtworks.util.HibernateUtil;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountTransactionTest {

    @Test
    public void shouldCreateAccountTransaction() throws Exception {
        AccountTransaction accountTransaction = createAccountTransaction();
        HibernateUtil.saveDomainObject(accountTransaction);
        AccountTransaction txn = new AccountTransaction();
        AccountTransaction loadedTxn = (AccountTransaction) HibernateUtil.load(txn, accountTransaction.getId());
        assertEquals("AccountID should have been same", accountTransaction.getAccountID(), loadedTxn.getAccountID());
        HibernateUtil.removeDomainObject(txn);
    }

    private AccountTransaction createAccountTransaction() {
        AccountTransaction txn = new AccountTransaction();
        txn.setAccountID((long) 1);
        txn.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
        txn.setTransactionType("Deposit");
        txn.setAmount(new BigDecimal("23.45"));
        return txn;
    }

}
