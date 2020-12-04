package ui.quanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.Date;
import java.util.Optional;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import dao.NhanVienHanhChinhDao;
import entity.NhanVienHanhChinh;
import other.BatRegex;
import other.CopyTask;
import other.RegexNhanVienHanhChinh;
import ui.App;
import ui.quanLyXeMay.GD_ThemXeMay;

public class GD_SuaNhanVienHanhChinh extends JPanel implements ActionListener, MouseListener, FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTenNV;
	private JButton btnThem;
	private JButton btnThoat;
	private JTextField txtSoDienThoai;
	private JTextField txtAnh;
	private JTextField txtDiaChi;
	private JTextField txtChucVu;
	private JTextField txtTrinhDoHocVan;
	private JPasswordField txtMatKhau;
	private JLabel lblHienMK;
	private JLabel lblAnMK;
	private JPanel pnlNVHanhChinh;
	private JButton btnChonFile;
	private JLabel lblAnh;
	private JPanel pnlAnh;
	private JButton btnResetMK;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;
	private JLabel lblMaNV;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private JDateChooser txtNgaySinh;
	private JComboBox<String> cboQuyenTruyCap;
	private String filePath;

	private boolean isTenNVHanhChinh = false;
	private boolean isSoDTNhanVienHC = false;
	private boolean isDiaChiNVHanhChinh = false;
	private boolean isChucVuNVHanhChinh = false;
	private boolean isTrinhDoNVHanhChinh = false;
	private boolean isNgaySinhNVHanhChinh = false;
	private boolean isMatKhau = false;

	private JTextArea taThongBao;

	/**
	 * Create the panel.
	 */
	public GD_SuaNhanVienHanhChinh(String maNVThaoTac) {
		nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();
		NhanVienHanhChinh nhanVienHanhChinh = nhanVienHanhChinhDao.getNVHanhChinhTheoMa(maNVThaoTac);
//		this.nhanVienHanhChinh = nhanVienHanhChinh;

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cập nhật thông tin nhân viên hành chính");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JLabel lblTngThuTrong_1 = new JLabel("Mã nhân viên:");
		lblTngThuTrong_1.setBounds(41, 76, 126, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV = new JTextField(nhanVienHanhChinh.getHoTenNV());
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setBounds(232, 136, 325, 30);
		add(txtTenNV);
		txtTenNV.setColumns(10);

		btnThem = new JButton("Lưu");
		btnThem.setToolTipText("Thêm nhân viên");
		btnThem.setIcon(new ImageIcon(GD_SuaNhanVienHanhChinh.class.getResource("/img/restore_page_30px.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1575, 798, 168, 40);
		add(btnThem);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 877, 1800, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1800, 133);
		pnlLogo.add(lblLogo);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(
				new ImageIcon(GD_SuaNhanVienHanhChinh.class.getResource("/img/baseline_close_white_24dp.png")));
		btnThoat.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(41, 798, 168, 40);
		add(btnThoat);

		// set mã nhân viên
		lblMaNV = new JLabel(nhanVienHanhChinh.getMaNVHanhChinh());
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(232, 76, 126, 30);
		add(lblMaNV);

		JLabel lblLNV = new JLabel("Loại nhân viên:");
		lblLNV.setForeground(Color.BLACK);
		lblLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLNV.setBounds(755, 76, 147, 30);
		add(lblLNV);

		JLabel lblTNV = new JLabel("Tên nhân viên:");
		lblTNV.setForeground(Color.BLACK);
		lblTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTNV.setBounds(41, 136, 139, 30);
		add(lblTNV);

		JLabel lblGT = new JLabel("Giới tính:");
		lblGT.setForeground(Color.BLACK);
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGT.setBounds(755, 136, 147, 30);
		add(lblGT);

		pnlAnh = new JPanel();
		pnlAnh.setBackground(Color.WHITE);
		pnlAnh.setBounds(1354, 79, 325, 301);
		add(pnlAnh);
		pnlAnh.setLayout(null);

		lblAnh = new JLabel();
		lblAnh.setIcon(new ImageIcon(GD_SuaNhanVienHanhChinh.class.getResource("/img/pictures_folder_30px.png")));
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBounds(0, 0, 325, 301);
		pnlAnh.add(lblAnh);
		// Kiểm tra xem ảnh có null không
		Optional<String> optional = Optional.ofNullable(nhanVienHanhChinh.getTenAnh());
		if (optional.isPresent()) {
			lblAnh.setIcon(new ImageIcon(new ImageIcon("ImgNhanVien/" + nhanVienHanhChinh.getTenAnh().trim()).getImage()
					.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		} else {
			if (nhanVienHanhChinh.isGioiTinh()) {
				lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png"))
						.getImage().getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			} else {
				lblAnh.setIcon(new ImageIcon(
						new ImageIcon(GD_ThemXeMay.class.getResource("/img/female-student-silhouette.png")).getImage()
								.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			}
		}

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(942, 142, 127, 25);
		add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(1073, 142, 127, 25);
		add(rdbtnNu);

		// set giới tính
		if (nhanVienHanhChinh.isGioiTinh() == false) {
			rdbtnNu.setSelected(true);
		} else {
			rdbtnNam.setSelected(true);
		}

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

		// set ngày sinh
		txtNgaySinh.setDate(nhanVienHanhChinh.getNgaySinh());
		add(txtNgaySinh);

		JLabel lblSsss = new JLabel("Số điện thoại:");
		lblSsss.setForeground(Color.BLACK);
		lblSsss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSsss.setBounds(755, 205, 147, 30);
		add(lblSsss);

		// set số điện thoại
		txtSoDienThoai = new JTextField(nhanVienHanhChinh.getSoDienThoai());
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(942, 205, 228, 30);
		add(txtSoDienThoai);

		JLabel lblanh = new JLabel("Ảnh:");
		lblanh.setForeground(Color.BLACK);
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblanh.setBounds(41, 350, 147, 30);
		add(lblanh);

		// set ten anh
		txtAnh = new JTextField(nhanVienHanhChinh.getTenAnh());
		txtAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnh.setColumns(10);
		txtAnh.setBounds(232, 350, 708, 30);
		add(txtAnh);

		btnChonFile = new JButton("Chọn file");
		btnChonFile.setIcon(new ImageIcon(GD_SuaNhanVienHanhChinh.class.getResource("/img/opened_folder_26px.png")));
		btnChonFile.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnChonFile.setForeground(Color.WHITE);
		btnChonFile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChonFile.setBackground(Color.GRAY);
		btnChonFile.setBounds(1002, 350, 168, 30);
		add(btnChonFile);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaCh.setBounds(41, 279, 105, 30);
		add(lblaCh);

		// set dia chi
		txtDiaChi = new JTextField(nhanVienHanhChinh.getDiaChi());
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(232, 279, 938, 30);
		add(txtDiaChi);

		JPanel pnlLoaiNV = new JPanel();
		pnlLoaiNV.setBackground(Color.WHITE);
		pnlLoaiNV.setBounds(12, 407, 1240, 273);
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

		// set chuc vu
		txtChucVu = new JTextField(nhanVienHanhChinh.getChucVu());
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(224, 13, 305, 30);
		pnlNVHanhChinh.add(txtChucVu);

		JLabel lblChcV_1 = new JLabel("Trình độ học vấn:");
		lblChcV_1.setForeground(Color.BLACK);
		lblChcV_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV_1.setBounds(755, 13, 156, 30);
		pnlNVHanhChinh.add(lblChcV_1);

		// set trinh do hoc van
		txtTrinhDoHocVan = new JTextField(nhanVienHanhChinh.getTrinhDoHocVan());
		txtTrinhDoHocVan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrinhDoHocVan.setColumns(10);
		txtTrinhDoHocVan.setBounds(942, 13, 227, 30);
		pnlNVHanhChinh.add(txtTrinhDoHocVan);

		JLabel lblQuynTruyCp = new JLabel("Quyền truy cập:");
		lblQuynTruyCp.setForeground(Color.BLACK);
		lblQuynTruyCp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuynTruyCp.setBounds(28, 81, 147, 30);
		pnlNVHanhChinh.add(lblQuynTruyCp);

		cboQuyenTruyCap = new JComboBox<String>();
		cboQuyenTruyCap
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Nhân viên bán hàng", "Người quản lý" }));

		// set quyền truy cập
		if (nhanVienHanhChinh.isVaiTro() == false)
			cboQuyenTruyCap.setSelectedIndex(0);
		else
			cboQuyenTruyCap.setSelectedIndex(1);

		cboQuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboQuyenTruyCap.setBounds(224, 81, 305, 30);
		pnlNVHanhChinh.add(cboQuyenTruyCap);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(755, 81, 147, 30);
		pnlNVHanhChinh.add(lblMtKhu);

		txtMatKhau = new JPasswordField(nhanVienHanhChinh.getMatKhau());
		txtMatKhau.setToolTipText("");
		txtMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(942, 84, 227, 30);
		pnlNVHanhChinh.add(txtMatKhau);

		lblHienMK = new JLabel("");
		lblHienMK.setIcon(
				new ImageIcon(GD_SuaNhanVienHanhChinh.class.getResource("/img/baseline_visibility_black_36dp.png")));
		lblHienMK.setForeground(Color.BLACK);
		lblHienMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHienMK.setBounds(1188, 84, 40, 30);
		pnlNVHanhChinh.add(lblHienMK);

		lblAnMK = new JLabel("");
		lblAnMK.setIcon(new ImageIcon(
				GD_SuaNhanVienHanhChinh.class.getResource("/img/baseline_visibility_off_black_36dp.png")));
		lblAnMK.setForeground(Color.BLACK);
		lblAnMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnMK.setBounds(1188, 84, 40, 30);
		pnlNVHanhChinh.add(lblAnMK);

		btnResetMK = new JButton("Reset mật khẩu");
		btnResetMK.setIcon(new ImageIcon(GD_SuaNhanVienHanhChinh.class.getResource("/img/reset_30px.png")));
		btnResetMK.setToolTipText("Reset mật khẩu về lại mặc định");
		btnResetMK.setForeground(Color.WHITE);
		btnResetMK.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnResetMK.setBackground(Color.GRAY);
		btnResetMK.setBounds(942, 137, 227, 35);
		pnlNVHanhChinh.add(btnResetMK);
		lblAnMK.setVisible(false);

		JLabel lblLoaiNV = new JLabel("Nhân viên hành chính");
		lblLoaiNV.setForeground(Color.BLACK);
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiNV.setBounds(942, 76, 228, 30);
		add(lblLoaiNV);

		taThongBao = new JTextArea();
		taThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		taThongBao.setForeground(Color.red);
		taThongBao.setBounds(41, 680, 899, 103);
		add(taThongBao);

		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnThoat.addActionListener(this);
		lblHienMK.addMouseListener(this);
		lblAnMK.addMouseListener(this);
		btnChonFile.addActionListener(this);
		btnResetMK.addActionListener(this);
		rdbtnNam.addMouseListener(this);
		rdbtnNu.addMouseListener(this);

		txtTenNV.addFocusListener(this);
		txtSoDienThoai.addFocusListener(this);
		txtDiaChi.addFocusListener(this);
		txtTrinhDoHocVan.addFocusListener(this);
		txtChucVu.addFocusListener(this);
		txtMatKhau.addFocusListener(this);
		;
		txtNgaySinh.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {
					if (!BatRegex.kiemTraNgaySinh(txtNgaySinh))
						isNgaySinhNVHanhChinh = true;
				}
			}
		});

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblHienMK)) {
			txtMatKhau.setEchoChar((char) 0);
			lblHienMK.setVisible(false);
			lblAnMK.setVisible(true);
		}

		if (o.equals(lblAnMK)) {
			txtMatKhau.setEchoChar('●');
			lblAnMK.setVisible(false);
			lblHienMK.setVisible(true);
		}

		if (o.equals(rdbtnNam)) {
			lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png")).getImage()
					.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		}
		if (o.equals(rdbtnNu)) {
			lblAnh.setIcon(
					new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/female-student-silhouette.png"))
							.getImage().getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
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

					filePath = f.getAbsolutePath();
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
		if (o.equals(btnResetMK)) {
//			JOptionPane.showConfirmDialog(this, message)
			int t = JOptionPane.showConfirmDialog(null, "bạn có chắc chắn muốn reset mật khẩu không?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (t == JOptionPane.YES_OPTION) {
				txtMatKhau.setText("12345678");
			}
		}
		if (o.equals(btnThoat)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_NhanVien());
			this.validate();
			this.repaint();
		}

		if (o.equals(btnThem)) {
			NhanVienHanhChinh nhanVienHanhChinh = getNhanVienHanhChinh();

			if (validateNhanVienHanhChinh(nhanVienHanhChinh)) {

				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn cập nhật không ?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					nhanVienHanhChinhDao.capNhatNhanVienHanhChinh(nhanVienHanhChinh);
					if (txtAnh.getText().trim().contains("\\")) {
						String fileNameExtentions = filePath.split("\\.")[1];
						CopyTask task = new CopyTask(filePath,
								"ImgNhanVien/" + lblMaNV.getText().trim() + "." + fileNameExtentions);
						task.execute();
					}

					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				}
			} else {
				isTenNVHanhChinh = true;
				isChucVuNVHanhChinh = true;
				isSoDTNhanVienHC = true;
				isTrinhDoNVHanhChinh = true;
				isDiaChiNVHanhChinh = true;
				thongbaoLoi();
			}

		}

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
		String urlAnh = txtAnh.getText().trim();
		String tenAnh = null;
		if (!urlAnh.equals("")) {
			if (urlAnh.contains("\\")) {
				tenAnh = lblMaNV.getText().trim() + "." + urlAnh.split("\\.")[1];
			} else {
				tenAnh = urlAnh;
			}
		}

		String chucVu = txtChucVu.getText();
		String trinhDoHocVan = txtTrinhDoHocVan.getText();
		@SuppressWarnings("deprecation")
		String matKhau = txtMatKhau.getText();
		NhanVienHanhChinh nvHanhChinh = new NhanVienHanhChinh(maNV, tenNV, matKhau, gioiTinh, ngaySinh, sdt, diaChi,
				tenAnh, chucVu, trinhDoHocVan, vaiTro, true);
		return nvHanhChinh;
	}

	private boolean validateNhanVienHanhChinh(NhanVienHanhChinh nhanVienHanhChinh) {
		if (RegexNhanVienHanhChinh.ktraTenNV(txtTenNV) && RegexNhanVienHanhChinh.ktraChucVu(txtChucVu)
				&& RegexNhanVienHanhChinh.KtraDiaChi(txtDiaChi) && RegexNhanVienHanhChinh.ktraSDT(txtSoDienThoai)
				&& RegexNhanVienHanhChinh.ktraTrinhDo(txtTrinhDoHocVan))
			return true;
		return false;
	}

	private void thongbaoLoi() {
		taThongBao.setText("");
		if (!RegexNhanVienHanhChinh.ktraTenNV(txtTenNV) && isTenNVHanhChinh)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.TEN_NV);
		if (!RegexNhanVienHanhChinh.ktraSDT(txtSoDienThoai) && isSoDTNhanVienHC)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.SO_DT);
		if (!RegexNhanVienHanhChinh.KtraDiaChi(txtDiaChi) && isDiaChiNVHanhChinh)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.DIA_CHI);
		if (!RegexNhanVienHanhChinh.ktraTrinhDo(txtTrinhDoHocVan) && isTrinhDoNVHanhChinh)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.TRINH_DO_HV);
		if (!RegexNhanVienHanhChinh.ktraChucVu(txtChucVu) && isChucVuNVHanhChinh)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.CHUC_VU);
		if (!RegexNhanVienHanhChinh.ktraNgaySinh(txtNgaySinh) && isNgaySinhNVHanhChinh)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.NGAY_SINH);
		if (!RegexNhanVienHanhChinh.ktraMatKhau(txtMatKhau) && isMatKhau)
			taThongBao.setText(taThongBao.getText() + "\n" + RegexNhanVienHanhChinh.MAT_KHAU);
	}

	@Override
	public void focusGained(FocusEvent e) {
		Object o = e.getSource();
		if (o.equals(txtTenNV))
			isTenNVHanhChinh = true;
		if (o.equals(txtChucVu))
			isChucVuNVHanhChinh = true;
		if (o.equals(txtDiaChi))
			isDiaChiNVHanhChinh = true;
		if (o.equals(txtTrinhDoHocVan))
			isTrinhDoNVHanhChinh = true;
		if (o.equals(txtSoDienThoai))
			isSoDTNhanVienHC = true;
		if (o.equals(txtMatKhau))
			isMatKhau = true;
		if (o.equals(txtNgaySinh))
			isNgaySinhNVHanhChinh = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
		thongbaoLoi();
	}

}
