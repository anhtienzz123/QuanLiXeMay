package ui.quanLyKhachHang;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.KhachHangDao;
import entity.KhachHang;
import other.XuLyThoiGian;
import ui.GD_DangNhap;
import javax.swing.ImageIcon;

public class GD_ChiTietKhachHang extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThoat;
	private JLabel lblDiaChi;
	private JLabel lblSDT;
	private JLabel lblNgaySinh;
	private JLabel lblTenKH;
	private JLabel lblSoCMT;
	private JLabel lblMaKH;
	private JLabel lblEmail;

	private KhachHangDao khachHangDao;
	private String maKhachHang;

	public GD_ChiTietKhachHang(String maKhachHang) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/icon/motorbike_helmet_100px.png")));

		khachHangDao = KhachHangDao.getInstance();
		this.maKhachHang = maKhachHang;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 431);
		setLocationRelativeTo(null);
		setTitle("Thông tin khách hàng");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBackground(new Color(58, 181, 74));
		panel.setPreferredSize(new Dimension(800, 50));
		horizontalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(122, 50));
		lblNewLabel.setPreferredSize(new Dimension(800, 50));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1);

		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_15);

		lblMaKH = new JLabel("KH123456");
		lblMaKH.setForeground(Color.BLACK);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaKH);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);

		JLabel lblNewLabel_1_1 = new JLabel("Số CMT:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1_1);

		Component rigidArea_15_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_15_1);

		lblSoCMT = new JLabel("123456789012");
		lblSoCMT.setForeground(Color.BLACK);
		lblSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblSoCMT);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_7);

		JLabel lblNewLabel_1_2 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_2);

		Component rigidArea_15_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_15_2);

		lblTenKH = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKH.setForeground(Color.BLACK);
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(lblTenKH);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);

		Component rigidArea_5_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_5_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_1_1);

		Component rigidArea_15_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_15_1_1);

		lblNgaySinh = new JLabel("20/20/2020");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(lblNgaySinh);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_8);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_9);

		JLabel lblNewLabel_1_3 = new JLabel("SĐT:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_3);

		Component rigidArea_15_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_15_3);

		lblSDT = new JLabel("0123456789");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_3.add(lblSDT);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_3);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3);

		Box horizontalBox_3_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3_1);

		Component rigidArea_9_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_9_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("Email:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblNewLabel_1_3_1);

		Component rigidArea_15_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_15_3_1);

		lblEmail = new JLabel("nhathao0852@gmail.com");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_3_1.add(lblEmail);

		Component horizontalGlue_3_1 = Box.createHorizontalGlue();
		horizontalBox_3_1.add(horizontalGlue_3_1);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_1.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_1);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7);

		Component rigidArea_20 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_20);

		JLabel lblNewLabel_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblNewLabel_1_1_2);

		Component rigidArea_15_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_15_1_2);

		lblDiaChi = new JLabel("Nơ Trang Long, Bình Thạnh, Thành phố Hồ Chí Minh");
		lblDiaChi.setVerticalAlignment(SwingConstants.TOP);
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_7.add(lblDiaChi);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_7.add(horizontalGlue_6);

		Component rigidArea_18 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_18.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_18);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);

		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_16);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(GD_ChiTietKhachHang.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setMaximumSize(new Dimension(120, 40));
		btnThoat.setPreferredSize(new Dimension(120, 40));
		horizontalBox_6.add(btnThoat);

		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_17);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		btnThoat.addActionListener(this);

		hienThiThongTinKhachHang();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	private void hienThiThongTinKhachHang() {
		KhachHang khachHang = khachHangDao.getKhachHangTheoMa(maKhachHang);
		lblMaKH.setText(khachHang.getMaKhachHang());
		lblTenKH.setText(khachHang.getHoTenKH());
		lblSoCMT.setText(khachHang.getSoCMT());
		lblSDT.setText(khachHang.getSoDienThoai());
		lblDiaChi.setText("<html>" + khachHang.getDiaChiKH() + "</html>");
		lblNgaySinh.setText(XuLyThoiGian.chuyenDateThanhString(khachHang.getNgaySinh()));
		lblEmail.setText(khachHang.getEmail());
	}

}
