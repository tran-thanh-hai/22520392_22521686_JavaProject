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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.NhaTruongHomeController;
import Model.DAO.KhoaDAO;
import Model.Object.Khoa;
import java.util.List;

/**
 *
 * @author rubik
 */

public class QuanLyKhoa extends JFrame implements ActionListener {

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

    private JButton btnBackToHome;

    private NhaTruongHomeController controller;
    private KhoaDAO khoaDAO;

    public QuanLyKhoa() {
        setTitle("Quản Lý Khoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);
        khoaDAO = new KhoaDAO();

        JPanel topPanel = new JPanel(new BorderLayout());

        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        lblTitle = new JLabel("Quản Lý Khoa", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã khoa");
        tableModel.addColumn("Tên khoa");
        tableModel.addColumn("Ngày thành lập");
        tableModel.addColumn("Trưởng khoa");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMaKhoa.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    txtTenKhoa.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    txtNgayThanhLap.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    txtTruongKhoa.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    txtMaKhoa.setEnabled(false);
                }
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

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
        btnThem.addActionListener(this);
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
        btnSearchMaKhoaSearch.addActionListener(this);
        inputPanel.add(btnSearchMaKhoaSearch, gbc);

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
        btnSua.addActionListener(this);
        inputPanel.add(btnSua, gbc);

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
        btnXoa.addActionListener(this);
        inputPanel.add(btnXoa, gbc);

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

        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        
        List<Khoa> danhSachKhoa = khoaDAO.getAllKhoa();
        
        for (Khoa khoa : danhSachKhoa) {
            Object[] row = {
                khoa.getMaKhoa(),
                khoa.getTenKhoa(),
                khoa.getNgThanhLap(),
                khoa.getTrgKhoa()
            };
            tableModel.addRow(row);
        }
    }

    private void clearFields() {
        txtMaKhoa.setText("");
        txtTenKhoa.setText("");
        txtNgayThanhLap.setText("");
        txtTruongKhoa.setText("");
        txtMaKhoa.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            Khoa khoa = new Khoa();
            khoa.setMaKhoa(txtMaKhoa.getText());
            khoa.setTenKhoa(txtTenKhoa.getText());
            khoa.setNgThanhLap(txtNgayThanhLap.getText());
            khoa.setTrgKhoa(txtTruongKhoa.getText());

            if (khoaDAO.themKhoa(khoa)) {
                JOptionPane.showMessageDialog(this, "Thêm khoa thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khoa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnSua) {
            Khoa khoa = new Khoa();
            khoa.setMaKhoa(txtMaKhoa.getText());
            khoa.setTenKhoa(txtTenKhoa.getText());
            khoa.setNgThanhLap(txtNgayThanhLap.getText());
            khoa.setTrgKhoa(txtTruongKhoa.getText());

            if (khoaDAO.suaKhoa(khoa)) {
                JOptionPane.showMessageDialog(this, "Cập nhật khoa thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật khoa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnXoa) {
            String maKhoa = txtMaKhoa.getText();
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa khoa này?", 
                "Xác nhận xóa", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (khoaDAO.xoaKhoa(maKhoa)) {
                    JOptionPane.showMessageDialog(this, "Xóa khoa thành công!");
                    loadDataToTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa khoa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            String maKhoa = txtSearchMaKhoaSearch.getText();
            Khoa khoa = khoaDAO.timKhoaTheoMa(maKhoa);
            
            if (khoa != null) {
                tableModel.setRowCount(0);
                Object[] row = {
                    khoa.getMaKhoa(),
                    khoa.getTenKhoa(),
                    khoa.getNgThanhLap(),
                    khoa.getTrgKhoa()
                };
                tableModel.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy khoa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDataToTable();
            }
        }
    }
}

