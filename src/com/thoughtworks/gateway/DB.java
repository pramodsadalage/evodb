package com.thoughtworks.gateway;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
    public static void cleanup(Statement stmt) {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }

    public static void HandleDBException(SQLException e) throws SQLException {
        System.out.println("Database Error Message " + e.getMessage());
        throw e;
    }

    public static PreparedStatement prepare(String sqlString) throws SQLException {
        return Persistence.INSTANCE.connection.prepareStatement(sqlString);
    }
}
