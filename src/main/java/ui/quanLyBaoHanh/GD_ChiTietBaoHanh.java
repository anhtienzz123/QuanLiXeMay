package ui.quanLyBaoHanh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.ChiTietBaoHanhDao;
import dao.HopDongDao;
import dao.NhanVienKiThuatDao;
import dao.PhieuBaoHanhDao;
import entity.ChiTietBaoHanh;
import entity.HopDong;
import entity.NhanVienKiThuat;
import entity.PhieuBaoHanh;
import ui.App;

public class GD_ChiTietBaoHanh extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelBaoHanh;
	private JTable tblBaoHanh;
	private JButton btnQuayLai;
	private JLabel lblMaHopDong;

	/**
	 * Create the panel.
	 */
	public GD_ChiTietBaoHanh(String maHopDong, String maPhieuBaoHanh, String dot) {
		HopDong hopDong = HopDongDao.getInstance().getHopDongTheoMa(maHopDong);
		PhieuBaoHanh phieuBaoHanh = PhieuBaoHanhDao.getInstance().getPhieuBaoHanhTheoMa(maPhieuBaoHanh);
		NhanVienKiThuat nhanVienKiThuat = NhanVienKiThuatDao.getInstance()
				.getNVKiThuatTheoMa(phieuBaoHanh.getNhanVienKiThuat().getMaNVKiThuat());
		List<ChiTietBaoHanh> chiTietBaoHanhs = ChiTietBaoHanhDao.getInstance()
				.getChiTietBaoHanhTheoMaPhieuBaoHanh(maPhieuBaoHanh);

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblDot = new JLabel("Phiếu bảo hành đợt " + dot);
		lblDot.setHorizontalAlignment(SwingConstants.CENTER);
		lblDot.setForeground(Color.WHITE);
		lblDot.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDot.setBounds(0, 0, 1800, 50);
		panel.add(lblDot);

		JScrollPane scrollpaneBaoHanh = new JScrollPane();
		scrollpaneBaoHanh.setBounds(29, 315, 1723, 450);
		add(scrollpaneBaoHanh);

		JLabel lblDanhSach = new JLabel("Danh mục bảo hành");
		lblDanhSach.setForeground(new Color(58, 181, 74));
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSach.setBounds(29, 241, 225, 30);
		add(lblDanhSach);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 278, 1723, 11);
		add(separator);

		String[] colHeaderBaoHanh = { "STT", "Danh mục bảo hành", "Vệ sinh", "Thay thế" };
		modelBaoHanh = new DefaultTableModel(new Object[][] {}, colHeaderBaoHanh) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Object.class, Object.class, Boolean.class, Boolean.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tblBaoHanh = new JTable(modelBaoHanh) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblBaoHanh.setRowHeight(40);
		scrollpaneBaoHanh.setViewportView(tblBaoHanh);
		tblBaoHanh.getColumnModel().getColumn(0).setPreferredWidth(85);
		tblBaoHanh.getColumnModel().getColumn(1).setPreferredWidth(900);
		tblBaoHanh.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblBaoHanh.getColumnModel().getColumn(3).setPreferredWidth(200);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblBaoHanh.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblBaoHanh.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

//		int count = chiTietBaoHanhs.size();
		for (ChiTietBaoHanh chiTietBaoHanh : chiTietBaoHanhs) {
			int index = chiTietBaoHanhs.indexOf(chiTietBaoHanh);
			modelBaoHanh.addRow(new Object[] { index + 1, chiTietBaoHanh.getDanhMucBaoHanh().getTenDanhMucBaoHanh(),
					chiTietBaoHanh.isTrangThai(), !chiTietBaoHanh.isTrangThai() });
		}

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 877, 1800, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/icon/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1800, 133);
		pnlLogo.add(lblLogo);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setIcon(new ImageIcon(GD_CapNhatBaoHanh.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setBounds(1588, 801, 164, 40);
		add(btnQuayLai);

		JLabel lblMPBH = new JLabel("Mã phiếu bảo hành:");
		lblMPBH.setForeground(Color.BLACK);
		lblMPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMPBH.setBounds(29, 77, 188, 30);
		add(lblMPBH);

		JLabel lblMaPhieuBaoHanh = new JLabel(maPhieuBaoHanh);
		lblMaPhieuBaoHanh.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh.setBounds(266, 77, 111, 30);
		add(lblMaPhieuBaoHanh);

		JLabel lblMHD = new JLabel("Mã hợp đồng:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBounds(583, 77, 188, 30);
		add(lblMHD);

		lblMaHopDong = new JLabel(maHopDong);
		lblMaHopDong.setForeground(Color.BLACK);
		lblMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHopDong.setBounds(812, 77, 111, 30);
		add(lblMaHopDong);

		JLabel lblNLHD = new JLabel("Ngày lập phiếu:");
		lblNLHD.setForeground(Color.BLACK);
		lblNLHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNLHD.setBounds(1349, 77, 158, 30);
		add(lblNLHD);

		JLabel lblNgay = new JLabel(new SimpleDateFormat("dd-MM-yyyy").format(phieuBaoHanh.getNgayBaoHanh()));
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(1522, 77, 111, 30);
		add(lblNgay);

		JLabel lblTnKhchHng = new JLabel("Mã khách hàng:");
		lblTnKhchHng.setForeground(Color.BLACK);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng.setBounds(29, 163, 164, 30);
		add(lblTnKhchHng);

		JLabel lblMaKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getMaKhachHang());
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBounds(266, 163, 180, 30);
		add(lblMaKhachHang);

		JLabel lblTnKhchHng_1 = new JLabel("Tên khách hàng:");
		lblTnKhchHng_1.setForeground(Color.BLACK);
		lblTnKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1.setBounds(583, 163, 164, 30);
		add(lblTnKhchHng_1);

		JLabel lblTenKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getHoTenKH());
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBounds(812, 163, 358, 30);
		add(lblTenKhachHang);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(Color.BLACK);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSinThoi.setBounds(1349, 163, 127, 30);
		add(lblSinThoi);

		JLabel lblSoDienThoai = new JLabel(hopDong.getHoaDon().getKhachHang().getSoDienThoai());
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(1522, 163, 127, 30);
		add(lblSoDienThoai);

		JLabel lblMXe = new JLabel("Mã xe:");
		lblMXe.setForeground(Color.BLACK);
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMXe.setBounds(29, 204, 86, 30);
		add(lblMXe);

		JLabel lblMaXe = new JLabel(hopDong.getXeMay().getMaXeMay());
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(182, 204, 127, 30);
		add(lblMaXe);

		JLabel lblTnKhchHng_1_1 = new JLabel("Tên xe:");
		lblTnKhchHng_1_1.setForeground(Color.BLACK);
		lblTnKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1_1.setBounds(583, 206, 86, 30);
		add(lblTnKhchHng_1_1);

		JLabel lblTenXe = new JLabel("<html>" + hopDong.getXeMay().getTenXeMay() + "</html>");
		lblTenXe.setVerticalAlignment(SwingConstants.TOP);
		lblTenXe.setForeground(Color.BLACK);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(681, 206, 489, 65);
		add(lblTenXe);

		JLabel lblHng_1 = new JLabel("Hãng:");
		lblHng_1.setForeground(Color.BLACK);
		lblHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng_1.setBounds(1349, 206, 100, 30);
		add(lblHng_1);

		JLabel lblHonda = new JLabel(hopDong.getXeMay().getDongXe().getHangXe().getTenHangXe());
		lblHonda.setForeground(Color.BLACK);
		lblHonda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHonda.setBounds(1468, 206, 127, 30);
		add(lblHonda);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên kỹ thuật:");
		lblMNhnVin.setForeground(Color.BLACK);
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMNhnVin.setBounds(29, 120, 231, 30);
		add(lblMNhnVin);

		JLabel lblKt = new JLabel(phieuBaoHanh.getNhanVienKiThuat().getMaNVKiThuat());
		lblKt.setForeground(Color.BLACK);
		lblKt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKt.setBounds(266, 120, 164, 30);
		add(lblKt);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên kỹ thuật:");
		lblTnNhnVin.setForeground(Color.BLACK);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnNhnVin.setBounds(583, 120, 217, 30);
		add(lblTnNhnVin);

		JLabel lblTenNV = new JLabel(nhanVienKiThuat.getHoTen());
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(812, 120, 325, 30);
		add(lblTenNV);

		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnQuayLai.addActionListener(this);
		tblBaoHanh.addMouseListener(this);

	}

	/**
	 * Đọc dữ liệu vào mo
	 */

	/*
	 * private void docDuLieuDatabaseVaoTable() {
	 * modelBaoHanh.getDataVector().removeAllElements(); }
	 */

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
		if (o.equals(btnQuayLai)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_BaoHanh(lblMaHopDong.getText().trim()));
			this.validate();
			this.repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
