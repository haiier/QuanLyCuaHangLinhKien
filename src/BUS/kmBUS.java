/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.kmDAO;
import DTO.kmDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ad
 */
public class kmBUS {
    public static ArrayList<kmDTO> dskm;

    public kmBUS() {
    }
    public void docDSKM(){
        try {
            kmDAO kmDAO = new kmDAO();
            if(dskm == null){            
                dskm = new ArrayList<>();
            }
            dskm = kmDAO.docDSKM();
        } catch (SQLException ex) {
            Logger.getLogger(kmBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean add(kmDTO kmDTO){
        kmDAO kmDAO = new kmDAO();
        if(kmDAO.insert(kmDTO) == "Thành công"){
            return true;
        }
        return false;
    }
    public String delete(String idkm) throws SQLException{
        kmDAO kmDAO = new kmDAO();            
        return kmDAO.delete(idkm);
    }
}
