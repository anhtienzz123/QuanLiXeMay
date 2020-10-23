package ui.quanLyNhanVien;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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

public class GD_ChiTietNVHanhChinh extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThoat;
	private JLabel lblMatKhau;
	private JLabel lblQuyen;
	private JLabel lblTrinhDoHocVan;
	private JLabel lblChucVu;
	private JLabel lblDiaChi;
	private JLabel lblSDT;
	private JLabel lblNgaySinh;
	private JLabel lblTenNV;
	private JLabel lblLoaiNV;
	private JLabel lblMaNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietNVHanhChinh frame = new GD_ChiTietNVHanhChinh();
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
	public GD_ChiTietNVHanhChinh() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		setLocationRelativeTo(null);
		setTitle("Thông tin nhân viên");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBackground(new Color(0, 128, 0));
		panel.setPreferredSize(new Dimension(800, 50));
		horizontalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Nhân viên hành chính");
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
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1);
		
		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_15);
		
		lblMaNV = new JLabel("HC123456");
		lblMaNV.setForeground(Color.GRAY);
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblMaNV);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại nhân viên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1_1);
		
		Component rigidArea_15_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_15_1);
		
		 lblLoaiNV = new JLabel("Nhân viên hành chính");
		lblLoaiNV.setForeground(Color.GRAY);
		lblLoaiNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblLoaiNV);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_7);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_2);
		
		Component rigidArea_15_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_15_2);
		
		 lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setForeground(Color.GRAY);
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblTenNV);
		
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
		lblNgaySinh.setForeground(Color.GRAY);
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
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
		lblSDT.setForeground(Color.GRAY);
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblSDT);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_3);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3);
		
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
		lblDiaChi.setForeground(Color.GRAY);
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblDiaChi);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_7.add(horizontalGlue_6);
		
		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_1.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_1);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_11);
		
		JLabel lblNewLabel_1_4 = new JLabel("Chức vụ:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblNewLabel_1_4);
		
		Component rigidArea_15_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_15_4);
		
		 lblChucVu = new JLabel("Quản lý");
		lblChucVu.setForeground(Color.GRAY);
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblChucVu);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_4);
		
		Component rigidArea_5_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_5_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Trình độ học vấn:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblNewLabel_1_1_3);
		
		Component rigidArea_15_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_15_1_3);
		
		 lblTrinhDoHocVan = new JLabel("12/12");
		lblTrinhDoHocVan.setForeground(Color.GRAY);
		lblTrinhDoHocVan.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblTrinhDoHocVan);
		
		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_12.setPreferredSize(new Dimension(150, 20));
		horizontalBox_4.add(rigidArea_12);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_4);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);
		
		Component rigidArea_13 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_13);
		
		JLabel lblNewLabel_1_5 = new JLabel("Quyền truy cập:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblNewLabel_1_5);
		
		Component rigidArea_15_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_15_5);
		
		 lblQuyen = new JLabel("Admin");
		lblQuyen.setForeground(Color.GRAY);
		lblQuyen.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblQuyen);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_5);
		
		Component rigidArea_5_1_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_5_1_4);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblNewLabel_1_1_4);
		
		Component rigidArea_15_1_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_15_1_4);
		
		 lblMatKhau = new JLabel("123456789");
		lblMatKhau.setForeground(Color.GRAY);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblMatKhau);
		
		Component rigidArea_14 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_14.setPreferredSize(new Dimension(175, 20));
		horizontalBox_5.add(rigidArea_14);
		
		Component rigidArea_18 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_18.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_18);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);
		
		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_16);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue);
		
		 btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setMaximumSize(new Dimension(97, 40));
		btnThoat.setPreferredSize(new Dimension(97, 40));
		horizontalBox_6.add(btnThoat);
		
		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_17);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
