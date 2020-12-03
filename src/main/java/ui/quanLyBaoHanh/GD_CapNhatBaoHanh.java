package ui.quanLyBaoHanh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.TenEntity;
import dao.DanhMucBaoHanhDao;
import dao.HopDongDao;
import dao.NhanVienKiThuatDao;
import dao.PhieuBaoHanhDao;
import entity.ChiTietBaoHanh;
import entity.DanhMucBaoHanh;
import entity.HopDong;
import entity.NhanVienKiThuat;
import entity.PhieuBaoHanh;
import other.RandomMa;
import other.XuLyThoiGian;
import ui.App;

public class GD_CapNhatBaoHanh extends JPanel implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnLuu;
	private JButton btnQuayLai;
	private JButton btnXoaMucBH;
	private JButton btnThemMucBH;

	private DefaultTableModel modelBaoHanh;
	
	private JTable tblBaoHanh;

	private JLabel lblMaHopDong;
	private JLabel lblMaPhieuBaoHanh;
	private JLabel lblNgay;
	private JLabel lblMaNV;
	
	private JTextField txtTen;
	private JTextField txtMucBaoHanh;
	
	private JPanel pnlTen;
	private JPanel pnlBaoHanh;
	
	private JPopupMenu popupTenNV;
	private JPopupMenu popupMucBaoHanh;
	
	private JScrollPane scrollPaneTen;
	private JScrollPane scrollPaneBaoHanh;

	private DefaultListModel<String> defaultListModelTen;
	private DefaultListModel<String> defaultListModelBaoHanh;

	private NhanVienKiThuatDao nhanVienKiThuatDao;
	private DanhMucBaoHanhDao danhMucBaoHanhDao;
	private PhieuBaoHanhDao phieuBaoHanhDao;

	private List<NhanVienKiThuat> nhanVienKiThuats;
	private List<DanhMucBaoHanh> danhMucBaoHanhs;
	
	private JList<String> listBaoHanh;
	private JList<String> listTen;

	

	/**
	 * Create the panel.
	 */
	public GD_CapNhatBaoHanh(String maHopDong, String dot) {
		HopDong hopDong = HopDongDao.getInstance().getHopDongTheoMa(maHopDong);

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblDot = new JLabel("Phiếu bảo hành đợt " + dot);
		lblDot.setHorizontalAlignment(SwingConstants.CENTER);
		lblDot.setForeground(Color.WHITE);
		lblDot.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDot.setBounds(0, 0, 1450, 50);
		panel.add(lblDot);

		JScrollPane scrollpaneBaoHanh = new JScrollPane();
		scrollpaneBaoHanh.setBounds(29, 292, 1385, 379);
		add(scrollpaneBaoHanh);

		JLabel lblDanhSach = new JLabel("Danh mục bảo hành");
		lblDanhSach.setForeground(new Color(58, 181, 74));
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSach.setBounds(29, 241, 225, 30);
		add(lblDanhSach);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 278, 1385, 11);
		add(separator);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(
				new ImageIcon(GD_CapNhatBaoHanh.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLuu.setBackground(new Color(58, 181, 74));
		btnLuu.setBounds(1204, 747, 203, 40);
		add(btnLuu);

		String[] colHeaderBaoHanh = { "STT", "Danh mục bảo hành", "Vệ sinh", "Thay thế" };
		modelBaoHanh = new DefaultTableModel(new Object[][] {}, colHeaderBaoHanh) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Object.class, Object.class, Boolean.class, Boolean.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tblBaoHanh = new JTable(modelBaoHanh);
		tblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblBaoHanh.setRowHeight(40);
		scrollpaneBaoHanh.setViewportView(tblBaoHanh);

		tblBaoHanh.getColumnModel().getColumn(0).setPreferredWidth(85);
		tblBaoHanh.getColumnModel().getColumn(1).setPreferredWidth(900);
		tblBaoHanh.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblBaoHanh.getColumnModel().getColumn(3).setPreferredWidth(200);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		tblBaoHanh.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblBaoHanh.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblBaoHanh.getTableHeader();
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

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setIcon(new ImageIcon(GD_CapNhatBaoHanh.class.getResource("/img/baseline_close_white_24dp.png")));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setBounds(29, 747, 164, 40);
		add(btnQuayLai);

		JLabel lblMPBH = new JLabel("Mã phiếu bảo hành:");
		lblMPBH.setForeground(Color.BLACK);
		lblMPBH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMPBH.setBounds(29, 77, 188, 30);
		add(lblMPBH);

		lblMaPhieuBaoHanh = new JLabel(RandomMa.getMaNgauNhien(TenEntity.PHIEU_BAO_HANH));
		lblMaPhieuBaoHanh.setForeground(Color.BLACK);
		lblMaPhieuBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaPhieuBaoHanh.setBounds(266, 77, 111, 30);
		add(lblMaPhieuBaoHanh);

		JLabel lblMHD = new JLabel("Mã hợp đồng:");
		lblMHD.setForeground(Color.BLACK);
		lblMHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMHD.setBounds(543, 77, 188, 30);
		add(lblMHD);

		lblMaHopDong = new JLabel(maHopDong);
		lblMaHopDong.setForeground(Color.BLACK);
		lblMaHopDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaHopDong.setBounds(772, 77, 111, 30);
		add(lblMaHopDong);

		JLabel lblNLHD = new JLabel("Ngày lập phiếu:");
		lblNLHD.setForeground(Color.BLACK);
		lblNLHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNLHD.setBounds(1085, 77, 158, 30);
		add(lblNLHD);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		lblNgay = new JLabel(simpleDateFormat.format(Calendar.getInstance().getTime()));
		lblNgay.setForeground(Color.BLACK);
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(1258, 77, 111, 30);
		add(lblNgay);

		JLabel lblTnKhchHng = new JLabel("Mã khách hàng:");
		lblTnKhchHng.setForeground(Color.BLACK);
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng.setBounds(29, 163, 164, 30);
		add(lblTnKhchHng);

		JLabel lblMaKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getMaKhachHang());
		lblMaKhachHang.setForeground(Color.BLACK);
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaKhachHang.setBounds(266, 163, 180, 30);
		add(lblMaKhachHang);

		JLabel lblTnKhchHng_1 = new JLabel("Tên khách hàng:");
		lblTnKhchHng_1.setForeground(Color.BLACK);
		lblTnKhchHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1.setBounds(543, 163, 164, 30);
		add(lblTnKhchHng_1);

		JLabel lblTenKhachHang = new JLabel(hopDong.getHoaDon().getKhachHang().getHoTenKH());
		lblTenKhachHang.setForeground(Color.BLACK);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhachHang.setBounds(772, 163, 358, 30);
		add(lblTenKhachHang);

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(Color.BLACK);
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSinThoi.setBounds(1085, 163, 127, 30);
		add(lblSinThoi);

		JLabel lblSoDienThoai = new JLabel(hopDong.getHoaDon().getKhachHang().getSoDienThoai());
		lblSoDienThoai.setForeground(Color.BLACK);
		lblSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(1258, 163, 127, 30);
		add(lblSoDienThoai);

		JLabel lblMXe = new JLabel("Mã xe:");
		lblMXe.setForeground(Color.BLACK);
		lblMXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMXe.setBounds(29, 204, 86, 30);
		add(lblMXe);

		JLabel lblMaXe = new JLabel(hopDong.getXeMay().getMaXeMay());
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaXe.setBounds(182, 204, 127, 30);
		add(lblMaXe);

		JLabel lblTnKhchHng_1_1 = new JLabel("Tên xe:");
		lblTnKhchHng_1_1.setForeground(Color.BLACK);
		lblTnKhchHng_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnKhchHng_1_1.setBounds(543, 206, 86, 30);
		add(lblTnKhchHng_1_1);

		JLabel lblTenXe = new JLabel(hopDong.getXeMay().getTenXeMay());
		lblTenXe.setForeground(Color.BLACK);
		lblTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenXe.setBounds(641, 206, 446, 30);
		add(lblTenXe);

		JLabel lblHng_1 = new JLabel("Hãng:");
		lblHng_1.setForeground(Color.BLACK);
		lblHng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHng_1.setBounds(1085, 206, 100, 30);
		add(lblHng_1);

		JLabel lblHonda = new JLabel(hopDong.getXeMay().getDongXe().getHangXe().getTenHangXe());
		lblHonda.setForeground(Color.BLACK);
		lblHonda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHonda.setBounds(1204, 206, 127, 30);
		add(lblHonda);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên kỹ thuật:");
		lblMNhnVin.setForeground(Color.BLACK);
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMNhnVin.setBounds(29, 120, 231, 30);
		add(lblMNhnVin);

		lblMaNV = new JLabel("");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(266, 120, 200, 30);
		add(lblMaNV);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên kỹ thuật:");
		lblTnNhnVin.setForeground(Color.BLACK);
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnNhnVin.setBounds(543, 120, 217, 30);
		add(lblTnNhnVin);

		JLabel lblThngTinBo = new JLabel("Thông tin bảo hành:");
		lblThngTinBo.setForeground(new Color(58, 181, 74));
		lblThngTinBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinBo.setBounds(31, 694, 188, 35);
		add(lblThngTinBo);

		btnThemMucBH = new JButton("Thêm");
		btnThemMucBH.setIcon(new ImageIcon(GD_CapNhatBaoHanh.class.getResource("/img/add_property_30px.png")));
		btnThemMucBH.setForeground(Color.WHITE);
		btnThemMucBH.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThemMucBH.setBackground(new Color(58, 181, 74));
		btnThemMucBH.setBounds(631, 694, 141, 35);
		add(btnThemMucBH);

		btnXoaMucBH = new JButton("Xóa");
		btnXoaMucBH.setIcon(new ImageIcon(GD_CapNhatBaoHanh.class.getResource("/img/delete_file_30px.png")));
		btnXoaMucBH.setForeground(Color.WHITE);
		btnXoaMucBH.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaMucBH.setBackground(Color.RED);
		btnXoaMucBH.setBounds(805, 694, 141, 35);
		add(btnXoaMucBH);

//		Tìm kiếm nhân viên theo tên
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setBounds(772, 120, 315, 30);
		add(txtTen);
		txtTen.setColumns(10);

		pnlTen = new JPanel();
		pnlTen.setBounds(1085, 150, 400, 200);
		pnlTen.setLayout(null);

		popupTenNV = new JPopupMenu();
		popupTenNV.setFocusable(false);
		popupTenNV.add(pnlTen);
		addPopup(txtTen, popupTenNV);

		scrollPaneTen = new JScrollPane();
		scrollPaneTen.setBounds(0, 0, pnlTen.getWidth(), pnlTen.getHeight());
		pnlTen.add(scrollPaneTen);

		listTen = new JList<String>();
		listTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defaultListModelTen = new DefaultListModel<String>();

		listTen.setModel(defaultListModelTen);

		scrollPaneTen.add(listTen);

//		Tìm kiếm mục bảo hành
		txtMucBaoHanh = new JTextField();
		txtMucBaoHanh.setText((String) null);
		txtMucBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMucBaoHanh.setColumns(10);
		txtMucBaoHanh.setBounds(229, 694, 373, 35);
		add(txtMucBaoHanh);

		pnlBaoHanh = new JPanel();
		pnlBaoHanh.setBounds(229, 487, 371, 205);
		pnlBaoHanh.setLayout(null);

		popupMucBaoHanh = new JPopupMenu();
		addPopup(txtMucBaoHanh, popupMucBaoHanh);
		popupMucBaoHanh.setFocusable(false);
		popupMucBaoHanh.add(pnlBaoHanh);

		scrollPaneBaoHanh = new JScrollPane();
		scrollPaneBaoHanh.setBounds(0, 0, pnlBaoHanh.getWidth(), pnlBaoHanh.getHeight());
		pnlBaoHanh.add(scrollPaneBaoHanh);

		listBaoHanh = new JList<String>();
		listBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defaultListModelBaoHanh = new DefaultListModel<String>();
		listBaoHanh.setModel(defaultListModelBaoHanh);
		scrollPaneBaoHanh.add(listBaoHanh);

		dangKiSuKien();
		khoiTao();

		nhanVienKiThuats = nhanVienKiThuatDao.getNVKiThuat();
		danhMucBaoHanhs = danhMucBaoHanhDao.getDanhMucBaoHanhs();
		docDulieuNVKiThuat();
		docDulieuMucBaoHanh();
		txtTen.setText(nhanVienKiThuats.get(0).getHoTen().trim());
		lblMaNV.setText(nhanVienKiThuats.get(0).getMaNVKiThuat().trim());
		txtMucBaoHanh.setText(danhMucBaoHanhs.get(0).getTenDanhMucBaoHanh().trim());

	}

	/**
	 * Khởi tạo DAO
	 */
	private void khoiTao() {
		danhMucBaoHanhDao = DanhMucBaoHanhDao.getInstance();
		nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();
		phieuBaoHanhDao = PhieuBaoHanhDao.getInstance();
	}

	/**
	 * Đưa dữ liệu từ database vào Jlist nhân viên kỹ thuật
	 */
	private void docDulieuNVKiThuat() {
		defaultListModelTen.removeAllElements();
		nhanVienKiThuats.forEach(v -> {
			defaultListModelTen.addElement(v.getHoTen() + " - " + v.getMaNVKiThuat());
		});
	}

	/**
	 * Đưa dữ liệu từ database vào Jlist bảo hành
	 */
	private void docDulieuMucBaoHanh() {
		defaultListModelBaoHanh.removeAllElements();
		int n = modelBaoHanh.getRowCount();
		List<String> listMucBH = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			listMucBH.add(tblBaoHanh.getValueAt(i, 1).toString().trim());
		}
		danhMucBaoHanhs.forEach(v -> {
			String temp = v.getTenDanhMucBaoHanh().trim();
			if (!listMucBH.contains(temp)) {
				defaultListModelBaoHanh.addElement(temp);
			}
		});

	}

	/**
	 * Thêm mục bảo hành vào bảng
	 */
	private void themMucBaoHanhVaoBang() {
		String temp = txtMucBaoHanh.getText().trim();
		if (!temp.equals("")) {
			DanhMucBaoHanh danhMucBaoHanh = danhMucBaoHanhDao.getDanhMucBaoHanhTheoTen(temp);

			Object[] datas = new Object[4];
			datas[0] = tblBaoHanh.getRowCount() + 1;
			datas[1] = danhMucBaoHanh.getTenDanhMucBaoHanh();
			datas[2] = true;
			datas[3] = false;
			modelBaoHanh.addRow(datas);

			docDulieuMucBaoHanh();

			if (defaultListModelBaoHanh.size() > 0) {
				txtMucBaoHanh.setText(defaultListModelBaoHanh.getElementAt(0));
			} else {
				txtMucBaoHanh.setText("");
			}

		} else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn mục bảo hành để thêm");
		}
	}

	/**
	 * Xóa mục bảo hành trong bảng
	 */
	private void xoaMucBaoHanh() {

		int[] rows = tblBaoHanh.getSelectedRows();
		int len = rows.length;

		if (len > 0) {
			int del = 1;
			for (int i = 0; i < len; i++) {
				modelBaoHanh.removeRow(rows[i]);
				if (i < len - 1) {
					rows[i + 1] = rows[i + 1] - del;
					del = del + 1;
				}
			}
			docDulieuMucBaoHanh();
			int countRow = tblBaoHanh.getRowCount();
			for (int i = 0; i < countRow; i++) {
				tblBaoHanh.setValueAt(i + 1, i, 0);
			}
		}

		else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xóa");
		}
	}

	/**
	 * Thêm phiếu bảo hành
	 */
	private void themPhieuBaoHanh() {

		PhieuBaoHanh phieuBaoHanh = new PhieuBaoHanh(lblMaPhieuBaoHanh.getText().trim(),
				new HopDong(lblMaHopDong.getText().trim()),
				XuLyThoiGian.chuyenStringThanhDate(lblNgay.getText().trim()),
				new NhanVienKiThuat(lblMaNV.getText().trim()));

		int count = tblBaoHanh.getRowCount();
		if (count >= 5) {
			for (int i = 0; i < count; i++) {
				String tenMucBH = tblBaoHanh.getValueAt(i, 1).toString().trim();
				ChiTietBaoHanh chiTietBaoHanh = new ChiTietBaoHanh(new PhieuBaoHanh(lblMaPhieuBaoHanh.getText().trim()),
						danhMucBaoHanhDao.getDanhMucBaoHanhTheoTen(tenMucBH),
						Boolean.valueOf(tblBaoHanh.getValueAt(i, 2).toString()));
				phieuBaoHanh.themChiTietBaoHanh(chiTietBaoHanh);
			}

			if (phieuBaoHanhDao.themPhieuBaoHanh(phieuBaoHanh)) {
				JOptionPane.showMessageDialog(this, "Đã lưu");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chi tiết bảo hành phải có ít nhất 5 mục");
		}
	}

	/**
	 * thoát
	 */
	private void thoat() {
		if (phieuBaoHanhDao.getPhieuBaoHanhTheoMa(lblMaPhieuBaoHanh.getText().trim()) == null) {
			if (tblBaoHanh.getRowCount() >= 5) {
				int tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu phiếu bảo hành không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					themPhieuBaoHanh();
					setManHinh();
				} else {
					setManHinh();
				}
			} else {
				setManHinh();
			}
		} else {
			setManHinh();
		}
	}

	/**
	 * chuyển panel
	 */
	private void setManHinh() {
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(new GD_BaoHanh(lblMaHopDong.getText().trim()));
		this.validate();
		this.repaint();
	}

	/**
	 * Đăng ký sự kiện
	 */
	private void dangKiSuKien() {
		btnLuu.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnThemMucBH.addActionListener(this);
		btnXoaMucBH.addActionListener(this);

		tblBaoHanh.addMouseListener(this);
		listTen.addMouseListener(this);
		listBaoHanh.addMouseListener(this);
		txtTen.addMouseListener(this);
		
		txtTen.addKeyListener(this);
		txtMucBaoHanh.addKeyListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuayLai)) {
			thoat();
		}
		if (o.equals(btnThemMucBH)) {
			themMucBaoHanhVaoBang();
		}
		if (o.equals(btnXoaMucBH)) {
			xoaMucBaoHanh();
		}
		if (o.equals(btnLuu)) {
			themPhieuBaoHanh();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tblBaoHanh)) {
			int row = tblBaoHanh.getSelectedRow();
			int column = tblBaoHanh.getSelectedColumn();
			boolean c2 = Boolean.valueOf(modelBaoHanh.getValueAt(row, 2).toString());
			boolean c3 = Boolean.valueOf(modelBaoHanh.getValueAt(row, 3).toString());

			if (column == 2) {
				if (c2 && c3) {
					modelBaoHanh.setValueAt(false, row, 3);
				} else if (!c2 && !c3) {
					modelBaoHanh.setValueAt(true, row, 2);
				}
			}
			if (column == 3) {
				if (c3 && c2) {
					modelBaoHanh.setValueAt(false, row, 2);
				} else if (!c3 && !c2) {
					modelBaoHanh.setValueAt(true, row, 3);
				}
			}
		}

		if (o.equals(listTen)) {
			String[] temp = listTen.getSelectedValue().split("-");
			txtTen.setText(temp[0]);
			lblMaNV.setText(temp[1]);
		}

		if (o.equals(listBaoHanh)) {
			txtMucBaoHanh.setText(listBaoHanh.getSelectedValue());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(txtTen)) {
			nhanVienKiThuats = nhanVienKiThuatDao.getNVKiThuatTheoTens(txtTen.getText().trim());
			docDulieuNVKiThuat();
			popupTenNV.show(txtTen, 0, txtTen.getHeight());
			scrollPaneTen.setViewportView(listTen);
		}
		if (o.equals(txtMucBaoHanh)) {
			danhMucBaoHanhs = danhMucBaoHanhDao.getDanhMucBaoHanhTheoTens(txtMucBaoHanh.getText().trim());
			docDulieuMucBaoHanh();
			popupMucBaoHanh.show(txtMucBaoHanh, 0, txtMucBaoHanh.getHeight());
			scrollPaneBaoHanh.setViewportView(listBaoHanh);
		}
	}

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
