/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.sanphamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author ad
 */
public class sanphamDAO {

    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();

    public sanphamDAO() {
    }

    public ArrayList GetAll() throws SQLException {
        ArrayList dssp = new ArrayList<sanphamDTO>();
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
        String sql = "SELECT sanpham.hinhanh_sp, sanpham.id_sp, sanpham.ten_sp, sanpham.soluong_sp,sanpham.id_brand ,brand.ten_brand FROM brand,sanpham WHERE brand.id_brand = sanpham.id_brand";
        ResultSet rs = db.ExcuteSELECT(sql);
        while (rs.next()) {
            sanphamDTO sp = new sanphamDTO();
            sp.setHinhanhsp(rs.getString("hinhanh_sp"));
            sp.setTensp(rs.getString("ten_sp") + "");
            sp.setIdsp(rs.getInt("id_sp"));            
            sp.setSoluongsp(rs.getInt("soluong_sp"));
            sp.setTenbrand(rs.getString("ten_brand"));
            sp.setIdbrand(rs.getInt("id_brand"));
            dssp.add(sp);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dssp;
    }
//    public ArrayList findsp(String name) throws SQLException{
//        ArrayList findname = new ArrayList<sanphamDTO>();
//            String sql="";
//            
//            boolean isNum = Pattern.matches("^[0-9]+$", name);
//            
//            
//            if(isNum){
//                sql = "select * from sanpham where id_sp='"+name+"'";
//            }
//            else{
//                sql = "select * from sanpham where ten_sp like '%"+name+"%'";
//            }
//
//            rs = db.ExcuteSELECT(sql);
//            while(rs.next()){
//                sanphamDTO sp = new sanphamDTO();
//                sp.setTensp(rs.getString("ten_sp")+"");            
//                sp.setIdsp(rs.getInt("id_sp"));
//                sp.setGiasp(rs.getFloat("gia_sp"));
//                sp.setTenbrand(rs.getString("id_brand"));
//                sp.setSoluongsp(rs.getInt("soluong_sp"));
//                findname.add(sp);
//            }
//        db.CloseConnection();
//        return findname;
//        // từ database -> DTO -> model -> table
//    }

    public String delete(String i) {
       
        String sql = "delete from sanpham where id_sp='" + i + "'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }

    public String insert(sanphamDTO spDTO) {
        String sql = "INSERT INTO sanpham VALUES ('"+ spDTO.getIdsp() + "','" + spDTO.getTensp() + "','" + spDTO.getHinhanhsp() + "','" + spDTO.getSoluongsp() + "','" + spDTO.getLoaisp() + "',(SELECT brand.id_brand FROM brand WHERE brand.ten_brand='"+spDTO.getTenbrand()+"'))";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }

    public String update(sanphamDTO spDTO, String s) {
        String sql = "update sanpham set id_sp ='" + spDTO.getIdsp() + "',ten_sp ='" + spDTO.getTensp() + "',hinhanh_sp='" + spDTO.getHinhanhsp() + "',soluong_sp ='" + spDTO.getSoluongsp() + "',id_brand=(SELECT brand.id_brand FROM brand WHERE brand.ten_brand='"+spDTO.getTenbrand()+"') where id_sp =" + s;
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
////UPDATE `sanpham` SET `id_sp`=8,`ten_sp`="ga chien",`hinhanh_sp`="",`gia_sp`=10000,`soluong_sp`=20,`loai_sp`="",`id_brand`= (SELECT brand.id_brand 
//                                                                                                                            FROM brand
//                                                                                                                            WHERE brand.ten_brand = "ASUS") WHERE id_sp = 5
//INSERT INTO `sanpham`(`id_sp`, `ten_sp`, `hinhanh_sp`, `gia_sp`, `soluong_sp`, `loai_sp`, `id_brand`) 
//VALUES (11,'chien qua','',23123123,12,'',
//        (SELECT brand.id_brand 
//         FROM brand 
//         WHERE brand.ten_brand = 'MACBOOK'))