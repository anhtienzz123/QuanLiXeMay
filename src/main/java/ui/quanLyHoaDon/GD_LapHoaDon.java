package ui.quanLyHoaDon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.TenEntity;
import dao.DongXeDao;
import dao.HangXeDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.LoaiXeDao;
import dao.NhanVienHanhChinhDao;
import dao.XeMayDao;
import dao.XuatXuDao;
import db.DatabaseConnect;
import entity.ChiTietHoaDon;
import entity.DongXe;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.XeMay;
import other.DinhDangTien;
import other.DocSo;
import other.RandomMa;
import other.XuLyChung;
import other.XuLyThoiGian;
import ui.quanLyXeMay.GD_ChiTietXeMay;

public class GD_LapHoaDon extends JPanel implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelHoaDon;
	private DefaultTableModel modelXe;
	private JTable tblHoaDon;
	private JTable tblXeMay;
	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JTextField txtTienKhachTra;
	private JTextField txtSoLuong;
	// private JLabel lblBangChu;

	private JButton btnThem;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;

	// Hoa don
	private JLabel lblNgayLapHoaDon;
	private JLabel lblMaHoaDon;
	private JLabel lblTienTraLai;
	private JLabel lblTongTien;
	private JLabel lblTienBangChu;
	private JButton btnLapHoaDon;
	private JButton btnTaoMoi;
	private JButton btnXoa;

	// Nhan vien
	private JLabel lblMaNhanVien;
	private JLabel lblTenNhanVien;
	private String maNhanVienHanhChinh;

	// khách hàng
	private JLabel lblMaKhachHang;
	private JLabel lblTenKhachHang;
	private JLabel lblNgaySinh;
	private JLabel lblDiaChi;
	private JTextField txtSoCMT;
	private JTextField txtSoDienThoai;

	private JComboBox<String> cboHangXe;
	private JComboBox<String> cboDongXe;
	private JComboBox<String> cboLoaiXe;
	private JComboBox<String> cboMauXe;
	private JComboBox<String> cboGiaXe;
	private JComboBox<String> cboXuatXu;
	private JComboBox<String> cboTimKiem;

	private int page = 1;
	private int maxPage = 0;
	private static final int SIZE = 11;
	private XeMayDao xeMayDao;
	private KhachHangDao khachHangDao;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;
	private List<XeMay> xeMays;

	private HoaDon hoaDon;
	private JButton btnXemChiTiet;
	private JComboBox<String> cboXe;

	public GD_LapHoaDon(String maNhanVienHanhChinh) {

		try {
			DatabaseConnect.connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Lập hóa đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin hóa đơn:");
		lblNewLabel_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1.setBounds(42, 51, 266, 50);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Thông tin khách hàng:");
		lblNewLabel_1_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1_1.setBounds(911, 51, 266, 50);
		add(lblNewLabel_1_1);

		JLabel lblMHD = new JLabel("Mã hóa đơn:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBackground(new Color(102, 102, 255));
		lblMHD.setBounds(42, 91, 124, 50);
		add(lblMHD);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(58, 181, 74));
		separator.setBounds(42, 91, 837, 12);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(58, 181, 74));
		separator_1.setBounds(911, 91, 849, 12);
		add(separator_1);

		lblMaHoaDon = new JLabel();
		lblMaHoaDon.setForeground(Color.BLACK);
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHoaDon.setBackground(new Color(102, 102, 255));
		lblMaHoaDon.setBounds(266, 91, 124, 50);
		add(lblMaHoaDon);

		JLabel lblNLHD = new JLabel("Ngày lập hóa đơn:");
		lblNLHD.setForeground(Color.BLACK);
		lblNLHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNLHD.setBackground(new Color(102, 102, 255));
		lblNLHD.setBounds(42, 125, 171, 50);
		add(lblNLHD);

		lblNgayLapHoaDon = new JLabel();
		LocalDate localDate = LocalDate.now();
		int ngay = localDate.getDayOfMonth();
		int thang = localDate.getMonthValue();
		int nam = localDate.getYear();

		lblNgayLapHoaDon.setText(ngay + "-" + thang + "-" + nam);
		lblNgayLapHoaDon.setForeground(Color.BLACK);
		lblNgayLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayLapHoaDon.setBackground(new Color(102, 102, 255));
		lblNgayLapHoaDon.setBounds(266, 125, 124, 50);
		add(lblNgayLapHoaDon);

		JLabel lblMNV = new JLabel("Mã nhân viên:");
		lblMNV.setForeground(Color.BLACK);
		lblMNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMNV.setBackground(new Color(102, 102, 255));
		lblMNV.setBounds(42, 163, 159, 50);
		add(lblMNV);

		lblMaNhanVien = new JLabel();
		lblMaNhanVien.setForeground(Color.BLACK);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNhanVien.setBackground(new Color(102, 102, 255));
		lblMaNhanVien.setBounds(266, 163, 124, 50);
		add(lblMaNhanVien);

		JLabel lblTNV = new JLabel("Tên nhân viên:");
		lblTNV.setForeground(Color.BLACK);
		lblTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTNV.setBackground(new Color(102, 102, 255));
		lblTNV.setBounds(42, 198, 159, 50);
		add(lblTNV);

		lblTenNhanVien = new JLabel();
		lblTenNhanVien.setForeground(Color.BLACK);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNhanVien.setBackground(new Color(102, 102, 255));
		lblTenNhanVien.setBounds(266, 198, 578, 50);
		add(lblTenNhanVien);

		// khách hàng
		JLabel lblMKH = new JLabel("Mã khách hàng:");
		lblMKH.setForeground(Color.BLACK);
		lblMKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMKH.setBackground(new Color(102, 102, 255));
		lblMKH.setBounds(911, 91, 159, 50);
		add(lblMKH);

		lblMaKhachHang = new JLabel();
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBackground(new Color(102, 102, 255));
		lblMaKhachHang.setBounds(1099, 91, 124, 50);
		add(lblMaKhachHang);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1_2_2_1.setBounds(911, 125, 171, 50);
		add(lblNewLabel_1_2_2_1);

		lblTenKhachHang = new JLabel();
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBackground(new Color(102, 102, 255));
		lblTenKhachHang.setBounds(1100, 135, 660, 30);
		add(lblTenKhachHang);

		lblNgaySinh = new JLabel();
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBackground(new Color(102, 102, 255));
		lblNgaySinh.setBounds(1504, 163, 171, 50);
		add(lblNgaySinh);

		lblDiaChi = new JLabel();
		lblDiaChi.setVerticalAlignment(SwingConstants.TOP);
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBackground(new Color(102, 102, 255));
		lblDiaChi.setBounds(999, 207, 761, 45);
		add(lblDiaChi);

		JLabel lblDC = new JLabel("Địa chỉ:");
		lblDC.setForeground(Color.BLACK);
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDC.setBackground(new Color(102, 102, 255));
		lblDC.setBounds(911, 198, 88, 50);
		add(lblDC);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBackground(new Color(102, 102, 255));
		lblSDT.setBounds(911, 163, 159, 50);
		add(lblSDT);

		JLabel lblNewLabel_1_2_1_4 = new JLabel("Số CMT:");
		lblNewLabel_1_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1_4.setBackground(new Color(102, 102, 255));
		lblNewLabel_1_2_1_4.setBounds(1378, 91, 159, 50);
		add(lblNewLabel_1_2_1_4);

		txtSoCMT = new JTextField();
		txtSoCMT.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMT.setBounds(1475, 104, 144, 25);
		add(txtSoCMT);
		txtSoCMT.setColumns(10);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtSoDienThoai.setBounds(1099, 177, 115, 25);
		add(txtSoDienThoai);

		JLabel lblNS = new JLabel("Ngày sinh:");
		lblNS.setForeground(Color.BLACK);
		lblNS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNS.setBackground(new Color(102, 102, 255));
		lblNS.setBounds(1378, 163, 159, 50);
		add(lblNS);

		/**
		 * Talbe Hóa đơn
		 */
		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setBackground(Color.WHITE);
		scrollPaneHoaDon.setBounds(911, 277, 849, 316);
		add(scrollPaneHoaDon);
		String[] colHeaderHoaDon = { "STT", "Tên xe", "Số khung", "Giá Bán", "Thuế", "Tổng tiền" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(35);
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(49);//STT
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(300);//Tên xe
		tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(250);//Số khung
		tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(200);//Giá bán
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(200);//Thuế
		tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(200);//Tổng Tiền

		tblHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

//		center value in column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		JTableHeader tableHeader = tblHoaDon.getTableHeader();
		tableHeader.setBackground(new Color(58, 181, 74));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneHoaDon.setViewportView(tblHoaDon);

//		String[] colHeaderHoaDon = { "STT", "Mã xe", "Tên xe", "hãng", "loại xe", "Màu sắc", "Số lượng", "Giá Bán",
//		"Bảo hành" };
		scrollPaneHoaDon.setViewportView(tblHoaDon);

		/**
		 * Table Thông tin xe máy
		 */
		JScrollPane scrollPaneXeMay = new JScrollPane();
		scrollPaneXeMay.setBackground(Color.WHITE);
		scrollPaneXeMay.setBounds(30, 479, 849, 432);
		add(scrollPaneXeMay);

		String[] colHeaderXeMay = { "STT", "Tên xe", "Số khung", "Số sườn", "Giá bán", "Bảo hành", "Màu xe", "Loại xe",
				"Dòng xe", "Hãng xe", "Xuất xứ" };
		modelXe = new DefaultTableModel(colHeaderXeMay, 0);
		tblXeMay = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblXeMay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXeMay.setRowHeight(35);
		tblXeMay.getColumnModel().getColumn(0).setPreferredWidth(60);// stt
		tblXeMay.getColumnModel().getColumn(1).setPreferredWidth(400);// tên xe
		tblXeMay.getColumnModel().getColumn(2).setPreferredWidth(250);// Số khung
		tblXeMay.getColumnModel().getColumn(3).setPreferredWidth(130);// số sườn
		tblXeMay.getColumnModel().getColumn(4).setPreferredWidth(210);// Giá bán
		tblXeMay.getColumnModel().getColumn(5).setPreferredWidth(130);// Bảo hành
		tblXeMay.getColumnModel().getColumn(6).setPreferredWidth(200);// Màu xe
		tblXeMay.getColumnModel().getColumn(7).setPreferredWidth(150);// Loại xe
		tblXeMay.getColumnModel().getColumn(8).setPreferredWidth(150);// Dòng xe
		tblXeMay.getColumnModel().getColumn(9).setPreferredWidth(150);// Hãng xe
		tblXeMay.getColumnModel().getColumn(10).setPreferredWidth(150);// Xuất xứ

//		center value in column
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblXeMay.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//		tblXeMay.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tblXeMay.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tblXeMay.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		tblXeMay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPaneXeMay.setViewportView(tblXeMay);
		JTableHeader tableHeader2 = tblXeMay.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(308, 275, 571, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cboHangXe = new JComboBox<String>();

		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setBounds(132, 326, 150, 30);
		add(cboHangXe);

		cboLoaiXe = new JComboBox<String>();

		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(424, 326, 150, 30);
		add(cboLoaiXe);

		cboDongXe = new JComboBox<String>();

		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(132, 377, 150, 30);
		add(cboDongXe);

		cboXuatXu = new JComboBox<String>();

		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setBackground(Color.WHITE);
		cboXuatXu.setBounds(424, 377, 150, 30);
		add(cboXuatXu);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_fast_rewind_white_24dp.png")));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(30, 942, 51, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(93, 942, 51, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_skip_next_white_24dp.png")));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(230, 942, 51, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(293, 942, 51, 40);
		add(btnCuoi);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setBounds(156, 942, 62, 40);
		add(txtTrang);
		txtTrang.setColumns(10);

		btnXemChiTiet = new JButton("Chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/icon/information_30px.png")));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setBounds(369, 942, 144, 40);
		add(btnXemChiTiet);

		JPanel pnlTongTien = new JPanel();
		pnlTongTien.setBackground(new Color(58, 181, 74));
		pnlTongTien.setBounds(911, 635, 849, 145);
		add(pnlTongTien);
		pnlTongTien.setLayout(null);

		JLabel lblTT = new JLabel("Tổng Tiền");
		lblTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTT.setBounds(0, 0, 849, 38);
		lblTT.setForeground(Color.WHITE);
		lblTT.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTT.setBackground(new Color(102, 102, 255));
		pnlTongTien.add(lblTT);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		separator_3.setBounds(0, 38, 849, 10);
		pnlTongTien.add(separator_3);

		lblTongTien = new JLabel("0 VNĐ");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setForeground(Color.WHITE);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongTien.setBackground(new Color(102, 102, 255));
		lblTongTien.setBounds(0, 38, 849, 46);
		pnlTongTien.add(lblTongTien);

		lblTienBangChu = new JLabel("Bằng chữ: không đồng.");
		lblTienBangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienBangChu.setForeground(Color.WHITE);
		lblTienBangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienBangChu.setBackground(new Color(102, 102, 255));
		lblTienBangChu.setBounds(22, 81, 815, 64);
		pnlTongTien.add(lblTienBangChu);

		JPanel pnlTienKhachTra = new JPanel();
		pnlTienKhachTra.setBackground(new Color(51, 204, 255));
		pnlTienKhachTra.setBounds(911, 816, 380, 94);
		add(pnlTienKhachTra);
		pnlTienKhachTra.setLayout(null);

		JLabel lblTienKhachTra = new JLabel("Tiền khách trả");
		lblTienKhachTra.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienKhachTra.setForeground(Color.WHITE);
		lblTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienKhachTra.setBackground(new Color(102, 102, 255));
		lblTienKhachTra.setBounds(0, 0, 380, 38);
		pnlTienKhachTra.add(lblTienKhachTra);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(Color.WHITE);
		separator_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		separator_3_1.setBounds(0, 38, 380, 10);
		pnlTienKhachTra.add(separator_3_1);

		JLabel lblVND = new JLabel("VNĐ");
		lblVND.setHorizontalAlignment(SwingConstants.CENTER);
		lblVND.setForeground(Color.WHITE);
		lblVND.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVND.setBackground(new Color(102, 102, 255));
		lblVND.setBounds(263, 41, 89, 56);
		pnlTienKhachTra.add(lblVND);

		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setHorizontalAlignment(SwingConstants.CENTER);
		txtTienKhachTra.setForeground(Color.WHITE);
		txtTienKhachTra.setBackground(new Color(51, 204, 255));
		txtTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTienKhachTra.setColumns(10);
		txtTienKhachTra.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtTienKhachTra.setBounds(44, 57, 231, 25);
		pnlTienKhachTra.add(txtTienKhachTra);

		JPanel pnlTienTraLai = new JPanel();
		pnlTienTraLai.setBackground(new Color(51, 204, 255));
		pnlTienTraLai.setBounds(1380, 816, 380, 94);
		add(pnlTienTraLai);
		pnlTienTraLai.setLayout(null);

		JLabel lblTTra = new JLabel("Tiền trả lại");
		lblTTra.setHorizontalAlignment(SwingConstants.CENTER);
		lblTTra.setForeground(Color.WHITE);
		lblTTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTTra.setBackground(new Color(102, 102, 255));
		lblTTra.setBounds(0, 0, 380, 38);
		pnlTienTraLai.add(lblTTra);

		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setForeground(Color.WHITE);
		separator_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		separator_3_2.setBounds(0, 38, 380, 10);
		pnlTienTraLai.add(separator_3_2);

		lblTienTraLai = new JLabel();
		lblTienTraLai.setBounds(0, 38, 380, 56);
		pnlTienTraLai.add(lblTienTraLai);
		lblTienTraLai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienTraLai.setForeground(Color.WHITE);
		lblTienTraLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienTraLai.setBackground(new Color(102, 102, 255));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_add_shopping_cart_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnThem.setBackground(new Color(51, 204, 255));
		btnThem.setBounds(735, 942, 144, 40);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_remove_shopping_cart_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(911, 944, 170, 40);
		add(btnXoa);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(58, 181, 74));
		separator_1_1.setBounds(30, 254, 1730, 12);
		add(separator_1_1);

		JLabel lblXuatXu = new JLabel("Xuất xứ:");
		lblXuatXu.setForeground(Color.BLACK);
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXuatXu.setBackground(new Color(102, 102, 255));
		lblXuatXu.setBounds(338, 377, 88, 30);
		add(lblXuatXu);

		JLabel lblDongXe = new JLabel("Dòng xe:");
		lblDongXe.setForeground(Color.BLACK);
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDongXe.setBackground(new Color(102, 102, 255));
		lblDongXe.setBounds(30, 377, 88, 30);
		add(lblDongXe);

		JLabel lblLoai = new JLabel("Loại xe:");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoai.setBackground(new Color(102, 102, 255));
		lblLoai.setBounds(338, 326, 74, 30);
		add(lblLoai);

		JLabel lblHang = new JLabel("Hãng:");
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBackground(new Color(102, 102, 255));
		lblHang.setBounds(30, 326, 62, 30);
		add(lblHang);

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] { "Tên xe", "Mã xe" }));
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setBounds(132, 276, 149, 29);
		add(cboTimKiem);

		JLabel lblTK = new JLabel("Tìm kiếm:");
		lblTK.setForeground(Color.BLACK);
		lblTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTK.setBackground(new Color(102, 102, 255));
		lblTK.setBounds(30, 275, 107, 30);
		add(lblTK);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_monetization_on_white_18dp.png")));
		btnLapHoaDon.setBounds(1378, 944, 382, 42);
		add(btnLapHoaDon);
		btnLapHoaDon.setForeground(Color.WHITE);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnLapHoaDon.setBackground(new Color(0, 153, 51));

		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/icon/baseline_create_new_folder_white_18dp.png")));
		btnTaoMoi.setForeground(Color.WHITE);
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnTaoMoi.setBackground(new Color(51, 204, 255));
		btnTaoMoi.setBounds(1121, 943, 170, 42);
		add(btnTaoMoi);

		txtSoLuong = new JTextField();
		txtSoLuong.setText("1");
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(651, 942, 62, 40);
		add(txtSoLuong);
		txtSoLuong.setVisible(false);

		cboMauXe = new JComboBox<String>();

		cboMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMauXe.setBackground(Color.WHITE);
		cboMauXe.setBounds(728, 326, 150, 30);
		add(cboMauXe);

		JLabel lblMu = new JLabel("Màu:");
		lblMu.setForeground(Color.BLACK);
		lblMu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMu.setBackground(new Color(102, 102, 255));
		lblMu.setBounds(628, 326, 69, 30);
		add(lblMu);

		JLabel lblGi = new JLabel("Giá:");
		lblGi.setForeground(Color.BLACK);
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGi.setBackground(new Color(102, 102, 255));
		lblGi.setBounds(628, 377, 69, 30);
		add(lblGi);

		cboGiaXe = new JComboBox<String>();
		cboGiaXe.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Tất cả", "Dưới 25tr", "Từ 25tr - 60tr", "Trên 60tr" }));
		cboGiaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboGiaXe.setBackground(Color.WHITE);
		cboGiaXe.setBounds(728, 377, 150, 30);
		add(cboGiaXe);
		this.maNhanVienHanhChinh = maNhanVienHanhChinh;

		cboXe = new JComboBox<String>();
		cboXe.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả" }));
		cboXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXe.setBackground(Color.WHITE);
		cboXe.setBounds(132, 429, 747, 30);
		add(cboXe);

		JLabel lblXe = new JLabel("Xe:");
		lblXe.setForeground(Color.BLACK);
		lblXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXe.setBackground(new Color(102, 102, 255));
		lblXe.setBounds(30, 429, 88, 30);
		add(lblXe);
		khoiTao();
		dangKiSuKien();
		hienThiNhanVien();

		loadDuLieuThongTinTimKiem();
		capNhatXeMaysTrongBang(false);

	}

	public void khoiTao() {
		xeMayDao = XeMayDao.getInstance();
		khachHangDao = KhachHangDao.getInstance();
		nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();

	}

	private void dangKiSuKien() {
		txtSoDienThoai.addMouseListener(this);
		txtSoCMT.addMouseListener(this);

		txtSoDienThoai.addActionListener(this);
		txtSoCMT.addActionListener(this);
		txtTienKhachTra.addActionListener(this);

		btnThem.addActionListener(this);
		cboHangXe.addActionListener(this);
		cboLoaiXe.addActionListener(this);
		cboMauXe.addActionListener(this);
		cboDongXe.addActionListener(this);
		cboXuatXu.addActionListener(this);
		cboGiaXe.addActionListener(this);

		cboTimKiem.addActionListener(this);
		txtTimKiem.addKeyListener(this);

		btnTruoc.addActionListener(this);
		btnSau.addActionListener(this);
		btnDau.addActionListener(this);
		btnCuoi.addActionListener(this);

		btnTaoMoi.addActionListener(this);
		btnLapHoaDon.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemChiTiet.addActionListener(this);

		cboXe.addActionListener(this);

	}

	private boolean flagCBO;
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source == txtSoDienThoai) {
			String soDienThoai = txtSoDienThoai.getText();
			KhachHang khachHang = khachHangDao.getKhachHangTheoSoDienThoai(soDienThoai);

			if (khachHang != null) {
				capNhatKhachHang(khachHang);
			} else {
				capNhatKhachHang(khachHang);
				JOptionPane.showMessageDialog(null, "Số điện thoại không tồn tại", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE, null);
			}
		}

		if (source == txtSoCMT) {
			String soCMT = txtSoCMT.getText();
			KhachHang khachHang = khachHangDao.getKhachHangTheoSoCMT(soCMT);

			if (khachHang != null) {
				capNhatKhachHang(khachHang);
			} else {
				capNhatKhachHang(khachHang);
				JOptionPane.showMessageDialog(null, "Số CMT không tồn tại", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE, null);
			}
		}

		if (source == btnThem) {

			if (!lblMaKhachHang.getText().trim().equals("")) {
				if (hoaDon == null) {
					hoaDon = new HoaDon(lblMaHoaDon.getText(), new KhachHang(lblMaKhachHang.getText()),
							new NhanVienHanhChinh(lblMaNhanVien.getText()),
							XuLyThoiGian.chuyenStringThanhDate(lblNgayLapHoaDon.getText()));

				}

				int index = tblXeMay.getSelectedRow();
				XeMay xeMay = xeMays.get(index);
				int soLuong = Integer.valueOf(txtSoLuong.getText());

				if (xeMay.getSoLuong() >= soLuong) {
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(new HoaDon(lblMaHoaDon.getText()), xeMay,
							xeMay.tinhGiaBan() + xeMay.getThue(), soLuong);
					xeMay.setSoLuong(xeMay.getSoLuong() - soLuong);
					xeMayDao.capNhatXeMay(xeMay);

					this.hoaDon.themChiTietHoaDon(chiTietHoaDon);

					capNhatXeMaysTrongBang(false);
					capNhatHoaDon();
				} else {
					JOptionPane.showMessageDialog(null, "Xe máy này không đủ số lượng");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin khách hàng", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE, null);
			}
		}

		
		if (source == cboHangXe || source == cboLoaiXe || source == cboMauXe || source == cboDongXe
				|| source == cboXuatXu || source == cboGiaXe) {

			if (source == cboHangXe) {

				DongXeDao dongXeDao = DongXeDao.getInstance();
				if (cboHangXe.getSelectedItem().toString().equalsIgnoreCase("Tất cả")) {
					cboDongXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
							dongXeDao.getDongXes().stream().map(s -> s.getTenDongXe()).collect(Collectors.toList()))));
				} else {
					String tenHangXe = cboHangXe.getSelectedItem().toString();
					String tenDongXe = cboDongXe.getSelectedItem().toString();

					List<String> tenDongXes = dongXeDao.getDongXesTheoTenHangXe(tenHangXe).stream()
							.map(s -> s.getTenDongXe()).collect(Collectors.toList());

					cboDongXe.setModel(new DefaultComboBoxModel<String>(
							XuLyChung.doiListThanhArray(dongXeDao.getDongXesTheoTenHangXe(tenHangXe).stream()
									.map(s -> s.getTenDongXe()).collect(Collectors.toList()))));

					if (tenDongXes.contains(tenDongXe)) {
						cboDongXe.setSelectedItem(tenDongXe);
					}

				}

			}

			if (source == cboDongXe) {
				DongXeDao dongXeDao = DongXeDao.getInstance();

				if (cboDongXe.getSelectedItem().toString().equalsIgnoreCase("Tất cả")) {

				} else {
					String tenDongXe = cboDongXe.getSelectedItem().toString();
					DongXe dongXe = dongXeDao.getDongXeTheoTen(tenDongXe);
					cboHangXe.setSelectedItem(dongXe.getHangXe().getTenHangXe());
				}

			}

			this.page = 1;

			flagCBO = true;
			capNhatXeMaysTrongBang(false);

		}

		if (source == cboTimKiem) {
			this.page = 1;
			txtTimKiem.setText("");
			capNhatXeMaysTrongBang(false);
		}

		if (source == btnTruoc && this.page > 1) {

			this.page--;
			capNhatXeMaysTrongBang(true);
		}

		if (source == btnSau && this.page < maxPage) {
			this.page++;
			capNhatXeMaysTrongBang(true);
		}

		if (source == btnDau) {
			this.page = 1;
			capNhatXeMaysTrongBang(true);
		}

		if (source == btnCuoi) {
			this.page = maxPage;
			capNhatXeMaysTrongBang(true);
		}

		if (source == txtTienKhachTra) {

			try {
				double tienTra = Double.valueOf(txtTienKhachTra.getText());

				double tongTienHoaDon = hoaDon.tinhTongTienHoaDon();

				if (tienTra < tongTienHoaDon) {
					JOptionPane.showMessageDialog(null, "Tiền trả không đủ");
					txtTienKhachTra.selectAll();
					txtTienKhachTra.requestFocus();

				} else {
					double tienTraLai = tienTra - tongTienHoaDon;
					lblTienTraLai.setText(DinhDangTien.format(tienTraLai));
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Tiền trả không hợp lệ");
				txtTienKhachTra.selectAll();
				txtTienKhachTra.requestFocus();

			}
		}

		if (source == btnLapHoaDon) {

			if (lblTienTraLai.getText().length() > 0) {
				HoaDonDao hoaDonDao = HoaDonDao.getInstance();
				System.out.println(hoaDon);
				if (hoaDonDao.themHoaDon(this.hoaDon)) {

					new GD_ChiTietHoaDon(hoaDon.getMaHoaDon()).setVisible(true);
					hoaDon = null;
					capNhatHoaDon();
					capNhatKhachHang(null);
					lblMaHoaDon.setText(RandomMa.getMaNgauNhien(TenEntity.HOA_DON));

				} else {
					System.out.println("Them that bai");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập tiền khách trả");
				txtTienKhachTra.requestFocus();
				txtTienKhachTra.selectAll();

			}

		}

		if (source == btnTaoMoi) {

			if (hoaDon != null) {
				for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {

					XeMay xeMay = chiTietHoaDon.getXeMay();
					xeMay.setSoLuong(xeMay.getSoLuong() + chiTietHoaDon.getSoLuong());
					xeMayDao.capNhatXeMay(xeMay);
				}
				this.hoaDon = null;
				capNhatHoaDon();
				capNhatKhachHang(null);
				capNhatXeMaysTrongBang(false);
				xoaThongTinsTimKiem();
			}

		}

		if (source == btnXoa) {
			int row = tblHoaDon.getSelectedRow();
			ChiTietHoaDon chiTietHoaDon = hoaDon.getChiTietHoaDons().get(row);
			XeMay xeMay = chiTietHoaDon.getXeMay();
			xeMay.setSoLuong(xeMay.getSoLuong() + chiTietHoaDon.getSoLuong());
			xeMayDao.capNhatXeMay(xeMay);

			hoaDon.getChiTietHoaDons().remove(row);
			capNhatHoaDon();
			capNhatXeMaysTrongBang(false);

		}

		if (source == btnXemChiTiet) {
			int row = tblXeMay.getSelectedRow();
			if (row != -1) {
				String ma = xeMays.get(row).getMaXeMay();
				// XeMay xeMay = xeMayDao.getXeMayTheoMa(ma);
				new GD_ChiTietXeMay(ma).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn xe máy để xem chi tiết");
			}
		}

		if (source == cboXe) {

			int from = (SIZE * (page - 1) + 1);
			int to = page * SIZE;

			String timKiem = txtTimKiem.getText();
			String field = cboTimKiem.getSelectedItem().toString();
			String gia = cboGiaXe.getSelectedItem().toString();
			String mauXe = cboMauXe.getSelectedItem().toString();
			String tenXuatXu = cboXuatXu.getSelectedItem().toString();
			String tenLoaiXe = cboLoaiXe.getSelectedItem().toString();
			String tenDongXe = cboDongXe.getSelectedItem().toString();
			String tenHangXe = cboHangXe.getSelectedItem().toString();
			String cboTenXe = cboXe.getSelectedItem().toString().split("-")[0].trim();
			this.maxPage = xeMayDao.getMaxPageTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe,
					tenDongXe, tenHangXe, cboTenXe, SIZE);
			xeMays = xeMayDao.getXeMaysTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
					tenHangXe, cboTenXe, from, to);

			xoaDuLieuXeMayTrongBang();
			themXeMaysVaoBang();

			txtTrang.setText(this.page + "");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.page = 1;
		capNhatXeMaysTrongBang(false);

	}

	private void capNhatHoaDon() {

		xoaDuLieuChiTietHoaDonsTrongBang();
		if (hoaDon != null) {
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
				Object[] datas = new Object[6];
				datas[0] = tblHoaDon.getRowCount() + 1;
				datas[1] = chiTietHoaDon.getXeMay().getTenXeMay();
				datas[2] = chiTietHoaDon.getXeMay().getSoKhung();
				datas[3] = DinhDangTien.format(chiTietHoaDon.getXeMay().tinhGiaBan());
				datas[4] = DinhDangTien.format(chiTietHoaDon.getXeMay().getThue());
				datas[5] = DinhDangTien.format(chiTietHoaDon.getGiaBan());

				modelHoaDon.addRow(datas);
			}

			lblTongTien.setText(DinhDangTien.format(hoaDon.tinhTongTienHoaDon()));

			DecimalFormat df = new DecimalFormat("###.##");
			System.out.println(DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon())));
			lblTienBangChu.setText(
					"<html>Bằng chữ: " + DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon())) + " đồng</html>");
		} else {
			lblTongTien.setText("0 VNĐ");
			lblTienBangChu.setText("Không đồng");
			txtTienKhachTra.setText("");
			lblTienTraLai.setText("");
		}

	}

	private void capNhatXeMaysTrongBang(boolean temp) {

		int from = (SIZE * (page - 1) + 1);
		int to = page * SIZE;

		String timKiem = txtTimKiem.getText();
		String field = cboTimKiem.getSelectedItem().toString();
		String gia = cboGiaXe.getSelectedItem().toString();
		String mauXe = cboMauXe.getSelectedItem().toString();
		String tenXuatXu = cboXuatXu.getSelectedItem().toString();
		String tenLoaiXe = cboLoaiXe.getSelectedItem().toString();
		String tenDongXe = cboDongXe.getSelectedItem().toString();
		String tenHangXe = cboHangXe.getSelectedItem().toString();
		String cboTenXe = flagCBO ? "Tất cả" : cboXe.getSelectedItem().toString().split("-")[0].trim();
		this.maxPage = xeMayDao.getMaxPageTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
				tenHangXe, cboTenXe, SIZE);
		xeMays = xeMayDao.getXeMaysTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
				tenHangXe, cboTenXe, from, to);
		Map<String, Integer> tenXes = xeMayDao.getTenXeMaysTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu,
				tenLoaiXe, tenDongXe, tenHangXe);

		xoaDuLieuXeMayTrongBang();
		themXeMaysVaoBang();

		if(!temp) {
			capNhatTenXeTimDuoc(tenXes);
		}

		txtTrang.setText(this.page + "");
		flagCBO = false;

	}

	private void capNhatTenXeTimDuoc(Map<String, Integer> tenXes) {

		List<String> datasList = new ArrayList<String>();

		tenXes.forEach((key, value) -> datasList.add(key + " - số lượng " + value));

		DefaultComboBoxModel<String> datas = new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(datasList));
		cboXe.setModel(datas);

	}

	private void themXeMaysVaoBang() {

		if (xeMays != null) {

			for (XeMay xeMay : xeMays) {
				themXeMayVaoBang(xeMay);
			}
		}

	}

	private void themXeMayVaoBang(XeMay xeMay) {

		Object[] datas = new Object[11];
		datas[0] = tblXeMay.getRowCount() + 1;
		datas[1] = xeMay.getTenXeMay();
		datas[2] = xeMay.getSoKhung();
		datas[3] = xeMay.getSoSuon();
		datas[4] = DinhDangTien.format(xeMay.tinhGiaBan());
		datas[5] = xeMay.getThoiGianBaoHanh() + " tháng";
		datas[6] = xeMay.getMauXe();
		datas[7] = xeMay.getLoaiXe().getTenLoaiXe();
		datas[8] = xeMay.getDongXe().getTenDongXe();
		datas[9] = xeMay.getDongXe().getHangXe().getTenHangXe();
		datas[10] = xeMay.getXuatXu().getTenXuatXu();

		modelXe.addRow(datas);
	}

	private void capNhatKhachHang(KhachHang khachHang) {

		if (khachHang != null) {
			lblMaKhachHang.setText(khachHang.getMaKhachHang());
			lblTenKhachHang.setText(khachHang.getHoTenKH());
			txtSoCMT.setText(khachHang.getSoCMT());
			txtSoCMT.setEditable(false);
			txtSoDienThoai.setEditable(false);
			txtSoDienThoai.setText(khachHang.getSoDienThoai());
			lblNgaySinh.setText(XuLyThoiGian.chuyenDateThanhString(khachHang.getNgaySinh()));
			lblDiaChi.setText("<html>" + khachHang.getDiaChiKH() + "</html>");
		} else {
			lblMaKhachHang.setText("");
			lblTenKhachHang.setText("");
			txtSoCMT.setText("");
			txtSoCMT.setEditable(true);
			txtSoDienThoai.setText("");
			txtSoDienThoai.setEditable(true);
			lblNgaySinh.setText("");
			lblDiaChi.setText("");
		}
	}

	private void xoaThongTinsTimKiem() {
		cboTimKiem.setSelectedItem("Tên xe");
		txtTimKiem.setText("");
		cboHangXe.setSelectedItem("Tất cả");
		cboLoaiXe.setSelectedItem("Tất cả");
		cboMauXe.setSelectedItem("Tất cả");
		cboDongXe.setSelectedItem("Tất cả");
		cboXuatXu.setSelectedItem("Tất cả");
		cboGiaXe.setSelectedItem("Tất cả");
		

	}

	private void hienThiNhanVien() {
		NhanVienHanhChinh nhanVienHanhChinh = nhanVienHanhChinhDao.getNVHanhChinhTheoMa(this.maNhanVienHanhChinh);
		lblMaNhanVien.setText(nhanVienHanhChinh.getMaNVHanhChinh());
		lblTenNhanVien.setText(nhanVienHanhChinh.getHoTenNV());

		String maHoaDon = RandomMa.getMaNgauNhien(TenEntity.HOA_DON);
		lblMaHoaDon.setText(maHoaDon);
	}

	private void loadDuLieuThongTinTimKiem() {
		XuatXuDao xuatXuDao = XuatXuDao.getInstance();
		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		HangXeDao hangXeDao = HangXeDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();

		cboXuatXu.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				xuatXuDao.getXuatXus().stream().map(s -> s.getTenXuatXu()).collect(Collectors.toList()))));
		cboLoaiXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				loaiXeDao.getLoaiXes().stream().map(s -> s.getTenLoaiXe()).collect(Collectors.toList()))));
		cboHangXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				hangXeDao.getHangXes().stream().map(s -> s.getTenHangXe()).collect(Collectors.toList()))));
		cboDongXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				dongXeDao.getDongXes().stream().map(s -> s.getTenDongXe()).collect(Collectors.toList()))));

		cboMauXe.addItem("Tất cả");
		for (String mauXe : xeMayDao.getMauXes()) {
			System.out.println(mauXe);
			cboMauXe.addItem(mauXe);
		}

	}

	private void xoaDuLieuChiTietHoaDonsTrongBang() {
		while (modelHoaDon.getRowCount() > 0) {
			modelHoaDon.removeRow(0);
		}

	}

	private void xoaDuLieuXeMayTrongBang() {
		while (modelXe.getRowCount() > 0) {
			modelXe.removeRow(0);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			txtSoDienThoai.setEditable(true);
			txtSoCMT.setEditable(true);
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
}
