package ui.quanLyXeMay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.DongXeDao;
import dao.HangXeDao;
import dao.LoaiXeDao;
import dao.XeMayDao;
import dao.XuatXuDao;
import entity.XeMay;
import other.DinhDangTien;
import other.XuLyChung;

public class GD_XeMay extends JPanel implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private DefaultTableModel modelXe;
	private JTable tblXeMay;

	private JMenuItem mntmHang;
	private JMenuItem mntmLoaiXe;
	private JMenuItem mntmDongXe;
	private JMenuItem mntmXuatXu;

	private JComboBox<String> cboTimKiem;
	private JComboBox<String> cboHangXe;
	private JComboBox<String> cboLoaiXe;
	private JComboBox<String> cboDongXe;
	private JComboBox<String> cboXuatXu;

	private int page = 1;
	private int maxPage = 0;
	private static final int SIZE = 17;

	private XeMayDao xeMayDao;
	private List<XeMay> xeMays;
	private JComboBox<String> cboMauXe;
	private JComboBox<String> cboGiaXe;
	private JButton btnXemChiTiet;

	/**
	 * Create the panel.
	 */
	public GD_XeMay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPaneXeMay = new JScrollPane();
		scrollPaneXeMay.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneXeMay.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneXeMay.setBounds(33, 278, 1727, 626);
		add(scrollPaneXeMay);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(977, 937, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 83, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] { "Tên xe", "Mã xe" }));
		cboTimKiem.setBounds(151, 83, 120, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(273, 83, 526, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel lblTngThuTrong_1_1 = new JLabel("Hãng:");
		lblTngThuTrong_1_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1.setBounds(920, 83, 83, 30);
		add(lblTngThuTrong_1_1);

		cboHangXe = new JComboBox<String>();
		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setBounds(1015, 83, 245, 30);
		add(cboHangXe);

		JPopupMenu popupHang = new JPopupMenu();
		addPopup(cboHangXe, popupHang);

		mntmHang = new JMenuItem("Quản lý hãng xe");
		mntmHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popupHang.add(mntmHang);

		JLabel lblTngThuTrong_1_1_1 = new JLabel("Loại xe:");
		lblTngThuTrong_1_1_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_1.setBounds(1404, 83, 83, 30);
		add(lblTngThuTrong_1_1_1);

		cboLoaiXe = new JComboBox<String>();
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(1515, 83, 245, 30);
		add(cboLoaiXe);

		JPopupMenu popupLoaiXe = new JPopupMenu();
		popupLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPopup(cboLoaiXe, popupLoaiXe);

		mntmLoaiXe = new JMenuItem("Quản lý loại xe");
		mntmLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popupLoaiXe.add(mntmLoaiXe);

		JLabel lblTngThuTrong_1_1_2 = new JLabel("Dòng xe:");
		lblTngThuTrong_1_1_2.setForeground(Color.BLACK);
		lblTngThuTrong_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2.setBounds(33, 142, 83, 30);
		add(lblTngThuTrong_1_1_2);

		cboDongXe = new JComboBox<String>();
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(151, 142, 197, 30);
		add(cboDongXe);

		JPopupMenu popupDongXe = new JPopupMenu();
		addPopup(cboDongXe, popupDongXe);

		mntmDongXe = new JMenuItem("Quản lý dòng xe");
		mntmDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popupDongXe.add(mntmDongXe);

		JLabel lblTngThuTrong_1_1_2_1 = new JLabel("Xuất xứ:");
		lblTngThuTrong_1_1_2_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_1.setBounds(495, 142, 83, 30);
		add(lblTngThuTrong_1_1_2_1);

		cboXuatXu = new JComboBox<String>();
		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setBackground(Color.WHITE);
		cboXuatXu.setBounds(602, 142, 197, 30);
		add(cboXuatXu);

		JPopupMenu popupXuatXu = new JPopupMenu();
		addPopup(cboXuatXu, popupXuatXu);

		mntmXuatXu = new JMenuItem("Quản lý xuất xứ");
		mntmXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popupXuatXu.add(mntmXuatXu);

		JLabel lblTngThuTrong_1_1_2_2 = new JLabel("Danh sách xe máy");
		lblTngThuTrong_1_1_2_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_2.setBounds(33, 205, 175, 30);
		add(lblTngThuTrong_1_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(33, 248, 1727, 11);
		add(separator);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(33, 937, 50, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(106, 937, 50, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(268, 937, 50, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(346, 937, 50, 40);
		add(btnCuoi);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setColumns(10);
		txtTrang.setBounds(182, 938, 60, 40);
		add(txtTrang);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1594, 937, 160, 40);
		add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_construction_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 102, 255));
		btnSua.setBounds(1407, 937, 160, 40);
		add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(1222, 937, 160, 40);
		add(btnXoa);

		String[] colHeaderXeMay = { "STT", "Mã xe", "Tên xe", "hãng", "Màu sắc", "Số lượng", "Giá Bán", "Bảo hành" };
		modelXe = new DefaultTableModel(colHeaderXeMay, 0);
		tblXeMay = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
																			// 1385
				return false;
			}
		};
		tblXeMay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXeMay.setRowHeight(35);
		scrollPaneXeMay.setViewportView(tblXeMay);
		tblXeMay.getColumnModel().getColumn(0).setPreferredWidth(85);
		tblXeMay.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblXeMay.getColumnModel().getColumn(2).setPreferredWidth(700);
		tblXeMay.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblXeMay.getColumnModel().getColumn(4).setPreferredWidth(250);
		tblXeMay.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblXeMay.getColumnModel().getColumn(6).setPreferredWidth(300);
		tblXeMay.getColumnModel().getColumn(7).setPreferredWidth(150);
//		center value in column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tblXeMay.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tblXeMay.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tblXeMay.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		tblXeMay.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		tblXeMay.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		tblXeMay.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );

		
		JLabel lblM = new JLabel("Màu xe:");
		lblM.setForeground(Color.BLACK);
		lblM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblM.setBounds(920, 142, 83, 30);
		add(lblM);

		cboMauXe = new JComboBox<String>();
		cboMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMauXe.setBackground(Color.WHITE);
		cboMauXe.setBounds(1015, 142, 245, 30);
		add(cboMauXe);

		JLabel lblTngThuTrong_1_3 = new JLabel("Giá:");
		lblTngThuTrong_1_3.setForeground(Color.BLACK);
		lblTngThuTrong_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_3.setBounds(1404, 142, 103, 30);
		add(lblTngThuTrong_1_3);

		cboGiaXe = new JComboBox<String>();
		cboGiaXe.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Tất cả", "Dưới 25tr", "Từ 25tr-60tr", "Trên 60tr" }));
		cboGiaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboGiaXe.setBackground(Color.WHITE);
		cboGiaXe.setBounds(1515, 142, 245, 30);
		add(cboGiaXe);
		JTableHeader tableHeader2 = tblXeMay.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		dangKiSuKien();
		khoiTao();
		loadDuLieuThongTinTimKiem();
		capNhatXeMaysTrongBang();

	}

	/**
	 * Kết nối database
	 */
	public void khoiTao() {
		xeMayDao = XeMayDao.getInstance();
	}

	/**
	 * Cập nhật xe máy trong bảng
	 */
	private void capNhatXeMaysTrongBang() {

		int from = (SIZE * (page - 1) + 1);
		int to = page * SIZE;

		String timKiem = txtTimKiem.getText();
		String field = cboTimKiem.getSelectedItem().toString();
		String gia = cboGiaXe.getSelectedItem().toString();
		String mauXe = cboMauXe.getSelectedItem().toString();
		String tenXuatXu = cboXuatXu.getSelectedItem().toString();
		String tenLoaiXe = cboLoaiXe.getSelectedItem().toString();
		String tenDongXe = cboDongXe.getSelectedItem().toString();
		String tenHangXe = cboHangXe.getSelectedItem().toString();
		this.maxPage = xeMayDao.getMaxPageTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
				tenHangXe, SIZE);
		xeMays = xeMayDao.getXeMaysTheoNhieuTieuChi(timKiem, field, gia, mauXe, tenXuatXu, tenLoaiXe, tenDongXe,
				tenHangXe, from, to);

		xoaDuLieuXeMayTrongBang();
		themXeMayVaoBang();
		txtTrang.setText(this.page + "");

	}

	/**
	 * Thêm danh sách xe máy vào bảng
	 */
	private void themXeMayVaoBang() {

		if (xeMays != null) {
			for (XeMay xeMay : xeMays) {
				themXeMayVaoBang(xeMay);
			}
		}

	}

	/**
	 * Thêm một xe máy vào bảng
	 * 
	 * @param xeMay
	 */
	private void themXeMayVaoBang(XeMay xeMay) {

		Object[] datas = new Object[8];
		datas[0] = tblXeMay.getRowCount() + 1;
		datas[1] = xeMay.getMaXeMay();
		datas[2] = xeMay.getTenXeMay();
		datas[3] = xeMay.getDongXe().getHangXe().getTenHangXe();
		datas[4] = xeMay.getMauXe();
		datas[5] = xeMay.getSoLuong();
		datas[6] = DinhDangTien.format(xeMay.getGiaNhap());
		datas[7] = xeMay.getThoiGianBaoHanh();
		modelXe.addRow(datas);
	}

	/**
	 * Xóa dữ liệu trong bảng
	 */
	private void xoaDuLieuXeMayTrongBang() {
		modelXe.getDataVector().removeAllElements();
		modelXe.fireTableDataChanged();
	}

	/**
	 * load dữ liệu thông tin tìm kiếm
	 */
	private void loadDuLieuThongTinTimKiem() {
		XuatXuDao xuatXuDao = XuatXuDao.getInstance();
		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		HangXeDao hangXeDao = HangXeDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();

		cboXuatXu.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				xuatXuDao.getXuatXus().stream().map(s -> s.getTenXuatXu()).collect(Collectors.toList()))));
		cboLoaiXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				loaiXeDao.getLoaiXes().stream().map(s -> s.getTenLoaiXe()).collect(Collectors.toList()))));
		cboHangXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				hangXeDao.getHangXes().stream().map(s -> s.getTenHangXe()).collect(Collectors.toList()))));
		cboDongXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				dongXeDao.getDongXes().stream().map(s -> s.getTenDongXe()).collect(Collectors.toList()))));

		cboMauXe.addItem("Tất cả");
		for (String mauXe : xeMayDao.getMauXes()) {
			cboMauXe.addItem(mauXe);
		}

	}

	/**
	 * Xem chi tiết xe máy
	 */
	private void xemChiTiet() {
		int row = tblXeMay.getSelectedRow();
		if (row != -1) {
			String ma = tblXeMay.getValueAt(row, 1).toString().trim();
			XeMay xeMay = xeMayDao.getXeMayTheoMa(ma);
			new GD_ChiTietXeMay(xeMay).setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xem chi tiết");
		}
	}

	/**
	 * Chuyển panel
	 * 
	 * @param newPanel
	 */
	public void setManHinh(JPanel newPanel) {
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(newPanel);
		this.validate();
		this.repaint();
	}

	/**
	 * Cập nhật thông tin xe máy
	 */
	private void capNhatThongTinXe() {
		int row = tblXeMay.getSelectedRow();
		if (row != -1) {
			String ma = tblXeMay.getValueAt(row, 1).toString().trim();
			XeMay xeMay = xeMayDao.getXeMayTheoMa(ma);
			setManHinh(new GD_CapNhatXeMay(xeMay));
		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để sửa");
		}
	}

	/**
	 * Đăng kí sự kiện
	 */
	private void dangKiSuKien() {
		// Phân Trang
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnTruoc.addActionListener(this);

		// Chức năng chính
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXemChiTiet.addActionListener(this);

		// Popupmenu
		mntmDongXe.addActionListener(this);
		mntmHang.addActionListener(this);
		mntmLoaiXe.addActionListener(this);
		mntmXuatXu.addActionListener(this);

		// ComboBox
		cboDongXe.addActionListener(this);
		cboHangXe.addActionListener(this);
		cboLoaiXe.addActionListener(this);
		cboTimKiem.addActionListener(this);
		cboXuatXu.addActionListener(this);
		cboMauXe.addActionListener(this);
		cboGiaXe.addActionListener(this);

		// Tìm kiếm
		txtTimKiem.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			setManHinh(new GD_ThemXeMay());
		}
		if (o.equals(btnSua)) {
			capNhatThongTinXe();
		}
		if (o.equals(btnXoa)) {
//			
		}
		if (o.equals(btnXemChiTiet)) {
			xemChiTiet();
		}
		if (o.equals(mntmDongXe)) {
			new GD_DongXe().setVisible(true);
		}
		if (o.equals(mntmHang)) {
			new GD_HangXe().setVisible(true);
		}
		if (o.equals(mntmLoaiXe)) {
			new GD_LoaiXe().setVisible(true);
		}
		if (o.equals(mntmXuatXu)) {
			new GD_XuatXu().setVisible(true);
		}
		if (o.equals(cboDongXe) || o.equals(cboGiaXe) || o.equals(cboHangXe) || o.equals(cboLoaiXe)
				|| o.equals(cboMauXe) || o.equals(cboTimKiem) || o.equals(cboXuatXu)) {
			this.page = 1;
			capNhatXeMaysTrongBang();
		}
		if (o.equals(cboTimKiem)) {
			this.page = 1;
			txtTimKiem.setText("");
			capNhatXeMaysTrongBang();
		}
		if (o.equals(btnTruoc) && this.page > 1) {

			this.page--;
			capNhatXeMaysTrongBang();
		}

		if (o.equals(btnSau) && this.page < maxPage) {
			this.page++;
			capNhatXeMaysTrongBang();
		}

		if (o.equals(btnDau)) {
			this.page = 1;
			capNhatXeMaysTrongBang();
		}

		if (o.equals(btnCuoi)) {
			this.page = maxPage;
			capNhatXeMaysTrongBang();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.page = 1;
		capNhatXeMaysTrongBang();
	}

	/**
	 * Menu popup
	 * 
	 * @param component
	 * @param popup
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
