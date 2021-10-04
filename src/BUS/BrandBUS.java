/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;


import DAO.BrandDAO;
import DTO.BrandDTO;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class BrandBUS {
    public static ArrayList<BrandDTO> dsbr;
    public static ArrayList<BrandDTO> findname;
    public BrandBUS(){}
    public void docDSBR() throws SQLException{
        BrandDAO brDAO = new BrandDAO();
        if(dsbr==null){
            dsbr = new ArrayList<BrandDTO>();
        }
        dsbr = brDAO.GetAll();
    }
    
    public boolean delete(String i){
        BrandDAO brDAO = new BrandDAO();
        if(brDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(BrandDTO br){
        BrandDAO brDAO = new BrandDAO();
        if(brDAO.insert(br)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(BrandDTO br,String s){
        BrandDAO brDAO = new BrandDAO();
        if(brDAO.update(br,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    
}
