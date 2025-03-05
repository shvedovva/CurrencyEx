package org.shvedovva.util;

import org.shvedovva.exceptions.DatabaseException;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_URI = "jdbc:sqlite::resource:CurrencyExchange.db";

    public static DataSource dataSource;

    static{
        try{
            //Class.forName("org.sqlite.JDBC");
            SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
            sqLiteDataSource.setUrl(DB_URI);
            dataSource = sqLiteDataSource;
        }
        catch (Exception ex){
            throw new RuntimeException("Error connect DB", ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

//    public static Connection getConnection(){
//
//
//        Connection connection;
//
//        try {
//            Class.forName("org.sqlite.JDBC");
//            connection = DriverManager.getConnection(DB_URI);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Not found driver");
//        } catch (SQLException e) {
//            throw new DatabaseException("Database connection error");
//        }
//
//        return connection;
//    }
}
