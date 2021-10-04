/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.cthdBUS;
import BUS.ctspBUS;
import BUS.hoadonBUS;
import BUS.khachhangBUS;
import BUS.kmBUS;
import DAO.LoginPattern;
import DTO.cthdDTO;
import DTO.ctspDTO;
import DTO.hoadonDTO;
import DTO.khachhangDTO;
import DTO.kmDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GUI_hoadon extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private JTable tablehoadon;
    private JTable tablechitiethd;
    private JTextField textField_masp;
    private JTextField textField_mahoadon;
    private JTextField textField_manv;
    private JComboBox textField_makh;
    private JComboBox textField_makm;
    private JTextField textField_soluongsp;
    private JTextField textField_gia;
    private String isdouble = "[+]?([0-9]*[.])?[0-9]+";
    private String isnumber = "^[0-9]+$";
    private String tenrong = "[a-zA-Z 0-9]*";
    private String phonenum = "[0]+[1-9]+([0-9]{9})";

    public GUI_hoadon() {
        setLayout(null);
        setBounds(0, 0, 1400, 800);

        JLabel lblNewLabel_5 = new JLabel("Hóa đơn");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(233, 54, 1027, 21);
        add(lblNewLabel_5);
        
        JLabel bill= new JLabel();
        bill.setBounds(200,230,160, 150);
        add(bill);

        tablehoadon = new JTable();
        tablehoadon.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},},
                new String[]{
                    "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày lập", "Tổng tiền"
                }
        ));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233, 85, 1027, 146);
        scrollPane.setViewportView(tablehoadon);
        this.add(scrollPane);

        JLabel lblNewLabel_6 = new JLabel("Chi tiết hóa đơn");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(233, 400, 1027, 21);
        add(lblNewLabel_6);

        tablechitiethd = new JTable();
        tablechitiethd.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {                    
                    TableMouseClicked(evt);
                }
            });
        tablechitiethd.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},},
                new String[]{
                    "Mã sản phẩm", "Số lượng", "Giá sản phẩm", "Tổng tiền"
                }
        ));

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(233, 440, 1027, 176);
        scrollPane2.setViewportView(tablechitiethd);
        this.add(scrollPane2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        this.add(panel);
        panel.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Tìm kiếm theo tên", "tìm kiếm theo mã"}));
        comboBox.setBounds(0, 10, 229, 21);
//        panel.add(comboBox);

//        textField_mahoadon = new JTextField();
//        textField_mahoadon.setBounds(109, 85, 120, 20);
//        panel.add(textField_mahoadon);
//        textField_mahoadon.setColumns(10);

//        textField_manv = new JTextField();
//        textField_manv.setBounds(109, 125, 120, 20);
//        panel.add(textField_manv);
//        textField_manv.setColumns(10);

        textField_makh = new JComboBox();
        textField_makh.setBounds(109, 125, 120, 20);
        textField_makh.setModel(new DefaultComboBoxModel());
        panel.add(textField_makh);

//        textField_masp = new JTextField();
//        textField_masp.setBounds(109, 440, 120, 20);
//        panel.add(textField_masp);
//        textField_masp.setColumns(10);

        textField_makm = new JComboBox();
        textField_makm.setModel(new DefaultComboBoxModel(new String [] {"1"}));
        textField_makm.setBounds(109, 165, 120, 20);
        panel.add(textField_makm);

        textField_soluongsp = new JTextField();
        textField_soluongsp.setBounds(109, 480, 120, 20);
        panel.add(textField_soluongsp);
        textField_soluongsp.setColumns(10);

//        JLabel lblNewLabel = new JLabel("Mã hóa đơn");
//        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel.setBackground(Color.BLACK);
//        lblNewLabel.setForeground(Color.BLACK);
//        lblNewLabel.setBounds(0, 85, 100, 20);
//        panel.add(lblNewLabel);

//        JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
//        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_1.setBounds(0, 125, 100, 20);
//        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_4 = new JLabel("Mã khách hàng");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 125, 100, 20);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_2 = new JLabel("Mã khuyến mãi");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 165, 100, 20);
        panel.add(lblNewLabel_2);

//        JLabel lblNewLabel_7 = new JLabel("Giá");
//        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_7.setBounds(0, 520, 100, 20);
//        panel.add(lblNewLabel_7);

//        textField_gia = new JTextField();
//        textField_gia.setBounds(109, 520, 120, 20);
//        panel.add(textField_gia);
//        textField_gia.setColumns(10);

//        JLabel lblNewLabel_3 = new JLabel("Mã sản phẩm");
//        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_3.setBounds(0, 440, 100, 20);
//        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_12 = new JLabel("Số lượng sản phẩm");
        lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_12.setBounds(1, 480, 100, 20);
        panel.add(lblNewLabel_12);

//        JButton btnNewButton_themkm = new JButton("Thêm");
//        btnNewButton_themkm.setBounds(15, 235, 85, 21);
//        panel.add(btnNewButton_themkm);
//
//        JButton btnNewButton_suakm = new JButton("Sửa");
//        btnNewButton_suakm.setBounds(136, 236, 85, 21);
//        panel.add(btnNewButton_suakm);
//
//        JButton btnNewButton_xoakm = new JButton("Xóa");
//        btnNewButton_xoakm.setBounds(15, 266, 85, 21);
//        panel.add(btnNewButton_xoakm);

        JButton btnNewButton_docthanhcthd = new JButton("Đọc thành chi tiết hóa đơn");
        btnNewButton_docthanhcthd.setBounds(550, 240, 300,30);
        add(btnNewButton_docthanhcthd);
        
//        JLabel doc= new JLabel();
//        doc.setBounds(50,500,160, 150);
//        panel.add(doc);
//        
        JLabel user= new JLabel();
        user.setBounds(50,250,160,100);
        panel.add(user);
        
        btnNewButton_docthanhcthd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    doccthd(e);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_hoadon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

//        JButton btnNewButton_themctkm = new JButton("Thêm");
//        btnNewButton_themctkm.setBounds(15, 550, 85, 21);
//        panel.add(btnNewButton_themctkm);

        JButton btnNewButton_suactkm = new JButton("Sửa");
        btnNewButton_suactkm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                suabill(e);
            }
        });
        btnNewButton_suactkm.setBounds(136, 579, 85, 21);
        panel.add(btnNewButton_suactkm);

        JButton btnNewButton_xoactkm = new JButton("Xóa");
        btnNewButton_xoactkm.setBounds(15, 579, 85, 21);
        panel.add(btnNewButton_xoactkm);
        btnNewButton_xoactkm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xoaspbill(e);
            }
        });

        JButton btnNewButton_dochd = new JButton("Đọc");
        btnNewButton_dochd.setBounds(350, 240,150,30);
        add(btnNewButton_dochd);        
        btnNewButton_dochd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        //                btnTimkiemByIDActionPerformed(evt);
                        xemhoadon(evt);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_hoadon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        
        JButton btnNewButton_xnbill = new JButton("Xác Nhận Add Bill");
        btnNewButton_xnbill.setBounds(15, 609, 200, 21);
        panel.add(btnNewButton_xnbill);
        btnNewButton_xnbill.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        //                btnTimkiemByIDActionPerformed(evt);
                        addbilldb(evt);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_hoadon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        
        JButton btnNewButton_xembill = new JButton("Xem Bill Đang Được Add");
        btnNewButton_xembill.setBounds(15, 639, 200, 21);
        panel.add(btnNewButton_xembill);
        btnNewButton_xembill.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //                btnTimkiemByIDActionPerformed(evt);
                    btnxembill(evt);
                }
            });

        JLabel lblNewLabel_8 = new JLabel("Hóa đơn");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(0, 54, 229, 21);
        panel.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Chi tiết hóa đơn");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_9.setBounds(0, 400, 229, 21);
        panel.add(lblNewLabel_9);
        
        try{
        Image img7= ImageIO.read(getClass().getResource("/resources/pay.png"));
        bill.setIcon(new ImageIcon(img7));
        Image img8= ImageIO.read(getClass().getResource("/resources/prouser.png"));
        user.setIcon(new ImageIcon(img8));       
        Image img4 = ImageIO.read(getClass().getResource("/resources/bill.png"));
        btnNewButton_dochd.setIcon(new ImageIcon(img4));
        Image img5 = ImageIO.read(getClass().getResource("/resources/cthd.png"));
        btnNewButton_docthanhcthd.setIcon(new ImageIcon(img5));
        }
        catch(Exception ex) {
         System.out.println(ex);
         }
    }
    public static String[] makhachang() throws SQLException{
        khachhangBUS bus = new khachhangBUS();
        bus.docDSKH();
        int temp = khachhangBUS.dskh.size();
        String s[] = new String[temp];
        int dem =0 ;
        for (khachhangDTO kh : khachhangBUS.dskh) {
            s[dem] = "" + kh.getIdkh()+ "";
            dem++;
        }
        return s;
    }
    public static String[] makm() throws SQLException{
        kmBUS bus = new kmBUS();
        bus.docDSKM();
        int temp = kmBUS.dskm.size();
        String s[] = new String[temp];
        int dem =0 ;
        for (kmDTO km : kmBUS.dskm) {
            s[dem] = "" + km.getIdkm()+ "";
            dem++;
        }
        return s;
    }
    private void btnxembill(java.awt.event.ActionEvent evt){
        if(ctspBUS.dsctsp==null){
            JOptionPane.showMessageDialog(new Frame(), "chưa đọc ds");
            return ;
        }
        ctspBUS ctspBUS = new ctspBUS();
        cthdDTO cthdDTO = new cthdDTO();
        
        if(ctspBUS.bill != null){
            Vector header = new Vector();        
            header.add("Mã Sản Phẩm");
            header.add("Số Lượng");
            header.add("Giá Sản Phẩm");
            header.add("Thành Tiền");       
            model = new DefaultTableModel(header, 0);
            for(ctspDTO ctspDTO: ctspBUS.bill ){
                Vector row = new Vector();            
                row.add(ctspDTO.getIdsp());
                row.add(ctspDTO.getSoluong());
                row.add(ctspDTO.getGia());
                row.add(ctspDTO.getSoluong()*ctspDTO.getGia());
                model.addRow(row);
            }
            tablechitiethd.setModel(model);
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Hiện Tại Chưa Có Hóa Đơn Nào Đang Được Khởi Tạo");
        }
    }
    private void addbilldb(java.awt.event.ActionEvent evt) throws SQLException{
//        if(hoadonBUS.dshd == null){
//            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
//            return;
//        }
//        if(tablehoadon.getSelectedRow()==-1){
//            JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
//            return;
//        }
       int i = tablehoadon.getSelectedRow();
        float total = 0;
        cthdBUS cthdBUS = new cthdBUS();        
        String manv = String.valueOf(LoginPattern.getInstance().getUser().getIdnv());        
        String makh = textField_makh.getSelectedItem().toString();
        String makm = textField_makm.getSelectedItem().toString();
        if(ctspBUS.bill != null){                          
            if(!makh.equals("") && !makm.equals("")){
                for(ctspDTO ctspDTO: ctspBUS.bill ){                                       
                    total = (float) (total + ctspDTO.getSoluong()*ctspDTO.getGia());                
                }
                if(cthdBUS.addbill(manv,makh,makm,total)== "Thành công"){
                    ctspBUS.bill = null;                    
                                      
                    textField_soluongsp.setText("");                    
                    JOptionPane.showMessageDialog(new Frame(), "Add Bill Thành Công");
                }else{
                    if(cthdBUS.addbill(manv,makh,makm,total) == "Không Đúng Ngày"){
                        JOptionPane.showMessageDialog(new Frame(), "Mã Khuyến Mãi Đã Hết Hạn");
                    }else{
                        JOptionPane.showMessageDialog(new Frame(), "Không Tồn Tại Mã Khuyến Mãi Này");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(new Frame(), "Chưa Nhập Đầy Đủ Thông Tin");
            }                     
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Hiện Tại Chưa Có Hóa Đơn Nào Đang Được Khởi Tạo");
        }
    }
    private void TableMouseClicked(java.awt.event.MouseEvent evt) {     
        if(cthdBUS.dshd == null){
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        int i = tablechitiethd.getSelectedRow();
//        textField_masp.setText(tablechitiethd.getModel().getValueAt(i, 0).toString());
        textField_soluongsp.setText(tablechitiethd.getModel().getValueAt(i, 1).toString());                
//        textField_gia.setText(tablechitiethd.getModel().getValueAt(i, 2).toString());        
    }
    private void xoaspbill(java.awt.event.ActionEvent evt){    
        ctspBUS ctBUS = new ctspBUS();
        if(ctspBUS.dsctsp == null){
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        if(tablechitiethd.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(new Frame(), "Chua chỉ vào ds");
            return;
        }
        int i = tablechitiethd.getSelectedRow();
        String masp = tablechitiethd.getValueAt(i, 0).toString();
        String gia = tablechitiethd.getValueAt(i, 2).toString();
        if(ctBUS.bill != null){
            if(!masp.equals("") && !textField_soluongsp.equals("") && !gia.equals("")){
                int dem = -1;
                ctspBUS ctspBUS = new ctspBUS();
                for(ctspDTO ctDTO : ctspBUS.bill){
                    dem++;
                    if(Integer.parseInt(masp) == ctDTO.getIdsp() && Integer.parseInt(textField_soluongsp.getText()) == ctDTO.getSoluong() && Float.parseFloat(gia) == ctDTO.getGia()){
                        ctspBUS.bill.remove(dem);                
                        btnxembill(evt);
                        break;
                    }
                }        
                JOptionPane.showMessageDialog(new Frame(), "Đã Xóa Sản Phẩm");
            }else{
                JOptionPane.showMessageDialog(new Frame(), "Xin Chọn Sản Phẩm Để Xóa");
            }
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Hiện Đang Không Có Hóa Đơn Nào Để Xóa");
        }
    }
    private void suabill(java.awt.event.ActionEvent evt){
        ctspBUS ctBUS = new ctspBUS();
        if(ctspBUS.dsctsp == null){
            JOptionPane.showMessageDialog(new Frame(), "Chưa đọc ds");
            return;
        }
        if(tablechitiethd.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
            return;
        }
        int i = tablechitiethd.getSelectedRow();
        String masp = tablechitiethd.getValueAt(i, 0).toString();
        String gia = tablechitiethd.getValueAt(i, 2).toString();
        if(!textField_soluongsp.getText().matches(isnumber)){
            JOptionPane.showMessageDialog(new Frame(), "Sai số");
            return;
        }
        if(ctBUS.bill != null){
            if(!masp.equals("") && !textField_soluongsp.equals("") && !gia.equals("")){
                int dem = -1;
                ctspBUS ctspBUS = new ctspBUS();
                for(ctspDTO ctDTO : ctspBUS.bill){
                    dem++;
                    if(Integer.parseInt(masp) == ctDTO.getIdsp() && Float.parseFloat(gia) == ctDTO.getGia()){
                        ctspBUS.bill.get(dem).setSoluong(Integer.parseInt(textField_soluongsp.getText()));
                        tablechitiethd.getModel().setValueAt(ctDTO.getGia()*ctDTO.getSoluong(),dem,3);
                        btnxembill(evt);
                        break;
                    }
                }        
                JOptionPane.showMessageDialog(new Frame(), "Đã Sửa Sản Phẩm");
            }else{
                JOptionPane.showMessageDialog(new Frame(), "Thiếu Thông Tin Để Sửa Sản Phẩm");
            }            
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Hiện Đang Không Có Hóa Đơn Nào Để Sửa");
        }        
    }
    public void xemhoadon(java.awt.event.ActionEvent evt) throws SQLException{
        textField_makm.setModel(new DefaultComboBoxModel(makm()));
        textField_makh.setModel(new DefaultComboBoxModel(makhachang()));
        hoadonBUS hdBUS = new hoadonBUS();
        hdBUS.docDSHD();
        Vector header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã nhân viên");
        header.add("Mã khách hàng");
        header.add("Mã khuyến mãi");
        header.add("Tổng tiền");
        header.add("Ngày lập");
        model = new DefaultTableModel(header, 0);
        for(hoadonDTO hdDTO : hdBUS.dshd){
            Vector row = new Vector();
            row.add(hdDTO.getIdhd());
            row.add(hdDTO.getIdnv());
            row.add(hdDTO.getIdkh());
            row.add(hdDTO.getIdkm());
            row.add(hdDTO.getTotal());
            row.add(hdDTO.getCreatedat());
            model.addRow(row);
        }
        tablehoadon.setModel(model);
    }
    public void doccthd(java.awt.event.ActionEvent evt) throws SQLException{
        if(tablehoadon.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(new Frame(), "Chưa chỉ vào ds");
            return;
        }
        int i = tablehoadon.getSelectedRow();
        String mahd = tablehoadon.getValueAt(i,0).toString();
//        hoadonDTO hdDTO = new hoadonDTO();
//        hdDTO.setIdhd(Integer.parseInt(tablehoadon.getValueAt(i,0).toString()));
//        hdDTO.setIdnv(Integer.parseInt(tablehoadon.getValueAt(i,1).toString()));
//        hdDTO.setIdkh(Integer.parseInt(tablehoadon.getValueAt(i,2).toString()));
//        hdDTO.setIdkm(Integer.parseInt(tablehoadon.getValueAt(i,3).toString()));
//        hdDTO.setTotal(Float.parseFloat(tablehoadon.getValueAt(i,4).toString()));        
//        hdDTO.setCreatedat((tablehoadon.getValueAt(i,5).toString()));
        cthdBUS ctBUS = new cthdBUS();
        ctBUS.docCTHD(mahd);
        Vector header = new Vector();        
            header.add("Mã Sản Phẩm");
            header.add("Số Lượng");
            header.add("Giá Sản Phẩm");
            header.add("Thành Tiền");       
            model = new DefaultTableModel(header, 0);
            for(cthdDTO cthdDTO: cthdBUS.dshd ){
                Vector row = new Vector();            
                row.add(cthdDTO.getIdsp());
                row.add(cthdDTO.getSoluong());
                row.add(cthdDTO.getGia());
                row.add(cthdDTO.getSubtotal());
                model.addRow(row);
            }
            tablechitiethd.setModel(model);
    }
}
