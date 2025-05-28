/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.SinhVien;

import Model.SinhVien;
import DAO.SinhVienDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Controller.SinhVienHomeController;

/**
 *
 * @author rubik
 */
public class XemSinhVien extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;



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

    private SinhVienHomeController controller;

    private SinhVienDAO sinhVienDAO;

    public XemSinhVien() {
        setTitle("Xem Sinh Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650); // Adjusted size for table and more search fields
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new SinhVienHomeController(this);

        // Create a panel for the back button and title
        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        btnBackToHome = new JButton("Quay về trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.navigateToTrangChu();
            }
        });

        // Title Label
        lblTitle = new JLabel("Xem Sinh Viên", SwingConstants.CENTER);
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

        // Add components to inputPanel using GridBagLayout
        // Column 0: Labels, Column 1: TextFields, Column 2: Action Buttons, Column 3: Search Labels, Column 4: Search TextFields, Column 5: Search Buttons
        int row = 0;



        // Search by MaSV
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



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;



        // Search by Diem Trung Binh
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



        // Search by Xep Loai
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



        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);

        sinhVienDAO = new SinhVienDAO();
        
        // Thêm action listeners cho các nút tìm kiếm
        btnSearchMaSVSearch = new JButton("Tìm");
        btnSearchMaLopSearch = new JButton("Tìm");
        btnSearchDiemTrungBinh = new JButton("Tìm");
        btnSearchXepLoai = new JButton("Tìm");
        
        btnSearchMaSVSearch.addActionListener(this);
        btnSearchMaLopSearch.addActionListener(this);
        btnSearchDiemTrungBinh.addActionListener(this);
        btnSearchXepLoai.addActionListener(this);
        
        // Thêm các nút tìm kiếm vào panel
        gbc.gridx = 5;
        gbc.gridy = 0;
        inputPanel.add(btnSearchMaSVSearch, gbc);
        
        gbc.gridy = 1;
        inputPanel.add(btnSearchMaLopSearch, gbc);
        
        gbc.gridy = 2;
        inputPanel.add(btnSearchDiemTrungBinh, gbc);
        
        gbc.gridy = 3;
        inputPanel.add(btnSearchXepLoai, gbc);
        
        // Load dữ liệu ban đầu
        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<SinhVien> dsSinhVien = sinhVienDAO.getAllSinhVien();
        for (SinhVien sv : dsSinhVien) {
            Object[] row = {
                sv.getMaHV(),
                sv.getHoTen(),
                sv.getGioiTinh(),
                sv.getMaLop(),
                sv.getNgaySinh(),
                sv.getNoiSinh(),
                sv.getDiemTB(),
                sv.getXepLoai()
            };
            tableModel.addRow(row);
        }
    }

    private void timKiemTheoMaSV() {
        String maSV = txtSearchMaSVSearch.getText().trim();
        if (!maSV.isEmpty()) {
            SinhVien sv = sinhVienDAO.timTheoMaSV(maSV);
            tableModel.setRowCount(0);
            if (sv != null) {
                Object[] row = {
                    sv.getMaHV(),
                    sv.getHoTen(),
                    sv.getGioiTinh(),
                    sv.getMaLop(),
                    sv.getNgaySinh(),
                    sv.getNoiSinh(),
                    sv.getDiemTB(),
                    sv.getXepLoai()
                };
                tableModel.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên với mã " + maSV);
                loadDataToTable();
            }
        } else {
            loadDataToTable();
        }
    }

    private void timKiemTheoMaLop() {
        String maLop = txtSearchMaLopSearch.getText().trim();
        if (!maLop.isEmpty()) {
            List<SinhVien> dsSinhVien = sinhVienDAO.timTheoMaLop(maLop);
            tableModel.setRowCount(0);
            if (!dsSinhVien.isEmpty()) {
                for (SinhVien sv : dsSinhVien) {
                    Object[] row = {
                        sv.getMaHV(),
                        sv.getHoTen(),
                        sv.getGioiTinh(),
                        sv.getMaLop(),
                        sv.getNgaySinh(),
                        sv.getNoiSinh(),
                        sv.getDiemTB(),
                        sv.getXepLoai()
                    };
                    tableModel.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên trong lớp " + maLop);
                loadDataToTable();
            }
        } else {
            loadDataToTable();
        }
    }

    private void timKiemTheoDiemTB() {
        try {
            float diemTB = Float.parseFloat(txtSearchDiemTrungBinh.getText().trim());
            tableModel.setRowCount(0);
            List<SinhVien> dsSinhVien = sinhVienDAO.getAllSinhVien();
            boolean found = false;
            for (SinhVien sv : dsSinhVien) {
                if (sv.getDiemTB() == diemTB) {
                    Object[] row = {
                        sv.getMaHV(),
                        sv.getHoTen(),
                        sv.getGioiTinh(),
                        sv.getMaLop(),
                        sv.getNgaySinh(),
                        sv.getNoiSinh(),
                        sv.getDiemTB(),
                        sv.getXepLoai()
                    };
                    tableModel.addRow(row);
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có điểm trung bình " + diemTB);
                loadDataToTable();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm trung bình hợp lệ!");
        }
    }

    private void timKiemTheoXepLoai() {
        String xepLoai = txtSearchXepLoai.getText().trim();
        if (!xepLoai.isEmpty()) {
            tableModel.setRowCount(0);
            List<SinhVien> dsSinhVien = sinhVienDAO.getAllSinhVien();
            boolean found = false;
            for (SinhVien sv : dsSinhVien) {
                if (sv.getXepLoai() != null && sv.getXepLoai().equalsIgnoreCase(xepLoai)) {
                    Object[] row = {
                        sv.getMaHV(),
                        sv.getHoTen(),
                        sv.getGioiTinh(),
                        sv.getMaLop(),
                        sv.getNgaySinh(),
                        sv.getNoiSinh(),
                        sv.getDiemTB(),
                        sv.getXepLoai()
                    };
                    tableModel.addRow(row);
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có xếp loại " + xepLoai);
                loadDataToTable();
            }
        } else {
            loadDataToTable();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnSearchMaSVSearch) {
            timKiemTheoMaSV();
        } else if (e.getSource() == btnSearchMaLopSearch) {
            timKiemTheoMaLop();
        } else if (e.getSource() == btnSearchDiemTrungBinh) {
            timKiemTheoDiemTB();
        } else if (e.getSource() == btnSearchXepLoai) {
            timKiemTheoXepLoai();
        }
    }
}
