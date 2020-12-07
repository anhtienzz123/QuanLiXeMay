package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
	private ThongKeQuanLiDao thongKeDao;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNgay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1724, 766));
		setLayout(null);

		JScrollPane scrollPaneDoanhThu = new JScrollPane();
		scrollPaneDoanhThu.setBounds(854, 104, 870, 571);
		add(scrollPaneDoanhThu);

		String[] colHeaderDoanhThu = { "STT", "Mã nhân viên", "Tên nhân viên", "Số lượng hóa đơn", "Tổng tiền" };
		modelDoanhThu = new DefaultTableModel(colHeaderDoanhThu, 0);
		tblDoanhThu = new JTable(modelDoanhThu) {
			private static final long serialVersionUID = 1L;

//			public void tableChanged(TableModelEvent e) {
//				super.tableChanged(e);
//				repaint();
//			}
			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblDoanhThu.setRowHeight(35);
		scrollPaneDoanhThu.setViewportView(tblDoanhThu);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblDoanhThu.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

//		Auto setSize
//		tblDoanhThu.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(140);
		tblDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(300);
		tblDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(180);
		tblDoanhThu.getColumnModel().getColumn(4).setPreferredWidth(200);

		tblDoanhThu.setShowGrid(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		Center value
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDoanhThu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDoanhThu.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblDoanhThu.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		/**
		 * Đổi màu các dòng chẵn
		 */
//		TableColorCellRender render = new TableColorCellRender();
//		tblDoanhThu.setDefaultRenderer(Object.class, render);

		JLabel lblTngThuTrong_2 = new JLabel("Danh sách hóa đơn đã lập trong ngày");
		lblTngThuTrong_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2.setBounds(854, 41, 392, 50);
		add(lblTngThuTrong_2);

		JDateChooser txtNgay = new JDateChooser();

		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setBounds(1243, 51, 172, 30);
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);
		// DateFormat df = new SimpleDateFormat("MM-yyyy");

		khoiTao();
		pnlThongKe = new JPanel();
		pnlThongKe.setBounds(0, 51, 808, 684);
		add(pnlThongKe);
		setDataToChart1(pnlThongKe);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setToolTipText("Xem chi tiết hóa đơn");
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXemChiTiet.setBounds(1558, 705, 166, 30);
		add(btnXemChiTiet);
		btnXemChiTiet.addActionListener(this);

	}

	/**
	 * Biểu đồ cột thống kê Doanh thu của tháng hiện tại
	 * 
	 * @param jpnItem
	 */

	private void khoiTao() {
		thongKeDao = ThongKeQuanLiDao.getInstance();
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

		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu của tháng hiện tại".toUpperCase(), "Ngày",
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
