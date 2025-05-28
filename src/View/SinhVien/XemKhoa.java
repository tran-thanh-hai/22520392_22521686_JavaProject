/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.SinhVien;

import Model.Object.Khoa;
import Model.DAO.KhoaDAO;
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

public class XemKhoa extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;



    private JLabel lblSearchMaKhoaSearch;
    private JTextField txtSearchMaKhoaSearch;
    private JButton btnSearchMaKhoaSearch;

    private JButton btnBackToHome;

    private SinhVienHomeController controller;

    private KhoaDAO khoaDAO;

    public XemKhoa() {
        setTitle("Xem Khoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new SinhVienHomeController(this);

        // Create a panel for the back button and title
        JPanel topPanel = new JPanel(new BorderLayout());

        // Back Button
        btnBackToHome = new JButton("Quay về trang chủ");
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

        // Panel nhập liệu và nút hành động
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;





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
        inputPanel.add(btnSearchMaKhoaSearch, gbc);





        add(inputPanel, BorderLayout.SOUTH);

        khoaDAO = new KhoaDAO();
        
        // Thêm action listener cho nút tìm kiếm
        btnSearchMaKhoaSearch.addActionListener(this);
        
        // Load dữ liệu ban đầu
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

    private void timKiemTheoMaKhoa() {
        String maKhoa = txtSearchMaKhoaSearch.getText().trim();
        if (!maKhoa.isEmpty()) {
            Khoa khoa = khoaDAO.timKhoaTheoMa(maKhoa);
            tableModel.setRowCount(0);
            if (khoa != null) {
                Object[] row = {
                    khoa.getMaKhoa(),
                    khoa.getTenKhoa(),
                    khoa.getNgThanhLap(),
                    khoa.getTrgKhoa()
                };
                tableModel.addRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy khoa với mã " + maKhoa);
                loadDataToTable(); // Load lại toàn bộ dữ liệu nếu không tìm thấy
            }
        } else {
            loadDataToTable(); // Load lại toàn bộ dữ liệu nếu ô tìm kiếm trống
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnSearchMaKhoaSearch) {
            timKiemTheoMaKhoa();
        }
    }


}

