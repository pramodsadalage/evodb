package com.thoughtworks.gateway;

import org.junit.Test;

public class PersistenceTest {


    @Test
    public void shouldConnectToDatabasePersistence() throws Exception {
        Persistence.INSTANCE.pingDatabase();
        Persistence.INSTANCE.close();
    }
}