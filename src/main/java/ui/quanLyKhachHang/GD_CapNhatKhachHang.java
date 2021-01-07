package ui.quanLyKhachHang;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import constant.TenEntity;
import dao.KhachHangDao;
import entity.KhachHang;
import other.BatRegex;
import other.RandomMa;

public class GD_CapNhatKhachHang extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThoat;
	private JLabel lblMaKH;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtSoCMT;
	private JTextField txtTenKH;
	private JDateChooser txtNgaySinh;
	private JButton btnLuu;

	private KhachHangDao khachHangDao;
	private String maKhachHang;
	private GD_KhachHang gd_KhachHang;

	private JTextArea txtThongBao;
	private boolean isSoCMT = false;
	private boolean isTenKhachHang = false;
	private boolean isSoDienThoai = false;
	private boolean isNgaySinh = false;
	private boolean isEmail = false;
	private JTextField txtEmail;

	public GD_CapNhatKhachHang(String maKhachHang, GD_KhachHang gd_KhachHang) {
		khachHangDao = KhachHangDao.getInstance();
		this.maKhachHang = maKhachHang;
		this.gd_KhachHang = gd_KhachHang;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setTitle("Cập nhật thông tin khách hàng");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBackground(new Color(58, 181, 74));
		panel.setPreferredSize(new Dimension(800, 50));
		horizontalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Cập nhật thông tin khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(37137, 50));
		lblNewLabel.setPreferredSize(new Dimension(800, 50));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1);

		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_15.setPreferredSize(new Dimension(25, 20));
		horizontalBox_1.add(rigidArea_15);

		lblMaKH = new JLabel();

		lblMaKH.setForeground(Color.BLACK);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaKH);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_5_1.setPreferredSize(new Dimension(115, 20));
		horizontalBox_1.add(rigidArea_5_1);

		JLabel lblNewLabel_1_1 = new JLabel("Số CMT:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1_1);

		Component rigidArea_15_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_15_1.setPreferredSize(new Dimension(45, 20));
		horizontalBox_1.add(rigidArea_15_1);

		txtSoCMT = new JTextField();
		txtSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMT.setPreferredSize(new Dimension(300, 40));
		txtSoCMT.setMaximumSize(new Dimension(2147483647, 40));
		txtSoCMT.setColumns(10);
		horizontalBox_1.add(txtSoCMT);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_7);

		JLabel lblNewLabel_1_2 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_2);

		Component rigidArea_15_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_15_2);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);

		txtTenKH = new JTextField();
		txtTenKH.setText("");
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setPreferredSize(new Dimension(300, 40));
		txtTenKH.setMaximumSize(new Dimension(2147483647, 40));
		txtTenKH.setColumns(10);
		horizontalBox_2.add(txtTenKH);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_12);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_9);

		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_3);

		Component rigidArea_15_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_15_3.setPreferredSize(new Dimension(50, 20));
		horizontalBox_3.add(rigidArea_15_3);

		txtSoDienThoai = new JTextField();

		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setPreferredSize(new Dimension(200, 40));
		txtSoDienThoai.setMaximumSize(new Dimension(2147483647, 40));
		txtSoDienThoai.setColumns(5);
		horizontalBox_3.add(txtSoDienThoai);

		Component rigidArea_5_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_5_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_1_1);

		Component rigidArea_15_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_15_1_1);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setPreferredSize(new Dimension(100, 40));
		txtNgaySinh.setMaximumSize(new Dimension(2147483647, 40));
		txtNgaySinh.setDate(Calendar.getInstance().getTime());
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		horizontalBox_3.add(txtNgaySinh);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_8);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_3);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3);
		
		Box horizontalBox_7_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7_2);
		
		Component rigidArea_20_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7_2.add(rigidArea_20_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("email:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7_2.add(lblNewLabel_1_1_2_1);
		
		Component rigidArea_15_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_15_1_2_1.setPreferredSize(new Dimension(125, 20));
		horizontalBox_7_2.add(rigidArea_15_1_2_1);
		
		txtEmail = new JTextField();
		txtEmail.setText((String) null);
		txtEmail.setPreferredSize(new Dimension(300, 40));
		txtEmail.setMaximumSize(new Dimension(300, 40));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(20);
		horizontalBox_7_2.add(txtEmail);
		
		Component horizontalGlue_6_1 = Box.createHorizontalGlue();
		horizontalBox_7_2.add(horizontalGlue_6_1);
		
		Component rigidArea_11_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7_2.add(rigidArea_11_1);
		
		Component rigidArea_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_1);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7);

		Component rigidArea_20 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_20);

		JLabel lblNewLabel_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblNewLabel_1_1_2);

		Component rigidArea_15_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_15_1_2);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setPreferredSize(new Dimension(300, 40));
		txtDiaChi.setMaximumSize(new Dimension(2147483647, 40));
		horizontalBox_7.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_7.add(horizontalGlue_6);

		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_11);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1);

		Box horizontalBox_7_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7_1);

		Component rigidArea_20_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7_1.add(rigidArea_20_1);

		txtThongBao = new JTextArea();
		txtThongBao.setPreferredSize(new Dimension(640, 130));
		txtThongBao.setMaximumSize(new Dimension(2147483647, 130));
		txtThongBao.setMargin(new Insets(10, 10, 10, 10));
		txtThongBao.setForeground(Color.RED);

		txtThongBao.setBorder(null);
		txtThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		horizontalBox_7_1.add(txtThongBao);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7_1.add(rigidArea_10);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);

		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_16);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setMaximumSize(new Dimension(97, 40));
		btnThoat.setPreferredSize(new Dimension(97, 40));
		horizontalBox_6.add(btnThoat);
		btnThoat.addActionListener(this);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue);

		btnLuu = new JButton("Lưu");
		btnLuu.setPreferredSize(new Dimension(97, 40));
		btnLuu.setMaximumSize(new Dimension(97, 40));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLuu.setBackground(new Color(0, 128, 0));
		horizontalBox_6.add(btnLuu);

		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_17);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);

		// tạo mã ngẫu nhiên
		lblMaKH.setText(RandomMa.getMaNgauNhien(TenEntity.KHACH_HANG));

		dangKiSuKien();
		hienThiKhachHang();
	}

	private void hienThiKhachHang() {
		KhachHang khachHang = khachHangDao.getKhachHangTheoMa(maKhachHang);

		lblMaKH.setText(khachHang.getMaKhachHang());
		txtSoCMT.setText(khachHang.getSoCMT());
		txtTenKH.setText(khachHang.getHoTenKH());
		txtDiaChi.setText(khachHang.getDiaChiKH());
		txtSoDienThoai.setText(khachHang.getSoDienThoai());
		txtNgaySinh.setDate(khachHang.getNgaySinh());

	}

	private void dangKiSuKien() {
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);

		txtSoCMT.addFocusListener(this);
		txtTenKH.addFocusListener(this);
		txtSoDienThoai.addFocusListener(this);
		txtNgaySinh.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {

					if (!BatRegex.kiemTraNgaySinh(txtNgaySinh))
						isNgaySinh = true;

				}

			}
		});
		
		txtEmail.addFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btnThoat)) {
			this.setVisible(false);
		}

		if (source == btnLuu) {
			KhachHang khachHang = getKhachHang();

			if (validateKhachHang(khachHang)) {

				if (khachHangDao.capNhatKhachHang(khachHang)) {
					int flag = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật ?",
							"Thông báo cập nhật khách hàng", JOptionPane.YES_NO_OPTION);

					if (flag == JOptionPane.YES_OPTION) {

						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						gd_KhachHang.capNhatDuLieuTrongBang();
						this.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
				}
			} else {
				isSoCMT = true;
				isTenKhachHang = true;
				isSoDienThoai = true;
				isNgaySinh = true;
				isEmail = true;
				capNhatThongBaoLoi();
			}

		}

		if (source == btnThoat)
			this.setVisible(false);
	}

	private KhachHang getKhachHang() {
		String maKhachHang = lblMaKH.getText();
		String soCMT = txtSoCMT.getText();
		String hoTenKH = txtTenKH.getText();
		String soDienThoai = txtSoDienThoai.getText();
		String email = txtEmail.getText();
		
		@SuppressWarnings("deprecation")
		Date ngaySinh = new Date(txtNgaySinh.getDate().getYear(), txtNgaySinh.getDate().getMonth(),
				txtNgaySinh.getDate().getDate());
		String diaChiKH = txtDiaChi.getText();

		KhachHang khachHang = new KhachHang(maKhachHang, soCMT, hoTenKH, ngaySinh, soDienThoai, diaChiKH, email);
		return khachHang;

	}

	private boolean validateKhachHang(KhachHang khachHang) {

		if (BatRegex.kiemTraSoCMT(txtSoCMT) && BatRegex.kiemTraTen(txtTenKH)
				&& BatRegex.kiemTraSoDienThoai(txtSoDienThoai) && BatRegex.kiemTraNgaySinh(txtNgaySinh) && BatRegex.kiemTraEmail(txtEmail))
			return true;

		return false;

	}

	private void capNhatThongBaoLoi() {

		txtThongBao.setText("");

		if (!BatRegex.kiemTraSoCMT(txtSoCMT) && isSoCMT)
			txtThongBao.setText(txtThongBao.getText() + "\n" + BatRegex.SO_CMT);

		if (!BatRegex.kiemTraTen(txtTenKH) && isTenKhachHang)
			txtThongBao.setText(txtThongBao.getText() + "\n" + BatRegex.TEN_KHACH_HANG);

		if (!BatRegex.kiemTraSoDienThoai(txtSoDienThoai) && isSoDienThoai)
			txtThongBao.setText(txtThongBao.getText() + "\n" + BatRegex.SO_DIEN_THOAI);

		if (!BatRegex.kiemTraNgaySinh(txtNgaySinh) && isNgaySinh)
			txtThongBao.setText(txtThongBao.getText() + "\n" + BatRegex.NGAY_SINH);
		
		if (!BatRegex.kiemTraEmail(txtEmail) && isEmail)
			txtThongBao.setText(txtThongBao.getText() + "\n" + "Email không đúng định dạng");

	}

	@Override
	public void focusGained(FocusEvent e) {
		Object source = e.getSource();

		if (source.equals(txtSoCMT))
			isSoCMT = true;

		if (source.equals(txtTenKH))
			isTenKhachHang = true;

		if (source.equals(txtSoDienThoai))
			isSoDienThoai = true;
		
		if(source.equals(txtEmail))
			isEmail = true;

	}

	@Override
	public void focusLost(FocusEvent e) {
		capNhatThongBaoLoi();

	}

}
