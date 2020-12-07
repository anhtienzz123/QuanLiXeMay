package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

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
import org.jfree.data.general.DefaultPieDataset;

import dao.ThongKeDao;

public class GD_ThongKeThang extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlDoanhThuThang;
	private JPanel pnlTopDong;
	private JPanel pnlTopHang;
	private JTabbedPane tabbedPaneDoanhThu;
	private JTabbedPane tabbedPaneXe;
	private JPanel pnlTopXe;

	private ThongKeDao thongKeDao;
	private LocalDate date;
	private JComboBox<String> cboThang;
	private JComboBox<String> cboNam;
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
	public GD_ThongKeThang() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn tháng:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(48, 20, 143, 30);
		add(lblTngThuTrong_2_1_1);

		tabbedPaneXe = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneXe.setBounds(912, 20, 812, 714);
		tabbedPaneXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneXe.setBackground(new Color(58, 181, 74));
		tabbedPaneXe.setForeground(Color.WHITE);
		add(tabbedPaneXe);

		pnlTopDong = new JPanel();
		pnlTopDong.setBackground(Color.WHITE);
		tabbedPaneXe.addTab("Dòng xe", null, pnlTopDong, null);

		pnlTopHang = new JPanel();
		pnlTopHang.setBackground(Color.WHITE);
		tabbedPaneXe.addTab("Hãng xe", null, pnlTopHang, null);

		tabbedPaneDoanhThu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDoanhThu.setBounds(0, 63, 852, 671);
		tabbedPaneDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneDoanhThu.setBackground(new Color(58, 181, 74));
		tabbedPaneDoanhThu.setForeground(Color.WHITE);
		add(tabbedPaneDoanhThu);

		pnlDoanhThuThang = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu trong tháng", null, pnlDoanhThuThang, null);

		khoiTao();

		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		tabbedPaneDoanhThu.addTab("Xe bán chạy trong tháng", null, pnlTopXe, null);

		thongKeDoanhThuThang(pnlDoanhThuThang);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);

		cboThang = new JComboBox<String>();
		cboThang.setBackground(Color.WHITE);
		cboThang.setForeground(Color.BLACK);
		cboThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboThang.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cboThang.setBounds(203, 23, 64, 30);
		add(cboThang);
		((JLabel) cboThang.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cboThang.setSelectedItem(date.getMonthValue()+"");
		
		cboNam = new JComboBox<String>();
		cboNam.setModel(new DefaultComboBoxModel<String>(new String[] {"2018", "2019", "2020"}));
		cboNam.setForeground(Color.BLACK);
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboNam.setBackground(Color.WHITE);
		cboNam.setBounds(410, 23, 90, 30);
		add(cboNam);
		((JLabel) cboNam.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cboNam.setSelectedItem(date.getYear()+"");
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPaneXe.addTab("Thống kê", null, scrollPane, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblTngThuTrong_2_1 = new JLabel("Doanh thu:");
		lblTngThuTrong_2_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1.setBounds(24, 138, 129, 30);
		panel.add(lblTngThuTrong_2_1);

		JLabel lblTngThuTrong = new JLabel("Số hóa đơn đã lập:");
		lblTngThuTrong.setForeground(new Color(58, 181, 74));
		lblTngThuTrong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong.setBounds(24, 181, 198, 30);
		panel.add(lblTngThuTrong);

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
		
		
		JLabel lblTngThuTrong_2_1_1_1 = new JLabel("năm:");
		lblTngThuTrong_2_1_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1_1.setBounds(349, 20, 64, 30);
		add(lblTngThuTrong_2_1_1_1);

	}

	public void khoiTao() {
		thongKeDao = ThongKeDao.getInstance();
		date = LocalDate.now();

	}

	public void thongKeDoanhThuThang(JPanel jpnItem) {

		int thang = date.getMonthValue();
		int nam = date.getYear();
		Map<String, Double> result = thongKeDao.getDoanhThuNgaysTheoThang(thang, nam);
		System.out.println("chay vao thong ke doanh thu thang");

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "Doanh thu", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu trong tháng".toUpperCase(), "Tháng",
				"Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);

//		Điền giá trị lên trên cột
		CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setDefaultNegativeItemLabelPosition(position);

		ChartPanel chartPanel1 = new ChartPanel(barChart);
		chartPanel1.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel1);
		jpnItem.validate();
		jpnItem.repaint();
	}

	public void thongKeTopXe(JPanel jpnItem) {

		int thang = date.getMonthValue();
		int nam = date.getYear();
		Map<String, Long> result = thongKeDao.getTopXeBansTrongThang(5, thang, nam);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "Số lượng", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê các xe bán chạy trong tháng".toUpperCase(), "Xe",
				"Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);

//		Điền giá trị lên trên cột
		CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setDefaultNegativeItemLabelPosition(position);

		ChartPanel chartPanel1 = new ChartPanel(barChart);
		chartPanel1.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel1);
		jpnItem.validate();
		jpnItem.repaint();
	}

	public void thongKeTopDongXe(JPanel jpnItem) {

		int thang = date.getMonthValue();
		int nam = date.getYear();
		Map<String, Long> result = thongKeDao.thongKeDongXeTrongThang(thang, nam);
		DefaultPieDataset pieDataset = new DefaultPieDataset();

		result.forEach((key, value) -> {
			pieDataset.setValue(key, value);

		});

		JFreeChart pieChart = ChartFactory.createPieChart("Các dòng xe bán chạy trong tháng", pieDataset, true, true,
				true);

		ChartPanel chartPanel2 = new ChartPanel(pieChart);
		chartPanel2.setBackground(Color.WHITE);
		chartPanel2.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel2);
		jpnItem.validate();
		jpnItem.repaint();
	}

	public void thongKeTopHangXe(JPanel jpnItem) {

		int thang = date.getMonthValue();
		int nam = date.getYear();
		Map<String, Long> result = thongKeDao.thongKeHangXeTrongThang(thang, nam);

		DefaultPieDataset pieDataset = new DefaultPieDataset();

		result.forEach((key, value) -> {
			pieDataset.setValue(key, value);
		});

		JFreeChart pieChart = ChartFactory.createPieChart("Các hãng xe bán chạy trong tháng", pieDataset, true, true,
				true);

		ChartPanel chartPanel2 = new ChartPanel(pieChart);
		chartPanel2.setBackground(Color.WHITE);
		chartPanel2.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel2);
		jpnItem.validate();
		jpnItem.repaint();
	}
}
