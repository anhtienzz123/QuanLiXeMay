package ui.quanLyXeMay;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GD_ChiTietXeMay extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietXeMay frame = new GD_ChiTietXeMay();
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
	public GD_ChiTietXeMay() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		setLocationRelativeTo(null);
		setTitle("Thông tin xe máy");
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
		panel.setMinimumSize(new Dimension(900, 50));
		panel.setMaximumSize(new Dimension(32767, 50));
		horizontalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Thông tin xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setPreferredSize(new Dimension(900, 50));
		lblNewLabel.setMaximumSize(new Dimension(37217, 50));
		panel.add(lblNewLabel);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_9);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_8);

		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_2);

		JPanel pnlIMG = new JPanel();
		pnlIMG.setPreferredSize(new Dimension(300, 250));
		pnlIMG.setMaximumSize(new Dimension(400, 500));
		pnlIMG.setBackground(Color.GRAY);
		verticalBox_2.add(pnlIMG);
		pnlIMG.setLayout(new BoxLayout(pnlIMG, BoxLayout.X_AXIS));

		JLabel lblIMG = new JLabel("IMG");
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG.setMaximumSize(new Dimension(400, 500));
		lblIMG.setPreferredSize(new Dimension(300, 250));
		lblIMG.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlIMG.add(lblIMG);

		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_1);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_2);

		JLabel lblNewLabel_1_1 = new JLabel("Mã xe:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_1);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_3);

		JLabel lblMa = new JLabel("XM123456");
		lblMa.setForeground(Color.GRAY);
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblMa);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_3_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tên xe:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_1_2);

		Component rigidArea_3_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_3_2);

		JLabel lblTenXe = new JLabel("Honda Air Blade 2020");
		lblTenXe.setPreferredSize(new Dimension(250, 40));
		lblTenXe.setMaximumSize(new Dimension(250, 40));
		lblTenXe.setForeground(Color.GRAY);
		lblTenXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblTenXe);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_1);

		Component rigidArea_3_2_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_3_2_3);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setMaximumSize(new Dimension(20, 30));
		verticalBox_1.add(rigidArea_1);

		Box horizontalBox_3_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_1);

		Component rigidArea_3_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_3_2_1);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Hãng:");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblNewLabel_1_1_2_2);

		Component rigidArea_3_2_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_2_2.setPreferredSize(new Dimension(10, 20));
		rigidArea_3_2_2.setMaximumSize(new Dimension(10, 20));
		horizontalBox_3_1.add(rigidArea_3_2_2);

		JLabel lblHang = new JLabel("Harley Davidson");
		lblHang.setMaximumSize(new Dimension(200, 40));
		lblHang.setPreferredSize(new Dimension(200, 40));
		lblHang.setForeground(Color.GRAY);
		lblHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblHang);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_3_1.add(horizontalGlue_2);

		Component rigidArea_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_2_1);

		JLabel lblNewLabel_1_1_3 = new JLabel("Loại xe:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblNewLabel_1_1_3);

		Component rigidArea_3_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_3_3);

		JLabel lblLoaiXe = new JLabel("Xe tay ga");
		lblLoaiXe.setForeground(Color.GRAY);
		lblLoaiXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblLoaiXe);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3_1.add(horizontalGlue_4);

		Component rigidArea_3_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_3_1_1);

		JLabel lblNewLabel_1_1_2_4 = new JLabel("Dòng xe:");
		lblNewLabel_1_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblNewLabel_1_1_2_4);

		Component rigidArea_3_2_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_3_2_4);

		JLabel lblDongXe = new JLabel("Air Blade");
		lblDongXe.setForeground(Color.GRAY);
		lblDongXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_1.add(lblDongXe);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_3_1.add(horizontalGlue_5);

		Component rigidArea_3_2_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_1.add(rigidArea_3_2_3_1);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_5.setMaximumSize(new Dimension(20, 30));
		verticalBox_1.add(rigidArea_5);

		Box horizontalBox_3_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_2);

		Component rigidArea_3_2_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_2.add(rigidArea_3_2_1_1);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Xuất xứ:");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_2.add(lblNewLabel_1_1_2_2_1);

		Component rigidArea_3_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_2.add(rigidArea_3_2_2_1);

		JLabel lblXuatXu = new JLabel("Việt nam");
		lblXuatXu.setForeground(Color.GRAY);
		lblXuatXu.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_2.add(lblXuatXu);

		Component horizontalGlue_7 = Box.createHorizontalGlue();
		horizontalBox_3_2.add(horizontalGlue_7);

		JLabel lblNewLabel_1_1_4 = new JLabel("Số phân khối:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_2.add(lblNewLabel_1_1_4);

		Component rigidArea_3_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_2.add(rigidArea_3_4);

		JLabel lblPhanKhoi = new JLabel("150");
		lblPhanKhoi.setForeground(Color.GRAY);
		lblPhanKhoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_2.add(lblPhanKhoi);

		Component rigidArea_3_4_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_4_1.setMaximumSize(new Dimension(10, 20));
		rigidArea_3_4_1.setPreferredSize(new Dimension(10, 20));
		horizontalBox_3_2.add(rigidArea_3_4_1);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("cc.");
		lblNewLabel_1_1_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_2.add(lblNewLabel_1_1_1_2_1);
		
		Component rigidArea_3_2_3_4_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_2_3_4_4.setPreferredSize(new Dimension(85, 20));
		horizontalBox_3_2.add(rigidArea_3_2_3_4_4);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_3_2.add(horizontalGlue_6);

		Component rigidArea_3_2_3_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_2.add(rigidArea_3_2_3_2);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_7.setMaximumSize(new Dimension(20, 30));
		verticalBox_1.add(rigidArea_7);

		Box horizontalBox_3_3 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_3);

		Component rigidArea_2_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_3.add(rigidArea_2_3);

		JLabel lblNewLabel_1_1_2_5 = new JLabel("Số lượng:");
		lblNewLabel_1_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_3.add(lblNewLabel_1_1_2_5);

		Component rigidArea_3_2_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_3.add(rigidArea_3_2_5);

		JLabel lblSoLuong = new JLabel("1000");
		lblSoLuong.setForeground(Color.GRAY);
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_3.add(lblSoLuong);

		Component rigidArea_3_4_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_4_1_1.setPreferredSize(new Dimension(10, 20));
		rigidArea_3_4_1_1.setMaximumSize(new Dimension(10, 20));
		horizontalBox_3_3.add(rigidArea_3_4_1_1);

		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("xe.");
		lblNewLabel_1_1_1_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_3.add(lblNewLabel_1_1_1_2_1_1);

		Component horizontalGlue_8 = Box.createHorizontalGlue();
		horizontalBox_3_3.add(horizontalGlue_8);

		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("Màu xe:");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_3.add(lblNewLabel_1_1_2_2_2);

		Component rigidArea_3_2_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_3.add(rigidArea_3_2_2_2);

		JLabel lblMau = new JLabel("Xanh dương");
		lblMau.setForeground(Color.GRAY);
		lblMau.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_3.add(lblMau);
		
		Component rigidArea_3_2_3_4_5 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_2_3_4_5.setPreferredSize(new Dimension(115, 20));
		horizontalBox_3_3.add(rigidArea_3_2_3_4_5);

		Component horizontalGlue_10 = Box.createHorizontalGlue();
		horizontalBox_3_3.add(horizontalGlue_10);

		Component rigidArea_3_2_3_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_3.add(rigidArea_3_2_3_2_1);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_6.setMaximumSize(new Dimension(20, 30));
		verticalBox_1.add(rigidArea_6);

		Box horizontalBox_3_4 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_3_4);

		Component rigidArea_2_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_4.add(rigidArea_2_4);

		JLabel lblNewLabel_1_1_5 = new JLabel("Giá nhập:");
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_4.add(lblNewLabel_1_1_5);

		Component rigidArea_3_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_4.add(rigidArea_3_5);

		JLabel lblGia = new JLabel("1500000000");
		lblGia.setForeground(Color.GRAY);
		lblGia.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_4.add(lblGia);

		Component rigidArea_3_4_1_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_4_1_1_1_1.setPreferredSize(new Dimension(10, 20));
		rigidArea_3_4_1_1_1_1.setMaximumSize(new Dimension(10, 20));
		horizontalBox_3_4.add(rigidArea_3_4_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2_1_1_1_1 = new JLabel("VNĐ.");
		lblNewLabel_1_1_1_2_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_4.add(lblNewLabel_1_1_1_2_1_1_1_1);

		Component horizontalGlue_11 = Box.createHorizontalGlue();
		horizontalBox_3_4.add(horizontalGlue_11);

		JLabel lblNewLabel_1_1_2_6 = new JLabel("Bảo hành:");
		lblNewLabel_1_1_2_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_4.add(lblNewLabel_1_1_2_6);

		Component rigidArea_3_2_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_4.add(rigidArea_3_2_6);

		JLabel lblBaoHanh = new JLabel("36");
		lblBaoHanh.setForeground(Color.GRAY);
		lblBaoHanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_4.add(lblBaoHanh);

		Component rigidArea_3_4_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_4_1_1_1.setPreferredSize(new Dimension(10, 20));
		rigidArea_3_4_1_1_1.setMaximumSize(new Dimension(10, 20));
		horizontalBox_3_4.add(rigidArea_3_4_1_1_1);

		JLabel lblNewLabel_1_1_1_2_1_1_1 = new JLabel("tháng.");
		lblNewLabel_1_1_1_2_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3_4.add(lblNewLabel_1_1_1_2_1_1_1);
		
		Component rigidArea_3_2_3_4_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_2_3_4_3.setPreferredSize(new Dimension(30, 20));
		horizontalBox_3_4.add(rigidArea_3_2_3_4_3);

		Component horizontalGlue_12 = Box.createHorizontalGlue();
		horizontalBox_3_4.add(horizontalGlue_12);

		Component rigidArea_3_2_3_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3_4.add(rigidArea_3_2_3_4);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_10);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_5);

		Component rigidArea_3_2_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_3_2_1_3);

		JLabel lblNewLabel_1_1_2_2_3 = new JLabel("Hệ số bán:");
		lblNewLabel_1_1_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblNewLabel_1_1_2_2_3);

		Component rigidArea_3_2_2_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_3_2_2_3);

		JLabel lblHeSo = new JLabel("3.5");
		lblHeSo.setMaximumSize(new Dimension(40, 40));
		lblHeSo.setPreferredSize(new Dimension(40, 40));
		lblHeSo.setForeground(Color.GRAY);
		lblHeSo.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblHeSo);

		Component horizontalGlue_13 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_13);

		JLabel lblNewLabel_1_1_6_1 = new JLabel("Số khung:");
		lblNewLabel_1_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblNewLabel_1_1_6_1);

		Component rigidArea_3_6_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_3_6_1);

		JLabel lblSoKhung_1 = new JLabel("XM123456");
		lblSoKhung_1.setForeground(Color.GRAY);
		lblSoKhung_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblSoKhung_1);

		Component horizontalGlue_14 = Box.createHorizontalGlue();
		horizontalBox_5.add(horizontalGlue_14);

		JLabel lblNewLabel_1_1_2_7_1 = new JLabel("Số sườn:");
		lblNewLabel_1_1_2_7_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblNewLabel_1_1_2_7_1);

		Component rigidArea_3_2_7_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_3_2_7_1);

		JLabel lblSoSuon_1 = new JLabel("Honda Air Blade 2020");
		lblSoSuon_1.setForeground(Color.GRAY);
		lblSoSuon_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblSoSuon_1);

		Component rigidArea_3_2_3_4_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_3_2_3_4_2);

		Component rigidArea_6_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_6_1.setMaximumSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_6_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_2_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_2_4_1);

		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setMaximumSize(new Dimension(100, 300));
		lblMT.setPreferredSize(new Dimension(100, 100));
		lblMT.setVerticalAlignment(SwingConstants.TOP);
		lblMT.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblMT);

		JScrollPane scrollPane = new JScrollPane();
		horizontalBox_2.add(scrollPane);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setEditable(false);
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(txtMoTa);

		Component rigidArea_3_2_3_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_3_2_3_4_1);

		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_11);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea);

		Component horizontalGlue_9 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_9);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setPreferredSize(new Dimension(100, 40));
		btnThoat.setMaximumSize(new Dimension(100, 40));
		horizontalBox_4.add(btnThoat);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_4);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		btnThoat.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}

}
