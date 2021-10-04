/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ad
 */
public class nhanvienDTO {
    private String tennv;
    private String honv;
    private int idnv;
    private String phonenv;
    private String addressnv;
    private float luongnv;
    private String gender;
    private String passwordnv;
    private String chucvu;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public nhanvienDTO() {
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getHonv() {
        return honv;
    }

    public void setHonv(String honv) {
        this.honv = honv;
    }

    public int getIdnv() {
        return idnv;
    }

    public void setIdnv(int idnv) {
        this.idnv = idnv;
    }

    public String getPhonenv() {
        return phonenv;
    }

    public void setPhonenv(String phonenv) {
        this.phonenv = phonenv;
    }

    public String getAddressnv() {
        return addressnv;
    }

    public void setAddressnv(String addressnv) {
        this.addressnv = addressnv;
    }

    public float getLuongnv() {
        return luongnv;
    }

    public void setLuongnv(float luongnv) {
        this.luongnv = luongnv;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPasswordnv() {
        return passwordnv;
    }

    public void setPasswordnv(String passwordnv) {
        this.passwordnv = passwordnv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
}
