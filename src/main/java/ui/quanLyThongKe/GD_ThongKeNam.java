package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import dao.ThongKeQuanLiDao;


public class GD_ThongKeNam extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TOP = 5;
	private JPanel pnlDoanhThuThang;
//	private Vector colHeaderDoanhThu;
//	private DefaultTableModel modelDoanhThu;
	private JPanel pnlTopDong;
	private JPanel pnlTopHang;
	private JPanel pnlDoanhThuQuy;
	private JTabbedPane tabbedPaneDoanhThu;
	private JTabbedPane tabbedPaneXe;
	private JPanel pnlTopXe;

	private ThongKeQuanLiDao thongKeDao;
	private int nam;
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
	public GD_ThongKeNam() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);
//		DateFormat df = new SimpleDateFormat("yyyy");

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn năm:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(48, 20, 182, 30);
		add(lblTngThuTrong_2_1_1);

		tabbedPaneXe = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneXe.setBounds(1007, 20, 717, 708);
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
		tabbedPaneDoanhThu.setBounds(48, 63, 893, 665);
		tabbedPaneDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneDoanhThu.setBackground(new Color(58, 181, 74));
		tabbedPaneDoanhThu.setForeground(Color.WHITE);
		add(tabbedPaneDoanhThu);

		pnlDoanhThuThang = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu từng tháng", null, pnlDoanhThuThang, null);

		pnlDoanhThuQuy = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu từng quý", null, pnlDoanhThuQuy, null);

		dangKiSuKien();

		khoiTao();

		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		tabbedPaneDoanhThu.addTab("Xe bán chạy trong năm", null, pnlTopXe, null);
		thongKeDoanhThuNam(pnlDoanhThuThang);
		thongKeDoanhThuQuy(pnlDoanhThuQuy);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);
		
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
		
		cboNam = new JComboBox<String>();
		cboNam.setBackground(Color.WHITE);
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboNam.setModel(new DefaultComboBoxModel<String>(new String[] {"2018", "2019", "2020"}));
		cboNam.setBounds(228, 20, 90, 30);
		add(cboNam);
		((JLabel) cboNam.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cboNam.setSelectedItem(nam+"");
		
		
	}

	public void dangKiSuKien() {
	}

	public void khoiTao() {
		thongKeDao = ThongKeQuanLiDao.getInstance();
		LocalDate date = LocalDate.now();
		nam = date.getYear();
	}

	/**
	 * Biểu đồ cột thống kê số doanh thu bán trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeDoanhThuNam(JPanel jpnItem) {

		Map<String, Double> result = thongKeDao.getDoanhThuThangsTheoNam(this.nam);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "Doanh thu", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu trong năm".toUpperCase(), "Tháng",
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

	/**
	 * Biểu đồ cột thống kê số doanh thu bán các quý trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeDoanhThuQuy(JPanel jpnItem) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		Random r = new Random();
		dataset.addValue(thongKeDao.getDoanhThuQuyTrongNam(1, this.nam), "Doanh thu", "Quý 1");
		dataset.addValue(thongKeDao.getDoanhThuQuyTrongNam(2, this.nam), "Doanh thu", "Quý 2");
		dataset.addValue(thongKeDao.getDoanhThuQuyTrongNam(3, this.nam), "Doanh thu", "Quý 3");
		dataset.addValue(thongKeDao.getDoanhThuQuyTrongNam(4, this.nam), "Doanh thu", "Quý 4");

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu các quý trong năm".toUpperCase(), "Quý",
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

		Map<String, Long> result = thongKeDao.getTopXeBansTrongNam(TOP, nam);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "Số lượng", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê các xe bán chạy trong năm".toUpperCase(), "Xe",
				"Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);

//		Điền giá trị lên trên cột
		CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();
		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);
		ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
		renderer.setDefaultNegativeItemLabelPosition(position);

//		Đổi màu các cột
		BarRenderer render = (BarRenderer) barChart.getCategoryPlot().getRenderer();

//		render.setSeriesPaint(0, Color.green);
//		render.setSeriesPaint(1, Color.green);
//		render.setSeriesPaint(2, Color.blue);

		render.setDrawBarOutline(false);
		render.setItemMargin(0);

		ChartPanel chartPanel1 = new ChartPanel(barChart);
		chartPanel1.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel1);
		jpnItem.validate();
		jpnItem.repaint();
	}

	public void thongKeTopDongXe(JPanel jpnItem) {

		Map<String, Long> result = thongKeDao.thongKeDongXeTrongNam(nam);

		DefaultPieDataset pieDataset = new DefaultPieDataset();

		result.forEach((key, value) -> {
			pieDataset.setValue(key, value);
		});

		JFreeChart pieChart = ChartFactory.createPieChart("Các dòng xe bán chạy trong năm", pieDataset, true, true,
				true);
//		Điền % vào Pie
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} : ({2})",
				new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) pieChart.getPlot()).setLabelGenerator(labelGenerator);

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

		Map<String, Long> result = thongKeDao.thongKeHangXeTrongNam(nam);

		DefaultPieDataset pieDataset = new DefaultPieDataset();

		result.forEach((key, value) -> {
			pieDataset.setValue(key, value);
		});

		JFreeChart pieChart = ChartFactory.createPieChart("Các hãng xe bán chạy trong năm", pieDataset, true, true,
				true);

//		Điền % vào Pie
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} : ({2})",
				new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) pieChart.getPlot()).setLabelGenerator(labelGenerator);

		ChartPanel chartPanel2 = new ChartPanel(pieChart);
		chartPanel2.setBackground(Color.WHITE);
		chartPanel2.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel2);
		jpnItem.validate();
		jpnItem.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		Object o = e.getSource();

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
//		Object o = e.getSource();

	}

	@Override
	public void mouseExited(MouseEvent e) {
//		Object o = e.getSource();

	}
}
