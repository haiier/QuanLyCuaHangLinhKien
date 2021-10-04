/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.kmBUS;
import DTO.kmDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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
public class GUI_khuyenmai extends JPanel {
    DefaultTableModel model = new DefaultTableModel();
    private JTable tablekhuyenmai;
    private JTable tablechitietkm;
    private JTextField textField_tylekm;
    private JTextField textField_makm1;
    private JTextField textField_tenkm;
    private JTextField textField_ngaybd;
    private JTextField textField_ngaykt;
    private JTextField textField_idsp;
    private JTextField textField_makm2,textField_phantram;
    private JFormattedTextField dateTextField;
    private JDateChooser datebd,datekt;
    private String ngaybd,ngaykt;

    /**
     * Create the panel.
     */
    public GUI_khuyenmai() {
        setLayout(null);
        setBounds(0, 0, 1400, 800);
        

        JLabel lblNewLabel_5 = new JLabel("Khuyến mãi");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(300, 10, 627, 21);
        add(lblNewLabel_5);

        tablekhuyenmai = new JTable();
//        tablekhuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
//                public void mouseClicked(java.awt.event.MouseEvent evt) {                    
//                    TableMouseClicked(evt);
//                }
//            });
        tablekhuyenmai.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},},
                new String[]{
                    "Mã KM", "Tên KM", "Ngày bắt đầu", "Ngày kết thúc,Phần Trăm Khuyến Mãi"
                }
        ));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233, 41,900, 400);
        scrollPane.setViewportView(tablekhuyenmai);
        this.add(scrollPane);

        JLabel km= new JLabel();
        km.setBounds(500, 10,100,30);
        add(km);
        

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        this.add(panel);
        panel.setLayout(null);
        JLabel dis= new JLabel();
        dis.setBounds(0,280,panel.getWidth(),500);
        panel.add(dis);
        try{
        Image img7= ImageIO.read(getClass().getResource("/resources/km.png"));
        km.setIcon(new ImageIcon(img7));
        Image img11= ImageIO.read(getClass().getResource("/resources/dis.jpeg"));
        dis.setIcon(new ImageIcon(img11));
        
        }
        catch(Exception ex) {
         System.out.println(ex);
         }


//        textField_makm1 = new JTextField();
//        textField_makm1.setBounds(109, 37, 120, 20);
//        panel.add(textField_makm1);
//        textField_makm1.setColumns(10);

        textField_tenkm = new JTextField();
        textField_tenkm.setBounds(109, 67, 120, 20);
        panel.add(textField_tenkm);
        textField_tenkm.setColumns(10);

//        textField_ngaybd = new JTextField();
//        textField_ngaybd.setBounds(109, 97, 120, 20);
//        panel.add(textField_ngaybd);
//        textField_ngaybd.setColumns(10);
                
        datebd = new JDateChooser();
        datebd.setDateFormatString("yyyy-MM-dd");    
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) datebd.getDateEditor();
        editor2.setEditable(false);
        datebd.setBounds(109, 97, 120, 20);
        datebd.setFocusCycleRoot(false);
        panel.add(datebd);

//        textField_tylekm = new JTextField();
//        textField_tylekm.setBounds(109, 383, 120, 20);
//        panel.add(textField_tylekm);
//        textField_tylekm.setColumns(10);

//        textField_ngaykt = new JTextField();
//        textField_ngaykt.setBounds(109, 127, 120, 20);
//        panel.add(textField_ngaykt);
//        textField_ngaykt.setColumns(10);

        datekt = new JDateChooser();
        datekt.setDateFormatString("yyyy-MM-dd");        
        datekt.setBounds(109, 127, 120, 20);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) datekt.getDateEditor();
        editor.setEditable(false);
        datekt.setFocusable(false);
        panel.add(datekt);

        textField_phantram = new JTextField();
        textField_phantram.setBounds(109, 40, 120, 20);
        panel.add(textField_phantram);
        textField_phantram.setColumns(10);

//        JLabel lblNewLabel = new JLabel("Mã khuyến mãi");
//        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel.setBackground(Color.BLACK);
//        lblNewLabel.setForeground(Color.BLACK);
//        lblNewLabel.setBounds(0, 36, 100, 20);
//        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tên khuyến mãi");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 66, 100, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_4 = new JLabel("Ngày bắt đầu");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 96, 100, 20);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_2 = new JLabel("ngày kết thúc");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(0, 126, 100, 20);
        panel.add(lblNewLabel_2);

//        JLabel lblNewLabel_7 = new JLabel("Mã khuyến mãi");
//        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_7.setBounds(0, 352, 100, 20);
//        panel.add(lblNewLabel_7);
//
//        textField_makm2 = new JTextField();
//        textField_makm2.setBounds(109, 353, 120, 20);
//        panel.add(textField_makm2);
//        textField_makm2.setColumns(10);
//
//        JLabel lblNewLabel_3 = new JLabel("Tỷ lệ khuyến mãi");
//        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_3.setBounds(0, 382, 100, 20);
//        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_CPU = new JLabel("tỷ lệ Khuyến Mãi");
        lblNewLabel_CPU.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_CPU.setBounds(1, 40, 100, 20);
        panel.add(lblNewLabel_CPU);

        JButton btnNewButton_themkm = new JButton("Thêm");
        btnNewButton_themkm.setBounds(15, 167,200,30);
        panel.add(btnNewButton_themkm);
        btnNewButton_themkm.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //                btnTimkiemByIDActionPerformed(evt);                    
                    btnthem(evt);
                }
         });
        

        JButton btnNewButton_xoakm = new JButton("Xóa");
        btnNewButton_xoakm.setBounds(15,210,200, 30);
        panel.add(btnNewButton_xoakm);
        btnNewButton_xoakm.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        //                btnTimkiemByIDActionPerformed(evt);
                        btnxoa(evt);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_khuyenmai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
         });
        

        JButton btnNewButton_dockm = new JButton("Đọc");
        btnNewButton_dockm.setBounds(15, 250,200,30);
        panel.add(btnNewButton_dockm);
        btnNewButton_dockm.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //                btnTimkiemByIDActionPerformed(evt);                    
                    btndochkm(evt);
                }
         });

        try{
         Image img3 = ImageIO.read(getClass().getResource("/resources/them.png"));
        btnNewButton_themkm.setIcon(new ImageIcon(img3));
        Image img4 = ImageIO.read(getClass().getResource("/resources/doc.png"));
        btnNewButton_xoakm.setIcon(new ImageIcon(img4));
        Image img5 = ImageIO.read(getClass().getResource("/resources/xoa.png"));
         btnNewButton_dockm.setIcon(new ImageIcon(img5));
        }
        catch(Exception ex) {
         System.out.println(ex);
         }

//        JLabel lblNewLabel_8 = new JLabel("Khuyến mãi");
//        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_8.setBounds(0, 10, 229, 21);
//        panel.add(lblNewLabel_8);
//
//        JLabel lblNewLabel_9 = new JLabel("Chi tiết khuyến mãi");
//        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
//        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        lblNewLabel_9.setBounds(0, 318, 229, 21);
//        panel.add(lblNewLabel_9);
    }
    private void btndochkm(java.awt.event.ActionEvent evt){
        kmBUS kmBUS = new kmBUS();
        kmBUS.docDSKM();
        Vector header = new Vector();
        header.add("Mã Khuyến Mãi");
        header.add("Tên Khuyến Mãi");
        header.add("Ngày Bắt Đầu");
        header.add("Ngày Kết Thúc");
        header.add("Phần Trăm Khuyến Mãi");
        model = new DefaultTableModel(header,0);
        for(kmDTO kmDTO: kmBUS.dskm){
            Vector row = new Vector();
            row.add(kmDTO.getIdkm());
            row.add(kmDTO.getTenkm());
            row.add(kmDTO.getNgaybd());
            row.add(kmDTO.getNgaykt());
            row.add(kmDTO.getPhantram());
            model.addRow(row);
        }
        tablekhuyenmai.setModel(model);
    }    
    private void btnthem(java.awt.event.ActionEvent evt){
        if(kmBUS.dskm == null){
            JOptionPane.showMessageDialog(new Frame(),"chưa đọc ds");
            return;
        }
        kmDTO kmDTO = new kmDTO();
        kmBUS kmBUS = new kmBUS();
        if(datebd.getDate() != null && datekt.getDate() !=null &&!textField_tenkm.equals("") && textField_phantram != null){
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            ngaybd = dateformat.format(datebd.getDate());
            ngaykt = dateformat.format(datekt.getDate());
            kmDTO.setTenkm(textField_tenkm.getText());
            kmDTO.setNgaybd(ngaybd);
            kmDTO.setNgaykt(ngaykt);
            kmDTO.setPhantram(Integer.parseInt(textField_phantram.getText()));        
           if(kmBUS.add(kmDTO)){
                btndochkm(evt);
                JOptionPane.showMessageDialog(new Frame(), "Thêm Thành Công");
            }else{
                JOptionPane.showMessageDialog(new Frame(), "Thêm Không Thành Công");
            } 
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Chưa Đủ Thông Tin Để Thêm");
        }
    }
    private void btnxoa(java.awt.event.ActionEvent evt) throws SQLException{
        if(kmBUS.dskm == null){
            JOptionPane.showMessageDialog(new Frame(),"chưa đọc ds");
            return;
        }
        kmBUS kmBUS = new kmBUS();
        int i = tablekhuyenmai.getSelectedRow();
        if(i != -1){
            String idkm = tablekhuyenmai.getValueAt(i, 0).toString();
            if(kmBUS.delete(idkm)=="Thành công"){
                btndochkm(evt);
                JOptionPane.showMessageDialog(new Frame(), "Xóa Thành Công");
            }else{
                if(kmBUS.delete(idkm)=="Mã Đã Được Sử Dụng"){
                    JOptionPane.showMessageDialog(new Frame(), "Mã Đã Được Sử Dụng Không Thể Xóa");
                }        
            }
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Bạn Chưa Chọn Mã Khuyến Mãi Nào Để Xóa");
        }
    }
}
