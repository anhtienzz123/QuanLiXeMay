package ui.quanLyHopDong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import other.DocSo;

public class GD_ChiTietHopDong extends JFrame implements ActionListener{

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
	private JLabel lblSDTNV;
	private JLabel lblDiaChiNV;
	private JLabel lblMaKH;
	private JLabel lblCMT;
	private JLabel lblTenKH;
	private JLabel lblNgaySinhKH;
	private JLabel lblSDTKH;
	private JLabel lblDiaChiKH;
	private JLabel lblMaXe;
	private JLabel lblTenXe;
	private JLabel lblHangXe;
	private JLabel lblLoaiXe;
	private JLabel lblDongXe;
	private JLabel lblPhanKhoi;
	private JLabel lblXuatSu;
	private JLabel lblMau;
	private JLabel lblSoKhung;
	private JLabel lblSoSuon;
	private JLabel lblThoiGianBaoHanh;
	private JLabel lblGiaBanSo;
	private JLabel lblGiaBanChu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietHopDong frame = new GD_ChiTietHopDong();
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
	public GD_ChiTietHopDong() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GD_ChiTietHopDong.class.getResource("/img/baseline_receipt_long_white_36dp.png")));
		setTitle("Hợp đồng");
		setSize(950, 960);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
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
		panel.setBackground(new Color(0, 128, 0));
		panel.setPreferredSize(new Dimension(800, 50));
		panel.setMaximumSize(new Dimension(32767, 50));
		horizontalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Hợp đồng bán xe máy");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setMaximumSize(new Dimension(37017, 50));
		lblNewLabel.setPreferredSize(new Dimension(800, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1);

		JLabel lblNewLabel_1 = new JLabel("Mã hợp đồng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_2);

		 lblMaHD = new JLabel("KH123456");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaHD);

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1_1);

		Component horizontalGlue_1_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1_2);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày lập hợp đồng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1_1);

		Component rigidArea_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_2_1);

		 lblNgayLapHD = new JLabel("19/10/2020");
		lblNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblNgayLapHD);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_7);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3);
		
		Box horizontalBox_2_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_6);
		
		Component rigidArea_1_2_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_6.add(rigidArea_1_2_6);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("Thông tin nhân viên lập hợp đồng:");
		lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		horizontalBox_2_6.add(lblNewLabel_1_2_6);
		
		Component horizontalGlue_1_7 = Box.createHorizontalGlue();
		horizontalBox_2_6.add(horizontalGlue_1_7);
		
		Component rigidArea_8_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_6.add(rigidArea_8_1);
		
		Component rigidArea_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2.add(rigidArea_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_2);
		
		Component rigidArea_2_2_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_2_2_1_3);

		 lblMaNV = new JLabel("NV123456");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(lblMaNV);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2.add(rigidArea_4);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tên NV:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_1_1);

		Component rigidArea_2_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_2_1_1);

		 lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(lblTenNV);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_1);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_8);
		
		Component rigidArea_3_2_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_2_1);
		
		Box horizontalBox_2_2_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_2_1);
		
		Component rigidArea_1_2_4_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_4_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_2_1.add(rigidArea_1_2_4_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2_1.add(lblNewLabel_1_1_1_2_1);
		
		Component rigidArea_2_2_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_2_2_1_2);
		
		 lblNgaySinhNV = new JLabel("30/04/2020");
		lblNgaySinhNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2_1.add(lblNgaySinhNV);
		
		Component rigidArea_2_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_2_2_2_1);
		
		JLabel lblNewLabel_1_2_3_2 = new JLabel("SĐT:");
		horizontalBox_2_2_1.add(lblNewLabel_1_2_3_2);
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		Component rigidArea_2_2_1_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_2_2_1_4);
		
		 lblSDTNV = new JLabel("0123456789");
		horizontalBox_2_2_1.add(lblSDTNV);
		lblSDTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		Component horizontalGlue_1_6_1 = Box.createHorizontalGlue();
		horizontalBox_2_2_1.add(horizontalGlue_1_6_1);
		
		Component rigidArea_6_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2_1.add(rigidArea_6_2);
		
		Component rigidArea_3_3_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_3_2);
		
		Box horizontalBox_2_3_2_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3_2_1);
		
		Component rigidArea_1_2_7_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_7_1_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_3_2_1.add(rigidArea_1_2_7_1_1);
		
		JLabel lblNewLabel_1_1_1_3_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_3_2_1.add(lblNewLabel_1_1_1_3_1_1);
		
		Component rigidArea_2_1_1_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_2_1.add(rigidArea_2_1_1_3_1_1);
		
		 lblDiaChiNV = new JLabel("..........................................................");
		lblDiaChiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_2_1.add(lblDiaChiNV);
		
		Component horizontalGlue_5_1_1 = Box.createHorizontalGlue();
		horizontalBox_2_3_2_1.add(horizontalGlue_5_1_1);
		
		Component rigidArea_6_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_2_1.add(rigidArea_6_1_2_1);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1);
		
		Box horizontalBox_2_6_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_6_1);
		
		Component rigidArea_1_2_6_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_6_1.add(rigidArea_1_2_6_1);
		
		JLabel lblNewLabel_1_2_6_1 = new JLabel("Thông tin khách hàng:");
		lblNewLabel_1_2_6_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		horizontalBox_2_6_1.add(lblNewLabel_1_2_6_1);
		
		Component horizontalGlue_1_7_1 = Box.createHorizontalGlue();
		horizontalBox_2_6_1.add(horizontalGlue_1_7_1);
		
		Component rigidArea_8_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_6_1.add(rigidArea_8_1_1);
		
		Component rigidArea_3_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_1_1);

		Box horizontalBox_2_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_1);
		
		Component rigidArea_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_1.add(rigidArea_1_2_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mã KH:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_1.add(lblNewLabel_1_2_1);

		Component rigidArea_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_2_2_1);

		 lblMaKH = new JLabel("HD123456");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_1.add(lblMaKH);
		
				Component rigidArea_2_1_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
				rigidArea_2_1_1_2_1.setPreferredSize(new Dimension(50, 20));
				horizontalBox_2_1.add(rigidArea_2_1_1_2_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số CMT:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_1.add(lblNewLabel_1_1_1_1);

		 lblCMT = new JLabel("123456789012");
		lblCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_1.add(lblCMT);
		
		Component rigidArea_2_1_1_2_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2_1_1_2_1_1.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_1.add(rigidArea_2_1_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Tên KH:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_1.add(lblNewLabel_1_2_2);
		
		Component rigidArea_2_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_2_2_2);
		
		 lblTenKH = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_1.add(lblTenKH);

		Component horizontalGlue_1_3 = Box.createHorizontalGlue();
		horizontalBox_2_1.add(horizontalGlue_1_3);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_5);

		Component rigidArea_3_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_2);

		Box horizontalBox_2_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_2);
		
		Component rigidArea_1_2_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_4.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_2.add(rigidArea_1_2_4);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2.add(lblNewLabel_1_1_1_2);
		
		Component rigidArea_2_2_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_2_2_1_1);

		 lblNgaySinhKH = new JLabel("30/04/2020");
		lblNgaySinhKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2.add(lblNgaySinhKH);

		Component rigidArea_2_1_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2_1_1_2.setPreferredSize(new Dimension(60, 20));
		horizontalBox_2_2.add(rigidArea_2_1_1_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("SĐT:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2.add(lblNewLabel_1_2_3);
		
		Component rigidArea_2_2_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_2_2_3);
		
		 lblSDTKH = new JLabel("0123456789");
		lblSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2.add(lblSDTKH);

		Component horizontalGlue_1_6 = Box.createHorizontalGlue();
		horizontalBox_2_2.add(horizontalGlue_1_6);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_6);

		Component rigidArea_3_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_3);
		
		Box horizontalBox_2_3_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3_2);
		
		Component rigidArea_1_2_7_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_7_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_3_2.add(rigidArea_1_2_7_1);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_3_2.add(lblNewLabel_1_1_1_3_1);
		
		Component rigidArea_2_1_1_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_2.add(rigidArea_2_1_1_3_1);
		
		 lblDiaChiKH = new JLabel("..........................................................");
		lblDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_2.add(lblDiaChiKH);
		
		Component horizontalGlue_5_1 = Box.createHorizontalGlue();
		horizontalBox_2_3_2.add(horizontalGlue_5_1);
		
		Component rigidArea_6_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_2.add(rigidArea_6_1_2);
		
		Component rigidArea_3_3_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_3_1_1_1);
		
		Box horizontalBox_2_3_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3_1_1);
		
		Component rigidArea_1_2_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1_1.add(rigidArea_1_2_3_1_1);
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("Thông tin xe:");
		lblNewLabel_1_2_3_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		horizontalBox_2_3_1_1.add(lblNewLabel_1_2_3_1_1);
		
		Component horizontalGlue_4_1 = Box.createHorizontalGlue();
		horizontalBox_2_3_1_1.add(horizontalGlue_4_1);
		
		Component rigidArea_6_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1_1.add(rigidArea_6_1_1_1);
		
		Component rigidArea_3_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_3_1_1);
		
		Box horizontalBox_2_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_4);
		
		Component rigidArea_1_2_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_2.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_4.add(rigidArea_1_2_2);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Mã xe:");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_4.add(lblNewLabel_1_2_4);
		
		Component rigidArea_2_1_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4.add(rigidArea_2_1_1_1_1);
		
		 lblMaXe = new JLabel("NV123456");
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_4.add(lblMaXe);
		
		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4_1.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_4.add(rigidArea_4_1);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Tên xe:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_4.add(lblNewLabel_1_1_1_3);
		
		Component rigidArea_2_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4.add(rigidArea_2_1_1_1);
		
		 lblTenXe = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_4.add(lblTenXe);
		
		Component rigidArea_2_1_1_1_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4.add(rigidArea_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_7 = new JLabel("Hãng:");
		lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_4.add(lblNewLabel_1_2_7);
		
		Component rigidArea_2_1_1_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4.add(rigidArea_2_1_1_1_1_1);
		
		 lblHangXe = new JLabel("NV123456");
		lblHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_4.add(lblHangXe);
		
		Component horizontalGlue_1_1 = Box.createHorizontalGlue();
		horizontalBox_2_4.add(horizontalGlue_1_1);
		
		Component rigidArea_8_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4.add(rigidArea_8_2);
		
		Component rigidArea_3_1_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_2);
		
		Box horizontalBox_2_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_7);
		
		Component rigidArea_1_2_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_3.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_7.add(rigidArea_1_2_3);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("Loại xe:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_7.add(lblNewLabel_1_1_1_4);
		
		Component rigidArea_2_1_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_7.add(rigidArea_2_1_1_3);
		
		 lblLoaiXe = new JLabel("Nguyễn Trần Nhật Hào");
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_7.add(lblLoaiXe);
		
		Component rigidArea_4_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4_3.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_7.add(rigidArea_4_3);
		
		JLabel lblNewLabel_1_2_8 = new JLabel("Dòng xe:");
		lblNewLabel_1_2_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_7.add(lblNewLabel_1_2_8);
		
		Component rigidArea_2_1_1_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_7.add(rigidArea_2_1_1_4_1);
		
		 lblDongXe = new JLabel("NV123456");
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_7.add(lblDongXe);
		
		Component rigidArea_4_3_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4_3_1.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_7.add(rigidArea_4_3_1);
		
		JLabel lblNewLabel_1_2_8_1 = new JLabel("Phân khối:");
		lblNewLabel_1_2_8_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_7.add(lblNewLabel_1_2_8_1);
		
		Component rigidArea_2_1_1_4_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_7.add(rigidArea_2_1_1_4_1_1);
		
		 lblPhanKhoi = new JLabel("175");
		lblPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_7.add(lblPhanKhoi);
		
		JLabel lblMaNV_3_1_1 = new JLabel(" cc.");
		lblMaNV_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_7.add(lblMaNV_3_1_1);
		
		Component horizontalGlue_1_4 = Box.createHorizontalGlue();
		horizontalBox_2_7.add(horizontalGlue_1_4);
		
		Component rigidArea_8_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_7.add(rigidArea_8_3);
		
		Component rigidArea_3_1_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_3);
		
		Box horizontalBox_2_8 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_8);
		
		Component rigidArea_1_2_8 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_8.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_8.add(rigidArea_1_2_8);
		
		JLabel lblNewLabel_1_1_1_5 = new JLabel("Xuất sứ:");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_8.add(lblNewLabel_1_1_1_5);
		
		Component rigidArea_2_1_1_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_8.add(rigidArea_2_1_1_4);
		
		 lblXuatSu = new JLabel("Nguyễn Trần Nhật Hào");
		lblXuatSu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_8.add(lblXuatSu);
		
		Component rigidArea_4_3_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4_3_2.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_8.add(rigidArea_4_3_2);
		
		JLabel lblNewLabel_1_1_1_5_1 = new JLabel("Màu xe:");
		lblNewLabel_1_1_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_8.add(lblNewLabel_1_1_1_5_1);
		
		Component rigidArea_2_1_1_4_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_8.add(rigidArea_2_1_1_4_2);
		
		 lblMau = new JLabel("Xanh dương");
		lblMau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_8.add(lblMau);
		
		Component horizontalGlue_1_8 = Box.createHorizontalGlue();
		horizontalBox_2_8.add(horizontalGlue_1_8);
		
		Component rigidArea_8_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_8.add(rigidArea_8_4);
		
		Component rigidArea_3_1_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_4);
		
		Box horizontalBox_2_8_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_8_1);
		
		Component rigidArea_1_2_8_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_8_2.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_8_1.add(rigidArea_1_2_8_2);
		
		JLabel lblNewLabel_1_1_1_5_2 = new JLabel("Số khung:");
		lblNewLabel_1_1_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_8_1.add(lblNewLabel_1_1_1_5_2);
		
		Component rigidArea_2_1_1_4_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_8_1.add(rigidArea_2_1_1_4_3);
		
		 lblSoKhung = new JLabel("123456789012345");
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_8_1.add(lblSoKhung);
		
		Component rigidArea_4_3_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4_3_2_1.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_8_1.add(rigidArea_4_3_2_1);
		
		JLabel lblNewLabel_1_1_1_5_1_1 = new JLabel("Số sườn:");
		lblNewLabel_1_1_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_8_1.add(lblNewLabel_1_1_1_5_1_1);
		
		Component rigidArea_2_1_1_4_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_8_1.add(rigidArea_2_1_1_4_2_1);
		
		 lblSoSuon = new JLabel("123456789012345");
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_8_1.add(lblSoSuon);
		
		Component horizontalGlue_1_8_1 = Box.createHorizontalGlue();
		horizontalBox_2_8_1.add(horizontalGlue_1_8_1);
		
		Component rigidArea_8_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_8_1.add(rigidArea_8_4_1);
		
		Component rigidArea_3_1_4_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1_4_1);
		
		Box horizontalBox_2_3_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3_1);
		
		Component rigidArea_1_2_8_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_8_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_3_1.add(rigidArea_1_2_8_1);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Thời gian bảo hành:");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_3_1.add(lblNewLabel_1_2_3_1);
		
		Component rigidArea_2_2_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1.add(rigidArea_2_2_3_1);
		
		 lblThoiGianBaoHanh = new JLabel("36");
		lblThoiGianBaoHanh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblThoiGianBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1.add(lblThoiGianBaoHanh);
		
		JLabel lblThng_1 = new JLabel("  tháng.");
		lblThng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1.add(lblThng_1);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_2_3_1.add(horizontalGlue_4);
		
		Component rigidArea_6_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1.add(rigidArea_6_1_1);

		Component rigidArea_3_4 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_4);
		
		Box horizontalBox_2_3_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3_1_2);
		
		Component rigidArea_1_2_8_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_8_1_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_3_1_2.add(rigidArea_1_2_8_1_1);
		
		JLabel lblNewLabel_1_2_3_1_2 = new JLabel("Giá bán:");
		lblNewLabel_1_2_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_3_1_2.add(lblNewLabel_1_2_3_1_2);
		
		Component rigidArea_2_2_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1_2.add(rigidArea_2_2_3_1_1);
		
		 lblGiaBanSo = new JLabel("53000000");
		lblGiaBanSo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGiaBanSo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1_2.add(lblGiaBanSo);
		
		JLabel lblThng_1_1_1_1 = new JLabel("  VNĐ.");
		lblThng_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1_2.add(lblThng_1_1_1_1);
		
		Component horizontalGlue_4_2 = Box.createHorizontalGlue();
		horizontalBox_2_3_1_2.add(horizontalGlue_4_2);
		
		Component rigidArea_6_1_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1_2.add(rigidArea_6_1_1_2);
		
		Component rigidArea_3_4_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_4_1);
		
		Box horizontalBox_2_3_1_2_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3_1_2_1);
		
		Component rigidArea_1_2_8_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_8_1_1_1.setPreferredSize(new Dimension(80, 20));
		horizontalBox_2_3_1_2_1.add(rigidArea_1_2_8_1_1_1);
		
		JLabel lblNewLabel_1_2_3_1_2_1 = new JLabel("(bằng chữ:");
		lblNewLabel_1_2_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1_2_1.add(lblNewLabel_1_2_3_1_2_1);
		
		Component rigidArea_2_2_3_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1_2_1.add(rigidArea_2_2_3_1_1_1);
		
		 lblGiaBanChu = new JLabel();
		lblGiaBanChu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1_2_1.add(lblGiaBanChu);
		lblGiaBanChu.setText(new DocSo().readNum(lblGiaBanSo.getText().trim()));
		
		JLabel lblThng_1_1_1 = new JLabel("đồng.)");
		lblThng_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3_1_2_1.add(lblThng_1_1_1);
		
		Component horizontalGlue_4_2_1 = Box.createHorizontalGlue();
		horizontalBox_2_3_1_2_1.add(horizontalGlue_4_2_1);
		
		Component rigidArea_6_1_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3_1_2_1.add(rigidArea_6_1_1_2_1);
		
		Component rigidArea_3_4_1_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_4_1_1);

		Box horizontalBox_2_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_5);

		Component rigidArea_1_2_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_5.add(rigidArea_1_2_5);

		Component horizontalGlue_1_5 = Box.createHorizontalGlue();
		horizontalBox_2_5.add(horizontalGlue_1_5);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setMaximumSize(new Dimension(150, 35));
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setPreferredSize(new Dimension(150, 35));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_5.add(btnThoat);

		Component rigidArea_2_1_1_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_5.add(rigidArea_2_1_1_5);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}

}
