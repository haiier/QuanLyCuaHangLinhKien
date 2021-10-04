/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BrandBUS;
import BUS.ctspBUS;
import BUS.sanphamBUS;
import DAO.BrandDAO;
import DTO.BrandDTO;
import DTO.ctspDTO;
import DTO.sanphamDTO;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class GUI_DSsanpham extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private JTextPane jt = new JTextPane();
    JLabel cell = new JLabel();
    private JTable tablesp;
    private JTable tablechitiet;
    private JTextField textField_idsp;
    private JTextField textField_tensp;
    private JTextField textField_gia;
    private JTextField textField_soluong;
    private JTextField textField_cpu;
    private JTextField textField_rom;
    private JTextField textField_ram;
    private JTextField textField_picture;
    private JComboBox textField_maspct;
    private JComboBox comboBox_tenhang;
    private String isdouble = "[+]?([0-9]*[.])?[0-9]+";
    private String isnumber = "^[0-9]+$";
    private String tenrong = "[a-zA-Z 0-9]*";

    public GUI_DSsanpham() {
        setLayout(null);
        setBounds(0, 0, 1400, 800);
        JLabel lblNewLabel_5 = new JLabel("Sản phẩm");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(233, 58, 627, 21);
        add(lblNewLabel_5);
        tablesp = new JTable();
        tablesp.setRowHeight(70);
        tablesp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String i = "sp";
                TableMouseClicked(evt, i);
            }
        });
        tablesp.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},},
                new String[]{
                    "Hình Ảnh", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số lượng", "Hãng"
                }
        ));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233, 99, 627, 284);
        scrollPane.setViewportView(tablesp);
        this.add(scrollPane);
        cell.setLocation(913, 99);
        cell.setSize(437, 284);
        add(cell);
        JLabel lblNewLabel_6 = new JLabel("Chi tiết");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(233, 435, 627, 21);
        add(lblNewLabel_6);
        tablechitiet = new JTable();
        tablechitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String i = "ct";
                TableMouseClicked(evt, i);
            }
        });
        tablechitiet.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},},
                new String[]{
                    "Mã sp", "CPU", "Rom", "Ram", "Giá"
                }
        ));
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(233, 475, 627, 176);
        scrollPane2.setViewportView(tablechitiet);
        this.add(scrollPane2);
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        this.add(panel);
        panel.setLayout(null);
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Sắp xếp theo mã", "Sắp xếp theo tên", "Sắp xếp theo giá"}));
        comboBox.setBounds(0, 10, 229, 21);
//        panel.add(comboBox);
        textField_idsp = new JTextField();
        textField_idsp.setBounds(109, 99, 120, 20);
        panel.add(textField_idsp);
        textField_idsp.setColumns(10);
        textField_tensp = new JTextField();
        textField_tensp.setBounds(109, 138, 120, 20);
        panel.add(textField_tensp);
        textField_tensp.setColumns(10);
        comboBox_tenhang = new JComboBox();
        comboBox_tenhang.setModel(new DefaultComboBoxModel());
        comboBox_tenhang.setBounds(109, 240, 120, 20);
        panel.add(comboBox_tenhang);
        textField_soluong = new JTextField();
        textField_soluong.setBounds(109, 178, 120, 20);
        panel.add(textField_soluong);
        textField_soluong.setColumns(10);
        textField_maspct = new JComboBox();
        comboBox_tenhang.setModel(new DefaultComboBoxModel());
        textField_maspct.setBounds(109, 435, 120, 20);
        panel.add(textField_maspct);
        textField_cpu = new JTextField();
        textField_cpu.setBounds(109, 475, 120, 20);
        panel.add(textField_cpu);
        textField_cpu.setColumns(10);
        textField_rom = new JTextField();
        textField_rom.setBounds(109, 515, 120, 20);
        panel.add(textField_rom);
        textField_rom.setColumns(10);
        textField_ram = new JTextField();
        textField_ram.setBounds(109, 555, 120, 20);
        panel.add(textField_ram);
        textField_ram.setColumns(10);
        textField_gia = new JTextField();
        textField_gia.setBounds(109, 585, 120, 20);
        panel.add(textField_gia);
        textField_gia.setColumns(10);
        JLabel lblNewLabel = new JLabel("Mã sản phẩm");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(0, 99, 100, 20);
        panel.add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 138, 100, 20);
        panel.add(lblNewLabel_1);
        JLabel lblNewLabel_4 = new JLabel("Giá");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 585, 100, 20);
        panel.add(lblNewLabel_4);
        JLabel lblNewLabel_2 = new JLabel("Số lượng");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 178, 100, 20);
        panel.add(lblNewLabel_2);
        JLabel lblNewLabel_7 = new JLabel("Hình ảnh");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(0, 210, 100, 20);
        panel.add(lblNewLabel_7);
        textField_picture = new JTextField();
        textField_picture.setEditable(false);
        textField_picture.setBounds(109, 210, 60, 20);
        panel.add(textField_picture);
        textField_picture.setColumns(10);
        JMenuItem mntmNewMenuItem = new JMenuItem("Thêm hình");
        mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 10));
        mntmNewMenuItem.setBounds(169, 210, 60, 20);
        panel.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                insertActionPerformed();
            }
        });
        JLabel lblNewLabel_3 = new JLabel("Hãng");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 240, 100, 20);
        panel.add(lblNewLabel_3);
        JButton btnNewButton_themsp = new JButton("Thêm");
        btnNewButton_themsp.setBounds(15, 285, 85, 21);
        panel.add(btnNewButton_themsp);
        btnNewButton_themsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    //                btnTimkiemByIDActionPerformed(evt);
                    String i = "sp";
                    btnThemActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnNewButton_suasp = new JButton("Sửa");
        btnNewButton_suasp.setBounds(136, 285, 85, 21);
        panel.add(btnNewButton_suasp);
        btnNewButton_suasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String i = "sp";
                    btnUpdateActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnNewButton_addbill = new JButton("Thêm Vào Bill");
        btnNewButton_addbill.setBounds(10, 685, 200, 21);
        panel.add(btnNewButton_addbill);
        btnNewButton_addbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //                btnTimkiemByIDActionPerformed(evt);
                btnAddBill(evt);
            }
        });
        
        JButton btnNewButton_xuatsp = new JButton("Xuất");
        btnNewButton_xuatsp.setBounds(15, 347, 85, 21);
        panel.add(btnNewButton_xuatsp);
        
        JButton btnNewButton_xoasp = new JButton("Xóa");
        btnNewButton_xoasp.setBounds(15, 316, 85, 21);
        panel.add(btnNewButton_xoasp);
        btnNewButton_xoasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //                btnTimkiemByIDActionPerformed(evt);
                String i = "sp";
                try {
                    btnXoaActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnNewButton_docsp = new JButton("Đọc");
        btnNewButton_docsp.setBounds(136, 316, 85, 21);
        panel.add(btnNewButton_docsp);
        btnNewButton_docsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String i = "sp";
                    btnDocActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JLabel lblNewLabel_8 = new JLabel("Mã sản phẩm");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(0, 435, 100, 20);
        panel.add(lblNewLabel_8);
        JLabel lblNewLabel_CPU = new JLabel("CPU");
        lblNewLabel_CPU.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_CPU.setBounds(0, 475, 100, 20);
        panel.add(lblNewLabel_CPU);
        JLabel lblNewLabel_ram = new JLabel("RAM");
        lblNewLabel_ram.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_ram.setBounds(0, 555, 100, 20);
        panel.add(lblNewLabel_ram);
        JLabel lblNewLabel_rom = new JLabel("ROM");
        lblNewLabel_rom.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_rom.setBounds(0, 515, 100, 20);
        panel.add(lblNewLabel_rom);
        JButton btnNewButton_themctsp = new JButton("Thêm");
        btnNewButton_themctsp.setBounds(15, 614, 85, 21);
        panel.add(btnNewButton_themctsp);
        btnNewButton_themctsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //                btnTimkiemByIDActionPerformed(evt);
                String i = "ct";
                try {
                    btnThemActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnNewButton_suactsp = new JButton("Sửa");
        btnNewButton_suactsp.setBounds(136, 614, 85, 21);
        panel.add(btnNewButton_suactsp);
        btnNewButton_suactsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String i = "ct";
                    btnUpdateActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnNewButton_xoactsp = new JButton("Xóa");
        btnNewButton_xoactsp.setBounds(15, 645, 85, 21);
        panel.add(btnNewButton_xoactsp);
        btnNewButton_xoactsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //                btnTimkiemByIDActionPerformed(evt);
                String i = "ct";
                try {
                    btnXoaActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnNewButton_docctsp = new JButton("Đọc");
        btnNewButton_docctsp.setBounds(136, 645, 85, 21);
        panel.add(btnNewButton_docctsp);
        btnNewButton_docctsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String i = "ct";
                    btnDocActionPerformed(evt, i);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JLabel lblNewLabel_9 = new JLabel("Chi tiết");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setBounds(0, 395, 229, 20);
        panel.add(lblNewLabel_9);
        JLabel lblNewLabel_10 = new JLabel("Sản phẩm");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_10.setBounds(0, 58, 229, 20);
        panel.add(lblNewLabel_10);

    }

    private void insertActionPerformed() {
        JFileChooser jf = new JFileChooser();

        // Show open dialog
        int option = jf.showOpenDialog(this);

        // If user chooses to insert..
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = jf.getSelectedFile();
            if (isImage(file)) {
                // Insert the icon
                textField_picture.setText(file.getName());
            } else // Show an error message, if not an image
            {
                JOptionPane.showMessageDialog(this, "Không phải hình.", "Not Image", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static String[] tenbrand() throws SQLException {
        BrandBUS bus = new BrandBUS();
        bus.docDSBR();
        int temp = BrandBUS.dsbr.size();
        String s[] = new String[temp];
        int dem = 0;
        for (BrandDTO br : BrandBUS.dsbr) {
            s[dem] = br.getTen_brand();
            dem++;
        }
        return s;
    }

    public static String[] masanpham() throws SQLException {
        sanphamBUS bus = new sanphamBUS();
        bus.docDSSP();
        int temp = sanphamBUS.dssp.size();
        String s[] = new String[temp];
        int dem = 0;
        for (sanphamDTO sp : sanphamBUS.dssp) {
            s[dem] = "" + sp.getIdsp() + "";
            dem++;
        }
        return s;
    }

    private boolean isImage(File file) {
        String name = file.getName();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg");
    }

    private void btnAddBill(java.awt.event.ActionEvent evt) {
        if (ctspBUS.dsctsp == null) {
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }

        if (!textField_cpu.getText().equals("") && !textField_rom.getText().equals("") && !textField_ram.getText().equals("") && !textField_gia.equals("")) {
            int flag = 0;
            int dem = -1;
            ctspDTO ctspDTO = new ctspDTO();
            ctspDTO.setIdsp(Integer.parseInt(textField_maspct.getSelectedItem().toString()));
            ctspDTO.setCpu(textField_cpu.getText());
            ctspDTO.setDisk(Integer.parseInt(textField_rom.getText()));
            ctspDTO.setRam(Integer.parseInt(textField_ram.getText()));
            ctspDTO.setSoluong(1);
            ctspDTO.setGia(Double.parseDouble(textField_gia.getText()));
            ctspBUS ctspBUS = new ctspBUS();
            if (ctspBUS.bill != null) {
                for (ctspDTO ctDTO : ctspBUS.bill) {
                    dem++;
                    if (ctspDTO.getIdsp() == ctDTO.getIdsp() && ctspDTO.getCpu().equals(ctDTO.getCpu()) && ctspDTO.getDisk() == ctDTO.getDisk() && ctspDTO.getRam() == ctDTO.getRam()) {
                        ctspBUS.bill.get(dem).setSoluong(ctDTO.getSoluong() + 1);
                        JOptionPane.showMessageDialog(new Frame(), "Đã Tăng Số Lượng Sản Phẩm");
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    ctspBUS.bill.add(ctspDTO);
                    JOptionPane.showMessageDialog(new Frame(), "Thêm Thành Công");
                }
            } else {
                ctspBUS.bill = new ArrayList<ctspDTO>();
                ctspBUS.bill.add(ctspDTO);
                JOptionPane.showMessageDialog(new Frame(), "Thêm Thành Công");
            }
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Chưa Có Thông Tin Sản Phẩm Cần Add");
            return;
        }
    }

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt, String i) throws SQLException {//GEN-FIRST:event_btnSuaActionPerformed    

        if (i == "sp") {
            comboBox_tenhang.setModel(new DefaultComboBoxModel(tenbrand()));
            sanphamBUS bus = new sanphamBUS();
            bus.docDSSP();
            Vector header = new Vector();
            header.add("Hình Ảnh");
            header.add("Mã Sản Phẩm");
            header.add("Tên Sản Phẩm");
            header.add("Số Lượng");
            header.add("Hãng");
            model = new DefaultTableModel(header, 0);
            int row2 = 0;
            for (sanphamDTO sp : sanphamBUS.dssp) {
                Vector row = new Vector();
                // add những thông tin từ textfield
                row.add(sp.getHinhanhsp());
                row.add(sp.getIdsp());
                row.add(sp.getTensp());
                row.add(sp.getSoluongsp());
                row.add(sp.getTenbrand());
                //add row vào model
                model.addRow(row);
            }
            tablesp.setModel(model);
        } else {
            textField_maspct.setModel(new DefaultComboBoxModel(masanpham()));
            ctspBUS bus = new ctspBUS();
            bus.docDSCTSP();
            Vector header = new Vector();
            header.add("Mã Sản Phẩm");
            header.add("CPU");
            header.add("ROM");
            header.add("RAM");
            header.add("Giá");
            model = new DefaultTableModel(header, 0);
            for (ctspDTO sp : ctspBUS.dsctsp) {
                Vector row = new Vector();
                // add những thông tin từ textfield                
                row.add(sp.getIdsp());
                row.add(sp.getCpu());
                row.add(sp.getDisk());
                row.add(sp.getRam());
                row.add(sp.getGia());
                //add row vào model
                model.addRow(row);
            }
            tablechitiet.setModel(model);
        }
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt, String a) throws SQLException {
        if (a == "sp") {
            if (sanphamBUS.dssp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            if (tablesp.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
                return;
            }
            int i = tablesp.getSelectedRow();
            String s = tablesp.getModel().getValueAt(i, 1).toString();
            sanphamBUS spBUS = new sanphamBUS();
            if (spBUS.delete(s)) {
                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
                btnDocActionPerformed(evt, "sp");
                textField_idsp.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
                textField_idsp.setEditable(true);
            }
    
        } else {
            if (tablechitiet.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
                return;
            }
            if (ctspBUS.dsctsp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            int i = tablechitiet.getSelectedRow();
            String s = tablechitiet.getModel().getValueAt(i, 0).toString();
            ctspBUS spBUS = new ctspBUS();
            if (spBUS.delete(s)) {
                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
                btnDocActionPerformed(evt, "ct");
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            }
       
        }
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt, String i) throws SQLException {
        if (i == "sp") {
            if (sanphamBUS.dssp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            sanphamDTO spDTO = new sanphamDTO();
            spDTO.setHinhanhsp(textField_picture.getText());
            if (textField_idsp.getText().matches(isnumber)) {
                System.out.println("la so");
                int idsp = Integer.parseInt(textField_idsp.getText());
                for (sanphamDTO sp : sanphamBUS.dssp) {
                    if (idsp == sp.getIdsp()) {
                        JOptionPane.showMessageDialog(new Frame(), "Trùng id");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(new Frame(), "id nhập không đúng dữ liệu");
                return;
            }
            spDTO.setIdsp(Integer.parseInt(textField_idsp.getText()));

            if (!textField_tensp.getText().matches(tenrong)) {
                JOptionPane.showMessageDialog(new Frame(), "Tên chưa nhập hoặc nhập sai");
                return;
            }
            spDTO.setTensp(textField_tensp.getText());

            if (textField_soluong.getText().matches(isnumber)) {
                System.out.println("la so");
                spDTO.setSoluongsp(Integer.parseInt(textField_soluong.getText()));
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Số lượng nhập không đúng dữ liệu");
                return;
            }
            spDTO.setTenbrand(comboBox_tenhang.getSelectedItem().toString());
            sanphamBUS spBUS = new sanphamBUS();
            if (spBUS.add(spDTO)) {
//                Vector header = new Vector();
//                header.add("Hình Ảnh");
//                header.add("Mã Sản Phẩm");
//                header.add("Tên Sản Phẩm");
//
//                header.add("Số Lượng");
//                header.add("Hãng");
//                if (model.getRowCount() == 0) {
//                    model = new DefaultTableModel(header, 0);//dữ liệu rỗng
//                }
//                //nạp dữ liệu cho mỗi row
//                //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
//                Vector row = new Vector();
//                // add những thông tin từ textfield
//                row.add(textField_picture.getText());
//                row.add(Integer.parseInt(textField_idsp.getText()));
//                row.add(textField_tensp.getText());
//
//                row.add(Integer.parseInt(textField_soluong.getText()));
//                row.add(comboBox_tenhang.getSelectedItem().toString());
//                //add row vào model
//                model.addRow(row);
//                //add model vào jtable
//                tablesp.setModel(model);
                
                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
                btnDocActionPerformed(evt, "sp");
                textField_maspct.setModel(new DefaultComboBoxModel(masanpham()));
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            }
        } else {
            if (ctspBUS.dsctsp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            ctspDTO spDTO = new ctspDTO();

            spDTO.setIdsp(Integer.parseInt(textField_maspct.getSelectedItem().toString()));

            if (!textField_cpu.getText().matches("")) {
                if (!textField_cpu.getText().matches(tenrong)) {
                    JOptionPane.showMessageDialog(new Frame(), "CPU nhập sai");
                    return;
                } else {
                    spDTO.setCpu(textField_cpu.getText());
                }
            } else {
                spDTO.setCpu(textField_cpu.getText());
            }

            if (!textField_rom.getText().matches("")) {
                if (textField_rom.getText().matches(isnumber)) {
                    System.out.println("la so");
                    spDTO.setDisk(Integer.parseInt(textField_rom.getText()));
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Rom nhập không đúng dữ liệu");
                    return;
                }
            } else {
                spDTO.setDisk(Integer.parseInt(textField_rom.getText()));
            }

            if (!textField_ram.getText().matches("")) {
                if (textField_ram.getText().matches(isnumber)) {
                    System.out.println("la so");
                    spDTO.setRam(Integer.parseInt(textField_ram.getText()));
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Ram nhập không đúng dữ liệu");
                    return;
                }
            } else {
                spDTO.setRam(Integer.parseInt(textField_ram.getText()));
            }

            if (textField_gia.getText().matches(isdouble)) {
                System.out.println("la so");
                spDTO.setGia(Double.parseDouble(textField_gia.getText()));
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Giá nhập không đúng dữ liệu");
                return;
            }
            ctspBUS spBUS = new ctspBUS();
            if (spBUS.add(spDTO)) {
                Vector header = new Vector();
//                header.add("Mã Sản Phẩm");
//                header.add("CPU");
//                header.add("ROM");
//                header.add("RAM");
//                header.add("Giá");
//                if (model.getRowCount() == 0) {
//                    model = new DefaultTableModel(header, 0);//dữ liệu rỗng
//                }
//                //nạp dữ liệu cho mỗi row
//                //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
//                Vector row = new Vector();
//                // add những thông tin từ textfield                
//                row.add(Integer.parseInt(textField_maspct.getSelectedItem().toString()));
//                row.add(textField_cpu.getText());
//                row.add(Integer.parseInt(textField_rom.getText()));
//                row.add(Integer.parseInt(textField_ram.getText()));
//                row.add(Double.parseDouble(textField_gia.getText()));
//                //add row vào model
//                model.addRow(row);
//                //add model vào jtable
//                tablechitiet.setModel(model);
                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
                btnDocActionPerformed(evt, "ct");
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Không thành công");
            }
        }
    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt, String a) {
        if (a == "sp") {
            if (sanphamBUS.dssp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            int i = tablesp.getSelectedRow();
            if (tablesp.getModel().getValueAt(i, 0).toString().endsWith(".jpg") || tablesp.getModel().getValueAt(i, 0).toString().endsWith(".png") || tablesp.getModel().getValueAt(i, 0).toString().endsWith(".jpeg")) {
                cell.setIcon(new javax.swing.ImageIcon(getClass().getResource(tablesp.getModel().getValueAt(i, 0).toString())));
            } else {
                cell.setIcon(null);
            }
            textField_idsp.setEditable(false);
            textField_idsp.setText(tablesp.getModel().getValueAt(i, 1).toString());
            textField_tensp.setText(tablesp.getModel().getValueAt(i, 2).toString());
            textField_picture.setText(tablesp.getModel().getValueAt(i, 0).toString());
            textField_soluong.setText(tablesp.getModel().getValueAt(i, 3).toString());
            comboBox_tenhang.setSelectedItem(tablesp.getModel().getValueAt(i, 4).toString());
        } else {
            if (ctspBUS.dsctsp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            int i = tablechitiet.getSelectedRow();
//        textField_ten.setText(tablesp.getModel().getValueAt(i,0).toString());
            textField_maspct.setSelectedItem(tablechitiet.getModel().getValueAt(i, 0).toString());
            textField_cpu.setText(tablechitiet.getModel().getValueAt(i, 1).toString());
            textField_rom.setText(tablechitiet.getModel().getValueAt(i, 2).toString());
            textField_ram.setText(tablechitiet.getModel().getValueAt(i, 3).toString());
            textField_gia.setText(tablechitiet.getModel().getValueAt(i, 4).toString());
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt, String a) throws SQLException {
        if (a == "sp") {
            if (tablesp.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
                return;
            }
            if (sanphamBUS.dssp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            int i = tablesp.getSelectedRow();
            String s = tablesp.getModel().getValueAt(i, 1).toString();
            sanphamBUS spBUS = new sanphamBUS();
            sanphamDTO spDTO = new sanphamDTO();
            spDTO.setHinhanhsp(textField_picture.getText());
//            if (textField_idsp.getText().matches(isnumber)) {
//                System.out.println("la so");
//                int idsp = Integer.parseInt(textField_idsp.getText());
//                for (sanphamDTO sp : sanphamBUS.dssp) {
//                    if (idsp == sp.getIdsp()) {
//                        JOptionPane.showMessageDialog(new Frame(), "Trùng id");
//                        return;
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "id nhập không đúng dữ liệu");
//                return;
//            }
            spDTO.setIdsp(Integer.parseInt(textField_idsp.getText()));

            if (!textField_tensp.getText().matches(tenrong)) {
                JOptionPane.showMessageDialog(new Frame(), "Tên chưa nhập hoặc nhập sai");
                return;
            }
            spDTO.setTensp(textField_tensp.getText());

            if (textField_soluong.getText().matches(isnumber)) {
                System.out.println("la so");
                spDTO.setSoluongsp(Integer.parseInt(textField_soluong.getText()));
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Số lượng nhập không đúng dữ liệu");
                return;
            }
            spDTO.setTenbrand(comboBox_tenhang.getSelectedItem().toString());
            if (spBUS.update(spDTO, s)) {
                btnDocActionPerformed(evt, a);
                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
                textField_idsp.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
                textField_idsp.setEditable(true);
            }
        } else {
            if (ctspBUS.dsctsp == null) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
                return;
            }
            if (tablechitiet.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
                return;
            }
            int i = tablechitiet.getSelectedRow();
            String s = tablechitiet.getModel().getValueAt(i, 0).toString();
            ctspBUS spBUS = new ctspBUS();
            ctspDTO spDTO = new ctspDTO();
            spDTO.setIdsp(Integer.parseInt(textField_maspct.getSelectedItem().toString()));

            if (!textField_cpu.getText().matches("")) {
                if (!textField_cpu.getText().matches(tenrong)) {
                    JOptionPane.showMessageDialog(new Frame(), "CPU nhập sai");
                    return;
                } else {
                    spDTO.setCpu(textField_cpu.getText());
                }
            } else {
                spDTO.setCpu(textField_cpu.getText());
            }

            if (!textField_rom.getText().matches("")) {
                if (textField_rom.getText().matches(isnumber)) {
                    System.out.println("la so");
                    spDTO.setDisk(Integer.parseInt(textField_rom.getText()));
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Rom nhập không đúng dữ liệu");
                    return;
                }
            } else {
                spDTO.setDisk(Integer.parseInt(textField_rom.getText()));
            }

            if (!textField_ram.getText().matches("")) {
                if (textField_ram.getText().matches(isnumber)) {
                    System.out.println("la so");
                    spDTO.setRam(Integer.parseInt(textField_ram.getText()));
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Ram nhập không đúng dữ liệu");
                    return;
                }
            } else {
                spDTO.setRam(Integer.parseInt(textField_ram.getText()));
            }

            if (textField_gia.getText().matches(isdouble)) {
                System.out.println("la so");
                spDTO.setGia(Double.parseDouble(textField_gia.getText()));
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Giá nhập không đúng dữ liệu");
                return;
            }
            if (spBUS.update(spDTO, s)) {
                btnDocActionPerformed(evt, a);
                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
            }
        }
    }
}
