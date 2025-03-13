/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    public static Connection con;

    public DAO() {
        if (con == null) {
            String dbUrl = "jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=chesstournament;autoReconnect=true&useSSL=false;encrypt=false;trustServerCertificate=false;";
            String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "sa", "123456");
                System.out.println("Ket noi thanh cong");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
