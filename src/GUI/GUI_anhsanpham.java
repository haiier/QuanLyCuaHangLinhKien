/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.sanphamBUS;
import DTO.sanphamDTO;
import java.awt.Component;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Admin
 */
public class GUI_anhsanpham implements TableCellRenderer {

    public String hinhanh;
    public int row2;

    public GUI_anhsanpham(String hinhanh, int row2) {
        this.hinhanh = hinhanh;
        this.row2 = row2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel cell = new JLabel();
            if (column == 0 && row == row2) {
                URL flagUrl = GUI_anhsanpham.class.getResource(hinhanh);
                ImageIcon flagIcon = new ImageIcon(flagUrl);
                cell.setIcon(flagIcon);
            }
            else{
                
            }
   
        return cell;
    }
}
