/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.DangNhapChungController;

/**
 *
 * @author rubik
 */
public class DangNhapChungView extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JButton btnTruong;
    private JButton btnGiaoVien;
    private JButton btnSinhVien;

    private DangNhapChungController controller;

    public DangNhapChungView() {
        setTitle("Đăng Nhập Chung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null); // Center the window
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Use FlowLayout with spacing

        controller = new DangNhapChungController(this);

        // Create components
        lblTitle = new JLabel("ĐĂNG NHẬP");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18)); // Set font for title

        btnTruong = new JButton("Dùng tài khoản trường");
        btnGiaoVien = new JButton("Dùng tài khoản giáo viên");
        btnSinhVien = new JButton("Dùng tài khoản sinh viên");

        // Add ActionListeners to buttons
        btnTruong.addActionListener(this);
        btnGiaoVien.addActionListener(this);
        btnSinhVien.addActionListener(this);

        // Add components to the frame
        add(lblTitle);
        add(btnTruong);
        add(btnGiaoVien);
        add(btnSinhVien);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTruong) {
            controller.handleTruongLogin();
        } else if (e.getSource() == btnGiaoVien) {
            controller.handleGiaoVienLogin();
        } else if (e.getSource() == btnSinhVien) {
            controller.handleSinhVienLogin();
        }
    }


}
