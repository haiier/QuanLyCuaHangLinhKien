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
public class thongkeDTO {
     private int idhd,idnv,idkh,idkm;
    private float total;
    private Date createdat;

    public thongkeDTO() {
    }

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public int getIdnv() {
        return idnv;
    }

    public void setIdnv(int idnv) {
        this.idnv = idnv;
    }

    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public int getIdkm() {
        return idkm;
    }

    public void setIdkm(int idkm) {
        this.idkm = idkm;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

//    public LocalDateTime getCreatedat() {
//        return createdat;
//    }
//
//    public void setCreatedat(LocalDateTime createdat) {
//        this.createdat = createdat;
//    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
    
}
