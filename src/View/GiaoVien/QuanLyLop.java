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
import Model.DAO.LopDAO;
import Model.Object.Lop;
import java.util.List;

/**
 *
 * @author rubik
 */
public class QuanLyLop extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;


    private JLabel lblMaLop;
    private JTextField txtMaLop;
    private JLabel lblTenLop;
    private JTextField txtTenLop;
    private JLabel lblTruongLop;
    private JTextField txtTruongLop;
    private JLabel lblSiSo;
    private JTextField txtSiSo;
    private JLabel lblMaGVCN;
    private JTextField txtMaGVCN;


    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;


    private JLabel lblSearchMaLopSearch;
    private JTextField txtSearchMaLopSearch;
    private JButton btnSearchMaLopSearch;
    private JLabel lblSearchMaGVSearch;
    private JTextField txtSearchMaGVSearch;
    private JButton btnSearchMaGVSearch;

    private JButton btnBackToHome;

    private GiaoVienHomeController controller;

    private LopDAO lopDAO;

    public QuanLyLop() {
        setTitle("Quản lý Lớp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);

        JPanel topPanel = new JPanel(new BorderLayout());


        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);


        lblTitle = new JLabel("Quản lý Lớp", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);


        add(topPanel, BorderLayout.NORTH);


        tableModel = new DefaultTableModel();

        tableModel.addColumn("Mã lớp");
        tableModel.addColumn("Tên lớp");
        tableModel.addColumn("Trưởng lớp");
        tableModel.addColumn("Sĩ số");
        tableModel.addColumn("Mã GVCN");

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
        lblTenLop = new JLabel("Tên lớp:");
        inputPanel.add(lblTenLop, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtTenLop = new JTextField(15);
        inputPanel.add(txtTenLop, gbc);


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
        lblSearchMaGVSearch = new JLabel("Tìm kiếm theo mã GVCN:");
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
        lblTruongLop = new JLabel("Trưởng lớp:");
        inputPanel.add(lblTruongLop, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtTruongLop = new JTextField(15);
        inputPanel.add(txtTruongLop, gbc);


        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblSiSo = new JLabel("Sĩ số:");
        inputPanel.add(lblSiSo, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtSiSo = new JTextField(15);
        inputPanel.add(txtSiSo, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaGVCN = new JLabel("Mã GVCN:");
        inputPanel.add(lblMaGVCN, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaGVCN = new JTextField(15);
        inputPanel.add(txtMaGVCN, gbc);


        add(inputPanel, BorderLayout.SOUTH);

        // Khởi tạo DAO
        lopDAO = new LopDAO();
        
        // Thêm action listeners cho các nút
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSearchMaLopSearch.addActionListener(this);
        btnSearchMaGVSearch.addActionListener(this);
        
        // Load dữ liệu ban đầu
        loadDataToTable();

        // Thêm listener cho bảng
        dataTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMaLop.setText(dataTable.getValueAt(selectedRow, 0).toString());
                    txtTenLop.setText(dataTable.getValueAt(selectedRow, 1).toString());
                    txtTruongLop.setText(dataTable.getValueAt(selectedRow, 2).toString());
                    txtSiSo.setText(dataTable.getValueAt(selectedRow, 3).toString());
                    txtMaGVCN.setText(dataTable.getValueAt(selectedRow, 4).toString());
                }
            }
        });
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<Lop> list = lopDAO.getAllLop();
        for (Lop lop : list) {
            tableModel.addRow(new Object[]{
                lop.getMaLop(),
                lop.getTenLop(),
                lop.getTrgLop(),
                lop.getSiSo(),
                lop.getMaGVCN()
            });
        }
    }

    private void clearFields() {
        txtMaLop.setText("");
        txtTenLop.setText("");
        txtTruongLop.setText("");
        txtSiSo.setText("");
        txtMaGVCN.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            try {
                Lop lop = new Lop();
                lop.setMaLop(txtMaLop.getText());
                lop.setTenLop(txtTenLop.getText());
                lop.setTrgLop(txtTruongLop.getText());
                lop.setSiSo(Integer.parseInt(txtSiSo.getText()));
                lop.setMaGVCN(txtMaGVCN.getText());
                
                if (lopDAO.themLop(lop)) {
                    JOptionPane.showMessageDialog(this, "Thêm lớp thành công!");
                    loadDataToTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm lớp thất bại!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Sĩ số phải là số nguyên!");
            }
        } else if (e.getSource() == btnSua) {
            try {
                Lop lop = new Lop();
                lop.setMaLop(txtMaLop.getText());
                lop.setTenLop(txtTenLop.getText());
                lop.setTrgLop(txtTruongLop.getText());
                lop.setSiSo(Integer.parseInt(txtSiSo.getText()));
                lop.setMaGVCN(txtMaGVCN.getText());
                
                if (lopDAO.suaLop(lop)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật lớp thành công!");
                    loadDataToTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật lớp thất bại!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Sĩ số phải là số nguyên!");
            }
        } else if (e.getSource() == btnXoa) {
            String maLop = txtMaLop.getText();
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa lớp này?", 
                "Xác nhận xóa", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (lopDAO.xoaLop(maLop)) {
                    JOptionPane.showMessageDialog(this, "Xóa lớp thành công!");
                    loadDataToTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa lớp thất bại!");
                }
            }
        } else if (e.getSource() == btnSearchMaLopSearch) {
            String maLop = txtSearchMaLopSearch.getText();
            if (!maLop.isEmpty()) {
                List<Lop> list = lopDAO.timKiemTheoMaLop(maLop);
                tableModel.setRowCount(0);
                for (Lop lop : list) {
                    tableModel.addRow(new Object[]{
                        lop.getMaLop(),
                        lop.getTenLop(),
                        lop.getTrgLop(),
                        lop.getSiSo(),
                        lop.getMaGVCN()
                    });
                }
            } else {
                loadDataToTable();
            }
        } else if (e.getSource() == btnSearchMaGVSearch) {
            String maGVCN = txtSearchMaGVSearch.getText();
            if (!maGVCN.isEmpty()) {
                List<Lop> list = lopDAO.timKiemTheoMaGVCN(maGVCN);
                tableModel.setRowCount(0);
                for (Lop lop : list) {
                    tableModel.addRow(new Object[]{
                        lop.getMaLop(),
                        lop.getTenLop(),
                        lop.getTrgLop(),
                        lop.getSiSo(),
                        lop.getMaGVCN()
                    });
                }
            } else {
                loadDataToTable();
            }
        }
    }
}
