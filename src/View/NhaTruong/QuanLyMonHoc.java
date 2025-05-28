/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import Controller.NhaTruongHomeController;

/**
 *
 * @author rubik
 */
public class QuanLyMonHoc extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

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
    private JLabel lblSearchMaMHSearch;
    private JTextField txtSearchMaMHSearch;
    private JButton btnSearchMaMHSearch;
    private JLabel lblSearchTCLTSearch;
    private JTextField txtSearchTCLTSearch;
    private JButton btnSearchTCLTSearch;
    private JLabel lblSearchTCTHSearch;
    private JTextField txtSearchTCTHSearch;
    private JButton btnSearchTCTHSearch;
    private JLabel lblSearchMaKhoaSearch;
    private JTextField txtSearchMaKhoaSearch;
    private JButton btnSearchMaKhoaSearch;

    private JButton btnBackToHome;

    private NhaTruongHomeController controller;

    public QuanLyMonHoc() {
        setTitle("Quản lý Môn học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650); // Adjusted size for consistency
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);

        // Create a panel for the back button and title
        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        // Title Label
        lblTitle = new JLabel("Quản lý Môn học", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Data Display Area (using JTable)
        tableModel = new DefaultTableModel();
        // Define table columns based on MONHOC SQL table
        tableModel.addColumn("Mã MH");
        tableModel.addColumn("Tên MH");
        tableModel.addColumn("Tín chỉ lý thuyết");
        tableModel.addColumn("Tín chỉ thực hành");
        tableModel.addColumn("Mã khoa");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Input and Action Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to inputPanel using GridBagLayout
        // Column 0: Labels, Column 1: TextFields, Column 2: Action Buttons, Column 3: Search Labels, Column 4: Search TextFields, Column 5: Search Buttons
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
        lblSearchMaMHSearch = new JLabel("Tìm kiếm theo mã môn học:");
        inputPanel.add(lblSearchMaMHSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaMHSearch = new JTextField(10);
        inputPanel.add(txtSearchMaMHSearch, gbc);

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaMHSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaMHSearch, gbc);

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
        lblSearchTCLTSearch = new JLabel("Tìm kiếm theo tín chỉ lý thuyết:");
        inputPanel.add(lblSearchTCLTSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchTCLTSearch = new JTextField(10);
        inputPanel.add(txtSearchTCLTSearch, gbc);

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
        lblSearchTCTHSearch = new JLabel("Tìm kiếm theo tín chỉ thực hành:");
        inputPanel.add(lblSearchTCTHSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchTCTHSearch = new JTextField(10);
        inputPanel.add(txtSearchTCTHSearch, gbc);

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
        lblSearchMaKhoaSearch = new JLabel("Tìm kiếm theo mã khoa:");
        inputPanel.add(lblSearchMaKhoaSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaKhoaSearch = new JTextField(10);
        inputPanel.add(txtSearchMaKhoaSearch, gbc);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        }
        // Add action handling for other buttons here if needed
    }


}
