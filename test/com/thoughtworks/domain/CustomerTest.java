package com.thoughtworks.domain;

import com.thoughtworks.util.HibernateUtil;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CustomerTest {

    @Test
    public void shouldCreateCustomer() throws Exception {
        Customer customer = createCustomer();
        HibernateUtil.saveDomainObject(customer);
        assertNotNull("Customer should have a ID", customer.getId());
        cleanUp(customer);
    }

    private void cleanUp(Customer customerToDelete) {
        HibernateUtil.removeDomainObject(customerToDelete);
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = createCustomer();
        HibernateUtil.saveDomainObject(customer);
        String customerNameToUpdate = "Mike2";
        customer.setName(customerNameToUpdate);
        HibernateUtil.updateDomainObject(customer);
        Customer customerToLoad = new Customer();
        Customer customerRetrivedFromDB = (Customer) HibernateUtil.load(customerToLoad, customer.getId());
        assertEquals("Incorrect FirstName", "Mike2", customerRetrivedFromDB.getName());
        assertEquals("ID should have been the same", customer.getId(), customerRetrivedFromDB.getId());
        cleanUp(customerRetrivedFromDB);
    }

    @Test
    public void shouldNotDieWhenCustomerNotFound() throws Exception {
        Customer customerToLoad = new Customer();
        Customer customerRetrivedFromDB = (Customer) HibernateUtil.load(customerToLoad, 9999L);
        assertNull("Customer found when it should have not been found", customerRetrivedFromDB);
    }

    private Customer createCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerNumber(999999L);
        customer.setName("Mike");
        customer.setCity("Chicago");
        customer.setPhoneCountryCode("001");
        customer.setPhoneAreaCode("773");
        customer.setPhoneNumber("3322111");
        return customer;
    }

}
