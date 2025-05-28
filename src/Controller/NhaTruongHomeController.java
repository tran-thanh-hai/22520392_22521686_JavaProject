/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.NhaTruong.QuanLyDiemThi;
import View.NhaTruong.QuanLyGiaoVien;
import View.NhaTruong.QuanLyKhoa;
import View.NhaTruong.QuanLyLichGiang;
import View.NhaTruong.QuanLyLop;
import View.NhaTruong.QuanLyMonHoc;
import View.NhaTruong.QuanLySinhVien;
import View.NhaTruong.TrangChuNhaTruong;
import View.DangNhapChungView;

import javax.swing.JFrame;

/**
 *
 * @author rubik
 */
public class NhaTruongHomeController {

    private JFrame currentFrame;

    public NhaTruongHomeController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    private void navigateTo(JFrame targetFrame) {
        currentFrame.dispose(); 
        targetFrame.setVisible(true); 
        currentFrame = targetFrame; 
    }

    public void navigateToQuanLyKhoa() {
        navigateTo(new QuanLyKhoa());
    }

    public void navigateToQuanLyGiaoVien() {
        navigateTo(new QuanLyGiaoVien());
    }

    public void navigateToQuanLySinhVien() {
        navigateTo(new QuanLySinhVien());
    }

    public void navigateToQuanLyMonHoc() {
        navigateTo(new QuanLyMonHoc());
    }

    public void navigateToQuanLyLichGiang() {
        navigateTo(new QuanLyLichGiang());
    }

    public void navigateToQuanLyDiemThi() {
        navigateTo(new QuanLyDiemThi());
    }

    public void navigateToQuanLyLop() {
        navigateTo(new QuanLyLop());
    }

    public void navigateToTrangChu() {
        navigateTo(new TrangChuNhaTruong());
    }

    public void handleLogout() {
        navigateTo(new DangNhapChungView());
    }
}
