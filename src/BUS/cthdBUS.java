/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.cthdDAO;
import DTO.cthdDTO;
import DTO.hoadonDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class cthdBUS {
    public static ArrayList<cthdDTO> dshd;
    public cthdBUS() {
    }
    
    public String addbill(String b,String c,String d, float total) throws SQLException{
       cthdDAO cthdDAO = new cthdDAO();                                                   
        return cthdDAO.addbill(b,c,d,total);
    }
    public void docCTHD(String mahd){
        try {
            cthdDAO ctDAO = new cthdDAO();
            if(dshd == null){
                dshd = new ArrayList<>();
            }
            dshd = ctDAO.docCTHD(mahd);
        } catch (SQLException ex) {
            Logger.getLogger(cthdBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
