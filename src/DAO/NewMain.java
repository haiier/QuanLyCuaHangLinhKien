/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ad
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        nhanvienDAO nvdao = new nhanvienDAO();
        String sql = "select * from brand";
        ResultSet rs = null;
        rs = (ResultSet) nvdao.GetAll();
        while(rs.next()){
            System.out.println(rs.getString("id_brand"));
        }
        
    }
    
}
