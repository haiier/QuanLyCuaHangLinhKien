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
public class khachhangDTO {
    private int idkh;
    private String hokh;
    private String tenkh;
    private String phonekh;
    private String addresskh;
    private String gender;

    public khachhangDTO() {
    }

    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public String getHokh() {
        return hokh;
    }

    public void setHokh(String hokh) {
        this.hokh = hokh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getPhonekh() {
        return phonekh;
    }

    public void setPhonekh(String phonekh) {
        this.phonekh = phonekh;
    }

    public String getAddresskh() {
        return addresskh;
    }

    public void setAddresskh(String addresskh) {
        this.addresskh = addresskh;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}
