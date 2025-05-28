package Controller;

import View.NhaTruong.DangNhapNhaTruong;
import View.GiaoVien.DangNhapGiaoVien;
import View.SinhVien.DangNhapSinhVien;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DangNhapChungController {

    private final JFrame currentFrame;

    public DangNhapChungController(JFrame currentFrame) {
        this.currentFrame = currentFrame;
    }

    public void handleTruongLogin() {
        SwingUtilities.invokeLater(() -> {
            DangNhapNhaTruong nhaTruongLoginFrame = new View.NhaTruong.DangNhapNhaTruong();
            nhaTruongLoginFrame.setVisible(true);
            currentFrame.dispose(); 
        });
    }

    public void handleGiaoVienLogin() {
         SwingUtilities.invokeLater(() -> {
            View.GiaoVien.DangNhapGiaoVien giaoVienLoginFrame = new View.GiaoVien.DangNhapGiaoVien();
            giaoVienLoginFrame.setVisible(true);
            currentFrame.dispose(); 
        });
    }

    public void handleSinhVienLogin() {
         SwingUtilities.invokeLater(() -> {
            View.SinhVien.DangNhapSinhVien sinhVienLoginFrame = new View.SinhVien.DangNhapSinhVien();
            sinhVienLoginFrame.setVisible(true);
            currentFrame.dispose(); 
        });
    }
} 