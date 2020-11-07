package ui.quanLyKhachHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.KhachHangDao;
import entity.KhachHang;
import ui.App;

public class GD_KhachHang extends JPanel implements ActionListener, MouseListener {

	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnThem;
	private DefaultTableModel modelKhachHang;
	private JTable tblKhachHang;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXemChiTiet;

	private int page = 1;
	private int maxPage = 2;
	private static final int SIZE = 20;
	private KhachHangDao khachHangDao;
	private List<KhachHang> khachHangs;

	/**
	 * Create the panel.
	 */
	public GD_KhachHang() {

		khachHangDao = KhachHangDao.getInstance();

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPaneKhachHang = new JScrollPane();
		scrollPaneKhachHang.setBounds(29, 200, 1385, 532);
		add(scrollPaneKhachHang);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet
				.setIcon(new ImageIcon(GD_KhachHang.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(592, 753, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 83, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(
				new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số CMT" }));
		cboTimKiem.setBounds(151, 83, 274, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(451, 83, 311, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel lblTngThuTrong_1_1_2_2 = new JLabel("Danh sách khách hàng");
		lblTngThuTrong_1_1_2_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_2.setBounds(29, 133, 209, 30);
		add(lblTngThuTrong_1_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 176, 1385, 11);
		add(separator);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_KhachHang.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(29, 753, 50, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_KhachHang.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(102, 753, 50, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_KhachHang.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(264, 753, 50, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_KhachHang.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
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
		btnThem.setIcon(
				new ImageIcon(GD_KhachHang.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1239, 753, 168, 40);
		add(btnThem);

		String[] colHeaderKhachHang = { "STT", "Mã khách hàng", "Tên khách hàng", "Số CMT", "Số điện thoại" };
		modelKhachHang = new DefaultTableModel(colHeaderKhachHang, 0);
		tblKhachHang = new JTable(modelKhachHang) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblKhachHang.setRowHeight(25);
		scrollPaneKhachHang.setViewportView(tblKhachHang);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblKhachHang.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

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
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(1041, 753, 168, 40);
		add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(843, 753, 168, 40);
		add(btnXoa);

		dangKiSuKien();
		loadDuLieu();

	}

	private void dangKiSuKien() {
		btnDau.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnSau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemChiTiet.addActionListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
		Object source = e.getSource();
		if (source.equals(btnThem)) {
			new GD_ThemKhachHang().setVisible(true);
		}
		if (source.equals(btnSua)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_CapNhatKhachHang());
			this.validate();
			this.repaint();

		}
		if (source.equals(btnXemChiTiet)) {
			new GD_ChiTietKhachHang().setVisible(true);
		}

		if (source == btnDau) {
			this.page = 1;
			loadDuLieu();
		}

		if (source == btnCuoi) {
			this.page = maxPage;
			loadDuLieu();
		}

		if (source == btnSau && page < maxPage) {
			this.page++;
			loadDuLieu();

		}

		if (source == btnTruoc && page > 1) {
			this.page--;
			loadDuLieu();
		}

		if (source == btnThem) {
			new GD_ThemKhachHang().setVisible(true);

		}

	}

	private void loadDuLieu() {
		khachHangs = khachHangDao.getKhachHangs((SIZE * (page - 1) + 1), page * SIZE);

		if (khachHangs.size() > 0) {
			xoaDuLieuTrongBang();
			themKhachHangsVaoBang();
			txtTrang.setText(this.page + "");
		}
	}

	private void themKhachHangsVaoBang() {
		if (khachHangs != null) {
			for (KhachHang khachHang : khachHangs) {
				themKhachHangVaoBang(khachHang);
			}
		}
	}

	private void themKhachHangVaoBang(KhachHang khachHang) {

		Object[] object = new Object[5];
		object[0] = tblKhachHang.getRowCount() + 1;
		object[1] = khachHang.getMaKhachHang();
		object[2] = khachHang.getHoTenKH();
		object[3] = khachHang.getSoCMT();
		object[4] = khachHang.getSoDienThoai();
		modelKhachHang.addRow(object);
	}

	private void xoaDuLieuTrongBang() {
		while (modelKhachHang.getRowCount() > 0) {
			modelKhachHang.removeRow(0);
		}

	}
}
