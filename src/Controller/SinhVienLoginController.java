/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.SinhVien.DangNhapSinhVien;
import View.SinhVien.TrangChuSinhVien;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author rubik
 */
public class SinhVienLoginController {

    private final DangNhapSinhVien loginView;

    public SinhVienLoginController(DangNhapSinhVien loginView) {
        this.loginView = loginView;
    }

    public void handleLogin(String username, String password) {
        // Ten dang nhap va Mat khau
        if (username.equals("sinhvien") && password.equals("sinhvien")) { 
            SwingUtilities.invokeLater(() -> {
                TrangChuSinhVien homeView = new TrangChuSinhVien();
                homeView.setVisible(true);
                loginView.dispose(); 
            });
        } else {
            JOptionPane.showMessageDialog(loginView, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
        }
    }
}
