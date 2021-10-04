/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS.ctspBUS;
import DTO.cthdDTO;
import DTO.ctspDTO;
import DTO.hoadonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ad
 */
public class cthdDAO {
    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();
    public cthdDAO(){
    }
    public String addbill(String manv,String makh,String makm,float total) throws SQLException{
        int getrow = 0;
        String rs2 = "";
        ctspBUS ctspBUS = new ctspBUS();
        String sql0 = "select * from hoadon";
        ResultSet rs0 = db.ExcuteSELECT(sql0);  
        while(rs0.next()){
            if(rs0.isLast()){
                getrow = rs0.getRow() +1;
            }
        }
        String getkm = "select phantram,ngaybd,ngaykt from khuyenmai where id_km ='"+makm+"'";
        ResultSet rs3 = db.ExcuteSELECT(getkm);
        int phantramkm = 0;
        LocalDate ngaybd = null;
        LocalDate ngaykt = null;        
//        LocalDate ngaybd = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        while(rs3.next()){
            phantramkm = rs3.getInt("phantram");
            ngaybd = rs3.getDate("ngaybd").toLocalDate();
            ngaykt = rs3.getDate("ngaykt").toLocalDate();               
        }  
        if(ngaybd != null && ngaykt != null){
            int bd = ngaybd.compareTo(java.time.LocalDate.now());
            int kt = ngaykt.compareTo(java.time.LocalDate.now());
            if( bd <= 0 &&  kt >=0){
                String sql1 = "insert into hoadon (id_hd,id_nv,id_kh,id_km,total_hd) values ('" +getrow+ "','" + manv + "','" + makh + "','" + makm + "','" +  total*(100-phantramkm)/100 + "')";
                String rs1 = db.ExcuteINSERTDELETEUPDATE(sql1);
                if(rs1 == "Thành công"){
                    for(ctspDTO ctDTO: ctspBUS.bill){
                        String sql2 = "insert into chitiethd (id_hd,id_sp,soluong,gia,subtotal) values ('"+getrow+"','" + ctDTO.getIdsp() + "','" + ctDTO.getSoluong() + "','" + ctDTO.getGia() + "','" + ctDTO.getSoluong()*ctDTO.getGia() + "')";
                        rs2 = db.ExcuteINSERTDELETEUPDATE(sql2);                
                    }
                    if(rs2 == "Thành công"){
                            return rs2;
                        }else{
                            String notice = "Thất bại";
                            return notice;
                    }
                }
                String notice = "Thất bại";
                db.CloseConnection();
                return notice;        
            }else{
                db.CloseConnection();
                return "Không Đúng Ngày";
            }
        }else{
            db.CloseConnection();
            return "Không Tồn Tại";
        }   
    }
    public ArrayList docCTHD(String mahd) throws SQLException{
        ArrayList<cthdDTO> dshd = new ArrayList<>();
        String sql = "select * from chitiethd where id_hd ='"+mahd+"'";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()) {
            cthdDTO hdDTO = new cthdDTO();
            hdDTO.setIdsp(rs.getInt("id_sp"));
            hdDTO.setSoluong(rs.getInt("soluong"));
            hdDTO.setGia(rs.getDouble("gia"));
            hdDTO.setSubtotal(rs.getDouble("subtotal"));            
            dshd.add(hdDTO);
        }
        return dshd;
    }
}
