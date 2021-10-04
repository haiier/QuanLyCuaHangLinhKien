/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ctpnDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ctpnDAO {
     ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();
    public ctpnDAO(){
    }
    public ArrayList GetAll() throws SQLException {
        ArrayList dsctpn = new ArrayList<ctpnDTO>();
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
        String sql= "select * from phieunhap";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()){
            ctpnDTO pn = new ctpnDTO();
            pn.setMaphieunhap(rs.getString("id_pn"));
            pn.setMasanpham(rs.getString("id_sp"));
            pn.setSoluong(rs.getInt("ngayLap_pn"));
            pn.setGiasanpham(rs.getDouble("gia_pn"));
            pn.setTongtien(rs.getDouble("subtotal_pn"));
            dsctpn.add(pn);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dsctpn;
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
//                sp.setIdbrand(rs.getString("id_brand"));
//                sp.setSoluongsp(rs.getInt("soluong_sp"));
//                findname.add(sp);
//            }
//        db.CloseConnection();
//        return findname;
//        // từ database -> DTO -> model -> table
//    }
    public String delete(String i){
        String sql = "delete from chitietpn where id_pn='"+i+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String insert(ctpnDTO ctpnDTO){
        String sql = "INSERT INTO chitietpn VALUES ('"+ctpnDTO.getMaphieunhap()+"','"+ctpnDTO.getMasanpham()+"','"+ ctpnDTO.getSoluong()+"','"+ctpnDTO.getGiasanpham()+"','"+ctpnDTO.getTongtien()+"')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String update(ctpnDTO ctpnDTO,String s){
        String sql = "update chitietpn set id_pn ='"+ctpnDTO.getMaphieunhap()+"',id_sp='"+ctpnDTO.getMasanpham()+"',soluong_pn ='"+ctpnDTO.getSoluong()+"',gia_pn ='"+ctpnDTO.getGiasanpham()+"',total_pn ='"+ctpnDTO.getTongtien()+"' where id_sp ="+s;
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
