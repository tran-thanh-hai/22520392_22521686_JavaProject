/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rubik
 */
public class ThanhVien {
    private String hoTen;
    private String chucVu;
    private String gioiTinh;
    
    public ThanhVien(){
        super();
    }
    public void setHoTen(String a){
        this.hoTen = a;
    }
    public void setChucVu(String a){
        this.chucVu = a;
    }
    public void setGioiTinh(String a){
        this.gioiTinh = a;
    }
    public String getHoTen (){
        return this.hoTen;
    }
    public String getGioiTinh (){
        return this.gioiTinh;
    }
    public String getChucVu (){
        return this.chucVu;
    }
}
