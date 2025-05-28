package Controller;

import View.SinhVien.XemKhoa;
import View.SinhVien.XemLop;
import View.SinhVien.XemMonHoc;
import View.SinhVien.XemSinhVien;
import View.SinhVien.TrangChuSinhVien;

import javax.swing.JFrame;

public class SinhVienHomeController {

    private JFrame currentFrame;

    public SinhVienHomeController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    private void navigateTo(JFrame targetFrame) {
        currentFrame.dispose(); // Close the current frame
        targetFrame.setVisible(true); // Show the target frame
        currentFrame = targetFrame; // Update the current frame reference
    }

    public void navigateToTrangChu() {
        // Assumes a new instance is created, which might not be ideal if state needs to be preserved.
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
        // TODO: Implement logout logic
        System.out.println("Logout clicked");
        System.exit(0);
    }
} 