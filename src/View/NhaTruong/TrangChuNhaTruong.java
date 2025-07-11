/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.NhaTruongHomeController;

/**
 *
 * @author rubik
 */
public class TrangChuNhaTruong extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JButton btnKhoa;
    private JButton btnGiaoVien;
    private JButton btnSinhVien;
    private JButton btnMonHoc;
    private JButton btnLichGiangDay;
    private JButton btnDiemThi;
    private JButton btnLop;
    private JButton btnDangXuat;

    private NhaTruongHomeController controller;

    public TrangChuNhaTruong() {
        setTitle("Trang chủ Nhà Trường");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400); // Adjusted size
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);

        // Title Label
        lblTitle = new JLabel("Trang chủ", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add buttons to panel using GridBagLayout
        int row = 0;
        int col = 0;

        // Row 1
        gbc.gridx = col++;
        gbc.gridy = row;
        btnKhoa = new JButton("Khoa");
        buttonPanel.add(btnKhoa, gbc);

        gbc.gridx = col++;
        gbc.gridy = row;
        btnGiaoVien = new JButton("Giáo Viên");
        buttonPanel.add(btnGiaoVien, gbc);

        gbc.gridx = col++;
        gbc.gridy = row;
        btnSinhVien = new JButton("Sinh Viên");
        buttonPanel.add(btnSinhVien, gbc);

        // Row 2
        row++;
        col = 0;
        gbc.gridx = col++;
        gbc.gridy = row;
        btnMonHoc = new JButton("Môn Học");
        buttonPanel.add(btnMonHoc, gbc);

        gbc.gridx = col++;
        gbc.gridy = row;
        btnLichGiangDay = new JButton("Lịch Giảng Dạy");
        buttonPanel.add(btnLichGiangDay, gbc);

        gbc.gridx = col++;
        gbc.gridy = row;
        btnDiemThi = new JButton("Điểm Thi");
        buttonPanel.add(btnDiemThi, gbc);

        // Row 3
        row++;
        col = 0;
        gbc.gridx = col++;
        gbc.gridy = row;
        btnLop = new JButton("Lớp");
        buttonPanel.add(btnLop, gbc);

        // Logout Button (positioned at bottom right)
        row++;
        col = 2; // Place in the rightmost column
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST; // Align to the east
        gbc.fill = GridBagConstraints.NONE; // Do not stretch horizontally
        btnDangXuat = new JButton("Đăng xuất");
        buttonPanel.add(btnDangXuat, gbc);

        // Add ActionListeners to buttons
        btnKhoa.addActionListener(this);
        btnGiaoVien.addActionListener(this);
        btnSinhVien.addActionListener(this);
        btnMonHoc.addActionListener(this);
        btnLichGiangDay.addActionListener(this);
        btnDiemThi.addActionListener(this);
        btnLop.addActionListener(this);
        btnDangXuat.addActionListener(this);

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKhoa) {
            controller.navigateToQuanLyKhoa();
        } else if (e.getSource() == btnGiaoVien) {
            controller.navigateToQuanLyGiaoVien();
        } else if (e.getSource() == btnSinhVien) {
            controller.navigateToQuanLySinhVien();
        } else if (e.getSource() == btnMonHoc) {
            controller.navigateToQuanLyMonHoc();
        } else if (e.getSource() == btnLichGiangDay) {
            controller.navigateToQuanLyLichGiang();
        } else if (e.getSource() == btnDiemThi) {
            controller.navigateToQuanLyDiemThi();
        } else if (e.getSource() == btnLop) {
            controller.navigateToQuanLyLop();
        } else if (e.getSource() == btnDangXuat) {
            controller.handleLogout();
        }
    }


}
