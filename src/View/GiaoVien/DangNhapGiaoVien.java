/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.GiaoVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.GiaoVienLoginController;
import View.DangNhapChungView;

/**
 *
 * @author rubik
 */
public class DangNhapGiaoVien extends JFrame implements ActionListener {

    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnExit;

    private GiaoVienLoginController controller;

    public DangNhapGiaoVien () {
        setTitle("Tài khoản giáo viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); 

        controller = new GiaoVienLoginController(this);


        lblUsername = new JLabel("Tên Đăng Nhập:");
        lblPassword = new JLabel("Mật Khẩu:");
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15); 
        btnLogin = new JButton("Đăng nhập");
        btnExit = new JButton("Quay lại");


        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);


        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; 
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnExit);
        panel.add(buttonPanel, gbc);


        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            controller.handleLogin(username, password);
        } else if (e.getSource() == btnExit) {

            DangNhapChungView commonLoginView = new DangNhapChungView();
            commonLoginView.setVisible(true);
            this.dispose(); 
        }
    }


}
