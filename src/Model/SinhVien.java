/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rubik
 */
public class SinhVien extends ThanhVien{
    private String maHV;
    private String maLop;
    private String noiSinh;
    private float diemTB;
    private String xepLoai;
    
    public SinhVien(){
        super();
    }
  
    public String getMaHV() {
        return maHV;
    }

    public String getMaLop() {
        return maLop;
    }


    public String getNoiSinh() {
        return noiSinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    // Setters
    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
}
