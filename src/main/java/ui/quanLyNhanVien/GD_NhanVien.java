package ui.quanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhanVienHanhChinhDao;
import dao.NhanVienKiThuatDao;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;
import ui.App;

public class GD_NhanVien extends JPanel implements ActionListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
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

	private List<NhanVienHanhChinh> nhanVienHanhChinhs;
	private List<NhanVienKiThuat> nhanVienKiThuats;
	private NhanVienHanhChinhDao nhanVienHanhChinhDao;
	private NhanVienKiThuatDao nhanVienKiThuatDao;

	private int page = 1;
	private int maxPage = 2;
	private static final int SIZE = 20;
	private String field = "";
	private JComboBox<String> cboTimKiem;
	private String maNVThaoTac; //
	private int bangLuaChon;
	private JButton btnXemChiTiet;

	/**
	 * Create the panel.
	 */
	public GD_NhanVien() {

		nhanVienHanhChinhDao = NhanVienHanhChinhDao.getInstance();
		nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();

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

		btnXemChiTiet = new JButton("Xem chi tiết");
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

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Chức vụ" }));

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

		String[] colHeaderNVHanhChinh = { "STT", "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Số điện thoại" };
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

		scrollPaneNVKyThuat = new JScrollPane();
		tabbedPane.addTab("Nhân viên kỹ thuật", null, scrollPaneNVKyThuat, null);

		String[] colHeaderNVKyThuat = { "STT", "Mã nhân viên ", "Tên nhân viên ", "Số năm kinh nghiệm", "Bậc thợ" };
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
		tabbedPane.setSelectedIndex(0);

		dangKiSuKien();
		capNhatLaiDuLieuTrongBang();
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
		txtTimKiem.addKeyListener(this);
		cboTimKiem.addActionListener(this);
		tabbedPane.addMouseListener(this);
		btnXemChiTiet.addActionListener(this);

		addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		getTabAndSetCbo();
		this.bangLuaChon = getTabAndSetCbo();
		this.page = 1;
		capNhatLaiDuLieuTrongBang();

	}

	private Integer getTabAndSetCbo() {
		int bangLuaChon = tabbedPane.getSelectedIndex();
		if (bangLuaChon == 0) {
			cboTimKiem.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Chức vụ" }));
			return bangLuaChon;
		}
		if (bangLuaChon == 1) {
			cboTimKiem.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Mã nhân viên", "Tên nhân viên", "Số năm kinh nghiệm", "Bậc thợ" }));
			return bangLuaChon;
		}
		return -1;
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
		if (o.equals(btnThem)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_ThemNhanVien());
			this.validate();
			this.repaint();
		}

		if (o.equals(btnXemChiTiet)) {

			try {

				if (tabbedPane.getSelectedIndex() == 0) {
					int row = tblNvHanhChinh.getSelectedRow();
					new GD_ChiTietNVHanhChinh(modelNVHanhChinh.getValueAt(row, 1).toString()).setVisible(true);
				}else {
					int row = tblNVKyThuat.getSelectedRow();
					new GD_ChiTietNVKyThuat(modelNVKyThuat.getValueAt(row, 1).toString()).setVisible(true);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Chọn vào nhân viên bạn muốn xem !");
				e2.printStackTrace();
			}

		}
		if (o.equals(btnSua)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			try {
				if (tabbedPane.getSelectedIndex() == 0) {
					int row = tblNvHanhChinh.getSelectedRow();
					this.add(new GD_SuaNhanVienHanhChinh(modelNVHanhChinh.getValueAt(row, 1).toString()));
				} else {
					int row = tblNVKyThuat.getSelectedRow();
					this.add(new GD_SuaNhanVienKyThuat(modelNVKyThuat.getValueAt(row, 1).toString()));
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			this.validate();
			this.repaint();
		}

		if (o == btnDau) {
			this.page = 1;
			capNhatLaiDuLieuTrongBang();
		}

		if (o == btnCuoi) {
			this.page = maxPage;
			capNhatLaiDuLieuTrongBang();
		}

		if (o == btnSau && page < maxPage) {
			this.page++;
			capNhatLaiDuLieuTrongBang();

		}

		if (o == btnTruoc && page > 1) {
			this.page--;
			capNhatLaiDuLieuTrongBang();
		}

		if (o.equals(btnXoa)) {

			maNVThaoTac = getMaNVXoa();

			if (tabbedPane.getSelectedIndex() == 0) {
				int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xóa nhân viên?", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (xacnhan == JOptionPane.YES_OPTION) {
					NhanVienHanhChinh nhanVienHanhChinh = nhanVienHanhChinhDao.getNVHanhChinhTheoMa(maNVThaoTac);
					nhanVienHanhChinh.setTrangThai(false);
					nhanVienHanhChinhDao.capNhatNhanVienHanhChinh(nhanVienHanhChinh);
					JOptionPane.showMessageDialog(this, "Xóa thành công");
					capNhatLaiDuLieuTrongBang();
				}

			} else {

				int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xóa nhân viên?", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (xacnhan == JOptionPane.YES_OPTION) {
					NhanVienKiThuat nhanVienKiThuat = nhanVienKiThuatDao.getNVKiThuatTheoMa(maNVThaoTac);
					System.out.println("Nhana vien ki thuat" + nhanVienKiThuat);
					nhanVienKiThuat.setTrangThai(false);
					nhanVienKiThuatDao.capNhatNhanVienKiThuat(nhanVienKiThuat);
					JOptionPane.showMessageDialog(this, "Xóa thành công");
					capNhatLaiDuLieuTrongBang();
				}
			}
		}
	}

	private String getMaNVXoa() {
		String maXoa;
		if (tabbedPane.getSelectedIndex() == 1) {
			int row = tblNVKyThuat.getSelectedRow();
			maXoa = (String) modelNVKyThuat.getValueAt(row, 1);

		} else {
			int row = tblNvHanhChinh.getSelectedRow();
			maXoa = (String) modelNVHanhChinh.getValueAt(row, 1);
		}
		return maXoa;

	}

	private void themNVHanhChinhsVaoBang() {
		if (nhanVienHanhChinhs != null) {
			for (NhanVienHanhChinh nhanVienHanhChinh : nhanVienHanhChinhs) {
				if (nhanVienHanhChinh.isTrangThai() == true) {
					themNhanVienHanhChinhVaoBang(nhanVienHanhChinh);
				}
			}
		}
	}

	private void themNVKiThuatsVaoBang() {
		if (nhanVienKiThuats != null) {
			for (NhanVienKiThuat nhanVienKiThuat : nhanVienKiThuats) {
				if (nhanVienKiThuat.isTrangThai() == true) {
					themNhanVienKiThuatVaoBang(nhanVienKiThuat);
				}
			}
		}
	}

	public void capNhatLaiDuLieuTrongBang() {
		int from = (SIZE * (page - 1) + 1);
		int to = page * SIZE;
		String timKiem = txtTimKiem.getText();
		String field = cboTimKiem.getSelectedItem().toString();

		if (bangLuaChon == 0) {
			maxPage = nhanVienHanhChinhDao.getMaxPageTimKiemNVHanhChinh(timKiem, field, SIZE);
			nhanVienHanhChinhs = nhanVienHanhChinhDao.timKiemNhanVienHanhChinh(timKiem, from, to, field);

			xoaDuLieuTrongBangNVHanhChinh();
			themNVHanhChinhsVaoBang();
			txtTrang.setText(this.page + "");

		} else {
			maxPage = nhanVienKiThuatDao.getMaxPageTimKiemNVKiThuat(timKiem, field, SIZE);
			nhanVienKiThuats = nhanVienKiThuatDao.timKiemNhanVienKiThuats(timKiem, from, to, field);

			xoaDuLieuTrongBangNVKiThuat();
			themNVKiThuatsVaoBang();
			txtTrang.setText(this.page + "");

		}

	}

	private void themNhanVienHanhChinhVaoBang(NhanVienHanhChinh nhanVienHanhChinh) {
		Object[] object = new Object[5];
		object[0] = tblNvHanhChinh.getRowCount() + 1;
		object[1] = nhanVienHanhChinh.getMaNVHanhChinh();
		object[2] = nhanVienHanhChinh.getHoTenNV();
		object[3] = nhanVienHanhChinh.getChucVu();
		object[4] = nhanVienHanhChinh.getSoDienThoai();
		modelNVHanhChinh.addRow(object);
	}

	private void themNhanVienKiThuatVaoBang(NhanVienKiThuat nhanVienKiThuat) {
		Object[] object = new Object[5];
		object[0] = tblNVKyThuat.getRowCount() + 1;
		object[1] = nhanVienKiThuat.getMaNVKiThuat();
		object[2] = nhanVienKiThuat.getHoTen();
		object[3] = nhanVienKiThuat.getSoNamKinhNghiem();
		object[4] = nhanVienKiThuat.getBacTho();
		modelNVKyThuat.addRow(object);
	}

	private void xoaDuLieuTrongBangNVHanhChinh() {
		while (modelNVHanhChinh.getRowCount() > 0) {
			modelNVHanhChinh.removeRow(0);
		}

	}

	private void xoaDuLieuTrongBangNVKiThuat() {
		while (modelNVKyThuat.getRowCount() > 0) {
			modelNVKyThuat.removeRow(0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.field = cboTimKiem.getSelectedItem().toString();
		page = 1;
		capNhatLaiDuLieuTrongBang();

	}
}
