package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class frm_APP extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlMenu;
	private JPanel pnlLogo;
	private JLabel lblLogo;
	private JPanel pnlTrangChu;
	private JLabel lblTrangChu;
	private JPanel pnlXeMay;
	private JLabel lblXeMay;
	private JPanel pnlHoaDon;
	private JLabel lblHoaDon;
	private JPanel pnlHopDong;
	private JLabel lblHopDong;
	private JPanel pnlKhachHang;
	private JLabel lblKhachHang;
	private JPanel pnlNhanVien;
	private JLabel lblNhanVien;
	private JPanel pnlThongKe;
	private JPanel pnlDangXuat;
	private JLabel lblDangXuat;
	private JPanel pnlManHinhChinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new frm_APP().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public frm_APP() {
		setTitle("Quản Lý mua bán linh kiện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		Box horizontalBox_4 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_4);

		pnlMenu = new JPanel();
		pnlMenu.setBackground(Color.DARK_GRAY);
		pnlMenu.setMaximumSize(new Dimension(300, 32767));
		pnlMenu.setPreferredSize(new Dimension(300, 900));
		horizontalBox_4.add(pnlMenu);
		pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.X_AXIS));

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBackground(Color.DARK_GRAY);
		pnlMenu.add(verticalBox_1);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_9);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5);

		pnlLogo = new JPanel();
		pnlLogo.setMinimumSize(new Dimension(300, 50));
		pnlLogo.setBackground(Color.DARK_GRAY);
		pnlLogo.setPreferredSize(new Dimension(300, 50));
		pnlLogo.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5.add(pnlLogo);
		pnlLogo.setLayout(new BoxLayout(pnlLogo, BoxLayout.X_AXIS));

		lblLogo = new JLabel("   Logo");
		lblLogo.setMaximumSize(new Dimension(32767, 50));
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLogo.setBackground(Color.BLACK);
		pnlLogo.add(lblLogo);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8);

		Box horizontalBox_5_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_1);

		pnlTrangChu = new JPanel();
		pnlTrangChu.setMinimumSize(new Dimension(300, 50));
		pnlTrangChu.setBackground(new Color(0, 128, 0));
		pnlTrangChu.setPreferredSize(new Dimension(300, 50));
		pnlTrangChu.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_1.add(pnlTrangChu);
		pnlTrangChu.setLayout(new BoxLayout(pnlTrangChu, BoxLayout.X_AXIS));
		
		JLabel lblIconTC = new JLabel("");
		lblIconTC.setPreferredSize(new Dimension(100, 50));
		lblIconTC.setIcon(new ImageIcon(frm_APP.class.getResource("/img/baseline_home_white_36dp.png")));
		lblIconTC.setMaximumSize(new Dimension(100, 50));
		lblIconTC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTC.setForeground(Color.WHITE);
		lblIconTC.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconTC.setBackground(Color.BLACK);
		pnlTrangChu.add(lblIconTC);

		lblTrangChu = new JLabel("Trang chủ");
		lblTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrangChu.setMaximumSize(new Dimension(32767, 50));
		lblTrangChu.setForeground(Color.WHITE);
		lblTrangChu.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTrangChu.setBackground(Color.BLACK);
		pnlTrangChu.add(lblTrangChu);

		Component rigidArea_8_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_1);

		Box horizontalBox_5_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_2);

		pnlXeMay = new JPanel();
		pnlXeMay.setMinimumSize(new Dimension(300, 50));
		pnlXeMay.setBackground(new Color(0, 128, 0));
		pnlXeMay.setPreferredSize(new Dimension(300, 50));
		pnlXeMay.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_2.add(pnlXeMay);
		pnlXeMay.setLayout(new BoxLayout(pnlXeMay, BoxLayout.X_AXIS));
		
		JLabel lblIconXM = new JLabel("");
		lblIconXM.setPreferredSize(new Dimension(100, 50));
		lblIconXM.setMaximumSize(new Dimension(100, 50));
		lblIconXM.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconXM.setForeground(Color.WHITE);
		lblIconXM.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconXM.setBackground(Color.BLACK);
		pnlXeMay.add(lblIconXM);

		lblXeMay = new JLabel("Xe máy");
		lblXeMay.setMaximumSize(new Dimension(32767, 50));
		lblXeMay.setHorizontalTextPosition(SwingConstants.CENTER);
		lblXeMay.setForeground(Color.WHITE);
		lblXeMay.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblXeMay.setBackground(Color.BLACK);
		pnlXeMay.add(lblXeMay);

		Component rigidArea_8_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_2);

		Box horizontalBox_5_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_3);

		pnlHoaDon = new JPanel();
		pnlHoaDon.setMinimumSize(new Dimension(300, 50));
		pnlHoaDon.setBackground(new Color(0, 128, 0));
		pnlHoaDon.setPreferredSize(new Dimension(300, 50));
		pnlHoaDon.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_3.add(pnlHoaDon);
		pnlHoaDon.setLayout(new BoxLayout(pnlHoaDon, BoxLayout.X_AXIS));
		
		JLabel lblIconHD = new JLabel("");
		lblIconHD.setPreferredSize(new Dimension(100, 50));
		lblIconHD.setMaximumSize(new Dimension(100, 50));
		lblIconHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHD.setForeground(Color.WHITE);
		lblIconHD.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconHD.setBackground(Color.BLACK);
		pnlHoaDon.add(lblIconHD);

		lblHoaDon = new JLabel("Hóa đơn");
		lblHoaDon.setMaximumSize(new Dimension(32767, 50));
		lblHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHoaDon.setBackground(Color.BLACK);
		pnlHoaDon.add(lblHoaDon);

		Component rigidArea_8_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_3);

		Box horizontalBox_5_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_4);

		pnlHopDong = new JPanel();
		pnlHopDong.setMinimumSize(new Dimension(300, 50));
		pnlHopDong.setBackground(new Color(0, 128, 0));
		pnlHopDong.setPreferredSize(new Dimension(300, 50));
		pnlHopDong.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_4.add(pnlHopDong);
		pnlHopDong.setLayout(new BoxLayout(pnlHopDong, BoxLayout.X_AXIS));
		
		JLabel lblIconHDong = new JLabel("");
		lblIconHDong.setPreferredSize(new Dimension(100, 50));
		lblIconHDong.setMaximumSize(new Dimension(100, 50));
		lblIconHDong.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHDong.setForeground(Color.WHITE);
		lblIconHDong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconHDong.setBackground(Color.BLACK);
		pnlHopDong.add(lblIconHDong);

		lblHopDong = new JLabel("Hợp đồng");
		lblHopDong.setMaximumSize(new Dimension(32767, 50));
		lblHopDong.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHopDong.setForeground(Color.WHITE);
		lblHopDong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHopDong.setBackground(Color.BLACK);
		pnlHopDong.add(lblHopDong);

		Component rigidArea_8_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_4);

		Box horizontalBox_5_5 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_5);

		pnlKhachHang = new JPanel();
		pnlKhachHang.setMinimumSize(new Dimension(300, 50));
		pnlKhachHang.setBackground(new Color(0, 128, 0));
		pnlKhachHang.setPreferredSize(new Dimension(300, 50));
		pnlKhachHang.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_5.add(pnlKhachHang);
		pnlKhachHang.setLayout(new BoxLayout(pnlKhachHang, BoxLayout.X_AXIS));
		
		JLabel lblIconKH = new JLabel("");
		lblIconKH.setPreferredSize(new Dimension(100, 50));
		lblIconKH.setMaximumSize(new Dimension(100, 50));
		lblIconKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKH.setForeground(Color.WHITE);
		lblIconKH.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconKH.setBackground(Color.BLACK);
		pnlKhachHang.add(lblIconKH);

		lblKhachHang = new JLabel("Khách hàng");
		lblKhachHang.setMaximumSize(new Dimension(32767, 50));
		lblKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblKhachHang.setBackground(Color.BLACK);
		pnlKhachHang.add(lblKhachHang);

		Component rigidArea_8_5 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_5);

		Box horizontalBox_5_7 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_7);

		pnlNhanVien = new JPanel();
		pnlNhanVien.setMinimumSize(new Dimension(300, 50));
		pnlNhanVien.setBackground(new Color(0, 128, 0));
		pnlNhanVien.setPreferredSize(new Dimension(300, 50));
		pnlNhanVien.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_7.add(pnlNhanVien);
		pnlNhanVien.setLayout(new BoxLayout(pnlNhanVien, BoxLayout.X_AXIS));
		
		JLabel lblIconNV = new JLabel("");
		lblIconNV.setPreferredSize(new Dimension(100, 50));
		lblIconNV.setMaximumSize(new Dimension(100, 50));
		lblIconNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNV.setForeground(Color.WHITE);
		lblIconNV.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconNV.setBackground(Color.BLACK);
		pnlNhanVien.add(lblIconNV);

		lblNhanVien = new JLabel("Nhân viên");
		lblNhanVien.setMaximumSize(new Dimension(32767, 50));
		lblNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNhanVien.setBackground(Color.BLACK);
		pnlNhanVien.add(lblNhanVien);

		Component rigidArea_8_7 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_7);

		Box horizontalBox_5_8 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_8);

		pnlThongKe = new JPanel();
		pnlThongKe.setMinimumSize(new Dimension(300, 50));
		pnlThongKe.setBackground(new Color(0, 128, 0));
		pnlThongKe.setPreferredSize(new Dimension(300, 50));
		pnlThongKe.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_8.add(pnlThongKe);
		pnlThongKe.setLayout(new BoxLayout(pnlThongKe, BoxLayout.X_AXIS));
		
		JLabel lblIconTK = new JLabel("");
		lblIconTK.setPreferredSize(new Dimension(100, 50));
		lblIconTK.setMaximumSize(new Dimension(100, 50));
		lblIconTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTK.setForeground(Color.WHITE);
		lblIconTK.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconTK.setBackground(Color.BLACK);
		pnlThongKe.add(lblIconTK);

		JLabel lblThongKe = new JLabel("Thống kê");
		lblThongKe.setMaximumSize(new Dimension(32767, 50));
		lblThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblThongKe.setBackground(Color.BLACK);
		pnlThongKe.add(lblThongKe);

		Component rigidArea_8_8 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox_1.add(rigidArea_8_8);

		Box horizontalBox_5_9 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_5_9);

		pnlDangXuat = new JPanel();
		pnlDangXuat.setMinimumSize(new Dimension(300, 50));
		pnlDangXuat.setBackground(new Color(0, 128, 0));
		pnlDangXuat.setPreferredSize(new Dimension(300, 50));
		pnlDangXuat.setMaximumSize(new Dimension(300, 50));
		horizontalBox_5_9.add(pnlDangXuat);
		pnlDangXuat.setLayout(new BoxLayout(pnlDangXuat, BoxLayout.X_AXIS));
		
		JLabel lblIconDX = new JLabel("");
		lblIconDX.setPreferredSize(new Dimension(100, 50));
		lblIconDX.setMaximumSize(new Dimension(100, 50));
		lblIconDX.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDX.setForeground(Color.WHITE);
		lblIconDX.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIconDX.setBackground(Color.BLACK);
		pnlDangXuat.add(lblIconDX);

		lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.setMaximumSize(new Dimension(32767, 50));
		lblDangXuat.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDangXuat.setBackground(Color.BLACK);
		pnlDangXuat.add(lblDangXuat);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue_1);

		pnlManHinhChinh = new JPanel();
		pnlManHinhChinh.setPreferredSize(new Dimension(1300, 900));
		horizontalBox_4.add(pnlManHinhChinh);
		pnlManHinhChinh.setLayout(new BoxLayout(pnlManHinhChinh, BoxLayout.X_AXIS));

		ChuyenManHinh chuyen = new ChuyenManHinh(pnlManHinhChinh);
		chuyen.setManHinh(pnlTrangChu, lblTrangChu);

		List<DanhMuc> listDanhMuc = new ArrayList<>();
		listDanhMuc.add(new DanhMuc("TrangChu", pnlTrangChu, lblTrangChu));
		listDanhMuc.add(new DanhMuc("TrangChu", pnlTrangChu, lblIconTC));
		listDanhMuc.add(new DanhMuc("HoaDon", pnlHoaDon, lblHoaDon));
		listDanhMuc.add(new DanhMuc("HoaDon", pnlHoaDon, lblIconHD));
		listDanhMuc.add(new DanhMuc("KhachHang", pnlKhachHang, lblKhachHang));
		listDanhMuc.add(new DanhMuc("KhachHang", pnlKhachHang, lblIconKH));
		listDanhMuc.add(new DanhMuc("XeMay", pnlXeMay, lblXeMay));
		listDanhMuc.add(new DanhMuc("XeMay", pnlXeMay, lblIconXM));
		listDanhMuc.add(new DanhMuc("NhanVien", pnlNhanVien, lblNhanVien));
		listDanhMuc.add(new DanhMuc("NhanVien", pnlNhanVien, lblIconNV));
		listDanhMuc.add(new DanhMuc("DangXuat", pnlDangXuat, lblDangXuat));
		listDanhMuc.add(new DanhMuc("DangXuat", pnlDangXuat, lblIconDX));
		listDanhMuc.add(new DanhMuc("ThongKe", pnlThongKe, lblThongKe));
		listDanhMuc.add(new DanhMuc("ThongKe", pnlThongKe, lblIconTK));
		listDanhMuc.add(new DanhMuc("HopDong", pnlHopDong, lblHopDong));
		listDanhMuc.add(new DanhMuc("HopDong", pnlHopDong, lblIconHDong));
		chuyen.setSuKien(listDanhMuc);
<<<<<<< HEAD

		pnlMenu.setPreferredSize(new Dimension(100, 900));
		dangKiSuLien();
	}

	private void dangKiSuLien() {
=======
		
		
		
>>>>>>> 9427b75ca656a3e297d0e1e59c8ac2ade1012534
		lblDangXuat.addMouseListener(this);
		lblLogo.addMouseListener(this);
		pnlMenu.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(lblDangXuat)) {
			int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (tl == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				new GD_DangNhap().setVisible(true);
			}
		} else if (o.equals(lblLogo)) {
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
						if (w == 100) {
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
