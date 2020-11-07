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

public class GD_ThongKeThang extends JPanel implements MouseListener {

	private JPanel pnlDoanhThu;
	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JPanel pnlTopXe;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeThang() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 717));
		setLayout(null);

		JLabel lblTngThuTrong_2 = new JLabel("Top các dòng xe bán chạy trong tháng");
		lblTngThuTrong_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2.setBounds(853, 61, 392, 50);
		add(lblTngThuTrong_2);

		JDateChooser txtNgay = new JDateChooser();
		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setBounds(218, 20, 146, 30);
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);

		JLabel lblTngThuTrong_2_1 = new JLabel("Doanh thu tháng");
		lblTngThuTrong_2_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1.setBounds(254, 61, 182, 50);
		add(lblTngThuTrong_2_1);

		JLabel lblThang = new JLabel("10-2020");
		DateFormat df = new SimpleDateFormat("MM-yyyy");
		lblThang.setText(df.format(txtNgay.getDate()));
		lblThang.setForeground(new Color(58, 181, 74));
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThang.setBounds(429, 61, 108, 50);
		add(lblThang);

		pnlDoanhThu = new JPanel();
		pnlDoanhThu.setBounds(30, 124, 777, 567);
		add(pnlDoanhThu);
		thongKeDoanhThu(pnlDoanhThu);

		JLabel lblTngThuTrong_2_1_1 = new JLabel("Chọn tháng:");
		lblTngThuTrong_2_1_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1_1.setBounds(48, 20, 182, 30);
		add(lblTngThuTrong_2_1_1);

		pnlTopXe = new JPanel();
		pnlTopXe.setBackground(Color.WHITE);
		pnlTopXe.setBounds(863, 124, 553, 528);
		add(pnlTopXe);

		thongKeTopXe(pnlTopXe);

		dangKiSuKien();

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
	 * Biểu đồ cột thống kê số doanh thu bán trong tháng
	 * 
	 * @param jpnItem
	 */
	public void thongKeDoanhThu(JPanel jpnItem) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Random r = new Random();
		for (int i = 1; i <= 31; i++) {
			int ran = r.nextInt(15);
			dataset.addValue(ran, "Doanh thu", i + "");
		}

		JFreeChart barChart = ChartFactory.createBarChart("".toUpperCase(), "Ngày", "Doanh thu", dataset,
				PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel1 = new ChartPanel(barChart);
		chartPanel1.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel1);
		jpnItem.validate();
		jpnItem.repaint();
	}

	/**
	 * Biểu đồ trò thống kê top các xe bán chạy trong tháng
	 * 
	 * @param jpnItem
	 */
	public void thongKeTopXe(JPanel jpnItem) {

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Honda", 4);
		pieDataset.setValue("Yamaha", 3);
		pieDataset.setValue("Suzuki", 2);
		pieDataset.setValue("SYM", 1);

		JFreeChart pieChart = ChartFactory.createPieChart("", pieDataset, true, true, true);

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
