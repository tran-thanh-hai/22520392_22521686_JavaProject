/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author rubik
 */
public class QuanLyMonHoc extends JFrame {

    private JLabel lblTitle;
    private JTextArea dataArea;

    // Labels and fields for course information
    private JLabel lblMaMH;
    private JTextField txtMaMH;
    private JLabel lblTenMH;
    private JTextField txtTenMH;
    private JLabel lblTCLT;
    private JTextField txtTCLT;
    private JLabel lblTCTH;
    private JTextField txtTCTH;
    private JLabel lblMaKhoa;
    private JTextField txtMaKhoa;

    // Action buttons
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    // Search components
    private JLabel lblSearchMaMH;
    private JTextField txtSearchMaMH;
    private JButton btnSearchMaMH;
    private JLabel lblSearchTCLT;
    private JTextField txtSearchTCLT;
    private JButton btnSearchTCLT;
    private JLabel lblSearchTCTH;
    private JTextField txtSearchTCTH;
    private JButton btnSearchTCTH;
    private JLabel lblSearchMaKhoa;
    private JTextField txtSearchMaKhoa;
    private JButton btnSearchMaKhoa;

    public QuanLyMonHoc() {
        setTitle("Quản lý Môn học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600); // Adjusted size
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Title Label
        lblTitle = new JLabel("Quản lý Môn học", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Data Display Area
        dataArea = new JTextArea();
        dataArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dataArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input and Action Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to inputPanel using GridBagLayout
        int row = 0;

        // Mã môn học
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaMH = new JLabel("Mã môn học:");
        inputPanel.add(lblMaMH, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaMH = new JTextField(15);
        inputPanel.add(txtMaMH, gbc);

        // Thêm Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);

        // Search by MaMH
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaMH = new JLabel("Tìm kiếm theo mã môn học:");
        inputPanel.add(lblSearchMaMH, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaMH = new JTextField(10);
        inputPanel.add(txtSearchMaMH, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tên môn học
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblTenMH = new JLabel("Tên môn học:");
        inputPanel.add(lblTenMH, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtTenMH = new JTextField(15);
        inputPanel.add(txtTenMH, gbc);

        // Sửa Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSua = new JButton("Sửa");
        inputPanel.add(btnSua, gbc);

        // Search by TCLT
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchTCLT = new JLabel("Tìm kiếm theo tín chỉ lý thuyết:");
        inputPanel.add(lblSearchTCLT, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchTCLT = new JTextField(10);
        inputPanel.add(txtSearchTCLT, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tín chỉ lý thuyết
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblTCLT = new JLabel("Tín chỉ lý thuyết:");
        inputPanel.add(lblTCLT, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtTCLT = new JTextField(15);
        inputPanel.add(txtTCLT, gbc);

        // Xóa Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

        // Search by TCTH
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchTCTH = new JLabel("Tìm kiếm theo tín chỉ thực hành:");
        inputPanel.add(lblSearchTCTH, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchTCTH = new JTextField(10);
        inputPanel.add(txtSearchTCTH, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tín chỉ thực hành
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblTCTH = new JLabel("Tín chỉ thực hành:");
        inputPanel.add(lblTCTH, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtTCTH = new JTextField(15);
        inputPanel.add(txtTCTH, gbc);

        // Search by MaKhoa
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaKhoa = new JLabel("Tìm kiếm theo mã khoa:");
        inputPanel.add(lblSearchMaKhoa, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaKhoa = new JTextField(10);
        inputPanel.add(txtSearchMaKhoa, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Mã khoa
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaKhoa = new JLabel("Mã khoa:");
        inputPanel.add(lblMaKhoa, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaKhoa = new JTextField(15);
        inputPanel.add(txtMaKhoa, gbc);

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyMonHoc().setVisible(true);
        });
    }
}
