package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EventObject;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

public class GD_ThongKe extends JPanel {

	private JPanel pnlThongKe;
	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JTable tblDoanhThu;

	/**
	 * Create the panel.
	 */
	public GD_ThongKe() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JPanel pnlThongKeThang = new JPanel();
		pnlThongKeThang.setBackground(new Color(0, 150, 199));
		pnlThongKeThang.setBounds(505, 100, 433, 140);
		add(pnlThongKeThang);
		pnlThongKeThang.setLayout(null);

		JLabel lblTngThuTrong = new JLabel("Tổng thu trong tháng");
		lblTngThuTrong.setForeground(Color.WHITE);
		lblTngThuTrong.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong.setBounds(12, 49, 317, 50);
		pnlThongKeThang.add(lblTngThuTrong);

		JLabel lblThongKeThang = new JLabel("150,000,000 VNĐ");
		lblThongKeThang.setForeground(Color.WHITE);
		lblThongKeThang.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeThang.setBounds(12, 0, 317, 69);
		pnlThongKeThang.add(lblThongKeThang);

		JPanel pnlXemChiTietDTThang = new JPanel();
		pnlXemChiTietDTThang.setBackground(new Color(0, 119, 182));
		pnlXemChiTietDTThang.setBounds(0, 105, 433, 35);
		pnlThongKeThang.add(pnlXemChiTietDTThang);
		pnlXemChiTietDTThang.setLayout(null);

		JLabel lblChiTietDTThang = new JLabel("Xem chi tiết ");
		lblChiTietDTThang.setHorizontalTextPosition(SwingConstants.LEADING);
		lblChiTietDTThang.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/img/next_page_26px.png")));
		lblChiTietDTThang.setBounds(0, 0, 433, 35);
		pnlXemChiTietDTThang.add(lblChiTietDTThang);
		lblChiTietDTThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDTThang.setForeground(Color.WHITE);
		lblChiTietDTThang.setFont(new Font("Tahoma", Font.ITALIC, 20));

		JLabel lblThongKeNgay_1_1 = new JLabel("");
		lblThongKeNgay_1_1.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/img/coins_100px.png")));
		lblThongKeNgay_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeNgay_1_1.setForeground(Color.WHITE);
		lblThongKeNgay_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay_1_1.setBounds(283, 0, 150, 107);
		pnlThongKeThang.add(lblThongKeNgay_1_1);

		JPanel pnlThongKeNgay = new JPanel();
		pnlThongKeNgay.setLayout(null);
		pnlThongKeNgay.setBackground(new Color(58, 181, 74));
		pnlThongKeNgay.setBounds(33, 100, 433, 140);
		add(pnlThongKeNgay);

		JLabel lblTngThuTrong_3 = new JLabel("Tổng thu trong ngày");
		lblTngThuTrong_3.setForeground(Color.WHITE);
		lblTngThuTrong_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_3.setBounds(12, 49, 317, 50);
		pnlThongKeNgay.add(lblTngThuTrong_3);

		JLabel lblThongKeNgay = new JLabel("15,000,000 VNĐ");
		lblThongKeNgay.setForeground(Color.WHITE);
		lblThongKeNgay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay.setBounds(12, 0, 317, 69);
		pnlThongKeNgay.add(lblThongKeNgay);

		JPanel pnlXemChiTietDTNgay = new JPanel();
		pnlXemChiTietDTNgay.setLayout(null);
		pnlXemChiTietDTNgay.setBackground(new Color(9, 161, 41));
		pnlXemChiTietDTNgay.setBounds(0, 105, 433, 35);
		pnlThongKeNgay.add(pnlXemChiTietDTNgay);

		JLabel lblChiTietDTNgay = new JLabel("Xem chi tiết ");
		lblChiTietDTNgay.setHorizontalTextPosition(SwingConstants.LEADING);
		lblChiTietDTNgay.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/img/next_page_26px.png")));
		lblChiTietDTNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDTNgay.setForeground(Color.WHITE);
		lblChiTietDTNgay.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblChiTietDTNgay.setBounds(0, 0, 433, 35);
		pnlXemChiTietDTNgay.add(lblChiTietDTNgay);

		JLabel lblThongKeNgay_1 = new JLabel("");
		lblThongKeNgay_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeNgay_1.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/img/expensive_price_100px.png")));
		lblThongKeNgay_1.setForeground(Color.WHITE);
		lblThongKeNgay_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay_1.setBounds(283, 0, 150, 105);
		pnlThongKeNgay.add(lblThongKeNgay_1);

		JPanel pnlThongKeNam = new JPanel();
		pnlThongKeNam.setLayout(null);
		pnlThongKeNam.setBackground(new Color(237, 197, 49));
		pnlThongKeNam.setBounds(985, 100, 433, 140);
		add(pnlThongKeNam);

		JLabel lblTngThuTrong_1 = new JLabel("Tổng thu trong năm");
		lblTngThuTrong_1.setForeground(Color.WHITE);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_1.setBounds(12, 49, 317, 50);
		pnlThongKeNam.add(lblTngThuTrong_1);

		JLabel lblThongKeNam = new JLabel("1,500,000,000 VNĐ");
		lblThongKeNam.setForeground(Color.WHITE);
		lblThongKeNam.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNam.setBounds(12, 0, 317, 69);
		pnlThongKeNam.add(lblThongKeNam);

		JPanel pnlXemChiTietDTNam = new JPanel();
		pnlXemChiTietDTNam.setLayout(null);
		pnlXemChiTietDTNam.setBackground(new Color(201, 162, 39));
		pnlXemChiTietDTNam.setBounds(0, 105, 433, 35);
		pnlThongKeNam.add(pnlXemChiTietDTNam);

		JLabel lblChiTietDTNam = new JLabel("Xem chi tiết ");
		lblChiTietDTNam.setHorizontalTextPosition(SwingConstants.LEADING);
		lblChiTietDTNam.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/img/next_page_26px.png")));
		lblChiTietDTNam.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietDTNam.setForeground(Color.WHITE);
		lblChiTietDTNam.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblChiTietDTNam.setBounds(0, 0, 433, 35);
		pnlXemChiTietDTNam.add(lblChiTietDTNam);

		JLabel lblThongKeNgay_1_1_1 = new JLabel("");
		lblThongKeNgay_1_1_1.setIcon(new ImageIcon(GD_ThongKe.class.getResource("/img/sales_performance_100px.png")));
		lblThongKeNgay_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKeNgay_1_1_1.setForeground(Color.WHITE);
		lblThongKeNgay_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay_1_1_1.setBounds(283, 0, 150, 107);
		pnlThongKeNam.add(lblThongKeNgay_1_1_1);

		JScrollPane scrollPaneDoanhThu = new JScrollPane();
		scrollPaneDoanhThu.setBounds(856, 341, 562, 532);
		add(scrollPaneDoanhThu);

		String[] colHeaderDoanhThu = { "STT", "Mã hóa đơn", "Tên nhân viên lập", "Tên khách hàng"};
		modelDoanhThu = new DefaultTableModel(colHeaderDoanhThu, 0);
		tblDoanhThu = new JTable(modelDoanhThu) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblDoanhThu.setRowHeight(25);
		scrollPaneDoanhThu.setViewportView(tblDoanhThu);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblDoanhThu.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 21; i++) {
			modelDoanhThu.addRow(new Object[] { i, null, null, null });
		}
		tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(122);
		tblDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		
		

		JLabel lblTngThuTrong_2 = new JLabel("Danh sách hóa đơn đã lập trong ngày");
		lblTngThuTrong_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2.setBounds(856, 278, 392, 50);
		add(lblTngThuTrong_2);

		JDateChooser txtNgay = new JDateChooser();
		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setBounds(1245, 288, 172, 30);
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);

		JLabel lblTngThuTrong_2_1 = new JLabel("Doanh thu tháng");
		lblTngThuTrong_2_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1.setBounds(257, 278, 182, 50);
		add(lblTngThuTrong_2_1);

		JLabel lblThang = new JLabel("10-2020");
		DateFormat df = new SimpleDateFormat("MM-yyyy");
		lblThang.setText(df.format(txtNgay.getDate()));
		lblThang.setForeground(new Color(58, 181, 74));
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThang.setBounds(432, 278, 108, 50);
		add(lblThang);

		pnlThongKe = new JPanel();
		pnlThongKe.setBounds(33, 341, 777, 567);
		add(pnlThongKe);
		setDataToChart1(pnlThongKe);

	}

	public void setDataToChart1(JPanel jpnItem) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Random r = new Random();
		for (int i = 1; i <= 31; i++) {
			int ran = r.nextInt(15);
			dataset.addValue(ran, "Học viên", i + "");
		}

		JFreeChart barChart = ChartFactory.createBarChart("".toUpperCase(), "Ngày", "Doanh thu", dataset,
				PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

		jpnItem.removeAll();
		jpnItem.setLayout(new BorderLayout());
		jpnItem.add(chartPanel);
		jpnItem.validate();
		jpnItem.repaint();
	}
}
