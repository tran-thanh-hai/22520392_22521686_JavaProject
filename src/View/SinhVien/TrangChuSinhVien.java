/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.SinhVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.SinhVienHomeController;
import View.SinhVien.XemKhoa;
import View.SinhVien.XemLop;
import View.SinhVien.XemMonHoc;
import View.SinhVien.XemSinhVien;

/**
 *
 * @author rubik
 */
public class TrangChuSinhVien extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JButton btnKhoa;
    private JButton btnGiaoVien;
    private JButton btnSinhVien;
    private JButton btnMonHoc;
    private JButton btnLichGiangDay;
    private JButton btnDiemThi;
    private JButton btnLop;
    private JButton btnDangXuat;

    private SinhVienHomeController controller;

    public TrangChuSinhVien() {
        setTitle("Trang chủ sinh viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400); // Adjusted size
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new SinhVienHomeController(this);

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
        btnSinhVien = new JButton("Sinh Viên");
        buttonPanel.add(btnSinhVien, gbc);
        
        gbc.gridx = col++;
        gbc.gridy = row;
        btnLop = new JButton("Lớp");
        buttonPanel.add(btnLop, gbc);

        // Row 2
        row++;
        col = 0;
        gbc.gridx = col++;
        gbc.gridy = row;
        btnMonHoc = new JButton("Môn Học");
        buttonPanel.add(btnMonHoc, gbc);

        // Logout Button (positioned at bottom right)
        row++;
        col = 2; // Place in the rightmost column
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST; // Align to the east
        gbc.fill = GridBagConstraints.NONE; // Do not stretch horizontally
        btnDangXuat = new JButton("Đăng xuất");
        buttonPanel.add(btnDangXuat, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        // Add ActionListeners to buttons
        btnKhoa.addActionListener(this);
        btnSinhVien.addActionListener(this);
        btnLop.addActionListener(this);
        btnMonHoc.addActionListener(this);
        // btnLichGiangDay and btnDiemThi are not in this view
        btnDangXuat.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKhoa) {
            controller.navigateToXemKhoa();
        } else if (e.getSource() == btnSinhVien) {
            controller.navigateToXemSinhVien();
        } else if (e.getSource() == btnLop) {
            controller.navigateToXemLop();
        } else if (e.getSource() == btnMonHoc) {
            controller.navigateToXemMonHoc();
        } else if (e.getSource() == btnDangXuat) {
            controller.handleLogout();
        }
    }


}
