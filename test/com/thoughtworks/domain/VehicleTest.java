package com.thoughtworks.domain;

import com.thoughtworks.util.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class VehicleTest {

    @Test
    public void shouldSaveVehicleWithModelAndMake() throws Exception {
        Vehicle vehicle = createVehicle("VW", "Polo", (long) 10, "45738-OIRYUOEIWR-RTYE", "2008");
        try {
            HibernateUtil.saveDomainObject(vehicle);
        } catch (Exception e) {
            fail("Vehicle should have been saved");
        }
        assertEquals("Polo", vehicle.getModel());
        assertEquals("VW", vehicle.getMake());
        cleanUp(vehicle);
    }

    @Test
    public void shouldNotAllowDuplicateVIN() throws Exception {
        Vehicle vehicle = createVehicle("VW", "Polo", (long) 10, "7738-OIRYUOEIWR-RTYE", "2008");
        try {
            HibernateUtil.saveDomainObject(vehicle);
        } catch (Exception e) {
            fail("Vehicle should have been saved");
        }
        Vehicle duplicateVIN = createVehicle("Ford", "Focus", (long) 12, "7738-OIRYUOEIWR-RTYE", "2010");
        try {
            HibernateUtil.saveDomainObject(duplicateVIN);
            fail("Should not have saved duplicate VIN");
        } catch (Exception e) {
            //expected
            assertTrue(e.getCause().getMessage().contains("UIDX_VEHICLE_VIN"));
        } finally {
            cleanUp(vehicle);
        }
    }

    @Test
    public void shouldAllowModelYear2010() throws Exception {
        Vehicle vehicle = createVehicle("Toyota", "Sienna", (long) 21, "7738-JHYTUP-RTYE", "2010");
        try {
            HibernateUtil.saveDomainObject(vehicle);
        } catch (Exception e) {
            fail("Vehicle should have been saved");
        }
        cleanUp(vehicle);
    }

    @Test
    public void shouldNotAllowModelYearBefore2005() throws Exception {
        Vehicle vehicle = createVehicle("Ford", "Focus", (long) 12, "7738-OIRYUOEIWR-RTYE", "2004");
        try {
            HibernateUtil.saveDomainObject(vehicle);
            fail("Should not have saved year 2004");
        } catch (Exception e) {
            //expected
            assertTrue(e.getCause().getMessage().contains("CHK_VEHICLE_YEAR_GT_2005"));
        } finally {
            cleanUp(vehicle);
        }
    }

    @Test
    public void shouldNotAllowNullModelName() throws Exception {
        Vehicle vehicle = createVehicle("Ford", null, (long) 12, "7738-OIRYUOEIWR-RTYE", "2004");
        try {
            HibernateUtil.saveDomainObject(vehicle);
            fail("Should not have saved null model");
        } catch (Exception e) {
            //expected
            assertTrue(e.getCause().getMessage().contains("ORA-01400"));
        } finally {
            cleanUp(vehicle);
        }
    }


    @Test
    public void shouldNotAllowNullMake() throws Exception {
        Vehicle vehicle = createVehicle(null, "Focus", (long) 12, "7738-OIRYUOEIWR-RTYE", "2004");
        try {
            HibernateUtil.saveDomainObject(vehicle);
            fail("Should not have saved null make");
        } catch (Exception e) {
            //expected
            assertTrue(e.getCause().getMessage().contains("ORA-01400"));
        } finally {
            cleanUp(vehicle);
        }
    }

    @Test
    public void shouldSaveMilesDriven() throws Exception {
        Vehicle vehicle = createVehicle("Ford", "Focus", (long) 12, "WERTYU--OIRYUOEIWR-RTYE", "2012");
        Vehicle vehicleFromDB = new Vehicle();
        try {
            HibernateUtil.saveDomainObject(vehicle);
            vehicleFromDB = (Vehicle) HibernateUtil.load(vehicleFromDB, vehicle.getId());
            assertEquals(vehicle.getMiles(), vehicleFromDB.getMiles());
        } catch (Exception e) {
            //expected
            fail("Vehicle should have been saved");
        }
        cleanUp(vehicle);
    }

    private Vehicle createVehicle(String make, String name, Long miles, String vin, String year) {
        Vehicle vehicle;
        vehicle = new Vehicle();
        vehicle.setMake(make);
        vehicle.setModel(name);
        vehicle.setMiles(miles);
        vehicle.setVin(vin);
        vehicle.setYear(year);
        return vehicle;
    }

    private void cleanUp(Vehicle vehicle) {
        HibernateUtil.removeDomainObject(vehicle);
    }
}
