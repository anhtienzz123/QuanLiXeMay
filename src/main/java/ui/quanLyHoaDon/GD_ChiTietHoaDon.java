package ui.quanLyHoaDon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.HoaDonDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import other.DinhDangTien;
import other.DocSo;
import other.XuLyThoiGian;
import other.XuatHoaDon;

public class GD_ChiTietHoaDon extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblHoaDon;
	private DefaultTableModel modelHoaDon;
	private JLabel lblMaHD;
	private JLabel lblNgayLapHD;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblSDT;
	private JLabel lblDiaChi;
	private JLabel lblSoCMT;
	private JLabel lblNgaySinh;
	private JButton btnThoat;
	private HoaDonDao hoaDonDao;
	private String maHoaDon;
	private JLabel lblTongTien;
	private JLabel lblChu;
	private JButton btnXuatHoaDon;

	public GD_ChiTietHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
		hoaDonDao = HoaDonDao.getInstance();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GD_ChiTietHoaDon.class.getResource("/icon/baseline_receipt_long_white_36dp.png")));
		setTitle("Hóa đơn");
		setSize(1200, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1182, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hóa đơn");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1182, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin hóa đơn");
		lblNewLabel_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 63, 249, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(528, 63, 287, 30);
		contentPane.add(lblNewLabel_1_1);

		JSeparator separator = new JSeparator();
		separator.setBorder(null);
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(23, 92, 457, 14);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(null);
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(528, 92, 623, 14);
		contentPane.add(separator_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 101, 136, 30);
		contentPane.add(lblNewLabel_1_2);

		lblMaHD = new JLabel("HD123456");
		lblMaHD.setForeground(Color.BLACK);
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHD.setBounds(232, 101, 136, 30);
		contentPane.add(lblMaHD);

		JLabel lblNewLabel_1_2_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(23, 144, 197, 30);
		contentPane.add(lblNewLabel_1_2_2);

		lblNgayLapHD = new JLabel("11-11-2020");
		lblNgayLapHD.setForeground(Color.BLACK);
		lblNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayLapHD.setBounds(232, 144, 136, 30);
		contentPane.add(lblNgayLapHD);

		JLabel lblNewLabel_1_2_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_3.setBounds(23, 187, 182, 30);
		contentPane.add(lblNewLabel_1_2_3);

		lblMaNV = new JLabel("HC123456");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(232, 187, 136, 30);
		contentPane.add(lblMaNV);

		JLabel lblNewLabel_1_2_4 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_4.setBounds(23, 230, 182, 30);
		contentPane.add(lblNewLabel_1_2_4);

		lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(232, 230, 270, 30);
		contentPane.add(lblTenNV);

		JLabel lblNewLabel_1_2_5 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_2_5.setForeground(Color.BLACK);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(529, 101, 197, 30);
		contentPane.add(lblNewLabel_1_2_5);

		lblMaKH = new JLabel("KH123456");
		lblMaKH.setForeground(Color.BLACK);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKH.setBounds(718, 101, 136, 30);
		contentPane.add(lblMaKH);

		lblTenKH = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKH.setForeground(Color.BLACK);
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKH.setBounds(718, 144, 389, 30);
		contentPane.add(lblTenKH);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2_1.setBounds(529, 144, 182, 30);
		contentPane.add(lblNewLabel_1_2_2_1);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_3_1.setBounds(529, 187, 182, 30);
		contentPane.add(lblNewLabel_1_2_3_1);

		lblSDT = new JLabel("0123456789");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(718, 187, 136, 30);
		contentPane.add(lblSDT);

		lblDiaChi = new JLabel("12, Nguyễn Văn Bảo, phường 4, Quận Gò Vấp, TPHCM");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(616, 230, 554, 30);
		contentPane.add(lblDiaChi);

		JLabel lblNewLabel_1_2_4_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_4_1.setBounds(529, 230, 136, 30);
		contentPane.add(lblNewLabel_1_2_4_1);

		JLabel lblNewLabel_1_2_5_1 = new JLabel("Số CMT:");
		lblNewLabel_1_2_5_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5_1.setBounds(899, 101, 121, 30);
		contentPane.add(lblNewLabel_1_2_5_1);

		lblSoCMT = new JLabel("123456789012");
		lblSoCMT.setForeground(Color.BLACK);
		lblSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoCMT.setBounds(1015, 101, 136, 30);
		contentPane.add(lblSoCMT);

		JLabel lblNewLabel_1_2_5_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_2_5_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5_1_1.setBounds(899, 187, 121, 30);
		contentPane.add(lblNewLabel_1_2_5_1_1);

		lblNgaySinh = new JLabel("11-11-2020");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBounds(1015, 187, 136, 30);
		contentPane.add(lblNgaySinh);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(58, 181, 74));
		separator_2.setBorder(null);
		separator_2.setBounds(23, 302, 1128, 14);
		contentPane.add(separator_2);

		JLabel lblNewLabel_1_3 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_1_3.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(23, 273, 249, 30);
		contentPane.add(lblNewLabel_1_3);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(1015, 791, 136, 35);
		contentPane.add(btnThoat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 329, 1128, 383);
		contentPane.add(scrollPane);

		String[] colHeaderHoaDon = { "STT", "Mã xe", "Tên xe", "Số khung", "Giá bán", "Bảo hành", "Hãng xe", "Loại xe",
				"Màu sắc" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setBackground(Color.WHITE);
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(30);
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(50);// STT
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(150);// Mã xe

		tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(300);// Tên xe

		tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(200);// Hãng
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(200);// Loại xe
		tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(200);// Màu
		tblHoaDon.getColumnModel().getColumn(6).setPreferredWidth(100);// Số lượng
		tblHoaDon.getColumnModel().getColumn(7).setPreferredWidth(250);// Giá bán
		tblHoaDon.getColumnModel().getColumn(8).setPreferredWidth(100);// Bảo hành
		scrollPane.setViewportView(tblHoaDon);
		tblHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		btnXuatHoaDon = new JButton("Xuất hóa đơn");
		btnXuatHoaDon.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/icon/print_30px.png")));
		// btnXuatHoaDon.setIcon(new
		// ImageIcon(GD_ChiTietHoaDon.class.getResource("/icon/print_30px.png")));
		btnXuatHoaDon.setForeground(Color.WHITE);
		btnXuatHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXuatHoaDon.setBackground(Color.GRAY);
		btnXuatHoaDon.setBounds(762, 791, 214, 35);
		contentPane.add(btnXuatHoaDon);

		lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongTien.setBounds(23, 729, 642, 35);
		contentPane.add(lblTongTien);

		lblChu = new JLabel("(Bằng chữ");
		lblChu.setVerticalAlignment(SwingConstants.TOP);
		lblChu.setForeground(Color.RED);
		lblChu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChu.setBounds(23, 765, 688, 61);
		contentPane.add(lblChu);
//		center value in column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		tblHoaDon.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
		tblHoaDon.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);

		JTableHeader tableHeaderNVKyThuat = tblHoaDon.getTableHeader();
		tableHeaderNVKyThuat.setBackground(new Color(58, 181, 74));
		tableHeaderNVKyThuat.setForeground(Color.white);
		tableHeaderNVKyThuat.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnThoat.addActionListener(this);
		btnXuatHoaDon.addActionListener(this);
		khoiTao();

	}

	private HoaDon hoaDon;

	private void khoiTao() {
		hoaDon = hoaDonDao.getHoaDonTheoMaHoaDon(maHoaDon);

		lblMaHD.setText(hoaDon.getMaHoaDon());
		lblNgayLapHD.setText(XuLyThoiGian.chuyenDateThanhString(hoaDon.getNgayLap()));
		lblMaNV.setText(hoaDon.getNhanVienHanhChinh().getMaNVHanhChinh());
		lblTenNV.setText(hoaDon.getNhanVienHanhChinh().getHoTenNV());

		lblMaKH.setText(hoaDon.getKhachHang().getMaKhachHang());
		lblSoCMT.setText(hoaDon.getKhachHang().getSoCMT());
		lblTenKH.setText(hoaDon.getKhachHang().getHoTenKH());
		lblSDT.setText(hoaDon.getKhachHang().getSoDienThoai());
		lblNgaySinh.setText(XuLyThoiGian.chuyenDateThanhString(hoaDon.getKhachHang().getNgaySinh()));
		lblDiaChi.setText(hoaDon.getKhachHang().getDiaChiKH());

		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
			Object[] datas = new Object[9];
			datas[0] = tblHoaDon.getRowCount() + 1;
			datas[1] = chiTietHoaDon.getXeMay().getMaXeMay();
			datas[2] = chiTietHoaDon.getXeMay().getTenXeMay();
			datas[3] = chiTietHoaDon.getXeMay().getSoKhung();
			datas[4] = DinhDangTien.format(chiTietHoaDon.getGiaBan());
			datas[5] = chiTietHoaDon.getXeMay().getThoiGianBaoHanh();
			datas[6] = chiTietHoaDon.getXeMay().getDongXe().getHangXe().getTenHangXe();
			datas[7] = chiTietHoaDon.getXeMay().getLoaiXe().getTenLoaiXe();
			datas[8] = chiTietHoaDon.getXeMay().getMauXe();

			modelHoaDon.addRow(datas);

		}

		DecimalFormat df = new DecimalFormat("###.##");
		lblTongTien.setText("Tổng tiền: " + DinhDangTien.format(hoaDon.tinhTongTienHoaDon()));
		lblChu.setText("<html>Bằng chữ: " + DocSo.readNum(df.format(hoaDon.tinhTongTienHoaDon())) + " đồng</html>");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			setVisible(false);
		}
		if (o.equals(btnXuatHoaDon)) {
			// XuLiXuatFile xuatFile = new XuLiXuatFile();
			try {

				HoaDon hoaDon = hoaDonDao.getHoaDonTheoMaHoaDon(maHoaDon);

				XuatHoaDon.xuatHoaDon(hoaDon);
				// xuatFile.xuatHoaDonRaFileWord1(this.hoaDon);
				// JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công");

			} catch (Exception e1) {
                e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Xuất hóa đơn thất bại");
			}
		}
	}
}
