/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ad
 */
public class kmDTO {
    private int idkm,phantram;

    public int getPhantram() {
        return phantram;
    }

    public void setPhantram(int phantram) {
        this.phantram = phantram;
    }
    private String tenkm;
    private String ngaybd,ngaykt;

    public kmDTO() {
    }

    public int getIdkm() {
        return idkm;
    }

    public void setIdkm(int idkm) {
        this.idkm = idkm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }
    
}
