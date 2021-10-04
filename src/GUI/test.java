///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//
//import DAO.ConnectDatabase;
//import java.awt.GridLayout;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//
///**
// *
// * @author ad
// */
//public class test extends JFrame{
//    DefaultTableModel model = new DefaultTableModel();
//    JPanel p1,p2;
//    JTextField txtMaSV,txtHo,txtTen,txttimkiem;
//    JTable tblDSSV;
//    JButton them,xoa,sua,doc,tim;
//    JLabel l1,l2,l3,imagelabel;
//    JScrollPane sp;
//    ArrayList<nhanvienDTO> SinhVien;
//    public void test(){
//        sp = new JScrollPane();        
//        tblDSSV = new JTable();
//        tblDSSV.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][]{
//                    {null,null,null,null,null,null,null,null,null},
//                    {null,null,null,null,null,null,null,null,null},
//                    {null,null,null,null,null,null,null,null,null},
//                    {null,null,null,null,null,null,null,null,null}
//                },
//                new String[]{
//                    "Tên Nhân Viên","Họ Nhân Viên","ID","Số Điện Thoại","Địa chỉ","Lương","Giới Tính","Mật Khẩu","Chức Vụ"
//                }
//        ));
//        sp.setViewportView(tblDSSV);
//        tblDSSV.setRowHeight(20);
//        sp.setBounds(0, 0, 1000,300);
//        imagelabel = new JLabel();
//        ImageIcon
//        
//        p1 = new JPanel();
//        p2 = new JPanel();
//        this.add(p1);
//        this.add(p2);
//        p1.setLayout(null);
//        p2.setLayout(new GridLayout(1,1));
//      
//        txtMaSV = new JTextField();
//        txtMaSV.setBounds(30, 30, 100, 20);
//        
//        txtHo = new JTextField();
//        txtHo.setBounds(30, 60, 100, 20);
//        
//        txtTen = new JTextField();
//        txtTen.setBounds(30, 90, 100, 20);
//        
//        txttimkiem = new JTextField();
//        txttimkiem.setBounds(30, 200, 100, 20);
//        
//        them = new JButton("Thêm");
//        them.setBounds(30, 120, 80, 30);
//        
//        xoa = new JButton("Xóa");
//        xoa.setBounds(110, 120, 80, 30);
//        
//        sua = new JButton("Sửa");
//        sua.setBounds(190, 120, 80, 30);
//
//        doc = new JButton("Đọc");
//        doc.setBounds(270, 120, 80, 30);
//        
//        tim = new JButton("Tìm");
//        tim.setBounds(350, 120, 80, 30);
//        
//        
//        tblDSSV.setVisible(true);
//        
//        
//        p1.add(txtMaSV);
//        p1.add(txtHo);
//        p1.add(txtTen);
//        p1.add(txttimkiem);
//        
//        p1.add(them);
//        p1.add(xoa);
//        p1.add(sua);
//        p1.add(doc);
//        p1.add(tim);
//        
//        p2.add(sp);
//        
//        
//        this.setLayout(new GridLayout(2,1));
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(1000, 800);
//    }
//    
////    private void btnThemMouseClicked(java.awt.event.MouseEvent evt){
////        
////        Vector header = new Vector();
////        header.add("Mã Sinh Viên");
////        header.add("Họ");
////        header.add("Tên");
////        if(model.getRowCount() == 0){
////            model = new DefaultTableModel(header,0);//dữ liệu rỗng
////        }
////        //nạp dữ liệu cho mỗi row
////            //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
////        Vector row = new Vector();
////        // add những thông tin từ textfield
////        row.add(txtMaSV.getText());
////        row.add(txtHo.getText());
////        row.add(txtTen.getText());
////        //add row vào model
////        model.addRow(row);
////        //add model vào jtable
////        tblDSSV.setModel(model);
////    }
////    private void tblDSSVMouseClicked(java.awt.event.MouseEvent evt){
////        int i = tblDSSV.getSelectedRow();
////        txtMaSV.setText(tblDSSV.getModel().getValueAt(i,0).toString());
////        txtHo.setText(tblDSSV.getModel().getValueAt(i,1).toString());
////        txtTen.setText(tblDSSV.getModel().getValueAt(i,2).toString());
////    }
////    private void btnXoaMouse(java.awt.event.MouseEvent evt){
////        int i = tblDSSV.getSelectedRow();
////        if(i>=0){
////            model.removeRow(i);
////            tblDSSV.setModel(model);
////        }
////    }
////    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
////        // TODO add your handling code here:
////        int  i=tblDSSV.getSelectedRow();
////        if (i>=0)
////        {
////            model.setValueAt(txtMaSV.getText(), i, 0);
////            model.setValueAt(txtHo.getText(), i, 1);
////            model.setValueAt(txtTen.getText(), i, 2);
////            
////            tblDSSV.setModel(model);
////        }
////    }
////    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {try {
////        //GEN-FIRST:event_btnSuaActionPerformed
////        nhanvienBUS bus = new nhanvienBUS();
////        bus.docDSNV();
////        Vector header = new Vector();
////        header.add("Tên nhân viên");
////        header.add("Họ nhân viên");
////        header.add("ID nhân viên");
////        header.add("Số điện thoại");
////        header.add("Địa chỉ");
////        header.add("Lương");
////        header.add("Giới tính");
////        header.add("Mật khẩu");
////        header.add("Chức vụ");
////        model = new DefaultTableModel(header,0);
////        for(nhanvienDTO nv: nhanvienBUS.dsnv){
////            Vector row = new Vector();
////            // add những thông tin từ textfield
////            row.add(nv.getTennv());
////            row.add(nv.getHonv());
////            row.add(nv.getIdnv());
////            row.add(nv.getPhonenv());
////            row.add(nv.getAddressnv());
////            row.add(nv.getLuongnv());
////            row.add(nv.getGender());
////            row.add(nv.getPasswordnv());
////            row.add(nv.getChucvu());
////            //add row vào model
////            model.addRow(row);
////        }
////        tblDSSV.setModel(model);
////        } catch (SQLException ex) {
////            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
////    public void btnTimkiemByIDActionPerformed(java.awt.event.ActionEvent evt){
////        int id = Integer.parseInt(txttimkiem.getText());
////        nhanvienDTO nvDTO = new nhanvienDTO();
////        nhanvienBUS nvBUS = new nhanvienBUS();
////        nvDTO = nvBUS.timkiembyid(id);
////        Vector header = new Vector();
////        header.add("Tên nhân viên");
////        header.add("Họ nhân viên");
////        header.add("ID nhân viên");
////        header.add("Số điện thoại");
////        header.add("Địa chỉ");
////        header.add("Lương");
////        header.add("Giới tính");
////        header.add("Mật khẩu");
////        header.add("Chức vụ");
////        model = new DefaultTableModel(header,0);
//////        for(nhanvienDTO nv: nvDTO){
////            Vector row = new Vector();
////            // add những thông tin từ textfield
////            row.add(nvDTO.getTennv());
////            row.add(nvDTO.getHonv());
////            row.add(nvDTO.getIdnv());
////            row.add(nvDTO.getPhonenv());
////            row.add(nvDTO.getAddressnv());
////            row.add(nvDTO.getLuongnv());
////            row.add(nvDTO.getGender());
////            row.add(nvDTO.getPasswordnv());
////            row.add(nvDTO.getChucvu());
////            //add row vào model
////            model.addRow(row);
////        //}
////        tblDSSV.setModel(model);
////    }
////    public void btnTimkiemByNameActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{
////        String name = txttimkiem.getText();
////        nhanvienBUS nvBUS = new nhanvienBUS();
////        nvBUS.timkiembyname(name);      
////        Vector header = new Vector();
////        header.add("Tên nhân viên");
////        header.add("Họ nhân viên");
////        header.add("ID nhân viên");
////        header.add("Số điện thoại");
////        header.add("Địa chỉ");
////        header.add("Lương");
////        header.add("Giới tính");
////        header.add("Mật khẩu");
////        header.add("Chức vụ");
////        model = new DefaultTableModel(header,0);
////        for(nhanvienDTO nv: nhanvienBUS.findname){
////            Vector row = new Vector();
////            // add những thông tin từ textfield
////            row.add(nv.getTennv());
////            row.add(nv.getHonv());
////            row.add(nv.getIdnv());
////            row.add(nv.getPhonenv());
////            row.add(nv.getAddressnv());
////            row.add(nv.getLuongnv());
////            row.add(nv.getGender());
////            row.add(nv.getPasswordnv());
////            row.add(nv.getChucvu());
////            //add row vào model
////            model.addRow(row);
////        //}
////        tblDSSV.setModel(model);
////    }
//    }
//    public static void main(String[] args) {
//        test t = new test();
//        ConnectDatabase cn = new ConnectDatabase();
//        t.test();
//        cn.CloseConnection();
//    }
//}
