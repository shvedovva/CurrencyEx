package org.shvedovva.dao;

import org.shvedovva.exceptions.DatabaseException;
import org.shvedovva.model.Currency;
import org.shvedovva.util.DBConnector;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CurrencyDao {
    public Currency findByCode(String code){

        String sql = "SELECT Id, Code, FullName, Sign FROM Currencies WHERE Code = ?";
        try(Connection conn = DBConnector.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setString(1, code);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()){
                Currency result = convertResultSet(rs);
                rs.close();
                return result;
            }
            else return null;

        }
        catch (SQLException e){
            throw new DatabaseException("DB not available");
        }
    }


    public List<Currency> findAll() {
        String sql = "SELECT Id, Code, FullName, Sign FROM Currencies;";

        try (Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            List<Currency> result = new LinkedList<>();
            while (rs.next()) {
                Currency currencyDto = convertResultSet(rs);
                result.add(currencyDto);
            }
            rs.close();
            return result;
        } catch (SQLException e) {
            throw new DatabaseException("Database is unavailable!");
        }
    }

    private Currency convertResultSet(ResultSet rs) throws SQLException {
        return Currency.builder()
                .id(rs.getLong("Id"))
                .code(rs.getString("Code"))
                .fullName(rs.getString("FullName"))
                .sign(rs.getString("Sign")).
                build();
    }

}
