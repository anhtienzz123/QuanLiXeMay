package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class GD_ThongKeNam extends JPanel implements MouseListener {

	private JPanel pnlDoanhThuThang;
	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JPanel pnlTopDong;
	private JPanel pnlTopHang;
	private JPanel pnlDoanhThuQuy;
	private JTabbedPane tabbedPaneDoanhThu;
	private JTabbedPane tabbedPaneXe;
	private JDateChooser txtNgay;
	private JPanel pnlTopXe;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNam() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 717));
		setLayout(null);

		txtNgay = new JDateChooser();
		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setBounds(218, 20, 146, 30);
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);
		DateFormat df = new SimpleDateFormat("MM-yyyy");

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn năm:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(48, 20, 182, 30);
		add(lblTngThuTrong_2_1_1);

		tabbedPaneXe = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneXe.setBounds(843, 20, 571, 671);
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
		tabbedPaneDoanhThu.setBounds(48, 63, 777, 628);
		tabbedPaneDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPaneDoanhThu.setBackground(new Color(58, 181, 74));
		tabbedPaneDoanhThu.setForeground(Color.WHITE);
		add(tabbedPaneDoanhThu);

		pnlDoanhThuThang = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu từng tháng", null, pnlDoanhThuThang, null);

		pnlDoanhThuQuy = new JPanel();
		tabbedPaneDoanhThu.addTab("Doanh thu từng quý", null, pnlDoanhThuQuy, null);

		dangKiSuKien();


		thongKeDoanhThuNam(pnlDoanhThuThang);
		thongKeDoanhThuQuy(pnlDoanhThuQuy);
		
		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		tabbedPaneDoanhThu.addTab("Xe bán chạy trong năm", null, pnlTopXe, null);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);
	}

	public void dangKiSuKien() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();

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
		Object o = e.getSource();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object o = e.getSource();

	}

	/**
	 * Biểu đồ cột thống kê số doanh thu bán trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeDoanhThuNam(JPanel jpnItem) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Random r = new Random();
		for (int i = 1; i <= 12; i++) {
			int ran = r.nextInt(15);
			dataset.addValue(ran, "Doanh thu", i + "");
		}

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu trong năm".toUpperCase(), "Tháng",
				"Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);

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
		Random r = new Random();
			dataset.addValue(110, "Doanh thu", "Quý 1");
			dataset.addValue(90, "Doanh thu", "Quý 2");
			dataset.addValue(130, "Doanh thu", "Quý 3");
			dataset.addValue(140, "Doanh thu", "Quý 4");
		
		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu các quý trong năm".toUpperCase(), "Quý",
				"Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);
		
		ChartPanel chartPanel1 = new ChartPanel(barChart);
		chartPanel1.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
		
		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel1);
		jpnItem.validate();
		jpnItem.repaint();
	}

	/**
	 * Biểu đồ cột thống kê top các xe bán chạy trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopXe(JPanel jpnItem) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(120, "Số lượng", "Air Blade 2020");
		dataset.addValue(200, "Số lượng", "Vision 2020");
		dataset.addValue(90, "Số lượng", "Yamaha Sirius 2020");
		dataset.addValue(160, "Số lượng", "SH mode");

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê các xe bán chạy trong năm".toUpperCase(), "Xe",
				"Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);
		
		ChartPanel chartPanel1 = new ChartPanel(barChart);
		chartPanel1.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));
		
		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel1);
		jpnItem.validate();
		jpnItem.repaint();
	}

	/**
	 * Biểu đồ trò thống kê top các dòng xe bán chạy trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopDongXe(JPanel jpnItem) {

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Air Blade", 3);
		pieDataset.setValue("Sirius", 2);
		pieDataset.setValue("SH", 3);
		pieDataset.setValue("Vision", 2);

		JFreeChart pieChart = ChartFactory.createPieChart("Các dòng xe bán chạy trong năm", pieDataset, true, true,
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

	/**
	 * Biểu đồ trò thống kê top các hãng xe bán chạy trong năm
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopHangXe(JPanel jpnItem) {

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Honda", 4);
		pieDataset.setValue("Yamaha", 3);
		pieDataset.setValue("Suzuki", 2);
		pieDataset.setValue("SYM", 1);

		JFreeChart pieChart = ChartFactory.createPieChart("Các hãng xe bán chạy trong năm", pieDataset, true, true,
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
