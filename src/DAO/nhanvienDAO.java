/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.nhanvienDTO;
import java.awt.Frame;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

//import excel
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;

/**
 *
 * @author ad
 */
public class nhanvienDAO {
    public static final int COLUMN_INDEX_TEN         = 0;
    public static final int COLUMN_INDEX_HO         = 1;
    public static final int COLUMN_INDEX_ID      = 2;
    public static final int COLUMN_INDEX_PHONE   = 3;
    public static final int COLUMN_INDEX_ADDRESS      = 4;
    public static final int COLUMN_INDEX_Luong      = 5;
    public static final int COLUMN_INDEX_Gioitinh      = 4;
    public static CellStyle cellStyleFormatNumber = null;
    ResultSet rs = null;
    ConnectDatabase db = new ConnectDatabase();
    public nhanvienDAO(){
    }
    //code excel
    public static void writeExcel(List<nhanvienDTO> books, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet("Books"); // Create sheet with sheet name
 
        int rowIndex = 0;
         
        // Write header
        writeHeader(sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (nhanvienDTO nv : books) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeNV(nv, row);
            rowIndex++;
        }
         
        // Write footer
        writeFooter(sheet, rowIndex);
 
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        JOptionPane.showMessageDialog(new Frame(),"Done!");
    }
 
    // Create dummy data
//    public static List<nhanvienDTO> getBooks() {
//        List<nhanvienDTO> listBook = new ArrayList<>();
//        nhanvienDTO book;
//        for (double i = 1; i <= 5; i++) {
//            book = new nhanvienDTO("nam", "Book ", (int) i, "nam","nam");
//            listBook.add(book);
//        }
//        return listBook;
//    }
    // Create workbook
    public static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Write header with format
    public static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_TEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên NV");
 
        cell = row.createCell(COLUMN_INDEX_HO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("HỌ NV");
 
        cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ID NV");
 
        cell = row.createCell(COLUMN_INDEX_PHONE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("PHONE");
 
        cell = row.createCell(COLUMN_INDEX_ADDRESS);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("ADDRESS");
        
        cell = row.createCell(COLUMN_INDEX_Luong);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("LUONG");
        
        cell = row.createCell(COLUMN_INDEX_Gioitinh);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("GIOITINH");
    }
 
    // Write data
    public static void writeNV(nhanvienDTO book, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
         
        Cell cell = row.createCell(COLUMN_INDEX_TEN);
        cell.setCellValue(book.getTennv());
 
        cell = row.createCell(COLUMN_INDEX_HO);
        cell.setCellValue(book.getHonv());
 
        cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(book.getIdnv());
 
        cell = row.createCell(COLUMN_INDEX_PHONE);
        cell.setCellValue(book.getPhonenv());
        cell.setCellStyle(cellStyleFormatNumber);
        
        cell = row.createCell(COLUMN_INDEX_Luong);
        cell.setCellValue(book.getLuongnv());
        cell.setCellStyle(cellStyleFormatNumber);
        
        cell = row.createCell(COLUMN_INDEX_Gioitinh);
        cell.setCellValue(book.getGender());
         
        // Create cell formula
        // totalMoney = price * quantity
//        cell = row.createCell(COLUMN_INDEX_ADDRESS, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_ID);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_ADDRESS);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
    }
 
    // Create CellStyle for header
    public static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
    // Write footer
    public static void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
//        Row row = sheet.createRow(rowIndex);
//        Cell cell = row.createCell(COLUMN_INDEX_ADDRESS, CellType.FORMULA);
//        cell.setCellFormula("SUM(E2:E6)");
    }
     
    // Auto resize column width
    public static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    public static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
    //done
    public ArrayList GetAll() throws SQLException {
        ArrayList dsnv = new ArrayList<nhanvienDTO>();
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
        String sql= "select * from nhanvien";
        ResultSet rs = db.ExcuteSELECT(sql);
        while(rs.next()){
            nhanvienDTO nv = new nhanvienDTO();
            nv.setTennv(rs.getString("ten_nv")+"");
            nv.setHonv(rs.getString("ho_nv"));
            nv.setIdnv(rs.getInt("id_nv"));
            nv.setUser(rs.getString("user"));
            nv.setPhonenv(rs.getString("phone_nv"));
            nv.setAddressnv(rs.getString("address_nv"));
            nv.setLuongnv(rs.getFloat("luong_nv"));
            nv.setGender(rs.getString("gender"));
            nv.setPasswordnv(rs.getString("password_nv"));
            nv.setChucvu(rs.getString("chucvu_nv"));
            dsnv.add(nv);
        }
        // từ database -> DTO -> arraylist -> model -> table
        db.CloseConnection();
        return dsnv;
    }
    public ArrayList findnv(String name,String gettype) throws SQLException{
        ArrayList findname = new ArrayList<nhanvienDTO>();
            String sql="";
//            
//            boolean isNum = Pattern.matches("^[0-9]+$", name);
//            
//            
            if(gettype == "Tìm kiếm theo mã"){
                sql = "select * from nhanvien where id_nv='"+name+"'";
            }
            else{
                sql = "select * from nhanvien where ten_nv like '%"+name+"%'";
            }

            rs = db.ExcuteSELECT(sql);
            while(rs.next()){
                nhanvienDTO nv = new nhanvienDTO();
                nv.setTennv(rs.getString("ten_nv")+"");
                nv.setHonv(rs.getString("ho_nv"));
                nv.setIdnv(rs.getInt("id_nv"));
                nv.setUser(rs.getString("user"));
                nv.setPhonenv(rs.getString("phone_nv"));
                nv.setAddressnv(rs.getString("address_nv"));
                nv.setLuongnv(rs.getFloat("luong_nv"));
                nv.setGender(rs.getString("gender"));
                nv.setPasswordnv(rs.getString("password_nv"));
                nv.setChucvu(rs.getString("chucvu_nv"));
                findname.add(nv);
            }
        db.CloseConnection();
        return findname;
        // từ database -> DTO -> model -> table
    }
    public String delete(String i){
        String sql = "delete from nhanvien where id_nv='"+i+"'";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String insert(nhanvienDTO nvDTO){
        String sql = "INSERT INTO nhanvien VALUES ('"+nvDTO.getTennv()+"','"+nvDTO.getHonv()+"','"+nvDTO.getIdnv()+"','"+nvDTO.getPhonenv()+"','"+nvDTO.getAddressnv()+"','"+nvDTO.getLuongnv()+"','"+nvDTO.getGender()+"','"+nvDTO.getPasswordnv()+"','"+nvDTO.getChucvu()+"','"+nvDTO.getUser()+"')";
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
    public String update(nhanvienDTO nvDTO,String s){
        String sql = "update nhanvien set ten_nv ='"+nvDTO.getTennv()+"',ho_nv ='"+nvDTO.getHonv()+"',id_nv ='"+nvDTO.getIdnv()+"',phone_nv ='"+nvDTO.getPhonenv()+"',address_nv ='"+nvDTO.getAddressnv()+"',luong_nv ='"+nvDTO.getLuongnv()+"',gender ='"+nvDTO.getGender()+"',password_nv ='"+nvDTO.getPasswordnv()+"',chucvu_nv ='"+nvDTO.getChucvu()+"',user='"+nvDTO.getUser()+"' where id_nv ="+s;
        String rs = db.ExcuteINSERTDELETEUPDATE(sql);
        db.CloseConnection();
        return rs;
    }
}
