package ui.quanLyHoaDon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GD_ChiTietHoaDon extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblHoaDon;
	private DefaultTableModel modelHoaDon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ChiTietHoaDon frame = new GD_ChiTietHoaDon();
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
	public GD_ChiTietHoaDon() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GD_ChiTietHoaDon.class.getResource("/img/baseline_receipt_long_white_36dp.png")));
		setTitle("Hóa đơn");
		setSize(800, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
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

		JLabel lblNewLabel = new JLabel("Hóa đơn");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setMaximumSize(new Dimension(37017, 50));
		lblNewLabel.setPreferredSize(new Dimension(800, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1);

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1.setPreferredSize(new Dimension(170, 40));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_2);

		JLabel lblMaHD = new JLabel("KH123456");
		lblMaHD.setPreferredSize(new Dimension(150, 40));
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaHD);

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_1_1);

		Component horizontalGlue_1_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1_2);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_1_1.setPreferredSize(new Dimension(190, 40));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1_1);

		Component rigidArea_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_2_1);

		JLabel lblNgayLapHD = new JLabel("19/10/2020");
		lblNgayLapHD.setPreferredSize(new Dimension(150, 40));
		lblNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblNgayLapHD);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_7);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_1_2);

		JLabel lblNewLabel_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_2.setPreferredSize(new Dimension(170, 40));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_2);

		Component rigidArea_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_2_2);

		JLabel lblMaNV = new JLabel("NV123456");
		lblMaNV.setPreferredSize(new Dimension(150, 40));
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(lblMaNV);

		Component horizontalGlue_1_1 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tên NV:");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(80, 40));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_1_1);

		Component rigidArea_2_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_2_1_1);

		JLabel lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setPreferredSize(new Dimension(240, 40));
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(lblTenNV);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_1);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_8);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_1.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_1);

		Box horizontalBox_2_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_1);

		Component rigidArea_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_1_2_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_2_1.setPreferredSize(new Dimension(170, 40));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_1.add(lblNewLabel_1_2_1);

		Component rigidArea_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_2_2_1);

		JLabel lblMaKH = new JLabel("HD123456");
		lblMaKH.setPreferredSize(new Dimension(135, 40));
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_1.add(lblMaKH);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2_1.add(horizontalGlue_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Số CMT:");
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(120, 40));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_1.add(lblNewLabel_1_1_1_1);

		JLabel lblCMT = new JLabel("123456789012");
		lblCMT.setPreferredSize(new Dimension(150, 40));
		lblCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_1.add(lblCMT);

		Component rigidArea_2_1_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2_1_1_2_1.setPreferredSize(new Dimension(50, 20));
		horizontalBox_2_1.add(rigidArea_2_1_1_2_1);

		Component horizontalGlue_1_3 = Box.createHorizontalGlue();
		horizontalBox_2_1.add(horizontalGlue_1_3);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_1.add(rigidArea_5);

		Component rigidArea_3_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_2.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_2);

		Box horizontalBox_2_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_2);

		Component rigidArea_1_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_1_2_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Tên KH:");
		lblNewLabel_1_2_2.setPreferredSize(new Dimension(80, 40));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2.add(lblNewLabel_1_2_2);

		Component rigidArea_2_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_2_2_2);

		JLabel lblTenKH = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKH.setPreferredSize(new Dimension(240, 40));
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2.add(lblTenKH);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_2_2.add(horizontalGlue_3);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_2.setPreferredSize(new Dimension(120, 40));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_2.add(lblNewLabel_1_1_1_2);

		JLabel lblNgaySinh = new JLabel("30/04/2020");
		lblNgaySinh.setPreferredSize(new Dimension(150, 40));
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_2.add(lblNgaySinh);

		Component rigidArea_2_1_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2_1_1_2.setPreferredSize(new Dimension(60, 20));
		horizontalBox_2_2.add(rigidArea_2_1_1_2);

		Component horizontalGlue_1_6 = Box.createHorizontalGlue();
		horizontalBox_2_2.add(horizontalGlue_1_6);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_2.add(rigidArea_6);

		Component rigidArea_3_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_3.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_3);

		Box horizontalBox_2_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_3);

		Component rigidArea_1_2_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3.add(rigidArea_1_2_3);

		JLabel lblNewLabel_1_2_3 = new JLabel("SĐT:");
		lblNewLabel_1_2_3.setPreferredSize(new Dimension(80, 40));
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_3.add(lblNewLabel_1_2_3);

		Component rigidArea_2_2_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3.add(rigidArea_2_2_3);

		JLabel lblSDT = new JLabel("0123456789");
		lblSDT.setPreferredSize(new Dimension(155, 40));
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3.add(lblSDT);

		Component rigidArea_1_1_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3.add(rigidArea_1_1_1_3);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_3.setPreferredSize(new Dimension(80, 40));
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_3.add(lblNewLabel_1_1_1_3);

		Component rigidArea_2_1_1_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3.add(rigidArea_2_1_1_3);

		JLabel lblDiaChi = new JLabel("..........................................................");
		lblDiaChi.setMaximumSize(new Dimension(3701, 40));
		lblDiaChi.setPreferredSize(new Dimension(350, 40));
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_3.add(lblDiaChi);

		Component rigidArea_6_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_3.add(rigidArea_6_1);

		Component rigidArea_3_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_4.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_4);

		Box horizontalBox_2_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_4);

		Component rigidArea_1_2_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4.add(rigidArea_1_2_4);

		JLabel lblNewLabel_1_2_4 = new JLabel("Chi tiết hóa đơn:");
		lblNewLabel_1_2_4.setPreferredSize(new Dimension(170, 40));
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_4.add(lblNewLabel_1_2_4);

		Component horizontalGlue_1_4 = Box.createHorizontalGlue();
		horizontalBox_2_4.add(horizontalGlue_1_4);

		Component rigidArea_3_4_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_4_1);

		Box horizontalBox_2_4_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_4_1);

		Component rigidArea_1_2_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4_1.add(rigidArea_1_2_4_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(760, 300));
		horizontalBox_2_4_1.add(scrollPane);

		String[] colHeaderHoaDon = { "STT", "Mã xe", "Tên xe", "hãng", "loại xe", "Màu sắc", "Số lượng", "Giá Bán", "Bảo hành"};
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(30);
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(35);
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(70);
		tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(80);
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(85);
		tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(85);
		tblHoaDon.getColumnModel().getColumn(6).setPreferredWidth(61);
		tblHoaDon.getColumnModel().getColumn(7).setPreferredWidth(80);
		tblHoaDon.getColumnModel().getColumn(8).setPreferredWidth(63);
		scrollPane.setViewportView(tblHoaDon);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_4_1.add(rigidArea_4);

		Component rigidArea_3_5 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_5.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_5);

		Box horizontalBox_2_5 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2_5);

		Component rigidArea_1_2_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_5.add(rigidArea_1_2_5);

		JLabel lblNewLabel_1_2_5 = new JLabel("Tổng tiền:");
		lblNewLabel_1_2_5.setPreferredSize(new Dimension(110, 40));
		lblNewLabel_1_2_5.setForeground(Color.RED);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_5.add(lblNewLabel_1_2_5);

		Component rigidArea_2_2_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_5.add(rigidArea_2_2_5);

		JLabel lblTongTien = new JLabel("1.500.000.000 VNĐ");
		lblTongTien.setPreferredSize(new Dimension(350, 40));
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2_5.add(lblTongTien);

		Component rigidArea_1_1_1_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_5.add(rigidArea_1_1_1_5);

		Component horizontalGlue_1_5 = Box.createHorizontalGlue();
		horizontalBox_2_5.add(horizontalGlue_1_5);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setPreferredSize(new Dimension(150, 40));
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2_5.add(btnThoat);

		Component rigidArea_2_1_1_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2_5.add(rigidArea_2_1_1_5);

		Component rigidArea_3_5_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3_5_1.setPreferredSize(new Dimension(20, 30));
		verticalBox.add(rigidArea_3_5_1);
		
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}

}
