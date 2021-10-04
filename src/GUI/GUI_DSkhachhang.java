/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.khachhangBUS;
import DTO.khachhangDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUI_DSkhachhang extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private JTable table;
    private JTextField textField_diachi;
    private JTextField textField_idkhachhang;
    private JTextField textField_ho;
    private JTextField textField_ten;
    private JTextField textField_phone;
    private JTextField textField_timkiem;
    private JComboBox comboBox_Gioitinh;
    private String isdouble = "[+]?([0-9]*[.])?[0-9]+";
    private String isnumber = "^[0-9]+$";
    private String tenrong = "[a-zA-Z 0-9]*";
    private String phonenum = "[0]+[1-9]+([0-9]{9})";

    public GUI_DSkhachhang() {
        setLayout(null);
        setBounds(0, 0, 1400, 800);

        table = new JTable();
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        table.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},},
                new String[]{
                    "ID Khách Hàng", "Họ Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa chỉ", "Giới Tính"
                }
        ));
        JLabel ava= new JLabel();
        ava.setBounds(500,0,160, 100);
        add(ava);
        
        
        
        JLabel titl = new JLabel("Danh Sách Khách Hàng");
        titl.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titl.setHorizontalAlignment(SwingConstants.CENTER);
        titl.setBounds(200,20, 1000, 25);
        add(titl);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233,130,920,300);
        scrollPane.setViewportView(table);
        this.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        this.add(panel);
        panel.setLayout(null);
        
        JLabel chart= new JLabel();
        chart.setBounds(50,400,160, 100);
        panel.add(chart);
        
        JLabel shop= new JLabel();
        shop.setBounds(50,500,160, 150);
        panel.add(shop);

        textField_ten = new JTextField();
        textField_ten.setBounds(109, 180, 120, 20);
        panel.add(textField_ten);
        textField_ten.setColumns(10);

        textField_ho = new JTextField();
        textField_ho.setBounds(109, 138, 120, 20);
        panel.add(textField_ho);
        textField_ho.setColumns(10);

        textField_idkhachhang = new JTextField();
        textField_idkhachhang.setBounds(109, 99, 120, 20);
        panel.add(textField_idkhachhang);
        textField_idkhachhang.setColumns(10);

        textField_diachi = new JTextField();
        textField_diachi.setBounds(109, 260, 120, 20);
        panel.add(textField_diachi);
        textField_diachi.setColumns(10);

        textField_timkiem = new JTextField();
        textField_timkiem.setBounds(109, 340, 120, 20);
        panel.add(textField_timkiem);
        textField_timkiem.setColumns(10);

        JLabel lblNewLabel = new JLabel("Tên");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(0, 180, 100, 20);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Họ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 138, 100, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_4 = new JLabel("Mã Khách Hàng");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 99, 100, 20);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_2 = new JLabel("Giới tính");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 220, 100, 20);
        panel.add(lblNewLabel_2);

        comboBox_Gioitinh = new JComboBox();
        comboBox_Gioitinh.setModel(new DefaultComboBoxModel(new String[]{"Nam", "Nữ"}));
        comboBox_Gioitinh.setMaximumRowCount(2);
        comboBox_Gioitinh.setBounds(109, 220, 120, 20);
        panel.add(comboBox_Gioitinh);

        JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 260, 100, 20);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("Phone");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(0, 300, 100, 20);
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Tìm Kiếm");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(0, 340, 100, 20);
        panel.add(lblNewLabel_6);

        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setBounds(293, 446,120,35);
        add(btnNewButton);
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnThemActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_1 = new JButton("Sửa");
        btnNewButton_1.setBounds(420, 446,120, 35);
        add(btnNewButton_1);
        btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnUpdateActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_2 = new JButton("Xóa");
        btnNewButton_2.setBounds(550, 446, 120, 35);
        add(btnNewButton_2);
        btnNewButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnXoaActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_3 = new JButton("Đọc");
        btnNewButton_3.setBounds(680, 446,120,35);
        add(btnNewButton_3);
        btnNewButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDocActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btntimkiem = new JButton("Tìm Kiếm");
        btntimkiem.setBounds(810, 446,120, 35);
        add(btntimkiem);
        try{
        Image img11=ImageIO.read(getClass().getResource("/resources/shop.png"));
        shop.setIcon(new ImageIcon(img11));       
        Image img10=ImageIO.read(getClass().getResource("/resources/chart.png"));
        chart.setIcon(new ImageIcon(img10));    
        Image img9=ImageIO.read(getClass().getResource("/resources/group.png"));
        ava.setIcon(new ImageIcon(img9));
        Image img1 = ImageIO.read(getClass().getResource("/resources/them.png"));
        btnNewButton.setIcon(new ImageIcon(img1));
        Image img2 = ImageIO.read(getClass().getResource("/resources/sua.png"));
        btnNewButton_1.setIcon(new ImageIcon(img2));
        Image img3 = ImageIO.read(getClass().getResource("/resources/xoa.png"));
        btnNewButton_2.setIcon(new ImageIcon(img3));
        Image img4 = ImageIO.read(getClass().getResource("/resources/doc.png"));
        btnNewButton_3.setIcon(new ImageIcon(img4));
        Image img5 = ImageIO.read(getClass().getResource("/resources/tim.png"));
        btntimkiem.setIcon(new ImageIcon(img5));
        }
        catch (Exception ex) {
         System.out.println(ex);
         }
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnTimkiemActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        textField_phone = new JTextField();
        textField_phone.setBounds(109, 300, 120, 20);
        panel.add(textField_phone);

    }

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnSuaActionPerformed
        khachhangBUS bus = new khachhangBUS();
        bus.docDSKH();
        Vector header = new Vector();
        header.add("ID khách hàng");
        header.add("Họ khách hàng");
        header.add("Tên khách hàng");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        header.add("Giới tính");
        model = new DefaultTableModel(header, 0);
        for (khachhangDTO kh : khachhangBUS.dskh) {
            Vector row = new Vector();
            // add những thông tin từ textfield
            row.add(kh.getIdkh());
            row.add(kh.getHokh());
            row.add(kh.getTenkh());
            row.add(kh.getPhonekh());
            row.add(kh.getAddresskh());
            row.add(kh.getGender());
            //add row vào model
            model.addRow(row);
        }
        table.setModel(model);
    }

    public void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if(khachhangBUS.dskh ==null){
            JOptionPane.showMessageDialog(new Frame(), "chưa đọc ds");
            return;
        }
        String str = textField_timkiem.getText();
        khachhangDTO khDTO = new khachhangDTO();
        khachhangBUS khBUS = new khachhangBUS();
        khBUS.timkiem(str);
        Vector header = new Vector();
        header.add("ID khách hàng");
        header.add("Họ khách hàng");
        header.add("Tên khách hàng");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        header.add("Giới tính");

        model = new DefaultTableModel(header, 0);
        for (khachhangDTO kh : khBUS.findname) {
            Vector row = new Vector();
            // add những thông tin từ textfield
            row.add(kh.getIdkh());
            row.add(kh.getHokh());
            row.add(kh.getTenkh());
            row.add(kh.getPhonekh());
            row.add(kh.getAddresskh());
            row.add(kh.getGender());
            //add row vào model
            model.addRow(row);
        }
        table.setModel(model);
    }

    public void btnXoaActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if(khachhangBUS.dskh ==null){
            JOptionPane.showMessageDialog(new Frame(), "chưa đọc ds");
            return;
        }
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(new Frame(), "chưa chỉ vào ds");
        }
        int i = table.getSelectedRow();
        String s = table.getModel().getValueAt(i, 0).toString();
        khachhangBUS khBUS = new khachhangBUS();
        if (khBUS.delete(s)) {
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            textField_idkhachhang.setEditable(true);
            btnDocActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            textField_idkhachhang.setEditable(true);
        }
    }

    public void btnThemActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if(khachhangBUS.dskh ==null){
            JOptionPane.showMessageDialog(new Frame(), "chưa đọc ds");
            return;
        }
      
        khachhangDTO khDTO = new khachhangDTO();
        if (textField_idkhachhang.getText().matches(isnumber)) {
                System.out.println("la so");
                int idkh = Integer.parseInt(textField_idkhachhang.getText());
                for (khachhangDTO kh : khachhangBUS.dskh) {
                    if (idkh == kh.getIdkh()) {
                        JOptionPane.showMessageDialog(new Frame(), "Trùng id");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(new Frame(), "id nhập không đúng dữ liệu");
                return;
            }
        khDTO.setIdkh(Integer.parseInt(textField_idkhachhang.getText()));
        if (!textField_ten.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Tên chưa nhập hoặc nhập sai");
            return;
        }
        khDTO.setTenkh(textField_ten.getText());
        if (!textField_ho.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Họ chưa nhập hoặc nhập sai");
            return;
        }
        khDTO.setHokh(textField_ho.getText());

        if (textField_phone.getText().matches(phonenum)) {
            System.out.println("la so");
             khDTO.setPhonekh(textField_phone.getText());
        } else {
            JOptionPane.showMessageDialog(new Frame(), "dien thoai nhập không đúng dữ liệu");
            return;
        }
        
        khDTO.setAddresskh(textField_diachi.getText());
        khDTO.setGender(comboBox_Gioitinh.getSelectedItem().toString());
        khachhangBUS khBUS = new khachhangBUS();
       if (khBUS.add(khDTO)) {
//            Vector header = new Vector();
//            header.add("ID khách hàng");
//            header.add("Họ khách hàng");
//            header.add("Tên khách hàng");
//            header.add("Số điện thoại");
//            header.add("Địa chỉ");
//            header.add("Giới tính");
//            if (model.getRowCount() == 0) {
//                model = new DefaultTableModel(header, 0);//dữ liệu rỗng
//            }
//            //nạp dữ liệu cho mỗi row
//            //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
//            Vector row = new Vector();
//            // add những thông tin từ textfield
//            row.add(Integer.parseInt(textField_idkhachhang.getText()));
//            row.add(textField_ho.getText());
//            row.add(textField_ten.getText());
//            row.add(textField_phone.getText());
//            row.add(textField_diachi.getText());
//            row.add(comboBox_Gioitinh.getSelectedItem().toString());
//            //add row vào model
//            model.addRow(row);
//            //add model vào jtable
//            table.setModel(model);
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            btnDocActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
        }
    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {
        if(khachhangBUS.dskh ==null){
            JOptionPane.showMessageDialog(new Frame(), "chưa đọc ds");
            return;
        }
      
        int i = table.getSelectedRow();
        textField_idkhachhang.setText(table.getModel().getValueAt(i, 0).toString());
        textField_ho.setText(table.getModel().getValueAt(i, 1).toString());
        textField_ten.setText(table.getModel().getValueAt(i, 2).toString());
        textField_phone.setText(table.getModel().getValueAt(i, 3).toString());
        textField_diachi.setText(table.getModel().getValueAt(i, 4).toString());
        comboBox_Gioitinh.setSelectedItem(table.getModel().getValueAt(i, 5).toString());
        textField_idkhachhang.setEditable(false);
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if(khachhangBUS.dskh ==null){
            JOptionPane.showMessageDialog(new Frame(), "chưa đọc ds");
            return;
        }
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(new Frame(), "chưa chỉ vào ds");
        }
        int i = table.getSelectedRow();
        String s = table.getModel().getValueAt(i, 0).toString();
        khachhangBUS khBUS = new khachhangBUS();
        khachhangDTO khDTO = new khachhangDTO();
        
        khDTO.setIdkh(Integer.parseInt(textField_idkhachhang.getText()));
        if (!textField_ten.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Tên chưa nhập hoặc nhập sai");
            return;
        }
        khDTO.setTenkh(textField_ten.getText());
        if (!textField_ho.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Họ chưa nhập hoặc nhập sai");
            return;
        }
        khDTO.setHokh(textField_ho.getText());

        if (textField_phone.getText().matches(phonenum)) {
            System.out.println("la so");
             khDTO.setPhonekh(textField_phone.getText());
        } else {
            JOptionPane.showMessageDialog(new Frame(), "dien thoai nhập không đúng dữ liệu");
            return;
        }
        
        khDTO.setAddresskh(textField_diachi.getText());
        khDTO.setGender(comboBox_Gioitinh.getSelectedItem().toString());
        if (khBUS.update(khDTO, s)) {
            btnDocActionPerformed(evt);
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            textField_idkhachhang.setEditable(true);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            textField_idkhachhang.setEditable(true);
        }
    }
}
