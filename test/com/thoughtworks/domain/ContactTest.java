package com.thoughtworks.domain;

import com.thoughtworks.util.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ContactTest {

    @Test
    public void shouldCreateContact() {
        Contact contact = createAContact();
        HibernateUtil.saveDomainObject(contact);
        cleanUp(contact);
    }

    @Test
    public void shouldNotAllowNullEmailOnCreateContact() {
        Contact contact = createAContact();
        contact.setEmail(null);
        try {
            HibernateUtil.saveDomainObject(contact);
            fail();
        } catch (Exception e) {
            //expected
            assertTrue(e.getCause().toString().contains("ORA-01400"));
        }
        cleanUp(contact);
    }

    @Test
    public void shouldUpdateExistingContact() {
        Contact contact = createAContact();
        HibernateUtil.saveDomainObject(contact);
        contact.setName("vada");
        HibernateUtil.updateDomainObject(contact);
        Contact newContact = new Contact();
        Contact updatedObject = (Contact) HibernateUtil.load(newContact, contact.getId());
        assertEquals("Name should be vada", "vada", updatedObject.getName());
        cleanUp(contact);
    }

    private void cleanUp(Contact contact) {
        HibernateUtil.removeDomainObject(contact);
    }

    private Contact createAContact() {
        Contact contact = new Contact();
        contact.setName("food");
        contact.setEmail("food@food.com");
        contact.setPhonecountrycode("1");
        contact.setPhoneareacode("312");
        contact.setPhonenumber("3735555");
        return contact;
    }

}
