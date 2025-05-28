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
import Model.Lop;
import DAO.LopDAO;
import java.util.List;

/**
 *
 * @author rubik
 */
public class XemLop extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;



    // Search components
    private JLabel lblSearchMaLopSearch;
    private JTextField txtSearchMaLopSearch;
    private JButton btnSearchMaLopSearch;
    private JLabel lblSearchMaGVSearch;
    private JTextField txtSearchMaGVSearch;
    private JButton btnSearchMaGVSearch;

    private JButton btnBackToHome;

    private SinhVienHomeController controller;

    private LopDAO lopDAO;

    public XemLop() {
        setTitle("Xem Lớp");
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
        lblTitle = new JLabel("Xem Lớp", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        // Add the top panel to the frame
        add(topPanel, BorderLayout.NORTH);

        // Data Display Area (using JTable)
        tableModel = new DefaultTableModel();
        // Define table columns based on LOP SQL table
        tableModel.addColumn("Mã lớp");
        tableModel.addColumn("Tên lớp");
        tableModel.addColumn("Trưởng lớp");
        tableModel.addColumn("Sĩ số");
        tableModel.addColumn("Mã GVCN");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Input and Action Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // Khởi tạo và thêm components tìm kiếm theo mã lớp
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

        // Khởi tạo nút tìm kiếm mã lớp
        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaLopSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaLopSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo và thêm components tìm kiếm theo mã GVCN
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaGVSearch = new JLabel("Tìm kiếm theo mã GVCN:");
        inputPanel.add(lblSearchMaGVSearch, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaGVSearch = new JTextField(10);
        inputPanel.add(txtSearchMaGVSearch, gbc);

        // Khởi tạo nút tìm kiếm mã GVCN
        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaGVSearch = new JButton("Tìm");
        inputPanel.add(btnSearchMaGVSearch, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);

        // Khởi tạo DAO
        lopDAO = new LopDAO();
        
        // Thêm action listeners cho các nút tìm kiếm
        btnSearchMaLopSearch.addActionListener(this);
        btnSearchMaGVSearch.addActionListener(this);
        
        // Load dữ liệu ban đầu
        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<Lop> dsLop = lopDAO.getAllLop();
        for (Lop lop : dsLop) {
            Object[] row = {
                lop.getMaLop(),
                lop.getTenLop(),
                lop.getTrgLop(),
                lop.getSiSo(),
                lop.getMaGVCN()
            };
            tableModel.addRow(row);
        }
    }

    private void timKiemTheoMaLop() {
        String maLop = txtSearchMaLopSearch.getText().trim();
        if (!maLop.isEmpty()) {
            List<Lop> dsLop = lopDAO.timKiemTheoMaLop(maLop);
            tableModel.setRowCount(0);
            if (!dsLop.isEmpty()) {
                for (Lop lop : dsLop) {
                    Object[] row = {
                        lop.getMaLop(),
                        lop.getTenLop(),
                        lop.getTrgLop(),
                        lop.getSiSo(),
                        lop.getMaGVCN()
                    };
                    tableModel.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp với mã " + maLop);
                loadDataToTable();
            }
        } else {
            loadDataToTable();
        }
    }

    private void timKiemTheoMaGVCN() {
        String maGVCN = txtSearchMaGVSearch.getText().trim();
        if (!maGVCN.isEmpty()) {
            List<Lop> dsLop = lopDAO.timKiemTheoMaGVCN(maGVCN);
            tableModel.setRowCount(0);
            if (!dsLop.isEmpty()) {
                for (Lop lop : dsLop) {
                    Object[] row = {
                        lop.getMaLop(),
                        lop.getTenLop(),
                        lop.getTrgLop(),
                        lop.getSiSo(),
                        lop.getMaGVCN()
                    };
                    tableModel.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lớp với mã GVCN " + maGVCN);
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
        } else if (e.getSource() == btnSearchMaLopSearch) {
            timKiemTheoMaLop();
        } else if (e.getSource() == btnSearchMaGVSearch) {
            timKiemTheoMaGVCN();
        }
    }
}
