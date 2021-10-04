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
public class phieunhapDTO {
    private String maphieunhap;
    private String manhanvien;
    private String nhacungcap;
    private Date ngaylap;
    private double tongtien;

    public phieunhapDTO() {
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
}
