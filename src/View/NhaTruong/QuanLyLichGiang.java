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
import Model.DAO.LichGiangDAO;
import Model.Object.LichGiang;
import java.util.List;

/**
 *
 * @author rubik
 */
public class QuanLyLichGiang extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

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

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

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

    private JButton btnBackToHome;

    private NhaTruongHomeController controller;

    private LichGiangDAO lichGiangDAO;

    public QuanLyLichGiang() {
        setTitle("Quản Lý Lịch Giảng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650); // Adjusted size for consistency
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);

        JPanel topPanel = new JPanel(new BorderLayout());

        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        lblTitle = new JLabel("Quản Lý Lịch Giảng", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
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

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

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
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);

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
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

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
        lblHocKy = new JLabel("Học kỳ:");
        inputPanel.add(lblHocKy, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtHocKy = new JTextField(15);
        inputPanel.add(txtHocKy, gbc);

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

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchHocKySearch = new JButton("Tìm");
        inputPanel.add(btnSearchHocKySearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

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

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchNamSearch = new JButton("Tìm");
        inputPanel.add(btnSearchNamSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

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

        add(inputPanel, BorderLayout.SOUTH);

        lichGiangDAO = new LichGiangDAO();
        
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSearchMaLopSearch.addActionListener(this);
        btnSearchMaMHSearch.addActionListener(this);
        btnSearchMaGVSearch.addActionListener(this);
        btnSearchHocKySearch.addActionListener(this);
        btnSearchNamSearch.addActionListener(this);
        
        dataTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    displaySelectedRow(selectedRow);
                }
            }
        });
        
        loadDataToTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            themLichGiang();
        } else if (e.getSource() == btnSua) {
            suaLichGiang();
        } else if (e.getSource() == btnXoa) {
            xoaLichGiang();
        } else if (e.getSource() == btnSearchMaLopSearch) {
            timTheoMaLop();
        } else if (e.getSource() == btnSearchMaMHSearch) {
            timTheoMaMH();
        } else if (e.getSource() == btnSearchMaGVSearch) {
            timTheoMaGV();
        } else if (e.getSource() == btnSearchHocKySearch) {
            timTheoHocKy();
        } else if (e.getSource() == btnSearchNamSearch) {
            timTheoNam();
        }
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<LichGiang> dsLichGiang = lichGiangDAO.getAllLichGiang();
        for (LichGiang lg : dsLichGiang) {
            addLichGiangToTable(lg);
        }
    }

    private void addLichGiangToTable(LichGiang lg) {
        Object[] row = {
            lg.getMaLop(),
            lg.getMaMH(),
            lg.getMaGV(),
            lg.getHocKy(),
            lg.getNam(),
            lg.getNgBatDau(),
            lg.getNgKetThuc()
        };
        tableModel.addRow(row);
    }

    private void displaySelectedRow(int row) {
        txtMaLop.setText(tableModel.getValueAt(row, 0).toString());
        txtMaMH.setText(tableModel.getValueAt(row, 1).toString());
        txtMaGV.setText(tableModel.getValueAt(row, 2).toString());
        txtHocKy.setText(tableModel.getValueAt(row, 3).toString());
        txtNam.setText(tableModel.getValueAt(row, 4).toString());
        txtTuNgay.setText(tableModel.getValueAt(row, 5).toString());
        txtDenNgay.setText(tableModel.getValueAt(row, 6).toString());
    }

    private LichGiang layThongTinTuForm() {
        LichGiang lg = new LichGiang();
        lg.setMaLop(txtMaLop.getText().trim());
        lg.setMaMH(txtMaMH.getText().trim());
        lg.setMaGV(txtMaGV.getText().trim());
        lg.setHocKy(txtHocKy.getText().trim());
        lg.setNam(Integer.parseInt(txtNam.getText().trim()));
        lg.setNgBatDau(txtTuNgay.getText().trim());
        lg.setNgKetThuc(txtDenNgay.getText().trim());
        return lg;
    }

    private void xoaForm() {
        txtMaLop.setText("");
        txtMaMH.setText("");
        txtMaGV.setText("");
        txtHocKy.setText("");
        txtNam.setText("");
        txtTuNgay.setText("");
        txtDenNgay.setText("");
    }

    private void themLichGiang() {
        try {
            LichGiang lg = layThongTinTuForm();
            if (lichGiangDAO.themLichGiang(lg)) {
                JOptionPane.showMessageDialog(this, "Thêm lịch giảng thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm lịch giảng thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void suaLichGiang() {
        try {
            LichGiang lg = layThongTinTuForm();
            if (lichGiangDAO.suaLichGiang(lg)) {
                JOptionPane.showMessageDialog(this, "Cập nhật lịch giảng thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật lịch giảng thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }

    private void xoaLichGiang() {
        String maLop = txtMaLop.getText().trim();
        String maMH = txtMaMH.getText().trim();
        String maGV = txtMaGV.getText().trim();
        
        if (maLop.isEmpty() || maMH.isEmpty() || maGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn lịch giảng cần xóa!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn xóa lịch giảng này?", 
            "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (lichGiangDAO.xoaLichGiang(maLop, maMH, maGV)) {
                JOptionPane.showMessageDialog(this, "Xóa lịch giảng thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa lịch giảng thất bại!");
            }
        }
    }

    private void timTheoMaLop() {
        String maLop = txtSearchMaLopSearch.getText().trim();
        if (maLop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã lớp cần tìm!");
            return;
        }
        
        List<LichGiang> ketQua = lichGiangDAO.timTheoMaLop(maLop);
        hienThiKetQuaTimKiem(ketQua);
    }

    private void timTheoMaMH() {
        String maMH = txtSearchMaMHSearch.getText().trim();
        if (maMH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã môn học cần tìm!");
            return;
        }
        
        List<LichGiang> ketQua = lichGiangDAO.timTheoMaMH(maMH);
        hienThiKetQuaTimKiem(ketQua);
    }

    private void timTheoMaGV() {
        String maGV = txtSearchMaGVSearch.getText().trim();
        if (maGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã giáo viên cần tìm!");
            return;
        }
        
        List<LichGiang> ketQua = lichGiangDAO.timTheoMaGV(maGV);
        hienThiKetQuaTimKiem(ketQua);
    }

    private void timTheoHocKy() {
        String hocKy = txtSearchHocKySearch.getText().trim();
        if (hocKy.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập học kỳ cần tìm!");
            return;
        }
        
        List<LichGiang> ketQua = lichGiangDAO.timTheoHocKy(hocKy);
        hienThiKetQuaTimKiem(ketQua);
    }

    private void timTheoNam() {
        try {
            int nam = Integer.parseInt(txtSearchNamSearch.getText().trim());
            List<LichGiang> ketQua = lichGiangDAO.timTheoNam(nam);
            hienThiKetQuaTimKiem(ketQua);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập năm hợp lệ!");
        }
    }

    private void hienThiKetQuaTimKiem(List<LichGiang> dsLichGiang) {
        tableModel.setRowCount(0);
        if (!dsLichGiang.isEmpty()) {
            for (LichGiang lg : dsLichGiang) {
                addLichGiangToTable(lg);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào!");
            loadDataToTable();
        }
    }
}
