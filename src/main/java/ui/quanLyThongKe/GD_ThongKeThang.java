package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JDateChooser;

import dao.ThongKeDao;

public class GD_ThongKeThang extends JPanel{

	private JPanel pnlDoanhThuThang;
	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JPanel pnlTopDong;
	private JPanel pnlTopHang;
	private JTabbedPane tabbedPaneDoanhThu;
	private JTabbedPane tabbedPaneXe;
	private JDateChooser txtNgay;
	private JPanel pnlTopXe;

	private ThongKeDao thongKeDao;
	private int thang;
	private int nam;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeThang() {
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
		

		txtNgay.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				
				if(e.getPropertyName().equals("date")) {
					
				}
			}
		});

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn tháng:");
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
		tabbedPaneDoanhThu.addTab("Doanh thu trong tháng", null, pnlDoanhThuThang, null);

		dangKiSuKien();

		khoiTao();

		thongKeDoanhThuThang(pnlDoanhThuThang);

		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		tabbedPaneDoanhThu.addTab("Xe bán chạy trong tháng", null, pnlTopXe, null);
		thongKeTopXe(pnlTopXe);
		thongKeTopDongXe(pnlTopDong);
		thongKeTopHangXe(pnlTopHang);
	}

	public void khoiTao() {
		thongKeDao = ThongKeDao.getInstance();
		LocalDate date = LocalDate.now();
		thang = date.getMonthValue();
		nam = date.getYear();

	}

	public void dangKiSuKien() {
		

	}

	/**
	 * Biểu đồ cột thống kê số doanh thu bán trong tháng
	 * 
	 * @param jpnItem
	 */
	public void thongKeDoanhThuThang(JPanel jpnItem) {

		Map<String, Double> result = thongKeDao.getDoanhThuNgaysTheoThang(thang, nam);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "Doanh thu", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu trong tháng".toUpperCase(), "Tháng",
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
	 * Biểu đồ cột thống kê top các xe bán chạy trong tháng
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopXe(JPanel jpnItem) {

		Map<String, Long> result = thongKeDao.getTopXeBansTrongThang(5, thang, nam);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		result.forEach((key, value) -> {
			dataset.addValue(value, "Số lượng", key);
		});

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê các xe bán chạy trong tháng".toUpperCase(), "Xe",
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
	 * Biểu đồ trò thống kê top các dòng xe bán chạy trong tháng
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopDongXe(JPanel jpnItem) {

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Air Blade", 3);
		pieDataset.setValue("Sirius", 2);
		pieDataset.setValue("SH", 3);
		pieDataset.setValue("Vision", 2);

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

	/**
	 * Biểu đồ trò thống kê top các hãng xe bán chạy trong tháng
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopHangXe(JPanel jpnItem) {

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
