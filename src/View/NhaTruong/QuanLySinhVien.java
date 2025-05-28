/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author rubik
 */
public class QuanLySinhVien extends JFrame {

    private JTextField maSinhVienField;
    private JTextField hoTenSinhVienField;
    private JTextField gioiTinhField;
    private JTextField maLopField;
    private JTextField ngaySinhField;
    private JTextField noiSinhField;

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton tinhDiemButton;
    private JButton xepLoaiButton;

    private JTextField searchTenField;
    private JTextField searchMaLopField;
    private JButton searchTenButton;
    private JButton searchMaLopButton;

    private JTextArea dataDisplayArea; // Using JTextArea as a placeholder, can be replaced by JTable

    public QuanLySinhVien() {
        setTitle("Quản Lý Sinh Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel for data display (placeholder)
        JPanel topPanel = new JPanel(new BorderLayout());
        dataDisplayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(dataDisplayArea);
        topPanel.setBorder(BorderFactory.createTitledBorder("Student Data")); // Optional title
        topPanel.add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);

        // Bottom Panel for input fields and buttons
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: Mã sinh viên
        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(new JLabel("Mã sinh viên:"), gbc);
        gbc.gridx = 1;
        maSinhVienField = new JTextField(15);
        bottomPanel.add(maSinhVienField, gbc);

        gbc.gridx = 2;
        addButton = new JButton("Thêm");
        bottomPanel.add(addButton, gbc);

        gbc.gridx = 3;
        searchTenButton = new JButton("Tìm kiếm sinh viên theo tên");
        bottomPanel.add(searchTenButton, gbc);
        gbc.gridx = 4;
        searchTenField = new JTextField(15);
        bottomPanel.add(searchTenField, gbc);

        // Row 2: Họ tên sinh viên
        gbc.gridx = 0;
        gbc.gridy = 1;
        bottomPanel.add(new JLabel("Họ tên sinh viên:"), gbc);
        gbc.gridx = 1;
        hoTenSinhVienField = new JTextField(15);
        bottomPanel.add(hoTenSinhVienField, gbc);

        gbc.gridx = 2;
        editButton = new JButton("Sửa");
        bottomPanel.add(editButton, gbc);

        gbc.gridx = 3;
        searchMaLopButton = new JButton("Tìm kiếm theo mã lớp");
        bottomPanel.add(searchMaLopButton, gbc);
        gbc.gridx = 4;
        searchMaLopField = new JTextField(15);
        bottomPanel.add(searchMaLopField, gbc);

        // Row 3: Giới tính
        gbc.gridx = 0;
        gbc.gridy = 2;
        bottomPanel.add(new JLabel("Giới tính:"), gbc);
        gbc.gridx = 1;
        gioiTinhField = new JTextField(15);
        bottomPanel.add(gioiTinhField, gbc);

        gbc.gridx = 2;
        deleteButton = new JButton("Xoá");
        bottomPanel.add(deleteButton, gbc);

        // Row 4: Mã lớp
        gbc.gridx = 0;
        gbc.gridy = 3;
        bottomPanel.add(new JLabel("Mã lớp:"), gbc);
        gbc.gridx = 1;
        maLopField = new JTextField(15);
        bottomPanel.add(maLopField, gbc);

        gbc.gridx = 2;
        tinhDiemButton = new JButton("Tính điểm trung bình");
        bottomPanel.add(tinhDiemButton, gbc);

        // Row 5: Ngày sinh
        gbc.gridx = 0;
        gbc.gridy = 4;
        bottomPanel.add(new JLabel("Ngày sinh:"), gbc);
        gbc.gridx = 1;
        ngaySinhField = new JTextField(15);
        bottomPanel.add(ngaySinhField, gbc);

        gbc.gridx = 2;
        xepLoaiButton = new JButton("Xếp loại");
        bottomPanel.add(xepLoaiButton, gbc);

        // Row 6: Nơi sinh
        gbc.gridx = 0;
        gbc.gridy = 5;
        bottomPanel.add(new JLabel("Nơi sinh:"), gbc);
        gbc.gridx = 1;
        noiSinhField = new JTextField(15);
        bottomPanel.add(noiSinhField, gbc);

        add(bottomPanel, BorderLayout.SOUTH);

        pack(); // Adjusts the window size to fit the components
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new QuanLySinhVien().setVisible(true);
        });
    }
}
