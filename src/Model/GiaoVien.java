/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rubik
 */
public class GiaoVien extends ThanhVien{
    private String maGV;
    private String maKhoa;
    private String ngVaoLam;
    private float heSoLuong;
    private float luongCoBan;
    private float luong;
    
    public GiaoVien(){
        super();
    }
    
    
    public String getMaGV() {
        return maGV;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public String getNgVaoLam() {
        return ngVaoLam;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public float getLuong() {
        return luong;
    }

    
    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setNgVaoLam(String ngVaoLam) {
        this.ngVaoLam = ngVaoLam;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
}
