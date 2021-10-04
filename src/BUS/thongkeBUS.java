/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.hoadonBUS.dshd;
import DAO.hoadonDAO;
import DAO.thongkeDAO;
import DTO.hoadonDTO;
import DTO.thongkeDTO;
import java.awt.Frame;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class thongkeBUS {

    public static ArrayList<thongkeDTO> dshd;

    public void docDSHD(Date d1, Date d2) {
        try {
            thongkeDAO hdDAo = new thongkeDAO();
            if (dshd == null) {
                dshd = new ArrayList<>();
            }
//            if (d1.compareTo(d2) > 0) {
//                return;
//            }
            dshd = hdDAo.docDSHD(d1, d2);
        } catch (SQLException ex) {
            Logger.getLogger(hoadonBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
