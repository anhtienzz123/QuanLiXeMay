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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EventObject;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.HopDongDao;
import entity.HopDong;
import entity.XeMay;
import ui.App;

public class GD_BaoHanh extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnCapNhat;
	private DefaultTableModel modelBaoHanh;
	private JTable tblBaoHanh;
	private JButton btnXemChiTiet;
	private JButton btnQuayLai;

	private HopDongDao hopDongDao;
	private HopDong hopDong;
	private JLabel lblMaHopDong;

	/**
	 * Create the panel.
	 */
	public GD_BaoHanh(String maHopDong) {
		khoiTao();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bảo hành");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollpaneBaoHanh = new JScrollPane();
		scrollpaneBaoHanh.setBounds(29, 540, 1385, 182);
		add(scrollpaneBaoHanh);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet
				.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(951, 747, 218, 40);
		add(btnXemChiTiet);

		JLabel lblDanhSach = new JLabel("Danh sách các đợt bảo hành");
		lblDanhSach.setForeground(new Color(58, 181, 74));
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSach.setBounds(29, 474, 272, 30);
		add(lblDanhSach);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 512, 1385, 11);
		add(separator);

		btnCapNhat = new JButton("Thêm");
		btnCapNhat
				.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCapNhat.setBackground(new Color(58, 181, 74));
		btnCapNhat.setBounds(1204, 747, 203, 40);
		add(btnCapNhat);

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
		btnQuayLai.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/img/baseline_close_white_24dp.png")));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setBounds(29, 747, 164, 40);
		add(btnQuayLai);

		JLabel lblTTPBH = new JLabel("Thông tin phiếu bảo hành");
		lblTTPBH.setForeground(new Color(58, 181, 74));
		lblTTPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTTPBH.setBounds(29, 61, 272, 30);
		add(lblTTPBH);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(29, 104, 1385, 11);
		add(separator_1);

		JLabel lblTTKH = new JLabel("Thông tin khách hàng");
		lblTTKH.setForeground(new Color(58, 181, 74));
		lblTTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTTKH.setBounds(70, 181, 211, 30);
		add(lblTTKH);

		JLabel lblMHD = new JLabel("Mã hợp đồng:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBounds(70, 128, 188, 30);
		add(lblMHD);

		lblMaHopDong = new JLabel(maHopDong);
		lblMaHopDong.setForeground(Color.BLACK);
		lblMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHopDong.setBounds(270, 128, 111, 30);
		add(lblMaHopDong);

		JLabel lblNLHD = new JLabel("Ngày lập hợp đồng");
		lblNLHD.setForeground(Color.BLACK);
		lblNLHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNLHD.setBounds(745, 128, 188, 30);
		add(lblNLHD);

		hopDong = hopDongDao.getHopDongTheoMa(maHopDong);
		Date ngayLapHD = hopDong.getHoaDon().getNgayLap();
		JLabel lblNgay = new JLabel(simpleDateFormat.format(ngayLapHD));
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(946, 128, 111, 30);
		add(lblNgay);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(58, 181, 74));
		separator_1_1.setBounds(70, 224, 589, 11);
		add(separator_1_1);

		JLabel lblThngTinXe = new JLabel("Thông tin xe");
		lblThngTinXe.setForeground(new Color(58, 181, 74));
		lblThngTinXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinXe.setBounds(745, 181, 139, 30);
		add(lblThngTinXe);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(58, 181, 74));
		separator_1_1_1.setBounds(743, 224, 633, 11);
		add(separator_1_1_1);

		JLabel lblTnKhchHng = new JLabel("Mã khách hàng:");
		lblTnKhchHng.setForeground(Color.BLACK);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng.setBounds(70, 246, 164, 30);
		add(lblTnKhchHng);

		JLabel lblMaKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getMaKhachHang().trim());
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBounds(270, 246, 358, 30);
		add(lblMaKhachHang);

		JLabel lblTnKhchHng_1 = new JLabel("Tên khách hàng:");
		lblTnKhchHng_1.setForeground(Color.BLACK);
		lblTnKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1.setBounds(70, 300, 164, 30);
		add(lblTnKhchHng_1);

		JLabel lblTenKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getHoTenKH());
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBounds(270, 300, 358, 30);
		add(lblTenKhachHang);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(Color.BLACK);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSinThoi.setBounds(70, 358, 164, 30);
		add(lblSinThoi);

		JLabel lblSoDienThoai = new JLabel(hopDong.getHoaDon().getKhachHang().getSoDienThoai());
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(270, 358, 358, 30);
		add(lblSoDienThoai);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaCh.setBounds(70, 416, 86, 30);
		add(lblaCh);

		JLabel lblDiaChi = new JLabel(hopDong.getHoaDon().getKhachHang().getDiaChiKH());
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(161, 416, 467, 30);
		add(lblDiaChi);

		XeMay xeMay = hopDong.getXeMay();
		JLabel lblMXe = new JLabel("Mã xe:");
		lblMXe.setForeground(Color.BLACK);
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMXe.setBounds(743, 246, 86, 30);
		add(lblMXe);

		JLabel lblMaXe = new JLabel(xeMay.getMaXeMay());
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(837, 246, 127, 30);
		add(lblMaXe);

		JLabel lblSKhung = new JLabel("Số khung:");
		lblSKhung.setForeground(Color.BLACK);
		lblSKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSKhung.setBounds(743, 358, 100, 30);
		add(lblSKhung);

		JLabel lblSoKhung = new JLabel(xeMay.getSoKhung());
		lblSoKhung.setForeground(Color.BLACK);
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoKhung.setBounds(872, 358, 188, 30);
		add(lblSoKhung);

		JLabel lblSSn = new JLabel("Số sườn:");
		lblSSn.setForeground(Color.BLACK);
		lblSSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSSn.setBounds(743, 416, 86, 30);
		add(lblSSn);

		JLabel lblTnKhchHng_1_1 = new JLabel("Tên xe:");
		lblTnKhchHng_1_1.setForeground(Color.BLACK);
		lblTnKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1_1.setBounds(1048, 246, 86, 30);
		add(lblTnKhchHng_1_1);

		JLabel lblTenXe = new JLabel(xeMay.getTenXeMay());
		lblTenXe.setForeground(Color.BLACK);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(1152, 246, 358, 30);
		add(lblTenXe);

		JLabel lblSoSuon = new JLabel(xeMay.getSoSuon());
		lblSoSuon.setForeground(Color.BLACK);
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoSuon.setBounds(872, 416, 188, 30);
		add(lblSoSuon);

		JLabel lblHng = new JLabel("Xuất Xứ:");
		lblHng.setForeground(Color.BLACK);
		lblHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng.setBounds(743, 300, 100, 30);
		add(lblHng);

		JLabel lblHng_1 = new JLabel("Hãng:");
		lblHng_1.setForeground(Color.BLACK);
		lblHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng_1.setBounds(1048, 300, 100, 30);
		add(lblHng_1);

		JLabel lblXuatXu = new JLabel(xeMay.getXuatXu().getTenXuatXu());
		lblXuatXu.setForeground(Color.BLACK);
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXuatXu.setBounds(837, 300, 127, 30);
		add(lblXuatXu);

		JLabel lblHang = new JLabel(xeMay.getDongXe().getHangXe().getTenHangXe());
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBounds(1152, 300, 127, 30);
		add(lblHang);

		String[] colHeaderBaoHanh = { "STT", "Đợt bảo hành", "Thời gian", "Ghi chú" };
		modelBaoHanh = new DefaultTableModel(colHeaderBaoHanh, 0);
		tblBaoHanh = new JTable(modelBaoHanh) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		scrollpaneBaoHanh.setViewportView(tblBaoHanh);

		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblBaoHanh.setRowHeight(25);
		tblBaoHanh.getColumnModel().getColumn(0).setPreferredWidth(85);
		tblBaoHanh.getColumnModel().getColumn(1).setPreferredWidth(300);
		tblBaoHanh.getColumnModel().getColumn(2).setPreferredWidth(600);
		tblBaoHanh.getColumnModel().getColumn(3).setPreferredWidth(400);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblBaoHanh.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblBaoHanh.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblBaoHanh.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblBaoHanh.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		/**
		 * Tính đợt bào hành ngày
		 */
		Calendar calendar = GregorianCalendar.getInstance();
		List<Date> ngayBH = new ArrayList<Date>(Arrays.asList(ngayLapHD));
		for (int i = 1; i <= 6; i++) {
			calendar.setTime(ngayBH.get(ngayBH.size() - 1));
			calendar.add(GregorianCalendar.MONTH, 6);
			ngayBH.add(calendar.getTime());
		}
//		ngayBH.forEach(d -> {
//			System.out.println(simpleDateFormat.format(d));
//		});

		String tgBH;
		for (int i = 1; i < 7; i++) {
			if (i != 1) {
				calendar.setTime(ngayBH.get(i - 1));
				calendar.add(GregorianCalendar.DATE, 1);
				tgBH = "Từ ngày " + simpleDateFormat.format(calendar.getTime()) + " đến ngày "
						+ simpleDateFormat.format(ngayBH.get(i));
				modelBaoHanh.addRow(new Object[] { i, "Đợt " + i, tgBH, null });
			} else {
				tgBH = "Từ ngày " + simpleDateFormat.format(ngayBH.get(i - 1)) + " đến ngày "
						+ simpleDateFormat.format(ngayBH.get(i));
				modelBaoHanh.addRow(new Object[] { i, "Đợt " + i, tgBH, null });
			}
		}

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		dangKiSuKien();
		khoiTao();

	}

	private void khoiTao() {
		hopDongDao = HopDongDao.getInstance();
	}

	private void dangKiSuKien() {
		btnCapNhat.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnQuayLai.addActionListener(this);

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
			chuyenManHinh(new GD_QuanLyBaoHanh());
		}
		if (o.equals(btnCapNhat)) {
			themPhieuBaoHanh();
			
			
		}

		if (o.equals(btnXemChiTiet)) {
			xemChiTiet();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Chuyển màn hình
	 * @param newJpanel
	 */
	public void chuyenManHinh(JPanel newJpanel) {
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(newJpanel);
		this.validate();
		this.repaint();
	}

	/**
	 * Thêm phiếu bào hành
	 */
	private void themPhieuBaoHanh() {
		
		int row = tblBaoHanh.getSelectedRow();
		if(row != -1) {
			String dot = tblBaoHanh.getValueAt(row, 1).toString().trim().split(" ")[1];
			chuyenManHinh(new GD_CapNhatBaoHanh(lblMaHopDong.getText().trim(), dot));
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn đợt bảo hành");
		}
	}
	/**
	 * Xem chi tiết phiếu bảo hành
	 */
	private void xemChiTiet() {
		
		int row = tblBaoHanh.getSelectedRow();
		if(row != -1) {
			chuyenManHinh(new GD_ChiTietBaoHanh());
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn đợt bảo hành");
		}
	}
}
