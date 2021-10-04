/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.nhanvienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class LoginDAO {
    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();

    public LoginDAO() {
    }
    public String getLogin(String user,String password){
        String a = "Thành Công";
        String b = "Không Thành Công";
        try {            
            String sql= "select * from nhanvien where user ='"+user+"'and password_nv ='"+password+"'";
            ResultSet rs = db.ExcuteSELECT(sql);
            while(rs.next()){
                nhanvienDTO nvDTO = new nhanvienDTO();
                nvDTO.setIdnv(rs.getInt("id_nv"));
                nvDTO.setUser(rs.getString("user"));
                nvDTO.setPasswordnv(rs.getString("password_nv"));                
                nvDTO.setPhonenv(rs.getString("phone_nv"));
                nvDTO.setAddressnv(rs.getString("address_nv"));
                nvDTO.setLuongnv(rs.getFloat("luong_nv"));
                nvDTO.setChucvu(rs.getString("chucvu_nv"));
                LoginPattern.getInstance().setUser(nvDTO);
                return a;                
            }            
            db.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}

