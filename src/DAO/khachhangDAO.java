/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.khachhangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author ad
 */
public class khachhangDAO {
    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();
    public khachhangDAO(){
    }
    public ArrayList GetAll() throws SQLException {
        ArrayList dskh = new ArrayList<khachhangDTO>();
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
        String sql= "select * from khachhang";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()){
            khachhangDTO kh = new khachhangDTO();
            kh.setTenkh(rs.getString("ten_kh")+"");
            kh.setHokh(rs.getString("ho_kh"));
            kh.setIdkh(rs.getInt("id_kh"));
            kh.setPhonekh(rs.getString("phone_kh"));
            kh.setAddresskh(rs.getString("address_kh"));            
            kh.setGender(rs.getString("gender"));            
            dskh.add(kh);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dskh;
    }
    public ArrayList findkh(String name) throws SQLException{
        ArrayList findname = new ArrayList<khachhangDTO>();
            String sql="";
            
            boolean isNum = Pattern.matches("^[0-9]+$", name);
            
            
            if(isNum){
                sql = "select * from khachhang where id_kh='"+name+"'";
            }
            else{
                sql = "select * from khachhang where ten_kh like '%"+name+"%'";
            }

            rs = db.ExcuteSELECT(sql);
            while(rs.next()){
                khachhangDTO kh = new khachhangDTO();
                kh.setTenkh(rs.getString("ten_kh")+"");
                kh.setHokh(rs.getString("ho_kh"));
                kh.setIdkh(rs.getInt("id_kh"));
                kh.setPhonekh(rs.getString("phone_kh"));
                kh.setAddresskh(rs.getString("address_kh"));            
                kh.setGender(rs.getString("gender"));                        
                findname.add(kh);
            }
        db.CloseConnection();
        return findname;
        // từ database -> DTO -> model -> table
    }
    public String delete(String i){
        String sql = "delete from khachhang where id_kh='"+i+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String insertkh(khachhangDTO khDTO){
        //nếu bị lỗi không đúng thứ tự khi truy vấn chuỗi sql thì nên insert trực tiếp trên mysql trước
        String sql = "insert into khachhang values ('"+khDTO.getIdkh()+"','"+khDTO.getHokh()+"','"+khDTO.getTenkh()+"','"+khDTO.getPhonekh()+"','"+khDTO.getAddresskh()+"','"+khDTO.getGender()+"')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String update(khachhangDTO khDTO,String s){
        String sql = "update khachhang set ten_kh ='"+khDTO.getTenkh()+"',ho_kh ='"+khDTO.getHokh()+"',id_kh ='"+khDTO.getIdkh()+"',phone_kh ='"+khDTO.getPhonekh()+"',address_kh ='"+khDTO.getAddresskh()+"',gender ='"+khDTO.getGender()+"' where id_kh ="+s;
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
