package ui.quanLyNhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.NhanVienHanhChinhDao;
import entity.NhanVienHanhChinh;
import ui.GD_DangNhap;
import ui.quanLyXeMay.GD_ThemXeMay;

public class GD_ChiTietNVHanhChinh extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;

	public GD_ChiTietNVHanhChinh(String maNVHanhChinh) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/icon/motorbike_helmet_100px.png")));
		nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();
		NhanVienHanhChinh nhanVienHanhChinh = nhanVienHanhChinhDao.getNVHanhChinhTheoMa(maNVHanhChinh);
		System.out.println(nhanVienHanhChinh);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1027, 547);
		setLocationRelativeTo(null);
		setTitle("Chi tiết nhân viên");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1009, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin chi tiết nhân viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1009, 50);
		panel.add(lblNewLabel);

		JPanel pnlAnh = new JPanel();
		pnlAnh.setBackground(Color.WHITE);
		pnlAnh.setBounds(33, 75, 302, 300);
		contentPane.add(pnlAnh);
		pnlAnh.setLayout(null);

		JLabel lblAnh = new JLabel();
		lblAnh.setBounds(0, 0, 302, 300);
		pnlAnh.add(lblAnh);
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(Color.WHITE);
		lblAnh.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		// Kiểm tra xem ảnh có null không
		Optional<String> optional = Optional.ofNullable(nhanVienHanhChinh.getTenAnh());
		if (optional.isPresent()) {
			lblAnh.setIcon(new ImageIcon(new ImageIcon("ImgNhanVien/" + nhanVienHanhChinh.getTenAnh().trim()).getImage()
					.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		}else {
			if(nhanVienHanhChinh.isGioiTinh()) {
				lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/male-user.png")).getImage()
						.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			}else {
				lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/female-student-silhouette.png")).getImage()
						.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			}
		}

		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(368, 75, 143, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblMaNV = new JLabel("XM123456");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(549, 75, 125, 30);
		lblMaNV.setText(nhanVienHanhChinh.getMaNVHanhChinh());
		contentPane.add(lblMaNV);

		JLabel lblNewLabel_2_1 = new JLabel("Loại nhân viên:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(368, 166, 154, 30);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblLoaiNV = new JLabel("Honda AirBlade");
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiNV.setBounds(547, 166, 237, 30);
		lblLoaiNV.setText("Nhân viên hành chính");
		contentPane.add(lblLoaiNV);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(368, 123, 154, 30);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblTenNV = new JLabel("XM123456");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(549, 123, 432, 30);
		lblTenNV.setText(nhanVienHanhChinh.getHoTenNV());
		contentPane.add(lblTenNV);

		JLabel lblNewLabel_2_1_3 = new JLabel("Giới tính:");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_3.setBounds(807, 209, 112, 30);
		contentPane.add(lblNewLabel_2_1_3);

		JLabel lblGioiTinh = new JLabel("Xe tay ga");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setBounds(931, 209, 65, 30);
		lblGioiTinh.setText(nhanVienHanhChinh.isGioiTinh() == true ? "Nam" : "Nữ");
		contentPane.add(lblGioiTinh);

		JLabel lblNewLabel_2_1_4 = new JLabel("Ngày sinh:");
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_4.setBounds(368, 209, 140, 30);
		contentPane.add(lblNewLabel_2_1_4);

		JLabel lblNgaySinh = new JLabel("150 cc");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBounds(549, 209, 162, 30);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		lblNgaySinh.setText(simpleDateFormat.format(nhanVienHanhChinh.getNgaySinh()));
		contentPane.add(lblNgaySinh);

		JLabel lblNewLabel_2_1_6 = new JLabel("Chức vụ:");
		lblNewLabel_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_6.setBounds(368, 338, 103, 30);
		contentPane.add(lblNewLabel_2_1_6);

		JLabel lblChucVu = new JLabel("Đỏ-Đen");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChucVu.setBounds(549, 338, 376, 30);
		lblChucVu.setText(nhanVienHanhChinh.isVaiTro() == false ? "Quản lý nhân viên" : "Nhân viên");
		contentPane.add(lblChucVu);

		JLabel lblNewLabel_2_1_8 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_8.setBounds(33, 398, 106, 30);
		contentPane.add(lblNewLabel_2_1_8);

		JLabel lblDiaChi = new JLabel(nhanVienHanhChinh.getDiaChi());
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(128, 398, 853, 30);
		contentPane.add(lblDiaChi);

		JLabel lblNewLabel_2_1_9 = new JLabel("Trình độ:");
		lblNewLabel_2_1_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_9.setBounds(368, 295, 103, 30);
		contentPane.add(lblNewLabel_2_1_9);

		JLabel lblTrinhDo = new JLabel("XM123456");
		lblTrinhDo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrinhDo.setBounds(549, 295, 193, 30);
		lblTrinhDo.setText(nhanVienHanhChinh.getTrinhDoHocVan());
		contentPane.add(lblTrinhDo);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(848, 439, 129, 35);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_2_1.setBounds(368, 252, 154, 30);
		contentPane.add(lblNewLabel_2_1_2_1);

		JLabel lblSDT = new JLabel("Việt Nam");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(549, 252, 165, 30);
		lblSDT.setText(nhanVienHanhChinh.getSoDienThoai());
		contentPane.add(lblSDT);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}
}
