/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Admin
 */
import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DAO.LoginPattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Admin extends JFrame {

    private JPanel contentPane;
    JButton btnNewButton_5;
    GUI_DSnhanvien nv = new GUI_DSnhanvien();
    GUI_DSkhachhang kh = new GUI_DSkhachhang();
    GUI_DSsanpham sp;
    GUI_LOGIN login = new GUI_LOGIN();
    GUI_khuyenmai km = new GUI_khuyenmai();
    GUI_hoadon hd = new GUI_hoadon();
    GUI_Brand br = new GUI_Brand();
    GUI_thongke tk = new GUI_thongke();

    public Admin() {
        this.sp = new GUI_DSsanpham();
    }

    public void frame() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 40, 1350, 800);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setVisible(true);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(102,0,153));
        panel.setLayout(new BorderLayout(3, 1));
        panel.setPreferredSize(new Dimension(this.getWidth(), 60));
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel, BorderLayout.CENTER);

        JButton btn_close = new JButton();
        panel.add(btn_close, BorderLayout.EAST);
        btn_close.setSize(new Dimension(30,30));
        btn_close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 180, 800);
        panel_3.add(panel_1);
        panel_1.setBackground(new Color(0,0,0));
        panel_1.setLayout(null);
        
        JLabel ava= new JLabel();
        ava.setBounds(10, 30,160, 100);
        panel_1.add(ava);
        
        JLabel tit= new JLabel();
        tit.setBounds(530,0,1000,60);
        lblNewLabel.add(tit);
        
        btnNewButton_5 = new JButton("Đăng nhập");
        btnNewButton_5.setBounds(10, 166,160, 35);
        btnNewButton_5.setBackground(new Color(255,255,0));
        panel_1.add(btnNewButton_5);
        btnNewButton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_5ActionPerformed(evt);
            }
        });

        
        JButton btnNewButton_1 = new JButton("DS nhân viên");
        btnNewButton_1.setBounds(10, 228,160, 35);
        panel_1.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_1ActionPerformed(evt);
            }
        });

        JButton btnNewButton = new JButton("DS khách hàng");
        btnNewButton.setBounds(10, 290,160, 35);
        btnNewButton.setBackground(new Color(255,255,0));
        panel_1.add(btnNewButton);
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
            }
        });

        JButton btnNewButton_2 = new JButton("Hóa đơn khách hàng");
        btnNewButton_2.setBounds(10, 352,160, 35);
        panel_1.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_2ActionPerformed(evt);
            }
        });

        JButton btnNewButton_4 = new JButton("Khuyến mãi");
        btnNewButton_4.setBounds(10, 414,160, 35);
        btnNewButton_4.setBackground(new Color(255,255,0));
        panel_1.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_4ActionPerformed(evt);
            }
        });

        JButton btnNewButton_3 = new JButton("DS sản phẩm");
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnNewButton_3.setBounds(10, 476,160, 35);
        panel_1.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnNewButton_3ActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton btnNewButton_6 = new JButton("Brand");
        btnNewButton_6.setBounds(10, 538,160,35);
        btnNewButton_6.setBackground(new Color(255,255,0));
        panel_1.add(btnNewButton_6);
        btnNewButton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_6ActionPerformed(evt);
            }
        });

        JButton btnNewButton_7 = new JButton("Thống kê");
        btnNewButton_7.setBounds(10, 600,160, 35);
        panel_1.add(btnNewButton_7);
        btnNewButton_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_7ActionPerformed(evt);
            }
        });
        try {
        Image img1 = ImageIO.read(getClass().getResource("/resources/thongke.png"));
        btnNewButton_7.setIcon(new ImageIcon(img1));
        Image img2 = ImageIO.read(getClass().getResource("/resources/dssnv.png"));
        btnNewButton_1.setIcon(new ImageIcon(img2));
        Image img3 = ImageIO.read(getClass().getResource("/resources/bill.png"));
        btnNewButton_2.setIcon(new ImageIcon(img3));
        Image img4 = ImageIO.read(getClass().getResource("/resources/icons8_add_30px_2.png"));
        btnNewButton_3.setIcon(new ImageIcon(img4));
        Image img5 = ImageIO.read(getClass().getResource("/resources/km.png"));
        btnNewButton_4.setIcon(new ImageIcon(img5));
        Image img6= ImageIO.read(getClass().getResource("/resources/dskh.png"));
        btnNewButton.setIcon(new ImageIcon(img6));
        Image img7= ImageIO.read(getClass().getResource("/resources/login1.png"));
        btnNewButton_5.setIcon(new ImageIcon(img7));
        Image img8= ImageIO.read(getClass().getResource("/resources/brand.png"));
        btnNewButton_6.setIcon(new ImageIcon(img8));
        Image img9=ImageIO.read(getClass().getResource("/resources/laptop.png"));
        ava.setIcon(new ImageIcon(img9));
        Image imge=ImageIO.read(getClass().getResource("/resources/tit.png"));
        tit.setIcon(new ImageIcon(imge));
        Image imges=ImageIO.read(getClass().getResource("/resources/close.png"));
        btn_close.setIcon(new ImageIcon(imges));
        } catch (Exception ex) {
         System.out.println(ex);
         }
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.PINK);
        panel_2.setBounds(180, 0, 1200, 800);
        panel_3.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));
        panel_2.add(nv);
        panel_2.add(kh);
        panel_2.add(sp);
        panel_2.add(login);
        panel_2.add(km);
        panel_2.add(hd);
        panel_2.add(br);
        panel_2.add(tk);
        nv.setPreferredSize(new Dimension(660, 530));
        nv.setVisible(false);
        kh.setVisible(false);
        sp.setVisible(false);
        km.setVisible(false);
        hd.setVisible(false);
        br.setVisible(false);
        login.setVisible(true);
        tk.setVisible(false);
    }

    private void btnNewButton_1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (LoginPattern.getInstance().getUser() != null) {
            
            nv.setVisible(true);
            kh.setVisible(false);
            sp.setVisible(false);
            login.setVisible(false);
            km.setVisible(false);
            hd.setVisible(false);
            br.setVisible(false);
            tk.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (LoginPattern.getInstance().getUser() != null) {
            kh.setVisible(true);
            nv.setVisible(false);
            sp.setVisible(false);
            login.setVisible(false);
            km.setVisible(false);
            hd.setVisible(false);
            br.setVisible(false);
            tk.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    private void btnNewButton_3ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        if (LoginPattern.getInstance().getUser() != null) {
            sp.setVisible(true);
            nv.setVisible(false);
            kh.setVisible(false);
            login.setVisible(false);
            km.setVisible(false);
            hd.setVisible(false);
            br.setVisible(false);
            tk.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    private void btnNewButton_5ActionPerformed(java.awt.event.ActionEvent evt) {
        
        login.setVisible(true);
        sp.setVisible(false);
        nv.setVisible(false);
        kh.setVisible(false);
        km.setVisible(false);
        hd.setVisible(false);
        br.setVisible(false);
        tk.setVisible(false);
    }

    private void btnNewButton_4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (LoginPattern.getInstance().getUser() != null) {
            km.setVisible(true);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(false);
            login.setVisible(false);
            hd.setVisible(false);
            br.setVisible(false);
            tk.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    private void btnNewButton_2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (LoginPattern.getInstance().getUser() != null) {
            hd.setVisible(true);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(false);
            login.setVisible(false);
            km.setVisible(false);
            br.setVisible(false);
            tk.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    private void btnNewButton_6ActionPerformed(java.awt.event.ActionEvent evt) {
        if (LoginPattern.getInstance().getUser() != null) {
            br.setVisible(true);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(false);
            login.setVisible(false);
            km.setVisible(false);
            hd.setVisible(false);
            tk.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    private void btnNewButton_7ActionPerformed(java.awt.event.ActionEvent evt) {
        if (LoginPattern.getInstance().getUser() != null) {
            tk.setVisible(true);
            br.setVisible(false);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(false);
            login.setVisible(false);
            km.setVisible(false);
            hd.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(new Frame(), "Bạn Cần Phải Đăng Nhập Để Vào Được Chức Năng Này");
        }
    }

    public static void main(String[] args) {
        Admin ad = new Admin();
        ad.setUndecorated(true);
        ad.frame();
    }
}
