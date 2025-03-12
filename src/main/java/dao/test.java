/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        var server = "ADMIN\\SQLEXPRESS";
        var user = "sa";
        var password = "123456";
        var db = "chesstournament";
        var port = 1434;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setEncrypt(false);
        ds.setTrustServerCertificate(false);
        try (Connection con = ds.getConnection()) {
            System.out.println("Successfully connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
