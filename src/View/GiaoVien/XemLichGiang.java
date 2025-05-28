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
import Model.DAO.LichGiangDAO;
import Model.Object.LichGiang;
import java.util.List;

/**
 *
 * @author rubik
 */
public class XemLichGiang extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;


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

    private GiaoVienHomeController controller;

    private LichGiangDAO lichGiangDAO;

    public XemLichGiang() {
        setTitle("Xem Lịch Giảng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);


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
        gbc.insets = new Insets(5, 5, 5, 5);  
        gbc.fill = GridBagConstraints.HORIZONTAL;

 
        int row = 0;



        // Search by MaLop
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



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;



 
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



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;



 
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


        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;



 
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



        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

 

        row++;



 
        add(inputPanel, BorderLayout.SOUTH);

 
        lichGiangDAO = new LichGiangDAO();

 
        btnSearchMaLopSearch = new JButton("Tìm");
        btnSearchMaLopSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 0;
        inputPanel.add(btnSearchMaLopSearch, gbc);

        btnSearchMaMHSearch = new JButton("Tìm");
        btnSearchMaMHSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 1;
        inputPanel.add(btnSearchMaMHSearch, gbc);

        btnSearchMaGVSearch = new JButton("Tìm");
        btnSearchMaGVSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 2;
        inputPanel.add(btnSearchMaGVSearch, gbc);

        btnSearchHocKySearch = new JButton("Tìm");
        btnSearchHocKySearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 3;
        inputPanel.add(btnSearchHocKySearch, gbc);

        btnSearchNamSearch = new JButton("Tìm");
        btnSearchNamSearch.addActionListener(this);
        gbc.gridx = 5;
        gbc.gridy = 4;
        inputPanel.add(btnSearchNamSearch, gbc);

        // Load dữ liệu ban đầu
        loadDataToTable();
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<LichGiang> list = lichGiangDAO.getAllLichGiang();
        for (LichGiang lg : list) {
            tableModel.addRow(new Object[]{
                lg.getMaLop(),
                lg.getMaMH(),
                lg.getMaGV(),
                lg.getHocKy(),
                lg.getNam(),
                lg.getNgBatDau(),
                lg.getNgKetThuc()
            });
        }
    }

    private void searchByMaLop() {
        String maLop = txtSearchMaLopSearch.getText().trim();
        if (!maLop.isEmpty()) {
            List<LichGiang> list = lichGiangDAO.timTheoMaLop(maLop);
            tableModel.setRowCount(0);
            for (LichGiang lg : list) {
                tableModel.addRow(new Object[]{
                    lg.getMaLop(),
                    lg.getMaMH(),
                    lg.getMaGV(),
                    lg.getHocKy(),
                    lg.getNam(),
                    lg.getNgBatDau(),
                    lg.getNgKetThuc()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy lịch giảng cho lớp " + maLop, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            loadDataToTable();
        }
    }

    private void searchByMaMH() {
        String maMH = txtSearchMaMHSearch.getText().trim();
        if (!maMH.isEmpty()) {
            List<LichGiang> list = lichGiangDAO.timTheoMaMH(maMH);
            tableModel.setRowCount(0);
            for (LichGiang lg : list) {
                tableModel.addRow(new Object[]{
                    lg.getMaLop(),
                    lg.getMaMH(),
                    lg.getMaGV(),
                    lg.getHocKy(),
                    lg.getNam(),
                    lg.getNgBatDau(),
                    lg.getNgKetThuc()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy lịch giảng cho môn học " + maMH, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            loadDataToTable();
        }
    }

    private void searchByMaGV() {
        String maGV = txtSearchMaGVSearch.getText().trim();
        if (!maGV.isEmpty()) {
            List<LichGiang> list = lichGiangDAO.timTheoMaGV(maGV);
            tableModel.setRowCount(0);
            for (LichGiang lg : list) {
                tableModel.addRow(new Object[]{
                    lg.getMaLop(),
                    lg.getMaMH(),
                    lg.getMaGV(),
                    lg.getHocKy(),
                    lg.getNam(),
                    lg.getNgBatDau(),
                    lg.getNgKetThuc()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy lịch giảng cho giáo viên " + maGV, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            loadDataToTable();
        }
    }

    private void searchByHocKy() {
        String hocKy = txtSearchHocKySearch.getText().trim();
        if (!hocKy.isEmpty()) {
            List<LichGiang> list = lichGiangDAO.timTheoHocKy(hocKy);
            tableModel.setRowCount(0);
            for (LichGiang lg : list) {
                tableModel.addRow(new Object[]{
                    lg.getMaLop(),
                    lg.getMaMH(),
                    lg.getMaGV(),
                    lg.getHocKy(),
                    lg.getNam(),
                    lg.getNgBatDau(),
                    lg.getNgKetThuc()
                });
            }
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Không tìm thấy lịch giảng cho học kỳ " + hocKy, 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            loadDataToTable();
        }
    }

    private void searchByNam() {
        try {
            String namStr = txtSearchNamSearch.getText().trim();
            if (!namStr.isEmpty()) {
                int nam = Integer.parseInt(namStr);
                List<LichGiang> list = lichGiangDAO.timTheoNam(nam);
                tableModel.setRowCount(0);
                for (LichGiang lg : list) {
                    tableModel.addRow(new Object[]{
                        lg.getMaLop(),
                        lg.getMaMH(),
                        lg.getMaGV(),
                        lg.getHocKy(),
                        lg.getNam(),
                        lg.getNgBatDau(),
                        lg.getNgKetThuc()
                    });
                }
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Không tìm thấy lịch giảng cho năm " + nam, 
                        "Thông báo", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                loadDataToTable();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Vui lòng nhập năm hợp lệ!", 
                "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnSearchMaLopSearch) {
            searchByMaLop();
        } else if (e.getSource() == btnSearchMaMHSearch) {
            searchByMaMH();
        } else if (e.getSource() == btnSearchMaGVSearch) {
            searchByMaGV();
        } else if (e.getSource() == btnSearchHocKySearch) {
            searchByHocKy();
        } else if (e.getSource() == btnSearchNamSearch) {
            searchByNam();
        }
    }
}
