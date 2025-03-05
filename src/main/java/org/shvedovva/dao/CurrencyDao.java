package org.shvedovva.dao;

import org.shvedovva.exceptions.DatabaseException;
import org.shvedovva.model.Currency;
import org.shvedovva.util.DBConnection;
import org.shvedovva.util.DBConnector;
import org.shvedovva.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao implements CrudDAO<Currency, Long> {

    public Currency findById(Long code){
        String sql = "SELECT Id, Code, FullName, Sign FROM Currencies WHERE Code = ?";

        try(Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setString(1, String.valueOf(code));
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
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT Id, Code, FullName, Sign FROM Currencies;";

        try (Connection conn = DatabaseConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Currency currency = new Currency();
                currency.setId(rs.getLong("Id"));
                currency.setCode(rs.getString("Code"));
                currency.setFullName(rs.getString("FullName"));
                currency.setSign(rs.getString("Sign"));
                currencies.add(currency);
            }

            return currencies;
        } catch (SQLException e) {
            throw new DatabaseException("Database is unavailable!");
        }
    }

    @Override
    public void save(Currency item) {
        String sql = "insert into Currencies (Code, FullName, Sign) values (?,?,?)";

        try(Connection conn = DatabaseConnectionManager.getConnection();
        PreparedStatement psmt = conn.prepareStatement(sql)){

        }
        catch (SQLException e){
            throw new DatabaseException("Database is unavailable!");
        }


    }

    @Override
    public void delete(Long id) {
        String sql = "delete from Currencies where id = ? ";

        try (Connection conn = DatabaseConnectionManager.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setLong(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
