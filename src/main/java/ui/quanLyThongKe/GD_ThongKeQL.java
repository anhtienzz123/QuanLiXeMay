package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ThongKeQuanLiDao;
import other.DinhDangTien;

public class GD_ThongKeQL extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblChiTietDTNgay;
	private JLabel lblChiTietDTThang;
	private JLabel lblChiTietDTNam;
	private JPanel pnlXemChiTietDTNgay;
	private JPanel pnlXemChiTietDTNam;
	private JPanel pnlXemChiTietDTThang;
	private JPanel pnlTK;

	private LocalDate localDate;
	private ThongKeQuanLiDao thongKeDao;
	private JLabel lblThongKeNgay;
	private JLabel lblThongKeNam;
	private JLabel lblThongKeThang;
	private JLabel lblXeBanNam;
	private JLabel lblXeBanNgay;
	private JLabel lblXeBanThang;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeQL() {

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JPanel pnlThongKeThang = new JPanel();
		pnlThongKeThang.setBackground(new Color(0, 150, 199));
		pnlThongKeThang.setBounds(649, 74, 500, 166);
		add(pnlThongKeThang);
		pnlThongKeThang.setLayout(null);

		JLabel lblTngThuTrong = new JLabel("Tổng thu trong tháng");
		lblTngThuTrong.setForeground(Color.WHITE);
		lblTngThuTrong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong.setBounds(12, 11, 317, 30);
		pnlThongKeThang.add(lblTngThuTrong);

		lblThongKeThang = new JLabel();
		lblThongKeThang.setForeground(Color.WHITE);
		lblThongKeThang.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeThang.setBounds(12, 30, 340, 69);
		pnlThongKeThang.add(lblThongKeThang);

		pnlXemChiTietDTThang = new JPanel();
		pnlXemChiTietDTThang.setBackground(new Color(0, 119, 182));
		pnlXemChiTietDTThang.setBounds(0, 131, 500, 35);
		pnlThongKeThang.add(pnlXemChiTietDTThang);
		pnlXemChiTietDTThang.setLayout(null);

		lblChiTietDTThang = new JLabel("Xem chi tiết ");
		lblChiTietDTThang.setHorizontalTextPosition(SwingConstants.LEADING);
		lblChiTietDTThang.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/next_page_26px.png")));
		lblChiTietDTThang.setBounds(0, 0, 500, 35);
		pnlXemChiTietDTThang.add(lblChiTietDTThang);
		lblChiTietDTThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDTThang.setForeground(Color.WHITE);
		lblChiTietDTThang.setFont(new Font("Tahoma", Font.ITALIC, 20));

		JLabel lblThongKeNgay_1_1 = new JLabel("");
		lblThongKeNgay_1_1.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/coins_100px.png")));
		lblThongKeNgay_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeNgay_1_1.setForeground(Color.WHITE);
		lblThongKeNgay_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay_1_1.setBounds(325, 11, 150, 107);
		pnlThongKeThang.add(lblThongKeNgay_1_1);

		JLabel lblTngThuTrong_3_1_1 = new JLabel("Số xe máy bán:");
		lblTngThuTrong_3_1_1.setForeground(Color.WHITE);
		lblTngThuTrong_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_3_1_1.setBounds(12, 88, 160, 30);
		pnlThongKeThang.add(lblTngThuTrong_3_1_1);

		lblXeBanThang = new JLabel("50 xe");
		lblXeBanThang.setForeground(Color.WHITE);
		lblXeBanThang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblXeBanThang.setBounds(184, 88, 160, 30);
		pnlThongKeThang.add(lblXeBanThang);

		JPanel pnlThongKeNgay = new JPanel();
		pnlThongKeNgay.setLayout(null);
		pnlThongKeNgay.setBackground(new Color(58, 181, 74));
		pnlThongKeNgay.setBounds(33, 74, 500, 166);
		add(pnlThongKeNgay);

		JLabel lblTngThuTrong_3 = new JLabel("Tổng thu trong ngày");
		lblTngThuTrong_3.setForeground(Color.WHITE);
		lblTngThuTrong_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_3.setBounds(12, 11, 317, 30);
		pnlThongKeNgay.add(lblTngThuTrong_3);

		lblThongKeNgay = new JLabel();
		lblThongKeNgay.setForeground(Color.WHITE);
		lblThongKeNgay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay.setBounds(12, 30, 317, 69);
		pnlThongKeNgay.add(lblThongKeNgay);

		pnlXemChiTietDTNgay = new JPanel();
		pnlXemChiTietDTNgay.setLayout(null);
		pnlXemChiTietDTNgay.setBackground(new Color(9, 161, 41));
		pnlXemChiTietDTNgay.setBounds(0, 131, 500, 35);
		pnlThongKeNgay.add(pnlXemChiTietDTNgay);

		lblChiTietDTNgay = new JLabel("Xem chi tiết ");
		lblChiTietDTNgay.setHorizontalTextPosition(SwingConstants.LEADING);
		lblChiTietDTNgay.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/next_page_26px.png")));
		lblChiTietDTNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDTNgay.setForeground(Color.WHITE);
		lblChiTietDTNgay.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblChiTietDTNgay.setBounds(0, 0, 500, 35);
		pnlXemChiTietDTNgay.add(lblChiTietDTNgay);

		JLabel lblThongKeNgay_1 = new JLabel("");
		lblThongKeNgay_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeNgay_1.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/expensive_price_100px.png")));
		lblThongKeNgay_1.setForeground(Color.WHITE);
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay_1.setBounds(325, 11, 150, 105);
		pnlThongKeNgay.add(lblThongKeNgay_1);

		JLabel lblTngThuTrong_3_1 = new JLabel("Số xe máy bán:");
		lblTngThuTrong_3_1.setForeground(Color.WHITE);
		lblTngThuTrong_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_3_1.setBounds(12, 88, 160, 30);
		pnlThongKeNgay.add(lblTngThuTrong_3_1);

		lblXeBanNgay = new JLabel("50 xe");
		lblXeBanNgay.setForeground(Color.WHITE);
		lblXeBanNgay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblXeBanNgay.setBounds(184, 88, 160, 30);
		pnlThongKeNgay.add(lblXeBanNgay);

		JPanel pnlThongKeNam = new JPanel();
		pnlThongKeNam.setLayout(null);
		pnlThongKeNam.setBackground(new Color(237, 197, 49));
		pnlThongKeNam.setBounds(1257, 74, 500, 166);
		add(pnlThongKeNam);

		JLabel lblTngThuTrong_1 = new JLabel("Tổng thu trong năm");
		lblTngThuTrong_1.setForeground(Color.WHITE);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_1.setBounds(12, 11, 317, 30);
		pnlThongKeNam.add(lblTngThuTrong_1);

		lblThongKeNam = new JLabel();
		lblThongKeNam.setForeground(Color.WHITE);
		lblThongKeNam.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNam.setBounds(12, 30, 348, 69);
		pnlThongKeNam.add(lblThongKeNam);

		pnlXemChiTietDTNam = new JPanel();
		pnlXemChiTietDTNam.setLayout(null);
		pnlXemChiTietDTNam.setBackground(new Color(201, 162, 39));
		pnlXemChiTietDTNam.setBounds(0, 131, 500, 35);
		pnlThongKeNam.add(pnlXemChiTietDTNam);

		lblChiTietDTNam = new JLabel("Xem chi tiết ");
		lblChiTietDTNam.setHorizontalTextPosition(SwingConstants.LEADING);
		lblChiTietDTNam.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/next_page_26px.png")));
		lblChiTietDTNam.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDTNam.setForeground(Color.WHITE);
		lblChiTietDTNam.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblChiTietDTNam.setBounds(0, 0, 500, 35);
		pnlXemChiTietDTNam.add(lblChiTietDTNam);

		JLabel lblThongKeNgay_1_1_1 = new JLabel("");
		lblThongKeNgay_1_1_1.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/sales_performance_100px.png")));
		lblThongKeNgay_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeNgay_1_1_1.setForeground(Color.WHITE);
		lblThongKeNgay_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay_1_1_1.setBounds(325, 11, 150, 107);
		pnlThongKeNam.add(lblThongKeNgay_1_1_1);

		JLabel lblTngThuTrong_3_1_2 = new JLabel("Số xe máy bán:");
		lblTngThuTrong_3_1_2.setForeground(Color.WHITE);
		lblTngThuTrong_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_3_1_2.setBounds(12, 88, 160, 30);
		pnlThongKeNam.add(lblTngThuTrong_3_1_2);

		lblXeBanNam = new JLabel(" 50 xe");
		lblXeBanNam.setForeground(Color.WHITE);
		lblXeBanNam.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblXeBanNam.setBounds(184, 88, 160, 30);
		pnlThongKeNam.add(lblXeBanNam);

		pnlTK = new JPanel();
		pnlTK.setBounds(33, 244, 1724, 766);
		add(pnlTK);
		pnlTK.setLayout(new BoxLayout(pnlTK, BoxLayout.X_AXIS));
		pnlTK.add(new GD_ThongKeNgayQL());

		khoiTao();
		dangKiSuKien();

	}

	public void dangKiSuKien() {
		lblChiTietDTNam.addMouseListener(this);
		lblChiTietDTNgay.addMouseListener(this);
		lblChiTietDTThang.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblChiTietDTNgay)) {
			pnlTK.removeAll();
			pnlTK.setLayout(new BorderLayout());
			pnlTK.add(new GD_ThongKeNgayQL());
			pnlTK.validate();
			pnlTK.repaint();
		}
		if (o.equals(lblChiTietDTThang)) {
			pnlTK.removeAll();
			pnlTK.setLayout(new BorderLayout());
			pnlTK.add(new GD_ThongKeThangQL());
			pnlTK.validate();
			pnlTK.repaint();
		}
		if (o.equals(lblChiTietDTNam)) {
			pnlTK.removeAll();
			pnlTK.setLayout(new BorderLayout());
			pnlTK.add(new GD_ThongKeNamQL());
			pnlTK.validate();
			pnlTK.repaint();
		}

	}

	private void khoiTao() {
		localDate = LocalDate.now();

		thongKeDao = ThongKeQuanLiDao.getInstance();
		Double ngay = thongKeDao.getDoanhThuTheoNgay(localDate.getDayOfMonth(), localDate.getMonthValue(),
				localDate.getYear());
		Double thang = thongKeDao.getDoanhThuTheoThang(localDate.getMonthValue(), localDate.getYear());
		Double nam = thongKeDao.getDoanhThuTheoNam(localDate.getYear());

		lblThongKeNgay.setText(DinhDangTien.format(ngay));
		lblThongKeThang.setText(DinhDangTien.format(thang));
		lblThongKeNam.setText(DinhDangTien.format(nam));
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
		Object o = e.getSource();
		if (o.equals(lblChiTietDTNgay)) {
			pnlXemChiTietDTNgay.setBackground(Color.LIGHT_GRAY);
		}
		if (o.equals(lblChiTietDTThang)) {
			pnlXemChiTietDTThang.setBackground(Color.LIGHT_GRAY);
		}
		if (o.equals(lblChiTietDTNam)) {
			pnlXemChiTietDTNam.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblChiTietDTNgay)) {
			pnlXemChiTietDTNgay.setBackground(new Color(9, 161, 41));
		}
		if (o.equals(lblChiTietDTThang)) {
			pnlXemChiTietDTThang.setBackground(new Color(0, 119, 182));
		}
		if (o.equals(lblChiTietDTNam)) {
			pnlXemChiTietDTNam.setBackground(new Color(201, 162, 39));
		}

	}

}
