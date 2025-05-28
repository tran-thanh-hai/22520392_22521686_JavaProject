/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.GiaoVien.DangNhapGiaoVien;
import View.GiaoVien.TrangChuGiaoVien;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author rubik
 */
public class GiaoVienLoginController {

    private final DangNhapGiaoVien loginView;

    public GiaoVienLoginController(DangNhapGiaoVien loginView) {
        this.loginView = loginView;
    }

    // Ten dang nhap va Mat khau
    public void handleLogin(String username, String password) {
        if (username.equals("giaovien") && password.equals("giaovien")) { 
            SwingUtilities.invokeLater(() -> {
                TrangChuGiaoVien homeView = new TrangChuGiaoVien();
                homeView.setVisible(true);
                loginView.dispose(); 
            });
        } else {
            JOptionPane.showMessageDialog(loginView, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
        }
    }
}
