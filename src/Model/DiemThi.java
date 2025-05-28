/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rubik
 */
public class DiemThi {
    private String maHV;
    private String maMH;
    private int lanThi;
    private String ngThi;
    private float diem;
    private String ketQua;
    
    public DiemThi(){
        super();
    }
    
    public String getMaHV() {
        return maHV;
    }

    public String getMaMH() {
        return maMH;
    }

    public int getLanThi() {
        return lanThi;
    }

    public String getNgThi() {
        return ngThi;
    }

    public float getDiem() {
        return diem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setLanThi(int lanThi) {
        this.lanThi = lanThi;
    }

    public void setNgThi(String ngThi) {
        this.ngThi = ngThi;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
}
