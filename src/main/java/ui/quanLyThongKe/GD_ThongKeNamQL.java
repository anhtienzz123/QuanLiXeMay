package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
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
import entity.NhanVienHanhChinh;
import other.DinhDangTien;

public class GD_ThongKeNamQL extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TOP = 10;
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
	private JComboBox<String> cboThongKe;
	private JLabel lblTngThuTrong_2_1_5;
	private JPanel pnlContain;
	private JPanel pnlSoLieu;
	private JPanel pnlBieuDo;
	private JScrollPane scrollPane1;
	private JTextArea txtSoLieu1;
	private JTextArea txtSoLieu2;
	private JTextArea txtSoLieu3;

	private JLabel lblTitle;
	private JLabel lblDoanhThuTrongNam;
	private JLabel lblSoXeTrongNam;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNamQL(JLabel lblTitle, JLabel lblDoanhThuTrongNam, JLabel lblSoXeTrongNam) {

		this.lblTitle = lblTitle;
		this.lblDoanhThuTrongNam = lblDoanhThuTrongNam;
		this.lblSoXeTrongNam = lblSoXeTrongNam;

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);
//		DateFormat df = new SimpleDateFormat("yyyy");

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn năm:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(48, 20, 182, 30);
		add(lblTngThuTrong_2_1_1);

		cboNam = new JComboBox<String>();
		cboNam.setBackground(Color.WHITE);
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboNam.setModel(new DefaultComboBoxModel<String>(new String[] { "2018", "2019", "2020" })  );
		khoiTao();

		
		
		
		
		cboNam.setBounds(228, 20, 90, 30);
		add(cboNam);
		((JLabel) cboNam.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cboNam.setSelectedItem(nam + "");

		cboThongKe = new JComboBox<String>();
		cboThongKe.setBackground(Color.WHITE);
		cboThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboThongKe.setModel(new DefaultComboBoxModel<String>(new String[] { "Biểu đồ", "Số liệu" }));
		cboThongKe.setBounds(1616, 23, 108, 30);
		add(cboThongKe);
		cboThongKe.addActionListener(this);

		lblTngThuTrong_2_1_5 = new JLabel("Dạng thống kê:");
		lblTngThuTrong_2_1_5.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_5.setBounds(1422, 20, 182, 30);
		add(lblTngThuTrong_2_1_5);

		pnlContain = new JPanel();
		pnlContain.setBounds(0, 63, 1724, 703);
		add(pnlContain);
		pnlContain.setLayout(new CardLayout(0, 0));

		pnlBieuDo = new JPanel();
		pnlBieuDo.setBackground(Color.WHITE);
		pnlContain.add(pnlBieuDo, "name_29177879398400");
		pnlBieuDo.setLayout(null);

		tabbedPaneDoanhThu = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDoanhThu.setBounds(0, 0, 893, 665);
		pnlBieuDo.add(tabbedPaneDoanhThu);
		tabbedPaneDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneDoanhThu.setBackground(new Color(58, 181, 74));
		tabbedPaneDoanhThu.setForeground(Color.WHITE);

		pnlDoanhThuThang = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu từng tháng", null, pnlDoanhThuThang, null);

		pnlDoanhThuQuy = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu từng quý", null, pnlDoanhThuQuy, null);

		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		tabbedPaneDoanhThu.addTab("Xe bán chạy trong năm", null, pnlTopXe, null);

		tabbedPaneXe = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneXe.setBounds(1007, 0, 717, 665);
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
		pnlContain.add(pnlSoLieu, "name_29164502988200");
		pnlSoLieu.setLayout(null);

		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 13, 500, 655);
		pnlSoLieu.add(scrollPane1);

		txtSoLieu1 = new JTextArea();
		txtSoLieu1.setEditable(false);
		txtSoLieu1.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane1.setViewportView(txtSoLieu1);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(619, 13, 500, 655);
		pnlSoLieu.add(scrollPane2);

		txtSoLieu2 = new JTextArea();
		txtSoLieu2.setEditable(false);
		txtSoLieu2.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane2.setViewportView(txtSoLieu2);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(1224, 13, 500, 655);
		pnlSoLieu.add(scrollPane3);

		txtSoLieu3 = new JTextArea();
		txtSoLieu3.setEditable(false);
		txtSoLieu3.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane3.setViewportView(txtSoLieu3);

		thongKeDoanhThuNam(pnlDoanhThuThang);
		thongKeDoanhThuQuy(pnlDoanhThuQuy);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);

		dangKiSuKien();
		capNhapLaiDuLieu();
	}

	private void dangKiSuKien() {
		cboNam.addActionListener(this);
	}

	public void khoiTao() {
		thongKeDao = ThongKeQuanLiDao.getInstance();
		LocalDate date = LocalDate.now();
		nam = date.getYear();
		
		List<String> nams = thongKeDao.getNams();
		
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>();
		for (String string : nams) {
			temp.addElement(string);
		}
	
		cboNam.setModel(temp);
	}
	

	/**
	 * Biểu đồ cột thống kê số doanh thu bán trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeDoanhThuNam(JPanel jpnItem) {

		Map<Integer, Double> result = thongKeDao.getDoanhThuThangsTheoNam(this.nam);

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

		Map<String, Long> result = thongKeDao.thongKeDongXeTrongNam(5, nam);

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
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source.equals(cboNam)) {
			txtSoLieu1.setText("");
			txtSoLieu2.setText("");
			txtSoLieu3.setText("");

			this.nam = Integer.valueOf(cboNam.getSelectedItem().toString());

			capNhapLaiDuLieu();
		}

		if (source.equals(cboThongKe)) {
			if (cboThongKe.getSelectedIndex() == 0) {
				pnlBieuDo.setVisible(true);
				pnlSoLieu.setVisible(false);
			} else {

				pnlBieuDo.setVisible(false);
				pnlSoLieu.setVisible(true);
			}
		}

	}

	private void capNhapLaiDuLieu() {
		capNhapThongTinChung();
		capNhapSoLieu();
		capNhapLaiBieuDo();
	}

	private void capNhapThongTinChung() {

		lblTitle.setText("Tổng thu trong năm " + nam);

		Double doanhSoNgay = thongKeDao.getDoanhThuTheoNam(nam);

		lblDoanhThuTrongNam.setText(DinhDangTien.format(doanhSoNgay));

		long xeNgay = thongKeDao.getSoLuongXeTheoNam(nam);

		lblSoXeTrongNam.setText(xeNgay + "");
	}

	private void capNhapLaiBieuDo() {
		thongKeDoanhThuNam(pnlDoanhThuThang);
		thongKeDoanhThuQuy(pnlDoanhThuQuy);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);
	}

	private void capNhapSoLieu() {

		System.out.println("Cap nhap so lieu " + nam);
		// Cap nhat so lieu 1
		txtSoLieu1.append("===== Doanh thu từng tháng trong năm ====");
		Map<Integer, Double> result = thongKeDao.getDoanhThuThangsTheoNam(this.nam);
		result.forEach((key, value) -> {
			txtSoLieu1.append("\n- Tháng " + key + " : " + DinhDangTien.format(value));
		});
		txtSoLieu1.append("\n===== Doanh thu từng quý trong năm =====");
		txtSoLieu1.append("\nQúy 1: " + DinhDangTien.format(thongKeDao.getDoanhThuQuyTrongNam(1, this.nam)));
		txtSoLieu1.append("\nQúy 2: " + DinhDangTien.format(thongKeDao.getDoanhThuQuyTrongNam(2, this.nam)));
		txtSoLieu1.append("\nQúy 3: " + DinhDangTien.format(thongKeDao.getDoanhThuQuyTrongNam(3, this.nam)));
		txtSoLieu1.append("\nQúy 4: " + DinhDangTien.format(thongKeDao.getDoanhThuQuyTrongNam(4, this.nam)));

		txtSoLieu1.append("\n===== Xe bán chạy trong năm =====");
		Map<String, Long> topXesBanChay = thongKeDao.getTopXeBansTrongNam(TOP, nam);

		topXesBanChay.forEach((key, value) -> {
			txtSoLieu1.append("\n" + key + " : " + value);
		});
		// Cap so lieu 2

		txtSoLieu2.append("===== Số lượng xe bán ra theo hãng ====");
		Map<String, Long> hangXes = thongKeDao.thongKeHangXeTrongNam(nam);
		hangXes.forEach((key, value) -> {
			txtSoLieu2.append("\n- " + key + " : " + value);
		});

		txtSoLieu2.append("\n===== Số lượng xe bán ra theo dòng xe ====");
		Map<String, Long> dongXes = thongKeDao.thongKeDongXeTrongNam(10, nam);
		dongXes.forEach((key, value) -> {
			txtSoLieu2.append("\n- " + key + " : " + value);
		});
		// Cap nhap so lieu 3
		txtSoLieu3.append("===== Doanh thu của mỗi nhân viên ===== ");
		Map<NhanVienHanhChinh, Double> doanhThuNhanViens = thongKeDao.thongKeDoanhThuNhanVienTrongNam(nam);
		doanhThuNhanViens.forEach((key, value) -> {
			txtSoLieu3.append(
					"\n" + key.getMaNVHanhChinh() + " - " + key.getHoTenNV() + " : " + DinhDangTien.format(value));

		});

	}

}
