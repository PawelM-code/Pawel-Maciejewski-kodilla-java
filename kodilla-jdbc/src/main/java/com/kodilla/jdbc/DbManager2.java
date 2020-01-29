package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager2 {
    private Connection conn;
    private static DbManager2 dbManagerInstance;

    private DbManager2() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_db_advance?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }

    public static DbManager2 getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager2();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}
