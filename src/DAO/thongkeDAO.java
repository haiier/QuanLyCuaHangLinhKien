package DAO;

import DAO.ConnectDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.hoadonDTO;
import DTO.thongkeDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class thongkeDAO {

    ConnectDatabase db = new ConnectDatabase();
    public thongkeDAO() {

    }


      public ArrayList docDSHD(Date d1, Date d2) throws SQLException{
        ArrayList<thongkeDTO> dshd = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String d3 = df.format(d1);
        
        String d4 = df.format(d2);
        String sql = "select * from hoadon where created_at >= '"+d3+"' AND created_at <= '"+d4+"' ";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()) {
            thongkeDTO hdDTO = new thongkeDTO();
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
