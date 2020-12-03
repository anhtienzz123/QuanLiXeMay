package ui.quanLyHoaDon;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import constant.HoaDonConstant;
import dao.HoaDonDao;
import entity.HoaDon;
import other.XuLyThoiGian;
import ui.App;

public class GD_HoaDon extends JPanel implements ActionListener, MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JTextField txtTimKiem;
	private JTextField txtTrang;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnLapHoaDon;
	private DefaultTableModel modelHoaDon;
	private JTable tblHoaDon;
	private JButton btnXemChiTiet;

	private JComboBox<String> cboTimKiem;

	private JDateChooser txtNgay;
	private LocalDate date;
	private int page = 1;
	private int maxPage = 2;
	private static final int SIZE = 16;
	private HoaDonDao hoaDonDao;
	private List<HoaDon> hoaDons;
	
	private String maNhanVienHanhChinh;

	private JButton btnBoloc;

	/**
	 * Create the panel.
	 */
	public GD_HoaDon(String maNhanVienHanhChinh) {
		this.maNhanVienHanhChinh = maNhanVienHanhChinh;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý hoá đơn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setBounds(29, 200, 1727, 575);
		add(scrollPaneHoaDon);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(1286, 809, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 83, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(
				new String[] { HoaDonConstant.MA_HOA_DON, HoaDonConstant.MA_NHAN_VIEN_LAP_HOA_DON,
						HoaDonConstant.TEN_NHAN_VIEN_LAP_HOA_DON, HoaDonConstant.MA_KHACH_HANG,
						HoaDonConstant.TEN_KHACH_HANG, HoaDonConstant.SO_DIEN_THOAI_KHACH_HANG }));
		cboTimKiem.setBounds(151, 83, 274, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(451, 83, 311, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel lblTngThuTrong_1_1_2_2 = new JLabel("Danh sách hóa đơn");
		lblTngThuTrong_1_1_2_2.setForeground(new Color(58, 181, 74));
		lblTngThuTrong_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_2.setBounds(29, 133, 175, 30);
		add(lblTngThuTrong_1_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 176, 1727, 11);
		add(separator);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(29, 809, 50, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(102, 809, 50, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(264, 809, 50, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(342, 809, 50, 40);
		add(btnCuoi);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setColumns(10);
		txtTrang.setBounds(178, 810, 60, 40);
		add(txtTrang);

		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon
				.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnLapHoaDon.setForeground(Color.WHITE);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLapHoaDon.setBackground(new Color(58, 181, 74));
		btnLapHoaDon.setBounds(1553, 809, 203, 40);
		add(btnLapHoaDon);

		String[] colHeaderXeMay = { "STT", "Mã hóa đơn", "Mã nhân viên", "Tên nhân viên", "Tên khách hàng",
				"SĐT khách hàng", "ngày lập hóa đơn" };
		modelHoaDon = new DefaultTableModel(colHeaderXeMay, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(35);
		tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(74);
		tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(200);
		tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(475);
		tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(475);
		tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(200);
		tblHoaDon.getColumnModel().getColumn(6).setPreferredWidth(200);
		scrollPaneHoaDon.setViewportView(tblHoaDon);
		

//		center value in column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tblHoaDon.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tblHoaDon.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tblHoaDon.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		tblHoaDon.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		tblHoaDon.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
//		tblHoaDon.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );

		JLabel lblTngThuTrong_1_1 = new JLabel("Ngày lập hóa đơn:");
		lblTngThuTrong_1_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1.setBounds(886, 83, 175, 30);
		add(lblTngThuTrong_1_1);

		txtNgay = new JDateChooser();
		txtNgay.setBounds(1073, 83, 189, 30);
		txtNgay.setForeground(new Color(58, 181, 74));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setDate(Calendar.getInstance().getTime());
		add(txtNgay);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 877, 1800, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1800, 133);
		pnlLogo.add(lblLogo);
		
		 btnBoloc = new JButton("Xóa tìm kiếm");
		 btnBoloc.setIcon(new ImageIcon(GD_HoaDon.class.getResource("/img/baseline_clear_all_white_18dp.png")));
		btnBoloc.setToolTipText("Xóa tìm kiếm\r\n");
		btnBoloc.setForeground(Color.WHITE);
		btnBoloc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBoloc.setBackground(Color.GRAY);
		btnBoloc.setBounds(1538, 81, 218, 35);
		add(btnBoloc);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblHoaDon.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		khoiTao();
		dangKiSuKien();
		capNhatHoaDonsTrongBang();

	}

	private void dangKiSuKien() {
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnLapHoaDon.addActionListener(this);
		btnTruoc.addActionListener(this);
		tblHoaDon.addMouseListener(this);
		
		btnBoloc.addActionListener(this);
		
		cboTimKiem.addActionListener(this);
		txtTimKiem.addKeyListener(this);
		txtNgay.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("date")) {
					date = txtNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    capNhatHoaDonsTrongBang();
				}

			}
		});

	}

	private void khoiTao() {
		hoaDonDao = HoaDonDao.getInstance();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btnLapHoaDon)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_LapHoaDon(this.maNhanVienHanhChinh));
			this.validate();
			this.repaint();
		}
		if (source.equals(btnXemChiTiet)) {
			int row = tblHoaDon.getSelectedRow();
			if(row >= 0) {
				String maHoaDon= hoaDons.get(row).getMaHoaDon();
				new GD_ChiTietHoaDon(maHoaDon).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn để xem");
			}
		}

		if (source == btnDau) {
			this.page = 1;
			capNhatHoaDonsTrongBang();
		}

		if (source == btnCuoi) {
			this.page = maxPage;
			capNhatHoaDonsTrongBang();
		}

		if (source == btnSau && page < maxPage) {
			this.page++;
			capNhatHoaDonsTrongBang();

		}

		if (source == btnTruoc && page > 1) {
			this.page--;
			capNhatHoaDonsTrongBang();
		}
		
		if(source == cboTimKiem) {
			txtTimKiem.setText("");
			this.page = 1;
			capNhatHoaDonsTrongBang();
		}

	}

	private void capNhatHoaDonsTrongBang() {

		int from = (SIZE * (page - 1) + 1);
		int to = page * SIZE;
		String timKiem = txtTimKiem.getText();
		String field = cboTimKiem.getSelectedItem().toString();

		maxPage = hoaDonDao.getMaxPageTimKiemHoaDon(timKiem, field, date, SIZE);
		hoaDons = hoaDonDao.timKiemHoaDons(timKiem, field, date, from, to);

		xoaDuLieuTrongBang();
		themHoaDonsVaoBang();
		txtTrang.setText(this.page + "");

	}

	@Override
	public void keyReleased(KeyEvent e) {

		this.page = 1;
		capNhatHoaDonsTrongBang();

	}

	private void themHoaDonsVaoBang() {
		if (hoaDons != null) {
			for (HoaDon hoaDon : hoaDons) {
				themHoaDonVaoBang(hoaDon);
			}
		}
	}

	private void themHoaDonVaoBang(HoaDon hoaDon) {

		Object[] object = new Object[7];
		object[0] = tblHoaDon.getRowCount() + 1;
		object[1] = hoaDon.getMaHoaDon();
		object[2] = hoaDon.getNhanVienHanhChinh().getMaNVHanhChinh();
		object[3] = hoaDon.getNhanVienHanhChinh().getHoTenNV();
		object[4] = hoaDon.getKhachHang().getHoTenKH();
		object[5] = hoaDon.getKhachHang().getSoDienThoai();
		object[6] = XuLyThoiGian.chuyenDateThanhString(hoaDon.getNgayLap());
		modelHoaDon.addRow(object);
	}

	private void xoaDuLieuTrongBang() {
		while (modelHoaDon.getRowCount() > 0) {
			modelHoaDon.removeRow(0);
		}

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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
