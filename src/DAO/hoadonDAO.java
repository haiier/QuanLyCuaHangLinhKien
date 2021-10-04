/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.hoadonDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author ad
 */
public class hoadonDAO {
    ConnectDatabase db = new ConnectDatabase();

    public hoadonDAO() {
    }
    public ArrayList docDSHD() throws SQLException{
        ArrayList<hoadonDTO> dshd = new ArrayList<>();
        String sql = "select * from hoadon";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()) {
            hoadonDTO hdDTO = new hoadonDTO();
            hdDTO.setIdhd(rs.getInt("id_hd"));
            hdDTO.setIdnv(rs.getInt("id_nv"));
            hdDTO.setIdkh(rs.getInt("id_kh"));
            hdDTO.setIdkm(rs.getInt("id_km"));
            hdDTO.setTotal(rs.getFloat("total_hd"));
            hdDTO.setCreatedat(rs.getDate("created_at"));
            dshd.add(hdDTO);
        }
        return dshd;
    }
}
