/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.phieunhapDAO;
import DTO.phieunhapDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class phieunhapBUS {
    public static ArrayList<phieunhapDTO> dspn;
    public static ArrayList<phieunhapDTO> findname;
    public phieunhapBUS(){}
    public void docDSPN() throws SQLException{
        phieunhapDAO pnDAO = new phieunhapDAO();
        if(dspn==null){
            dspn = new ArrayList<phieunhapDTO>();
        }
        dspn = pnDAO.GetAll();
    }
    
//    public void timkiem(String name) throws SQLException{
//        phieunhapDAO pnDAO = new phieunhapDAO();
//        if(findname==null){
//            findname = new ArrayList<phieunhapDTO>();
//        }
//        findname = pnDAO.findpn(name);
//    }
    public boolean delete(String i){
        phieunhapDAO pnDAO = new phieunhapDAO();
        if(pnDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(phieunhapDTO pn){
        phieunhapDAO pnDAO = new phieunhapDAO();
        if(pnDAO.insert(pn)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(phieunhapDTO pn,String s){
        phieunhapDAO pnDAO = new phieunhapDAO();
        if(pnDAO.update(pn,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
}
