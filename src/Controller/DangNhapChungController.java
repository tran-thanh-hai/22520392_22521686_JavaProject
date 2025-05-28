package Controller;

import View.NhaTruong.DangNhapNhaTruong;
import View.GiaoVien.DangNhapGiaoVien;
import View.SinhVien.DangNhapSinhVien;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DangNhapChungController {

    private JFrame currentFrame;

    public DangNhapChungController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    public void handleTruongLogin() {
        // Logic to open the NhaTruong login screen
        SwingUtilities.invokeLater(() -> {
            DangNhapNhaTruong nhaTruongLoginFrame = new View.NhaTruong.DangNhapNhaTruong();
            nhaTruongLoginFrame.setVisible(true);
            currentFrame.dispose(); // Close the current frame
        });
    }

    public void handleGiaoVienLogin() {
        // Logic to open the GiaoVien login screen
         SwingUtilities.invokeLater(() -> {
            View.GiaoVien.DangNhapGiaoVien giaoVienLoginFrame = new View.GiaoVien.DangNhapGiaoVien();
            giaoVienLoginFrame.setVisible(true);
            currentFrame.dispose(); // Close the current frame
        });
    }

    public void handleSinhVienLogin() {
        // Logic to open the SinhVien login screen
         SwingUtilities.invokeLater(() -> {
            View.SinhVien.DangNhapSinhVien sinhVienLoginFrame = new View.SinhVien.DangNhapSinhVien();
            sinhVienLoginFrame.setVisible(true);
            currentFrame.dispose(); // Close the current frame
        });
    }
} 