package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import dao.ThongKeDao;
import other.DinhDangTien;
import other.OutputNhanVien_HoaDonLap;

public class GD_ThongKeNgay extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlThongKe;
//	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JTable tblDoanhThu;
	private JButton btnXemChiTiet;

	private LocalDate localDate;
	private ThongKeDao thongKeDao;
	private JLabel lblNgay;
	private JLabel lblMaNV;
	private JLabel lblTenNV;
	private JLabel lblDoanhThu;
	private JLabel lblSoHoaDon;
	private JLabel lblSoXe;
	private JLabel lblPhieuBH;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNgay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);

		JScrollPane scrollPaneDoanhThu = new JScrollPane();
		scrollPaneDoanhThu.setBounds(1226, 104, 498, 597);
		add(scrollPaneDoanhThu);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPaneDoanhThu.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblTngThuTrong_2_1 = new JLabel("Doanh thu:");
		lblTngThuTrong_2_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1.setBounds(24, 138, 129, 30);
		panel.add(lblTngThuTrong_2_1);

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Số hóa đơn đã lập:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(24, 181, 198, 30);
		panel.add(lblTngThuTrong_2_1_1);

		JLabel lblTngThuTrong_2_1_2 = new JLabel("Số xe bán ra:");
		lblTngThuTrong_2_1_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_2.setBounds(24, 223, 198, 30);
		panel.add(lblTngThuTrong_2_1_2);

		JLabel lblTngThuTrong_2_1_3 = new JLabel("Số phiếu bảo hành đã lập:");
		lblTngThuTrong_2_1_3.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_3.setBounds(24, 266, 270, 30);
		panel.add(lblTngThuTrong_2_1_3);

		JLabel lblTngThuTrong_2_1_4 = new JLabel("Mã nhân viên:");
		lblTngThuTrong_2_1_4.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_4.setBounds(24, 52, 158, 30);
		panel.add(lblTngThuTrong_2_1_4);

		JLabel lblTngThuTrong_2_1_4_1 = new JLabel("Tên nhân viên:");
		lblTngThuTrong_2_1_4_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_4_1.setBounds(24, 95, 158, 30);
		panel.add(lblTngThuTrong_2_1_4_1);

		lblNgay = new JLabel("Ngày 7-12-2020");
		lblNgay.setForeground(new Color(58, 181, 74));
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgay.setBounds(173, 13, 191, 30);
		panel.add(lblNgay);

		lblMaNV = new JLabel("NV180556");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(194, 52, 251, 30);
		panel.add(lblMaNV);

		lblTenNV = new JLabel("Nguyễn Trần Nhật Hào");
		lblTenNV.setForeground(Color.BLACK);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenNV.setBounds(194, 95, 296, 30);
		panel.add(lblTenNV);

		lblDoanhThu = new JLabel("1.200.000.000 VNĐ");
		lblDoanhThu.setForeground(Color.BLACK);
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoanhThu.setBounds(194, 138, 251, 30);
		panel.add(lblDoanhThu);

		lblSoHoaDon = new JLabel("20 hóa đơn");
		lblSoHoaDon.setForeground(Color.BLACK);
		lblSoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoHoaDon.setBounds(234, 181, 251, 30);
		panel.add(lblSoHoaDon);

		lblSoXe = new JLabel("50 chiếc xe");
		lblSoXe.setForeground(Color.BLACK);
		lblSoXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoXe.setBounds(234, 223, 251, 30);
		panel.add(lblSoXe);

		lblPhieuBH = new JLabel("10 phiếu");
		lblPhieuBH.setForeground(Color.BLACK);
		lblPhieuBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhieuBH.setBounds(309, 266, 176, 30);
		panel.add(lblPhieuBH);

//		String[] colHeaderDoanhThu = { "STT", "Mã nhân viên", "Tên nhân viên", "Số lượng hóa đơn", "Tổng tiền" };
//		modelDoanhThu = new DefaultTableModel(colHeaderDoanhThu, 0);
//		tblDoanhThu = new JTable(modelDoanhThu) {
//			private static final long serialVersionUID = 1L;
//			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
//				return false;
//			}
//		};
//		tblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		tblDoanhThu.setRowHeight(35);
//		scrollPaneDoanhThu.setViewportView(tblDoanhThu);
//
//		/**
//		 * Đổi màu header cho table
//		 */
//		JTableHeader tableHeader2 = tblDoanhThu.getTableHeader();
//		tableHeader2.setBackground(new Color(58, 181, 74));
//		tableHeader2.setForeground(Color.white);
//		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
//
//		Auto setSize
//		tblDoanhThu.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(50);
//		tblDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(140);
//		tblDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(300);
//		tblDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(180);
//		tblDoanhThu.getColumnModel().getColumn(4).setPreferredWidth(200);
//
//		tblDoanhThu.setShowGrid(false);
//
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		Center value
//		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//		tblDoanhThu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
//		tblDoanhThu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
//		tblDoanhThu.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		JLabel lblTngThuTrong_2 = new JLabel("Chọn ngày:");
		lblTngThuTrong_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2.setBounds(0, 30, 121, 30);
		add(lblTngThuTrong_2);

		JDateChooser txtNgay = new JDateChooser();

		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setBounds(127, 30, 161, 30);
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);
		// DateFormat df = new SimpleDateFormat("MM-yyyy");

		khoiTao();
		pnlThongKe = new JPanel();
		pnlThongKe.setBounds(0, 79, 1128, 674);
		add(pnlThongKe);
		setDataToChart1(pnlThongKe);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setToolTipText("Xem chi tiết hóa đơn");
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXemChiTiet.setBounds(1557, 722, 166, 30);
		add(btnXemChiTiet);
		btnXemChiTiet.addActionListener(this);
		btnXemChiTiet.setVisible(false);

	}

	/**
	 * Biểu đồ cột thống kê Doanh thu của tháng hiện tại
	 * 
	 * @param jpnItem
	 */

	private void khoiTao() {
		thongKeDao = ThongKeDao.getInstance();
		localDate = LocalDate.now();

		hienThiHoaDonLapTrongNgay();
	}

	private void hienThiHoaDonLapTrongNgay() {

		List<OutputNhanVien_HoaDonLap> result = thongKeDao.thongKeHoaDonLapCuaNhanViensTrongNgay(localDate);

		for (OutputNhanVien_HoaDonLap outputNhanVien_HoaDonLap : result) {
			Object[] datas = new Object[5];
			datas[0] = tblDoanhThu.getRowCount() + 1;
			datas[1] = outputNhanVien_HoaDonLap.getMaNVHanhChinh();
			datas[2] = outputNhanVien_HoaDonLap.getHoTenNV();
			datas[3] = outputNhanVien_HoaDonLap.getSoLuong();
			datas[4] = DinhDangTien.format(outputNhanVien_HoaDonLap.getTongTien());

			modelDoanhThu.addRow(datas);
		}

	}

	public void setDataToChart1(JPanel jpnItem) {
		Map<String, Double> result = thongKeDao.getDoanhThuNgaysTheoThang(localDate.getMonthValue(),
				localDate.getYear());

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê các xe bán trong ngày".toUpperCase(), "Ngày",
				"Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);

//		Điền giá trị lên trên cột
		CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setDefaultNegativeItemLabelPosition(position);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel);
		jpnItem.validate();
		jpnItem.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
