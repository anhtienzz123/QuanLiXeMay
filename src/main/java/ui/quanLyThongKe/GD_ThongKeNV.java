package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import dao.ThongKeNhanVienDao;
import dao.ThongKeQuanLiDao;
import other.DinhDangTien;
import other.ThongTinNguoiDung;

public class GD_ThongKeNV extends JPanel implements MouseListener {

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

	private LocalDate localDate;
	private ThongKeQuanLiDao thongKeDao;
	private JLabel lblThongKeNgay;
	private JLabel lblThongKeNam;
	private JLabel lblThongKeThang;
	private JLabel lblXeBanNam;
	private JLabel lblXeBanNgay;
	private JLabel lblXeBanThang;
	private JLabel lblTongTienNgay;
	private JLabel lblXeNgay;
	private JLabel lblHDNgay;
	private JLabel lblTenNV;
	private JLabel lblMaNV;
	private JLabel lblHDThang;
	private JLabel lblXeThang;
	private JLabel lblTongTienThang;
	private JLabel lblTongTienNam;
	private JLabel lblXeNam;
	private JLabel lblHDNam;
	private JLabel lblTonKho;

	private ThongKeNhanVienDao thongKeNhanVienDao;
	private String maNhanVienHanhChinh;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNV() {

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
		lblThongKeNgay_1_1_1
				.setIcon(new ImageIcon(GD_ThongKeQL.class.getResource("/icon/sales_performance_100px.png")));
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

		JLabel lblNgay = new JLabel("Ngày 8-12-2020");
		lblNgay.setForeground(new Color(58, 181, 74));
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgay.setBounds(33, 277, 186, 30);
		add(lblNgay);

		JLabel lblThng_1 = new JLabel("Tháng 12-2020");
		lblThng_1.setForeground(new Color(58, 181, 74));
		lblThng_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThng_1.setBounds(649, 277, 186, 30);
		add(lblThng_1);

		JLabel lblThng = new JLabel("Năm 2020");
		lblThng.setForeground(new Color(58, 181, 74));
		lblThng.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThng.setBounds(1257, 277, 186, 30);
		add(lblThng);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(33, 314, 500, 30);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(649, 314, 500, 30);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(58, 181, 74));
		separator_2.setBounds(1257, 314, 500, 30);
		add(separator_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(58, 181, 74)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(33, 335, 500, 631);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setBounds(12, 32, 186, 30);
		panel_1.add(lblMNhnVin);
		lblMNhnVin.setForeground(new Color(58, 181, 74));
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblTnNhnVin = new JLabel("Tên Nhân viên:");
		lblTnNhnVin.setBounds(12, 85, 186, 30);
		panel_1.add(lblTnNhnVin);
		lblTnNhnVin.setForeground(new Color(58, 181, 74));
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblSHan = new JLabel("Số hóa đơn đã lập:");
		lblSHan.setBounds(12, 140, 211, 30);
		panel_1.add(lblSHan);
		lblSHan.setForeground(new Color(58, 181, 74));
		lblSHan.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblSXeBn = new JLabel("Số xe bán ra:");
		lblSXeBn.setBounds(12, 201, 139, 30);
		panel_1.add(lblSXeBn);
		lblSXeBn.setForeground(new Color(58, 181, 74));
		lblSXeBn.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblTngwrTin = new JLabel("Tổng tiền:");
		lblTngwrTin.setBounds(12, 260, 120, 30);
		panel_1.add(lblTngwrTin);
		lblTngwrTin.setForeground(new Color(58, 181, 74));
		lblTngwrTin.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblMaNV = new JLabel("NV180556");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(210, 32, 278, 30);
		panel_1.add(lblMaNV);

		lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(210, 85, 278, 30);
		panel_1.add(lblTenNV);

		lblHDNgay = new JLabel("20 hóa đơn.");
		lblHDNgay.setForeground(Color.BLACK);
		lblHDNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHDNgay.setBounds(210, 140, 278, 30);
		panel_1.add(lblHDNgay);

		lblXeNgay = new JLabel("30 xe.");
		lblXeNgay.setForeground(Color.BLACK);
		lblXeNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXeNgay.setBounds(210, 201, 278, 30);
		panel_1.add(lblXeNgay);

		lblTongTienNgay = new JLabel("1.200.000.000.000 VNĐ");
		lblTongTienNgay.setForeground(Color.BLACK);
		lblTongTienNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongTienNgay.setBounds(210, 260, 278, 30);
		panel_1.add(lblTongTienNgay);

		JLabel lblSXeTn = new JLabel("Số xe tồn kho:");
		lblSXeTn.setForeground(new Color(58, 181, 74));
		lblSXeTn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSXeTn.setBounds(12, 314, 174, 30);
		panel_1.add(lblSXeTn);

		lblTonKho = new JLabel("30 xe.");
		lblTonKho.setForeground(Color.BLACK);
		lblTonKho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTonKho.setBounds(210, 314, 278, 30);
		panel_1.add(lblTonKho);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(58, 181, 74)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(649, 335, 500, 631);
		add(panel_1_1);

		JLabel lblSHan_1 = new JLabel("Số hóa đơn đã lập:");
		lblSHan_1.setForeground(new Color(58, 181, 74));
		lblSHan_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSHan_1.setBounds(12, 32, 211, 30);
		panel_1_1.add(lblSHan_1);

		JLabel lblSXeBn_1 = new JLabel("Số xe bán ra:");
		lblSXeBn_1.setForeground(new Color(58, 181, 74));
		lblSXeBn_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSXeBn_1.setBounds(12, 85, 139, 30);
		panel_1_1.add(lblSXeBn_1);

		JLabel lblTngwrTin_1 = new JLabel("Tổng tiền:");
		lblTngwrTin_1.setForeground(new Color(58, 181, 74));
		lblTngwrTin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngwrTin_1.setBounds(12, 140, 120, 30);
		panel_1_1.add(lblTngwrTin_1);

		lblHDThang = new JLabel("20 hóa đơn.");
		lblHDThang.setForeground(Color.BLACK);
		lblHDThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHDThang.setBounds(210, 32, 278, 30);
		panel_1_1.add(lblHDThang);

		lblXeThang = new JLabel("30 xe.");
		lblXeThang.setForeground(Color.BLACK);
		lblXeThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXeThang.setBounds(210, 85, 278, 30);
		panel_1_1.add(lblXeThang);

		lblTongTienThang = new JLabel("1.200.000.000.000 VNĐ");
		lblTongTienThang.setForeground(Color.BLACK);
		lblTongTienThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongTienThang.setBounds(144, 140, 344, 30);
		panel_1_1.add(lblTongTienThang);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(58, 181, 74)));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(1257, 335, 500, 631);
		add(panel_1_1_1);

		JLabel lblSHan_1_1 = new JLabel("Số hóa đơn đã lập:");
		lblSHan_1_1.setForeground(new Color(58, 181, 74));
		lblSHan_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSHan_1_1.setBounds(12, 32, 211, 30);
		panel_1_1_1.add(lblSHan_1_1);

		JLabel lblSXeBn_1_1 = new JLabel("Số xe bán ra:");
		lblSXeBn_1_1.setForeground(new Color(58, 181, 74));
		lblSXeBn_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSXeBn_1_1.setBounds(12, 85, 139, 30);
		panel_1_1_1.add(lblSXeBn_1_1);

		JLabel lblTngwrTin_1_1 = new JLabel("Tổng tiền:");
		lblTngwrTin_1_1.setForeground(new Color(58, 181, 74));
		lblTngwrTin_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngwrTin_1_1.setBounds(12, 140, 120, 30);
		panel_1_1_1.add(lblTngwrTin_1_1);

		lblHDNam = new JLabel("20 hóa đơn.");
		lblHDNam.setForeground(Color.BLACK);
		lblHDNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHDNam.setBounds(210, 32, 278, 30);
		panel_1_1_1.add(lblHDNam);

		lblXeNam = new JLabel("30 xe.");
		lblXeNam.setForeground(Color.BLACK);
		lblXeNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXeNam.setBounds(210, 85, 278, 30);
		panel_1_1_1.add(lblXeNam);

		lblTongTienNam = new JLabel("1.200.000.000.000 VNĐ");
		lblTongTienNam.setForeground(Color.BLACK);
		lblTongTienNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongTienNam.setBounds(144, 140, 344, 30);
		panel_1_1_1.add(lblTongTienNam);

		khoiTao();
		dangKiSuKien();

		hienThiThongTinThongKe();

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
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_ThongKeNgayNV());
			this.validate();
			this.repaint();
		}
		if (o.equals(lblChiTietDTThang)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_ThongKeThangNV());
			this.validate();
			this.repaint();
		}
		if (o.equals(lblChiTietDTNam)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_ThongKeNamNV());
			this.validate();
			this.repaint();
		}

	}

	private void khoiTao() {

		thongKeNhanVienDao = ThongKeNhanVienDao.getInstance();
		this.maNhanVienHanhChinh = ThongTinNguoiDung.nhanVienHanhChinh.getMaNVHanhChinh();

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

	private void hienThiThongTinThongKe() {

		hienThiThongKeNgay();
		hienThiThongKeThang();
		hienThiThongKeNam();
	}

	private void hienThiThongKeNgay() {
		String tenNhanVien = ThongTinNguoiDung.nhanVienHanhChinh.getHoTenNV();
		lblMaNV.setText(maNhanVienHanhChinh);
		lblTenNV.setText(tenNhanVien);

		double doanhThuNgay = thongKeNhanVienDao.getDoanhThuTheoNgay(maNhanVienHanhChinh, localDate.getDayOfMonth(),
				localDate.getMonthValue(), localDate.getYear());
		long soXeBanTrongNgay = thongKeNhanVienDao.getSoLuongXeTheoNgay(maNhanVienHanhChinh, localDate.getDayOfMonth(),
				localDate.getMonthValue(), localDate.getYear());
		long hoaDonLaps = thongKeNhanVienDao.getHoaDonLapTheoNgay(maNhanVienHanhChinh, localDate.getDayOfMonth(),
				localDate.getMonthValue(), localDate.getYear());
		long soLuongTon = thongKeNhanVienDao.getSoLuongTon();

		lblThongKeNgay.setText(DinhDangTien.format(doanhThuNgay));
		lblTongTienNgay.setText(DinhDangTien.format(doanhThuNgay));
		lblHDNgay.setText(hoaDonLaps + "");
		lblXeBanNgay.setText(soXeBanTrongNgay + "");
		lblXeNgay.setText(soXeBanTrongNgay + "");
		
		lblTonKho.setText(soLuongTon+"");
		

	}

	private void hienThiThongKeThang() {
		double doanhThuThang = thongKeNhanVienDao.getDoanhThuTheoThang(maNhanVienHanhChinh, localDate.getMonthValue(),
				localDate.getYear());
		long soXeBanTrongThang = thongKeNhanVienDao.getSoLuongXeTheoThang(maNhanVienHanhChinh, 
				localDate.getMonthValue(), localDate.getYear());
		long hoaDonLapsTrongThang = thongKeNhanVienDao.getHoaDonLapTheoThang(maNhanVienHanhChinh, 
				localDate.getMonthValue(), localDate.getYear());

		lblThongKeThang.setText(DinhDangTien.format(doanhThuThang));
		lblTongTienThang.setText(DinhDangTien.format(doanhThuThang));
		lblHDThang.setText(hoaDonLapsTrongThang + "");
		lblXeBanThang.setText(soXeBanTrongThang + "");
		lblXeThang.setText(soXeBanTrongThang + "");
	}

	private void hienThiThongKeNam() {
		double doanhThuNam = thongKeNhanVienDao.getDoanhThuTheoNgay(maNhanVienHanhChinh, localDate.getDayOfMonth(),
				localDate.getMonthValue(), localDate.getYear());
		long soXeBanTrongNam = thongKeNhanVienDao.getSoLuongXeTheoNgay(maNhanVienHanhChinh, localDate.getDayOfMonth(),
				localDate.getMonthValue(), localDate.getYear());
		long hoaDonLapsTrongNam = thongKeNhanVienDao.getHoaDonLapTheoNgay(maNhanVienHanhChinh, localDate.getDayOfMonth(),
				localDate.getMonthValue(), localDate.getYear());

		lblThongKeNam.setText(DinhDangTien.format(doanhThuNam));
		lblTongTienNam.setText(DinhDangTien.format(doanhThuNam));
		lblHDNam.setText(hoaDonLapsTrongNam + "");
		lblXeBanNam.setText(soXeBanTrongNam + "");
		lblXeNam.setText(soXeBanTrongNam + "");
	}
	
	// Thong ke hoa don Lap trong ngay

}
