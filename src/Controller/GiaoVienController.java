/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.GiaoVien.DangNhapGiaoVien;
import View.GiaoVien.TrangChuGiaoVien;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author rubik
 */
public class GiaoVienController {

    private DangNhapGiaoVien loginView;

    public GiaoVienController(DangNhapGiaoVien loginView) {
        this.loginView = loginView;
    }

    public void handleLogin(String username, String password) {
        // Placeholder login logic
        // In a real application, you would interact with a Model (e.g., database) here
        if (username.equals("giaovien") && password.equals("giaovien")) { // Example credentials
            SwingUtilities.invokeLater(() -> {
                TrangChuGiaoVien homeView = new TrangChuGiaoVien();
                homeView.setVisible(true);
                loginView.dispose(); // Close login window
            });
        } else {
            JOptionPane.showMessageDialog(loginView, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
        }
    }
}
