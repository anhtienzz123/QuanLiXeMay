package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
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

import dao.ThongKeQuanLiDao;

public class GD_ThongKeThangQL extends JPanel implements ActionListener {

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

	private ThongKeQuanLiDao thongKeDao;
	private LocalDate date;
	private JComboBox<String> cboThang;
	private JComboBox<String> cboNam;
	private JComboBox<String> cboThongKe;
	private JLabel lblTngThuTrong_2_1_1_2;
	private JPanel pnlContain;
	private JPanel pnlSoLieu;
	private JPanel pnlBieuDo;
	private JScrollPane scrollPane1;
	private JTextArea txtSoLieu1;
	private JScrollPane scrollPane3;
	private JScrollPane scrollPane2;
	private JTextArea txtSoLieu2;
	private JTextArea txtSoLieu3;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeThangQL() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);
		khoiTao();

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn tháng:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(48, 20, 143, 30);
		add(lblTngThuTrong_2_1_1);

		cboThang = new JComboBox<String>();
		cboThang.setBackground(Color.WHITE);
		cboThang.setForeground(Color.BLACK);
		cboThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboThang.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cboThang.setBounds(203, 23, 64, 30);
		add(cboThang);
		((JLabel) cboThang.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cboThang.setSelectedItem(date.getMonthValue() + "");

		cboNam = new JComboBox<String>();
		cboNam.setModel(new DefaultComboBoxModel<String>(new String[] { "2018", "2019", "2020" }));
		cboNam.setForeground(Color.BLACK);
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboNam.setBackground(Color.WHITE);
		cboNam.setBounds(410, 23, 90, 30);
		add(cboNam);
		((JLabel) cboNam.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cboNam.setSelectedItem(date.getYear() + "");

		JLabel lblTngThuTrong_2_1_1_1 = new JLabel("năm:");
		lblTngThuTrong_2_1_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1_1.setBounds(349, 20, 64, 30);
		add(lblTngThuTrong_2_1_1_1);

		cboThongKe = new JComboBox<String>();
		cboThongKe.setModel(new DefaultComboBoxModel<String>(new String[] { "Biểu đồ", "Số liệu" }));
		cboThongKe.setForeground(Color.BLACK);
		cboThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboThongKe.setBackground(Color.WHITE);
		cboThongKe.setBounds(1616, 20, 108, 30);
		add(cboThongKe);

		lblTngThuTrong_2_1_1_2 = new JLabel("Dạng thống kê:");
		lblTngThuTrong_2_1_1_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1_2.setBounds(1433, 20, 171, 30);
		add(lblTngThuTrong_2_1_1_2);

		pnlContain = new JPanel();
		pnlContain.setBackground(Color.WHITE);
		pnlContain.setBounds(0, 65, 1724, 701);
		add(pnlContain);
		pnlContain.setLayout(new CardLayout(0, 0));

		pnlBieuDo = new JPanel();
		pnlBieuDo.setBackground(Color.WHITE);
		pnlContain.add(pnlBieuDo, "name_27850809237800");
		pnlBieuDo.setLayout(null);

		tabbedPaneDoanhThu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDoanhThu.setBounds(0, 0, 852, 671);
		pnlBieuDo.add(tabbedPaneDoanhThu);
		tabbedPaneDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneDoanhThu.setBackground(new Color(58, 181, 74));
		tabbedPaneDoanhThu.setForeground(Color.WHITE);

		pnlDoanhThuThang = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu trong tháng", null, pnlDoanhThuThang, null);

		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		tabbedPaneDoanhThu.addTab("Xe bán chạy trong tháng", null, pnlTopXe, null);

		tabbedPaneXe = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneXe.setBounds(912, 0, 812, 671);
		pnlBieuDo.add(tabbedPaneXe);
		tabbedPaneXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneXe.setBackground(new Color(58, 181, 74));
		tabbedPaneXe.setForeground(Color.WHITE);

		pnlTopDong = new JPanel();
		pnlTopDong.setBackground(Color.WHITE);
		tabbedPaneXe.addTab("Dòng xe", null, pnlTopDong, null);

		pnlTopHang = new JPanel();
		pnlTopHang.setBackground(Color.WHITE);
		tabbedPaneXe.addTab("Hãng xe", null, pnlTopHang, null);

		pnlSoLieu = new JPanel();
		pnlSoLieu.setBackground(Color.WHITE);
		pnlContain.add(pnlSoLieu, "name_27823531921600");
		pnlSoLieu.setLayout(null);

		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 13, 500, 655);
		pnlSoLieu.add(scrollPane1);

		txtSoLieu1 = new JTextArea();
		txtSoLieu1.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane1.setViewportView(txtSoLieu1);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(613, 13, 500, 655);
		pnlSoLieu.add(scrollPane2);
		
		txtSoLieu2 = new JTextArea();
		txtSoLieu2.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane2.setViewportView(txtSoLieu2);
		
		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(1224, 13, 500, 655);
		pnlSoLieu.add(scrollPane3);
		
		txtSoLieu3 = new JTextArea();
		txtSoLieu3.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane3.setViewportView(txtSoLieu3);

		thongKeDoanhThuThang(pnlDoanhThuThang);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);
		cboThongKe.addActionListener(this);
	}

	public void khoiTao() {
		thongKeDao = ThongKeQuanLiDao.getInstance();
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
		Map<String, Long> result = thongKeDao.thongKeDongXeTrongThang(5,thang, nam);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cboThongKe.getSelectedIndex() == 0) {
			pnlBieuDo.setVisible(true);
			pnlSoLieu.setVisible(false);
		} else {

			pnlBieuDo.setVisible(false);
			pnlSoLieu.setVisible(true);
		}
	}
}
