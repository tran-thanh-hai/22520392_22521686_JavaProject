/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rubik
 */
public class DangNhapChung extends JFrame {

    private JLabel lblTitle;
    private JButton btnTruong;
    private JButton btnGiaoVien;
    private JButton btnSinhVien;

    public DangNhapChung() {
        setTitle("Đăng Nhập Chung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null); // Center the window
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Use FlowLayout with spacing

        // Create components
        lblTitle = new JLabel("ĐĂNG NHẬP");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18)); // Set font for title

        btnTruong = new JButton("Dùng tài khoản trường");
        btnGiaoVien = new JButton("Dùng tài khoản giáo viên");
        btnSinhVien = new JButton("Dùng tài khoản sinh viên");

        // Add components to the frame
        add(lblTitle);
        add(btnTruong);
        add(btnGiaoVien);
        add(btnSinhVien);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DangNhapChung().setVisible(true);
        });
    }
}
