/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.GiaoVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.GiaoVienHomeController;

/**
 *
 * @author rubik
 */
public class QuanLySinhVien extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    // Labels and fields for student information
    private JLabel lblMaSV;
    private JTextField txtMaSV;
    private JLabel lblHoTenSV;
    private JTextField txtHoTenSV;
    private JLabel lblGioiTinh;
    private JTextField txtGioiTinh;
    private JLabel lblMaLop;
    private JTextField txtMaLop;
    private JLabel lblNgaySinh;
    private JTextField txtNgaySinh;
    private JLabel lblNoiSinh;
    private JTextField txtNoiSinh;

    // Action buttons
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnTinhDiemTrungBinh;
    private JButton btnXepLoai;

    // Search components
    private JLabel lblSearchMaSVSearch;
    private JTextField txtSearchMaSVSearch;
    private JButton btnSearchMaSVSearch;
    private JLabel lblSearchMaLopSearch;
    private JTextField txtSearchMaLopSearch;
    private JButton btnSearchMaLopSearch;
    private JLabel lblSearchDiemTrungBinh;
    private JTextField txtSearchDiemTrungBinh;
    private JButton btnSearchDiemTrungBinh;
    private JLabel lblSearchXepLoai;
    private JTextField txtSearchXepLoai;
    private JButton btnSearchXepLoai;

    private JButton btnBackToHome;

    private GiaoVienHomeController controller;

    public QuanLySinhVien() {
        setTitle("Quản Lý Sinh Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650); // Adjusted size for table and more search fields
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);

        // Create a panel for the back button and title
        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        // Title Label
        lblTitle = new JLabel("Quản Lý Sinh Viên", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        // Add the top panel to the frame
        add(topPanel, BorderLayout.NORTH);

        // Data Display Area (using JTable)
        tableModel = new DefaultTableModel();
        // Define table columns (replace with actual column names from your data)
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Họ tên sinh viên");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Mã lớp");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("Nơi sinh");
        tableModel.addColumn("Điểm trung bình");
        tableModel.addColumn("Xếp loại");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Input and Action Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;


        int row = 0;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaSV = new JLabel("Mã sinh viên:");
        inputPanel.add(lblMaSV, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaSV = new JTextField(15);
        inputPanel.add(txtMaSV, gbc);


        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);


        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaSVSearch = new JLabel("Tìm kiếm theo mã sinh viên:");
        inputPanel.add(lblSearchMaSVSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaSVSearch = new JTextField(10);
        inputPanel.add(txtSearchMaSVSearch, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaSVSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaSVSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblHoTenSV = new JLabel("Họ tên sinh viên:");
        inputPanel.add(lblHoTenSV, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtHoTenSV = new JTextField(15);
        inputPanel.add(txtHoTenSV, gbc);


        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSua = new JButton("Sửa");
        inputPanel.add(btnSua, gbc);


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



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


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


        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);


        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchDiemTrungBinh = new JLabel("Tìm kiếm theo điểm trung bình:");
        inputPanel.add(lblSearchDiemTrungBinh, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchDiemTrungBinh = new JTextField(10);
        inputPanel.add(txtSearchDiemTrungBinh, gbc);



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


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


        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnTinhDiemTrungBinh = new JButton("Tính điểm trung bình");
        inputPanel.add(btnTinhDiemTrungBinh, gbc);


        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchXepLoai = new JLabel("Tìm kiếm theo xếp loại:");
        inputPanel.add(lblSearchXepLoai, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchXepLoai = new JTextField(10);
        inputPanel.add(txtSearchXepLoai, gbc);



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


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


        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXepLoai = new JButton("Xếp loại");
        inputPanel.add(btnXepLoai, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblNoiSinh = new JLabel("Nơi sinh:");
        inputPanel.add(lblNoiSinh, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtNoiSinh = new JTextField(15);
        inputPanel.add(txtNoiSinh, gbc);


        add(inputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        }

    }


}
