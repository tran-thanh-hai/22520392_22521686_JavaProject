/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author rubik
 */

public class QuanLyKhoa extends JFrame {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private JLabel lblMaKhoa;
    private JTextField txtMaKhoa;
    private JLabel lblTenKhoa;
    private JTextField txtTenKhoa;
    private JLabel lblNgayThanhLap;
    private JTextField txtNgayThanhLap;
    private JLabel lblTruongKhoa;
    private JTextField txtTruongKhoa;

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    private JLabel lblSearchMaKhoaSearch;
    private JTextField txtSearchMaKhoaSearch;
    private JButton btnSearchMaKhoaSearch;

    public QuanLyKhoa() {
        setTitle("Quản Lý Khoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tiêu đề
        lblTitle = new JLabel("Quản Lý Khoa", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Khu vực hiển thị dữ liệu
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã khoa");
        tableModel.addColumn("Tên khoa");
        tableModel.addColumn("Ngày thành lập");
        tableModel.addColumn("Trưởng khoa");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Panel nhập liệu và nút hành động
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // Mã khoa
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaKhoa = new JLabel("Mã khoa:");
        inputPanel.add(lblMaKhoa, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaKhoa = new JTextField(15);
        inputPanel.add(txtMaKhoa, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);

        gbc.gridx = 3;
        gbc.anchor = GridBagConstraints.EAST;
        lblSearchMaKhoaSearch = new JLabel("Tìm kiếm theo mã khoa:");
        inputPanel.add(lblSearchMaKhoaSearch, gbc);

        gbc.gridx = 4;
        gbc.anchor = GridBagConstraints.WEST;
        txtSearchMaKhoaSearch = new JTextField(10);
        inputPanel.add(txtSearchMaKhoaSearch, gbc);

        gbc.gridx = 5;
        btnSearchMaKhoaSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaKhoaSearch, gbc);

        // Tên khoa
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblTenKhoa = new JLabel("Tên khoa:");
        inputPanel.add(lblTenKhoa, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtTenKhoa = new JTextField(15);
        inputPanel.add(txtTenKhoa, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnSua = new JButton("Sửa");
        inputPanel.add(btnSua, gbc);

        // Ngày thành lập
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblNgayThanhLap = new JLabel("Ngày thành lập:");
        inputPanel.add(lblNgayThanhLap, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtNgayThanhLap = new JTextField(15);
        inputPanel.add(txtNgayThanhLap, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

        // Trưởng khoa
        row++;
        gbc.gridx = 0; gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblTruongKhoa = new JLabel("Trưởng khoa:");
        inputPanel.add(lblTruongKhoa, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtTruongKhoa = new JTextField(15);
        inputPanel.add(txtTruongKhoa, gbc);

        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyKhoa().setVisible(true);
        });
    }
}

