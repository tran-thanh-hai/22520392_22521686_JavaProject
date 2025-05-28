/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.geom.RoundRectangle2D;
import Controller.DangNhapChungController;

/**
 *
 * @author rubik
 */
public class DangNhapChungView extends JFrame implements ActionListener {

    private JLabel lblTitle, lblSubTitle;
    private CustomButton btnTruong, btnGiaoVien, btnSinhVien;
    private JPanel mainPanel, headerPanel, buttonPanel;
    private DangNhapChungController controller;

    public DangNhapChungView() {
        setTitle("Hệ Thống Quản Lý Giáo Vụ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setBackground(new Color(245, 245, 250));
        
        controller = new DangNhapChungController(this);
        initializeComponents();
    }

    private void initializeComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 30));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(new EmptyBorder(40, 60, 40, 60));

        headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(245, 245, 250));

        lblTitle = new JLabel("HỆ THỐNG QUẢN LÝ GIÁO VỤ");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitle.setForeground(new Color(51, 51, 51));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblDescription = new JLabel("Chương trình là 1 sản phẩm của môn học Công nghệ JAVA IE303");
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblDescription.setForeground(new Color(128, 128, 128));
        lblDescription.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblStudent1 = new JLabel("Cao Trường Vũ - MSSV: 22521686");
        lblStudent1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblStudent1.setForeground(new Color(128, 128, 128));
        lblStudent1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblStudent2 = new JLabel("Trần Thanh Hải - MSSV: 22520392");
        lblStudent2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblStudent2.setForeground(new Color(128, 128, 128));
        lblStudent2.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        headerPanel.add(lblTitle);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(lblDescription);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(lblStudent1);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        headerPanel.add(lblStudent2);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        btnTruong = createCustomButton("Đăng nhập Admin", new Color(25, 118, 210));
        btnGiaoVien = createCustomButton("Đăng nhập Giáo viên", new Color(56, 142, 60));
        btnSinhVien = createCustomButton("Đăng nhập Sinh viên", new Color(2, 136, 209));

        gbc.gridy = 0;
        buttonPanel.add(btnTruong, gbc);
        gbc.gridy = 1;
        buttonPanel.add(btnGiaoVien, gbc);
        gbc.gridy = 2;
        buttonPanel.add(btnSinhVien, gbc);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private CustomButton createCustomButton(String text, Color color) {
        CustomButton button = new CustomButton(text, color);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTruong) {
            controller.handleTruongLogin();
        } else if (e.getSource() == btnGiaoVien) {
            controller.handleGiaoVienLogin();
        } else if (e.getSource() == btnSinhVien) {
            controller.handleSinhVienLogin();
        }
    }
}

class CustomButton extends JButton {
    private Color hoverColor;
    private Color pressedColor;
    private boolean isHovered = false;
    private boolean isPressed = false;

    public CustomButton(String text, Color baseColor) {
        super(text);
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBackground(baseColor);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        
        hoverColor = baseColor.brighter();
        pressedColor = baseColor.darker();

        setPreferredSize(new Dimension(400, 60));
        
        setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(10, 20, 10, 20),
            new LineBorder(baseColor, 1, true)
        ));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                isHovered = true;
                repaint();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                isHovered = false;
                isPressed = false;
                repaint();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                isPressed = true;
                repaint();
            }

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                isPressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isPressed) {
            g2.setColor(pressedColor);
        } else if (isHovered) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(getBackground());
        }

        RoundRectangle2D.Float rect = new RoundRectangle2D.Float(0, 0, 
            getWidth() - 1, getHeight() - 1, 12, 12);
        g2.fill(rect);

        if (isHovered && !isPressed) {
            g2.setColor(new Color(0, 0, 0, 30));
            g2.fill(rect);
        }

        g2.dispose();
        super.paintComponent(g);
    }
}
