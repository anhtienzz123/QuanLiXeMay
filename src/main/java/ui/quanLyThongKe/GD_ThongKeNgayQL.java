package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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

import dao.ThongKeQuanLiDao;
import entity.NhanVienHanhChinh;
import other.DinhDangTien;

public class GD_ThongKeNgayQL extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private LocalDate localDate;

	private ThongKeQuanLiDao thongKeDao;
	private JComboBox<String> cboThongKe;
	private JPanel pnlBieuDo;
	private JPanel pnlSoLieu;
	private JTextArea txtSoLieu2;
	private JTextArea txtSoLieu1;
	private JTextArea txtSoLieu3;

	private JDateChooser txtNgay;
	
	private JLabel lblTitle;
	private JLabel lblDoanhThuTrongNgay;
	private JLabel lblSoXeTrongNgay;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNgayQL(JLabel lblTitle, JLabel lblDoanhThuTrongNgay, JLabel lblSoXeTrongNgay) {
		
		this.lblTitle = lblTitle;
		this.lblDoanhThuTrongNgay = lblDoanhThuTrongNgay;
		this.lblSoXeTrongNgay = lblSoXeTrongNgay;
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);

		JLabel lblTngThuTrong_2 = new JLabel("Chọn ngày:");
		lblTngThuTrong_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2.setBounds(0, 30, 121, 30);
		add(lblTngThuTrong_2);

		txtNgay = new JDateChooser();

		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setBounds(127, 30, 161, 30);
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);
		// DateFormat df = new SimpleDateFormat("MM-yyyy");

		JPanel pnlContain = new JPanel();
		pnlContain.setBounds(0, 73, 1724, 680);
		add(pnlContain);
		pnlContain.setLayout(new CardLayout(0, 0));

		pnlBieuDo = new JPanel();
		pnlContain.add(pnlBieuDo, "name_23747476560100");

		pnlSoLieu = new JPanel();
		pnlSoLieu.setLayout(null);
		pnlSoLieu.setBackground(Color.WHITE);
		pnlContain.add(pnlSoLieu, "name_24057104890500");

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 13, 500, 655);
		pnlSoLieu.add(scrollPane1);

		txtSoLieu1 = new JTextArea();
		txtSoLieu1.setEditable(false);
		txtSoLieu1.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane1.setViewportView(txtSoLieu1);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(1224, 13, 500, 655);
		pnlSoLieu.add(scrollPane3);

		txtSoLieu3 = new JTextArea();
		txtSoLieu3.setEditable(false);
		txtSoLieu3.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane3.setViewportView(txtSoLieu3);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(622, 13, 500, 655);
		pnlSoLieu.add(scrollPane2);

		txtSoLieu2 = new JTextArea();
		txtSoLieu2.setEditable(false);
		txtSoLieu2.setMargin(new Insets(10, 10, 10, 10));
		txtSoLieu2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane2.setViewportView(txtSoLieu2);

		khoiTao();
		setDataToChart1(pnlBieuDo);

		cboThongKe = new JComboBox<String>();
		cboThongKe.setBackground(Color.WHITE);
		cboThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboThongKe.setModel(new DefaultComboBoxModel<String>(new String[] { "Biểu đồ", "Số liệu" }));
		cboThongKe.setBounds(1616, 30, 108, 30);
		add(cboThongKe);

		JLabel lblTngThuTrong_2_2 = new JLabel("Dạng thống kê:");
		lblTngThuTrong_2_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_2.setBounds(1428, 30, 161, 30);
		add(lblTngThuTrong_2_2);

		cboThongKe.addActionListener(this);

		txtNgay.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {
					localDate = txtNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					txtSoLieu1.setText("");
					txtSoLieu2.setText("");
					txtSoLieu3.setText("");
					
					capNhapLaiDuLieu();

				}

			}
		});
		
		khoiTao();
		capNhapLaiDuLieu();

	}

	/**
	 * Biểu đồ cột thống kê Doanh thu của tháng hiện tại
	 * 
	 * @param jpnItem
	 */
	private void khoiTao() {
		thongKeDao = ThongKeQuanLiDao.getInstance();
		localDate = LocalDate.now();

	}

	public void setDataToChart1(JPanel jpnItem) {
		int ngay = localDate.getDayOfMonth();
		int thang = localDate.getMonthValue();
		int nam = localDate.getYear();
		
		Map<String, Long> result = thongKeDao.thongKeXeBanTrongNgay(ngay, thang, nam);

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
		if (cboThongKe.getSelectedIndex() == 0) {
			pnlBieuDo.setVisible(true);
			pnlSoLieu.setVisible(false);
		} else {

			pnlBieuDo.setVisible(false);
			pnlSoLieu.setVisible(true);
		}
	}

	private void capNhapLaiDuLieu() {

		capNhapThongTinChung();
		capNhapSoLieu();
		capNhapLaiBieuDo();
	}
	
	private void capNhapThongTinChung() {
		int ngay = localDate.getDayOfMonth();
		int thang = localDate.getMonthValue();
		int nam = localDate.getYear();
		String titleNgay =  ngay+"-" + thang + "-"+nam;
		lblTitle.setText("Tổng thu trong ngày " + titleNgay);
	
		
		Double doanhSoNgay = thongKeDao.getDoanhThuTheoNgay(localDate.getDayOfMonth(), localDate.getMonthValue(),
				localDate.getYear());
		
		lblDoanhThuTrongNgay.setText(DinhDangTien.format(doanhSoNgay));
		
		long xeNgay = thongKeDao.getSoLuongXeTheoNgay(localDate.getDayOfMonth(), localDate.getMonthValue(),
				localDate.getYear());
		
		lblSoXeTrongNgay.setText(xeNgay + "");
	}

	private void capNhapLaiBieuDo() {
		setDataToChart1(pnlBieuDo);
	}

	private void capNhapSoLieu() {

		// Cap nhat so lieu 1
	
		txtSoLieu1.append("===== Doanh thu của mỗi nhân viên trong ngày ===== ");
		Map<NhanVienHanhChinh, Double> doanhThuNhanViens = thongKeDao.thongKeDoanhThuNhanVienTrongNgay(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
		
		doanhThuNhanViens.forEach((key, value) -> {
			txtSoLieu1.append(
					"\n" + key.getMaNVHanhChinh() + " - " + key.getHoTenNV() + " : " + DinhDangTien.format(value));

		});
		
	
		// Cap so lieu 2

		txtSoLieu2.append("===== Số lượng xe bán ra trong ngày ====");
		thongKeDao.thongKeXeBanTrongNgay(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()).forEach((key,value) -> {
			 txtSoLieu2.append("\n - " + key + " : " + value);
		});
		
		
		// Cap nhap so lieu 3
		// Thống kê số lượng tồn
		txtSoLieu3.append("===== Số lượng hiện tồn của mỗi xe =====");
		thongKeDao.thongXeSoLuongXeTon().forEach( (key,value) -> {
			txtSoLieu3.append("\n - " + key + " : " + value);
		});
		
		
		

	}
}
