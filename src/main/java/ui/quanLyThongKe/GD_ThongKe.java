package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import dao.ThongKeDao;
import other.DinhDangTien;
import other.TableColorCellRender;
import ui.quanLyHoaDon.GD_LapHoaDon;
import java.awt.CardLayout;
import javax.swing.BoxLayout;

public class GD_ThongKe extends JPanel implements MouseListener {

	private JPanel pnlTKThang;
	private Vector colHeaderDoanhThu;
	private DefaultTableModel modelDoanhThu;
	private JLabel lblChiTietDTNgay;
	private JLabel lblChiTietDTThang;
	private JLabel lblChiTietDTNam;
	private JPanel pnlXemChiTietDTNgay;
	private JPanel pnlXemChiTietDTNam;
	private JPanel pnlXemChiTietDTThang;
	private DefaultTableModel modelHDNgay;
	private JPanel pnlTK;

	private LocalDate localDate;
	private ThongKeDao thongKeDao;
	private JLabel lblThongKeNgay;
	private JLabel lblThongKeNam;
	private JLabel lblThongKeThang;

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

		lblThongKeThang = new JLabel();
		lblThongKeThang.setForeground(Color.WHITE);
		lblThongKeThang.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeThang.setBounds(12, 0, 317, 69);
		pnlThongKeThang.add(lblThongKeThang);

		pnlXemChiTietDTThang = new JPanel();
		pnlXemChiTietDTThang.setBackground(new Color(0, 119, 182));
		pnlXemChiTietDTThang.setBounds(0, 105, 433, 35);
		pnlThongKeThang.add(pnlXemChiTietDTThang);
		pnlXemChiTietDTThang.setLayout(null);

		lblChiTietDTThang = new JLabel("Xem chi tiết ");
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

		lblThongKeNgay = new JLabel();
		lblThongKeNgay.setForeground(Color.WHITE);
		lblThongKeNgay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNgay.setBounds(12, 0, 317, 69);
		pnlThongKeNgay.add(lblThongKeNgay);

		pnlXemChiTietDTNgay = new JPanel();
		pnlXemChiTietDTNgay.setLayout(null);
		pnlXemChiTietDTNgay.setBackground(new Color(9, 161, 41));
		pnlXemChiTietDTNgay.setBounds(0, 105, 433, 35);
		pnlThongKeNgay.add(pnlXemChiTietDTNgay);

		lblChiTietDTNgay = new JLabel("Xem chi tiết ");
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

		lblThongKeNam = new JLabel();
		lblThongKeNam.setForeground(Color.WHITE);
		lblThongKeNam.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThongKeNam.setBounds(12, 0, 317, 69);
		pnlThongKeNam.add(lblThongKeNam);

		pnlXemChiTietDTNam = new JPanel();
		pnlXemChiTietDTNam.setLayout(null);
		pnlXemChiTietDTNam.setBackground(new Color(201, 162, 39));
		pnlXemChiTietDTNam.setBounds(0, 105, 433, 35);
		pnlThongKeNam.add(pnlXemChiTietDTNam);

		lblChiTietDTNam = new JLabel("Xem chi tiết ");
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
		DateFormat df = new SimpleDateFormat("MM-yyyy");

		pnlTK = new JPanel();
		pnlTK.setBounds(0, 244, 1450, 717);
		add(pnlTK);
		pnlTK.setLayout(new BoxLayout(pnlTK, BoxLayout.X_AXIS));
		pnlTK.add(new GD_ThongKeNgay());
		
		khoiTao();
		dangKiSuKien();

	}

	public void dangKiSuKien() {
		lblChiTietDTNam.addMouseListener(this);
		lblChiTietDTNgay.addMouseListener(this);
		lblChiTietDTThang.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblChiTietDTNgay)) {
			pnlTK.removeAll();
			pnlTK.setLayout(new BorderLayout());
			pnlTK.add(new GD_ThongKeNgay());
			pnlTK.validate();
			pnlTK.repaint();
		}
		if (o.equals(lblChiTietDTThang)) {
			pnlTK.removeAll();
			pnlTK.setLayout(new BorderLayout());
			pnlTK.add(new GD_ThongKeThang());
			pnlTK.validate();
			pnlTK.repaint();
		}
		if (o.equals(lblChiTietDTNam)) {
			pnlTK.removeAll();
			pnlTK.setLayout(new BorderLayout());
			pnlTK.add(new GD_ThongKeNam());
			pnlTK.validate();
			pnlTK.repaint();
		}

	}

	private void khoiTao() {
		localDate = LocalDate.now();

		thongKeDao = ThongKeDao.getInstance();
		Double ngay = thongKeDao.getDoanhThuTheoNgay(localDate.getDayOfMonth(), localDate.getMonthValue(),
				localDate.getYear());
		Double thang = thongKeDao.getDoanhThuTheoThang(localDate.getMonthValue(), localDate.getYear());
		Double nam = thongKeDao.getDoanhThuTheoNam(localDate.getYear());

		lblThongKeNgay.setText(DinhDangTien.format(ngay));
		lblThongKeThang.setText(DinhDangTien.format(thang));
		lblThongKeNam.setText(DinhDangTien.format(nam));
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
		if (o.equals(lblChiTietDTNgay)) {
			pnlXemChiTietDTNgay.setBackground(Color.LIGHT_GRAY);
		}
		if (o.equals(lblChiTietDTThang)) {
			pnlXemChiTietDTThang.setBackground(Color.LIGHT_GRAY);
		}
		if (o.equals(lblChiTietDTNam)) {
			pnlXemChiTietDTNam.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(lblChiTietDTNgay)) {
			pnlXemChiTietDTNgay.setBackground(new Color(9, 161, 41));
		}
		if (o.equals(lblChiTietDTThang)) {
			pnlXemChiTietDTThang.setBackground(new Color(0, 119, 182));
		}
		if (o.equals(lblChiTietDTNam)) {
			pnlXemChiTietDTNam.setBackground(new Color(201, 162, 39));
		}

	}

}
