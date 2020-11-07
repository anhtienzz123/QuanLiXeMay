package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.EventObject;
import java.util.Random;
import java.util.Vector;

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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

public class GD_ThongKeNgay extends JPanel implements ActionListener {

	private JPanel pnlThongKe;
	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JTable tblDoanhThu;
	private JButton btnXemChiTiet;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNgay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 717));
		setLayout(null);

		JScrollPane scrollPaneDoanhThu = new JScrollPane();
		scrollPaneDoanhThu.setBounds(854, 104, 562, 532);
		add(scrollPaneDoanhThu);

		String[] colHeaderDoanhThu = { "STT", "Mã hóa đơn", "Tên nhân viên lập", "Số lượng hóa đơn" };
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
//		Auto setSize
//		tblDoanhThu.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(122);
		tblDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(200);
		tblDoanhThu.setShowGrid(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDoanhThu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
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

		JLabel lblTngThuTrong_2_1 = new JLabel("Doanh thu tháng");
		lblTngThuTrong_2_1.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngThuTrong_2_1.setBounds(255, 41, 182, 50);
		add(lblTngThuTrong_2_1);

		JLabel lblThang = new JLabel("10-2020");
		DateFormat df = new SimpleDateFormat("MM-yyyy");
		lblThang.setText(df.format(txtNgay.getDate()));
		lblThang.setForeground(new Color(58, 181, 74));
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThang.setBounds(430, 41, 108, 50);
		add(lblThang);

		pnlThongKe = new JPanel();
		pnlThongKe.setBounds(31, 104, 777, 567);
		add(pnlThongKe);
		setDataToChart1(pnlThongKe);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setToolTipText("Xem chi tiết hóa đơn");
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXemChiTiet.setBounds(1249, 649, 166, 30);
		add(btnXemChiTiet);
		btnXemChiTiet.addActionListener(this);

	}

	/**
	 * Biểu đồ cột thống kê Doanh thu của tháng hiện tại
	 * 
	 * @param jpnItem
	 */
	public void setDataToChart1(JPanel jpnItem) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Random r = new Random();
		for (int i = 1; i <= 31; i++) {
			int ran = r.nextInt(15);
			dataset.addValue(ran, "", i + "");
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

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
