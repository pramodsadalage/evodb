package com.thoughtworks.domain;

import com.thoughtworks.util.HibernateUtil;
import com.thoughtworks.util.Today;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;

import static junit.framework.Assert.*;
import static org.junit.Assert.fail;

public class EmployeeTest {

    @Test
    public void shouldCreateNewEployee() throws Exception {
        Employee employee = createEmployee();
        HibernateUtil.saveDomainObject(employee);
        assertNotNull("Insert test failed", employee.getId());
        cleanUp(employee);
    }

    private Employee createEmployee() {
        Employee employee = new Employee();
        employee.setEmail("employee@test.com");
        employee.setFirstName("Employee");
        employee.setLastName("Name");
        employee.setNickName("Jack");
        employee.setBirthDate(new Today().past());
        employee.setHireDate(new Today().todayDate());
        employee.setHasAccessToCustomer(Boolean.TRUE);
        return employee;
    }

    private void cleanUp(Employee employee) {
        HibernateUtil.removeDomainObject(employee);
    }

    @Test
    public void shouldUpdateExitingEmployee() throws Exception {
        Employee employee = createEmployee();
        HibernateUtil.saveDomainObject(employee);
        Employee retrivedEmployee = new Employee();
        Employee loadedEmployee = (Employee) HibernateUtil.get(retrivedEmployee, employee.getId());
        loadedEmployee.setFirstName("Couger");
        HibernateUtil.updateDomainObject(loadedEmployee);
        Employee reLoadedEmployee = (Employee) HibernateUtil.get(retrivedEmployee, loadedEmployee.getId());
        assertEquals("Employee should not have changed", reLoadedEmployee.getId(), loadedEmployee.getId());
        assertEquals("Employee name should have been couger", "Couger", reLoadedEmployee.getFirstName());
        cleanUp(employee);
    }

    @Test
    public void shouldNotCreatedEmployeeWhenHireDateIsGreaterThanTerminationDate() {
        Employee employee = createEmployee();
        employee.setTerminatedDate(new Today().past());
        try {
            HibernateUtil.saveDomainObject(employee);
            fail("Employee with termination date before hiredate should not be allowed by the database");
        } catch (ConstraintViolationException e) {
            assertTrue(e.getCause().getMessage().contains("CHK_HIRED_BEFORE_TERMINATION"));
            //expected
        }
    }

    @Test
    public void shouldNotDieWhenFindingNonExistantEmployee() throws Exception {
        assertNull("Non Existant Employee test failed", HibernateUtil.load(new Employee(), 11111L));
    }
}
