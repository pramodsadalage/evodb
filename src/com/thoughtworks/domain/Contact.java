package com.thoughtworks.domain;

public class Contact extends DomainObject {
    private String name;
    private String phonecountrycode;
    private String phoneareacode;
    private String phonenumber;

    public String getPhonecountrycode() {
        return phonecountrycode;
    }

    public void setPhonecountrycode(String phonecountrycode) {
        this.phonecountrycode = phonecountrycode;
    }

    public String getPhoneareacode() {
        return phoneareacode;
    }

    public void setPhoneareacode(String phoneareacode) {
        this.phoneareacode = phoneareacode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
