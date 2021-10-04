/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class ConnectDatabase {

    public Connection conn = null;

    public ConnectDatabase() {
    }

    public Connection getConnect() {
        try {
            Connection connection = null;
            String dbURL = "jdbc:mysql://localhost:3306/linhkienmaytinh";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(dbURL, username, password);

            return connection;

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return null;
        }

    }

    public String ExcuteINSERTDELETEUPDATE(String sql) {
        try {
            conn = getConnect();
            Statement statement = conn.createStatement();

            int n = statement.executeUpdate(sql);
            if (n >= 1) {
                return "Thành công";
            } else {
                return "Không thành công";
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return "Lỗi thực thi";
        }
    }

    public void CloseConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ExcuteSELECT(String sql) {

        try {
            conn = getConnect();
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                String manv = rs.getString("MANV");
//                String hoten = rs.getString("TENNV");
//                System.out.println(manv + " " + hoten);
//
//            }

            return rs;

        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return null;
        }

    }

    public void ExcuteINSERT_AUTO_ICRE(String sql) {
        try {
            conn = getConnect();
            Statement statement = conn.createStatement();

            int n = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (n > 0) {
                System.out.println(" Thêm thành công !!!");
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int maDanhMuc = rs.getInt(1);
                    System.out.println("Mã phong vừa thêm: " + maDanhMuc);
                }
            } else {
                System.out.println("Lỗi !!!");
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

    }

}
