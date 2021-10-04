/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.khachhangDAO;
import DTO.khachhangDTO;
import DTO.khachhangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
public class khachhangBUS {
    public static ArrayList<khachhangDTO> dskh;
    public static ArrayList<khachhangDTO> findname;
    public khachhangBUS(){}
    public void docDSKH() throws SQLException{
        khachhangDAO khDAO = new khachhangDAO();
        if(dskh==null){
            dskh = new ArrayList<khachhangDTO>();
        }
        dskh = khDAO.GetAll();
    }
    
    public void timkiem(String name) throws SQLException{
        khachhangDAO khDAO = new khachhangDAO();
        if(findname==null){
            findname = new ArrayList<khachhangDTO>();
        }
        findname = khDAO.findkh(name);
    }
    public boolean delete(String i){
        khachhangDAO khDAO = new khachhangDAO();
        if(khDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(khachhangDTO kh){
        khachhangDAO khDAO = new khachhangDAO();
        if(khDAO.insertkh(kh)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(khachhangDTO kh,String s){
        khachhangDAO khDAO = new khachhangDAO();
        if(khDAO.update(kh,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
}
