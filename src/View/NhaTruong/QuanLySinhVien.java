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
import Controller.NhaTruongHomeController;
import Model.DAO.SinhVienDAO;
import Model.Object.SinhVien;
import java.util.List;

/**
 *
 * @author rubik
 */
public class QuanLySinhVien extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    private JLabel lblMaSV;
    private JTextField txtMaSV;
    private JLabel lblHoTenSV;
    private JTextField txtHoTenSV;
    private JLabel lblChucVu;
    private JTextField txtChucVu;
    private JLabel lblGioiTinh;
    private JTextField txtGioiTinh;
    private JLabel lblMaLop;
    private JTextField txtMaLop;
    private JLabel lblNgaySinh;
    private JTextField txtNgaySinh;
    private JLabel lblNoiSinh;
    private JTextField txtNoiSinh;

    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnTinhDiemTrungBinh;
    private JButton btnXepLoai;
    private JButton btnTinhDiemTrungBinhTatCa;
    private JButton btnXepLoaiTatCa;

    private JLabel lblSearchMaSV;
    private JTextField txtSearchMaSV;
    private JButton btnSearchMaSV;
    private JLabel lblSearchMaLop;
    private JTextField txtSearchMaLop;
    private JButton btnSearchMaLop;
    private JLabel lblSearchDiemTB;
    private JTextField txtSearchDiemTB;
    private JButton btnSearchDiemTB;
    private JLabel lblSearchXepLoai;
    private JTextField txtSearchXepLoai;
    private JButton btnSearchXepLoai;

    private JButton btnBackToHome;

    private NhaTruongHomeController controller;

    private SinhVienDAO sinhVienDAO;

    public QuanLySinhVien() {
        setTitle("Quản Lý Sinh Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new NhaTruongHomeController(this);

        sinhVienDAO = new SinhVienDAO();

        JPanel topPanel = new JPanel(new BorderLayout());

        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);

        lblTitle = new JLabel("Quản Lý Sinh Viên", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(lblTitle, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        initializeTable();

        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        addActionListeners();

        loadDataToTable();
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã sinh viên");
        tableModel.addColumn("Họ tên sinh viên");
        tableModel.addColumn("Chức vụ");
        tableModel.addColumn("Giới tính");
        tableModel.addColumn("Mã lớp");
        tableModel.addColumn("Ngày sinh");
        tableModel.addColumn("Nơi sinh");
        tableModel.addColumn("Điểm trung bình");
        tableModel.addColumn("Xếp loại");

        dataTable = new JTable(tableModel);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        dataTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = dataTable.getSelectedRow();
                if (selectedRow >= 0) {
                    displaySelectedRow(selectedRow);
                }
            }
        });
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        initializeComponents();

        addInputComponents(inputPanel, gbc);

        addActionButtons(inputPanel, gbc);

        addSearchComponents(inputPanel, gbc);

        return inputPanel;
    }

    private void initializeComponents() {
        lblMaSV = new JLabel("Mã sinh viên:");
        lblHoTenSV = new JLabel("Họ tên sinh viên:");
        lblChucVu = new JLabel("Chức vụ:");
        lblGioiTinh = new JLabel("Giới tính:");
        lblMaLop = new JLabel("Mã lớp:");
        lblNgaySinh = new JLabel("Ngày sinh:");
        lblNoiSinh = new JLabel("Nơi sinh:");

        txtMaSV = new JTextField(15);
        txtHoTenSV = new JTextField(15);
        txtChucVu = new JTextField(15);
        txtGioiTinh = new JTextField(15);
        txtMaLop = new JTextField(15);
        txtNgaySinh = new JTextField(15);
        txtNoiSinh = new JTextField(15);

        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnTinhDiemTrungBinh = new JButton("Tính điểm trung bình");
        btnXepLoai = new JButton("Xếp loại");
        btnTinhDiemTrungBinhTatCa = new JButton("Tính điểm TB tất cả");
        btnXepLoaiTatCa = new JButton("Xếp loại tất cả");

        lblSearchMaSV = new JLabel("Tìm theo mã SV:");
        lblSearchMaLop = new JLabel("Tìm theo mã lớp:");
        txtSearchMaSV = new JTextField(10);
        txtSearchMaLop = new JTextField(10);
        btnSearchMaSV = new JButton("Tìm");
        btnSearchMaLop = new JButton("Tìm");
    }

    private void addInputComponents(JPanel panel, GridBagConstraints gbc) {
        int row = 0;
        
        addComponent(panel, lblMaSV, txtMaSV, gbc, row++);
        addComponent(panel, lblHoTenSV, txtHoTenSV, gbc, row++);
        addComponent(panel, lblChucVu, txtChucVu, gbc, row++);
        addComponent(panel, lblGioiTinh, txtGioiTinh, gbc, row++);
        addComponent(panel, lblMaLop, txtMaLop, gbc, row++);
        addComponent(panel, lblNgaySinh, txtNgaySinh, gbc, row++);
        addComponent(panel, lblNoiSinh, txtNoiSinh, gbc, row);
    }

    private void addComponent(JPanel panel, JLabel label, JTextField textField, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private void addActionButtons(JPanel panel, GridBagConstraints gbc) {
        JPanel buttonPanel = new JPanel(new GridLayout(7, 1, 5, 5));
        buttonPanel.add(btnThem);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnTinhDiemTrungBinh);
        buttonPanel.add(btnTinhDiemTrungBinhTatCa);
        buttonPanel.add(btnXepLoai);
        buttonPanel.add(btnXepLoaiTatCa);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(buttonPanel, gbc);
    }

    private void addSearchComponents(JPanel panel, GridBagConstraints gbc) {
        gbc.gridheight = 1;
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(lblSearchMaSV, gbc);
        
        gbc.gridx = 4;
        panel.add(txtSearchMaSV, gbc);
        
        gbc.gridx = 5;
        panel.add(btnSearchMaSV, gbc);
    
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(lblSearchMaLop, gbc);
        
        gbc.gridx = 4;
        panel.add(txtSearchMaLop, gbc);
        
        gbc.gridx = 5;
        panel.add(btnSearchMaLop, gbc);
    }

    private void addActionListeners() {
        btnBackToHome.addActionListener(this);
        btnThem.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnTinhDiemTrungBinh.addActionListener(this);
        btnXepLoai.addActionListener(this);
        btnTinhDiemTrungBinhTatCa.addActionListener(this);
        btnXepLoaiTatCa.addActionListener(this);
        btnSearchMaSV.addActionListener(this);
        btnSearchMaLop.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        } else if (e.getSource() == btnThem) {
            themSinhVien();
        } else if (e.getSource() == btnSua) {
            suaSinhVien();
        } else if (e.getSource() == btnXoa) {
            xoaSinhVien();
        } else if (e.getSource() == btnTinhDiemTrungBinh) {
            tinhDiemTrungBinh();
        } else if (e.getSource() == btnTinhDiemTrungBinhTatCa) {
            tinhDiemTrungBinhTatCa();
        } else if (e.getSource() == btnXepLoai) {
            xepLoai();
        } else if (e.getSource() == btnXepLoaiTatCa) {
            xepLoaiTatCa();
        } else if (e.getSource() == btnSearchMaSV) {
            timTheoMaSV();
        } else if (e.getSource() == btnSearchMaLop) {
            timTheoMaLop();
        }
    }

    private void loadDataToTable() {
        tableModel.setRowCount(0);
        List<SinhVien> danhSachSV = sinhVienDAO.getAllSinhVien();
        for (SinhVien sv : danhSachSV) {
            addSinhVienToTable(sv);
        }
    }

    private void addSinhVienToTable(SinhVien sv) {
        Object[] row = {
            sv.getMaHV(),
            sv.getHoTen(),
            sv.getChucVu(),
            sv.getGioiTinh(),
            sv.getMaLop(),
            sv.getNgaySinh(),
            sv.getNoiSinh(),
            sv.getDiemTB(),
            sv.getXepLoai()
        };
        tableModel.addRow(row);
    }

    private void displaySelectedRow(int row) {
        txtMaSV.setText(tableModel.getValueAt(row, 0).toString());
        txtHoTenSV.setText(tableModel.getValueAt(row, 1).toString());
        txtChucVu.setText(tableModel.getValueAt(row, 2).toString());
        txtGioiTinh.setText(tableModel.getValueAt(row, 3).toString());
        txtMaLop.setText(tableModel.getValueAt(row, 4).toString());
        txtNgaySinh.setText(tableModel.getValueAt(row, 5).toString());
        txtNoiSinh.setText(tableModel.getValueAt(row, 6).toString());
    }

    private SinhVien layThongTinTuForm() {
        SinhVien sv = new SinhVien();
        sv.setMaHV(txtMaSV.getText().trim());
        sv.setHoTen(txtHoTenSV.getText().trim());
        sv.setChucVu(txtChucVu.getText().trim());
        sv.setGioiTinh(txtGioiTinh.getText().trim());
        sv.setMaLop(txtMaLop.getText().trim());
        sv.setNgaySinh(txtNgaySinh.getText().trim());
        sv.setNoiSinh(txtNoiSinh.getText().trim());
        return sv;
    }

    private void xoaForm() {
        txtMaSV.setText("");
        txtHoTenSV.setText("");
        txtChucVu.setText("");
        txtGioiTinh.setText("");
        txtMaLop.setText("");
        txtNgaySinh.setText("");
        txtNoiSinh.setText("");
    }

    private void themSinhVien() {
        SinhVien sv = layThongTinTuForm();
        if (sinhVienDAO.themSinhVien(sv)) {
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
            loadDataToTable();
            xoaForm();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại!");
        }
    }

    private void suaSinhVien() {
        SinhVien sv = layThongTinTuForm();
        if (sinhVienDAO.suaSinhVien(sv)) {
            JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công!");
            loadDataToTable();
            xoaForm();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thất bại!");
        }
    }

    private void xoaSinhVien() {
        String maSV = txtMaSV.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn xóa sinh viên này?", 
            "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (sinhVienDAO.xoaSinhVien(maSV)) {
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công!");
                loadDataToTable();
                xoaForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thất bại!");
            }
        }
    }

    private void tinhDiemTrungBinh() {
        String maSV = txtMaSV.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên!");
            return;
        }

        if (sinhVienDAO.tinhDiemTrungBinh(maSV)) {
            JOptionPane.showMessageDialog(this, "Tính điểm trung bình thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Tính điểm trung bình thất bại!");
        }
    }

    private void xepLoai() {
        String maSV = txtMaSV.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên!");
            return;
        }

        if (sinhVienDAO.xepLoai(maSV)) {
            JOptionPane.showMessageDialog(this, "Xếp loại thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Xếp loại thất bại!");
        }
    }

    private void tinhDiemTrungBinhTatCa() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn tính điểm trung bình cho tất cả sinh viên?", 
            "Xác nhận", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (sinhVienDAO.tinhDiemTrungBinhTatCa()) {
                JOptionPane.showMessageDialog(this, "Tính điểm trung bình cho tất cả sinh viên thành công!");
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tính điểm trung bình!");
            }
        }
    }

    private void xepLoaiTatCa() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc muốn xếp loại cho tất cả sinh viên?", 
            "Xác nhận", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (sinhVienDAO.xepLoaiTatCa()) {
                JOptionPane.showMessageDialog(this, "Xếp loại cho tất cả sinh viên thành công!");
                loadDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xếp loại!");
            }
        }
    }

    private void timTheoMaSV() {
        String maSV = txtSearchMaSV.getText().trim();
        if (maSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sinh viên cần tìm!");
            return;
        }

        SinhVien sv = sinhVienDAO.timTheoMaSV(maSV);
        if (sv != null) {
            tableModel.setRowCount(0);
            addSinhVienToTable(sv);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên!");
            loadDataToTable();
        }
    }

    private void timTheoMaLop() {
        String maLop = txtSearchMaLop.getText().trim();
        if (maLop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã lớp cần tìm!");
            return;
        }

        List<SinhVien> danhSachSV = sinhVienDAO.timTheoMaLop(maLop);
        tableModel.setRowCount(0);
        if (!danhSachSV.isEmpty()) {
            for (SinhVien sv : danhSachSV) {
                addSinhVienToTable(sv);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên nào trong lớp này!");
            loadDataToTable();
        }
    }
}
