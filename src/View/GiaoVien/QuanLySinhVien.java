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
import Model.DAO.SinhVienDAO;
import Model.Object.SinhVien;
import java.util.List;

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

    private SinhVienDAO sinhVienDAO;

    public QuanLySinhVien() {
        setTitle("Quản Lý Sinh Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);  
        setLocationRelativeTo(null);  
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);

         JPanel topPanel = new JPanel(new BorderLayout());

 
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

 
        lblTitle = new JLabel("Quản Lý Sinh Viên", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

 
        add(topPanel, BorderLayout.NORTH);

 
        tableModel = new DefaultTableModel();
 
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

 
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  
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
        
 
        btnSearchMaSVSearch = new JButton("Tìm");
        btnSearchMaLopSearch = new JButton("Tìm");
        btnSearchDiemTrungBinh = new JButton("Tìm");
        btnSearchXepLoai = new JButton("Tìm");

 
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(btnSearchMaSVSearch, gbc);

 
        gbc.gridx = 5;
        gbc.gridy = 1;
        inputPanel.add(btnSearchMaLopSearch, gbc);

 
        gbc.gridx = 5;
        gbc.gridy = 2;
        inputPanel.add(btnSearchDiemTrungBinh, gbc);

 
        gbc.gridx = 5;
        gbc.gridy = 3;
        inputPanel.add(btnSearchXepLoai, gbc);

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

 
        sinhVienDAO = new SinhVienDAO();
        
 
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnTinhDiemTrungBinh.addActionListener(this);
        btnXepLoai.addActionListener(this);
        btnSearchMaSVSearch.addActionListener(this);
        btnSearchMaLopSearch.addActionListener(this);
        btnSearchDiemTrungBinh.addActionListener(this);
        btnSearchXepLoai.addActionListener(this);
        
 
        loadDataToTable();

 
        dataTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMaSV.setText(dataTable.getValueAt(selectedRow, 0).toString());
                    txtHoTenSV.setText(dataTable.getValueAt(selectedRow, 1).toString());
                    txtGioiTinh.setText(dataTable.getValueAt(selectedRow, 2).toString());
                    txtMaLop.setText(dataTable.getValueAt(selectedRow, 3).toString());
                    txtNgaySinh.setText(dataTable.getValueAt(selectedRow, 4).toString());
                    txtNoiSinh.setText(dataTable.getValueAt(selectedRow, 5).toString());
                }
            }
        });
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<SinhVien> list = sinhVienDAO.getAllSinhVien();
        for (SinhVien sv : list) {
            tableModel.addRow(new Object[]{
                sv.getMaHV(),
                sv.getHoTen(),
                sv.getGioiTinh(),
                sv.getMaLop(),
                sv.getNgaySinh(),
                sv.getNoiSinh(),
                sv.getDiemTB(),
                sv.getXepLoai()
            });
        }
    }

    private void clearFields() {
        txtMaSV.setText("");
        txtHoTenSV.setText("");
        txtGioiTinh.setText("");
        txtMaLop.setText("");
        txtNgaySinh.setText("");
        txtNoiSinh.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            SinhVien sv = new SinhVien();
            sv.setMaHV(txtMaSV.getText());
            sv.setHoTen(txtHoTenSV.getText());
            sv.setGioiTinh(txtGioiTinh.getText());
            sv.setMaLop(txtMaLop.getText());
            sv.setNgaySinh(txtNgaySinh.getText());
            sv.setNoiSinh(txtNoiSinh.getText());
            
            if (sinhVienDAO.themSinhVien(sv)) {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại!");
            }
        } else if (e.getSource() == btnSua) {
            SinhVien sv = new SinhVien();
            sv.setMaHV(txtMaSV.getText());
            sv.setHoTen(txtHoTenSV.getText());
            sv.setGioiTinh(txtGioiTinh.getText());
            sv.setMaLop(txtMaLop.getText());
            sv.setNgaySinh(txtNgaySinh.getText());
            sv.setNoiSinh(txtNoiSinh.getText());
            
            if (sinhVienDAO.suaSinhVien(sv)) {
                JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thất bại!");
            }
        } else if (e.getSource() == btnXoa) {
            String maSV = txtMaSV.getText();
            if (sinhVienDAO.xoaSinhVien(maSV)) {
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thất bại!");
            }
        } else if (e.getSource() == btnTinhDiemTrungBinh) {
            String maSV = txtMaSV.getText();
            if (!maSV.isEmpty()) {
                if (sinhVienDAO.tinhDiemTrungBinh(maSV)) {
                    JOptionPane.showMessageDialog(this, "Tính điểm trung bình thành công!");
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Tính điểm trung bình thất bại!");
                }
            } else {
                if (sinhVienDAO.tinhDiemTrungBinhTatCa()) {
                    JOptionPane.showMessageDialog(this, "Tính điểm trung bình cho tất cả sinh viên thành công!");
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Tính điểm trung bình cho tất cả sinh viên thất bại!");
                }
            }
        } else if (e.getSource() == btnXepLoai) {
            String maSV = txtMaSV.getText();
            if (!maSV.isEmpty()) {
                if (sinhVienDAO.xepLoai(maSV)) {
                    JOptionPane.showMessageDialog(this, "Xếp loại sinh viên thành công!");
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Xếp loại sinh viên thất bại!");
                }
            } else {
                if (sinhVienDAO.xepLoaiTatCa()) {
                    JOptionPane.showMessageDialog(this, "Xếp loại tất cả sinh viên thành công!");
                    loadDataToTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Xếp loại tất cả sinh viên thất bại!");
                }
            }
        } else if (e.getSource() == btnSearchMaSVSearch) {
            String maSV = txtSearchMaSVSearch.getText();
            if (!maSV.isEmpty()) {
                SinhVien sv = sinhVienDAO.timTheoMaSV(maSV);
                tableModel.setRowCount(0);
                if (sv != null) {
                    tableModel.addRow(new Object[]{
                        sv.getMaHV(),
                        sv.getHoTen(),
                        sv.getGioiTinh(),
                        sv.getMaLop(),
                        sv.getNgaySinh(),
                        sv.getNoiSinh(),
                        sv.getDiemTB(),
                        sv.getXepLoai()
                    });
                }
            } else {
                loadDataToTable();
            }
        } else if (e.getSource() == btnSearchMaLopSearch) {
            String maLop = txtSearchMaLopSearch.getText();
            if (!maLop.isEmpty()) {
                List<SinhVien> list = sinhVienDAO.timTheoMaLop(maLop);
                tableModel.setRowCount(0);
                for (SinhVien sv : list) {
                    tableModel.addRow(new Object[]{
                        sv.getMaHV(),
                        sv.getHoTen(),
                        sv.getGioiTinh(),
                        sv.getMaLop(),
                        sv.getNgaySinh(),
                        sv.getNoiSinh(),
                        sv.getDiemTB(),
                        sv.getXepLoai()
                    });
                }
            } else {
                loadDataToTable();
            }
        } else if (e.getSource() == btnSearchDiemTrungBinh) {
            try {
                float diemTB = Float.parseFloat(txtSearchDiemTrungBinh.getText().trim());
                tableModel.setRowCount(0);
                List<SinhVien> list = sinhVienDAO.getAllSinhVien();
                for (SinhVien sv : list) {
                    if (sv.getDiemTB() == diemTB) {
                        tableModel.addRow(new Object[]{
                            sv.getMaHV(),
                            sv.getHoTen(),
                            sv.getGioiTinh(),
                            sv.getMaLop(),
                            sv.getNgaySinh(),
                            sv.getNoiSinh(),
                            sv.getDiemTB(),
                            sv.getXepLoai()
                        });
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm trung bình hợp lệ!");
            }
        } else if (e.getSource() == btnSearchXepLoai) {
            String xepLoai = txtSearchXepLoai.getText().trim();
            if (!xepLoai.isEmpty()) {
                tableModel.setRowCount(0);
                List<SinhVien> list = sinhVienDAO.getAllSinhVien();
                for (SinhVien sv : list) {
                    if (sv.getXepLoai() != null && sv.getXepLoai().equalsIgnoreCase(xepLoai)) {
                        tableModel.addRow(new Object[]{
                            sv.getMaHV(),
                            sv.getHoTen(),
                            sv.getGioiTinh(),
                            sv.getMaLop(),
                            sv.getNgaySinh(),
                            sv.getNoiSinh(),
                            sv.getDiemTB(),
                            sv.getXepLoai()
                        });
                    }
                }
            } else {
                loadDataToTable();
            }
        }
    }
}
