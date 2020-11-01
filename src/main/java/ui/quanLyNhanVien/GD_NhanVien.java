package ui.quanLyNhanVien;

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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

public class GD_NhanVien extends JPanel implements ActionListener, MouseListener {
	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnThem;
	private DefaultTableModel modelNVHanhChinh;
	private JButton btnSua;
	private JButton btnXoa;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneNVHanhChinh;
	private JScrollPane scrollPaneNVKyThuat;
	private JTable tblNvHanhChinh;
	private DefaultTableModel modelNVKyThuat;
	private JTable tblNVKyThuat;

	/**
	 * Create the panel.
	 */
	public GD_NhanVien() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setToolTipText("Xem chi tiết nhân viên");
		btnXemChiTiet
				.setIcon(new ImageIcon(GD_NhanVien.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(592, 753, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 74, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(
				new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số CMT" }));
		cboTimKiem.setBounds(151, 74, 274, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(451, 74, 311, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel lblTngThuTrong_1_1_2_2 = new JLabel("Danh sách nhân viên");
		lblTngThuTrong_1_1_2_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_2.setBounds(33, 117, 209, 30);
		add(lblTngThuTrong_1_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(33, 150, 1385, 11);
		add(separator);

		btnDau = new JButton("");
		btnDau.setToolTipText("Đến trang đầu");
		btnDau.setIcon(new ImageIcon(GD_NhanVien.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(29, 753, 50, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setToolTipText("Đến trang trước");
		btnTruoc.setIcon(new ImageIcon(GD_NhanVien.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(102, 753, 50, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setToolTipText("Đến trang sau");
		btnSau.setIcon(new ImageIcon(GD_NhanVien.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(264, 753, 50, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setToolTipText("Đến trang cuối");
		btnCuoi.setIcon(new ImageIcon(GD_NhanVien.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
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

		btnThem = new JButton("Thêm");
		btnThem.setToolTipText("Thêm nhân viên");
		btnThem.setIcon(new ImageIcon(GD_NhanVien.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1239, 753, 168, 40);
		add(btnThem);

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

		btnSua = new JButton("Sửa");
		btnSua.setToolTipText("Sửa thông tin nhân viên");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(1041, 753, 168, 40);
		add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setToolTipText("Xóa nhân viên");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(843, 753, 168, 40);
		add(btnXoa);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 165, 1374, 569);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabbedPane.setBackground(new Color(58, 181, 74));
		tabbedPane.setForeground(Color.WHITE);
		add(tabbedPane);

		scrollPaneNVHanhChinh = new JScrollPane();
		tabbedPane.addTab("Nhân viên hành chính", null, scrollPaneNVHanhChinh, null);

		String[] colHeaderNVHanhChinh = { "STT", "Mã nhân viên hành chính", "Tên nhân viên hành chính", "Chức vụ",
				"Số điện thoại" };
		modelNVHanhChinh = new DefaultTableModel(colHeaderNVHanhChinh, 0);
		tblNvHanhChinh = new JTable(modelNVHanhChinh) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblNvHanhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblNvHanhChinh.setRowHeight(25);
		scrollPaneNVHanhChinh.setViewportView(tblNvHanhChinh);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblNvHanhChinh.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 21; i++) {
			modelNVHanhChinh.addRow(new Object[] { i, null, null, null });
		}

		scrollPaneNVKyThuat = new JScrollPane();
		tabbedPane.addTab("Nhân viên kỹ thuật", null, scrollPaneNVKyThuat, null);

		String[] colHeaderNVKyThuat = { "STT", "Mã nhân viên kỹ thuật", "Tên nhân viên kỹ thuật", "Số năm kinh nghiệm",
				"Bậc thợ" };
		modelNVKyThuat = new DefaultTableModel(colHeaderNVKyThuat, 0);
		tblNVKyThuat = new JTable(modelNVKyThuat) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblNVKyThuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblNVKyThuat.setRowHeight(25);
		scrollPaneNVKyThuat.setViewportView(tblNVKyThuat);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeaderNVKyThuat = tblNVKyThuat.getTableHeader();
		tableHeaderNVKyThuat.setBackground(new Color(58, 181, 74));
		tableHeaderNVKyThuat.setForeground(Color.white);
		tableHeaderNVKyThuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 21; i++) {
			modelNVKyThuat.addRow(new Object[] { i, null, null, null });
		}

		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnThem.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnThem.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);

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

	}
}
