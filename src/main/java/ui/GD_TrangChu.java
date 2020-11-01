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
}
