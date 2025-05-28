/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.NhaTruong.DangNhapNhaTruong;
import View.NhaTruong.TrangChuNhaTruong;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author rubik
 */
public class NhaTruongLoginController {

    private final DangNhapNhaTruong loginView;

    public NhaTruongLoginController(DangNhapNhaTruong loginView) {
        this.loginView = loginView;
    }

    // Ten dang nhap va Mat khau
    public void handleLogin(String username, String password) {
        if (username.equals("truong") && password.equals("truong")) { 
            SwingUtilities.invokeLater(() -> {
                TrangChuNhaTruong homeView = new TrangChuNhaTruong();
                homeView.setVisible(true);
                loginView.dispose(); 
            });
        } else {
            JOptionPane.showMessageDialog(loginView, "Tên đăng nhập hoặc mật khẩu không đúng.", "Lỗi Đăng Nhập", JOptionPane.ERROR_MESSAGE);
        }
    }
}
