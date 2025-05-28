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

    public QuanLyDiemThi() {
        setTitle("Quản Lý Điểm Thi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 650); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        controller = new GiaoVienHomeController(this);


        JPanel topPanel = new JPanel(new BorderLayout());


        btnBackToHome = new JButton("Quay lại trang chủ");
        topPanel.add(btnBackToHome, BorderLayout.WEST);
        btnBackToHome.addActionListener(this);


        lblTitle = new JLabel("Quản Lý Điểm Thi", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(lblTitle, BorderLayout.CENTER);


        add(topPanel, BorderLayout.NORTH);


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


        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;


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

        gbc.gridx = 5;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        btnSearchMaMH = new JButton("Tìm");
        inputPanel.add(btnSearchMaMH, gbc);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBackToHome) {
            controller.navigateToTrangChu();
        }
    }


}
