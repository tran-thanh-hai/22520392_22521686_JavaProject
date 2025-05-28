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
import DAO.KhoaDAO;
import Model.Khoa;
import java.util.List;

/**
 *
 * @author rubik
 */

public class XemKhoa extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private JLabel lblSearchMaKhoaSearch;
    private JTextField txtSearchMaKhoaSearch;
    private JButton btnSearchMaKhoaSearch;

    private JButton btnBackToHome;

    private GiaoVienHomeController controller;
    private KhoaDAO khoaDAO;

    public XemKhoa() {
        setTitle("Xem Khoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);
        khoaDAO = new KhoaDAO();

        // Create a panel for the back button and title
        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        // Tiêu đề
        lblTitle = new JLabel("Quản Lý Khoa", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        // Add the top panel to the frame
        add(topPanel, BorderLayout.NORTH);

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

        // Panel tìm kiếm
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        lblSearchMaKhoaSearch = new JLabel("Tìm kiếm theo mã khoa:");
        searchPanel.add(lblSearchMaKhoaSearch);
        
        txtSearchMaKhoaSearch = new JTextField(15);
        searchPanel.add(txtSearchMaKhoaSearch);
        
        btnSearchMaKhoaSearch = new JButton("Tìm");
        btnSearchMaKhoaSearch.addActionListener(this);
        searchPanel.add(btnSearchMaKhoaSearch);

        add(searchPanel, BorderLayout.SOUTH);

        // Load dữ liệu ban đầu
        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<Khoa> danhSachKhoa = khoaDAO.getAllKhoa();
        for (Khoa khoa : danhSachKhoa) {
            tableModel.addRow(new Object[]{
                khoa.getMaKhoa(),
                khoa.getTenKhoa(),
                khoa.getNgThanhLap(),
                khoa.getTrgKhoa()
            });
        }
    }

    private void searchKhoa() {
        String maKhoa = txtSearchMaKhoaSearch.getText().trim();
        if (!maKhoa.isEmpty()) {
            Khoa khoa = khoaDAO.timKhoaTheoMa(maKhoa);
            tableModel.setRowCount(0);
            if (khoa != null) {
                tableModel.addRow(new Object[]{
                    khoa.getMaKhoa(),
                    khoa.getTenKhoa(),
                    khoa.getNgThanhLap(),
                    khoa.getTrgKhoa()
                });
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy khoa với mã " + maKhoa, 
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
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            searchKhoa();
        }
    }
}

