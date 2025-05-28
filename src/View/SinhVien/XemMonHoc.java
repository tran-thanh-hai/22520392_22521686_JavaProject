/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.SinhVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import Controller.SinhVienHomeController;
import Model.MonHoc;
import DAO.MonHocDAO;
import java.util.List;

/**
 *
 * @author rubik
 */
public class XemMonHoc extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    // Labels and fields for course information


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

    private SinhVienHomeController controller;

    private MonHocDAO monHocDAO;

    public XemMonHoc() {
        setTitle("Xem Môn học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650); // Adjusted size for consistency
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        controller = new SinhVienHomeController(this);

        // Create a panel for the back button and title
        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        btnBackToHome = new JButton("Quay về trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        // Title Label
        lblTitle = new JLabel("Quản lý Môn học", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        // Add the top panel to the frame
        add(topPanel, BorderLayout.NORTH);

        // Data Display Area (using JTable)
        tableModel = new DefaultTableModel();
        // Define table columns based on MONHOC SQL table
        tableModel.addColumn("Mã MH");
        tableModel.addColumn("Tên MH");
        tableModel.addColumn("Tín chỉ lý thuyết");
        tableModel.addColumn("Tín chỉ thực hành");
        tableModel.addColumn("Mã khoa");

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

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaMHSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaMHSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;



        // Search by TCLT
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



        // Search by TCTH
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



        // Search by MaKhoa
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



        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);

        monHocDAO = new MonHocDAO();
        
        // Thêm action listeners cho các nút tìm kiếm
        btnSearchMaMHSearch = new JButton("Tìm");
        btnSearchTCLTSearch = new JButton("Tìm");
        btnSearchTCTHSearch = new JButton("Tìm");
        btnSearchMaKhoaSearch = new JButton("Tìm");
        
        btnSearchMaMHSearch.addActionListener(this);
        btnSearchTCLTSearch.addActionListener(this);
        btnSearchTCTHSearch.addActionListener(this);
        btnSearchMaKhoaSearch.addActionListener(this);
        
        // Thêm các nút tìm kiếm vào panel
        gbc.gridx = 5;
        gbc.gridy = 0;
        inputPanel.add(btnSearchMaMHSearch, gbc);
        
        gbc.gridy = 1;
        inputPanel.add(btnSearchTCLTSearch, gbc);
        
        gbc.gridy = 2;
        inputPanel.add(btnSearchTCTHSearch, gbc);
        
        gbc.gridy = 3;
        inputPanel.add(btnSearchMaKhoaSearch, gbc);
        
        // Load dữ liệu ban đầu
        loadDataToTable();
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

    private void timKiemTheoMaMH() {
        String maMH = txtSearchMaMHSearch.getText().trim();
        if (!maMH.isEmpty()) {
            MonHoc mh = monHocDAO.timTheoMaMH(maMH);
            tableModel.setRowCount(0);
            if (mh != null) {
                Object[] row = {
                    mh.getMaMH(),
                    mh.getTenMH(),
                    mh.getTCLT(),
                    mh.getTCTH(),
                    mh.getMaKhoa()
                };
                tableModel.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy môn học với mã " + maMH);
                loadDataToTable();
            }
        } else {
            loadDataToTable();
        }
    }

    private void timKiemTheoTCLT() {
        try {
            int tclt = Integer.parseInt(txtSearchTCLTSearch.getText().trim());
            List<MonHoc> dsMonHoc = monHocDAO.timTheoTCLT(tclt);
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
                JOptionPane.showMessageDialog(this, "Không tìm thấy môn học có số tín chỉ lý thuyết " + tclt);
                loadDataToTable();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tín chỉ lý thuyết hợp lệ!");
        }
    }

    private void timKiemTheoTCTH() {
        try {
            int tcth = Integer.parseInt(txtSearchTCTHSearch.getText().trim());
            List<MonHoc> dsMonHoc = monHocDAO.timTheoTCTH(tcth);
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
                JOptionPane.showMessageDialog(this, "Không tìm thấy môn học có số tín chỉ thực hành " + tcth);
                loadDataToTable();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tín chỉ thực hành hợp lệ!");
        }
    }

    private void timKiemTheoMaKhoa() {
        String maKhoa = txtSearchMaKhoaSearch.getText().trim();
        if (!maKhoa.isEmpty()) {
            List<MonHoc> dsMonHoc = monHocDAO.timTheoMaKhoa(maKhoa);
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
                JOptionPane.showMessageDialog(this, "Không tìm thấy môn học thuộc khoa " + maKhoa);
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
        } else if (e.getSource() == btnSearchMaMHSearch) {
            timKiemTheoMaMH();
        } else if (e.getSource() == btnSearchTCLTSearch) {
            timKiemTheoTCLT();
        } else if (e.getSource() == btnSearchTCTHSearch) {
            timKiemTheoTCTH();
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            timKiemTheoMaKhoa();
        }
    }
}
