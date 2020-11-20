package ui.quanLyNhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.NhanVienKiThuatDao;
import entity.NhanVienKiThuat;

public class GD_ChiTietNVKyThuat extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NhanVienKiThuatDao nhanVienKiThuatDao;

	public GD_ChiTietNVKyThuat(String maNVKiThuat) {
		nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();
		NhanVienKiThuat nhanVienKiThuat = nhanVienKiThuatDao.getNVKiThuatTheoMa(maNVKiThuat);

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
		pnlAnh.setBackground(Color.LIGHT_GRAY);
		pnlAnh.setBounds(33, 75, 302, 300);
		contentPane.add(pnlAnh);
		pnlAnh.setLayout(null);

		JLabel lblAnh = new JLabel("img");
		lblAnh.setBounds(0, 0, 302, 300);
		pnlAnh.add(lblAnh);
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(Color.WHITE);
		lblAnh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAnh.setIcon(new ImageIcon(new ImageIcon(nhanVienKiThuat.getTenAnh()).getImage()
				.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));

		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(368, 75, 143, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblMaNV = new JLabel("XM123456");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(549, 75, 125, 30);
		lblMaNV.setText(nhanVienKiThuat.getMaNVKiThuat());
		contentPane.add(lblMaNV);

		JLabel lblNewLabel_2_1 = new JLabel("Loại nhân viên:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(368, 166, 154, 30);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblLoaiNV = new JLabel("Honda AirBlade");
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiNV.setBounds(547, 166, 237, 30);
		lblLoaiNV.setText("Nhân viên kỹ thuật");
		contentPane.add(lblLoaiNV);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(368, 123, 154, 30);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblTenNV = new JLabel("XM123456");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(549, 123, 448, 30);
		lblTenNV.setText(nhanVienKiThuat.getHoTen());
		contentPane.add(lblTenNV);

		JLabel lblNewLabel_2_1_3 = new JLabel("Giới tính:");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_3.setBounds(807, 209, 112, 30);
		contentPane.add(lblNewLabel_2_1_3);

		JLabel lblGioiTinh = new JLabel("Xe tay ga");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setBounds(931, 209, 65, 30);
		lblGioiTinh.setText(nhanVienKiThuat.isGioiTinh() == true ? "Nam" : "Nữ");
		contentPane.add(lblGioiTinh);

		JLabel lblNewLabel_2_1_4 = new JLabel("Ngày sinh:");
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_4.setBounds(368, 209, 140, 30);
		contentPane.add(lblNewLabel_2_1_4);

		JLabel lblNgaySinh = new JLabel("150 cc");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBounds(549, 209, 162, 30);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		lblNgaySinh.setText(simpleDateFormat.format(nhanVienKiThuat.getNgaySinh()));
		contentPane.add(lblNgaySinh);

		JLabel lblNewLabel_2_1_6 = new JLabel("Kinh nghiệm:");
		lblNewLabel_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_6.setBounds(368, 338, 143, 30);
		contentPane.add(lblNewLabel_2_1_6);

		JLabel lblKinhNghiem = new JLabel("Đỏ-Đen");
		lblKinhNghiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKinhNghiem.setBounds(549, 338, 302, 30);
		lblKinhNghiem.setText(String.valueOf(nhanVienKiThuat.getSoNamKinhNghiem()));
		contentPane.add(lblKinhNghiem);

		JLabel lblNewLabel_2_1_8 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_8.setBounds(33, 398, 106, 30);
		contentPane.add(lblNewLabel_2_1_8);

		JLabel lblDiaChi = new JLabel(nhanVienKiThuat.getDiaChi());
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(128, 398, 849, 30);
		contentPane.add(lblDiaChi);

		JLabel lblNewLabel_2_1_9 = new JLabel("Bậc thợ:");
		lblNewLabel_2_1_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_9.setBounds(368, 295, 103, 30);
		contentPane.add(lblNewLabel_2_1_9);

		JLabel lblBacTho = new JLabel("XM123456");
		lblBacTho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBacTho.setBounds(549, 295, 193, 30);
		lblBacTho.setText(String.valueOf(nhanVienKiThuat.getBacTho()));
		contentPane.add(lblBacTho);

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
		lblSDT.setText(nhanVienKiThuat.getSoDienThoai());
		contentPane.add(lblSDT);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}
}
