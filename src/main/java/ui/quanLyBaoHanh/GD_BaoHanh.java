package ui.quanLyBaoHanh;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventObject;
import java.util.List;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ui.App;
import ui.ChuyenManHinh;
import ui.DanhMuc;
import ui.quanLyHopDong.GD_HopDong;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class GD_BaoHanh extends JPanel implements ActionListener, MouseListener {
	private JButton btnCapNhat;
	private DefaultTableModel modelBaoHanh;
	private JTable tblBaoHanh;
	private JButton btnXemChiTiet;
	private JButton btnQuayLai;

	/**
	 * Create the panel.
	 */
	public GD_BaoHanh() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bảo hành");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollpaneBaoHanh = new JScrollPane();
		scrollpaneBaoHanh.setBounds(29, 540, 1385, 182);
		add(scrollpaneBaoHanh);

		 btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(937, 747, 218, 40);
		add(btnXemChiTiet);

		JLabel lblDanhSach = new JLabel("Danh sách các đợt bảo hành");
		lblDanhSach.setForeground(new Color(58, 181, 74));
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSach.setBounds(29, 474, 272, 30);
		add(lblDanhSach);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 512, 1385, 11);
		add(separator);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCapNhat.setBackground(new Color(58, 181, 74));
		btnCapNhat.setBounds(1204, 747, 203, 40);
		add(btnCapNhat);

		String[] colHeaderBaoHanh = { "STT", "Đợt bảo hành", "Thời gian", "Ghi chú" };
		modelBaoHanh = new DefaultTableModel(colHeaderBaoHanh, 0);
		tblBaoHanh = new JTable(modelBaoHanh) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblBaoHanh.setRowHeight(25);
		scrollpaneBaoHanh.setViewportView(tblBaoHanh);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 817, 1450, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1450, 133);
		pnlLogo.add(lblLogo);
		
		 btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setIcon(new ImageIcon(GD_BaoHanh.class.getResource("/img/baseline_close_white_24dp.png")));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setBounds(29, 747, 164, 40);
		add(btnQuayLai);
		
		JLabel lblTTPBH = new JLabel("Thông tin phiếu bảo hành");
		lblTTPBH.setForeground(new Color(58, 181, 74));
		lblTTPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTTPBH.setBounds(29, 61, 272, 30);
		add(lblTTPBH);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(29, 104, 1385, 11);
		add(separator_1);
		
		JLabel lblTTKH = new JLabel("Thông tin khách hàng");
		lblTTKH.setForeground(new Color(58, 181, 74));
		lblTTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTTKH.setBounds(70, 181, 211, 30);
		add(lblTTKH);
		
		JLabel lblMPBH = new JLabel("Mã phiếu bảo hành:");
		lblMPBH.setForeground(Color.BLACK);
		lblMPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMPBH.setBounds(70, 131, 188, 30);
		add(lblMPBH);
		
		JLabel lblMaPhieuBaoHanh = new JLabel("BH123456");
		lblMaPhieuBaoHanh.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh.setBounds(270, 131, 111, 30);
		add(lblMaPhieuBaoHanh);
		
		JLabel lblMHD = new JLabel("Mã hợp đồng:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBounds(543, 131, 188, 30);
		add(lblMHD);
		
		JLabel lblMaHopDong = new JLabel("HD123456");
		lblMaHopDong.setForeground(Color.BLACK);
		lblMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHopDong.setBounds(743, 131, 111, 30);
		add(lblMaHopDong);
		
		JLabel lblNLHD = new JLabel("Ngày lập hợp đồng");
		lblNLHD.setForeground(Color.BLACK);
		lblNLHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNLHD.setBounds(1013, 131, 188, 30);
		add(lblNLHD);
		
		JLabel lblNgay = new JLabel("01-11-2020");
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(1214, 131, 111, 30);
		add(lblNgay);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(58, 181, 74));
		separator_1_1.setBounds(70, 224, 589, 11);
		add(separator_1_1);
		
		JLabel lblThngTinXe = new JLabel("Thông tin xe");
		lblThngTinXe.setForeground(new Color(58, 181, 74));
		lblThngTinXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinXe.setBounds(745, 181, 139, 30);
		add(lblThngTinXe);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(58, 181, 74));
		separator_1_1_1.setBounds(743, 224, 633, 11);
		add(separator_1_1_1);
		
		JLabel lblTnKhchHng = new JLabel("Mã khách hàng:");
		lblTnKhchHng.setForeground(Color.BLACK);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng.setBounds(70, 246, 164, 30);
		add(lblTnKhchHng);
		
		JLabel lblMaKhachHang = new JLabel("KH123456");
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBounds(270, 246, 358, 30);
		add(lblMaKhachHang);
		
		JLabel lblTnKhchHng_1 = new JLabel("Tên khách hàng:");
		lblTnKhchHng_1.setForeground(Color.BLACK);
		lblTnKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1.setBounds(70, 300, 164, 30);
		add(lblTnKhchHng_1);
		
		JLabel lblTenKhachHang = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBounds(270, 300, 358, 30);
		add(lblTenKhachHang);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(Color.BLACK);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSinThoi.setBounds(70, 358, 164, 30);
		add(lblSinThoi);
		
		JLabel lblSoDienThoai = new JLabel("0123456789");
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(270, 358, 358, 30);
		add(lblSoDienThoai);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaCh.setBounds(70, 416, 86, 30);
		add(lblaCh);
		
		JLabel lblDiaChi = new JLabel("BH123456");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiaChi.setBounds(161, 416, 467, 30);
		add(lblDiaChi);
		
		JLabel lblMXe = new JLabel("Mã xe:");
		lblMXe.setForeground(Color.BLACK);
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMXe.setBounds(743, 246, 86, 30);
		add(lblMXe);
		
		JLabel lblMaXe = new JLabel("KH123456");
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(837, 246, 127, 30);
		add(lblMaXe);
		
		JLabel lblSKhung = new JLabel("Số khung:");
		lblSKhung.setForeground(Color.BLACK);
		lblSKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSKhung.setBounds(743, 358, 100, 30);
		add(lblSKhung);
		
		JLabel lblMaPhieuBaoHanh_1_2_1 = new JLabel("SK1234567890123");
		lblMaPhieuBaoHanh_1_2_1.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh_1_2_1.setBounds(872, 358, 188, 30);
		add(lblMaPhieuBaoHanh_1_2_1);
		
		JLabel lblSSn = new JLabel("Số sườn:");
		lblSSn.setForeground(Color.BLACK);
		lblSSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSSn.setBounds(743, 416, 86, 30);
		add(lblSSn);
		
		JLabel lblTnKhchHng_1_1 = new JLabel("Tên xe:");
		lblTnKhchHng_1_1.setForeground(Color.BLACK);
		lblTnKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1_1.setBounds(976, 246, 86, 30);
		add(lblTnKhchHng_1_1);
		
		JLabel lblMaPhieuBaoHanh_1_1_1 = new JLabel("Honda Air Blade");
		lblMaPhieuBaoHanh_1_1_1.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh_1_1_1.setBounds(1080, 246, 358, 30);
		add(lblMaPhieuBaoHanh_1_1_1);
		
		JLabel lblMaPhieuBaoHanh_1_2_1_1 = new JLabel("SK1234567890123");
		lblMaPhieuBaoHanh_1_2_1_1.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh_1_2_1_1.setBounds(872, 416, 188, 30);
		add(lblMaPhieuBaoHanh_1_2_1_1);
		
		JLabel lblHng = new JLabel("Xuất Xứ:");
		lblHng.setForeground(Color.BLACK);
		lblHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng.setBounds(743, 300, 100, 30);
		add(lblHng);
		
		JLabel lblHng_1 = new JLabel("Hãng:");
		lblHng_1.setForeground(Color.BLACK);
		lblHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng_1.setBounds(976, 300, 100, 30);
		add(lblHng_1);
		
		JLabel lblVitNam = new JLabel("Việt Nam");
		lblVitNam.setForeground(Color.BLACK);
		lblVitNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVitNam.setBounds(837, 300, 127, 30);
		add(lblVitNam);
		
		JLabel lblHonda = new JLabel("Honda");
		lblHonda.setForeground(Color.BLACK);
		lblHonda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHonda.setBounds(1080, 300, 127, 30);
		add(lblHonda);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 7; i++) {
			modelBaoHanh.addRow(new Object[] { i, "Đợt "+i, null, null });
		}
		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnCapNhat.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnQuayLai.addActionListener(this);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnQuayLai)) {
			chuyenManHinh(new GD_HopDong());
		} if (o.equals(btnCapNhat)) {
			chuyenManHinh(new GD_CapNhatBaoHanh());
		}
		
		if (o.equals(btnXemChiTiet)) {
			chuyenManHinh(new GD_ChiTietBaoHanh());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void chuyenManHinh(JPanel newJpanel) {
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(newJpanel);
		this.validate();
		this.repaint();
	}
}
