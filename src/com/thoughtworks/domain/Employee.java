package com.thoughtworks.domain;

import java.sql.Date;

public class Employee extends DomainObject {

    private Long managerEmployeeId;
    private Date hireDate;
    private String email;
    private String firstName;
    private String nickName;
    private Date terminatedDate;
    private String lastName;
    private Date birthDate;
    private Boolean hasAccessToCustomer;

    public Long getManagerEmployeeId() {
        return managerEmployeeId;
    }

    public void setManagerEmployeeId(Long managerEmployeeId) {
        this.managerEmployeeId = managerEmployeeId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getTerminatedDate() {
        return terminatedDate;
    }

    public void setTerminatedDate(Date terminatedDate) {
        this.terminatedDate = terminatedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getHasAccessToCustomer() {
        return hasAccessToCustomer;
    }

    public void setHasAccessToCustomer(Boolean hasAccessToCustomer) {
        this.hasAccessToCustomer = hasAccessToCustomer;
    }
}