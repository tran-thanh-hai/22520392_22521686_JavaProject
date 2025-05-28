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
import java.text.SimpleDateFormat;
import Controller.GiaoVienHomeController;
import Model.DAO.MonHocDAO;
import Model.Object.MonHoc;
import java.util.List;

/**
 *
 * @author rubik
 */
public class XemMonHoc extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

 
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

    private GiaoVienHomeController controller;

    private MonHocDAO monHocDAO;

    public XemMonHoc() {
        setTitle("Xem Môn học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);  
        setLocationRelativeTo(null);  
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);
 
        JPanel topPanel = new JPanel(new BorderLayout());

   
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

 
        lblTitle = new JLabel("Quản lý Môn học", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

 
        add(topPanel, BorderLayout.NORTH);

 
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

 
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int row = 0;

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

        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchTCLTSearch = new JLabel("Tìm kiếm theo tín chỉ lý thuyết:");
        inputPanel.add(lblSearchTCLTSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchTCLTSearch = new JTextField(10);
        inputPanel.add(txtSearchTCLTSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
 
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchTCTHSearch = new JLabel("Tìm kiếm theo tín chỉ thực hành:");
        inputPanel.add(lblSearchTCTHSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchTCTHSearch = new JTextField(10);
        inputPanel.add(txtSearchTCTHSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

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

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(inputPanel, BorderLayout.SOUTH);

        monHocDAO = new MonHocDAO();

        btnSearchMaMHSearch = new JButton("Tìm");
        btnSearchMaMHSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 0;
        inputPanel.add(btnSearchMaMHSearch, gbc);

        btnSearchTCLTSearch = new JButton("Tìm");
        btnSearchTCLTSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 1;
        inputPanel.add(btnSearchTCLTSearch, gbc);

        btnSearchTCTHSearch = new JButton("Tìm");
        btnSearchTCTHSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 2;
        inputPanel.add(btnSearchTCTHSearch, gbc);

        btnSearchMaKhoaSearch = new JButton("Tìm");
        btnSearchMaKhoaSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 3;
        inputPanel.add(btnSearchMaKhoaSearch, gbc);

        // Load dữ liệu ban đầu
        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<MonHoc> list = monHocDAO.getAllMonHoc();
        for (MonHoc mh : list) {
            tableModel.addRow(new Object[]{
                mh.getMaMH(),
                mh.getTenMH(),
                mh.getTCLT(),
                mh.getTCTH(),
                mh.getMaKhoa()
            });
        }
    }

    private void searchByMaMH() {
        String maMH = txtSearchMaMHSearch.getText().trim();
        if (!maMH.isEmpty()) {
            MonHoc mh = monHocDAO.timTheoMaMH(maMH);
            tableModel.setRowCount(0);
            if (mh != null) {
                tableModel.addRow(new Object[]{
                    mh.getMaMH(),
                    mh.getTenMH(),
                    mh.getTCLT(),
                    mh.getTCTH(),
                    mh.getMaKhoa()
                });
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy môn học với mã " + maMH, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            loadDataToTable();
        }
    }

    private void searchByTCLT() {
        try {
            int tclt = Integer.parseInt(txtSearchTCLTSearch.getText().trim());
            List<MonHoc> list = monHocDAO.timTheoTCLT(tclt);
            tableModel.setRowCount(0);
            for (MonHoc mh : list) {
                tableModel.addRow(new Object[]{
                    mh.getMaMH(),
                    mh.getTenMH(),
                    mh.getTCLT(),
                    mh.getTCTH(),
                    mh.getMaKhoa()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy môn học với số tín chỉ lý thuyết " + tclt, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Vui lòng nhập số tín chỉ hợp lệ!", 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchByTCTH() {
        try {
            int tcth = Integer.parseInt(txtSearchTCTHSearch.getText().trim());
            List<MonHoc> list = monHocDAO.timTheoTCTH(tcth);
            tableModel.setRowCount(0);
            for (MonHoc mh : list) {
                tableModel.addRow(new Object[]{
                    mh.getMaMH(),
                    mh.getTenMH(),
                    mh.getTCLT(),
                    mh.getTCTH(),
                    mh.getMaKhoa()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy môn học với số tín chỉ thực hành " + tcth, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Vui lòng nhập số tín chỉ hợp lệ!", 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchByMaKhoa() {
        String maKhoa = txtSearchMaKhoaSearch.getText().trim();
        if (!maKhoa.isEmpty()) {
            List<MonHoc> list = monHocDAO.timTheoMaKhoa(maKhoa);
            tableModel.setRowCount(0);
            for (MonHoc mh : list) {
                tableModel.addRow(new Object[]{
                    mh.getMaMH(),
                    mh.getTenMH(),
                    mh.getTCLT(),
                    mh.getTCTH(),
                    mh.getMaKhoa()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy môn học thuộc khoa " + maKhoa, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            loadDataToTable();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnSearchMaMHSearch) {
            searchByMaMH();
        } else if (e.getSource() == btnSearchTCLTSearch) {
            searchByTCLT();
        } else if (e.getSource() == btnSearchTCTHSearch) {
            searchByTCTH();
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            searchByMaKhoa();
        }
    }
}
