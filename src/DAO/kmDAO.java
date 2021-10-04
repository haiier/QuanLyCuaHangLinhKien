/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.kmDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ad
 */
public class kmDAO {
    ConnectDatabase db = new ConnectDatabase();

    public kmDAO() {
    }
    public ArrayList docDSKM() throws SQLException{
        ArrayList dskm = new ArrayList();
        String sql = "select * from khuyenmai";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()){
            kmDTO kmDTO = new kmDTO();
            kmDTO.setIdkm(rs.getInt("id_km"));
            kmDTO.setTenkm(rs.getString("ten_km"));
            kmDTO.setNgaybd(rs.getString("ngaybd"));
            kmDTO.setNgaykt(rs.getString("ngaykt"));
            kmDTO.setPhantram(rs.getInt("phantram"));
            dskm.add(kmDTO);
        }
        return dskm;
    }
    public String insert(kmDTO kmDTO){
        String sql = "insert into khuyenmai (ten_km,ngaybd,ngaykt,phantram) values ('"+kmDTO.getTenkm()+"','"+kmDTO.getNgaybd()+"','"+kmDTO.getNgaykt()+"','"+kmDTO.getPhantram()+ "')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        return rs;
    }
    public String delete(String idkm) throws SQLException{
        String sql1 = "select id_hd from hoadon where id_hd ='"+idkm+"'";
        ResultSet getidkm = db.ExcuteSELECT(sql1);
        while(getidkm.next()){
            return "Mã Đã Được Sử Dụng";
        }
        String sql = "delete from khuyenmai where id_km ='"+idkm+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        return rs;
    }
}
