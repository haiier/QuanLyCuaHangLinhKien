/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class ctpnDTO {
    private String maphieunhap;
    private String masanpham;
    private double giasanpham;
    private int soluong;
    private double tongtien;

    public ctpnDTO() {
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    public void setGiasanpham(double giasanpham) {
        this.giasanpham = giasanpham;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
    public String getMaphieunhap() {
        return maphieunhap;
    }

    public String getMasanpham() {
        return masanpham;
    }

    public double getGiasanpham() {
        return giasanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public double getTongtien() {
        return tongtien;
    }
}
