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
import Model.DAO.GiaoVienDAO;
import Model.Object.GiaoVien;
import java.util.List;

/**
 *
 * @author rubik
 */
public class QuanLyGiaoVien extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

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

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnTinhLuong;
    private JButton btnTinhLuongTatCa;

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

    private JButton btnBackToHome;

    private NhaTruongHomeController controller;

    private GiaoVienDAO giaoVienDAO;

    public QuanLyGiaoVien() {
        setTitle("Quản Lý Giáo Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);

        JPanel topPanel = new JPanel(new BorderLayout());

        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        lblTitle = new JLabel("Quản Lý Giáo Viên", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
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

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

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

        row++; 
        gbc.fill = GridBagConstraints.HORIZONTAL; 

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

        row++; 
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        btnTinhLuong = new JButton("Tính lương");
        inputPanel.add(btnTinhLuong, gbc);

        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnTinhLuongTatCa = new JButton("Tính lương tất cả");
        inputPanel.add(btnTinhLuongTatCa, gbc);

        // Search by MaKhoa (Row 3)
        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaKhoaSearch = new JLabel("Tìm kiếm theo mã khoa:");
        inputPanel.add(lblSearchMaKhoaSearch, gbc);

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaKhoaSearch = new JTextField(10);
        inputPanel.add(txtSearchMaKhoaSearch, gbc);

        gbc.gridx = 6;
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

        // Khởi tạo GiaoVienDAO trong constructor
        giaoVienDAO = new GiaoVienDAO();
        
        // Thêm ActionListener cho các nút
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnTinhLuong.addActionListener(this);
        btnTinhLuongTatCa.addActionListener(this);
        btnSearchMaGVSearch.addActionListener(this);
        btnSearchChucVuSearch.addActionListener(this);
        btnSearchMaKhoaSearch.addActionListener(this);
        btnSearchHeSoLuongSearch.addActionListener(this);
        
        // Load dữ liệu ban đầu
        loadDataToTable();

        // Thêm vào constructor sau khi khởi tạo dataTable
        dataTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    displaySelectedRow(selectedRow);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            themGiaoVien();
        } else if (e.getSource() == btnSua) {
            suaGiaoVien();
        } else if (e.getSource() == btnXoa) {
            xoaGiaoVien();
        } else if (e.getSource() == btnTinhLuong) {
            tinhLuong();
        } else if (e.getSource() == btnTinhLuongTatCa) {
            tinhLuongTatCa();
        } else if (e.getSource() == btnSearchMaGVSearch) {
            timTheoMaGV();
        } else if (e.getSource() == btnSearchChucVuSearch) {
            timTheoChucVu();
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            timTheoMaKhoa();
        } else if (e.getSource() == btnSearchHeSoLuongSearch) {
            timTheoHeSoLuong();
        }
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<GiaoVien> danhSachGV = giaoVienDAO.getAllGiaoVien();
        for (GiaoVien gv : danhSachGV) {
            Object[] row = {
                gv.getMaGV(),
                gv.getHoTen(),
                gv.getChucVu(),
                gv.getGioiTinh(),
                gv.getMaKhoa(),
                gv.getNgaySinh(),
                gv.getNgVaoLam(),
                gv.getHeSoLuong(),
                gv.getLuongCoBan(),
                gv.getLuong()
            };
            tableModel.addRow(row);
        }
    }

    private void themGiaoVien() {
        try {
            GiaoVien gv = layThongTinTuForm();
            if (giaoVienDAO.themGiaoVien(gv)) {
                JOptionPane.showMessageDialog(this, "Thêm giáo viên thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm giáo viên thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void suaGiaoVien() {
        try {
            GiaoVien gv = layThongTinTuForm();
            if (giaoVienDAO.suaGiaoVien(gv)) {
                JOptionPane.showMessageDialog(this, "Cập nhật giáo viên thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật giáo viên thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void xoaGiaoVien() {
        String maGV = txtMaGV.getText().trim();
        if (maGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã giáo viên cần xóa!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn xóa giáo viên này?", 
            "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (giaoVienDAO.xoaGiaoVien(maGV)) {
                JOptionPane.showMessageDialog(this, "Xóa giáo viên thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa giáo viên thất bại!");
            }
        }
    }

    private void tinhLuong() {
        String maGV = txtMaGV.getText().trim();
        if (maGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã giáo viên!");
            return;
        }
        
        if (giaoVienDAO.tinhLuong(maGV)) {
            JOptionPane.showMessageDialog(this, "Tính lương thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tính lương thất bại!");
        }
    }

    private void tinhLuongTatCa() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn tính lương cho tất cả giáo viên?", 
            "Xác nhận", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (giaoVienDAO.tinhLuongTatCa()) {
                    JOptionPane.showMessageDialog(this, 
                        "Tính lương cho tất cả giáo viên thành công!", 
                        "Thành công", 
                        JOptionPane.INFORMATION_MESSAGE);
                    loadDataToTable(); // Cập nhật lại bảng
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Không có giáo viên nào được cập nhật lương!", 
                        "Thông báo", 
                        JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Lỗi khi tính lương: " + ex.getMessage(), 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void timTheoMaGV() {
        String maGV = txtSearchMaGVSearch.getText().trim();
        if (maGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã giáo viên cần tìm!");
            return;
        }
        
        GiaoVien gv = giaoVienDAO.timTheoMaGV(maGV);
        hienThiKetQuaTimKiem(gv != null ? List.of(gv) : List.of());
    }

    private void timTheoChucVu() {
        String chucVu = txtSearchChucVuSearch.getText().trim();
        if (chucVu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chức vụ cần tìm!");
            return;
        }
        
        List<GiaoVien> ketQua = giaoVienDAO.timTheoChucVu(chucVu);
        hienThiKetQuaTimKiem(ketQua);
    }

    private void timTheoMaKhoa() {
        String maKhoa = txtSearchMaKhoaSearch.getText().trim();
        if (maKhoa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khoa cần tìm!");
            return;
        }
        
        List<GiaoVien> ketQua = giaoVienDAO.timTheoMaKhoa(maKhoa);
        hienThiKetQuaTimKiem(ketQua);
    }

    private void timTheoHeSoLuong() {
        try {
            float heSoLuong = Float.parseFloat(txtSearchHeSoLuongSearch.getText().trim());
            List<GiaoVien> ketQua = giaoVienDAO.timTheoHeSoLuong(heSoLuong);
            hienThiKetQuaTimKiem(ketQua);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hệ số lương hợp lệ!");
        }
    }

    private void hienThiKetQuaTimKiem(List<GiaoVien> danhSachGV) {
        tableModel.setRowCount(0);
        for (GiaoVien gv : danhSachGV) {
            Object[] row = {
                gv.getMaGV(),
                gv.getHoTen(),
                gv.getChucVu(),
                gv.getGioiTinh(),
                gv.getMaKhoa(),
                gv.getNgaySinh(),
                gv.getNgVaoLam(),
                gv.getHeSoLuong(),
                gv.getLuongCoBan(),
                gv.getLuong()
            };
            tableModel.addRow(row);
        }
    }

    private GiaoVien layThongTinTuForm() {
        GiaoVien gv = new GiaoVien();
        gv.setMaGV(txtMaGV.getText().trim());
        gv.setHoTen(txtHoTen.getText().trim());
        gv.setChucVu(txtChucVu.getText().trim());
        gv.setGioiTinh(txtGioiTinh.getText().trim());
        gv.setMaKhoa(txtMaKhoa.getText().trim());
        gv.setNgaySinh(txtNgaySinh.getText().trim());
        gv.setNgVaoLam(txtNgayVaoLam.getText().trim());
        gv.setHeSoLuong(Float.parseFloat(txtHeSoLuong.getText().trim()));
        gv.setLuongCoBan(Float.parseFloat(txtLuongCoBan.getText().trim()));
        return gv;
    }

    private void xoaForm() {
        txtMaGV.setText("");
        txtHoTen.setText("");
        txtChucVu.setText("");
        txtGioiTinh.setText("");
        txtMaKhoa.setText("");
        txtNgaySinh.setText("");
        txtNgayVaoLam.setText("");
        txtHeSoLuong.setText("");
        txtLuongCoBan.setText("");
    }

    private void displaySelectedRow(int row) {
        txtMaGV.setText(tableModel.getValueAt(row, 0).toString());
        txtHoTen.setText(tableModel.getValueAt(row, 1).toString());
        txtChucVu.setText(tableModel.getValueAt(row, 2).toString());
        txtGioiTinh.setText(tableModel.getValueAt(row, 3).toString());
        txtMaKhoa.setText(tableModel.getValueAt(row, 4).toString());
        txtNgaySinh.setText(tableModel.getValueAt(row, 5).toString());
        txtNgayVaoLam.setText(tableModel.getValueAt(row, 6).toString());
        txtHeSoLuong.setText(tableModel.getValueAt(row, 7).toString());
        txtLuongCoBan.setText(tableModel.getValueAt(row, 8).toString());
    }
}
