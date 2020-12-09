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
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

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

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.toedter.calendar.JDateChooser;

import constant.TenEntity;
import dao.NhanVienHanhChinhDao;
import dao.NhanVienKiThuatDao;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;
import other.BatRegex;
import other.CopyTask;
import other.RandomMa;
import other.RegexNVKiThuat;
import other.RegexNhanVienHanhChinh;
import ui.App;
import ui.quanLyXeMay.GD_ThemXeMay;

public class GD_ThemNhanVien extends JPanel implements ActionListener, FocusListener, MouseListener {

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
	private JComboBox<String> cboLoaiNV;
	private JPanel pnlNVHanhChinh;
	private JPanel pnlNVKyThuat;
	private JButton btnChonFile;
	private JLabel lblAnh;
	private JPanel pnlAnh;
	private JDateChooser txtNgaySinh;
	private JComboBox<String> cboQuyenTruyCap;
	private JComboBox<String> cboBacTho;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;
	private NhanVienKiThuatDao nhanVienKiThuatDao;

	private boolean isTenNVHanhChinh = false;
	private boolean isSoDTNhanVienHC = false;
	private boolean isDiaChiNVHanhChinh = false;
	private boolean isChucVuNVHanhChinh = false;
	private boolean isTrinhDoNVHanhChinh = false;
	private boolean isNgaySinhNVHanhChinh = false;
	private boolean isMatKhau = false;

	private boolean isTenNVKiThuat = false;
	private boolean isSoDTNhanVienKT = false;
	private boolean isDiaChiNVKiThuat = false;
	private boolean isSoNamKNKiThuat = false;
	private boolean isNgaySinhKiThuat = false;

	private int check;

	private JTextArea taThongBao;

	private String filePath;

	/**
	 * Create the panel.
	 */
	public GD_ThemNhanVien() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm nhân viên");
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
		btnThem.setBounds(1575, 808, 168, 40);
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

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setToolTipText("Xóa trắng các trường nhập dữ liệu");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setBounds(1332, 808, 168, 40);
		add(btnXoaRong);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_close_white_24dp.png")));
		btnThoat.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(41, 808, 168, 40);
		add(btnThoat);

		lblMaNV = new JLabel();

		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(232, 76, 126, 30);
		add(lblMaNV);

		JLabel lblLNV = new JLabel("Loại nhân viên:");
		lblLNV.setForeground(Color.BLACK);
		lblLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLNV.setBounds(755, 76, 147, 30);
		add(lblLNV);

		cboLoaiNV = new JComboBox<String>();
		cboLoaiNV.setBackground(Color.WHITE);
		cboLoaiNV.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Nhân viên hành chính", "Nhân viên kỹ thuật" }));
		cboLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiNV.setBounds(942, 79, 228, 30);
		add(cboLoaiNV);
		lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));

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
		lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png")).getImage()
				.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBounds(0, 0, 325, 301);
		pnlAnh.add(lblAnh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(942, 142, 127, 25);
		rdbtnNam.setSelected(true);
		add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(1073, 142, 127, 25);
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
		lblSsss.setBounds(755, 205, 147, 30);
		add(lblSsss);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(942, 205, 228, 30);
		add(txtSoDienThoai);

		JLabel lblanh = new JLabel("Ảnh:");
		lblanh.setForeground(Color.BLACK);
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblanh.setBounds(41, 350, 147, 30);
		add(lblanh);

		txtAnh = new JTextField();
		txtAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnh.setColumns(10);
		txtAnh.setBounds(232, 350, 708, 30);
		add(txtAnh);

		btnChonFile = new JButton("Chọn file");
		btnChonFile.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/opened_folder_26px.png")));
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

		txtDiaChi = new JTextField();
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

		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(224, 13, 305, 30);
		pnlNVHanhChinh.add(txtChucVu);

		JLabel lblChcV_1 = new JLabel("Trình độ học vấn:");
		lblChcV_1.setForeground(Color.BLACK);
		lblChcV_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChcV_1.setBounds(755, 13, 156, 30);
		pnlNVHanhChinh.add(lblChcV_1);

		txtTrinhDoHocVan = new JTextField();
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
		cboQuyenTruyCap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboQuyenTruyCap.setBounds(224, 81, 305, 30);
		pnlNVHanhChinh.add(cboQuyenTruyCap);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(Color.BLACK);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(755, 81, 147, 30);
		pnlNVHanhChinh.add(lblMtKhu);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setToolTipText("Mật khẩu mặc định là 12345678");
		txtMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setBounds(942, 84, 227, 30);
		txtMatKhau.setText("12345678");
		pnlNVHanhChinh.add(txtMatKhau);

		lblHienMK = new JLabel("");
		lblHienMK.setIcon(new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_visibility_black_36dp.png")));
		lblHienMK.setForeground(Color.BLACK);
		lblHienMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHienMK.setBounds(1188, 84, 40, 30);
		pnlNVHanhChinh.add(lblHienMK);

		lblAnMK = new JLabel("");
		lblAnMK.setIcon(
				new ImageIcon(GD_ThemNhanVien.class.getResource("/img/baseline_visibility_off_black_36dp.png")));
		lblAnMK.setForeground(Color.BLACK);
		lblAnMK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnMK.setBounds(1188, 84, 40, 30);
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
		lblBcTh.setBounds(755, 13, 152, 30);
		pnlNVKyThuat.add(lblBcTh);

		cboBacTho = new JComboBox<String>();
		cboBacTho.setBackground(Color.WHITE);
		cboBacTho.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
		cboBacTho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboBacTho.setBounds(942, 13, 228, 30);
		pnlNVKyThuat.add(cboBacTho);

		taThongBao = new JTextArea();
		taThongBao.setForeground(Color.RED);
		taThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		taThongBao.setBounds(38, 693, 929, 76);
		add(taThongBao);

		dangKiSuKien();

	}

	private void thongbaoLoi() {
		if (check == 0) {
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
		} else {
			taThongBao.setText("");
			if (!RegexNVKiThuat.ktraTenNV(txtTenNV) && isTenNVKiThuat)
				taThongBao.setText(taThongBao.getText() + "\n" + RegexNVKiThuat.TEN_NV);
			if (!RegexNVKiThuat.ktraSDT(txtSoDienThoai) && isSoDTNhanVienKT)
				taThongBao.setText(taThongBao.getText() + "\n" + RegexNVKiThuat.SO_DT);
			if (!RegexNVKiThuat.KtraDiaChi(txtDiaChi) && isDiaChiNVKiThuat)
				taThongBao.setText(taThongBao.getText() + "\n" + RegexNVKiThuat.DIA_CHI);
			if (!RegexNVKiThuat.KtraSoNamKN(txtNamKinhNghiem) && isSoNamKNKiThuat)
				taThongBao.setText(taThongBao.getText() + "\n" + RegexNVKiThuat.SO_NAM_KN);
			if (!RegexNVKiThuat.ktraNgaySinh(txtNgaySinh) && isNgaySinhKiThuat)
				taThongBao.setText(taThongBao.getText() + "\n" + RegexNVKiThuat.NGAY_SINH);
		}
	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		lblHienMK.addMouseListener(this);
		lblAnMK.addMouseListener(this);

		cboLoaiNV.addActionListener(this);
		btnChonFile.addActionListener(this);

		rdbtnNam.addMouseListener(this);
		rdbtnNu.addMouseListener(this);

		txtTenNV.addFocusListener(this);
		txtSoDienThoai.addFocusListener(this);
		txtDiaChi.addFocusListener(this);
		txtTrinhDoHocVan.addFocusListener(this);
		txtChucVu.addFocusListener(this);
		txtMatKhau.addFocusListener(this);
		txtNamKinhNghiem.addFocusListener(this);
		txtNgaySinh.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {

					if (check == 0) {
						if (!RegexNhanVienHanhChinh.ktraNgaySinh(txtNgaySinh))
							isNgaySinhNVHanhChinh = true;
					} else {
						if (!RegexNVKiThuat.ktraNgaySinh(txtNgaySinh))
							isNgaySinhKiThuat = true;
					}

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

	private NhanVienHanhChinh getNhanVienHanhChinh() {
		if (txtAnh.getText().trim().contains("\\")) {
			String fileNameExtentions = filePath.split("\\.")[1];
			CopyTask task = new CopyTask(filePath,
					"ImgNhanVien/" + lblMaNV.getText().trim() + "." + fileNameExtentions);
			task.execute();
		}

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
			tenAnh = lblMaNV.getText().trim() + "." + urlAnh.split("\\.")[1];
		}

		String chucVu = txtChucVu.getText();
		String trinhDoHocVan = txtTrinhDoHocVan.getText();
		@SuppressWarnings("deprecation")
		String matKhau = txtMatKhau.getText();
		NhanVienHanhChinh nvHanhChinh = new NhanVienHanhChinh(maNV, tenNV, matKhau, gioiTinh, ngaySinh, sdt, diaChi,
				tenAnh, chucVu, trinhDoHocVan, vaiTro, true);
		System.out.println(nvHanhChinh);
		return nvHanhChinh;
	}

	private NhanVienKiThuat getNhanVienKiThuat() {
		if (txtAnh.getText().trim().contains("\\")) {
			String fileNameExtentions = filePath.split("\\.")[1];
			CopyTask task = new CopyTask(filePath,
					"ImgNhanVien/" + lblMaNV.getText().trim() + "." + fileNameExtentions);
			task.execute();
		}

		String maNV = lblMaNV.getText();
		String tenNV = txtTenNV.getText();
		boolean gioiTinh = rdbtnNam.isSelected();
		Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
		String sdt = txtSoDienThoai.getText();
		String diaChi = txtDiaChi.getText();

		String urlAnh = txtAnh.getText().trim();
		String tenAnh = null;
		if (!urlAnh.equals("")) {
			tenAnh = lblMaNV.getText().trim() + "." + urlAnh.split("\\.")[1];
		}

		int soNamKN = Integer.parseInt(txtNamKinhNghiem.getText());

		String bacThoText = (String) cboBacTho.getSelectedItem();
		int bacTho = Integer.parseInt(bacThoText);

		NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(maNV, tenNV, ngaySinh, sdt, diaChi, soNamKN, bacTho, true,
				tenAnh, gioiTinh);
		return nhanVienKiThuat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		check = cboLoaiNV.getSelectedIndex();
		if (o.equals(cboLoaiNV)) {
			check = cboLoaiNV.getSelectedIndex();

			if (cboLoaiNV.getSelectedIndex() == 1) {
				lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT));
				pnlNVHanhChinh.setVisible(false);
				pnlNVKyThuat.setVisible(true);
				taThongBao.setText("");

			} else {

				lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));
				pnlNVHanhChinh.setVisible(true);
				pnlNVKyThuat.setVisible(false);
				taThongBao.setText("");
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

					String to = f.getAbsolutePath().split("\\.")[1];
					CopyTask task = new CopyTask(f.getAbsolutePath(),
							"ImgNhanVien/" + lblMaNV.getText().trim() + "." + to);

					filePath = f.getAbsolutePath();
				}

				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
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

					try {
						if (nhanVienHanhChinhDao.themNhanVienHanhChinh(nvHanhChinh)) {
							JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công", "Thông báo thêm nhân viên",
									JOptionPane.INFORMATION_MESSAGE, null);
							xoaRongText();
							taThongBao.setText("");

						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại", "Thông báo thêm nhân viên",
								JOptionPane.ERROR_MESSAGE, null);
					}
				}

				else {
					isTenNVHanhChinh = true;
					isChucVuNVHanhChinh = true;
					isSoDTNhanVienHC = true;
					isTrinhDoNVHanhChinh = true;
					isDiaChiNVHanhChinh = true;
					isNgaySinhNVHanhChinh = true;
					thongbaoLoi();
				}
			} else {

				if (validateNhanVienKiThuat(nvKiThuat)) {
					nvKiThuat = getNhanVienKiThuat();
					if (nhanVienKiThuatDao.themNhanVienKiThuat(nvKiThuat)) {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công", "Thông báo thêm nhân viên",
								JOptionPane.INFORMATION_MESSAGE, null);
						xoaRongText();
						taThongBao.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại", "Thông báo thêm nhân viên",
								JOptionPane.ERROR_MESSAGE, null);
					}
				} else {
					isTenNVKiThuat = true;
					isSoDTNhanVienKT = true;
					isSoNamKNKiThuat = true;
					isDiaChiNVKiThuat = true;
					isNgaySinhKiThuat = true;
					thongbaoLoi();
				}
			}
		}

		if (o.equals(btnXoaRong)) {
			xoaRongText();
		}

	}

	private void xoaRongText() {

	

			if (check == 0) {
				lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_HANH_CHINH));
				txtTenNV.setText("");
				rdbtnNam.setSelected(true);
				txtNgaySinh.setDate(new java.util.Date());
				txtSoDienThoai.setText("");
				txtDiaChi.setText("");
				txtChucVu.setText("");
				txtTrinhDoHocVan.setText("");
				cboQuyenTruyCap.setSelectedIndex(0);
				txtMatKhau.setText("12345678");
				txtAnh.setText("");
				lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png"))
						.getImage().getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			} else {
				lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT));
				txtTenNV.setText("");
				rdbtnNam.setSelected(true);
				txtNgaySinh.setDate(new java.util.Date());
				txtSoDienThoai.setText("");
				txtDiaChi.setText("");
				txtAnh.setText("");
				txtNamKinhNghiem.setText("");
				cboBacTho.setSelectedIndex(0);
				lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png"))
						.getImage().getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));

			}
		

	}

	private boolean validateNhanVienHanhChinh(NhanVienHanhChinh nhanVienHanhChinh) {
		if (RegexNhanVienHanhChinh.ktraTenNV(txtTenNV) && RegexNhanVienHanhChinh.ktraChucVu(txtChucVu)
				&& RegexNhanVienHanhChinh.KtraDiaChi(txtDiaChi) && RegexNhanVienHanhChinh.ktraSDT(txtSoDienThoai)
				&& RegexNhanVienHanhChinh.ktraTrinhDo(txtTrinhDoHocVan) && RegexNhanVienHanhChinh.ktraNgaySinh(txtNgaySinh))
			return true;
		return false;
	}

	private boolean validateNhanVienKiThuat(NhanVienKiThuat nhanVienKiThuat) {
		if (RegexNVKiThuat.ktraTenNV(txtTenNV) && RegexNVKiThuat.ktraSDT(txtSoDienThoai)
				&& RegexNVKiThuat.KtraDiaChi(txtDiaChi) && RegexNVKiThuat.KtraSoNamKN(txtNamKinhNghiem)
				&& RegexNVKiThuat.ktraNgaySinh(txtNgaySinh))
			return true;
		return false;
	}

	@Override
	public void focusGained(FocusEvent e) {
		Object o = e.getSource();

		if (check == 0) {
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
		} else {
			if (o.equals(txtTenNV))
				isTenNVKiThuat = true;
			if (o.equals(txtSoDienThoai))
				isSoDTNhanVienKT = true;
			if (o.equals(txtDiaChi))
				isDiaChiNVKiThuat = true;
			if (o.equals(txtNamKinhNghiem))
				isSoNamKNKiThuat = true;
			if (o.equals(txtNgaySinh))
				isNgaySinhKiThuat = true;

		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		thongbaoLoi();

	}
}
