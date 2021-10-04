/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ctspDAO;
import DTO.ctspDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class ctspBUS {
    public static ArrayList<ctspDTO> dsctsp;
    public static ArrayList<ctspDTO> findname;
    public static ArrayList<ctspDTO> bill;
    public ctspBUS(){}
    public void docDSCTSP() throws SQLException{
        ctspDAO ctspDAO = new ctspDAO();
        if(dsctsp==null){
            dsctsp = new ArrayList<ctspDTO>();
        }
        dsctsp = ctspDAO.GetAll();
    }
    
//    public void timkiem(String name) throws SQLException{
//        ctspDAO ctspDAO = new ctspDAO();
//        if(findname==null){
//            findname = new ArrayList<ctspDTO>();
//        }
//        findname = ctspDAO.findctsp(name);
//    }
    public boolean delete(String i){
        ctspDAO ctspDAO = new ctspDAO();
        if(ctspDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(ctspDTO ctsp){
        try {
            ctspDAO ctspDAO = new ctspDAO();
            if(ctspDAO.insert(ctsp)== "Thành công"){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ctspBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean update(ctspDTO ctsp,String s){
        ctspDAO ctspDAO = new ctspDAO();
        if(ctspDAO.update(ctsp,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
}
