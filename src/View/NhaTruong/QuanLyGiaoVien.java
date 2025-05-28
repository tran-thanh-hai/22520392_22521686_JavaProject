/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author rubik
 */
public class QuanLyGiaoVien extends JFrame {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    // Labels and fields for teacher information
    private JLabel lblMaGV;
    private JTextField txtMaGV;
    private JLabel lblHoTen;
    private JTextField txtHoTen;
    private JLabel lblChucVu;
    private JTextField txtChucVu;
    private JLabel lblGioiTinh;
    private JTextField txtGioiTinh;
    private JLabel lblMaKhoa;
    private JTextField txtMaKhoa;
    private JLabel lblNgaySinh;
    private JTextField txtNgaySinh;
    private JLabel lblNgayVaoLam;
    private JTextField txtNgayVaoLam;
    private JLabel lblHeSoLuong;
    private JTextField txtHeSoLuong;
    private JLabel lblLuongCoBan;
    private JTextField txtLuongCoBan;

    // Action buttons
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnTinhLuong;

    // Search components
    private JLabel lblSearchMaGVSearch;
    private JTextField txtSearchMaGVSearch;
    private JButton btnSearchMaGVSearch;
    private JLabel lblSearchChucVuSearch;
    private JTextField txtSearchChucVuSearch;
    private JButton btnSearchChucVuSearch;
    private JLabel lblSearchMaKhoaSearch;
    private JTextField txtSearchMaKhoaSearch;
    private JButton btnSearchMaKhoaSearch;
    private JLabel lblSearchHeSoLuongSearch;
    private JTextField txtSearchHeSoLuongSearch;
    private JButton btnSearchHeSoLuongSearch;

    public QuanLyGiaoVien() {
        setTitle("Quản Lý Giáo Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650); // Adjusted size for consistency
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Title Label
        lblTitle = new JLabel("Quản Lý Giáo Viên", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Data Display Area (using JTable)
        tableModel = new DefaultTableModel();
        // Define table columns based on GIAOVIEN SQL table
        tableModel.addColumn("Mã GV");
        tableModel.addColumn("Họ Tên");
        tableModel.addColumn("Chức vụ");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Mã khoa");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("Ngày vào làm");
        tableModel.addColumn("Hệ số lương");
        tableModel.addColumn("Lương cơ bản");
        tableModel.addColumn("Lương");

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

        // Mã giáo viên (Row 0)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaGV = new JLabel("Mã giáo viên:");
        inputPanel.add(lblMaGV, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaGV = new JTextField(15);
        inputPanel.add(txtMaGV, gbc);

        // Thêm Button (Row 0)
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);

        // Search by MaGV (Row 0)
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaGVSearch = new JLabel("Tìm kiếm theo mã GV:");
        inputPanel.add(lblSearchMaGVSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaGVSearch = new JTextField(10);
        inputPanel.add(txtSearchMaGVSearch, gbc);

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaGVSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaGVSearch, gbc);

        row++; // Increment row for the next group
        gbc.fill = GridBagConstraints.HORIZONTAL; // Reset fill to horizontal for text fields

        // Họ tên (Row 1)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblHoTen = new JLabel("Họ tên:");
        inputPanel.add(lblHoTen, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtHoTen = new JTextField(15);
        inputPanel.add(txtHoTen, gbc);

        // Sửa Button (Row 1)
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSua = new JButton("Sửa");
        inputPanel.add(btnSua, gbc);

        // Search by ChucVu (Row 1)
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchChucVuSearch = new JLabel("Tìm kiếm theo chức vụ:");
        inputPanel.add(lblSearchChucVuSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchChucVuSearch = new JTextField(10);
        inputPanel.add(txtSearchChucVuSearch, gbc);

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchChucVuSearch = new JButton("Tìm");
        inputPanel.add(btnSearchChucVuSearch, gbc);

        row++; // Increment row
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Chức vụ (Row 2)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblChucVu = new JLabel("Chức vụ:");
        inputPanel.add(lblChucVu, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtChucVu = new JTextField(15);
        inputPanel.add(txtChucVu, gbc);

        // Xóa Button (Row 2)
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

        // Search by HeSoLuong (Row 2)
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchHeSoLuongSearch = new JLabel("Tìm kiếm theo hệ số lương:");
        inputPanel.add(lblSearchHeSoLuongSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchHeSoLuongSearch = new JTextField(10);
        inputPanel.add(txtSearchHeSoLuongSearch, gbc);

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchHeSoLuongSearch = new JButton("Tìm");
        inputPanel.add(btnSearchHeSoLuongSearch, gbc);

        row++; // Increment row
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Giới tính (Row 3)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblGioiTinh = new JLabel("Giới tính:");
        inputPanel.add(lblGioiTinh, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtGioiTinh = new JTextField(15);
        inputPanel.add(txtGioiTinh, gbc);

        // Tinh luong button (Row 3)
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnTinhLuong = new JButton("Tính lương");
        inputPanel.add(btnTinhLuong, gbc);

        // Search by MaKhoa (Row 3)
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

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaKhoaSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaKhoaSearch, gbc);

        row++; // Increment row
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Mã khoa (input field) (Row 4)
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

        row++; // Increment row

        // Ngày sinh (Row 5)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblNgaySinh = new JLabel("Ngày sinh:");
        inputPanel.add(lblNgaySinh, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtNgaySinh = new JTextField(15);
        inputPanel.add(txtNgaySinh, gbc);

        row++; // Increment row

        // Ngày vào làm (Row 6)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblNgayVaoLam = new JLabel("Ngày vào làm:");
        inputPanel.add(lblNgayVaoLam, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtNgayVaoLam = new JTextField(15);
        inputPanel.add(txtNgayVaoLam, gbc);

        row++; // Increment row

        // Hệ số lương (Row 7)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblHeSoLuong = new JLabel("Hệ số lương:");
        inputPanel.add(lblHeSoLuong, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtHeSoLuong = new JTextField(15);
        inputPanel.add(txtHeSoLuong, gbc);

        row++; // Increment row

        // Lương cơ bản (Row 8)
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblLuongCoBan = new JLabel("Lương cơ bản:");
        inputPanel.add(lblLuongCoBan, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtLuongCoBan = new JTextField(15);
        inputPanel.add(txtLuongCoBan, gbc);

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyGiaoVien().setVisible(true);
        });
    }
}
