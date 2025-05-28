/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.NhaTruong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rubik
 */
public class QuanLyDiemThi extends JFrame {

    private JTextField maHvField;
    private JTextField maMhField;
    private JTextField lanThiField;
    private JTextField ngayThiField;
    private JTextField diemField;
    private JTextField kquaField;

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    private JTextField searchMaMhField;
    private JTextField searchLanThiField;
    private JTextField searchDiemField;

    private JButton searchMaMhButton;
    private JButton searchLanThiButton;
    private JButton searchDiemButton;

    private JTextArea dataDisplayArea; // Using JTextArea as a placeholder, can be replaced by JTable

    public QuanLyDiemThi() {
        setTitle("Quản Lý Điểm Thi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel for data display (placeholder)
        JPanel topPanel = new JPanel(new BorderLayout());
        dataDisplayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(dataDisplayArea);
        topPanel.setBorder(BorderFactory.createTitledBorder("Exam Results Data")); // Optional title
        topPanel.add(scrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);

        // Bottom Panel for input fields and buttons
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: Mã HV
        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(new JLabel("Mã HV:"), gbc);
        gbc.gridx = 1;
        maHvField = new JTextField(15);
        bottomPanel.add(maHvField, gbc);

        gbc.gridx = 2;
        addButton = new JButton("Thêm");
        bottomPanel.add(addButton, gbc);

        // Row 2: Mã MH
        gbc.gridx = 0;
        gbc.gridy = 1;
        bottomPanel.add(new JLabel("Mã MH:"), gbc);
        gbc.gridx = 1;
        maMhField = new JTextField(15);
        bottomPanel.add(maMhField, gbc);

        gbc.gridx = 2;
        editButton = new JButton("Sửa");
        bottomPanel.add(editButton, gbc);

        // Row 2 (cont.): Search by Mã MH
        gbc.gridx = 3;
        gbc.gridy = 1; // Align with Mã MH row
        searchMaMhButton = new JButton("Tìm kiếm theo môn học");
        bottomPanel.add(searchMaMhButton, gbc);
        gbc.gridx = 4;
        searchMaMhField = new JTextField(15);
        bottomPanel.add(searchMaMhField, gbc);

        // Row 3: Lần thi
        gbc.gridx = 0;
        gbc.gridy = 2;
        bottomPanel.add(new JLabel("Lần thi:"), gbc);
        gbc.gridx = 1;
        lanThiField = new JTextField(15);
        bottomPanel.add(lanThiField, gbc);

        gbc.gridx = 2;
        deleteButton = new JButton("Xoá");
        bottomPanel.add(deleteButton, gbc);

        // Row 3 (cont.): Search by Lần thi
        gbc.gridx = 3;
        gbc.gridy = 2; // Align with Lần thi row
        searchLanThiButton = new JButton("Tìm kiếm theo lần thi");
        bottomPanel.add(searchLanThiButton, gbc);
        gbc.gridx = 4;
        searchLanThiField = new JTextField(15);
        bottomPanel.add(searchLanThiField, gbc);

        // Row 4: Ngày thi
        gbc.gridx = 0;
        gbc.gridy = 3;
        bottomPanel.add(new JLabel("Ngày thi:"), gbc);
        gbc.gridx = 1;
        ngayThiField = new JTextField(15);
        bottomPanel.add(ngayThiField, gbc);

        // Row 5: Điểm
        gbc.gridx = 0;
        gbc.gridy = 4;
        bottomPanel.add(new JLabel("Điểm:"), gbc);
        gbc.gridx = 1;
        diemField = new JTextField(15);
        bottomPanel.add(diemField, gbc);

        // Row 5 (cont.): Search by Điểm
        gbc.gridx = 3;
        gbc.gridy = 4; // Align with Điểm row
        searchDiemButton = new JButton("Tìm kiếm theo điểm thi");
        bottomPanel.add(searchDiemButton, gbc);
        gbc.gridx = 4;
        searchDiemField = new JTextField(15);
        bottomPanel.add(searchDiemField, gbc);

        // Row 6: Kết quả
        gbc.gridx = 0;
        gbc.gridy = 5;
        bottomPanel.add(new JLabel("Kết quả:"), gbc);
        gbc.gridx = 1;
        kquaField = new JTextField(15);
        bottomPanel.add(kquaField, gbc);

        add(bottomPanel, BorderLayout.SOUTH);

        pack(); // Adjusts the window size to fit the components
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDiemThi().setVisible(true);
            }
        });
    }
}
