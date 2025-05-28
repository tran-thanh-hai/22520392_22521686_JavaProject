package Controller;

import View.GiaoVien.QuanLyDiemThi;
import View.GiaoVien.QuanLyLop;
import View.GiaoVien.QuanLySinhVien;
import View.GiaoVien.XemKhoa;
import View.GiaoVien.XemLichGiang;
import View.GiaoVien.XemMonHoc;
import View.GiaoVien.TrangChuGiaoVien;

import javax.swing.JFrame;

public class GiaoVienHomeController {

    private JFrame currentFrame;

    public GiaoVienHomeController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    private void navigateTo(JFrame targetFrame) {
        currentFrame.dispose(); // Close the current frame
        targetFrame.setVisible(true); // Show the target frame
        currentFrame = targetFrame; // Update the current frame reference
    }

    public void navigateToTrangChu() {
        // Assumes a new instance is created, which might not be ideal if state needs to be preserved.
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
        // TODO: Implement logout logic
        System.out.println("Logout clicked");
        System.exit(0);
    }
} 