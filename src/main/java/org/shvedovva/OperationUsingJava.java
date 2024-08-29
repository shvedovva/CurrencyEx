package org.shvedovva;

import java.sql.*;
import java.util.Scanner;

public class OperationUsingJava {
    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite::resource:CurrencyExchange.db");
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Currencies;");

            System.out.println("ID\t FullName\t\t\t\t Code\t Sign ");
            while (rs.next()) {
                long id = rs.getInt("id");
                String name = rs.getString("fullname");
                String code = rs.getString("code");
                String sign = rs.getString("sign");
                System.out.println(id + "\t " + name + " \t\t\t\t " + code + "\t " + sign);
            }
            rs.close();
            stmt.close();
            conn.commit();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
