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
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ui.App;
import javax.swing.JComboBox;

public class GD_ChiTietBaoHanh extends JPanel implements ActionListener, MouseListener {
	private DefaultTableModel modelBaoHanh;
	private JTable tblBaoHanh;
	private JButton btnQuayLai;

	/**
	 * Create the panel.
	 */
	public GD_ChiTietBaoHanh() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblDot = new JLabel("Phiếu bảo hành đợt 1");
		lblDot.setHorizontalAlignment(SwingConstants.CENTER);
		lblDot.setForeground(Color.WHITE);
		lblDot.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDot.setBounds(0, 0, 1450, 50);
		panel.add(lblDot);

		JScrollPane scrollpaneBaoHanh = new JScrollPane();
		scrollpaneBaoHanh.setBounds(29, 292, 1385, 431);
		add(scrollpaneBaoHanh);

		JLabel lblDanhSach = new JLabel("Danh mục bảo hành");
		lblDanhSach.setForeground(new Color(58, 181, 74));
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSach.setBounds(29, 241, 225, 30);
		add(lblDanhSach);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 278, 1385, 11);
		add(separator);

		String[] colHeaderBaoHanh = { "STT", "Danh mục bảo hành", "Vệ sinh", "Thay thế" };
		modelBaoHanh = new DefaultTableModel(new Object[][] {}, colHeaderBaoHanh) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Object.class, Object.class, Boolean.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tblBaoHanh = new JTable(modelBaoHanh);
//		{
//			private static final long serialVersionUID = 1L;
//
//			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
//				return false;
//			}
//		};
		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblBaoHanh.setRowHeight(25);
		scrollpaneBaoHanh.setViewportView(tblBaoHanh);
		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 7; i++) {
			modelBaoHanh.addRow(new Object[] { i, "Đợt " + i, false, true });
		}

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

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setIcon(new ImageIcon(GD_CapNhatBaoHanh.class.getResource("/img/baseline_close_white_24dp.png")));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setBounds(1250, 746, 164, 40);
		add(btnQuayLai);

		JLabel lblMPBH = new JLabel("Mã phiếu bảo hành:");
		lblMPBH.setForeground(Color.BLACK);
		lblMPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMPBH.setBounds(29, 77, 188, 30);
		add(lblMPBH);

		JLabel lblMaPhieuBaoHanh = new JLabel("BH123456");
		lblMaPhieuBaoHanh.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh.setBounds(266, 77, 111, 30);
		add(lblMaPhieuBaoHanh);

		JLabel lblMHD = new JLabel("Mã hợp đồng:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBounds(543, 77, 188, 30);
		add(lblMHD);

		JLabel lblMaHopDong = new JLabel("HD123456");
		lblMaHopDong.setForeground(Color.BLACK);
		lblMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHopDong.setBounds(772, 77, 111, 30);
		add(lblMaHopDong);

		JLabel lblNLHD = new JLabel("Ngày lập phiếu:");
		lblNLHD.setForeground(Color.BLACK);
		lblNLHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNLHD.setBounds(1085, 77, 158, 30);
		add(lblNLHD);

		JLabel lblNgay = new JLabel("01-11-2020");
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(1258, 77, 111, 30);
		add(lblNgay);

		JLabel lblTnKhchHng = new JLabel("Mã khách hàng:");
		lblTnKhchHng.setForeground(Color.BLACK);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng.setBounds(29, 163, 164, 30);
		add(lblTnKhchHng);

		JLabel lblMaKhachHang = new JLabel("KH123456");
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBounds(266, 163, 180, 30);
		add(lblMaKhachHang);

		JLabel lblTnKhchHng_1 = new JLabel("Tên khách hàng:");
		lblTnKhchHng_1.setForeground(Color.BLACK);
		lblTnKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1.setBounds(543, 163, 164, 30);
		add(lblTnKhchHng_1);

		JLabel lblTenKhachHang = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBounds(772, 163, 358, 30);
		add(lblTenKhachHang);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(Color.BLACK);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSinThoi.setBounds(1085, 163, 127, 30);
		add(lblSinThoi);

		JLabel lblSoDienThoai = new JLabel("0123456789");
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(1258, 163, 127, 30);
		add(lblSoDienThoai);

		JLabel lblMXe = new JLabel("Mã xe:");
		lblMXe.setForeground(Color.BLACK);
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMXe.setBounds(29, 204, 86, 30);
		add(lblMXe);

		JLabel lblMaXe = new JLabel("KH123456");
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(182, 204, 127, 30);
		add(lblMaXe);

		JLabel lblTnKhchHng_1_1 = new JLabel("Tên xe:");
		lblTnKhchHng_1_1.setForeground(Color.BLACK);
		lblTnKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1_1.setBounds(543, 206, 86, 30);
		add(lblTnKhchHng_1_1);

		JLabel lblMaPhieuBaoHanh_1_1_1 = new JLabel("Honda Air Blade");
		lblMaPhieuBaoHanh_1_1_1.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh_1_1_1.setBounds(641, 206, 446, 30);
		add(lblMaPhieuBaoHanh_1_1_1);

		JLabel lblHng_1 = new JLabel("Hãng:");
		lblHng_1.setForeground(Color.BLACK);
		lblHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng_1.setBounds(1085, 206, 100, 30);
		add(lblHng_1);

		JLabel lblHonda = new JLabel("Honda");
		lblHonda.setForeground(Color.BLACK);
		lblHonda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHonda.setBounds(1204, 206, 127, 30);
		add(lblHonda);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên kỹ thuật:");
		lblMNhnVin.setForeground(Color.BLACK);
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMNhnVin.setBounds(29, 120, 231, 30);
		add(lblMNhnVin);

		JLabel lblKt = new JLabel("KT123456");
		lblKt.setForeground(Color.BLACK);
		lblKt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKt.setBounds(266, 120, 111, 30);
		add(lblKt);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên kỹ thuật:");
		lblTnNhnVin.setForeground(Color.BLACK);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnNhnVin.setBounds(543, 120, 217, 30);
		add(lblTnNhnVin);

		JLabel lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(772, 120, 325, 30);
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
	private void docDuLieuDatabaseVaoTable() {
		// TODO Auto-generated method stub
		modelBaoHanh.getDataVector().removeAllElements();
		
		
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
		if (o.equals(btnQuayLai)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_BaoHanh());
			this.validate();
			this.repaint();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
