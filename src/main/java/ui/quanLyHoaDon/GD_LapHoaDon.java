package ui.quanLyHoaDon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.EventObject;

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

import db.DatabaseConnect;
import other.DocSo;
import ui.quanLyHoaDon.GD_ChiTietHoaDon;
import ui.quanLyKhachHang.GD_ThemKhachHang;
import ui.quanLyXeMay.GD_ChiTietXeMay;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class GD_LapHoaDon extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelHoaDon;
	private DefaultTableModel modelXe;
	private JTextField txtSoCMT;
	private JTextField txtSoDienThoai;
	private JTable tblHoaDon;
	private JTable tblXeMay;
	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JTextField txtTienKhachTra;
	private JTextField txtSoLuong;
	
	private JComboBox<String> cboHang;
	private JComboBox<String> cboTimKiem;

	/**
	 * Create the panel.
	 */
	public GD_LapHoaDon() {
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

		JLabel lblMaHoaDon = new JLabel("HD123456");
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

		JLabel lblNgayLạpHoaDon = new JLabel("20-10-2020");
		lblNgayLạpHoaDon.setForeground(Color.BLACK);
		lblNgayLạpHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayLạpHoaDon.setBackground(new Color(102, 102, 255));
		lblNgayLạpHoaDon.setBounds(242, 125, 124, 50);
		add(lblNgayLạpHoaDon);

		JLabel lblMNV = new JLabel("Mã nhân viên:");
		lblMNV.setForeground(Color.BLACK);
		lblMNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMNV.setBackground(new Color(102, 102, 255));
		lblMNV.setBounds(42, 163, 159, 50);
		add(lblMNV);

		JLabel lblMaNhanVien = new JLabel("NV123456");
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

		JLabel lblTenNhanVien = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNhanVien.setForeground(Color.BLACK);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNhanVien.setBackground(new Color(102, 102, 255));
		lblTenNhanVien.setBounds(242, 198, 264, 50);
		add(lblTenNhanVien);

		JLabel lblMKH = new JLabel("Mã khách hàng:");
		lblMKH.setForeground(Color.BLACK);
		lblMKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMKH.setBackground(new Color(102, 102, 255));
		lblMKH.setBounds(602, 91, 159, 50);
		add(lblMKH);

		JLabel lblMaKhachHang = new JLabel("KH123456");
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

		JLabel lblTenKhachHang = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBackground(new Color(102, 102, 255));
		lblTenKhachHang.setBounds(790, 135, 438, 30);
		add(lblTenKhachHang);

		JLabel lblNgaySinh = new JLabel("20-10-2000");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBackground(new Color(102, 102, 255));
		lblNgaySinh.setBounds(1195, 163, 115, 50);
		add(lblNgaySinh);

		JLabel lblDiaChi = new JLabel("12 Nguyễn Văn Bảo, phường 4, Gò Vấp, TPHCM");
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
		txtSoCMT.setText("123456789012");
		txtSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMT.setBounds(1166, 104, 144, 25);
		add(txtSoCMT);
		txtSoCMT.setColumns(10);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(1166, 129, 137, 12);
		add(separator_2);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setText("0123456789");
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
		String[] colHeaderHoaDon = { "STT", "Mã xe", "Tên xe", "Số lượng", "Giá Bán", "Bảo hành" };
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
		tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(100);
		JTableHeader tableHeader = tblHoaDon.getTableHeader();
		tableHeader.setBackground(new Color(58, 181, 74));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneHoaDon.setViewportView(tblHoaDon);

		modelHoaDon.addRow(new Object[] { "1", null, null, null });
		modelHoaDon.addRow(new Object[] { "2", null, null, null });
		modelHoaDon.addRow(new Object[] { "3", null, null, null });
		modelHoaDon.addRow(new Object[] { "4", null, null, null });
		modelHoaDon.addRow(new Object[] { "5", null, null, null });

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
		txtTimKiem.setBounds(326, 275, 386, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		 cboHang = new JComboBox<String>();
		cboHang.setModel(new DefaultComboBoxModel(new String[] { "Harley Davidson", "Tất cả" }));
		cboHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHang.setBackground(Color.WHITE);
		cboHang.setBounds(132, 326, 171, 30);
		add(cboHang);

		JComboBox<String> cboLoaiXe = new JComboBox<String>();
		cboLoaiXe.setModel(new DefaultComboBoxModel<String>(new String[] { "Xe côn tay", "Tất cả" }));
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(582, 326, 130, 30);
		add(cboLoaiXe);

		JComboBox<String> cboDongXe = new JComboBox<String>();
		cboDongXe.setModel(new DefaultComboBoxModel<String>(new String[] { "Air Blade", "Tất cả" }));
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(132, 373, 171, 30);
		add(cboDongXe);

		JComboBox<String> cboXuatXu = new JComboBox<String>();
		cboXuatXu.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Trung Quốc", "Tất cả", "Việt Nam", "Nhật Bản", "Thái Lan", "Đức", "Trung Quốc" }));
		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setBackground(Color.WHITE);
		cboXuatXu.setBounds(575, 373, 137, 30);
		add(cboXuatXu);

		JButton btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(30, 840, 51, 40);
		add(btnDau);

		JButton btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(93, 840, 51, 40);
		add(btnTruoc);

		JButton btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(230, 840, 51, 40);
		add(btnSau);

		JButton btnCuoi = new JButton("");
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

		JLabel lblTongTien = new JLabel("30000000 VNĐ");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setForeground(Color.WHITE);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTongTien.setBackground(new Color(102, 102, 255));
		lblTongTien.setBounds(0, 38, 661, 46);
		pnlTongTien.add(lblTongTien);
		
		JLabel lblBngCh = new JLabel("Bằng chữ: ba mươi triệu đồng.");
		lblBngCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblBngCh.setForeground(Color.WHITE);
		lblBngCh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBngCh.setBackground(new Color(102, 102, 255));
		lblBngCh.setBounds(0, 87, 661, 46);
		pnlTongTien.add(lblBngCh);

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
		txtTienKhachTra.setText("123456789012");
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

		JLabel lblTienTraLai = new JLabel("30000000 VNĐ");
		lblTienTraLai.setBounds(0, 38, 319, 56);
		pnlTienTraLai.add(lblTienTraLai);
		lblTienTraLai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienTraLai.setForeground(Color.WHITE);
		lblTienTraLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTienTraLai.setBackground(new Color(102, 102, 255));

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_add_shopping_cart_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnThem.setBackground(new Color(51, 204, 255));
		btnThem.setBounds(568, 840, 144, 40);
		add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_edit_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSua.setBackground(new Color(51, 204, 255));
		btnSua.setBounds(568, 893, 144, 40);
		add(btnSua);

		JButton btnXoa = new JButton("Xóa");
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
		lblXuatXu.setBounds(463, 373, 88, 30);
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
		lblLoai.setBounds(475, 326, 74, 30);
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
		cboTimKiem.setBounds(132, 276, 171, 29);
		add(cboTimKiem);

		JLabel lblTK = new JLabel("Tìm kiếm:");
		lblTK.setForeground(Color.BLACK);
		lblTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTK.setBackground(new Color(102, 102, 255));
		lblTK.setBounds(30, 275, 107, 30);
		add(lblTK);

		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan
				.setIcon(new ImageIcon(GD_LapHoaDon.class.getResource("/img/baseline_monetization_on_white_18dp.png")));
		btnThanhToan.setBounds(1073, 893, 319, 42);
		add(btnThanhToan);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnThanhToan.setBackground(new Color(0, 153, 51));

		JButton btnTaoMoi = new JButton("Tạo mới");
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
		
		
		

		dangKiSuKien();
	}

	private void dangKiSuKien() {
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
	
	
}
