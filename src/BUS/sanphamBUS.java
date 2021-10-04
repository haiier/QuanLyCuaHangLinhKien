/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.sanphamDAO;
import DTO.sanphamDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
public class sanphamBUS {
    public static ArrayList<sanphamDTO> dssp;
    public static ArrayList<sanphamDTO> findname;
    public sanphamBUS(){}
    public void docDSSP() throws SQLException{
        sanphamDAO spDAO = new sanphamDAO();
        if(dssp==null){
            dssp = new ArrayList<sanphamDTO>();
        }
        dssp = spDAO.GetAll();
    }
    
//    public void timkiem(String name) throws SQLException{
//        sanphamDAO spDAO = new sanphamDAO();
//        if(findname==null){
//            findname = new ArrayList<sanphamDTO>();
//        }
//        findname = spDAO.findsp(name);
//    }
    public boolean delete(String i){
        sanphamDAO spDAO = new sanphamDAO();
        if(spDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(sanphamDTO sp){
        sanphamDAO spDAO = new sanphamDAO();
        if(spDAO.insert(sp)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(sanphamDTO sp,String s){
        sanphamDAO spDAO = new sanphamDAO();
        if(spDAO.update(sp,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
}
