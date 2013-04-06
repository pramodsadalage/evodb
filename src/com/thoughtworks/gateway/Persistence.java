package com.thoughtworks.gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Persistence {

    public Connection connection;
    public static final Persistence INSTANCE = new Persistence();

    private Persistence() {
        try {
            Class.forName(System.getProperty("db.drivername"));
            String url = System.getProperty("db.url");
            connection = DriverManager.getConnection(url, System.getProperty("db.user"), System.getProperty("db.password"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void close() throws java.sql.SQLException {
        connection.commit();
    }

    public void pingDatabase() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeQuery("select 0 from dual");
        stmt.close();
    }
}