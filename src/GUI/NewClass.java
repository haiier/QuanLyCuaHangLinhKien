/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ad
 */
public class NewClass extends JFrame{
    JLabel ImageLabel;
    ImageIcon imageicon;
    void NewClass(){
        setVisible(true);
        ImageLabel = new JLabel();
        ImageLabel.setBounds(0, 0, 800,500);
        ImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("asusrogphone2.png")));
        setLayout(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        this.add(ImageLabel);
    }
    public static void main(String[] args) {
        NewClass nc= new NewClass();
        nc.NewClass();
    }
}
