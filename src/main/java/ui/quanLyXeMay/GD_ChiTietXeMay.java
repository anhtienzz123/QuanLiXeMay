package ui.quanLyXeMay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.XeMay;
import other.DinhDangTien;

public class GD_ChiTietXeMay extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietXeMay frame = new GD_ChiTietXeMay(new XeMay());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_ChiTietXeMay(XeMay xeMay) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1422, 747);
		setLocationRelativeTo(null);
		setTitle("Thông tin xe máy");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1404, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông tin chi tiết xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1404, 50);
		panel.add(lblNewLabel);

		JPanel pnlAnh = new JPanel();
		pnlAnh.setBackground(Color.LIGHT_GRAY);
		pnlAnh.setBounds(739, 127, 617, 504);
		contentPane.add(pnlAnh);
		pnlAnh.setLayout(null);

		JLabel lblAnh = new JLabel("");
		lblAnh.setBounds(1, 0, 616, 504);
		pnlAnh.add(lblAnh);
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.BOLD, 20));

		String anh = xeMay.getTenAnh();
		// Kiểm tra xem ảnh có null không
		Optional<String> optional = Optional.ofNullable(xeMay.getTenAnh());
		if (!optional.isPresent()) {
			lblAnh.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/pictures_folder_30px.png")));
			lblAnh.setText("img");
		} else {
			lblAnh.setIcon(new ImageIcon(new ImageIcon("ImgXe/" + anh).getImage().getScaledInstance(pnlAnh.getWidth(),
					pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			lblAnh.setText("");
		}

		JLabel lblNewLabel_2 = new JLabel("Mã xe:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(32, 73, 83, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblMaXe = new JLabel("XM123456");
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(147, 73, 125, 30);
		lblMaXe.setText(xeMay.getMaXeMay().trim());
		contentPane.add(lblMaXe);

		JLabel lblNewLabel_2_1 = new JLabel("Tên xe:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(352, 73, 83, 30);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblTenXe = new JLabel("Honda AirBlade");
		lblTenXe.setVerticalAlignment(SwingConstants.TOP);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(504, 73, 852, 60);
		lblTenXe.setText("<html>" + xeMay.getTenXeMay().trim() + "</html>");
		contentPane.add(lblTenXe);

		JLabel lblNewLabel_2_1_1 = new JLabel("Hãng xe:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(32, 123, 90, 30);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblHangXe = new JLabel("XM123456");
		lblHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHangXe.setBounds(147, 123, 165, 30);
		lblHangXe.setText(xeMay.getDongXe().getHangXe().getTenHangXe().trim());
		contentPane.add(lblHangXe);

		JLabel lblNewLabel_2_1_2 = new JLabel("Dòng xe:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_2.setBounds(352, 123, 106, 30);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblDongXe = new JLabel("Air Blade");
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDongXe.setBounds(504, 123, 190, 30);
		lblDongXe.setText(xeMay.getDongXe().getTenDongXe().trim());
		contentPane.add(lblDongXe);

		JLabel lblNewLabel_2_1_3 = new JLabel("Loại xe:");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_3.setBounds(32, 174, 83, 30);
		contentPane.add(lblNewLabel_2_1_3);

		JLabel lblLoaiXe = new JLabel("Xe tay ga");
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiXe.setBounds(147, 174, 165, 30);
		lblLoaiXe.setText(xeMay.getLoaiXe().getTenLoaiXe().trim());
		contentPane.add(lblLoaiXe);

		JLabel lblNewLabel_2_1_4 = new JLabel("Số phân khối:");
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_4.setBounds(352, 174, 140, 30);
		contentPane.add(lblNewLabel_2_1_4);

		JLabel lblPhanKhoi = new JLabel("150 cc");
		lblPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhanKhoi.setBounds(504, 174, 68, 30);
		lblPhanKhoi.setText(xeMay.getSoPhanKhoi() + " cc");
		contentPane.add(lblPhanKhoi);

		JLabel lblNewLabel_2_1_5 = new JLabel("Số lượng:");
		lblNewLabel_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_5.setBounds(352, 228, 103, 30);
		contentPane.add(lblNewLabel_2_1_5);

		JLabel lblSoLuong = new JLabel("20 chiếc");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(504, 228, 106, 30);
		lblSoLuong.setText(xeMay.getSoLuong() + " chiếc");
		contentPane.add(lblSoLuong);

		JLabel lblNewLabel_2_1_6 = new JLabel("Màu xe:");
		lblNewLabel_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_6.setBounds(32, 275, 83, 30);
		contentPane.add(lblNewLabel_2_1_6);

		JLabel lblMauXe = new JLabel("Đỏ-Đen");
		lblMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMauXe.setBounds(147, 275, 193, 30);
		lblMauXe.setText(xeMay.getMauXe().trim());
		contentPane.add(lblMauXe);

		JLabel lblNewLabel_2_1_7 = new JLabel("Số khung:");
		lblNewLabel_2_1_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_7.setBounds(352, 324, 116, 30);
		contentPane.add(lblNewLabel_2_1_7);

		JLabel lblSoKhung = new JLabel("123456789012345");
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoKhung.setBounds(504, 324, 223, 30);
		lblSoKhung.setText(xeMay.getSoKhung().trim());
		contentPane.add(lblSoKhung);

		JLabel lblNewLabel_2_1_8 = new JLabel("Số sườn:");
		lblNewLabel_2_1_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_8.setBounds(32, 379, 106, 30);
		contentPane.add(lblNewLabel_2_1_8);

		JLabel lblSoSuon = new JLabel("123456789012");
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoSuon.setBounds(147, 379, 165, 30);
		lblSoSuon.setText(xeMay.getSoSuon());
		contentPane.add(lblSoSuon);

		JLabel lblNewLabel_2_1_9 = new JLabel("Giá nhập:");
		lblNewLabel_2_1_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_9.setBounds(352, 275, 103, 30);
		contentPane.add(lblNewLabel_2_1_9);

		JLabel lblGiaNhap = new JLabel("XM123456");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(504, 275, 223, 30);
		lblGiaNhap.setText(DinhDangTien.format(xeMay.getGiaNhap()));
		contentPane.add(lblGiaNhap);

		JLabel lblNewLabel_2_1_10 = new JLabel("Bảo hành:");
		lblNewLabel_2_1_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_10.setBounds(32, 324, 116, 30);
		contentPane.add(lblNewLabel_2_1_10);

		JLabel lblBaoHanh = new JLabel("36 tháng");
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(147, 324, 116, 30);
		lblBaoHanh.setText(xeMay.getThoiGianBaoHanh() + " tháng");
		contentPane.add(lblBaoHanh);

		JLabel lblNewLabel_2_1_12 = new JLabel("Mô tả:");
		lblNewLabel_2_1_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_12.setBounds(32, 430, 83, 30);
		contentPane.add(lblNewLabel_2_1_12);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 473, 662, 208);
		contentPane.add(scrollPane);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setEditable(false);
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMoTa.setText(xeMay.getMoTa());

		txtMoTa.setLineWrap(true);
		txtMoTa.setWrapStyleWord(true);
		scrollPane.setViewportView(txtMoTa);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(1227, 652, 129, 35);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);

		JLabel lblNewLabel_2_1_12_1 = new JLabel("Hệ số bán:");
		lblNewLabel_2_1_12_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_12_1.setBounds(352, 379, 140, 30);
		contentPane.add(lblNewLabel_2_1_12_1);

		JLabel lblHeSoBan = new JLabel("0.1");
		lblHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeSoBan.setBounds(504, 379, 55, 30);
		contentPane.add(lblHeSoBan);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Xuất xứ:");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_2_1.setBounds(32, 228, 106, 30);
		contentPane.add(lblNewLabel_2_1_2_1);

		JLabel lblXuatXu = new JLabel("Việt Nam");
		lblXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXuatXu.setBounds(147, 228, 165, 30);
		lblXuatXu.setText(xeMay.getXuatXu().getTenXuatXu().trim());
		contentPane.add(lblXuatXu);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}
}
