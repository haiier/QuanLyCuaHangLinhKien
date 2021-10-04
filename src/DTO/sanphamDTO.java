package DTO;

public class sanphamDTO {
    private int idsp,loaisp;
    private String tensp;
    private int soluongsp;    
    private int idbrand;
    private String hinhanhsp;
    private String tenbrand;

    public String getTenbrand() {
        return tenbrand;
    }

    public void setTenbrand(String tenbrand) {
        this.tenbrand = tenbrand;
    }
   
    public sanphamDTO(){
        
    }



    public int getIdsp() {
        return idsp;
    }
    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }



    public int getLoaisp() {
        return loaisp;
    }



    public void setLoaisp(int loaisp) {
        this.loaisp = loaisp;
    }



    public String getTensp() {
        return tensp;
    }



    public void setTensp(String tensp) {
        this.tensp = tensp;
    }



    public int getSoluongsp() {
        return soluongsp;
    }



    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }



    



    public int getIdbrand() {
        return idbrand;
    }

    public String getHinhanhsp() {
        return hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        this.hinhanhsp = hinhanhsp;
    }



    public void setIdbrand(int idbrand) {
        this.idbrand = idbrand;
    }
}