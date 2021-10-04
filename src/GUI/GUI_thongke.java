/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.cthdBUS;
import BUS.hoadonBUS;
import BUS.thongkeBUS;
import DTO.cthdDTO;
import DTO.hoadonDTO;
import DTO.thongkeDTO;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
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
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class GUI_thongke extends JPanel{
    DefaultTableModel model = new DefaultTableModel();
    private JTable tablethongke;
    private JTextField textField_mahoadon;
    private JTextField textField_manv;
    private JTextField textField_makh;
    private JDateChooser date;
    private JDateChooser date2;

    public GUI_thongke() {
        setLayout(null);
        setBounds(0, 0, 1400, 800);

        tablethongke = new JTable();
        tablethongke.setModel(new DefaultTableModel(
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
        scrollPane.setBounds(233, 226,900, 146);
        scrollPane.setViewportView(tablethongke);
        this.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        this.add(panel);
        panel.setLayout(null);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Tìm kiếm theo tên", "tìm kiếm theo mã"}));
        comboBox.setBounds(0, 10, 229, 21);
//        panel.add(comboBox);

        JLabel user= new JLabel();
        user.setBounds(50,50,160,100);
        panel.add(user);

        date = new JDateChooser();
        date.setDateFormatString("dd/MM/yyyy");
        JTextFieldDateEditor editor = (JTextFieldDateEditor) date.getDateEditor();
        editor.setEditable(false);
        
        date.setBounds(109, 226, 120, 20);
        panel.add(date);


        date2 = new JDateChooser();
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) date2.getDateEditor();
        date2.setDateFormatString("dd/MM/yyyy");
        editor2.setEditable(false);
        date2.setBounds(109, 286, 120, 20);
        panel.add(date2);

        JLabel lblNewLabel = new JLabel("Từ ngày");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(0, 225, 100, 20);
        panel.add(lblNewLabel);


        JLabel lblNewLabel_4 = new JLabel("Đến Ngày");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(0, 285, 100, 20);
        panel.add(lblNewLabel_4);

        JButton btnNewButton_dockm = new JButton("Tra");
        btnNewButton_dockm.setBounds(78, 315, 85, 21);
        panel.add(btnNewButton_dockm);
        btnNewButton_dockm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //                btnTimkiemByIDActionPerformed(evt);
                btnTraActionPerformed(evt);
            }
        });

        JLabel lblNewLabel_8 = new JLabel("Thống kê");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setBounds(0, 194, 229, 21);
        panel.add(lblNewLabel_8);
        
        try{
        Image img8= ImageIO.read(getClass().getResource("/resources/prouser.png"));
        user.setIcon(new ImageIcon(img8));  
        }
        catch(Exception ex) {
         System.out.println(ex);
         }
    }
    public void btnTraActionPerformed(java.awt.event.ActionEvent evt){
        if(date.getDate() == null || date2.getDate() == null){
            JOptionPane.showMessageDialog(new Frame(), "Nhập time");
            return;
        }
        Date d1 = date.getDate();
        Date d2 = date2.getDate();
        if(d1.compareTo(d2)>0){
            JOptionPane.showMessageDialog(new Frame(), "Sai thời gian r nhập lại đi");
            return;
        }
        
        thongkeBUS hdBUS = new thongkeBUS();
        hdBUS.docDSHD(d1,d2);
        Vector header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã nhân viên");
        header.add("Mã khách hàng");
        header.add("Mã khuyến mãi");
        header.add("Tổng tiền");
        header.add("Ngày lập");
        model = new DefaultTableModel(header, 0);
        for(thongkeDTO hdDTO : hdBUS.dshd){
            Vector row = new Vector();
            row.add(hdDTO.getIdhd());
            row.add(hdDTO.getIdnv());
            row.add(hdDTO.getIdkh());
            row.add(hdDTO.getIdkm());
            row.add(hdDTO.getTotal());
            row.add(hdDTO.getCreatedat());
            model.addRow(row);
        }
        tablethongke.setModel(model);
    }
}


