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

import javax.swing.JFrame;

/**
 *
 * @author rubik
 */
public class NhaTruongHomeController {

    private TrangChuNhaTruong trangChuNhaTruong;
    private JFrame currentFrame;

    public NhaTruongHomeController(TrangChuNhaTruong trangChuNhaTruong) {
        this.trangChuNhaTruong = trangChuNhaTruong;
        this.currentFrame = trangChuNhaTruong;
    }

    private void navigateTo(JFrame targetFrame) {
        currentFrame.dispose(); // Close the current frame
        targetFrame.setVisible(true); // Show the target frame
        currentFrame = targetFrame; // Update the current frame reference
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
         // Assumes a new instance of TrangChuNhaTruong is created, 
         // which might not be ideal if state needs to be preserved.
         // A better approach would be to pass the existing instance 
         // or use a more sophisticated navigation system.
        navigateTo(new TrangChuNhaTruong());
    }

    public void handleLogout() {
        // TODO: Implement logout logic
        System.out.println("Logout clicked");
        System.exit(0);
    }
}
