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
import DAO.MonHocDAO;
import Model.MonHoc;
import java.util.List;

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

    private MonHocDAO monHocDAO;

    public QuanLyMonHoc() {
        setTitle("Quản lý Môn học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);
        monHocDAO = new MonHocDAO();

        // Tạo panel trên cùng
        JPanel topPanel = new JPanel(new BorderLayout());
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        lblTitle = new JLabel("Quản lý Môn học", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Khởi tạo bảng
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã MH");
        tableModel.addColumn("Tên MH");
        tableModel.addColumn("Tín chỉ lý thuyết");
        tableModel.addColumn("Tín chỉ thực hành");
        tableModel.addColumn("Mã khoa");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Khởi tạo panel nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo các components
        initializeComponents();

        // Thêm các components vào panel
        addComponentsToPanel(inputPanel, gbc);

        // Thêm panel vào frame
        add(inputPanel, BorderLayout.SOUTH);

        // Thêm ListSelectionListener cho bảng
        dataTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    displaySelectedRow(selectedRow);
                }
            }
        });

        // Load dữ liệu ban đầu
        loadDataToTable();
    }

    private void initializeComponents() {
        // Khởi tạo các label
        lblMaMH = new JLabel("Mã môn học:");
        lblTenMH = new JLabel("Tên môn học:");
        lblTCLT = new JLabel("Tín chỉ lý thuyết:");
        lblTCTH = new JLabel("Tín chỉ thực hành:");
        lblMaKhoa = new JLabel("Mã khoa:");

        // Khởi tạo các text field
        txtMaMH = new JTextField(15);
        txtTenMH = new JTextField(15);
        txtTCLT = new JTextField(15);
        txtTCTH = new JTextField(15);
        txtMaKhoa = new JTextField(15);

        // Khởi tạo các nút chức năng
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");

        // Khởi tạo các components tìm kiếm
        lblSearchMaMHSearch = new JLabel("Tìm kiếm theo mã môn học:");
        txtSearchMaMHSearch = new JTextField(10);
        btnSearchMaMHSearch = new JButton("Tìm");

        lblSearchTCLTSearch = new JLabel("Tìm kiếm theo tín chỉ lý thuyết:");
        txtSearchTCLTSearch = new JTextField(10);
        btnSearchTCLTSearch = new JButton("Tìm");

        lblSearchTCTHSearch = new JLabel("Tìm kiếm theo tín chỉ thực hành:");
        txtSearchTCTHSearch = new JTextField(10);
        btnSearchTCTHSearch = new JButton("Tìm");

        lblSearchMaKhoaSearch = new JLabel("Tìm kiếm theo mã khoa:");
        txtSearchMaKhoaSearch = new JTextField(10);
        btnSearchMaKhoaSearch = new JButton("Tìm");
    }

    private void addComponentsToPanel(JPanel panel, GridBagConstraints gbc) {
        int row = 0;

        // Thêm các components vào panel theo thứ tự
        addComponent(panel, lblMaMH, txtMaMH, btnThem, 
                    lblSearchMaMHSearch, txtSearchMaMHSearch, btnSearchMaMHSearch, gbc, row++);
        
        addComponent(panel, lblTenMH, txtTenMH, btnSua, 
                    lblSearchTCLTSearch, txtSearchTCLTSearch, btnSearchTCLTSearch, gbc, row++);
        
        addComponent(panel, lblTCLT, txtTCLT, btnXoa, 
                    lblSearchTCTHSearch, txtSearchTCTHSearch, btnSearchTCTHSearch, gbc, row++);
        
        addComponent(panel, lblTCTH, txtTCTH, null, 
                    lblSearchMaKhoaSearch, txtSearchMaKhoaSearch, btnSearchMaKhoaSearch, gbc, row++);
        
        addComponent(panel, lblMaKhoa, txtMaKhoa, null, null, null, null, gbc, row);
    }

    private void addComponent(JPanel panel, JLabel label, JTextField textField, 
                            JButton actionButton, JLabel searchLabel, 
                            JTextField searchField, JButton searchButton,
                            GridBagConstraints gbc, int row) {
        gbc.gridy = row;

        if (label != null) {
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(label, gbc);
        }

        if (textField != null) {
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(textField, gbc);
        }

        if (actionButton != null) {
            gbc.gridx = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(actionButton, gbc);
        }

        if (searchLabel != null) {
            gbc.gridx = 3;
            gbc.anchor = GridBagConstraints.EAST;
            panel.add(searchLabel, gbc);
        }

        if (searchField != null) {
            gbc.gridx = 4;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(searchField, gbc);
        }

        if (searchButton != null) {
            gbc.gridx = 5;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(searchButton, gbc);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            themMonHoc();
        } else if (e.getSource() == btnSua) {
            suaMonHoc();
        } else if (e.getSource() == btnXoa) {
            xoaMonHoc();
        } else if (e.getSource() == btnSearchMaMHSearch) {
            timTheoMaMH();
        } else if (e.getSource() == btnSearchTCLTSearch) {
            timTheoTCLT();
        } else if (e.getSource() == btnSearchTCTHSearch) {
            timTheoTCTH();
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            timTheoMaKhoa();
        }
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<MonHoc> dsMonHoc = monHocDAO.getAllMonHoc();
        for (MonHoc mh : dsMonHoc) {
            Object[] row = {
                mh.getMaMH(),
                mh.getTenMH(),
                mh.getTCLT(),
                mh.getTCTH(),
                mh.getMaKhoa()
            };
            tableModel.addRow(row);
        }
    }

    private void displaySelectedRow(int row) {
        txtMaMH.setText(tableModel.getValueAt(row, 0).toString());
        txtTenMH.setText(tableModel.getValueAt(row, 1).toString());
        txtTCLT.setText(tableModel.getValueAt(row, 2).toString());
        txtTCTH.setText(tableModel.getValueAt(row, 3).toString());
        txtMaKhoa.setText(tableModel.getValueAt(row, 4).toString());
    }

    private MonHoc layThongTinTuForm() {
        MonHoc mh = new MonHoc();
        mh.setMaMH(txtMaMH.getText().trim());
        mh.setTenMH(txtTenMH.getText().trim());
        mh.setTCLT(Integer.parseInt(txtTCLT.getText().trim()));
        mh.setTCTH(Integer.parseInt(txtTCTH.getText().trim()));
        mh.setMaKhoa(txtMaKhoa.getText().trim());
        return mh;
    }

    private void xoaForm() {
        txtMaMH.setText("");
        txtTenMH.setText("");
        txtTCLT.setText("");
        txtTCTH.setText("");
        txtMaKhoa.setText("");
    }

    private void themMonHoc() {
        try {
            MonHoc mh = layThongTinTuForm();
            if (monHocDAO.themMonHoc(mh)) {
                JOptionPane.showMessageDialog(this, "Thêm môn học thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm môn học thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void suaMonHoc() {
        try {
            MonHoc mh = layThongTinTuForm();
            if (monHocDAO.suaMonHoc(mh)) {
                JOptionPane.showMessageDialog(this, "Cập nhật môn học thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật môn học thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void xoaMonHoc() {
        String maMH = txtMaMH.getText().trim();
        if (maMH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn môn học cần xóa!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn xóa môn học này?", 
            "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (monHocDAO.xoaMonHoc(maMH)) {
                JOptionPane.showMessageDialog(this, "Xóa môn học thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa môn học thất bại!");
            }
        }
    }

    private void timTheoMaMH() {
        String maMH = txtSearchMaMHSearch.getText().trim();
        if (maMH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã môn học cần tìm!");
            return;
        }
        
        MonHoc mh = monHocDAO.timTheoMaMH(maMH);
        if (mh != null) {
            tableModel.setRowCount(0);
            Object[] row = {
                mh.getMaMH(),
                mh.getTenMH(),
                mh.getTCLT(),
                mh.getTCTH(),
                mh.getMaKhoa()
            };
            tableModel.addRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy môn học!");
            loadDataToTable();
        }
    }

    private void timTheoTCLT() {
        try {
            int tclt = Integer.parseInt(txtSearchTCLTSearch.getText().trim());
            List<MonHoc> dsMonHoc = monHocDAO.timTheoTCLT(tclt);
            hienThiKetQuaTimKiem(dsMonHoc);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tín chỉ lý thuyết hợp lệ!");
        }
    }

    private void timTheoTCTH() {
        try {
            int tcth = Integer.parseInt(txtSearchTCTHSearch.getText().trim());
            List<MonHoc> dsMonHoc = monHocDAO.timTheoTCTH(tcth);
            hienThiKetQuaTimKiem(dsMonHoc);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tín chỉ thực hành hợp lệ!");
        }
    }

    private void timTheoMaKhoa() {
        String maKhoa = txtSearchMaKhoaSearch.getText().trim();
        if (maKhoa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khoa cần tìm!");
            return;
        }
        
        List<MonHoc> dsMonHoc = monHocDAO.timTheoMaKhoa(maKhoa);
        hienThiKetQuaTimKiem(dsMonHoc);
    }

    private void hienThiKetQuaTimKiem(List<MonHoc> dsMonHoc) {
        tableModel.setRowCount(0);
        if (!dsMonHoc.isEmpty()) {
            for (MonHoc mh : dsMonHoc) {
                Object[] row = {
                    mh.getMaMH(),
                    mh.getTenMH(),
                    mh.getTCLT(),
                    mh.getTCTH(),
                    mh.getMaKhoa()
                };
                tableModel.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào!");
            loadDataToTable();
        }
    }
}
