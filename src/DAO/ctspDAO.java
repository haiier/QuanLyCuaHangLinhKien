/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ctspDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
public class ctspDAO {

    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();

    public ctspDAO() {
    }

    public ArrayList GetAll() throws SQLException {
        ArrayList dsctsp = new ArrayList<ctspDTO>();
//        try{
//            conn = getConnect();
//            String qry= "select * from sinhvien";
//            st = conn.createStatement();
//            rs = st.executeQuery(qry);
//            while(rs.next()){
//                SinhVienDTO sv = new SinhVienDTO();
//                sv.maSV = rs.getString(1);
//                sv.Ho = rs.getString(2);
//                sv.Ten =rs.getString(3);
//                dssv.add(sv);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin");
//        }
        String sql = "select * from ctsp";
        ResultSet rs = db.ExcuteSELECT(sql);
        while (rs.next()) {
            ctspDTO sp = new ctspDTO();
            sp.setIdsp(rs.getInt("id_sp"));
            sp.setCpu(rs.getString("cpu"));
            sp.setDisk(rs.getInt("disk"));
            sp.setRam(rs.getInt("ram"));
            sp.setGia(rs.getDouble("gia"));
            dsctsp.add(sp);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dsctsp;
    }
//    public ArrayList findsp(String name) throws SQLException{
//        ArrayList findname = new ArrayList<ctspDTO>();
//            String sql="";
//            
//            boolean isNum = Pattern.matches("^[0-9]+$", name);
//            
//            
//            if(isNum){
//                sql = "select * from ctsp where id_sp='"+name+"'";
//            }
//            else{
//                sql = "select * from ctsp where ten_sp like '%"+name+"%'";
//            }
//
//            rs = db.ExcuteSELECT(sql);
//            while(rs.next()){
//                ctspDTO sp = new ctspDTO();
//                sp.setTensp(rs.getString("ten_sp")+"");            
//                sp.setIdsp(rs.getInt("id_sp"));
//                sp.setGiasp(rs.getFloat("gia_sp"));
//                sp.setIdbrand(rs.getString("id_brand"));
//                sp.setSoluongsp(rs.getInt("soluong_sp"));
//                findname.add(sp);
//            }
//        db.CloseConnection();
//        return findname;
//        // từ database -> DTO -> model -> table
//    }

    public String delete(String i) {
        String sql = "delete from ctsp where id_sp='" + i + "'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }

    public String insert(ctspDTO spDTO) throws SQLException {
        String sql = "INSERT INTO ctsp (id_sp,cpu,ram,disk,gia) VALUES ('" + spDTO.getIdsp() + "','" + spDTO.getCpu() + "','" + spDTO.getRam() + "','" + spDTO.getDisk() + "','" + spDTO.getGia() + "')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;

    }

    public String update(ctspDTO spDTO, String s) {
        String sql = "update ctsp set id_sp ='" + spDTO.getIdsp() + "',cpu ='" + spDTO.getCpu() + "',ram ='" + spDTO.getRam() + "',disk ='" + spDTO.getDisk() + "',gia ='" + spDTO.getGia() + "' where id_sp =" + s;
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
