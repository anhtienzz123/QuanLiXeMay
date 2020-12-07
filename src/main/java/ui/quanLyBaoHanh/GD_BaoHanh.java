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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
import dao.PhieuBaoHanhDao;
import entity.HopDong;
import entity.PhieuBaoHanh;
import entity.XeMay;
import ui.App;

public class GD_BaoHanh extends JPanel implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnCapNhat;
	private JButton btnXemChiTiet;
	private JButton btnQuayLai;

	private DefaultTableModel modelBaoHanh;
	private JTable tblBaoHanh;

	private HopDong hopDong;
	private JLabel lblMaHopDong;

	private HopDongDao hopDongDao;
	private PhieuBaoHanhDao phieuBaoHanhDao;

	private Date ngayLapHD;
	private SimpleDateFormat simpleDateFormat;
	private int dotBaoHanh;

	/**
	 * Create the panel.
	 */
	public GD_BaoHanh(String maHopDong) {
		khoiTao();
		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bảo hành");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollpaneBaoHanh = new JScrollPane();
		scrollpaneBaoHanh.setBounds(29, 548, 1726, 243);
		add(scrollpaneBaoHanh);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet
				.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/icon/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(1281, 814, 218, 40);
		add(btnXemChiTiet);

		JLabel lblDanhSach = new JLabel("Danh sách các đợt bảo hành");
		lblDanhSach.setForeground(new Color(58, 181, 74));
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSach.setBounds(29, 474, 272, 30);
		add(lblDanhSach);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 512, 1726, 11);
		add(separator);

		btnCapNhat = new JButton("Thêm");
		btnCapNhat
				.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/icon/baseline_create_new_folder_white_18dp.png")));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCapNhat.setBackground(new Color(58, 181, 74));
		btnCapNhat.setBounds(1552, 814, 203, 40);
		add(btnCapNhat);

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
		btnQuayLai.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setBounds(29, 814, 164, 40);
		add(btnQuayLai);

		JLabel lblTTPBH = new JLabel("Thông tin phiếu bảo hành");
		lblTTPBH.setForeground(new Color(58, 181, 74));
		lblTTPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTTPBH.setBounds(29, 61, 272, 30);
		add(lblTTPBH);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(29, 104, 1726, 11);
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
		lblNLHD.setBounds(937, 128, 188, 30);
		add(lblNLHD);

		hopDong = hopDongDao.getHopDongTheoMa(maHopDong);
		ngayLapHD = hopDong.getHoaDon().getNgayLap();
		JLabel lblNgay = new JLabel(simpleDateFormat.format(ngayLapHD));
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(1138, 128, 111, 30);
		add(lblNgay);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(58, 181, 74));
		separator_1_1.setBounds(70, 224, 683, 11);
		add(separator_1_1);

		JLabel lblThngTinXe = new JLabel("Thông tin xe");
		lblThngTinXe.setForeground(new Color(58, 181, 74));
		lblThngTinXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinXe.setBounds(937, 181, 139, 30);
		add(lblThngTinXe);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(58, 181, 74));
		separator_1_1_1.setBounds(935, 224, 820, 11);
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
		lblTenKhachHang.setBounds(270, 300, 483, 30);
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

		JLabel lblDiaChi = new JLabel("<html>" + hopDong.getHoaDon().getKhachHang().getDiaChiKH() + "</html>");
		lblDiaChi.setVerticalAlignment(SwingConstants.TOP);
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(270, 416, 483, 59);
		add(lblDiaChi);

		XeMay xeMay = hopDong.getXeMay();
		JLabel lblMXe = new JLabel("Mã xe:");
		lblMXe.setForeground(Color.BLACK);
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMXe.setBounds(935, 246, 86, 30);
		add(lblMXe);

		JLabel lblMaXe = new JLabel(xeMay.getMaXeMay());
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(1047, 246, 127, 30);
		add(lblMaXe);

		JLabel lblSKhung = new JLabel("Số khung:");
		lblSKhung.setForeground(Color.BLACK);
		lblSKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSKhung.setBounds(935, 358, 100, 30);
		add(lblSKhung);

		JLabel lblSoKhung = new JLabel(xeMay.getSoKhung());
		lblSoKhung.setForeground(Color.BLACK);
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoKhung.setBounds(1047, 358, 188, 30);
		add(lblSoKhung);

		JLabel lblSSn = new JLabel("Số sườn:");
		lblSSn.setForeground(Color.BLACK);
		lblSSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSSn.setBounds(935, 416, 86, 30);
		add(lblSSn);

		JLabel lblTnKhchHng_1_1 = new JLabel("Tên xe:");
		lblTnKhchHng_1_1.setForeground(Color.BLACK);
		lblTnKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1_1.setBounds(1240, 246, 86, 30);
		add(lblTnKhchHng_1_1);

		JLabel lblTenXe = new JLabel("<html>" + xeMay.getTenXeMay() + "</html>");
		lblTenXe.setVerticalAlignment(SwingConstants.TOP);
		lblTenXe.setForeground(Color.BLACK);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(1344, 246, 411, 61);
		add(lblTenXe);

		JLabel lblSoSuon = new JLabel(xeMay.getSoSuon());
		lblSoSuon.setForeground(Color.BLACK);
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoSuon.setBounds(1047, 416, 188, 30);
		add(lblSoSuon);

		JLabel lblHng = new JLabel("Xuất Xứ:");
		lblHng.setForeground(Color.BLACK);
		lblHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng.setBounds(935, 300, 100, 30);
		add(lblHng);

		JLabel lblHng_1 = new JLabel("Hãng:");
		lblHng_1.setForeground(Color.BLACK);
		lblHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng_1.setBounds(1240, 300, 100, 30);
		add(lblHng_1);

		JLabel lblXuatXu = new JLabel(xeMay.getXuatXu().getTenXuatXu());
		lblXuatXu.setForeground(Color.BLACK);
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXuatXu.setBounds(1047, 300, 127, 30);
		add(lblXuatXu);

		JLabel lblHang = new JLabel(xeMay.getDongXe().getHangXe().getTenHangXe());
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBounds(1344, 300, 127, 30);
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
		tblBaoHanh.setRowHeight(35);
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
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		dangKiSuKien();
		khoiTao();

		capNhatBangBaoHanh();

	}

	/**
	 * Khởi tạo DAO
	 */
	private void khoiTao() {
		hopDongDao = HopDongDao.getInstance();
		phieuBaoHanhDao = PhieuBaoHanhDao.getInstance();
	}

	/**
	 * Đăng kí sự kiện
	 */
	private void dangKiSuKien() {
		btnCapNhat.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnQuayLai.addActionListener(this);
	}

	/**
	 * Cập nhật bảng bảo hành
	 */
	private void capNhatBangBaoHanh() {
		/**
		 * Tính thời gian của các đợt bảo hành
		 */
		Calendar calendar = GregorianCalendar.getInstance();
		System.out.println();
		List<Date> ngayBH = new ArrayList<Date>(Arrays.asList(ngayLapHD));
		for (int i = 1; i <= 6; i++) {
			calendar.setTime(ngayBH.get(ngayBH.size() - 1));
			calendar.add(GregorianCalendar.MONTH, 6);
			ngayBH.add(calendar.getTime());
		}

		/**
		 * Ghi các đợt bảo hành vào bảng
		 */
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
		 * Thêm ghi chú các đợt đã lập phiếu bảo hành vào bảng
		 */
		List<PhieuBaoHanh> phieuBaoHanhs = phieuBaoHanhDao.getPhieuBaoHanhTheoMaHopDong(lblMaHopDong.getText().trim());
		if (phieuBaoHanhs.size() > 0) {
			for (int i = 0; i < 6; i++) {
				for (PhieuBaoHanh phieuBaoHanh : phieuBaoHanhs) {

					try {
						String[] temp = tblBaoHanh.getValueAt(i, 2).toString().trim().split(" ");
						Date before = simpleDateFormat.parse(temp[5]);
						Date after = simpleDateFormat.parse(temp[2]);
						Date date = simpleDateFormat.parse(simpleDateFormat.format(phieuBaoHanh.getNgayBaoHanh()));
						if (date.before(before) && date.after(after) || date.equals(before) || date.equals(after)) {
							tblBaoHanh.setValueAt(
									"Bảo hành ngày " + simpleDateFormat.format(phieuBaoHanh.getNgayBaoHanh()) + "_"
											+ phieuBaoHanh.getMaPhieuBaoHanh(),
									i, 3);
						}
						/**
						 * Kiểm tra đợt bảo hành của ngày hiện tại
						 */
						Date currentDay = Calendar.getInstance().getTime();
						if (currentDay.before(before) && currentDay.after(after) || currentDay.equals(before)
								|| currentDay.equals(after)) {
							dotBaoHanh = i;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

	}

	/**
	 * Chuyển màn hình
	 * 
	 * @param newJpanel
	 */
	private void chuyenManHinh(JPanel newJpanel) {
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(newJpanel);
		this.validate();
		this.repaint();
	}

	/**
	 * Thêm phiếu bảo hành
	 */
	private void themPhieuBaoHanh() {

		try {
			String[] temp = tblBaoHanh.getValueAt(5, 2).toString().trim().split(" ");
			Date after = simpleDateFormat.parse(temp[5]);
			Date currentDay = Calendar.getInstance().getTime();
			System.out.println(dotBaoHanh);

			if (currentDay.before(after) || currentDay.equals(after)) {
				if (tblBaoHanh.getValueAt(dotBaoHanh, 3) == null) {
					String dot = tblBaoHanh.getValueAt(dotBaoHanh, 1).toString().trim().split(" ")[1];
					chuyenManHinh(new GD_CapNhatBaoHanh(lblMaHopDong.getText().trim(), dot));
				} else {
					JOptionPane.showMessageDialog(this, "Đợt " + (dotBaoHanh + 1) + " đã lập phiếu bảo hành");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Đã hết thời gian bảo hành");
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Xem chi tiết phiếu bảo hành
	 */
	private void xemChiTiet() {

		int row = tblBaoHanh.getSelectedRow();
		if (row != -1) {
			if (tblBaoHanh.getValueAt(row, 3) != null) {
				String maHopDong = lblMaHopDong.getText().trim();
				String maPhieuBaoHanh = tblBaoHanh.getValueAt(row, 3).toString().split("_")[1].trim();
				String dot = tblBaoHanh.getValueAt(row, 0).toString().trim();
				chuyenManHinh(new GD_ChiTietBaoHanh(maHopDong, maPhieuBaoHanh, dot));
			} else {
				JOptionPane.showMessageDialog(this,
						"Đợt " + tblBaoHanh.getValueAt(row, 0).toString() + " chưa lập phiếu bảo hành");
			}

		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn đợt bảo hành");
		}
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

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
