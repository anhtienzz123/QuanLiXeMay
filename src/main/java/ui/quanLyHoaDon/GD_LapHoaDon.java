package ui.quanLyHoaDon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.EventObject;
import java.util.List;
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
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.XeMay;
import other.DinhDangTien;
import other.DocSo;
import other.RandomMa;
import other.XuLyChung;
import other.XuLyThoiGian;

public class GD_LapHoaDon extends JPanel implements ActionListener, KeyListener {
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
	private JLabel lblBangChu;

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
	private JButton btnSua;
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
	private static final int SIZE = 15;
	private XeMayDao xeMayDao;
	private KhachHangDao khachHangDao;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;
	private List<XeMay> xeMays;

	private HoaDon hoaDon;

	public GD_LapHoaDon(String maNhanVienHanhChinh) {
		this.maNhanVienHanhChinh = "NVHC222222";

		try {
			DatabaseConnect.connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Lập hóa đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 1450, 50);
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
		lblNewLabel_1_1.setBounds(602, 51, 266, 50);
		add(lblNewLabel_1_1);

		JLabel lblMHD = new JLabel("Mã hóa đơn:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBackground(new Color(102, 102, 255));
		lblMHD.setBounds(42, 91, 124, 50);
		add(lblMHD);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(58, 181, 74));
		separator.setBounds(42, 91, 501, 30);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(58, 181, 74));
		separator_1.setBounds(602, 91, 790, 30);
		add(separator_1);

		lblMaHoaDon = new JLabel();
		lblMaHoaDon.setForeground(Color.BLACK);
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHoaDon.setBackground(new Color(102, 102, 255));
		lblMaHoaDon.setBounds(242, 91, 124, 50);
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
		lblNgayLapHoaDon.setBounds(242, 125, 124, 50);
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
		lblMaNhanVien.setBounds(242, 163, 124, 50);
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
		lblTenNhanVien.setBounds(242, 198, 264, 50);
		add(lblTenNhanVien);

		// khách hàng
		JLabel lblMKH = new JLabel("Mã khách hàng:");
		lblMKH.setForeground(Color.BLACK);
		lblMKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMKH.setBackground(new Color(102, 102, 255));
		lblMKH.setBounds(602, 91, 159, 50);
		add(lblMKH);

		lblMaKhachHang = new JLabel();
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBackground(new Color(102, 102, 255));
		lblMaKhachHang.setBounds(790, 91, 124, 50);
		add(lblMaKhachHang);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1_2_2_1.setBounds(602, 125, 171, 50);
		add(lblNewLabel_1_2_2_1);

		lblTenKhachHang = new JLabel();
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBackground(new Color(102, 102, 255));
		lblTenKhachHang.setBounds(790, 135, 438, 30);
		add(lblTenKhachHang);

		lblNgaySinh = new JLabel();
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBackground(new Color(102, 102, 255));
		lblNgaySinh.setBounds(1195, 163, 115, 50);
		add(lblNgaySinh);

		lblDiaChi = new JLabel();
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBackground(new Color(102, 102, 255));
		lblDiaChi.setBounds(690, 198, 550, 50);
		add(lblDiaChi);

		JLabel lblDC = new JLabel("Địa chỉ:");
		lblDC.setForeground(Color.BLACK);
		lblDC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDC.setBackground(new Color(102, 102, 255));
		lblDC.setBounds(602, 198, 159, 50);
		add(lblDC);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBackground(new Color(102, 102, 255));
		lblSDT.setBounds(602, 163, 159, 50);
		add(lblSDT);

		JLabel lblNewLabel_1_2_1_4 = new JLabel("Số CMT:");
		lblNewLabel_1_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1_4.setBackground(new Color(102, 102, 255));
		lblNewLabel_1_2_1_4.setBounds(1069, 91, 159, 50);
		add(lblNewLabel_1_2_1_4);

		txtSoCMT = new JTextField();
		txtSoCMT.setBorder(null);
		txtSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMT.setBounds(1166, 104, 144, 25);
		add(txtSoCMT);
		txtSoCMT.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(1166, 129, 137, 12);
		add(separator_2);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBorder(null);
		txtSoDienThoai.setBounds(789, 176, 115, 25);
		add(txtSoDienThoai);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBounds(789, 201, 115, 12);
		add(separator_2_1);

		JLabel lblNS = new JLabel("Ngày sinh:");
		lblNS.setForeground(Color.BLACK);
		lblNS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNS.setBackground(new Color(102, 102, 255));
		lblNS.setBounds(1069, 163, 159, 50);
		add(lblNS);

		/**
		 * Talbe Hóa đơn
		 */
		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setBounds(731, 277, 661, 316);
		add(scrollPaneHoaDon);
		String[] colHeaderHoaDon = { "STT", "Tên xe", "Số lượng", "Giá Bán", "Tổng tiền" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(25);
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(300);
		tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(500);
		tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(300);
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
		scrollPaneXeMay.setBounds(30, 416, 682, 407);
		add(scrollPaneXeMay);

		String[] colHeaderXeMay = { "STT", "Mã xe", "Tên xe", "hãng", "Màu sắc", "Số lượng", "Giá Bán", "Bảo hành" };
		modelXe = new DefaultTableModel(colHeaderXeMay, 0);
		tblXeMay = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblXeMay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXeMay.setRowHeight(25);
		scrollPaneXeMay.setViewportView(tblXeMay);
		JTableHeader tableHeader2 = tblXeMay.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(274, 275, 438, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cboHangXe = new JComboBox<String>();

		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setBounds(132, 326, 115, 30);
		add(cboHangXe);

		cboLoaiXe = new JComboBox<String>();

		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(360, 326, 130, 30);
		add(cboLoaiXe);

		cboDongXe = new JComboBox<String>();

		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(132, 373, 115, 30);
		add(cboDongXe);

		cboXuatXu = new JComboBox<String>();

		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setBackground(Color.WHITE);
		cboXuatXu.setBounds(360, 373, 130, 30);
		add(cboXuatXu);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(30, 840, 51, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(93, 840, 51, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(230, 840, 51, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(293, 840, 51, 40);
		add(btnCuoi);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setBounds(156, 840, 62, 40);
		add(txtTrang);
		txtTrang.setColumns(10);

		JButton btnXemChiTiet = new JButton("Chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/information_30px.png")));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setBounds(30, 893, 144, 40);
		add(btnXemChiTiet);

		JPanel pnlTongTien = new JPanel();
		pnlTongTien.setBackground(new Color(58, 181, 74));
		pnlTongTien.setBounds(731, 617, 661, 145);
		add(pnlTongTien);
		pnlTongTien.setLayout(null);

		JLabel lblTT = new JLabel("Tổng Tiền");
		lblTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTT.setBounds(0, 0, 661, 38);
		lblTT.setForeground(Color.WHITE);
		lblTT.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTT.setBackground(new Color(102, 102, 255));
		pnlTongTien.add(lblTT);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		separator_3.setBounds(0, 38, 661, 10);
		pnlTongTien.add(separator_3);

		lblTongTien = new JLabel("0 VNĐ");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setForeground(Color.WHITE);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongTien.setBackground(new Color(102, 102, 255));
		lblTongTien.setBounds(0, 38, 661, 46);
		pnlTongTien.add(lblTongTien);

		lblTienBangChu = new JLabel("Bằng chữ: không đồng.");
		lblTienBangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienBangChu.setForeground(Color.WHITE);
		lblTienBangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienBangChu.setBackground(new Color(102, 102, 255));
		lblTienBangChu.setBounds(0, 87, 661, 46);
		pnlTongTien.add(lblTienBangChu);

		JPanel pnlTienKhachTra = new JPanel();
		pnlTienKhachTra.setBackground(new Color(255, 215, 0));
		pnlTienKhachTra.setBounds(731, 785, 319, 94);
		add(pnlTienKhachTra);
		pnlTienKhachTra.setLayout(null);

		JLabel lblTienKhachTra = new JLabel("Tiền khách trả");
		lblTienKhachTra.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienKhachTra.setForeground(Color.WHITE);
		lblTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienKhachTra.setBackground(new Color(102, 102, 255));
		lblTienKhachTra.setBounds(0, 0, 319, 38);
		pnlTienKhachTra.add(lblTienKhachTra);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(Color.WHITE);
		separator_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		separator_3_1.setBounds(0, 38, 319, 10);
		pnlTienKhachTra.add(separator_3_1);

		JLabel lblVND = new JLabel("VNĐ");
		lblVND.setHorizontalAlignment(SwingConstants.CENTER);
		lblVND.setForeground(Color.WHITE);
		lblVND.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVND.setBackground(new Color(102, 102, 255));
		lblVND.setBounds(218, 38, 89, 56);
		pnlTienKhachTra.add(lblVND);

		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setHorizontalAlignment(SwingConstants.CENTER);
		txtTienKhachTra.setForeground(Color.WHITE);
		txtTienKhachTra.setBackground(new Color(255, 215, 0));
		txtTienKhachTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTienKhachTra.setColumns(10);
		txtTienKhachTra.setBorder(null);
		txtTienKhachTra.setBounds(44, 57, 180, 25);
		pnlTienKhachTra.add(txtTienKhachTra);

		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setForeground(Color.WHITE);
		separator_2_2.setBounds(54, 82, 170, 12);
		pnlTienKhachTra.add(separator_2_2);

		JPanel pnlTienTraLai = new JPanel();
		pnlTienTraLai.setBackground(new Color(102, 204, 255));
		pnlTienTraLai.setBounds(1073, 786, 319, 94);
		add(pnlTienTraLai);
		pnlTienTraLai.setLayout(null);

		JLabel lblTTra = new JLabel("Tiền trả lại");
		lblTTra.setHorizontalAlignment(SwingConstants.CENTER);
		lblTTra.setForeground(Color.WHITE);
		lblTTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTTra.setBackground(new Color(102, 102, 255));
		lblTTra.setBounds(0, 0, 319, 38);
		pnlTienTraLai.add(lblTTra);

		JSeparator separator_3_2 = new JSeparator();
		separator_3_2.setForeground(Color.WHITE);
		separator_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		separator_3_2.setBounds(0, 38, 319, 10);
		pnlTienTraLai.add(separator_3_2);

		lblTienTraLai = new JLabel();
		lblTienTraLai.setBounds(0, 38, 319, 56);
		pnlTienTraLai.add(lblTienTraLai);
		lblTienTraLai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienTraLai.setForeground(Color.WHITE);
		lblTienTraLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienTraLai.setBackground(new Color(102, 102, 255));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_add_shopping_cart_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnThem.setBackground(new Color(51, 204, 255));
		btnThem.setBounds(568, 840, 144, 40);
		add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_edit_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSua.setBackground(new Color(51, 204, 255));
		btnSua.setBounds(568, 893, 144, 40);
		add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_remove_shopping_cart_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(409, 893, 144, 40);
		add(btnXoa);

		JLabel lblSL = new JLabel("Số lượng:");
		lblSL.setForeground(Color.BLACK);
		lblSL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSL.setBackground(new Color(102, 102, 255));
		lblSL.setBounds(399, 840, 96, 40);
		add(lblSL);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(58, 181, 74));
		separator_1_1.setBounds(30, 250, 1362, 12);
		add(separator_1_1);

		JLabel lblXuatXu = new JLabel("Xuất xứ:");
		lblXuatXu.setForeground(Color.BLACK);
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXuatXu.setBackground(new Color(102, 102, 255));
		lblXuatXu.setBounds(274, 369, 88, 30);
		add(lblXuatXu);

		JLabel lblDongXe = new JLabel("Dòng xe:");
		lblDongXe.setForeground(Color.BLACK);
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDongXe.setBackground(new Color(102, 102, 255));
		lblDongXe.setBounds(30, 373, 88, 30);
		add(lblDongXe);

		JLabel lblLoai = new JLabel("Loại xe:");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoai.setBackground(new Color(102, 102, 255));
		lblLoai.setBounds(274, 326, 74, 30);
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
		cboTimKiem.setBounds(132, 276, 115, 29);
		add(cboTimKiem);

		JLabel lblTK = new JLabel("Tìm kiếm:");
		lblTK.setForeground(Color.BLACK);
		lblTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTK.setBackground(new Color(102, 102, 255));
		lblTK.setBounds(30, 275, 107, 30);
		add(lblTK);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon
				.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_monetization_on_white_18dp.png")));
		btnLapHoaDon.setBounds(1073, 893, 319, 42);
		add(btnLapHoaDon);
		btnLapHoaDon.setForeground(Color.WHITE);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnLapHoaDon.setBackground(new Color(0, 153, 51));

		btnTaoMoi = new JButton("Tạo mới hóa đơn");
		btnTaoMoi.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnTaoMoi.setForeground(Color.WHITE);
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnTaoMoi.setBackground(new Color(51, 204, 255));
		btnTaoMoi.setBounds(731, 893, 319, 42);
		add(btnTaoMoi);

		txtSoLuong = new JTextField();
		txtSoLuong.setText("1");
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(496, 840, 62, 40);
		add(txtSoLuong);

		cboMauXe = new JComboBox<String>();

		cboMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMauXe.setBackground(Color.WHITE);
		cboMauXe.setBounds(568, 326, 151, 30);
		add(cboMauXe);

		JLabel lblMu = new JLabel("Màu:");
		lblMu.setForeground(Color.BLACK);
		lblMu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMu.setBackground(new Color(102, 102, 255));
		lblMu.setBounds(518, 326, 69, 30);
		add(lblMu);

		JLabel lblGi = new JLabel("Giá:");
		lblGi.setForeground(Color.BLACK);
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGi.setBackground(new Color(102, 102, 255));
		lblGi.setBounds(518, 373, 69, 30);
		add(lblGi);

		cboGiaXe = new JComboBox<String>();
		cboGiaXe.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Tất cả", "Dưới 25tr", "Từ 25tr - 60tr", "Trên 60tr" }));
		cboGiaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboGiaXe.setBackground(Color.WHITE);
		cboGiaXe.setBounds(568, 373, 151, 30);
		add(cboGiaXe);

		khoiTao();
		dangKiSuKien();
		hienThiNhanVien();

		loadDuLieuThongTinTimKiem();
		capNhatXeMaysTrongBang();

	}

	public void khoiTao() {
		xeMayDao = XeMayDao.getInstance();
		khachHangDao = KhachHangDao.getInstance();
		nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();

	}

	private void dangKiSuKien() {
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
		btnSua.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == txtSoDienThoai) {
			String soDienThoai = txtSoDienThoai.getText();
			KhachHang khachHang = khachHangDao.getKhachHangTheoSoDienThoai(soDienThoai);

			if (khachHang != null) {
				capNhatKhachHang(khachHang);
			} else {
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
							xeMay.getGiaNhap(), soLuong);
					xeMay.setSoLuong(xeMay.getSoLuong() - soLuong);
					xeMayDao.capNhatXeMay(xeMay);

					this.hoaDon.themChiTietHoaDon(chiTietHoaDon);

					capNhatXeMaysTrongBang();
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
			this.page = 1;
			capNhatXeMaysTrongBang();
		}

		if (source == cboTimKiem) {
			this.page = 1;
			txtTimKiem.setText("");
			capNhatXeMaysTrongBang();
		}

		if (source == btnTruoc && this.page > 1) {

			this.page--;
			capNhatXeMaysTrongBang();
		}

		if (source == btnSau && this.page < maxPage) {
			this.page++;
			capNhatXeMaysTrongBang();
		}

		if (source == btnDau) {
			this.page = 1;
			capNhatXeMaysTrongBang();
		}

		if (source == btnCuoi) {
			this.page = maxPage;
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

			if(lblTienTraLai.getText().length() > 0) {
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
			}else {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập tiền khách trả");
				txtTienKhachTra.requestFocus();
				txtTienKhachTra.selectAll();

			}

		}

		if (source == btnTaoMoi) {

			if(hoaDon != null) {
				for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {

					XeMay xeMay = chiTietHoaDon.getXeMay();
					xeMay.setSoLuong(xeMay.getSoLuong() + chiTietHoaDon.getSoLuong());
					xeMayDao.capNhatXeMay(xeMay);
				}
				this.hoaDon = null;
				capNhatHoaDon();
				capNhatKhachHang(null);
				capNhatXeMaysTrongBang();
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
			capNhatXeMaysTrongBang();

		}

		if (source == btnSua) {
			int row = tblHoaDon.getSelectedRow();
			int soLuong = Integer.valueOf(txtSoLuong.getText());

			ChiTietHoaDon chiTietHoaDon = hoaDon.getChiTietHoaDons().get(row);
			XeMay xeMay = chiTietHoaDon.getXeMay();

			xeMay.setSoLuong(xeMay.getSoLuong() + chiTietHoaDon.getSoLuong() - soLuong);
			xeMayDao.capNhatXeMay(xeMay);

			chiTietHoaDon.setSoLuong(soLuong);
			capNhatHoaDon();
			capNhatXeMaysTrongBang();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.page = 1;
		capNhatXeMaysTrongBang();

	}

	private void capNhatHoaDon() {

		xoaDuLieuChiTietHoaDonsTrongBang();
		if (hoaDon != null) {
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
				Object[] datas = new Object[5];
				datas[0] = tblHoaDon.getRowCount() + 1;
				datas[1] = chiTietHoaDon.getXeMay().getTenXeMay();
				datas[2] = chiTietHoaDon.getSoLuong();
				datas[3] = DinhDangTien.format(chiTietHoaDon.getGiaBan());
				datas[4] = DinhDangTien.format(chiTietHoaDon.tinhTongTien());

				modelHoaDon.addRow(datas);
			}

			lblTongTien.setText(DinhDangTien.format(hoaDon.tinhTongTienHoaDon()));
			
			DecimalFormat df = new DecimalFormat("###.##");
			System.out.println(DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon())));
			lblTienBangChu.setText("Bằng chữ: "  + DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon())) + " đồng"  );
		} else {
			lblTongTien.setText("0 VNĐ");
			lblTienBangChu.setText("Không đồng");
			txtTienKhachTra.setText("");
			lblTienTraLai.setText("");
		}

	}

	private void capNhatXeMaysTrongBang() {

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
		this.maxPage = xeMayDao.getMaxPageTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
				tenHangXe, SIZE);
		// System.out.println("maxPage: " + maxPage);
		xeMays = xeMayDao.getXeMaysTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
				tenHangXe, from, to);

		xoaDuLieuXeMayTrongBang();
		themXeMaysVaoBang();
		txtTrang.setText(this.page + "");

	}

	private void themXeMaysVaoBang() {

		if (xeMays != null) {

			for (XeMay xeMay : xeMays) {
				themXeMayVaoBang(xeMay);
			}
		}

	}

	private void themXeMayVaoBang(XeMay xeMay) {

		Object[] datas = new Object[8];
		datas[0] = tblXeMay.getRowCount() + 1;
		datas[1] = xeMay.getMaXeMay();
		datas[2] = xeMay.getTenXeMay();
		datas[3] = xeMay.getDongXe().getHangXe().getTenHangXe();
		datas[4] = xeMay.getMauXe();
		datas[5] = xeMay.getSoLuong();
		datas[6] = DinhDangTien.format(xeMay.getGiaNhap());
		datas[7] = xeMay.getThoiGianBaoHanh();

		modelXe.addRow(datas);
	}

	private void capNhatKhachHang(KhachHang khachHang) {

		if (khachHang != null) {
			lblMaKhachHang.setText(khachHang.getMaKhachHang());
			lblTenKhachHang.setText(khachHang.getHoTenKH());
			txtSoCMT.setText(khachHang.getSoCMT());
			txtSoCMT.setEditable(false);
			txtSoDienThoai.setEditable(false);
			lblNgaySinh.setText(XuLyThoiGian.chuyenDateThanhString(khachHang.getNgaySinh()));
			lblDiaChi.setText(khachHang.getDiaChiKH());
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
		System.out.println(nhanVienHanhChinh);
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

}
