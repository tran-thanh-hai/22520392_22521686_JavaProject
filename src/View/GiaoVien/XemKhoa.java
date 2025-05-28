/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.GiaoVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author rubik
 */

public class XemKhoa extends JFrame {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;



    private JLabel lblSearchMaKhoaSearch;
    private JTextField txtSearchMaKhoaSearch;
    private JButton btnSearchMaKhoaSearch;

    public XemKhoa() {
        setTitle("Xem Khoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tiêu đề
        lblTitle = new JLabel("Quản Lý Khoa", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new XemKhoa().setVisible(true);
        });
    }
}

