/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BrandDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
/**
 *
 * @author Admin
 */
public class BrandDAO {
    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();
    public BrandDAO(){
    }
    public ArrayList GetAll() throws SQLException {
        ArrayList dsbr = new ArrayList<BrandDTO>();
        String sql= "select * from brand";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()){
            BrandDTO br = new BrandDTO();
            br.setTen_brand(rs.getString("ten_brand")+"");
            dsbr.add(br);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dsbr;
    }
    public String delete(String i){
        String sql = "delete from brand where ten_brand='"+i+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String insert(BrandDTO brDTO){
        String sql = "INSERT INTO brand VALUES ('"+brDTO.getTen_brand()+"')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String update(BrandDTO brDTO,String s){
        String sql = "update brand set ten_brand ='"+brDTO.getTen_brand()+"' where ten_brand ='"+s+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
