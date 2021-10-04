/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoginBUS;
import BUS.nhanvienBUS;
import DAO.LoginDAO;
import DAO.LoginPattern;
import DTO.nhanvienDTO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
/**
 *
 * @author Admin
 */
public class GUI_LOGIN extends JPanel{

    private JTextField textField_username;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel;
    private ImageIcon image;
     private JLabel jl;
    public GUI_LOGIN() {
        setBackground(new Color(102, 102, 255));
        setLayout(null);
        setBounds(0, 0, 1400, 800);
        JPanel img=new JPanel();
        JPanel log = new JPanel();
        
        log.setBounds(530,100,400, 400);
        log.setBackground(new Color(255,255,255));
        log.setLayout(null);
        add(log);
        
        img.setBounds(130,100,400, 400);
        img.setBackground(new Color(255,255,255));
        img.setLayout(null);
        add(img);
        
        
//        jl.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\Image\\icons8_user_male_50px.png"));
        lblNewLabel = new JLabel("Đăng nhập");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(102, 102, 255));
        lblNewLabel.setBounds(50,70,300, 67);
        log.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Tên đăng nhập");
        lblNewLabel_1.setBounds(30,160, 94, 13);
        lblNewLabel_1.setForeground(new Color(102, 102, 255));

        log.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Mật khẩu");
        lblNewLabel_2.setBounds(30,230, 94, 13);
        lblNewLabel_2.setForeground(new Color(102, 102, 255));
        log.add(lblNewLabel_2);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 230, 180,30);
        log.add(passwordField);
        
        textField_username = new JTextField();
        textField_username.setBounds(150,160, 180,30);
        log.add(textField_username);
        textField_username.setColumns(10);
//        add(jl);
        btnNewButton = new JButton("Đăng nhập");
        btnNewButton.setBounds(150,300, 120, 26);
        btnNewButton.setBackground(new Color(102, 102, 255));
        log.add(btnNewButton);
        JLabel tit= new JLabel();
        tit.setBounds(15,-50,500,500);
        img.add(tit);
        try{
            Image imge=ImageIO.read(getClass().getResource("/resources/uselap.jpeg"));
        tit.setIcon(new ImageIcon(imge));
        }
        catch (Exception ex) {
         System.out.println(ex);
         }
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    login(evt);
                }
            });
        validate();
    }
    public void login(java.awt.event.ActionEvent evt){
        String username = textField_username.getText();
        String password = passwordField.getText();
        String loginbtn = btnNewButton.getText();        
        LoginBUS lgBUS = new LoginBUS();           
        if(loginbtn == "Đăng xuất"){
            LoginPattern.getInstance().logout();
            JOptionPane.showMessageDialog(new Frame(), "Đăng Xuất Thành Công");
            lblNewLabel.setText("Đăng nhập");
            textField_username.setText("");
            passwordField.setText("");
            lblNewLabel_1.setVisible(true);
            lblNewLabel_2.setVisible(true);
            textField_username.setVisible(true);
            passwordField.setVisible(true);
            btnNewButton.setText("Đăng nhập");
        }else{
            if(lgBUS.Login(username,password) == 1 && loginbtn == "Đăng nhập"){                  
                JOptionPane.showMessageDialog(new Frame(), "Đăng Nhập Thành Công");
                lblNewLabel_1.setVisible(false);
                lblNewLabel_2.setVisible(false);
                textField_username.setVisible(false);
                passwordField.setVisible(false);
                lblNewLabel.setText("Đăng xuất");
                btnNewButton.setText("Đăng xuất");
            }else{  
                JOptionPane.showMessageDialog(new Frame(), "Sai Tài Khoản Hoặc Mật Khẩu");

            }
        }
        
    }
}
