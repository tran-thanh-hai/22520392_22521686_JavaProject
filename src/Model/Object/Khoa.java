/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Object;

/**
 *
 * @author rubik
 */
public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private String ngThanhLap;
    private String trgKhoa;
    
    public Khoa(){
        super();
    }
    
    public String getMaKhoa() {
        return maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public String getNgThanhLap() {
        return ngThanhLap;
    }

    public String getTrgKhoa() {
        return trgKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void setNgThanhLap(String ngThanhLap) {
        this.ngThanhLap = ngThanhLap;
    }

    public void setTrgKhoa(String trgKhoa) {
        this.trgKhoa = trgKhoa;
    }
}
