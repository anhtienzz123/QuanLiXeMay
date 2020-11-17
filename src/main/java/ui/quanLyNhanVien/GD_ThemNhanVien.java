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
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import ui.App;
import com.toedter.calendar.JDateChooser;

import constant.TenEntity;
import dao.NhanVienHanhChinhDao;
import dao.NhanVienKiThuatDao;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;
import other.RandomMa;

import java.awt.CardLayout;
import javax.swing.JPasswordField;

public class GD_ThemNhanVien extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JTextField txtTenNV;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private JLabel lblMaNV;
	private JTextField txtSoDienThoai;
	private JTextField txtAnh;
	private JTextField txtDiaChi;
	private JTextField txtChucVu;
	private JTextField txtTrinhDoHocVan;
	private JPasswordField txtMatKhau;
	private JTextField txtNamKinhNghiem;
	private JLabel lblHienMK;
	private JLabel lblAnMK;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JComboBox cboLoaiNV;
	private JPanel pnlNVHanhChinh;
	private JPanel pnlNVKyThuat;
	private JButton btnChonFile;
	private JLabel lblAnh;
	private JPanel pnlAnh;
	private JDateChooser txtNgaySinh;
	private JComboBox cboQuyenTruyCap;
	private JComboBox cboBacTho;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;
	private NhanVienKiThuatDao nhanVienKiThuatDao;

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
		txtTenNV.setBounds(232, 136, 325, 30);
		add(txtTenNV);
		txtTenNV.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("Thêm nhân viên");
		btnThem.setIcon(
				new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
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

		lblMaNV = new JLabel();

		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(232, 76, 126, 30);
		add(lblMaNV);

		JLabel lblLNV = new JLabel("Loại nhân viên:");
		lblLNV.setForeground(Color.BLACK);
		lblLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLNV.setBounds(615, 76, 147, 30);
		add(lblLNV);

		cboLoaiNV = new JComboBox();
		cboLoaiNV.setBackground(Color.WHITE);
		cboLoaiNV.setModel(new DefaultComboBoxModel(new String[] { "Nhân viên hành chính", "Nhân viên kỹ thuật" }));
		cboLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiNV.setBounds(802, 79, 228, 30);
		add(cboLoaiNV);
		lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));

		// tạo mã nhân viên
//		if(cboLoaiNV.getSelectedIndex() == 0)
//			lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));
//		else
//			lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT));

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

		pnlAnh = new JPanel();
		pnlAnh.setBounds(1082, 79, 325, 301);
		add(pnlAnh);
		pnlAnh.setLayout(null);

		lblAnh = new JLabel("img");
		lblAnh.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/pictures_folder_30px.png")));
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBounds(0, 0, 325, 301);
		pnlAnh.add(lblAnh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(802, 142, 127, 25);
		rdbtnNam.setSelected(true);
		add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
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

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.getCalendarButton().setBackground(Color.WHITE);
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setBounds(232, 205, 325, 30);
		txtNgaySinh.setDate(Calendar.getInstance().getTime());
		add(txtNgaySinh);

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
		txtAnh.setBounds(232, 350, 570, 30);
		add(txtAnh);

		btnChonFile = new JButton("Chọn file");
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

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(232, 279, 798, 30);
		add(txtDiaChi);

		JPanel pnlLoaiNV = new JPanel();
		pnlLoaiNV.setBackground(Color.WHITE);
		pnlLoaiNV.setBounds(12, 407, 1072, 273);
		add(pnlLoaiNV);
		pnlLoaiNV.setLayout(new CardLayout(0, 0));

		pnlNVHanhChinh = new JPanel();
		pnlNVHanhChinh.setBackground(Color.WHITE);
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
		txtChucVu.setBounds(224, 13, 305, 30);
		pnlNVHanhChinh.add(txtChucVu);

		JLabel lblChcV_1 = new JLabel("Trình độ học vấn:");
		lblChcV_1.setForeground(Color.BLACK);
		lblChcV_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV_1.setBounds(599, 13, 156, 30);
		pnlNVHanhChinh.add(lblChcV_1);

		txtTrinhDoHocVan = new JTextField();
		txtTrinhDoHocVan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrinhDoHocVan.setColumns(10);
		txtTrinhDoHocVan.setBounds(790, 13, 227, 30);
		pnlNVHanhChinh.add(txtTrinhDoHocVan);

		JLabel lblQuynTruyCp = new JLabel("Quyền truy cập:");
		lblQuynTruyCp.setForeground(Color.BLACK);
		lblQuynTruyCp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuynTruyCp.setBounds(28, 81, 147, 30);
		pnlNVHanhChinh.add(lblQuynTruyCp);

		cboQuyenTruyCap = new JComboBox();
		cboQuyenTruyCap.setModel(new DefaultComboBoxModel(new String[] { "Nhân viên bán hàng", "Người quản lý" }));
		cboQuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboQuyenTruyCap.setBounds(224, 81, 305, 30);
		pnlNVHanhChinh.add(cboQuyenTruyCap);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(599, 81, 147, 30);
		pnlNVHanhChinh.add(lblMtKhu);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setToolTipText("Mật khẩu mặc định là 12345678");
		txtMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(790, 84, 227, 30);
		txtMatKhau.setText("12345678");
		pnlNVHanhChinh.add(txtMatKhau);

		lblHienMK = new JLabel("");
		lblHienMK.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_visibility_black_36dp.png")));
		lblHienMK.setForeground(Color.BLACK);
		lblHienMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHienMK.setBounds(1029, 84, 40, 30);
		pnlNVHanhChinh.add(lblHienMK);

		lblAnMK = new JLabel("");
		lblAnMK.setIcon(
				new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_visibility_off_black_36dp.png")));
		lblAnMK.setForeground(Color.BLACK);
		lblAnMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnMK.setBounds(1029, 84, 40, 30);
		pnlNVHanhChinh.add(lblAnMK);
		lblAnMK.setVisible(false);

		pnlNVKyThuat = new JPanel();
		pnlNVKyThuat.setBackground(Color.WHITE);
		pnlLoaiNV.add(pnlNVKyThuat, "name_191649957157600");
		pnlNVKyThuat.setLayout(null);

		JLabel lblSNKN = new JLabel("Số năm kinh nghiệm:");
		lblSNKN.setForeground(Color.BLACK);
		lblSNKN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSNKN.setBounds(29, 13, 189, 30);
		pnlNVKyThuat.add(lblSNKN);

		txtNamKinhNghiem = new JTextField();
		txtNamKinhNghiem.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNamKinhNghiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNamKinhNghiem.setColumns(10);
		txtNamKinhNghiem.setBounds(221, 13, 61, 30);
		pnlNVKyThuat.add(txtNamKinhNghiem);

		JLabel lblNm = new JLabel("năm.");
		lblNm.setForeground(Color.BLACK);
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNm.setBounds(294, 13, 55, 30);
		pnlNVKyThuat.add(lblNm);

		JLabel lblBcTh = new JLabel("Bậc thợ:");
		lblBcTh.setForeground(Color.BLACK);
		lblBcTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBcTh.setBounds(615, 13, 152, 30);
		pnlNVKyThuat.add(lblBcTh);

		cboBacTho = new JComboBox();
		cboBacTho.setBackground(Color.WHITE);
		cboBacTho.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
		cboBacTho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboBacTho.setBounds(796, 13, 228, 30);
		pnlNVKyThuat.add(cboBacTho);

		JLabel lblThongBao = new JLabel("Thông báo: Ngày sinh không hợp lệ");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThongBao.setBounds(41, 693, 1043, 30);
		add(lblThongBao);

		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		lblHienMK.addMouseListener(this);
		lblAnMK.addMouseListener(this);

		cboLoaiNV.addActionListener(this);
		btnChonFile.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblHienMK)) {
			txtMatKhau.setEchoChar((char) 0);
			lblHienMK.setVisible(false);
			lblAnMK.setVisible(true);
		} else if (o.equals(lblAnMK)) {
			txtMatKhau.setEchoChar('●');
			lblAnMK.setVisible(false);
			lblHienMK.setVisible(true);
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

	private NhanVienHanhChinh getNhanVienHanhChinh() {
		String maNV = lblMaNV.getText();
		String tenNV = txtTenNV.getText();
		String vaiTroText = (String) cboQuyenTruyCap.getSelectedItem();
		boolean vaiTro = vaiTroText == "Nhân viên bán hàng" ? true : false;
		boolean gioiTinh = rdbtnNam.isSelected();
		Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
		String sdt = txtSoDienThoai.getText();
		String diaChi = txtDiaChi.getText();
		String urlAnh = txtAnh.getText();
		String chucVu = txtChucVu.getText();
		String trinhDoHocVan = txtTrinhDoHocVan.getText();
		String matKhau = txtMatKhau.getText();
		NhanVienHanhChinh nvHanhChinh = new NhanVienHanhChinh(maNV, tenNV, matKhau, gioiTinh, ngaySinh, sdt, diaChi,
				urlAnh, chucVu, trinhDoHocVan, vaiTro, true);
		System.out.println(nvHanhChinh);
		return nvHanhChinh;
	}

	private NhanVienKiThuat getNhanVienKiThuat() {
		String maNV = lblMaNV.getText();
		String tenNV = txtTenNV.getText();
		boolean gioiTinh = rdbtnNam.isSelected();
		Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
		String sdt = txtSoDienThoai.getText();
		String diaChi = txtDiaChi.getText();
		String urlAnh = txtAnh.getText();
		int soNamKN = Integer.parseInt(txtNamKinhNghiem.getText());
		String bacThoText = (String) cboBacTho.getSelectedItem();
		int bacTho = Integer.parseInt(bacThoText);
		String tenAnh = txtAnh.getText();
		// NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(maNV, tenNV, ngaySinh,
		// sdt, diaChi, soNamKN, bacTho, true);

		// return nhanVienKiThuat;

		NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(maNV, tenNV, ngaySinh, sdt, diaChi, soNamKN, bacTho, true,
				tenAnh, gioiTinh);
		return nhanVienKiThuat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(cboLoaiNV)) {
			if (cboLoaiNV.getSelectedIndex() == 1) {
				lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT));
				pnlNVHanhChinh.setVisible(false);
				pnlNVKyThuat.setVisible(true);
			} else {

				lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));
				pnlNVHanhChinh.setVisible(true);
				pnlNVKyThuat.setVisible(false);
			}
		}
		if (o.equals(btnChonFile)) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpg", "png", "jpg");
				fileChooser.setFileFilter(imgFilter);
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setPreferredSize(new Dimension(900, 600));
				if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					lblAnh.setIcon(new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage()
							.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
					txtAnh.setText(f.getPath());
				}

				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

//				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lblAnh.setText("");
		}
		if (o.equals(btnThoat)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_NhanVien());
			this.validate();
			this.repaint();
		}

		if (o.equals(btnThem)) {

			NhanVienHanhChinh nvHanhChinh = null;
			NhanVienKiThuat nvKiThuat = null;

			nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();
			nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();

			if (cboLoaiNV.getSelectedIndex() == 0) {

				nvHanhChinh = getNhanVienHanhChinh();

				if (validateNhanVienHanhChinh(nvHanhChinh)) {

					if (nhanVienHanhChinhDao.themNhanVienHanhChinh(nvHanhChinh)) {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công", "Thông báo thêm nhân viên",
								JOptionPane.INFORMATION_MESSAGE, null);
						xoaRongText();
						
					} else {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại", "Thông báo thêm nhân viên",
								JOptionPane.ERROR_MESSAGE, null);
					}

				}
			} else {
				nvKiThuat = getNhanVienKiThuat();

				if (validateNhanVienKiThuat(nvKiThuat)) {
					if (nhanVienKiThuatDao.themNhanVienKiThuat(nvKiThuat)) {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công", "Thông báo thêm nhân viên",
								JOptionPane.INFORMATION_MESSAGE, null);
						xoaRongText();
						
					} else {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại", "Thông báo thêm nhân viên",
								JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
		}
		
		if(o.equals(btnXoaRong)) {
			xoaRongText();
		}

	}
	
	private void xoaRongText() {
		if(cboLoaiNV.getSelectedIndex() == 0) {
			lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));
			txtTenNV.setText("");
			rdbtnNam.setSelected(true);
			txtNgaySinh.setDate(new java.util.Date());
			txtSoDienThoai.setText("");
			txtDiaChi.setText("");
			txtChucVu.setText("");
			txtTrinhDoHocVan.setText("");
			cboQuyenTruyCap.setSelectedIndex(0);
			txtMatKhau.setText("");
			txtAnh.setText("");
		}else {
			lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT));
			txtTenNV.setText("");
			rdbtnNam.setSelected(true);
			txtNgaySinh.setDate(new java.util.Date());
			txtSoDienThoai.setText("");
			txtDiaChi.setText("");
			txtAnh.setText("");
			txtNamKinhNghiem.setText("");
			cboBacTho.setSelectedIndex(0);
			
		}
	}

	private boolean validateNhanVienHanhChinh(NhanVienHanhChinh nhanVienHanhChinh) {

		return true;
	}

	private boolean validateNhanVienKiThuat(NhanVienKiThuat nhanVienKiThuat) {

		return true;
	}
}
