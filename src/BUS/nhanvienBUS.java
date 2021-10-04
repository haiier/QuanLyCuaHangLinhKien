/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.nhanvienDAO;
import static DAO.nhanvienDAO.writeExcel;
import DTO.nhanvienDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
public class nhanvienBUS {
    public static ArrayList<nhanvienDTO> dsnv;
    public static ArrayList<nhanvienDTO> findname;
    public nhanvienBUS(){}
    public void docDSNV() throws SQLException{
        nhanvienDAO nvDAO = new nhanvienDAO();
        if(dsnv==null){
            dsnv = new ArrayList<nhanvienDTO>();
        }
        dsnv = nvDAO.GetAll();
    }
    
    public void timkiem(String name,String gettype) throws SQLException{
        nhanvienDAO nvDAO = new nhanvienDAO();
        if(findname==null){
            findname = new ArrayList<nhanvienDTO>();
        }
        findname = nvDAO.findnv(name,gettype);
    }
    public boolean delete(String i){
        nhanvienDAO nvDAO = new nhanvienDAO();
        if(nvDAO.delete(i)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(nhanvienDTO nv){
        nhanvienDAO nvDAO = new nhanvienDAO();
        if(nvDAO.insert(nv)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(nhanvienDTO nv,String s){
        nhanvienDAO nvDAO = new nhanvienDAO();
        if(nvDAO.update(nv,s)== "Thành công"){
            return true;
        }else{
            return false;
        }
    }
    //excel
    public void exDSNV() throws SQLException, IOException{
         nhanvienDAO nvDAO = new nhanvienDAO();
//         books = nvDAO.getBooks();;
        if(dsnv==null){
            dsnv = new ArrayList<nhanvienDTO>();
        }
        dsnv = nvDAO.GetAll();
        final String excelFilePath = "C:/demo/gooks.xlsx";
        writeExcel(dsnv, excelFilePath);
     }
}
