package ui.quanLyHopDong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.HopDongDao;
import entity.HopDong;
import other.DocSo;

public class GD_ChiTietHD extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMaHD;
	private JLabel lblNgayLapHD;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblNgaySinhNV;
	private JLabel lblDiaChiNV;
	private JLabel lblSDTNhanVien;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblNgaySinhKH;
	private JLabel lblSDTKhachHang;
	private JLabel lblDiaChiKH;
	private JLabel lblLoaiXe;
	private JLabel lblHang;
	private JLabel lblMaXe;
	private JLabel lblTenXe;
	private JLabel lblXuatXu;
	private JLabel lblDongXe;
	private JLabel lblMauXe;
	private JLabel lblSoPhanKhoi;
	private JLabel lblSoSuon;
	private JLabel lblSoKhung;
	private JLabel lblGiaBan;
	private JLabel lblBaoHanh;
	private JLabel lblChu;
	private HopDongDao hopDongDao;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public GD_ChiTietHD(String maHopDong) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		hopDongDao = HopDongDao.getInstance();
		HopDong hopDong = hopDongDao.getHopDongTheoMa(maHopDong);
		System.out.println(hopDong);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GD_ChiTietHD.class.getResource("/img/baseline_receipt_long_white_36dp.png")));
		setTitle("Chi tiết hợp đồng");
		setSize(950, 981);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 932, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hợp đồng bán xe máy");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 932, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin nhân viên lập hợp đồng:");
		lblNewLabel_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 108, 364, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Thông tin khách hàng:");
		lblNewLabel_1_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(30, 306, 364, 30);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Thông tin xe:");
		lblNewLabel_1_1_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(31, 506, 147, 30);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã hợp đồng:");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(28, 63, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1);

		lblMaHD = new JLabel(hopDong.getMaHopDong());
		lblMaHD.setForeground(Color.BLACK);
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHD.setBounds(207, 63, 147, 30);
		contentPane.add(lblMaHD);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Ngày lập hợp đồng:");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(453, 63, 204, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		lblNgayLapHD = new JLabel(simpleDateFormat.format(hopDong.getHoaDon().getNgayLap()));
		lblNgayLapHD.setForeground(Color.BLACK);
		lblNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayLapHD.setBounds(669, 63, 147, 30);
		contentPane.add(lblNgayLapHD);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(58, 181, 74));
		separator.setBounds(30, 140, 866, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(58, 181, 74));
		separator_1.setBounds(30, 341, 866, 2);
		contentPane.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(new Color(58, 181, 74));
		separator_1_1.setBounds(31, 542, 866, 2);
		contentPane.add(separator_1_1);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_2.setBounds(30, 159, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_2);

		lblMaNV = new JLabel(hopDong.getHoaDon().getNhanVienHanhChinh().getMaNVHanhChinh());
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(197, 159, 147, 30);
		contentPane.add(lblMaNV);

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3.setBounds(453, 159, 158, 30);
		contentPane.add(lblNewLabel_1_1_1_1_3);

		 lblTenNV = new JLabel(hopDong.getHoaDon().getNhanVienHanhChinh().getHoTenNV());
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(636, 159, 272, 30);
		contentPane.add(lblTenNV);

		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_4.setBounds(30, 209, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_4);


		lblNgaySinhNV = new JLabel(simpleDateFormat.format(hopDong.getHoaDon().getNhanVienHanhChinh().getNgaySinh()));
		lblNgaySinhNV.setForeground(Color.BLACK);
		lblNgaySinhNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinhNV.setBounds(197, 209, 147, 30);
		contentPane.add(lblNgaySinhNV);

		JLabel lblNewLabel_1_1_1_1_5 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_5.setBounds(30, 263, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_5);

		 lblDiaChiNV = new JLabel(hopDong.getHoaDon().getNhanVienHanhChinh().getDiaChi());
		lblDiaChiNV.setForeground(Color.BLACK);
		lblDiaChiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChiNV.setBounds(197, 263, 698, 30);
		contentPane.add(lblDiaChiNV);

		JLabel lblNewLabel_1_1_1_1_6 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1_1_1_6.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_6.setBounds(453, 209, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_6);

		 lblSDTNhanVien = new JLabel(hopDong.getHoaDon().getNhanVienHanhChinh().getSoDienThoai());
		lblSDTNhanVien.setForeground(Color.BLACK);
		lblSDTNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDTNhanVien.setBounds(636, 209, 147, 30);
		contentPane.add(lblSDTNhanVien);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_2_1.setBounds(30, 362, 169, 30);
		contentPane.add(lblNewLabel_1_1_1_1_2_1);

		 lblMaKH = new JLabel(hopDong.getHoaDon().getKhachHang().getMaKhachHang());
		lblMaKH.setForeground(Color.BLACK);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKH.setBounds(197, 362, 147, 30);
		contentPane.add(lblMaKH);

		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_1_1_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1.setBounds(453, 362, 169, 30);
		contentPane.add(lblNewLabel_1_1_1_1_3_1);

		 lblTenKH = new JLabel(hopDong.getHoaDon().getKhachHang().getHoTenKH());
		lblTenKH.setForeground(Color.BLACK);
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKH.setBounds(638, 362, 272, 30);
		contentPane.add(lblTenKH);

		JLabel lblNewLabel_1_1_1_1_4_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_4_1.setBounds(30, 412, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_4_1);

		 lblNgaySinhKH = new JLabel(simpleDateFormat.format(hopDong.getHoaDon().getKhachHang().getNgaySinh()));
		lblNgaySinhKH.setForeground(Color.BLACK);
		lblNgaySinhKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinhKH.setBounds(197, 412, 147, 30);
		contentPane.add(lblNgaySinhKH);

		JLabel lblNewLabel_1_1_1_1_6_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1_1_1_6_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_6_1.setBounds(453, 412, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_6_1);

		lblSDTKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getSoDienThoai());
		lblSDTKhachHang.setForeground(Color.BLACK);
		lblSDTKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDTKhachHang.setBounds(638, 412, 147, 30);
		contentPane.add(lblSDTKhachHang);

		JLabel lblNewLabel_1_1_1_1_5_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_1_5_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_5_1.setBounds(30, 464, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_5_1);

		 lblDiaChiKH = new JLabel(hopDong.getHoaDon().getKhachHang().getDiaChiKH());
		lblDiaChiKH.setForeground(Color.BLACK);
		lblDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChiKH.setBounds(197, 464, 687, 30);
		contentPane.add(lblDiaChiKH);

		JLabel lblNewLabel_1_1_1_1_5_1_1 = new JLabel("Loại xe:");
		lblNewLabel_1_1_1_1_5_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_5_1_1.setBounds(30, 662, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_5_1_1);

		 lblLoaiXe = new JLabel("Xe tay ga");
		lblLoaiXe.setForeground(Color.BLACK);
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiXe.setBounds(197, 662, 147, 30);
		contentPane.add(lblLoaiXe);

		JLabel lblNewLabel_1_1_1_1_4_1_1 = new JLabel("Hãng:");
		lblNewLabel_1_1_1_1_4_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_4_1_1.setBounds(30, 610, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_4_1_1);

		 lblHang = new JLabel(hopDong.getXeMay().getDongXe().getHangXe().getTenHangXe());
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBounds(197, 610, 232, 30);
		contentPane.add(lblHang);

		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("Mã xe:");
		lblNewLabel_1_1_1_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_2_1_1.setBounds(30, 560, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_2_1_1);

		 lblMaXe = new JLabel(hopDong.getXeMay().getMaXeMay());
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(197, 560, 147, 30);
		contentPane.add(lblMaXe);

		JLabel lblNewLabel_1_1_1_1_3_1_1 = new JLabel("Tên xe:");
		lblNewLabel_1_1_1_1_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1_1.setBounds(453, 560, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_3_1_1);

		 lblTenXe = new JLabel(hopDong.getXeMay().getTenXeMay());
		lblTenXe.setForeground(Color.BLACK);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(636, 560, 260, 30);
		contentPane.add(lblTenXe);

		JLabel lblNewLabel_1_1_1_1_6_1_1 = new JLabel("Xuất xứ:");
		lblNewLabel_1_1_1_1_6_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_6_1_1.setBounds(453, 610, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_6_1_1);

		 lblXuatXu = new JLabel(hopDong.getXeMay().getXuatXu().getTenXuatXu());
		lblXuatXu.setForeground(Color.BLACK);
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXuatXu.setBounds(636, 610, 147, 30);
		contentPane.add(lblXuatXu);

		JLabel lblNewLabel_1_1_1_1_6_1_1_1 = new JLabel("Dòng xe:");
		lblNewLabel_1_1_1_1_6_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_6_1_1_1.setBounds(453, 662, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_6_1_1_1);

		 lblDongXe = new JLabel(hopDong.getXeMay().getDongXe().getTenDongXe());
		lblDongXe.setForeground(Color.BLACK);
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDongXe.setBounds(636, 662, 147, 30);
		contentPane.add(lblDongXe);

		JLabel lblNewLabel_1_1_1_1_2_1_1_1 = new JLabel("Màu xe:");
		lblNewLabel_1_1_1_1_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_2_1_1_1.setBounds(30, 709, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_2_1_1_1);

		 lblMauXe = new JLabel(hopDong.getXeMay().getMauXe());
		lblMauXe.setForeground(Color.BLACK);
		lblMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMauXe.setBounds(197, 709, 232, 30);
		contentPane.add(lblMauXe);

		JLabel lblNewLabel_1_1_1_1_3_1_1_1 = new JLabel("Số phân khối:");
		lblNewLabel_1_1_1_1_3_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1_1_1.setBounds(453, 709, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_3_1_1_1);

		 lblSoPhanKhoi = new JLabel(String.valueOf(hopDong.getXeMay().getSoPhanKhoi())+" cc");
		lblSoPhanKhoi.setForeground(Color.BLACK);
		lblSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoPhanKhoi.setBounds(636, 709, 50, 30);
		contentPane.add(lblSoPhanKhoi);

		 lblSoSuon = new JLabel(hopDong.getXeMay().getSoSuon());
		lblSoSuon.setForeground(Color.BLACK);
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoSuon.setBounds(636, 759, 260, 30);
		contentPane.add(lblSoSuon);

		JLabel lblNewLabel_1_1_1_1_6_1_1_2 = new JLabel("Số sườn:");
		lblNewLabel_1_1_1_1_6_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_6_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_6_1_1_2.setBounds(453, 759, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_6_1_1_2);

		 lblSoKhung = new JLabel(hopDong.getXeMay().getSoKhung());
		lblSoKhung.setForeground(Color.BLACK);
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoKhung.setBounds(197, 759, 232, 30);
		contentPane.add(lblSoKhung);

		JLabel lblNewLabel_1_1_1_1_4_1_1_1 = new JLabel("Số khung:");
		lblNewLabel_1_1_1_1_4_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_4_1_1_1.setBounds(30, 759, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_4_1_1_1);

		JLabel lblNewLabel_1_1_1_1_5_1_1_1 = new JLabel("Giá bán:");
		lblNewLabel_1_1_1_1_5_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_5_1_1_1.setBounds(30, 811, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_5_1_1_1);

		 lblGiaBan = new JLabel(String.valueOf(hopDong.getXeMay().tinhGiaBan()));
		lblGiaBan.setForeground(Color.BLACK);
		lblGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaBan.setBounds(197, 811, 224, 30);
		contentPane.add(lblGiaBan);

		JLabel lblNewLabel_1_1_1_1_6_1_1_1_1 = new JLabel("Bảo hành:");
		lblNewLabel_1_1_1_1_6_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_6_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_6_1_1_1_1.setBounds(453, 811, 147, 30);
		contentPane.add(lblNewLabel_1_1_1_1_6_1_1_1_1);

		 lblBaoHanh = new JLabel(String.valueOf(hopDong.getXeMay().getThoiGianBaoHanh())+" tháng");
		lblBaoHanh.setForeground(Color.BLACK);
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(636, 811, 147, 30);
		contentPane.add(lblBaoHanh);

//		JLabel lblPK = new JLabel("cc");
//		lblPK.setForeground(Color.BLACK);
//		lblPK.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblPK.setBounds(698, 709, 67, 30);
//		contentPane.add(lblPK);

		JLabel lblNewLabel_1_1_1_1_5_1_1_1_1 = new JLabel("(Bằng chữ: ");
		lblNewLabel_1_1_1_1_5_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_5_1_1_1_1.setBounds(31, 851, 104, 30);
		contentPane.add(lblNewLabel_1_1_1_1_5_1_1_1_1);
		
		 lblChu = new JLabel(DocSo.readNum(lblGiaBan.getText())+")");
		lblChu.setForeground(Color.BLACK);
		lblChu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChu.setBounds(135, 851, 749, 30);
		contentPane.add(lblChu);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(737, 885, 147, 30);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
}
