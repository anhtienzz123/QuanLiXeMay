package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.DatabaseConnect;

public class App extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIconDanhMuc;
	public JPanel pnlMenu;
	private JLabel lblDangXuat;
	private JLabel lblDanhMuc;
	private JLabel lblThongKe;
	private JLabel lblXeMay;
	private JLabel lblHoaDon;
	private JLabel lblHopDong;
	private JLabel lblKhachHang;
	private JLabel lblNhanVien;
	private JLabel lblTrangChu;
	private JLabel lblIconDangXuat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new App("NV180556").setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public App(String maNhanVien) {
		try {
			DatabaseConnect.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/img/motorbike_helmet_100px.png")));
		setTitle("Quản Lý mua bán xe máy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 1000);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		Box vB = Box.createVerticalBox();
		contentPane.add(vB);

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_1.setBackground(new Color(58, 181, 74));
		panel_1.setPreferredSize(new Dimension(1600, 70));
		panel_1.setMaximumSize(new Dimension(32767, 70));
		vB.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.setVisible(false);

		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg")));
		lblNewLabel.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(panel_1.getPreferredSize().width - 500,
								panel_1.getPreferredSize().height, Image.SCALE_DEFAULT)));
		panel_1.add(lblNewLabel);

		Box hB2 = Box.createHorizontalBox();
		vB.add(hB2);

		pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(58, 181, 74));
		pnlMenu.setPreferredSize(new Dimension(120, 900));
		pnlMenu.setMaximumSize(new Dimension(120, 32767));
		hB2.add(pnlMenu);
		pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.X_AXIS));

		Box vB1 = Box.createVerticalBox();
		pnlMenu.add(vB1);

		JPanel pnlDanhMuc = new JPanel();
		pnlDanhMuc.setBackground(new Color(58, 181, 74));
		pnlDanhMuc.setPreferredSize(new Dimension(300, 70));
		pnlDanhMuc.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlDanhMuc);
		pnlDanhMuc.setLayout(new BoxLayout(pnlDanhMuc, BoxLayout.X_AXIS));

		lblIconDanhMuc = new JLabel("");
		lblIconDanhMuc.setMinimumSize(new Dimension(120, 70));
		lblIconDanhMuc.setIcon(new ImageIcon(App.class.getResource("/img/menu_50px.png")));
		lblIconDanhMuc.setPreferredSize(new Dimension(120, 70));
		lblIconDanhMuc.setMaximumSize(new Dimension(120, 70));
		lblIconDanhMuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDanhMuc.setForeground(Color.WHITE);
		lblIconDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlDanhMuc.add(lblIconDanhMuc);

		lblDanhMuc = new JLabel("");
		lblDanhMuc.setMinimumSize(new Dimension(180, 70));
		lblDanhMuc.setForeground(Color.WHITE);
		lblDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhMuc.setMaximumSize(new Dimension(180, 70));
		lblDanhMuc.setPreferredSize(new Dimension(180, 70));
		pnlDanhMuc.add(lblDanhMuc);

		JPanel pnlTrangChu = new JPanel();
		pnlTrangChu.setBackground(new Color(58, 181, 74));
		pnlTrangChu.setPreferredSize(new Dimension(300, 70));
		pnlTrangChu.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlTrangChu);
		pnlTrangChu.setLayout(new BoxLayout(pnlTrangChu, BoxLayout.X_AXIS));

		JLabel lblIconTrangChu = new JLabel("");
		lblIconTrangChu.setMinimumSize(new Dimension(120, 70));
		lblIconTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTrangChu.setIcon(new ImageIcon(App.class.getResource("/img/home_page_50px.png")));
		lblIconTrangChu.setPreferredSize(new Dimension(120, 70));
		lblIconTrangChu.setMaximumSize(new Dimension(120, 70));
		lblIconTrangChu.setForeground(Color.WHITE);
		lblIconTrangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlTrangChu.add(lblIconTrangChu);

		lblTrangChu = new JLabel("Trang chủ");
		lblTrangChu.setMinimumSize(new Dimension(180, 70));
		lblTrangChu.setPreferredSize(new Dimension(180, 70));
		lblTrangChu.setMaximumSize(new Dimension(180, 70));
		lblTrangChu.setForeground(Color.WHITE);
		lblTrangChu.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlTrangChu.add(lblTrangChu);

		JPanel pnlXeMay = new JPanel();
		pnlXeMay.setBackground(new Color(58, 181, 74));
		pnlXeMay.setPreferredSize(new Dimension(300, 70));
		pnlXeMay.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlXeMay);
		pnlXeMay.setLayout(new BoxLayout(pnlXeMay, BoxLayout.X_AXIS));

		JLabel lblIconXeMay = new JLabel("");
		lblIconXeMay.setMinimumSize(new Dimension(120, 70));
		lblIconXeMay.setIcon(new ImageIcon(App.class.getResource("/img/motorcycle_50px.png")));
		lblIconXeMay.setPreferredSize(new Dimension(120, 70));
		lblIconXeMay.setMaximumSize(new Dimension(120, 70));
		lblIconXeMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconXeMay.setForeground(Color.WHITE);
		lblIconXeMay.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlXeMay.add(lblIconXeMay);

		lblXeMay = new JLabel("Xe máy");
		lblXeMay.setMinimumSize(new Dimension(180, 70));
		lblXeMay.setPreferredSize(new Dimension(180, 70));
		lblXeMay.setMaximumSize(new Dimension(180, 70));
		lblXeMay.setForeground(Color.WHITE);
		lblXeMay.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlXeMay.add(lblXeMay);

		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(new Color(58, 181, 74));
		pnlHoaDon.setPreferredSize(new Dimension(300, 70));
		pnlHoaDon.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlHoaDon);
		pnlHoaDon.setLayout(new BoxLayout(pnlHoaDon, BoxLayout.X_AXIS));

		JLabel lblIconHoaDon = new JLabel("");
		lblIconHoaDon.setMinimumSize(new Dimension(120, 70));
		lblIconHoaDon.setIcon(new ImageIcon(App.class.getResource("/img/bill_50px.png")));
		lblIconHoaDon.setPreferredSize(new Dimension(120, 70));
		lblIconHoaDon.setMaximumSize(new Dimension(120, 70));
		lblIconHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHoaDon.setForeground(Color.WHITE);
		lblIconHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlHoaDon.add(lblIconHoaDon);

		lblHoaDon = new JLabel("Hóa đơn");
		lblHoaDon.setMinimumSize(new Dimension(180, 70));
		lblHoaDon.setPreferredSize(new Dimension(180, 70));
		lblHoaDon.setMaximumSize(new Dimension(180, 70));
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlHoaDon.add(lblHoaDon);

		JPanel pnlHopDong = new JPanel();
		pnlHopDong.setBackground(new Color(58, 181, 74));
		pnlHopDong.setPreferredSize(new Dimension(300, 70));
		pnlHopDong.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlHopDong);
		pnlHopDong.setLayout(new BoxLayout(pnlHopDong, BoxLayout.X_AXIS));

		JLabel lblIconHopDong = new JLabel("");
		lblIconHopDong.setMinimumSize(new Dimension(120, 70));
		lblIconHopDong.setIcon(new ImageIcon(App.class.getResource("/img/handshake_50px.png")));
		lblIconHopDong.setPreferredSize(new Dimension(120, 70));
		lblIconHopDong.setMaximumSize(new Dimension(120, 70));
		lblIconHopDong.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHopDong.setForeground(Color.WHITE);
		lblIconHopDong.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlHopDong.add(lblIconHopDong);

		lblHopDong = new JLabel("Hợp đồng");
		lblHopDong.setMinimumSize(new Dimension(180, 70));
		lblHopDong.setPreferredSize(new Dimension(180, 70));
		lblHopDong.setMaximumSize(new Dimension(180, 70));
		lblHopDong.setForeground(Color.WHITE);
		lblHopDong.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlHopDong.add(lblHopDong);

		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setBackground(new Color(58, 181, 74));
		pnlKhachHang.setPreferredSize(new Dimension(300, 70));
		pnlKhachHang.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlKhachHang);
		pnlKhachHang.setLayout(new BoxLayout(pnlKhachHang, BoxLayout.X_AXIS));

		JLabel lblIconKhachHang = new JLabel("");
		lblIconKhachHang.setMinimumSize(new Dimension(120, 70));
		lblIconKhachHang.setIcon(new ImageIcon(App.class.getResource("/img/member_50px.png")));
		lblIconKhachHang.setPreferredSize(new Dimension(120, 70));
		lblIconKhachHang.setMaximumSize(new Dimension(120, 70));
		lblIconKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKhachHang.setForeground(Color.WHITE);
		lblIconKhachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlKhachHang.add(lblIconKhachHang);

		lblKhachHang = new JLabel("Khách hàng");
		lblKhachHang.setMinimumSize(new Dimension(180, 70));
		lblKhachHang.setPreferredSize(new Dimension(180, 70));
		lblKhachHang.setMaximumSize(new Dimension(180, 70));
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlKhachHang.add(lblKhachHang);

		JPanel pnlNhanVien = new JPanel();
		pnlNhanVien.setBackground(new Color(58, 181, 74));
		pnlNhanVien.setPreferredSize(new Dimension(300, 70));
		pnlNhanVien.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlNhanVien);
		pnlNhanVien.setLayout(new BoxLayout(pnlNhanVien, BoxLayout.X_AXIS));

		JLabel lblIconNhanVien = new JLabel("");
		lblIconNhanVien.setMinimumSize(new Dimension(120, 70));
		lblIconNhanVien.setIcon(new ImageIcon(App.class.getResource("/img/worker_50px.png")));
		lblIconNhanVien.setPreferredSize(new Dimension(120, 70));
		lblIconNhanVien.setMaximumSize(new Dimension(120, 70));
		lblIconNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNhanVien.setForeground(Color.WHITE);
		lblIconNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlNhanVien.add(lblIconNhanVien);

		lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setMinimumSize(new Dimension(180, 70));
		lblNhanVien.setPreferredSize(new Dimension(180, 70));
		lblNhanVien.setMaximumSize(new Dimension(180, 70));
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlNhanVien.add(lblNhanVien);

		JPanel pnlThongKe = new JPanel();
		pnlThongKe.setBackground(new Color(58, 181, 74));
		pnlThongKe.setPreferredSize(new Dimension(300, 70));
		pnlThongKe.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlThongKe);
		pnlThongKe.setLayout(new BoxLayout(pnlThongKe, BoxLayout.X_AXIS));

		JLabel lblIconThongKe = new JLabel("");
		lblIconThongKe.setMinimumSize(new Dimension(120, 70));
		lblIconThongKe.setIcon(new ImageIcon(App.class.getResource("/img/combo_chart_50px.png")));
		lblIconThongKe.setPreferredSize(new Dimension(120, 70));
		lblIconThongKe.setMaximumSize(new Dimension(120, 70));
		lblIconThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThongKe.setForeground(Color.WHITE);
		lblIconThongKe.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlThongKe.add(lblIconThongKe);

		lblThongKe = new JLabel("Thống kê");
		lblThongKe.setMinimumSize(new Dimension(180, 70));
		lblThongKe.setPreferredSize(new Dimension(180, 70));
		lblThongKe.setMaximumSize(new Dimension(180, 70));
		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlThongKe.add(lblThongKe);

		JPanel pnlDangXuat = new JPanel();
		pnlDangXuat.setBackground(new Color(58, 181, 74));
		pnlDangXuat.setPreferredSize(new Dimension(300, 70));
		pnlDangXuat.setMaximumSize(new Dimension(300, 70));
		vB1.add(pnlDangXuat);
		pnlDangXuat.setLayout(new BoxLayout(pnlDangXuat, BoxLayout.X_AXIS));

		lblIconDangXuat = new JLabel("");
		lblIconDangXuat.setMinimumSize(new Dimension(120, 70));
		lblIconDangXuat.setIcon(new ImageIcon(App.class.getResource("/img/export_50px.png")));
		lblIconDangXuat.setPreferredSize(new Dimension(120, 70));
		lblIconDangXuat.setMaximumSize(new Dimension(120, 70));
		lblIconDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDangXuat.setForeground(Color.WHITE);
		lblIconDangXuat.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlDangXuat.add(lblIconDangXuat);

		lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setMinimumSize(new Dimension(180, 70));
		lblDangXuat.setPreferredSize(new Dimension(180, 70));
		lblDangXuat.setMaximumSize(new Dimension(180, 70));
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlDangXuat.add(lblDangXuat);

		Component vG1 = Box.createVerticalGlue();
		vB1.add(vG1);

		JPanel pnlManHinhChinh = new JPanel();
		pnlManHinhChinh.setPreferredSize(new Dimension(1300, 900));
		hB2.add(pnlManHinhChinh);
		pnlManHinhChinh.setLayout(new BoxLayout(pnlManHinhChinh, BoxLayout.X_AXIS));

		Component hG = Box.createHorizontalGlue();
		hB2.add(hG);

		Component vG = Box.createVerticalGlue();
		vB.add(vG);

		ChuyenManHinh chuyen = new ChuyenManHinh(pnlManHinhChinh, maNhanVien);
		chuyen.setManHinh(pnlTrangChu, lblTrangChu);

		List<DanhMuc> listDanhMuc = new ArrayList<>();
		listDanhMuc.add(new DanhMuc("TrangChu", pnlTrangChu, lblTrangChu));
		listDanhMuc.add(new DanhMuc("TrangChu", pnlTrangChu, lblIconTrangChu));
		listDanhMuc.add(new DanhMuc("HoaDon", pnlHoaDon, lblHoaDon));
		listDanhMuc.add(new DanhMuc("HoaDon", pnlHoaDon, lblIconHoaDon));
		listDanhMuc.add(new DanhMuc("KhachHang", pnlKhachHang, lblKhachHang));
		listDanhMuc.add(new DanhMuc("KhachHang", pnlKhachHang, lblIconKhachHang));
		listDanhMuc.add(new DanhMuc("XeMay", pnlXeMay, lblXeMay));
		listDanhMuc.add(new DanhMuc("XeMay", pnlXeMay, lblIconXeMay));
		listDanhMuc.add(new DanhMuc("NhanVien", pnlNhanVien, lblNhanVien));
		listDanhMuc.add(new DanhMuc("NhanVien", pnlNhanVien, lblIconNhanVien));
		listDanhMuc.add(new DanhMuc("DangXuat", pnlDangXuat, lblDangXuat));
		listDanhMuc.add(new DanhMuc("DangXuat", pnlDangXuat, lblIconDangXuat));
		listDanhMuc.add(new DanhMuc("ThongKe", pnlThongKe, lblThongKe));
		listDanhMuc.add(new DanhMuc("ThongKe", pnlThongKe, lblIconThongKe));
		listDanhMuc.add(new DanhMuc("HopDong", pnlHopDong, lblHopDong));
		listDanhMuc.add(new DanhMuc("HopDong", pnlHopDong, lblIconHopDong));
		chuyen.setSuKien(listDanhMuc);

		pnlMenu.setPreferredSize(new Dimension(120, 900));

		dangKiSuLien();
	}

	private void dangKiSuLien() {
		lblDangXuat.addMouseListener(this);
		lblDanhMuc.addMouseListener(this);
		lblIconDanhMuc.addMouseListener(this);
		lblIconDangXuat.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(lblDangXuat) || o.equals(lblIconDangXuat)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				new GD_DangNhap().setVisible(true);
			}
		} else if (o.equals(lblIconDanhMuc) || o.equals(lblDanhMuc)) {
			if (pnlMenu.getWidth() < 300) {
				openMouseClicked(e);
			} else {
				closeMouseClicked(e);
			}
		}
	}

	private void openMouseClicked(MouseEvent evt) {
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(5);
						int w = pnlMenu.getWidth();
						if (w == 300) {
							break;
						}
						pnlMenu.setSize(w + 5, pnlMenu.getHeight());
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		};
		th.start();

	}

	private void closeMouseClicked(MouseEvent evt) {
		// TODO add your handling code here:
		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(5);
						int w = pnlMenu.getWidth();
						if (w == 120) {
							break;
						}
						pnlMenu.setSize(w - 5, pnlMenu.getHeight());
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		};
		th.start();

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

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
