/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BrandBUS;
import DTO.BrandDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUI_Brand extends JPanel {

    DefaultTableModel model = new DefaultTableModel();
    private JTable tablebrand;
    private JTextField textField_tenbrand;

    /**
     * Create the panel.
     */
    public GUI_Brand() {
        setLayout(null);
        setBounds(0, 0, 1400, 800);
        setBackground(new Color(152, 152, 103));

        tablebrand = new JTable();
        tablebrand.setModel(new DefaultTableModel(
                new Object[][]{
                    {null},
                    {null},},
                new String[]{
                    "Brand"
                }
        ));
        tablebrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);                
            }
        });
        
         JPanel img=new JPanel();
        JPanel log = new JPanel();
        
        log.setBounds(670,100,450, 400);
        log.setBackground(new Color(255,255,255));
        log.setLayout(null);
        add(log);
        
        img.setBounds(270,100,400, 400);
        img.setBackground(new Color(255,255,255));
        img.setLayout(null);
        add(img);

        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20,40, 350,300);
        scrollPane.setViewportView(tablebrand);
        img.add(scrollPane);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 231, 800);
        this.add(panel);
        panel.setLayout(null);

        textField_tenbrand = new JTextField();
        textField_tenbrand.setBounds(109, 99, 120, 20);
        panel.add(textField_tenbrand);
        textField_tenbrand.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Tên Brand");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(0, 99, 100, 20);
        panel.add(lblNewLabel);
        
        JButton btnNewButton_them = new JButton("Thêm");
        btnNewButton_them.setBounds(20, 195, 200,30);
        panel.add(btnNewButton_them);
        btnNewButton_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        

        JButton btnNewButton_sua = new JButton("Sửa");
        btnNewButton_sua.setBounds(20,257,200,30);
        panel.add(btnNewButton_sua);
        btnNewButton_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnUpdateActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_xoa = new JButton("Xóa");
        btnNewButton_xoa.setBounds(20, 226,200,30);
        panel.add(btnNewButton_xoa);
        btnNewButton_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        

        JButton btnNewButton_doc = new JButton("Đọc");
        btnNewButton_doc.setBounds(20,289,200,30);
        panel.add(btnNewButton_doc);
        JLabel tit= new JLabel();
        tit.setBounds(0,0,400,400);
        log.add(tit);
        try{
         Image imge=ImageIO.read(getClass().getResource("/resources/ul.jpg"));
        tit.setIcon(new ImageIcon(imge));
         Image img1 = ImageIO.read(getClass().getResource("/resources/them.png"));
        btnNewButton_them.setIcon(new ImageIcon(img1));
        Image img2 = ImageIO.read(getClass().getResource("/resources/sua.png"));
        btnNewButton_sua.setIcon(new ImageIcon(img2));
        Image img3 = ImageIO.read(getClass().getResource("/resources/xoa.png"));
        btnNewButton_xoa.setIcon(new ImageIcon(img3));
        Image img4 = ImageIO.read(getClass().getResource("/resources/doc.png"));
        btnNewButton_doc.setIcon(new ImageIcon(img4));
        }
        catch (Exception ex) {
         System.out.println(ex);
         }
        btnNewButton_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDocActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_DSkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
    }
        public void btnXoaActionPerformed (java.awt.event.ActionEvent evt){
        int i = tablebrand.getSelectedRow();
        String s = tablebrand.getModel().getValueAt(i, 0).toString();
        BrandBUS khBUS = new BrandBUS();
        if(khBUS.delete(s)){
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
        }
        if(i>=0){
            model.removeRow(i);
            tablebrand.setModel(model);
        }
    }
    public void btnThemActionPerformed (java.awt.event.ActionEvent evt){
        BrandDTO brDTO = new BrandDTO();
        brDTO.setTen_brand(textField_tenbrand.getText());
        BrandBUS khBUS = new BrandBUS();
        if(khBUS.add(brDTO)){
            Vector header = new Vector();
            header.add("Tên Brand");                       
            if(model.getRowCount() == 0){
                model = new DefaultTableModel(header,0);//dữ liệu rỗng
            }
            //nạp dữ liệu cho mỗi row
                //mỗi lần nạp sẽ tạo 1 vector row chứa dữ liệu
            Vector row = new Vector();
            // add những thông tin từ textfield
            row.add(textField_tenbrand.getText());            
            //add row vào model
            model.addRow(row);
            //add model vào jtable
            tablebrand.setModel(model);
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
        }
    }
    private void TableMouseClicked(java.awt.event.MouseEvent evt){
        int i = tablebrand.getSelectedRow();
        textField_tenbrand.setText(tablebrand.getModel().getValueAt(i,0).toString());
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{
        int i = tablebrand.getSelectedRow();
        String s = tablebrand.getModel().getValueAt(i, 0).toString();
        BrandBUS brBUS = new BrandBUS();
        BrandDTO brDTO = new BrandDTO();
        brDTO.setTen_brand(textField_tenbrand.getText());       
        if(brBUS.update(brDTO, s)){
            btnDocActionPerformed(evt);
            JOptionPane.showMessageDialog(new Frame(), "Thành Công");
        }else{
            JOptionPane.showMessageDialog(new Frame(), "Không Thành Công");
        }
    }
        private void btnDocActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_btnSuaActionPerformed
        BrandBUS bus = new BrandBUS();
        bus.docDSBR();
        Vector header = new Vector();
        header.add("Tên brand");        
        model = new DefaultTableModel(header,0);
        for(BrandDTO br: BrandBUS.dsbr){
            Vector row = new Vector();
            // add những thông tin từ textfield
            row.add(br.getTen_brand());                                            
            //add row vào model
            model.addRow(row);
        }
        tablebrand.setModel(model);
    }
}
