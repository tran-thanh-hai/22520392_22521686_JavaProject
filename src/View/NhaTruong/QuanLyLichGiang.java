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
public class QuanLyLichGiang extends JFrame {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    // Labels and fields for schedule information
    private JLabel lblMaLop;
    private JTextField txtMaLop;
    private JLabel lblMaMH;
    private JTextField txtMaMH;
    private JLabel lblMaGV;
    private JTextField txtMaGV;
    private JLabel lblHocKy;
    private JTextField txtHocKy;
    private JLabel lblNam;
    private JTextField txtNam;
    private JLabel lblTuNgay;
    private JTextField txtTuNgay;
    private JLabel lblDenNgay;
    private JTextField txtDenNgay;

    // Action buttons
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    // Search components
    private JLabel lblSearchMaLopSearch;
    private JTextField txtSearchMaLopSearch;
    private JButton btnSearchMaLopSearch;
    private JLabel lblSearchMaMHSearch;
    private JTextField txtSearchMaMHSearch;
    private JButton btnSearchMaMHSearch;
    private JLabel lblSearchMaGVSearch;
    private JTextField txtSearchMaGVSearch;
    private JButton btnSearchMaGVSearch;
    private JLabel lblSearchHocKySearch;
    private JTextField txtSearchHocKySearch;
    private JButton btnSearchHocKySearch;
    private JLabel lblSearchNamSearch;
    private JTextField txtSearchNamSearch;
    private JButton btnSearchNamSearch;

    public QuanLyLichGiang() {
        setTitle("Quản Lý Lịch Giảng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650); // Adjusted size for consistency
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Title Label
        lblTitle = new JLabel("Quản Lý Lịch Giảng", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Data Display Area (using JTable)
        tableModel = new DefaultTableModel();
        // Define table columns based on GIANGDAY SQL table
        tableModel.addColumn("Mã lớp");
        tableModel.addColumn("Mã MH");
        tableModel.addColumn("Mã GV");
        tableModel.addColumn("Học kỳ");
        tableModel.addColumn("Năm");
        tableModel.addColumn("Từ ngày");
        tableModel.addColumn("Đến ngày");

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

        // Mã lớp
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaLop = new JLabel("Mã lớp:");
        inputPanel.add(lblMaLop, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaLop = new JTextField(15);
        inputPanel.add(txtMaLop, gbc);

        // Thêm Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);

        // Search by MaLop
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaLopSearch = new JLabel("Tìm kiếm theo mã lớp:");
        inputPanel.add(lblSearchMaLopSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaLopSearch = new JTextField(10);
        inputPanel.add(txtSearchMaLopSearch, gbc);

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaLopSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaLopSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

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

        // Sửa Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSua = new JButton("Sửa");
        inputPanel.add(btnSua, gbc);

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

 

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Mã giáo viên
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

        // Xóa Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

        // Search by MaGV
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaGVSearch = new JLabel("Tìm kiếm theo mã giáo viên:");
        inputPanel.add(lblSearchMaGVSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaGVSearch = new JTextField(10);
        inputPanel.add(txtSearchMaGVSearch, gbc);



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Học kỳ
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblHocKy = new JLabel("Học kỳ:");
        inputPanel.add(lblHocKy, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtHocKy = new JTextField(15);
        inputPanel.add(txtHocKy, gbc);

        // Search by HocKy
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchHocKySearch = new JLabel("Tìm kiếm theo học kỳ:");
        inputPanel.add(lblSearchHocKySearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchHocKySearch = new JTextField(10);
        inputPanel.add(txtSearchHocKySearch, gbc);



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Năm
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblNam = new JLabel("Năm:");
        inputPanel.add(lblNam, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtNam = new JTextField(15);
        inputPanel.add(txtNam, gbc);

        // Search by Nam
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchNamSearch = new JLabel("Tìm kiếm theo năm:");
        inputPanel.add(lblSearchNamSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchNamSearch = new JTextField(10);
        inputPanel.add(txtSearchNamSearch, gbc);



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Từ ngày
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblTuNgay = new JLabel("Từ ngày:");
        inputPanel.add(lblTuNgay, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtTuNgay = new JTextField(15);
        inputPanel.add(txtTuNgay, gbc);

        row++;

        // Đến ngày
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblDenNgay = new JLabel("Đến ngày:");
        inputPanel.add(lblDenNgay, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtDenNgay = new JTextField(15);
        inputPanel.add(txtDenNgay, gbc);

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyLichGiang().setVisible(true);
        });
    }
}
