/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Object;

/**
 *
 * @author rubik
 */
public class MonHoc {
    private String maMH;
    private String tenMH;
    private int TCLT;
    private int TCTH;
    private String maKhoa;
    
    public MonHoc(){
        super();
    }
    
    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public int getTCLT() {
        return TCLT;
    }

    public int getTCTH() {
        return TCTH;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public void setTCLT(int TCLT) {
        this.TCLT = TCLT;
    }

    public void setTCTH(int TCTH) {
        this.TCTH = TCTH;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}
