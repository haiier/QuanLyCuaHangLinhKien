/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ctpnDAO;
import DTO.ctpnDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ctpnBUS {
    public static ArrayList<ctpnDTO> dsctpn;
    
    
    public ctpnBUS(){}
    public void docDSctPN() throws SQLException{
        ctpnDAO pnDAO = new ctpnDAO();
        if(dsctpn==null){
            dsctpn = new ArrayList<ctpnDTO>();
        }
        dsctpn = pnDAO.GetAll();
    }
    
//    public void timkiem(String name) throws SQLException{
//        ctpnDAO pnDAO = new ctpnDAO();
//        if(findname==null){
//            findname = new ArrayList<ctpnDTO>();
//        }
//        findname = pnDAO.findpn(name);
//    }
    public boolean delete(String i){
        ctpnDAO pnDAO = new ctpnDAO();
        if(pnDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(ctpnDTO pn){
        ctpnDAO pnDAO = new ctpnDAO();
        if(pnDAO.insert(pn)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(ctpnDTO pn,String s){
        ctpnDAO pnDAO = new ctpnDAO();
        if(pnDAO.update(pn,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
}
