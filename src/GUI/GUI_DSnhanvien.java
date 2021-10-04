/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.nhanvienBUS;
import DTO.nhanvienDTO;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Admin
 */
public class GUI_DSnhanvien extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private JTable table;
    private JTextField textField_diachi;
    private JTextField textField_idnv;
    private JTextField textField_ho;
    private JTextField textField_ten;
    private JTextField textField_luong;
    private JTextField textField_phone, textField_taikhoan;
    private JTextField textField_timkiem, textField_matkhau;
    private JComboBox comboBox_Gioitinh, comboBox_chucvu, comboBox_timkiem;
    private String isdouble = "[+]?([0-9]*[.])?[0-9]+";
    private String isnumber = "^[0-9]+$";
    private String tenrong = "[a-zA-Z 0-9]*";
    private String phonenum = "[0]+[1-9]+([0-9]{9})";

    public GUI_DSnhanvien() {
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
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "Tên Nhân Viên", "Họ Nhân Viên", "ID", "Tài khoản", "Số Điện Thoại", "Địa chỉ", "Lương", "Giới Tính", "Mật Khẩu", "Chức Vụ"
                }
        ));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233,10, 920, 400);
        scrollPane.setBackground(new Color(0,0,0));
        scrollPane.setViewportView(table);
        this.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        add(panel);
        panel.setLayout(null);
        
        textField_idnv = new JTextField();
        textField_idnv.setBounds(109, 99, 120, 20);
        panel.add(textField_idnv);
        textField_idnv.setColumns(10);

        textField_ho = new JTextField();
        textField_ho.setBounds(109, 138, 120, 20);
        panel.add(textField_ho);
        textField_ho.setColumns(10);

        textField_ten = new JTextField();
        textField_ten.setBounds(109, 180, 120, 20);
        panel.add(textField_ten);
        textField_ten.setColumns(10);

        textField_diachi = new JTextField();
        textField_diachi.setBounds(109, 261, 120, 20);
        panel.add(textField_diachi);
        textField_diachi.setColumns(10);

        textField_phone = new JTextField();
        textField_phone.setBounds(109, 385, 120, 20);
        panel.add(textField_phone);
        textField_phone.setColumns(10);

        textField_matkhau = new JTextField();
        textField_matkhau.setBounds(109, 425, 120, 20);
        panel.add(textField_matkhau);
        textField_matkhau.setColumns(10);

        textField_taikhoan = new JTextField();
        textField_taikhoan.setBounds(109, 465, 120, 20);
        panel.add(textField_taikhoan);
        textField_taikhoan.setColumns(10);

        textField_timkiem = new JTextField();
        textField_timkiem.setBounds(109, 505, 120, 20);
        panel.add(textField_timkiem);
        textField_timkiem.setColumns(10);
        
        JLabel ava= new JLabel();
        ava.setBounds(30,0,160, 100);
        panel.add(ava);
        try {
        Image img9=ImageIO.read(getClass().getResource("/resources/user.png"));
        ava.setIcon(new ImageIcon(img9));    
        }
        catch (Exception ex) {
         System.out.println(ex);
         }

        JLabel lblNewLabel = new JLabel("Mã nhân viên");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(0, 99, 100, 20);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Họ");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 138, 100, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Giới tính");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 219, 100, 20);
        panel.add(lblNewLabel_2);

        comboBox_Gioitinh = new JComboBox();
        comboBox_Gioitinh.setModel(new DefaultComboBoxModel(new String[]{"Nam", "Nữ"}));
        comboBox_Gioitinh.setMaximumRowCount(2);
        comboBox_Gioitinh.setBounds(109, 219, 120, 20);
        panel.add(comboBox_Gioitinh);

        comboBox_timkiem = new JComboBox();
        comboBox_timkiem.setModel(new DefaultComboBoxModel(new String[]{"Tìm kiếm theo mã", "Tìm kiếm theo tên"}));
        comboBox_timkiem.setBounds(0, 10, 229, 21);
        //panel.add(comboBox_timkiem);

        JLabel lblNewLabel_3 = new JLabel("Địa chỉ");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 260, 100, 20);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Tên");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 180, 100, 20);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Chức vụ");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(0, 303, 100, 20);
        panel.add(lblNewLabel_5);

        comboBox_chucvu = new JComboBox();
        comboBox_chucvu.setModel(new DefaultComboBoxModel(new String[]{"Quản lý", "Nhân viên", "Chủ"}));
        comboBox_chucvu.setBounds(109, 303, 120, 20);
        panel.add(comboBox_chucvu);

        JLabel lblNewLabel_6 = new JLabel("Lương");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(0, 345, 100, 20);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Phone");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(0, 385, 100, 20);
        panel.add(lblNewLabel_7);

        JLabel lblNewLabel_9 = new JLabel("Mật Khẩu");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setBounds(0, 425, 100, 20);
        panel.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Tài Khoản");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_10.setBounds(0, 465, 100, 20);
        panel.add(lblNewLabel_10);

        JLabel lblNewLabel_8 = new JLabel("Tìm Kiếm");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(0, 505, 100, 20);
        panel.add(lblNewLabel_8);

        textField_luong = new JTextField();
        textField_luong.setBounds(109, 345, 120, 20);
        panel.add(textField_luong);
        textField_luong.setColumns(10);

        JButton btnNewButton = new JButton("Thêm");
        btnNewButton.setBounds(490, 500,100,40);
        this.add(btnNewButton);
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    //                btnTimkiemByIDActionPerformed(evt);
                    btnThemActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_1 = new JButton("Sửa");
        btnNewButton_1.setBounds(370, 500,100,40);
        this.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnUpdateActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_2 = new JButton("Xóa");
        btnNewButton_2.setBounds(250,500, 100, 40);
        this.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    //                btnTimkiemByIDActionPerformed(evt);
                    btnXoaActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_3 = new JButton("Đọc");
        btnNewButton_3.setBounds(610, 500,100, 40);
        this.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDocActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_4 = new JButton("xuất");
        btnNewButton_4.setBounds(730,500,100,40);
        this.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnXuatActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        JButton tim = new JButton("Tìm Kiếm");
        tim.setBounds(850, 500, 100, 40);
        this.add(tim);
        try{
        Image img1 = ImageIO.read(getClass().getResource("/resources/them.png"));
        btnNewButton.setIcon(new ImageIcon(img1));
        Image img2 = ImageIO.read(getClass().getResource("/resources/sua.png"));
        btnNewButton_1.setIcon(new ImageIcon(img2));
        Image img3 = ImageIO.read(getClass().getResource("/resources/xoa.png"));
        btnNewButton_2.setIcon(new ImageIcon(img3));
        Image img4 = ImageIO.read(getClass().getResource("/resources/doc.png"));
        btnNewButton_3.setIcon(new ImageIcon(img4));
        Image img5 = ImageIO.read(getClass().getResource("/resources/ex.png"));
        btnNewButton_4.setIcon(new ImageIcon(img5));
        Image img7= ImageIO.read(getClass().getResource("/resources/tim.png"));
        tim.setIcon(new ImageIcon(img7));
        }
        catch(Exception ex) {
         System.out.println(ex);
         }
        tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    //                btnTimkiemByIDActionPerformed(evt);
                    btnTimkiemActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSnhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void btnXuatActionPerformed(ActionEvent evt) throws SQLException, IOException {
        if(nhanvienBUS.dsnv == null){
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        nhanvienBUS bus = new nhanvienBUS();
        bus.exDSNV();
    }

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        //GEN-FIRST:event_btnSuaActionPerformed
        nhanvienBUS bus = new nhanvienBUS();
        bus.docDSNV();
        Vector header = new Vector();
        header.add("Tên nhân viên");
        header.add("Họ nhân viên");
        header.add("ID nhân viên");
        header.add("Tài khoản nhân viên");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        header.add("Lương");
        header.add("Giới tính");
        header.add("Mật khẩu");
        header.add("Chức vụ");
        model = new DefaultTableModel(header, 0);
        for (nhanvienDTO nv : nhanvienBUS.dsnv) {
            Vector row = new Vector();
            // add những thông tin từ textfield
            row.add(nv.getTennv());
            row.add(nv.getHonv());
            row.add(nv.getIdnv());
            row.add(nv.getUser());
            row.add(nv.getPhonenv());
            row.add(nv.getAddressnv());
            row.add(nv.getLuongnv());
            row.add(nv.getGender());
            row.add(nv.getPasswordnv());
            row.add(nv.getChucvu());

            //add row vào model
            model.addRow(row);
        }
        table.setModel(model);
    }

    public void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        String gettype = comboBox_timkiem.getSelectedItem().toString();
        String str = textField_timkiem.getText();
        nhanvienDTO nvDTO = new nhanvienDTO();
        nhanvienBUS nvBUS = new nhanvienBUS();
        if (nhanvienBUS.dsnv == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        nvBUS.timkiem(str, gettype);
        Vector header = new Vector();
        header.add("Tên nhân viên");
        header.add("Họ nhân viên");
        header.add("ID nhân viên");
        header.add("Tài khoản nhân viên");
        header.add("Số điện thoại");
        header.add("Địa chỉ");
        header.add("Lương");
        header.add("Giới tính");
        header.add("Mật khẩu");
        header.add("Chức vụ");

        if (nvBUS.findname.size() == 0) {
            JOptionPane.showMessageDialog(new Frame(), "Không Có Kết Quả Tìm Kiếm");
            return;
        } else {
            model = new DefaultTableModel(header, 0);
            for (nhanvienDTO nv : nvBUS.findname) {
                Vector row = new Vector();
                // add những thông tin từ textfield
                row.add(nv.getTennv());
                row.add(nv.getHonv());
                row.add(nv.getIdnv());
                row.add(nv.getPhonenv());
                row.add(nv.getAddressnv());
                row.add(nv.getLuongnv());
                row.add(nv.getGender());
                row.add(nv.getPasswordnv());
                row.add(nv.getChucvu());
                //add row vào model
                model.addRow(row);
            }
        }
        table.setModel(model);
    }

    public void btnXoaActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (nhanvienBUS.dsnv == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
            return;
        }

        int i = table.getSelectedRow();
        String s = table.getModel().getValueAt(i, 2).toString();
        nhanvienBUS nvBUS = new nhanvienBUS();
        if (nhanvienBUS.dsnv == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        if (nvBUS.delete(s)) {
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            textField_idnv.setEditable(true);
            btnDocActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            textField_idnv.setEditable(true);
        }
 
    }

    public void btnThemActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        nhanvienDTO nvDTO = new nhanvienDTO();
        if (nhanvienBUS.dsnv == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        if (textField_idnv.getText().matches(isnumber)) {
            System.out.println("la so");
            int idnv = Integer.parseInt(textField_idnv.getText());
            for (nhanvienDTO nv : nhanvienBUS.dsnv) {
                if (idnv == nv.getIdnv()) {
                    JOptionPane.showMessageDialog(new Frame(), "Trùng id");
                    return;
                }
            }
            nvDTO.setIdnv(Integer.parseInt(textField_idnv.getText()));
        } else {
            JOptionPane.showMessageDialog(new Frame(), "id nhập không đúng dữ liệu");
            return;
        }

        if (!textField_ten.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Tên chưa nhập hoặc nhập sai");
            return;
        }
        nvDTO.setTennv(textField_ten.getText());

        if (!textField_ho.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Họ chưa nhập hoặc nhập sai");
            return;
        }
        nvDTO.setHonv(textField_ho.getText());

        if (textField_phone.getText().matches(phonenum)) {
            System.out.println("la so");
            nvDTO.setPhonenv(textField_phone.getText());
        } else {
            JOptionPane.showMessageDialog(new Frame(), "dienthoai nhập không đúng dữ liệu");
            return;
        }

        nvDTO.setAddressnv(textField_diachi.getText());

        if (textField_luong.getText().matches(isdouble)) {
            System.out.println("la so");
            nvDTO.setLuongnv(Float.parseFloat(textField_luong.getText()));
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Luong nhập không đúng dữ liệu");
            return;
        }

        nvDTO.setGender(comboBox_Gioitinh.getSelectedItem().toString());
        nvDTO.setPasswordnv(textField_matkhau.getText());
        nvDTO.setChucvu(comboBox_chucvu.getSelectedItem().toString());

        if (!textField_taikhoan.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "tai khoan chưa nhập hoặc nhập sai");
            return;
        } else {
            String username = textField_taikhoan.getText();
            for (nhanvienDTO nv : nhanvienBUS.dsnv) {
                if (username.equals(nv.getUser())) {
                    JOptionPane.showMessageDialog(new Frame(), "Trùng User");
                    return;
                }

            }
            nvDTO.setUser(textField_taikhoan.getText());
        }

        nhanvienBUS nvBUS = new nhanvienBUS();
        if (nvBUS.add(nvDTO)) {
//            Vector header = new Vector();
//            header.add("Tên nhân viên");
//            header.add("Họ nhân viên");
//            header.add("ID nhân viên");
//            header.add("Tài khoản nhân viên");
//            header.add("Số điện thoại");
//            header.add("Địa chỉ");
//            header.add("Lương");
//            header.add("Giới tính");
//            header.add("Mật khẩu");
//            header.add("Chức vụ");
//            if (model.getRowCount() == 0) {
//                model = new DefaultTableModel(header, 0);//dữ liệu rỗng
//            }
//            //nạp dữ liệu cho mỗi row
//            //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
//            Vector row = new Vector();
//            // add những thông tin từ textfield
//            row.add(textField_ten.getText());
//            row.add(textField_ho.getText());
//            row.add(Integer.parseInt(textField_idnv.getText()));
//            row.add(textField_taikhoan.getText());
//            row.add(textField_phone.getText());
//            row.add(textField_diachi.getText());
//            row.add(Float.parseFloat(textField_luong.getText()));
//            row.add(comboBox_Gioitinh.getSelectedItem().toString());
//            row.add(textField_matkhau.getText());
//            row.add(comboBox_chucvu.getSelectedItem().toString());
//            //add row vào model
//            model.addRow(row);
            //add model vào jtable
            table.setModel(model);
            textField_ten.setText("");
            textField_ho.setText("");
            textField_idnv.setText("");
            textField_phone.setText("");
            textField_diachi.setText("");
            textField_luong.setText("");
            textField_matkhau.setText("");
            textField_taikhoan.setText("");
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            btnDocActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
        }
    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {
        if (nhanvienBUS.dsnv == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        int i = table.getSelectedRow();

        textField_ten.setText(table.getModel().getValueAt(i, 0).toString());
        textField_ho.setText(table.getModel().getValueAt(i, 1).toString());
        textField_idnv.setText(table.getModel().getValueAt(i, 2).toString());
        textField_taikhoan.setText(table.getModel().getValueAt(i, 3).toString());
        textField_phone.setText(table.getModel().getValueAt(i, 4).toString());
        textField_diachi.setText(table.getModel().getValueAt(i, 5).toString());
        textField_luong.setText(table.getModel().getValueAt(i, 6).toString());
        comboBox_Gioitinh.setSelectedItem(table.getModel().getValueAt(i, 7).toString());
        textField_matkhau.setText(table.getModel().getValueAt(i, 8).toString());
        comboBox_chucvu.setSelectedItem(table.getModel().getValueAt(i, 9).toString());
        textField_idnv.setEditable(false);
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (nhanvienBUS.dsnv == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }

        int i = table.getSelectedRow();
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
            return;
        }
        String s = table.getModel().getValueAt(i, 2).toString();
        nhanvienBUS nvBUS = new nhanvienBUS();
        nhanvienDTO nvDTO = new nhanvienDTO();
        nvDTO.setIdnv(Integer.parseInt(textField_idnv.getText()));
        if (!textField_ten.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Tên chưa nhập hoặc nhập sai");
            return;
        }
        nvDTO.setTennv(textField_ten.getText());

        if (!textField_ho.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "Họ chưa nhập hoặc nhập sai");
            return;
        }
        nvDTO.setHonv(textField_ho.getText());

        if (textField_phone.getText().matches(phonenum)) {
            System.out.println("la so");
            nvDTO.setPhonenv(textField_phone.getText());
        } else {
            JOptionPane.showMessageDialog(new Frame(), "dien thoai nhập không đúng dữ liệu");
            return;
        }

        nvDTO.setAddressnv(textField_diachi.getText());

        if (textField_luong.getText().matches(isdouble)) {
            System.out.println("la so");
            nvDTO.setLuongnv(Float.parseFloat(textField_luong.getText()));
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Luong nhập không đúng dữ liệu");
            return;
        }

        nvDTO.setGender(comboBox_Gioitinh.getSelectedItem().toString());
        nvDTO.setPasswordnv(textField_matkhau.getText());
        nvDTO.setChucvu(comboBox_chucvu.getSelectedItem().toString());

        if (!textField_taikhoan.getText().matches(tenrong)) {
            JOptionPane.showMessageDialog(new Frame(), "tai khoan chưa nhập hoặc nhập sai");
            return;
        }
        nvDTO.setUser(textField_taikhoan.getText());
        if (nvBUS.update(nvDTO, s)) {
            btnDocActionPerformed(evt);
            textField_ten.setText("");
            textField_ho.setText("");
            textField_idnv.setText("");
            textField_taikhoan.setText("");
            textField_phone.setText("");
            textField_diachi.setText("");
            textField_luong.setText("");
            textField_matkhau.setText("");
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            textField_idnv.setEditable(true);
        } else {
            textField_ten.setText("");
            textField_ho.setText("");
            textField_idnv.setText("");
            textField_taikhoan.setText("");
            textField_phone.setText("");
            textField_diachi.setText("");
            textField_luong.setText("");
            textField_matkhau.setText("");
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            textField_idnv.setEditable(true);
        }
    }
}
