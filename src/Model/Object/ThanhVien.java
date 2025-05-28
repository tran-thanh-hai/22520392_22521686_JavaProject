/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Object;

/**
 *
 * @author rubik
 */
public abstract class ThanhVien {
    private String hoTen;
    private String chucVu;
    private String gioiTinh;
    private String ngaySinh;
    
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
    public void setNgaySinh(String a){
        this.ngaySinh = a;
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
    public String getNgaySinh(){
        return this.ngaySinh;
    }

    public String getThongTinChung() {
        return String.format("Họ tên: %s, Giới tính: %s, Ngày sinh: %s, Chức vụ: %s",
                           hoTen, gioiTinh, ngaySinh, chucVu);
    }

    public abstract String getMa();
    public abstract String getLoaiThanhVien();
}
