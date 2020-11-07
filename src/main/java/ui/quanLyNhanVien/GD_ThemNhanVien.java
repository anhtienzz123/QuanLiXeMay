package ui.quanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ui.App;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import javax.swing.JPasswordField;

public class GD_ThemNhanVien extends JPanel implements ActionListener, MouseListener {
	private JTextField txtTenNV;
	private JButton btnThem;
	private DefaultTableModel modelNVHanhChinh;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private DefaultTableModel modelNVKyThuat;
	private JTextField txtSoDienThoai;
	private JTextField txtAnh;
	private JTextField textField;
	private JTextField txtChucVu;
	private JTextField txtTrinhDoHocVan;
	private JPasswordField txtMatKhau;

	/**
	 * Create the panel.
	 */
	public GD_ThemNhanVien() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm nhân viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JLabel lblTngThuTrong_1 = new JLabel("Mã nhân viên:");
		lblTngThuTrong_1.setBounds(41, 76, 126, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setBounds(209, 136, 311, 30);
		add(txtTenNV);
		txtTenNV.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("Thêm nhân viên");
		btnThem.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1239, 753, 168, 40);
		add(btnThem);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 817, 1450, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1450, 133);
		pnlLogo.add(lblLogo);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setToolTipText("Xóa trắng các trường nhập dữ liệu");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setBounds(1041, 753, 168, 40);
		add(btnXoaRong);

		btnThoat = new JButton("Thoát");
		btnThoat.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(41, 753, 168, 40);
		add(btnThoat);
		
		JLabel lblMaNV = new JLabel("HC123456");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(209, 76, 126, 30);
		add(lblMaNV);
		
		JLabel lblLNV = new JLabel("Loại nhân viên:");
		lblLNV.setForeground(Color.BLACK);
		lblLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLNV.setBounds(615, 76, 147, 30);
		add(lblLNV);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên hành chính", "Nhân viên kỹ thuật"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(802, 79, 228, 30);
		add(comboBox);
		
		JLabel lblTNV = new JLabel("Tên nhân viên:");
		lblTNV.setForeground(Color.BLACK);
		lblTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTNV.setBounds(41, 136, 139, 30);
		add(lblTNV);
		
		JLabel lblGT = new JLabel("Giới tính:");
		lblGT.setForeground(Color.BLACK);
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGT.setBounds(615, 136, 147, 30);
		add(lblGT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1082, 79, 325, 301);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("img");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 325, 301);
		panel_1.add(lblNewLabel_1);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(802, 142, 127, 25);
		add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(933, 142, 127, 25);
		add(rdbtnNu);
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbtnNu);
		btnG.add(rdbtnNam);
		
		JLabel lblNS = new JLabel("Ngày sinh:");
		lblNS.setForeground(Color.BLACK);
		lblNS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNS.setBounds(41, 205, 147, 30);
		add(lblNS);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateChooser.setBounds(209, 205, 311, 30);
		add(dateChooser);
		
		JLabel lblSsss = new JLabel("Số điện thoại:");
		lblSsss.setForeground(Color.BLACK);
		lblSsss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSsss.setBounds(615, 205, 147, 30);
		add(lblSsss);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(802, 205, 228, 30);
		add(txtSoDienThoai);
		
		JLabel lblanh = new JLabel("Ảnh:");
		lblanh.setForeground(Color.BLACK);
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblanh.setBounds(41, 350, 147, 30);
		add(lblanh);
		
		txtAnh = new JTextField();
		txtAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnh.setColumns(10);
		txtAnh.setBounds(209, 350, 593, 30);
		add(txtAnh);
		
		JButton btnChonFile = new JButton("Chọn file");
		btnChonFile.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnChonFile.setForeground(Color.WHITE);
		btnChonFile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChonFile.setBackground(Color.GRAY);
		btnChonFile.setBounds(862, 350, 168, 30);
		add(btnChonFile);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaCh.setBounds(41, 279, 105, 30);
		add(lblaCh);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(209, 279, 821, 30);
		add(textField);
		
		JPanel pnlLoaiNV = new JPanel();
		pnlLoaiNV.setBackground(Color.WHITE);
		pnlLoaiNV.setBounds(12, 407, 1072, 273);
		add(pnlLoaiNV);
		pnlLoaiNV.setLayout(new CardLayout(0, 0));
		
		JPanel pnlNVHanhChinh = new JPanel();
		pnlLoaiNV.add(pnlNVHanhChinh, "name_191634603687900");
		pnlNVHanhChinh.setLayout(null);
		
		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(Color.BLACK);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV.setBounds(28, 13, 147, 30);
		pnlNVHanhChinh.add(lblChcV);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(196, 13, 305, 30);
		pnlNVHanhChinh.add(txtChucVu);
		
		JLabel lblChcV_1 = new JLabel("Trình độ học vấn:");
		lblChcV_1.setForeground(Color.BLACK);
		lblChcV_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV_1.setBounds(599, 13, 156, 30);
		pnlNVHanhChinh.add(lblChcV_1);
		
		txtTrinhDoHocVan = new JTextField();
		txtTrinhDoHocVan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrinhDoHocVan.setColumns(10);
		txtTrinhDoHocVan.setBounds(767, 13, 250, 30);
		pnlNVHanhChinh.add(txtTrinhDoHocVan);
		
		JLabel lblQuynTruyCp = new JLabel("Quyền truy cập:");
		lblQuynTruyCp.setForeground(Color.BLACK);
		lblQuynTruyCp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuynTruyCp.setBounds(28, 81, 147, 30);
		pnlNVHanhChinh.add(lblQuynTruyCp);
		
		JComboBox cboQuyenTruyCap = new JComboBox();
		cboQuyenTruyCap.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên bán hàng", "Người quản lý"}));
		cboQuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboQuyenTruyCap.setBounds(196, 81, 305, 30);
		pnlNVHanhChinh.add(cboQuyenTruyCap);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(599, 81, 147, 30);
		pnlNVHanhChinh.add(lblMtKhu);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(767, 84, 250, 30);
		pnlNVHanhChinh.add(txtMatKhau);
		
		JLabel lblHienMK = new JLabel("");
		lblHienMK.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_visibility_white_36dp.png")));
		lblHienMK.setForeground(Color.BLACK);
		lblHienMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHienMK.setBounds(1028, 81, 32, 30);
		pnlNVHanhChinh.add(lblHienMK);
		
		
		JLabel lblAnMK = new JLabel("");
		lblHienMK.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_visibility_white_36dp.png")));
		lblHienMK.setForeground(Color.BLACK);
		lblHienMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHienMK.setBounds(1028, 81, 32, 30);
		pnlNVHanhChinh.add(lblHienMK);
		
		JPanel pnlNVKyThuat = new JPanel();
		pnlNVKyThuat.setBackground(Color.GRAY);
		pnlLoaiNV.add(pnlNVKyThuat, "name_191649957157600");
		pnlNVKyThuat.setLayout(null);


		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(new GD_TNV());
		this.validate();
		this.repaint();

	}
}
