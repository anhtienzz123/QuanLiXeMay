package ui.quanLyBaoHanh;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventObject;
import java.util.List;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ui.App;
import ui.ChuyenManHinh;
import ui.DanhMuc;
import ui.quanLyBaoHanh.GD_BaoHanh;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class GD_QuanLyBaoHanh extends JPanel implements ActionListener, MouseListener {
	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private DefaultTableModel modelBaoHanh;
	private JTable tblBaoHanh;
	private JButton btnXemChiTiet;

	/**
	 * Create the panel.
	 */
	public GD_QuanLyBaoHanh() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý Bảo hành");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPaneBaoHanh = new JScrollPane();
		scrollPaneBaoHanh.setBounds(29, 200, 1385, 532);
		add(scrollPaneBaoHanh);

		 btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_QuanLyBaoHanh.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(1196, 753, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 83, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Mã phiếu bảo hành", "Mã hóa đơn", "Mã nhân viên", "Tên nhân viên lập", "Mã khách hàng", "Tên khách hàng", "Số điện thoại"}));
		cboTimKiem.setBounds(151, 83, 274, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(451, 83, 311, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel lblTngThuTrong_1_1_2_2 = new JLabel("Danh sách hợp đồng");
		lblTngThuTrong_1_1_2_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_2.setBounds(29, 133, 209, 30);
		add(lblTngThuTrong_1_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 176, 1385, 11);
		add(separator);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_QuanLyBaoHanh.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(29, 753, 50, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_QuanLyBaoHanh.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(102, 753, 50, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_QuanLyBaoHanh.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(264, 753, 50, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_QuanLyBaoHanh.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(342, 753, 50, 40);
		add(btnCuoi);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setColumns(10);
		txtTrang.setBounds(178, 754, 60, 40);
		add(txtTrang);

		String[] colHeaderHopDong = { "STT", "Mã hóa đơn", "Tên nhân viên", "Tên nhân viên", "Mã khách hàng",
				"Tên khách hàng", "ngày lập hóa đơn" };
		modelBaoHanh = new DefaultTableModel(colHeaderHopDong, 0);
		tblBaoHanh = new JTable(modelBaoHanh) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblBaoHanh.setRowHeight(25);
		scrollPaneBaoHanh.setViewportView(tblBaoHanh);

		JLabel lblTngThuTrong_1_1 = new JLabel("Ngày lập hợp đồng:");
		lblTngThuTrong_1_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1.setBounds(886, 83, 175, 30);
		add(lblTngThuTrong_1_1);

		JDateChooser txtNgay = new JDateChooser();
		txtNgay.setBounds(1073, 83, 189, 30);
		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 817, 1450, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1450, 133);
		pnlLogo.add(lblLogo);
		
		JButton btnDanhMucBaoHanh = new JButton("Danh mục bảo hành");
		btnDanhMucBaoHanh.setForeground(Color.WHITE);
		btnDanhMucBaoHanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDanhMucBaoHanh.setBackground(Color.GRAY);
		btnDanhMucBaoHanh.setBounds(906, 753, 257, 40);
		add(btnDanhMucBaoHanh);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 21; i++) {
			modelBaoHanh.addRow(new Object[] { i, null, null, null });
		}
		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnTruoc.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXemChiTiet)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_BaoHanh());
			this.validate();
			this.repaint();
		}

	}
}
