package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.DatabaseConnect;
import other.SplashScreenn;

public class GD_DangNhap extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnHuy;
	private JLabel lblDangNhap;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;
	private JPanel pnlVien1;
	private JLabel lblNewLabel;
	private JPanel pnlHienMK;
	private JPanel pnlAnMK;
	private JLabel lblAnMK;
	private JLabel lblHienMK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatabaseConnect.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new GD_DangNhap().setVisible(true);
	}

	public GD_DangNhap() {

		/*
		 * // setLookAndFeel try {
		 * UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		 * } catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		setTitle("Đăng nhập");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 371);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(82, 83, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		lblDangNhap = new JLabel("Đăng Nhập");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDangNhap.setForeground(new Color(253, 245, 230));
		lblDangNhap.setBounds(148, 31, 290, 34);
		contentPane.add(lblDangNhap);

		lblTaiKhoan = new JLabel("Tài Khoản: ");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTaiKhoan.setForeground(new Color(255, 255, 255));
		lblTaiKhoan.setBounds(44, 90, 138, 44);
		contentPane.add(lblTaiKhoan);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		txtTaiKhoan.setForeground(new Color(255, 255, 255));
		txtTaiKhoan.setBackground(new Color(82, 83, 81));
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTaiKhoan.setBounds(212, 93, 329, 44);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatKhau.setBounds(44, 164, 138, 44);
		contentPane.add(lblMatKhau);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setForeground(new Color(255, 255, 255));
		txtMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatKhau.setBackground(new Color(82, 83, 81));
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(212, 169, 329, 41);
		contentPane.add(txtMatKhau);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/img/baseline_login_white_24dp.png")));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDangNhap.setBackground(new Color(0, 128, 0));
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBounds(409, 255, 132, 34);
		contentPane.add(btnDangNhap);

		btnHuy = new JButton("Thoát");
		btnHuy.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/img/baseline_close_white_24dp.png")));
		btnHuy.addActionListener(this);
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setBounds(212, 255, 132, 34);
		contentPane.add(btnHuy);

		pnlVien1 = new JPanel();
		pnlVien1.setBackground(new Color(0, 128, 0));
		pnlVien1.setBounds(212, 66, 167, 10);
		contentPane.add(pnlVien1);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(485, 181, 56, 16);
		contentPane.add(lblNewLabel);

		pnlHienMK = new JPanel();
		pnlHienMK.setBackground(new Color(82, 83, 81));
		pnlHienMK.setBounds(569, 169, 40, 39);
		contentPane.add(pnlHienMK);
		pnlHienMK.setLayout(null);

		pnlAnMK = new JPanel();
		pnlAnMK.setBackground(new Color(82, 83, 81));
		pnlAnMK.setBounds(569, 169, 40, 39);
		contentPane.add(pnlAnMK);
		pnlAnMK.setLayout(null);

		lblHienMK = new JLabel("");
		lblHienMK.setHorizontalAlignment(SwingConstants.CENTER);
		lblHienMK.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/img/baseline_visibility_white_36dp.png")));
		lblHienMK.setBounds(0, 0, 40, 39);
		pnlHienMK.add(lblHienMK);

		lblAnMK = new JLabel("");
		lblAnMK.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnMK.setIcon(new ImageIcon(GD_DangNhap.class.getResource("/img/baseline_visibility_off_white_36dp.png")));
		lblAnMK.setBounds(0, 0, 40, 39);
		pnlAnMK.add(lblAnMK);

		btnDangNhap.addActionListener(this);
		btnHuy.addActionListener(this);
		lblHienMK.addMouseListener(this);
		lblAnMK.addMouseListener(this);
		txtMatKhau.addKeyListener(this);
		txtTaiKhoan.addKeyListener(this);

//		Test
		txtTaiKhoan.setText("18055671");
		txtMatKhau.setText("123456");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			this.setVisible(false);
			new SplashScreen().name();
			

		} else if (o.equals(btnHuy)) {
			this.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(lblHienMK)) {
			txtMatKhau.setEchoChar((char) 0);
			pnlHienMK.setVisible(false);
			pnlAnMK.setVisible(true);
		} else if (o.equals(lblAnMK)) {
			txtMatKhau.setEchoChar('●');
			pnlAnMK.setVisible(false);
			pnlHienMK.setVisible(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if (o.equals(txtTaiKhoan)) {
//			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//				txtMatKhau.requestFocus();
//			}
//		}
//		if (o.equals(txtMatKhau)) {
//			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//				if (valid()) {
//					if (KiemTraTaiKhoan(txtTaiKhoan.getText(), txtMatKhau.getText())) {
////						nhanVien = getNhanVien(txtTaiKhoan.getText());
//						nhanVien = new NhanVien(txtTaiKhoan.getText());
//						new frm_APP(nhanVien).setVisible(true);
//					} else {
//						JOptionPane.showMessageDialog(this, "Mật khẩu hay tài khoản không chính xác!!!");
//					}
//				}
//			}
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private Boolean valid() {
		String taiKhoan = txtTaiKhoan.getText().trim();
		if (taiKhoan.equals("")) {
			thongBao(txtTaiKhoan, "Tài khoản không được để trống");
			return false;
		} else if (txtMatKhau.getText().equals("")) {
			thongBao(txtMatKhau, "Bạn chưa nhập mật khẩu");
			return false;
		} else if (!taiKhoan.matches("^180[0-9]{5}")) {
			thongBao(txtTaiKhoan, "Tài khoản không hợp lệ!");
			return false;
		}
		return true;
	}

	private void thongBao(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes);
		tf.selectAll();
		tf.requestFocus();
	}

}
