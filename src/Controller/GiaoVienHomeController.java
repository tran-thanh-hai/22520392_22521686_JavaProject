package Controller;

import View.GiaoVien.QuanLyDiemThi;
import View.GiaoVien.QuanLyLop;
import View.GiaoVien.QuanLySinhVien;
import View.GiaoVien.XemKhoa;
import View.GiaoVien.XemLichGiang;
import View.GiaoVien.XemMonHoc;
import View.GiaoVien.TrangChuGiaoVien;
import View.DangNhapChungView;

import javax.swing.JFrame;

public class GiaoVienHomeController {

    private JFrame currentFrame;

    public GiaoVienHomeController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    private void navigateTo(JFrame targetFrame) {
        currentFrame.dispose();
        targetFrame.setVisible(true);
        currentFrame = targetFrame; 
    }

    public void navigateToTrangChu() {
        navigateTo(new TrangChuGiaoVien());
    }

    public void navigateToQuanLyDiemThi() {
        navigateTo(new QuanLyDiemThi());
    }

    public void navigateToQuanLyLop() {
        navigateTo(new QuanLyLop());
    }

    public void navigateToQuanLySinhVien() {
        navigateTo(new QuanLySinhVien());
    }

    public void navigateToXemKhoa() {
        navigateTo(new XemKhoa());
    }

    public void navigateToXemLichGiang() {
        navigateTo(new XemLichGiang());
    }

    public void navigateToXemMonHoc() {
        navigateTo(new XemMonHoc());
    }

    public void handleLogout() {
        navigateTo(new DangNhapChungView());
    }
} 