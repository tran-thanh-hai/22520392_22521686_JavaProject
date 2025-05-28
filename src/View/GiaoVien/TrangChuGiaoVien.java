/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.GiaoVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.GiaoVienHomeController;
import View.GiaoVien.QuanLyDiemThi;
import View.GiaoVien.QuanLyLop;
import View.GiaoVien.QuanLySinhVien;
import View.GiaoVien.XemKhoa;
import View.GiaoVien.XemLichGiang;
import View.GiaoVien.XemMonHoc;

/**
 *
 * @author rubik
 */
public class TrangChuGiaoVien extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JButton btnKhoa;
    private JButton btnGiaoVien;
    private JButton btnSinhVien;
    private JButton btnMonHoc;
    private JButton btnLichGiangDay;
    private JButton btnDiemThi;
    private JButton btnLop;
    private JButton btnDangXuat;

    private GiaoVienHomeController controller;

    public TrangChuGiaoVien() {
        setTitle("Trang chủ giáo viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);  
        setLocationRelativeTo(null);  
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);

 
        lblTitle = new JLabel("Trang chủ", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

 
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  
        gbc.fill = GridBagConstraints.HORIZONTAL;

    
        int row = 0;
        int col = 0;

 
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

       
        


        row++;
        col = 2; 
        gbc.gridx = col;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST; 
        gbc.fill = GridBagConstraints.NONE; 
        btnDangXuat = new JButton("Đăng xuất");
        buttonPanel.add(btnDangXuat, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        btnKhoa.addActionListener(this);
        btnSinhVien.addActionListener(this);
        btnLop.addActionListener(this);
        btnMonHoc.addActionListener(this);
        btnLichGiangDay.addActionListener(this);
        btnDiemThi.addActionListener(this);
        btnDangXuat.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKhoa) {
            controller.navigateToXemKhoa();
        } else if (e.getSource() == btnSinhVien) {
            controller.navigateToQuanLySinhVien();
        } else if (e.getSource() == btnLop) {
            controller.navigateToQuanLyLop();
        } else if (e.getSource() == btnMonHoc) {
            controller.navigateToXemMonHoc();
        } else if (e.getSource() == btnLichGiangDay) {
            controller.navigateToXemLichGiang();
        } else if (e.getSource() == btnDiemThi) {
            controller.navigateToQuanLyDiemThi();
        } else if (e.getSource() == btnDangXuat) {
            controller.handleLogout();
        }
    }


}
