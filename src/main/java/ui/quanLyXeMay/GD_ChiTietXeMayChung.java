package ui.quanLyXeMay;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import customoutput.ThongTinChiTietXeMay;
import customoutput.ThongTinChungXeMay;
import dao.ThongTinChungXeMayDao;
import other.DinhDangTien;
import ui.GD_DangNhap;

public class GD_ChiTietXeMayChung extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblXe;
	private DefaultTableModel modelXe;
	private ThongTinChungXeMay thongTinChungXeMay;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GD_ChiTietXeMayChung frame = new GD_ChiTietXeMayChung(new XeMay());
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GD_ChiTietXeMayChung(String tenXeMay) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/icon/motorbike_helmet_100px.png")));

		ThongTinChungXeMayDao thongTinChungXeMayDao = ThongTinChungXeMayDao.getInstance();

		thongTinChungXeMay = thongTinChungXeMayDao.getThongTinChungXeMayTheoTenXeMay(tenXeMay);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1422, 958);
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
		pnlAnh.setBounds(739, 63, 617, 479);
		contentPane.add(pnlAnh);
		pnlAnh.setLayout(null);

		JLabel lblAnh = new JLabel("img");
		lblAnh.setBackground(new Color(240, 240, 240));
		lblAnh.setBounds(1, 0, 616, 479);
		pnlAnh.add(lblAnh);
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.BOLD, 20));

		String anh = thongTinChungXeMay.getTenAnh();
		// Kiểm tra xem ảnh có null không
		Optional<String> optional = Optional.ofNullable(thongTinChungXeMay.getTenAnh());
		if (!optional.isPresent()) {
			lblAnh.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/pictures_folder_30px.png")));
			lblAnh.setText("img");
		} else {
			lblAnh.setIcon(new ImageIcon(new ImageIcon("ImgXe/" + anh).getImage().getScaledInstance(pnlAnh.getWidth(),
					pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			lblAnh.setText("");
		}

		JLabel lblNewLabel_2_1 = new JLabel("Tên xe:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(32, 63, 90, 30);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblTenXe = new JLabel("Honda AirBlade");
		lblTenXe.setVerticalAlignment(SwingConstants.TOP);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(147, 63, 580, 60);
		lblTenXe.setText("<html>" + thongTinChungXeMay.getTenXe().trim() + "</html>");
		contentPane.add(lblTenXe);

		JLabel lblNewLabel_2_1_1 = new JLabel("Hãng xe:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(32, 123, 90, 30);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblHangXe = new JLabel("XM123456");
		lblHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHangXe.setBounds(147, 123, 165, 30);
		lblHangXe.setText(thongTinChungXeMay.getHangXe().trim());
		contentPane.add(lblHangXe);

		JLabel lblNewLabel_2_1_2 = new JLabel("Dòng xe:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_2.setBounds(352, 123, 106, 30);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblDongXe = new JLabel("Air Blade");
		lblDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDongXe.setBounds(504, 123, 190, 30);
		lblDongXe.setText(thongTinChungXeMay.getDongXe().trim());
		contentPane.add(lblDongXe);

		JLabel lblNewLabel_2_1_3 = new JLabel("Loại xe:");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_3.setBounds(32, 174, 83, 30);
		contentPane.add(lblNewLabel_2_1_3);

		JLabel lblLoaiXe = new JLabel("Xe tay ga");
		lblLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiXe.setBounds(147, 174, 165, 30);
		lblLoaiXe.setText(thongTinChungXeMay.getLoaiXe().trim());
		contentPane.add(lblLoaiXe);

		JLabel lblNewLabel_2_1_4 = new JLabel("Số phân khối:");
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_4.setBounds(352, 174, 140, 30);
		contentPane.add(lblNewLabel_2_1_4);

		JLabel lblPhanKhoi = new JLabel("150 cc");
		lblPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhanKhoi.setBounds(504, 174, 68, 30);
		lblPhanKhoi.setText(thongTinChungXeMay.getSoPhanKhoi() + " cc");
		contentPane.add(lblPhanKhoi);

		JLabel lblNewLabel_2_1_5 = new JLabel("Số lượng:");
		lblNewLabel_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_5.setBounds(32, 228, 103, 30);
		contentPane.add(lblNewLabel_2_1_5);

		JLabel lblSoLuong = new JLabel("20 chiếc");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(147, 228, 125, 30);
		lblSoLuong.setText(thongTinChungXeMay.getSoLuongXe() + " chiếc");
		contentPane.add(lblSoLuong);

		JLabel lblNewLabel_2_1_9 = new JLabel("Giá nhập:");
		lblNewLabel_2_1_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_9.setBounds(352, 228, 103, 30);
		contentPane.add(lblNewLabel_2_1_9);

		JLabel lblGiaNhap = new JLabel("XM123456");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(504, 228, 223, 30);
		lblGiaNhap.setText(DinhDangTien.format(thongTinChungXeMay.getGiaBan()));
		contentPane.add(lblGiaNhap);

		JLabel lblNewLabel_2_1_10 = new JLabel("Bảo hành:");
		lblNewLabel_2_1_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_10.setBounds(32, 279, 116, 30);
		contentPane.add(lblNewLabel_2_1_10);

		JLabel lblBaoHanh = new JLabel("36 tháng");
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(147, 279, 116, 30);
		lblBaoHanh.setText(thongTinChungXeMay.getThoiGianBaoHanh() + " tháng");
		contentPane.add(lblBaoHanh);

		JLabel lblNewLabel_2_1_12 = new JLabel("Mô tả:");
		lblNewLabel_2_1_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_12.setBounds(32, 332, 83, 30);
		contentPane.add(lblNewLabel_2_1_12);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 375, 662, 167);
		contentPane.add(scrollPane);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setEditable(false);
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMoTa.setText(thongTinChungXeMay.getMoTa());

		txtMoTa.setLineWrap(true);
		txtMoTa.setWrapStyleWord(true);
		scrollPane.setViewportView(txtMoTa);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(1227, 867, 129, 35);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);

		JLabel lblNewLabel_2_1_12_1 = new JLabel("Hệ số bán:");
		lblNewLabel_2_1_12_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_12_1.setBounds(352, 279, 140, 30);
		contentPane.add(lblNewLabel_2_1_12_1);

		JLabel lblHeSoBan = new JLabel("0.1");
		lblHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeSoBan.setBounds(504, 279, 55, 30);
		contentPane.add(lblHeSoBan);

		JScrollPane scrollPaneXe = new JScrollPane();
		scrollPaneXe.setBounds(32, 598, 1324, 254);
		contentPane.add(scrollPaneXe);

		JLabel lblNewLabel_2_1_12_2 = new JLabel("Xe:");
		lblNewLabel_2_1_12_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1_12_2.setBounds(32, 560, 83, 30);
		contentPane.add(lblNewLabel_2_1_12_2);

		String[] colHeaderHoaDon = { "STT", "Mã xe", "Số khung", "Số sườn", "Màu", "Xuất xứ", "Ghi chú" };
		modelXe = new DefaultTableModel(colHeaderHoaDon, 0);
		tblXe = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXe.setRowHeight(35);//1324
		
		tblXe.getColumnModel().getColumn(0).setPreferredWidth(74);// STT
		tblXe.getColumnModel().getColumn(1).setPreferredWidth(150);// Mã xe
		tblXe.getColumnModel().getColumn(2).setPreferredWidth(300);// Tên xe
		tblXe.getColumnModel().getColumn(3).setPreferredWidth(300);// Tên xe
		tblXe.getColumnModel().getColumn(4).setPreferredWidth(200);// Tên xe
		tblXe.getColumnModel().getColumn(5).setPreferredWidth(200);// Tên xe
		tblXe.getColumnModel().getColumn(6).setPreferredWidth(100);// Tên xe
		
		JTableHeader tableHeader2 = tblXe.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		

		themListChiTietXeVaoBang();

		scrollPaneXe.setViewportView(tblXe);

	}

	private void themListChiTietXeVaoBang() {
		for (ThongTinChiTietXeMay thongTinChiTietXeMay : thongTinChungXeMay.getThongTinChiTietXeMays()) {
			Object[] datas = new Object[7];
			datas[0] = tblXe.getRowCount() + 1;// STT
			datas[1] = thongTinChiTietXeMay.getMaXe();// Mã xe
			datas[2] = thongTinChiTietXeMay.getSoKhung();// Số khung
			datas[3] = thongTinChiTietXeMay.getSoSuon();// Số sườn
			datas[4] = thongTinChiTietXeMay.getMauXe();// Màu xe
			datas[5] = thongTinChiTietXeMay.getXuatXu();// Xuất xứ
			datas[6] = thongTinChiTietXeMay.getSoLuong() == 0 ? "Đã bán" : "";// Ghi chú
			modelXe.addRow(datas);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);

	}
}
