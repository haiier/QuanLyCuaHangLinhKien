/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.ctpnBUS;
import BUS.ctpnBUS;
import BUS.phieunhapBUS;
import DTO.ctpnDTO;
import DTO.phieunhapDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUI_phieunhap extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private JTable tablephieunhap;
    private JTable tablechitietpn;
    private JTextField textField_masp;
    private JTextField textField_maphieunhap;
    private JTextField textField_manv;
    private JTextField textField_mancc;
    private JTextField textField_soluongsp;
    private JTextField textField_maphieunhap2;

    /**
     * Create the panel.
     */
    public GUI_phieunhap() {
        setLayout(null);
        setBounds(0, 0, 860, 720);

        JLabel lblNewLabel_5 = new JLabel("Phiếu nhập");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(233, 54, 627, 21);
        add(lblNewLabel_5);

        tablephieunhap = new JTable();
        tablephieunhap.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},},
                new String[]{
                    "Mã phiếu nhập", "Mã nhân viên", "Ngày lập", "Mã nhà cung cấp", "Tổng tiền"
                }
        ));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233, 85, 627, 146);
        scrollPane.setViewportView(tablephieunhap);
        this.add(scrollPane);

        JLabel lblNewLabel_6 = new JLabel("Chi tiết phiếu nhập");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(233, 400, 627, 21);
        add(lblNewLabel_6);

        tablechitietpn = new JTable();
        tablechitietpn.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},},
                new String[]{
                    "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Giá sản phẩm", "Tổng tiền"
                }
        ));

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(233, 440, 627, 176);
        scrollPane2.setViewportView(tablechitietpn);
        this.add(scrollPane2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 720);
        this.add(panel);
        panel.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Tìm kiếm theo tên", "tìm kiếm theo mã"}));
        comboBox.setBounds(0, 10, 229, 21);
        panel.add(comboBox);

        textField_maphieunhap = new JTextField();
        textField_maphieunhap.setBounds(109, 85, 120, 20);
        panel.add(textField_maphieunhap);
        textField_maphieunhap.setColumns(10);

        textField_manv = new JTextField();
        textField_manv.setBounds(109, 125, 120, 20);
        panel.add(textField_manv);
        textField_manv.setColumns(10);

        textField_mancc = new JTextField();
        textField_mancc.setBounds(109, 165, 120, 20);
        panel.add(textField_mancc);
        textField_mancc.setColumns(10);

        textField_masp = new JTextField();
        textField_masp.setBounds(109, 480, 120, 20);
        panel.add(textField_masp);
        textField_masp.setColumns(10);

        textField_soluongsp = new JTextField();
        textField_soluongsp.setBounds(109, 520, 120, 20);
        panel.add(textField_soluongsp);
        textField_soluongsp.setColumns(10);

        JLabel lblNewLabel = new JLabel("Mã hóa đơn");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(0, 85, 100, 20);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 125, 100, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_4 = new JLabel("Nhà cung cấp");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 165, 100, 20);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_7 = new JLabel("Mã phiếu nhập");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(0, 440, 100, 20);
        panel.add(lblNewLabel_7);

        textField_maphieunhap2 = new JTextField();
        textField_maphieunhap2.setBounds(109, 440, 120, 20);
        panel.add(textField_maphieunhap2);
        textField_maphieunhap2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Mã sản phẩm");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 480, 100, 20);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_12 = new JLabel("Số lượng sản phẩm");
        lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_12.setBounds(1, 520, 100, 20);
        panel.add(lblNewLabel_12);

        JButton btnNewButton_thempn = new JButton("Thêm");
        btnNewButton_thempn.setBounds(15, 195, 85, 21);
        panel.add(btnNewButton_thempn);

        JButton btnNewButton_suapn = new JButton("Sửa");
        btnNewButton_suapn.setBounds(136, 195, 85, 21);
        panel.add(btnNewButton_suapn);

        JButton btnNewButton_xoapn = new JButton("Xóa");
        btnNewButton_xoapn.setBounds(15, 226, 85, 21);
        panel.add(btnNewButton_xoapn);

        JButton btnNewButton_docpn = new JButton("Đọc");
        btnNewButton_docpn.setBounds(136, 226, 85, 21);
        panel.add(btnNewButton_docpn);
        
//        btnNewButton_docpn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                try {
//                    String i = "pn";
//                    btnDocActionPerformed(evt, i);
//                } catch (SQLException ex) {
//                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });

        JButton btnNewButton_themctpn = new JButton("Thêm");
        btnNewButton_themctpn.setBounds(15, 550, 85, 21);
        panel.add(btnNewButton_themctpn);

        JButton btnNewButton_suactpn = new JButton("Sửa");
        btnNewButton_suactpn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_suactpn.setBounds(136, 550, 85, 21);
        panel.add(btnNewButton_suactpn);

        JButton btnNewButton_xoactpn = new JButton("Xóa");
        btnNewButton_xoactpn.setBounds(15, 579, 85, 21);
        panel.add(btnNewButton_xoactpn);

        JButton btnNewButton_docctpn = new JButton("Đọc");
        btnNewButton_docctpn.setBounds(136, 579, 85, 21);
        panel.add(btnNewButton_docctpn);
        
//         btnNewButton_docctpn.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                try {
//                    String i = "ct";
//                    btnDocActionPerformed(evt, i);
//                } catch (SQLException ex) {
//                    Logger.getLogger(GUI_DSsanpham.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });

        JLabel lblNewLabel_8 = new JLabel("Phiếu nhập");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(0, 54, 229, 21);
        panel.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Chi tiết phiếu nhập");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_9.setBounds(0, 400, 229, 21);
        panel.add(lblNewLabel_9);
    }

//    private void btnDocActionPerformed(java.awt.event.ActionEvent evt, String i) throws SQLException {//GEN-FIRST:event_btnSuaActionPerformed        
//        if (i == "pn") {
//            phieunhapBUS bus = new phieunhapBUS();
//            bus.docDSPN();
//            Vector header = new Vector();
//            header.add("Hình Ảnh");
//            header.add("Mã Sản Phẩm");
//            header.add("Tên Sản Phẩm");
//            header.add("Giá");
//            header.add("Số Lượng");
//            header.add("Hãng");
//            model = new DefaultTableModel(header, 0);
//            int row2 = 0;
//            for (phieunhapDTO sp : phieunhapBUS.dspn) {
//                Vector row = new Vector();
//                // add những thông tin từ textfield
//                row.add(sp.getMaphieunhap());
//                row.add(sp.getManhanvien());
//                row.add(sp.getNgaylap());
//                row.add(sp.getNhacungcap());
//                row.add(sp.getTongtien());
//                //add row vào model
//                model.addRow(row);
//            }
//            tablephieunhap.setModel(model);
//        }
//            else {
//            ctpnBUS bus = new ctpnBUS();
//            bus.docDSctPN();
//            Vector header = new Vector();
//            header.add("Mã Sản Phẩm");
//            header.add("CPU");
//            header.add("ROM");
//            header.add("RAM");
//            model = new DefaultTableModel(header, 0);
//            for (ctpnDTO sp : ctpnBUS.dsctpn) {
//                Vector row = new Vector();
//                // add những thông tin từ textfield                
//                row.add(sp.getMaphieunhap());
//                row.add(sp.getMasanpham());
//                row.add(sp.getSoluong());
//                row.add(sp.getGiasanpham());
//                row.add(sp.getTongtien());
//                //add row vào model
//                model.addRow(row);
//            }
//            tablechitietpn.setModel(model);
//        }
//    }
//        public void btnXoaActionPerformed(java.awt.event.ActionEvent evt, String a) {
//        if (a == "sp") {
//            int i = tablephieunhap.getSelectedRow();
//            String s = tablephieunhap.getModel().getValueAt(i, 1).toString();
//            phieunhapBUS ctpnBUS = new phieunhapBUS();
//            if (ctpnBUS.delete(s)) {
//                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
//            }
//            if (i >= 0) {
//                model.removeRow(i);
//                tablephieunhap.setModel(model);
//            }
//        } else {
//            int i = tablechitietpn.getSelectedRow();
//            String s = tablechitietpn.getModel().getValueAt(i, 0).toString();
//            ctpnBUS ctpnBUS = new ctpnBUS();
//            if (ctpnBUS.delete(s)) {
//                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
//            }
//            if (i >= 0) {
//                model.removeRow(i);
//                tablechitietpn.setModel(model);
//            }
//        }
//    }
//
//    public void btnThemActionPerformed(java.awt.event.ActionEvent evt, String i) {
//        if (i == "sp") {
//            phieunhapDTO pnDTO = new phieunhapDTO();
//            pnDTO.setMaphieunhap(textField_maphieunhap.getText());
//            pnDTO.setManhanvien(textField_manv.getText());
//            
//            //Ngay lay truc tiep
// //           pnDTO.setNgaylap(textField_.getText()));
//            
//            
//            pnDTO.setNhacungcap(textField_mancc.getText());
//            
//            //tinh tong ben chi tiet
//        //    pnDTO.setTongtien(textField_.getText());
//        
//        
//            phieunhapBUS ctpnBUS = new phieunhapBUS();
//            if (ctpnBUS.add(pnDTO)) {
//                Vector header = new Vector();
//                header.add("Hình Ảnh");
//                header.add("Mã Sản Phẩm");
//                header.add("Tên Sản Phẩm");
//                header.add("Giá");
//                header.add("Số Lượng");
//                header.add("Hãng");
//                if (model.getRowCount() == 0) {
//                    model = new DefaultTableModel(header, 0);//dữ liệu rỗng
//                }
//                //nạp dữ liệu cho mỗi row
//                //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
//                Vector row = new Vector();
//                // add những thông tin từ textfield
//                row.add(null);
//                row.add(Integer.parseInt(textField_idsp.getText()));
//                row.add(textField_tensp.getText());
//                row.add(Float.parseFloat(textField_gia.getText()));
//                row.add(Integer.parseInt(textField_soluong.getText()));
//                row.add(Integer.parseInt(textField_hang.getText()));
//                //add row vào model
//                model.addRow(row);
//                //add model vào jtable
//                tablephieunhap.setModel(model);
//                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
//            }
//        } else {
//            ctpnDTO pnDTO = new ctpnDTO();
//            pnDTO.setCpu(textField_cpu.getText());
//            pnDTO.setIdsp(Integer.parseInt(textField_maspct.getText()));
//            pnDTO.setDisk(Integer.parseInt(textField_rom.getText()));
//            pnDTO.setRam(Integer.parseInt(textField_ram.getText()));
//            ctpnBUS ctpnBUS = new ctpnBUS();
//            if (ctpnBUS.add(pnDTO)) {
//                Vector header = new Vector();
//                header.add("Mã Sản Phẩm");
//                header.add("CPU");
//                header.add("ROM");
//                header.add("RAM");
//                if (model.getRowCount() == 0) {
//                    model = new DefaultTableModel(header, 0);//dữ liệu rỗng
//                }
//                //nạp dữ liệu cho mỗi row
//                //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
//                Vector row = new Vector();
//                // add những thông tin từ textfield                
//                row.add(Integer.parseInt(textField_maspct.getText()));
//                row.add(textField_cpu.getText());
//                row.add(Integer.parseInt(textField_rom.getText()));
//                row.add(Integer.parseInt(textField_ram.getText()));
//                //add row vào model
//                model.addRow(row);
//                //add model vào jtable
//                tablechitietpn.setModel(model);
//                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
//            }
//        }
//    }
//
//    private void TableMouseClicked(java.awt.event.MouseEvent evt, String a) {
//        if (a == "sp") {
//            int i = tablephieunhap.getSelectedRow();
//            textField_idsp.setText(tablephieunhap.getModel().getValueAt(i, 1).toString());
//            textField_tensp.setText(tablephieunhap.getModel().getValueAt(i, 2).toString());
//            textField_gia.setText(tablephieunhap.getModel().getValueAt(i, 3).toString());
//            textField_soluong.setText(tablephieunhap.getModel().getValueAt(i, 4).toString());
//            textField_hang.setText(tablephieunhap.getModel().getValueAt(i, 5).toString());
//        } else {
//            int i = tablechitietpn.getSelectedRow();
////        textField_ten.setText(tablephieunhap.getModel().getValueAt(i,0).toString());
//            textField_maspct.setText(tablechitietpn.getModel().getValueAt(i, 0).toString());
//            textField_cpu.setText(tablechitietpn.getModel().getValueAt(i, 1).toString());
//            textField_rom.setText(tablechitietpn.getModel().getValueAt(i, 2).toString());
//            textField_ram.setText(tablechitietpn.getModel().getValueAt(i, 3).toString());
//        }
//    }
//
//    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt, String a) throws SQLException {
//        if (a == "sp") {
//            int i = tablephieunhap.getSelectedRow();
//            String s = tablephieunhap.getModel().getValueAt(i, 1).toString();
//            phieunhapBUS ctpnBUS = new phieunhapBUS();
//            phieunhapDTO pnDTO = new phieunhapDTO();
//            pnDTO.setTensp(textField_tensp.getText());
//            pnDTO.setIdsp(Integer.parseInt(textField_idsp.getText()));
//            pnDTO.setGiasp(Float.parseFloat(textField_gia.getText()));
//            pnDTO.setSoluongsp(Integer.parseInt(textField_soluong.getText()));
//            pnDTO.setIdbrand(Integer.parseInt(textField_hang.getText()));
//            if (ctpnBUS.update(pnDTO, s)) {
//                btnDocActionPerformed(evt, a);
//                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
//            }
//        } else {
//            int i = tablechitietpn.getSelectedRow();
//            String s = tablechitietpn.getModel().getValueAt(i, 0).toString();
//            ctpnBUS ctpnBUS = new ctpnBUS();
//            ctpnDTO pnDTO = new ctpnDTO();
//            pnDTO.setCpu(textField_cpu.getText());
//            pnDTO.setIdsp(Integer.parseInt(textField_maspct.getText()));
//            pnDTO.setDisk(Integer.parseInt(textField_rom.getText()));
//            pnDTO.setRam(Integer.parseInt(textField_ram.getText()));
//            if (ctpnBUS.update(pnDTO, s)) {
//                btnDocActionPerformed(evt, a);
//                JOptionPane.showMessageDialog(new Frame(), "Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
//            }
//        }
//    }
}
