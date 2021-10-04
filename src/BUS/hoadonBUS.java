/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.hoadonDAO;
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
public class hoadonBUS {
    public static ArrayList<hoadonDTO> dshd;    
    public hoadonBUS() {
    }
    public void docDSHD(){
        try {
            hoadonDAO hdDAo = new hoadonDAO();
            if(dshd == null){                      
                dshd = new ArrayList<>();
            }
            dshd = hdDAo.docDSHD();
        } catch (SQLException ex) {
            Logger.getLogger(hoadonBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
