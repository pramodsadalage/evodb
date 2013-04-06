package com.thoughtworks.domain;

import java.sql.Date;
import java.math.BigDecimal;

public class Account extends DomainObject {
    private Long customerPOId;
    private String accountNumber;
    private Date openedOn;
    private Date closedOn;
    private String accountType;
    private BigDecimal balance;
    private Date effectiveSince;

    public Long getCustomerPOId() {
        return customerPOId;
    }

    public void setCustomerPOId(Long customerPOId) {
        this.customerPOId = customerPOId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpenedOn() {
        return openedOn;
    }

    public void setOpenedOn(Date openedOn) {
        this.openedOn = openedOn;
    }

    public Date getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(Date closedOn) {
        this.closedOn = closedOn;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getEffectiveSince() {
        return effectiveSince;
    }

    public void setEffectiveSince(Date effectiveSince) {
        this.effectiveSince = effectiveSince;
    }
}
