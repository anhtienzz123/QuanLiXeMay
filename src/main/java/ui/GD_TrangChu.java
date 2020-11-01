package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import other.DocSo;
import other.DongHoAnalog;
import ui.quanLyHoaDon.GD_ChiTietHoaDon;
import ui.quanLyKhachHang.GD_ThemKhachHang;
import ui.quanLyXeMay.GD_ChiTietXeMay;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class GD_TrangChu extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelHoaDon;
	private DefaultTableModel modelXe;
	private JLabel lblNgay;
	private JLabel lblGio;
	private JLabel lblMaNhanVien;
	private JLabel lblTenNhanVien;
	private JLabel lblChucVu;
	private JLabel lblLapHoaDon;
	private JLabel lblIconLapHoaDon;
	private JPanel pnlThemKhachHang;
	private JPanel pnlLapHoaDon;
	private JLabel lblThemKhachHang;
	private JLabel lblIconThemKhachHang;
	private JPanel pnlQuanLyHangXe;
	private JLabel lblQuanLyHangXe;
	private JLabel lblIconQuanLyHangXe;
	private JPanel pnlDoanhSoTheoNgay;
	private JLabel lblDoanhSoTheoNgay;
	private JLabel lblIconDoanhSoTheoNgay;
	private JPanel pnlThemXeMay;
	private JLabel lblIconThemXeMay;
	private JLabel lblThemXeMay;
	private JPanel pnlThemNhanVien;
	private JLabel lblThemNhanVien;
	private JLabel lblIconThemNhanVien;
	private List<DanhMuc> listDanhMuc;

	/**
	 * Create the panel.
	 */
	public GD_TrangChu() {
<<<<<<< HEAD
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Trang chủ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin nhân viên:");
		lblNewLabel_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1.setBounds(924, 458, 266, 50);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Liên kết nhanh:");
		lblNewLabel_1_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1_1.setBounds(67, 52, 266, 50);
		add(lblNewLabel_1_1);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(58, 181, 74));
		separator.setBounds(924, 498, 501, 30);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(58, 181, 74));
		separator_1.setBounds(67, 92, 790, 30);
		add(separator_1);

		JLabel lblMNV = new JLabel("Mã nhân viên:");
		lblMNV.setForeground(Color.BLACK);
		lblMNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMNV.setBackground(new Color(102, 102, 255));
		lblMNV.setBounds(924, 505, 159, 50);
		add(lblMNV);

		 lblMaNhanVien = new JLabel("NV123456");
		lblMaNhanVien.setForeground(Color.BLACK);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMaNhanVien.setBackground(new Color(102, 102, 255));
		lblMaNhanVien.setBounds(1124, 505, 124, 50);
		add(lblMaNhanVien);

		JLabel lblTNV = new JLabel("Tên nhân viên:");
		lblTNV.setForeground(Color.BLACK);
		lblTNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTNV.setBackground(new Color(102, 102, 255));
		lblTNV.setBounds(924, 550, 188, 50);
		add(lblTNV);

		 lblTenNhanVien = new JLabel("ABCDE");
		lblTenNhanVien.setForeground(Color.BLACK);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTenNhanVien.setBackground(new Color(102, 102, 255));
		lblTenNhanVien.setBounds(1124, 550, 264, 50);
		add(lblTenNhanVien);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(58, 181, 74));
		separator_1_1.setBounds(25, 710, 1400, 12);
		add(separator_1_1);

		JLabel lblChcV = new JLabel("Chức vụ:");
		lblChcV.setForeground(Color.BLACK);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblChcV.setBackground(new Color(102, 102, 255));
		lblChcV.setBounds(924, 595, 159, 50);
		add(lblChcV);

		 lblChucVu = new JLabel("Nhân viên bán hàng");
		lblChucVu.setForeground(Color.BLACK);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblChucVu.setBackground(new Color(102, 102, 255));
		lblChucVu.setBounds(1124, 595, 264, 50);
		add(lblChucVu);

		 pnlLapHoaDon = new JPanel();
		pnlLapHoaDon.setBackground(new Color(58, 181, 74));
		pnlLapHoaDon.setBounds(87, 115, 278, 165);
		add(pnlLapHoaDon);
		pnlLapHoaDon.setLayout(null);

		 lblLapHoaDon = new JLabel("Lập hóa đơn");
		lblLapHoaDon.setForeground(Color.WHITE);
		lblLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLapHoaDon.setBounds(0, 102, 278, 63);
		pnlLapHoaDon.add(lblLapHoaDon);
		
		 lblIconLapHoaDon = new JLabel("");
		lblIconLapHoaDon.setBounds(0, 0, 278, 123);
		pnlLapHoaDon.add(lblIconLapHoaDon);
		lblIconLapHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLapHoaDon.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/add_property_100px.png")));

		JPanel pnlLogo = new JPanel();
		pnlLogo.setLayout(null);
		pnlLogo.setBounds(0, 817, 1450, 133);
		add(pnlLogo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));

		lblLogo.setBounds(0, 0, 1450, 133);
		pnlLogo.add(lblLogo);

		JPanel pnlClock = new DongHoAnalog();
		pnlClock.setLayout(null);
		pnlClock.setBounds(991, 92, 317, 300);
		add(pnlClock);

		lblGio = new JLabel("00 : 00 : 00");
		lblGio.setForeground(Color.BLACK);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGio.setBackground(new Color(102, 102, 255));
		lblGio.setBounds(1163, 395, 145, 50);
		add(lblGio);

		lblNgay = new JLabel("");
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBackground(new Color(102, 102, 255));
		lblNgay.setBounds(992, 395, 159, 50);
		add(lblNgay);
		
		 pnlThemKhachHang = new JPanel();
		pnlThemKhachHang.setLayout(null);
		pnlThemKhachHang.setBackground(new Color(58, 181, 74));
		pnlThemKhachHang.setBounds(549, 115, 278, 165);
		add(pnlThemKhachHang);
		
		 lblThemKhachHang = new JLabel("Thêm khách hàng");
		lblThemKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemKhachHang.setForeground(Color.WHITE);
		lblThemKhachHang.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThemKhachHang.setBounds(0, 102, 278, 63);
		pnlThemKhachHang.add(lblThemKhachHang);
		
		 lblIconThemKhachHang = new JLabel("");
		lblIconThemKhachHang.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/add_user_male_100px.png")));
		lblIconThemKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThemKhachHang.setBounds(0, 0, 278, 123);
		pnlThemKhachHang.add(lblIconThemKhachHang);
		
		 pnlQuanLyHangXe = new JPanel();
		pnlQuanLyHangXe.setLayout(null);
		pnlQuanLyHangXe.setBackground(new Color(58, 181, 74));
		pnlQuanLyHangXe.setBounds(87, 314, 278, 165);
		add(pnlQuanLyHangXe);
		
		 lblQuanLyHangXe = new JLabel("Quản lý hãng xe");
		lblQuanLyHangXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyHangXe.setForeground(Color.WHITE);
		lblQuanLyHangXe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQuanLyHangXe.setBounds(0, 102, 278, 63);
		pnlQuanLyHangXe.add(lblQuanLyHangXe);
		
		 lblIconQuanLyHangXe = new JLabel("");
		lblIconQuanLyHangXe.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/supplier_100px.png")));
		lblIconQuanLyHangXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconQuanLyHangXe.setBounds(0, 0, 278, 123);
		pnlQuanLyHangXe.add(lblIconQuanLyHangXe);
		
		 pnlDoanhSoTheoNgay = new JPanel();
		pnlDoanhSoTheoNgay.setLayout(null);
		pnlDoanhSoTheoNgay.setBackground(new Color(58, 181, 74));
		pnlDoanhSoTheoNgay.setBounds(87, 517, 278, 165);
		add(pnlDoanhSoTheoNgay);
		
		 lblDoanhSoTheoNgay = new JLabel("Doanh số theo ngày");
		lblDoanhSoTheoNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoanhSoTheoNgay.setForeground(Color.WHITE);
		lblDoanhSoTheoNgay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDoanhSoTheoNgay.setBounds(0, 102, 278, 63);
		pnlDoanhSoTheoNgay.add(lblDoanhSoTheoNgay);
		
		 lblIconDoanhSoTheoNgay = new JLabel("");
		lblIconDoanhSoTheoNgay.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/calendar_100px.png")));
		lblIconDoanhSoTheoNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDoanhSoTheoNgay.setBounds(0, 0, 278, 123);
		pnlDoanhSoTheoNgay.add(lblIconDoanhSoTheoNgay);
		
		 pnlThemXeMay = new JPanel();
		pnlThemXeMay.setLayout(null);
		pnlThemXeMay.setBackground(new Color(58, 181, 74));
		pnlThemXeMay.setBounds(549, 314, 278, 165);
		add(pnlThemXeMay);
		
		 lblIconThemXeMay = new JLabel("");
		lblIconThemXeMay.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/scooter_100px.png")));
		lblIconThemXeMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThemXeMay.setBounds(0, 0, 278, 123);
		pnlThemXeMay.add(lblIconThemXeMay);
		
		 lblThemXeMay = new JLabel("Thêm xe máy");
		lblThemXeMay.setBounds(0, 102, 278, 63);
		pnlThemXeMay.add(lblThemXeMay);
		lblThemXeMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemXeMay.setForeground(Color.WHITE);
		lblThemXeMay.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		 pnlThemNhanVien = new JPanel();
		pnlThemNhanVien.setLayout(null);
		pnlThemNhanVien.setBackground(new Color(58, 181, 74));
		pnlThemNhanVien.setBounds(549, 517, 278, 165);
		add(pnlThemNhanVien);
		
		 lblThemNhanVien = new JLabel("Thêm nhân viên");
		lblThemNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemNhanVien.setForeground(Color.WHITE);
		lblThemNhanVien.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThemNhanVien.setBounds(0, 102, 278, 63);
		pnlThemNhanVien.add(lblThemNhanVien);
		
		 lblIconThemNhanVien = new JLabel("");
		lblIconThemNhanVien.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/add_administrator_100px.png")));
		lblIconThemNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThemNhanVien.setBounds(0, 0, 278, 123);
		pnlThemNhanVien.add(lblIconThemNhanVien);
		
		JLabel lblCaHngMotor = new JLabel("Cửa hàng MotorCycle Việt Nam");
		lblCaHngMotor.setForeground(Color.BLACK);
		lblCaHngMotor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCaHngMotor.setBackground(new Color(102, 102, 255));
		lblCaHngMotor.setBounds(87, 714, 364, 50);
		add(lblCaHngMotor);
		
		listDanhMuc = new ArrayList<DanhMuc>();
		listDanhMuc.add(new DanhMuc("LapHoaDon", pnlLapHoaDon,lblLapHoaDon));
		listDanhMuc.add(new DanhMuc("LapHoaDon", pnlLapHoaDon,lblIconLapHoaDon));
		listDanhMuc.add(new DanhMuc("ThemKhachHang", pnlThemKhachHang,lblThemKhachHang));
		listDanhMuc.add(new DanhMuc("ThemKhachHang", pnlThemKhachHang,lblIconThemKhachHang));
		listDanhMuc.add(new DanhMuc("QuanLyHangXe", pnlQuanLyHangXe,lblQuanLyHangXe));
		listDanhMuc.add(new DanhMuc("QuanLyHangXe", pnlQuanLyHangXe,lblIconQuanLyHangXe));
		listDanhMuc.add(new DanhMuc("ThemXeMay", pnlThemXeMay,lblThemXeMay));
		listDanhMuc.add(new DanhMuc("ThemXeMay", pnlThemXeMay,lblIconThemXeMay));
		listDanhMuc.add(new DanhMuc("DoanhSoTheoNgay", pnlDoanhSoTheoNgay,lblDoanhSoTheoNgay));
		listDanhMuc.add(new DanhMuc("DoanhSoTheoNgay", pnlDoanhSoTheoNgay,lblIconDoanhSoTheoNgay));
		listDanhMuc.add(new DanhMuc("ThemNhanVien", pnlThemNhanVien,lblThemNhanVien));
		listDanhMuc.add(new DanhMuc("ThemNhanVien", pnlThemNhanVien,lblIconThemNhanVien));
		ChuyenManHinh chuyen = new ChuyenManHinh(this);
		
		JLabel lblaCh = new JLabel("Địa chỉ: 151 điện biên phủ, phường 15, quận bình thạnh, Thành phố Hồ Chí Minh");
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblaCh.setBackground(new Color(102, 102, 255));
		lblaCh.setBounds(87, 759, 1004, 50);
		add(lblaCh);
		chuyen.setSuKien(listDanhMuc);
		dangKiSuKien();
		DongHo();
	}

	private void dangKiSuKien() {
	}

	public void DongHo() {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		SimpleDateFormat dt1 = new SimpleDateFormat("dd - MM - yyyy");
		lblNgay.setText(dt1.format(date));

		new Thread() {
			public void run() {
				while (true) {
					Calendar ca = new GregorianCalendar();
					int gio = ca.get(Calendar.HOUR_OF_DAY);
					int phut = ca.get(Calendar.MINUTE);
					int giay = ca.get(Calendar.SECOND);
					String dongHo = gio + " : " + phut + " : " + giay;
					lblGio.setText(dongHo);
				}
			}
		}.start();
	}
=======
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(1300, 900));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		Box horizontalBox = Box.createHorizontalBox();
		add(horizontalBox);

		int hoveredRow = -1, hoveredColumn = -1;


		pnlChiTietXe = new JPanel();
		pnlChiTietXe.setBackground(Color.WHITE);
		pnlChiTietXe.setPreferredSize(new Dimension(650, 900));
		horizontalBox.add(pnlChiTietXe);
		pnlChiTietXe.setLayout(new BoxLayout(pnlChiTietXe, BoxLayout.X_AXIS));

		Box verticalBox = Box.createVerticalBox();
		pnlChiTietXe.add(verticalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		pnlThongTinXe = new JPanel();
		pnlThongTinXe.setBackground(new Color(30, 144, 255));
		pnlThongTinXe.setPreferredSize(new Dimension(650, 50));
		pnlThongTinXe.setMaximumSize(new Dimension(32767, 50));
		horizontalBox_1.add(pnlThongTinXe);
		pnlThongTinXe.setLayout(new BoxLayout(pnlThongTinXe, BoxLayout.X_AXIS));

		lblThongTinXe = new JLabel("ThÃ´ng tin xe mÃ¡y");
		lblThongTinXe.setPreferredSize(new Dimension(650, 50));
		lblThongTinXe.setMaximumSize(new Dimension(2000, 50));
		lblThongTinXe.setForeground(new Color(255, 255, 255));
		lblThongTinXe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongTinXe.setHorizontalAlignment(SwingConstants.CENTER);
		pnlThongTinXe.add(lblThongTinXe);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_2);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_1);

		lblTimKiem = new JLabel("TÃ¬m kiáº¿m: ");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblTimKiem);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea);

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] { "TÃªn xe", "MÃ£ xe" }));
		cboTimKiem.setMaximumSize(new Dimension(250, 40));
		cboTimKiem.setPreferredSize(new Dimension(100, 50));
		horizontalBox_2.add(cboTimKiem);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_3);

		txtTimKiem = new JTextField();
		txtTimKiem.setPreferredSize(new Dimension(250, 40));
		txtTimKiem.setMaximumSize(new Dimension(400, 40));
		horizontalBox_2.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_4);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_7);

		Box horizontalBox_2_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_2);

		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_1_2);

		JLabel lblHng = new JLabel("HÃ£ng:");
		lblHng.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2.add(lblHng);

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_1_1);

		JComboBox<String> cboHang = new JComboBox<String>();
		cboHang.setBackground(Color.WHITE);
		cboHang.setModel(new DefaultComboBoxModel(new String[] { "Táº¥t cáº£", "Honda", "Yamaha", "SYM", "Suzuki",
				"Piaggio", "Ducati", "Kawasaki", "Harley Davidson" }));
		cboHang.setPreferredSize(new Dimension(100, 50));
		cboHang.setMaximumSize(new Dimension(250, 40));
		cboHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2.add(cboHang);

		Component rigidArea_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_1_3);

		JLabel lblLoiXe = new JLabel("Loáº¡i xe:");
		lblLoiXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2.add(lblLoiXe);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_3_1);

		JComboBox<String> cboLoaiXe = new JComboBox<String>();
		cboLoaiXe.setModel(
				new DefaultComboBoxModel(new String[] { "Táº¥t cáº£", "Xe sá»‘", "Xe tay ga", "Xe cÃ´n tay", "Xe mÃ´ tÃ´" }));
		cboLoaiXe.setPreferredSize(new Dimension(100, 50));
		cboLoaiXe.setMaximumSize(new Dimension(250, 40));
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2.add(cboLoaiXe);

		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_4_1);

		Component rigidArea_7_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_7_2);

		Box horizontalBox_2_2_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_2_1);

		Component rigidArea_1_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_1_4);

		JLabel lblDngXe = new JLabel("DÃ²ng xe:");
		lblDngXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2_1.add(lblDngXe);

		Component rigidArea_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_1_1.setPreferredSize(new Dimension(5, 20));
		horizontalBox_2_2_1.add(rigidArea_1_1_1);

		JComboBox<String> cboDongXe = new JComboBox<String>();
		cboDongXe.setModel(new DefaultComboBoxModel(
				new String[] { "Táº¥t cáº£", "Wave", "Winner", "Air Blade", "SH", "Vision", "Lead", "Cub" }));
		cboDongXe.setPreferredSize(new Dimension(50, 50));
		cboDongXe.setMaximumSize(new Dimension(250, 40));
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2_1.add(cboDongXe);

		Component rigidArea_1_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_1_5);

		JLabel cboXuatSu = new JLabel("Xuáº¥t xá»©:");
		cboXuatSu.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2_1.add(cboXuatSu);

		Component rigidArea_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_3_1_1);

		JComboBox<String> cboXuatXu = new JComboBox<String>();
		cboXuatXu.setModel(new DefaultComboBoxModel(
				new String[] { "Táº¥t cáº£", "Viá»‡t Nam", "Nháº­t Báº£n", "HÃ n Quá»‘c", "Trung Quá»‘c", "Má»¹", "Ä�á»©c", "ThÃ¡i Lan" }));
		cboXuatXu.setPreferredSize(new Dimension(100, 50));
		cboXuatXu.setMaximumSize(new Dimension(250, 40));
		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2_1.add(cboXuatXu);

		Component rigidArea_4_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_4_1_1);

		Component rigidArea_7_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_7_1);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setPreferredSize(new Dimension(610, 300));
		horizontalBox_3.add(scrollPane);

		String[] colHeaderXeMay = { "STT", "MÃ£ xe", "TÃªn xe", "hÃ£ng", "MÃ u sáº¯c", "Sá»‘ lÆ°á»£ng", "GiÃ¡ BÃ¡n", "Báº£o hÃ nh" };
		modelXe = new DefaultTableModel(colHeaderXeMay, 0);
		tblXe = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // KhÃ´ng cho chá»‰nh sá»­a giÃ¡ trá»‹ trong table
				return false;
			}
		};
		tblXe.setBackground(Color.WHITE);
		tblXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXe.setRowHeight(50);
		tblXe.getColumnModel().getColumn(0).setPreferredWidth(69);
		tblXe.getColumnModel().getColumn(1).setPreferredWidth(102);
		tblXe.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblXe.getColumnModel().getColumn(4).setPreferredWidth(63);
		tblXe.getColumnModel().getColumn(5).setPreferredWidth(73);
		tblXe.getColumnModel().getColumn(6).setPreferredWidth(66);
		scrollPane.setViewportView(tblXe);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_5);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_9);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_10);

		btnDau = new JButton("");
		btnDau.setBackground(Color.LIGHT_GRAY);
		btnDau.setMinimumSize(new Dimension(20, 20));
		btnDau.setMaximumSize(new Dimension(40, 40));
		btnDau.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnDau);

		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_11);

		btnTruoc = new JButton("");
		btnTruoc.setBackground(Color.LIGHT_GRAY);
		btnTruoc.setMinimumSize(new Dimension(20, 20));
		btnTruoc.setPreferredSize(new Dimension(50, 50));
		btnTruoc.setMaximumSize(new Dimension(40, 40));
		horizontalBox_4.add(btnTruoc);

		Component rigidArea_12_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_1);

		txtTrang = new JTextField();
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setPreferredSize(new Dimension(50, 40));
		txtTrang.setMaximumSize(new Dimension(50, 40));
		horizontalBox_4.add(txtTrang);
		txtTrang.setColumns(3);

		Component rigidArea_11_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_11_1);

		btnSau = new JButton("");
		btnSau.setBackground(Color.LIGHT_GRAY);
		btnSau.setMinimumSize(new Dimension(20, 20));
		btnSau.setPreferredSize(new Dimension(50, 50));
		btnSau.setMaximumSize(new Dimension(40, 40));
		horizontalBox_4.add(btnSau);

		Component rigidArea_11_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_11_2);

		btnCuoi = new JButton("");
		btnCuoi.setBackground(Color.LIGHT_GRAY);
		btnCuoi.setMinimumSize(new Dimension(20, 20));
		btnCuoi.setPreferredSize(new Dimension(50, 50));
		btnCuoi.setMaximumSize(new Dimension(40, 40));
		horizontalBox_4.add(btnCuoi);

		Component rigidArea_11_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_11_3);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue);

		btnXemChiTiet = new JButton("Chi tiáº¿t");
		horizontalBox_4.add(btnXemChiTiet);
		btnXemChiTiet.setPreferredSize(new Dimension(150, 50));
		btnXemChiTiet.setMaximumSize(new Dimension(200, 50));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBackground(Color.LIGHT_GRAY);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_8);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);

		Component rigidArea_13 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_13);

		btnThemKH = new JButton("ThÃªm KH");
		horizontalBox_5.add(btnThemKH);
		btnThemKH.setPreferredSize(new Dimension(150, 40));
		btnThemKH.setMaximumSize(new Dimension(200, 50));
		btnThemKH.setForeground(Color.WHITE);
		btnThemKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThemKH.setBackground(Color.LIGHT_GRAY);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_1);

		lblSoLuong = new JLabel("Sá»‘ lÆ°á»£ng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblSoLuong);

		Component rigidArea_13_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_13_1);

		txtSoLuong = new JTextField();
		txtSoLuong.setText("1");
		txtSoLuong.setPreferredSize(new Dimension(40, 40));
		txtSoLuong.setMaximumSize(new Dimension(40, 40));
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(3);
		horizontalBox_5.add(txtSoLuong);

		Component rigidArea_12_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_12_2);

		btnThem = new JButton("ThÃªm");
		horizontalBox_5.add(btnThem);
		btnThem.setIcon(new ImageIcon(GD_TrangChu.class.getResource("/img/baseline_add_shopping_cart_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setPreferredSize(new Dimension(150, 50));
		btnThem.setMaximumSize(new Dimension(200, 50));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));

		Component rigidArea_15_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_15_1);

		Box horizontalBox_5_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5_3);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);

		Component rigidArea_8_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_8_1);

		pnlChiTietHoaDon = new JPanel();
		pnlChiTietHoaDon.setBackground(Color.WHITE);
		pnlChiTietHoaDon.setPreferredSize(new Dimension(650, 900));
		horizontalBox.add(pnlChiTietHoaDon);
		pnlChiTietHoaDon.setLayout(new BoxLayout(pnlChiTietHoaDon, BoxLayout.X_AXIS));

		Box verticalBox_1 = Box.createVerticalBox();
		pnlChiTietHoaDon.add(verticalBox_1);

		Box horizontalBox_2_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2_1);

		pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setPreferredSize(new Dimension(650, 55));
		pnlThongTinHoaDon.setMaximumSize(new Dimension(32767, 53));
		pnlThongTinHoaDon.setBackground(new Color(0, 128, 0));
		horizontalBox_2_1.add(pnlThongTinHoaDon);
		pnlThongTinHoaDon.setLayout(new BoxLayout(pnlThongTinHoaDon, BoxLayout.X_AXIS));

		lblThongTinHoaDon = new JLabel("ThÃ´ng tin hÃ³a Ä‘Æ¡n");
		lblThongTinHoaDon.setPreferredSize(new Dimension(650, 55));
		lblThongTinHoaDon.setMaximumSize(new Dimension(2000, 55));
		lblThongTinHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinHoaDon.setForeground(Color.WHITE);
		lblThongTinHoaDon.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlThongTinHoaDon.add(lblThongTinHoaDon);

		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_17);

		Box horizontalBox_3_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1);

		JLabel lblMaHoaDon_1 = new JLabel("MÃ£ hÃ³a Ä‘Æ¡n:");
		lblMaHoaDon_1.setPreferredSize(new Dimension(150, 40));
		lblMaHoaDon_1.setMaximumSize(new Dimension(300, 40));
		lblMaHoaDon_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblMaHoaDon_1);

		Component rigidArea_19 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_19);

		lblMaHoaDon = new JLabel("HD123456");
		lblMaHoaDon.setMaximumSize(new Dimension(300, 40));
		lblMaHoaDon.setPreferredSize(new Dimension(150, 40));
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_3_1.add(lblMaHoaDon);

		Component rigidArea_20 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_20);

		JLabel lblNgayLap_1 = new JLabel("NgÃ y láº­p HD:");
		lblNgayLap_1.setPreferredSize(new Dimension(150, 40));
		lblNgayLap_1.setMaximumSize(new Dimension(150, 40));
		lblNgayLap_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblNgayLap_1);

		Component rigidArea_19_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_19_1);

		lblNgayLap = new JLabel("20-20-2020");
		lblNgayLap.setMaximumSize(new Dimension(150, 40));
		lblNgayLap.setPreferredSize(new Dimension(150, 40));
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_3_1.add(lblNgayLap);

		Component rigidArea_20_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_20_1);

		Component rigidArea_18 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_18);

		Box horizontalBox_4_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_4_1);

		JLabel lblSoCMT = new JLabel("Sá»‘ CMT:");
		lblSoCMT.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4_1.add(lblSoCMT);

		Component rigidArea_19_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4_1.add(rigidArea_19_2);

		txtSoCMT = new JTextField();
		txtSoCMT.setPreferredSize(new Dimension(250, 40));
		txtSoCMT.setMaximumSize(new Dimension(400, 40));
		txtSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMT.setColumns(13);
		horizontalBox_4_1.add(txtSoCMT);

		Component rigidArea_20_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4_1.add(rigidArea_20_2);

		JLabel lblHTnKh_1 = new JLabel("TÃªn KH:");
		lblHTnKh_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4_1.add(lblHTnKh_1);

		Component rigidArea_19_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4_1.add(rigidArea_19_1_1);

		lblHTenKH = new JLabel("Nguyá»…n Tráº§n Nháº­t HÃ o");
		lblHTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_4_1.add(lblHTenKH);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_4_1.add(horizontalGlue_3);

		Component rigidArea_20_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4_1.add(rigidArea_20_1_1);

		Component rigidArea_17_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_17_1);

		Box horizontalBox_3_1_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1_1);

		JLabel lblSinThoi = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i:");
		lblSinThoi.setMaximumSize(new Dimension(300, 40));
		lblSinThoi.setPreferredSize(new Dimension(150, 40));
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1_1.add(lblSinThoi);

		Component rigidArea_19_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_1.add(rigidArea_19_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setPreferredSize(new Dimension(250, 40));
		txtSoDienThoai.setMaximumSize(new Dimension(400, 40));
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		horizontalBox_3_1_1.add(txtSoDienThoai);

		Component rigidArea_20_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_1.add(rigidArea_20_3);

		JLabel lblNgySinh = new JLabel("NgÃ y sinh:");
		lblNgySinh.setPreferredSize(new Dimension(150, 40));
		lblNgySinh.setMaximumSize(new Dimension(85, 40));
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1_1.add(lblNgySinh);

		Component rigidArea_19_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_1.add(rigidArea_19_1_2);

		lblNgaySinh = new JLabel("20-20-2020");
		lblNgaySinh.setMaximumSize(new Dimension(85, 40));
		lblNgaySinh.setPreferredSize(new Dimension(150, 40));
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_3_1_1.add(lblNgaySinh);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3_1_1.add(horizontalGlue_4);

		Component rigidArea_20_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_1.add(rigidArea_20_1_2);

		Component rigidArea_17_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_17_2);

		Box horizontalBox_3_1_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1_2);

		JLabel lblDiaChi_1 = new JLabel("Ä�á»‹a chá»‰:");
		lblDiaChi_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1_2.add(lblDiaChi_1);

		Component rigidArea_21_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_2.add(rigidArea_21_1);

		lblDiaChi = new JLabel("..................................................");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_3_1_2.add(lblDiaChi);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_3_1_2.add(horizontalGlue_2);

		Component rigidArea_21 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_2.add(rigidArea_21);

		Component rigidArea_17_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_17_3);

		Box horizontalBox_3_1_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setPreferredSize(new Dimension(630, 195));
		horizontalBox_3_1_3.add(scrollPane_1);

		String[] colHeaderHoaDon = { "STT", "MÃ£ xe", "TÃªn xe", "hÃ£ng", "loáº¡i xe", "MÃ u sáº¯c", "Sá»‘ lÆ°á»£ng", "GiÃ¡ BÃ¡n",
				"Báº£o hÃ nh" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // KhÃ´ng cho chá»‰nh sá»­a giÃ¡ trá»‹ trong table
				return false;
			}
		};
		tblHoaDon.setBackground(Color.WHITE);
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(30);
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(36);
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(67);
		tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(110);
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(90);
		tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(61);
		tblHoaDon.getColumnModel().getColumn(6).setPreferredWidth(85);
		tblHoaDon.getColumnModel().getColumn(7).setPreferredWidth(63);
		scrollPane_1.setViewportView(tblHoaDon);

		Component rigidArea_22 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_3.add(rigidArea_22);

		Component rigidArea_17_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_17_4);

		Box horizontalBox_3_1_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1_4);

		JPanel pnlThanhToan = new JPanel();
		pnlThanhToan.setBorder(
				new TitledBorder(null, "Thanh to\u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThanhToan.setPreferredSize(new Dimension(500, 200));
		horizontalBox_3_1_4.add(pnlThanhToan);
		pnlThanhToan.setLayout(new BoxLayout(pnlThanhToan, BoxLayout.X_AXIS));

		Box verticalBox_3 = Box.createVerticalBox();
		pnlThanhToan.add(verticalBox_3);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_6);

		Component rigidArea_28 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_28);

		JLabel lblTongTien_1 = new JLabel("Tá»•ng tiá»�n:");
		lblTongTien_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_6.add(lblTongTien_1);

		Component rigidArea_25 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_25);

		lblTongTien = new JLabel("64900500");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_6.add(lblTongTien);

		JLabel lblVn = new JLabel("  VNÄ�");
		lblVn.setForeground(Color.RED);
		lblVn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_6.add(lblVn);

		Component horizontalGlue_11 = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue_11);

		Component rigidArea_27 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_27);

		Component rigidArea_30 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_3.add(rigidArea_30);

		Box horizontalBox_6_1 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_6_1);

		Component rigidArea_28_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6_1.add(rigidArea_28_1);

		JLabel lblTongTien_3_1 = new JLabel("(Báº±ng chá»¯:");
		lblTongTien_3_1.setForeground(Color.RED);
		lblTongTien_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_6_1.add(lblTongTien_3_1);

		Component rigidArea_25_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6_1.add(rigidArea_25_3);

		lblTienChu = new JLabel("1.500.000.000");
		lblTienChu.setText(new DocSo().readNum(lblTongTien.getText().trim()));
		lblTienChu.setForeground(Color.RED);
		lblTienChu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_6_1.add(lblTienChu);

		JLabel lblng = new JLabel("Ä‘á»“ng.)");
		lblng.setForeground(Color.RED);
		lblng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_6_1.add(lblng);

		Component horizontalGlue_11_1 = Box.createHorizontalGlue();
		horizontalBox_6_1.add(horizontalGlue_11_1);

		Component rigidArea_27_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6_1.add(rigidArea_27_1);

		Component rigidArea_30_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_3.add(rigidArea_30_1);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_7);

		Component rigidArea_24 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_24);

		JLabel lblTienKhachTra = new JLabel("Tiá»�n khÃ¡ch tráº£:");
		lblTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblTienKhachTra);

		Component rigidArea_25_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_25_1);

		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTienKhachTra.setMaximumSize(new Dimension(2147483647, 40));
		txtTienKhachTra.setPreferredSize(new Dimension(100, 40));
		txtTienKhachTra.setColumns(10);
		horizontalBox_7.add(txtTienKhachTra);

		Component rigidArea_26 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_26);

		Component rigidArea_31 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_3.add(rigidArea_31);

		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_8);

		Component rigidArea_32 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_8.add(rigidArea_32);

		JLabel lblTienThoi = new JLabel("Tiá»�n tráº£ láº¡i:");
		lblTienThoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_8.add(lblTienThoi);

		Component rigidArea_25_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_8.add(rigidArea_25_2);

		lblTienTra = new JLabel("10000000");
		lblTienTra.setForeground(Color.RED);
		lblTienTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_8.add(lblTienTra);

		JLabel lblVn_1 = new JLabel("  VNÄ�");
		lblVn_1.setForeground(Color.RED);
		lblVn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_8.add(lblVn_1);

		Component horizontalGlue_12 = Box.createHorizontalGlue();
		horizontalBox_8.add(horizontalGlue_12);

		Component rigidArea_29 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1_4.add(rigidArea_29);

		Component rigidArea_14 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_14);

		Box horizontalBox_9 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_9);

		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalBox_9.add(horizontalGlue_7);

		btnSua = new JButton("Sá»­a");
		btnSua.setPreferredSize(new Dimension(150, 50));
		btnSua.setMaximumSize(new Dimension(130, 50));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSua.setBackground(new Color(30, 144, 255));
		horizontalBox_9.add(btnSua);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_9.add(horizontalGlue_6);

		btnThanhToan = new JButton("Thanh toÃ¡n");
		btnThanhToan.setPreferredSize(new Dimension(150, 50));
		btnThanhToan.setMaximumSize(new Dimension(130, 50));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToan.setBackground(new Color(0, 128, 0));
		horizontalBox_9.add(btnThanhToan);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_9.add(horizontalGlue_5);

		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_9.add(rigidArea_15);

		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_16);

		Box horizontalBox_10 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_10);

		Component horizontalGlue_10 = Box.createHorizontalGlue();
		horizontalBox_10.add(horizontalGlue_10);

		btnXoa = new JButton("XÃ³a");
		horizontalBox_10.add(btnXoa);
		btnXoa.setPreferredSize(new Dimension(150, 50));
		btnXoa.setMaximumSize(new Dimension(130, 50));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBackground(Color.RED);

		Component horizontalGlue_8 = Box.createHorizontalGlue();
		horizontalBox_10.add(horizontalGlue_8);

		btnTaoMoi = new JButton("Táº¡o má»›i");
		horizontalBox_10.add(btnTaoMoi);
		btnTaoMoi.setPreferredSize(new Dimension(150, 50));
		btnTaoMoi.setMaximumSize(new Dimension(130, 50));
		btnTaoMoi.setForeground(Color.WHITE);
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTaoMoi.setBackground(new Color(30, 144, 255));

		Component horizontalGlue_9 = Box.createHorizontalGlue();
		horizontalBox_10.add(horizontalGlue_9);
>>>>>>> 9427b75ca656a3e297d0e1e59c8ac2ade1012534

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
//		if (o.equals(btnThanhToan)) {
//			new GD_ChiTietHoaDon().setVisible(true);
//		} else if (o.equals(btnXemChiTiet)) {
//			new GD_ChiTietXeMay().setVisible(true);
//		} else if (o.equals(btnThemKH)) {
//			new GD_ThemKhachHang().setVisible(true);
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
=======

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);


>>>>>>> 9427b75ca656a3e297d0e1e59c8ac2ade1012534
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
}
