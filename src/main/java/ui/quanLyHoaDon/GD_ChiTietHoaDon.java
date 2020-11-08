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
import javax.swing.table.JTableHeader;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class GD_ChiTietHoaDon extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblHoaDon;
	private DefaultTableModel modelHoaDon;
	private JLabel lblMaHD;
	private JLabel lblNgayLapHD;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblMaKH;
	private JLabel lblTenKH;
	private JLabel lblSDT;
	private JLabel lblDiaChi;
	private JLabel lblSoCMT;
	private JLabel lblNgaySinh;
	private JButton btnThoat;

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
		setSize(1200, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1182, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hóa đơn");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1182, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin hóa đơn");
		lblNewLabel_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 63, 249, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1_1.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(528, 63, 287, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(null);
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(23, 92, 457, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(null);
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(528, 92, 623, 14);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 101, 136, 30);
		contentPane.add(lblNewLabel_1_2);
		
		 lblMaHD = new JLabel("HD123456");
		lblMaHD.setForeground(Color.BLACK);
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHD.setBounds(232, 101, 136, 30);
		contentPane.add(lblMaHD);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Ngày lập hóa đơn:");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(23, 144, 197, 30);
		contentPane.add(lblNewLabel_1_2_2);
		
		 lblNgayLapHD = new JLabel("11-11-2020");
		lblNgayLapHD.setForeground(Color.BLACK);
		lblNgayLapHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayLapHD.setBounds(232, 144, 136, 30);
		contentPane.add(lblNgayLapHD);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_3.setBounds(23, 187, 182, 30);
		contentPane.add(lblNewLabel_1_2_3);
		
		 lblMaNV = new JLabel("HC123456");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(232, 187, 136, 30);
		contentPane.add(lblMaNV);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_4.setBounds(23, 230, 182, 30);
		contentPane.add(lblNewLabel_1_2_4);
		
		 lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(232, 230, 270, 30);
		contentPane.add(lblTenNV);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_2_5.setForeground(Color.BLACK);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(529, 101, 197, 30);
		contentPane.add(lblNewLabel_1_2_5);
		
		 lblMaKH = new JLabel("KH123456");
		lblMaKH.setForeground(Color.BLACK);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKH.setBounds(718, 101, 136, 30);
		contentPane.add(lblMaKH);
		
		 lblTenKH = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKH.setForeground(Color.BLACK);
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKH.setBounds(718, 144, 389, 30);
		contentPane.add(lblTenKH);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_2_1.setBounds(529, 144, 182, 30);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_3_1.setBounds(529, 187, 182, 30);
		contentPane.add(lblNewLabel_1_2_3_1);
		
		 lblSDT = new JLabel("0123456789");
		lblSDT.setForeground(Color.BLACK);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSDT.setBounds(718, 187, 136, 30);
		contentPane.add(lblSDT);
		
		 lblDiaChi = new JLabel("12, Nguyễn Văn Bảo, phường 4, Quận Gò Vấp, TPHCM");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(616, 230, 554, 30);
		contentPane.add(lblDiaChi);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_4_1.setBounds(529, 230, 136, 30);
		contentPane.add(lblNewLabel_1_2_4_1);
		
		JLabel lblNewLabel_1_2_5_1 = new JLabel("Số CMT:");
		lblNewLabel_1_2_5_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5_1.setBounds(899, 101, 121, 30);
		contentPane.add(lblNewLabel_1_2_5_1);
		
		 lblSoCMT = new JLabel("123456789012");
		lblSoCMT.setForeground(Color.BLACK);
		lblSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoCMT.setBounds(1015, 101, 136, 30);
		contentPane.add(lblSoCMT);
		
		JLabel lblNewLabel_1_2_5_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_2_5_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5_1_1.setBounds(899, 187, 121, 30);
		contentPane.add(lblNewLabel_1_2_5_1_1);
		
		 lblNgaySinh = new JLabel("11-11-2020");
		lblNgaySinh.setForeground(Color.BLACK);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBounds(1015, 187, 136, 30);
		contentPane.add(lblNgaySinh);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(58, 181, 74));
		separator_2.setBorder(null);
		separator_2.setBounds(23, 302, 1128, 14);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_1_3.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(23, 273, 249, 30);
		contentPane.add(lblNewLabel_1_3);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setIcon(new ImageIcon(GD_ChiTietHoaDon.class.getResource("/img/baseline_close_white_24dp.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(1015, 810, 136, 30);
		contentPane.add(btnThoat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 329, 1128, 383);
		contentPane.add(scrollPane);



		String[] colHeaderHoaDon = { "STT", "Mã xe", "Tên xe", "hãng", "loại xe", "Màu sắc", "Số lượng", "Giá Bán", "Bảo hành"};
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setBackground(Color.WHITE);
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
		
		JTableHeader tableHeaderNVKyThuat = tblHoaDon.getTableHeader();
		tableHeaderNVKyThuat.setBackground(new Color(58, 181, 74));
		tableHeaderNVKyThuat.setForeground(Color.white);
		tableHeaderNVKyThuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 7; i++) {
			modelHoaDon.addRow(new Object[] { i, null, null, null });
		}
		
		btnThoat.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
}
