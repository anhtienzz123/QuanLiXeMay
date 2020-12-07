package ui.quanLyNhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.NhanVienHanhChinhDao;
import entity.NhanVienHanhChinh;

public class GD_DoiMatKhau extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtNhapLai;
	private JButton btnDangNhap;
	private JButton btnHuy;
	private JLabel lblDangNhap;
	private JLabel lblTaiKhoan;
	private JLabel lblMatKhau;
	private JPanel pnlVien1;
	private JLabel lblNewLabel;
	private JPanel pnlHienMK2;
	private JPanel pnlAnMK2;
	private JLabel lblAnMK2;
	private JLabel lblHienMK2;
	private JPasswordField txtMatKhau;
	private JPanel pnlHienMK1;
	private JLabel lblHienMK1;
	private JPanel pnlAnMK1;
	private JLabel lblAnMK1;
	private NhanVienHanhChinh nhanVienHanhChinh;

	public GD_DoiMatKhau(NhanVienHanhChinh nhanVienHanhChinh) {
		this.nhanVienHanhChinh = nhanVienHanhChinh;

		/*
		 * // setLookAndFeel try {
		 * UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		 * } catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		setTitle("Đổi mật khẩu");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 371);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(82, 83, 81));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		lblDangNhap = new JLabel("Đổi mật khẩu");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDangNhap.setForeground(new Color(253, 245, 230));
		lblDangNhap.setBounds(192, 34, 290, 34);
		contentPane.add(lblDangNhap);

		lblTaiKhoan = new JLabel("Mật khẩu mới:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTaiKhoan.setForeground(new Color(255, 255, 255));
		lblTaiKhoan.setBounds(44, 90, 180, 44);
		contentPane.add(lblTaiKhoan);

		lblMatKhau = new JLabel("Nhập lại :");
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatKhau.setBounds(44, 164, 180, 44);
		contentPane.add(lblMatKhau);

		txtNhapLai = new JPasswordField();
		txtNhapLai.setForeground(new Color(255, 255, 255));
		txtNhapLai.setHorizontalAlignment(SwingConstants.CENTER);
		txtNhapLai.setBackground(new Color(82, 83, 81));
		txtNhapLai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNhapLai.setBounds(236, 166, 329, 41);
		contentPane.add(txtNhapLai);

		btnDangNhap = new JButton("Lưu");
		btnDangNhap.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/icon/baseline_login_white_24dp.png")));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDangNhap.setBackground(new Color(0, 128, 0));
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBounds(433, 255, 132, 34);
		contentPane.add(btnDangNhap);

		btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnHuy.addActionListener(this);
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setBounds(236, 255, 132, 34);
		contentPane.add(btnHuy);

		pnlVien1 = new JPanel();
		pnlVien1.setBackground(new Color(0, 128, 0));
		pnlVien1.setBounds(236, 67, 202, 10);
		contentPane.add(pnlVien1);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(485, 181, 56, 16);
		contentPane.add(lblNewLabel);

		pnlHienMK2 = new JPanel();
		pnlHienMK2.setBackground(new Color(82, 83, 81));
		pnlHienMK2.setBounds(577, 169, 40, 39);
		contentPane.add(pnlHienMK2);
		pnlHienMK2.setLayout(null);

		pnlAnMK2 = new JPanel();
		pnlAnMK2.setBackground(new Color(82, 83, 81));
		pnlAnMK2.setBounds(577, 169, 40, 39);
		contentPane.add(pnlAnMK2);
		pnlAnMK2.setLayout(null);

		lblHienMK2 = new JLabel("");
		lblHienMK2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHienMK2.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/icon/baseline_visibility_white_36dp.png")));
		lblHienMK2.setBounds(0, 0, 40, 39);
		pnlHienMK2.add(lblHienMK2);

		lblAnMK2 = new JLabel("");
		lblAnMK2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnMK2.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/icon/baseline_visibility_off_white_36dp.png")));
		lblAnMK2.setBounds(0, 0, 40, 39);
		pnlAnMK2.add(lblAnMK2);

		btnDangNhap.addActionListener(this);
		btnHuy.addActionListener(this);
		lblHienMK2.addMouseListener(this);
		lblAnMK2.addMouseListener(this);
		txtNhapLai.addKeyListener(this);
		txtNhapLai.setText("55555");

		txtMatKhau = new JPasswordField();
		txtMatKhau.setText("55555");
		txtMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatKhau.setForeground(Color.WHITE);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBackground(new Color(82, 83, 81));
		txtMatKhau.setBounds(236, 90, 329, 41);
		contentPane.add(txtMatKhau);

		pnlHienMK1 = new JPanel();
		pnlHienMK1.setLayout(null);
		pnlHienMK1.setBackground(new Color(82, 83, 81));
		pnlHienMK1.setBounds(577, 90, 40, 39);
		contentPane.add(pnlHienMK1);

		lblHienMK1 = new JLabel("");
		lblHienMK1.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/icon/baseline_visibility_white_36dp.png")));
		lblHienMK1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHienMK1.setBounds(0, 0, 40, 39);
		pnlHienMK1.add(lblHienMK1);

		pnlAnMK1 = new JPanel();
		pnlAnMK1.setLayout(null);
		pnlAnMK1.setBackground(new Color(82, 83, 81));
		pnlAnMK1.setBounds(577, 90, 40, 39);
		contentPane.add(pnlAnMK1);

		lblAnMK1 = new JLabel("");
		lblAnMK1.setIcon(new ImageIcon(GD_DoiMatKhau.class.getResource("/icon/baseline_visibility_off_white_36dp.png")));
		lblAnMK1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnMK1.setBounds(0, 0, 40, 39);
		pnlAnMK1.add(lblAnMK1);

		lblAnMK1.addMouseListener(this);
		lblHienMK1.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {
			luu();
		} else if (o.equals(btnHuy)) {
			this.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(lblHienMK1)) {
			txtMatKhau.setEchoChar((char) 0);
			pnlHienMK1.setVisible(false);
			pnlAnMK1.setVisible(true);
		}
		if (o.equals(lblAnMK1)) {
			txtMatKhau.setEchoChar('●');
			pnlAnMK1.setVisible(false);
			pnlHienMK1.setVisible(true);
		}
		if (o.equals(lblHienMK2)) {
			txtNhapLai.setEchoChar((char) 0);
			pnlHienMK2.setVisible(false);
			pnlAnMK2.setVisible(true);
		}
		if (o.equals(lblAnMK2)) {
			txtNhapLai.setEchoChar('●');
			pnlAnMK2.setVisible(false);
			pnlHienMK2.setVisible(true);
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
		Object o = e.getSource();
		if (o.equals(txtMatKhau)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtNhapLai.requestFocus();
			}
		}
		if (o.equals(txtNhapLai)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				luu();
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void luu() {
		String mk = txtMatKhau.getText();
		String nhapLai = txtNhapLai.getText();
		if (mk.length() > 6) {
			if (mk.equals(nhapLai)) {
				nhanVienHanhChinh.setMatKhau(mk);
				NhanVienHanhChinhDao.getInstance().capNhatNhanVienHanhChinh(nhanVienHanhChinh);
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Mật khẩu phải chứa ít nhất 6 kí tự");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
