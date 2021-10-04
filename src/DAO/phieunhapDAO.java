/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.phieunhapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class phieunhapDAO {
    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();
    public phieunhapDAO(){
    }
    public ArrayList GetAll() throws SQLException {
        ArrayList dspn = new ArrayList<phieunhapDTO>();
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
            phieunhapDTO pn = new phieunhapDTO();
            pn.setMaphieunhap(rs.getString("id_pn"));
            pn.setManhanvien(rs.getString("id_nv"));
            pn.setNgaylap(rs.getDate("ngayLap_pn"));
            pn.setNhacungcap(rs.getString("id_ncc"));
            pn.setTongtien(rs.getDouble("total_pn"));
            dspn.add(pn);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dspn;
    }
//    public ArrayList findsp(String name) throws SQLException{
//        ArrayList findname = new ArrayList<phieunhapDTO>();
//            String sql="";
//            
//            boolean isNum = Pattern.matches("^[0-9]+$", name);
//            
//            
//            if(isNum){
//                sql = "select * from phieunhap where id_sp='"+name+"'";
//            }
//            else{
//                sql = "select * from phieunhap where ten_sp like '%"+name+"%'";
//            }
//
//            rs = db.ExcuteSELECT(sql);
//            while(rs.next()){
//                phieunhapDTO sp = new phieunhapDTO();
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
        String sql = "delete from phieunhap where id_pn='"+i+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String insert(phieunhapDTO pnDTO){
        String sql = "INSERT INTO phieunhap VALUES ('"+pnDTO.getMaphieunhap()+"','"+pnDTO.getManhanvien()+"','"+ pnDTO.getNgaylap()+"','"+pnDTO.getNhacungcap()+"','"+pnDTO.getTongtien()+"')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String update(phieunhapDTO pnDTO,String s){
        String sql = "update phieunhap set id_pn ='"+pnDTO.getMaphieunhap()+"',id_nv='"+pnDTO.getManhanvien()+"',ngayLap_pn ='"+pnDTO.getNgaylap()+"',id_ncc ='"+pnDTO.getNhacungcap()+"',total_pn ='"+pnDTO.getTongtien()+"' where id_sp ="+s;
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
