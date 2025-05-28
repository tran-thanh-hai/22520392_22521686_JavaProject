/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author rubik
 */
public class QuanLyLop extends JFrame {

    private JLabel lblTitle;
    private JTextArea dataArea;

    // Labels and fields for class information
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

    // Action buttons
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;

    // Search components
    private JLabel lblSearchMaLop;
    private JTextField txtSearchMaLop;
    private JButton btnSearchMaLop;
    private JLabel lblSearchMaGV;
    private JTextField txtSearchMaGV;
    private JButton btnSearchMaGV;

    public QuanLyLop() {
        setTitle("Quản lý Lớp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550); // Adjusted size
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Title Label
        lblTitle = new JLabel("Quản lý Lớp", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Data Display Area
        dataArea = new JTextArea();
        dataArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dataArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input and Action Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to inputPanel using GridBagLayout
        int row = 0;

        // Mã lớp
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

        // Thêm Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnThem = new JButton("Thêm");
        inputPanel.add(btnThem, gbc);

        // Search by MaLop
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaLop = new JLabel("Tìm kiếm theo mã lớp:");
        inputPanel.add(lblSearchMaLop, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaLop = new JTextField(10);
        inputPanel.add(txtSearchMaLop, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tên lớp
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

        // Sửa Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSua = new JButton("Sửa");
        inputPanel.add(btnSua, gbc);

        // Search by MaGVCN
        gbc.gridx = 3;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        lblSearchMaGV = new JLabel("Tìm kiếm theo mã GVCN:");
        inputPanel.add(lblSearchMaGV, gbc);

        gbc.gridx = 4;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSearchMaGV = new JTextField(10);
        inputPanel.add(txtSearchMaGV, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Trưởng lớp
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

        // Xóa Button
        gbc.gridx = 2;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnXoa = new JButton("Xóa");
        inputPanel.add(btnXoa, gbc);

        row++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Sĩ số
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

        // Mã GVCN
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

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyLop().setVisible(true);
        });
    }
}
