package org.shvedovva.util;

import org.shvedovva.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection(){
        final String DB_URI = "jdbc:sqlite::resource:CurrencyExchange.db";

        Connection connection;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URI);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found driver");
        } catch (SQLException e) {
            throw new DatabaseException("Database connection error");
        }

        return connection;

    }
}
