package Controller;

import View.SinhVien.XemKhoa;
import View.SinhVien.XemLop;
import View.SinhVien.XemMonHoc;
import View.SinhVien.XemSinhVien;
import View.SinhVien.TrangChuSinhVien;
import View.DangNhapChungView;

import javax.swing.JFrame;

public class SinhVienHomeController {

    private JFrame currentFrame;

    public SinhVienHomeController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    private void navigateTo(JFrame targetFrame) {
        currentFrame.dispose(); 
        targetFrame.setVisible(true); 
        currentFrame = targetFrame; 
    }

    public void navigateToTrangChu() {
        navigateTo(new TrangChuSinhVien());
    }

    public void navigateToXemKhoa() {
        navigateTo(new XemKhoa());
    }

    public void navigateToXemLop() {
        navigateTo(new XemLop());
    }

    public void navigateToXemMonHoc() {
        navigateTo(new XemMonHoc());
    }

    public void navigateToXemSinhVien() {
        navigateTo(new XemSinhVien());
    }

    public void handleLogout() {
        navigateTo(new DangNhapChungView());
    }
} 