/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.GiaoVien;

import Model.DiemThi;
import DAO.DiemThiDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import Controller.GiaoVienHomeController;

/**
 *
 * @author rubik
 */
public class QuanLyDiemThi extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;


    private JLabel lblMaHV;
    private JTextField txtMaHV;
    private JLabel lblMaMH;
    private JTextField txtMaMH;
    private JLabel lblLanThi;
    private JTextField txtLanThi;
    private JLabel lblNgayThi;
    private JTextField txtNgayThi;
    private JLabel lblDiem;
    private JTextField txtDiem;
    private JLabel lblKetQua;
    private JTextField txtKetQua;


    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;


    private JLabel lblSearchMaMH;
    private JTextField txtSearchMaMH;
    private JButton btnSearchMaMH;
    private JLabel lblSearchLanThi;
    private JTextField txtSearchLanThi;
    private JButton btnSearchLanThi;
    private JLabel lblSearchDiem;
    private JTextField txtSearchDiem;
    private JButton btnSearchDiem;

    private JButton btnBackToHome;

    private GiaoVienHomeController controller;

    private DiemThiDAO diemThiDAO;

    public QuanLyDiemThi() {
        setTitle("Quản Lý Điểm Thi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);

        // Khởi tạo các thành phần giao diện
        initializeComponents();
        
        // Khởi tạo DAO và load dữ liệu
        diemThiDAO = new DiemThiDAO();
        loadDataToTable();

        // Thêm action listeners cho các nút
        addActionListeners();
    }

    private void initializeComponents() {
        // Panel trên cùng
        JPanel topPanel = new JPanel(new BorderLayout());
        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);

        lblTitle = new JLabel("Quản Lý Điểm Thi", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Khởi tạo table model và table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã HV");
        tableModel.addColumn("Mã MH");
        tableModel.addColumn("Lần thi");
        tableModel.addColumn("Ngày thi");
        tableModel.addColumn("Điểm");
        tableModel.addColumn("Kết quả");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Khởi tạo panel nhập liệu
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Khởi tạo các nút tìm kiếm
        btnSearchMaMH = new JButton("Tìm");
        btnSearchLanThi = new JButton("Tìm");
        btnSearchDiem = new JButton("Tìm");

        int row = 0;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaHV = new JLabel("Mã HV:");
        inputPanel.add(lblMaHV, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtMaHV = new JTextField(15);
        inputPanel.add(txtMaHV, gbc);


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
        lblSearchMaMH = new JLabel("Tìm kiếm theo mã môn học:");
        inputPanel.add(lblSearchMaMH, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaMH = new JTextField(10);
        inputPanel.add(txtSearchMaMH, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblMaMH = new JLabel("Mã MH:");
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
        lblSearchLanThi = new JLabel("Tìm kiếm theo lần thi:");
        inputPanel.add(lblSearchLanThi, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchLanThi = new JTextField(10);
        inputPanel.add(txtSearchLanThi, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblLanThi = new JLabel("Lần thi:");
        inputPanel.add(lblLanThi, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtLanThi = new JTextField(15);
        inputPanel.add(txtLanThi, gbc);

 
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
        lblSearchDiem = new JLabel("Tìm kiếm theo điểm thi:");
        inputPanel.add(lblSearchDiem, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchDiem = new JTextField(10);
        inputPanel.add(txtSearchDiem, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblNgayThi = new JLabel("Ngày thi:");
        inputPanel.add(lblNgayThi, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtNgayThi = new JTextField(15);
        inputPanel.add(txtNgayThi, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblDiem = new JLabel("Điểm:");
        inputPanel.add(lblDiem, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtDiem = new JTextField(15);
        inputPanel.add(txtDiem, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        lblKetQua = new JLabel("Kết quả:");
        inputPanel.add(lblKetQua, gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        txtKetQua = new JTextField(15);
        inputPanel.add(txtKetQua, gbc);


        add(inputPanel, BorderLayout.SOUTH);

        // Thêm mouse listener cho bảng
        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = dataTable.getSelectedRow();
                if (row >= 0) {
                    txtMaHV.setText(dataTable.getValueAt(row, 0).toString());
                    txtMaMH.setText(dataTable.getValueAt(row, 1).toString());
                    txtLanThi.setText(dataTable.getValueAt(row, 2).toString());
                    txtNgayThi.setText(dataTable.getValueAt(row, 3).toString());
                    txtDiem.setText(dataTable.getValueAt(row, 4).toString());
                    txtKetQua.setText(dataTable.getValueAt(row, 5).toString());
                }
            }
        });
    }

    private void addActionListeners() {
        btnBackToHome.addActionListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSearchMaMH.addActionListener(this);
        btnSearchLanThi.addActionListener(this);
        btnSearchDiem.addActionListener(this);
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<DiemThi> list = diemThiDAO.getAllDiemThi();
        for (DiemThi dt : list) {
            Object[] row = {
                dt.getMaHV(),
                dt.getMaMH(),
                dt.getLanThi(),
                dt.getNgThi(),
                dt.getDiem(),
                dt.getKetQua()
            };
            tableModel.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            themDiemThi();
        } else if (e.getSource() == btnSua) {
            suaDiemThi();
        } else if (e.getSource() == btnXoa) {
            xoaDiemThi();
        } else if (e.getSource() == btnSearchMaMH) {
            timKiemTheoMaMH();
        } else if (e.getSource() == btnSearchLanThi) {
            timKiemTheoLanThi();
        } else if (e.getSource() == btnSearchDiem) {
            timKiemTheoDiem();
        }
    }

    private void themDiemThi() {
        try {
            DiemThi dt = new DiemThi();
            dt.setMaHV(txtMaHV.getText());
            dt.setMaMH(txtMaMH.getText());
            dt.setLanThi(Integer.parseInt(txtLanThi.getText()));
            dt.setNgThi(txtNgayThi.getText());
            dt.setDiem(Float.parseFloat(txtDiem.getText()));
            dt.setKetQua(txtKetQua.getText());

            if (diemThiDAO.themDiemThi(dt)) {
                JOptionPane.showMessageDialog(this, "Thêm điểm thi thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm điểm thi thất bại!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số!");
        }
    }

    private void suaDiemThi() {
        try {
            DiemThi dt = new DiemThi();
            dt.setMaHV(txtMaHV.getText());
            dt.setMaMH(txtMaMH.getText());
            dt.setLanThi(Integer.parseInt(txtLanThi.getText()));
            dt.setNgThi(txtNgayThi.getText());
            dt.setDiem(Float.parseFloat(txtDiem.getText()));
            dt.setKetQua(txtKetQua.getText());

            if (diemThiDAO.suaDiemThi(dt)) {
                JOptionPane.showMessageDialog(this, "Cập nhật điểm thi thành công!");
                loadDataToTable();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật điểm thi thất bại!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số!");
        }
    }

    private void xoaDiemThi() {
        int row = dataTable.getSelectedRow();
        if (row >= 0) {
            String maHV = txtMaHV.getText();
            String maMH = txtMaMH.getText();
            int lanThi = Integer.parseInt(txtLanThi.getText());

            int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc muốn xóa điểm thi này?", 
                "Xác nhận xóa", 
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (diemThiDAO.xoaDiemThi(maHV, maMH, lanThi)) {
                    JOptionPane.showMessageDialog(this, "Xóa điểm thi thành công!");
                    loadDataToTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa điểm thi thất bại!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn điểm thi cần xóa!");
        }
    }

    private void timKiemTheoMaMH() {
        String maMH = txtSearchMaMH.getText();
        if (!maMH.isEmpty()) {
            tableModel.setRowCount(0);
            List<DiemThi> list = diemThiDAO.timKiemTheoMaMH(maMH);
            for (DiemThi dt : list) {
                Object[] row = {
                    dt.getMaHV(),
                    dt.getMaMH(),
                    dt.getLanThi(),
                    dt.getNgThi(),
                    dt.getDiem(),
                    dt.getKetQua()
                };
                tableModel.addRow(row);
            }
        } else {
            loadDataToTable();
        }
    }

    private void timKiemTheoLanThi() {
        try {
            int lanThi = Integer.parseInt(txtSearchLanThi.getText());
            tableModel.setRowCount(0);
            List<DiemThi> list = diemThiDAO.timKiemTheoLanThi(lanThi);
            for (DiemThi dt : list) {
                Object[] row = {
                    dt.getMaHV(),
                    dt.getMaMH(),
                    dt.getLanThi(),
                    dt.getNgThi(),
                    dt.getDiem(),
                    dt.getKetQua()
                };
                tableModel.addRow(row);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lần thi hợp lệ!");
        }
    }

    private void timKiemTheoDiem() {
        try {
            float diem = Float.parseFloat(txtSearchDiem.getText());
            tableModel.setRowCount(0);
            List<DiemThi> list = diemThiDAO.timKiemTheoDiem(diem);
            for (DiemThi dt : list) {
                Object[] row = {
                    dt.getMaHV(),
                    dt.getMaMH(),
                    dt.getLanThi(),
                    dt.getNgThi(),
                    dt.getDiem(),
                    dt.getKetQua()
                };
                tableModel.addRow(row);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điểm hợp lệ!");
        }
    }

    private void clearFields() {
        txtMaHV.setText("");
        txtMaMH.setText("");
        txtLanThi.setText("");
        txtNgayThi.setText("");
        txtDiem.setText("");
        txtKetQua.setText("");
        txtSearchMaMH.setText("");
        txtSearchLanThi.setText("");
        txtSearchDiem.setText("");
    }
}
