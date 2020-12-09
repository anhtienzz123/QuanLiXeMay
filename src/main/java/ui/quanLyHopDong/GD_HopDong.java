package ui.quanLyHopDong;

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
import java.text.SimpleDateFormat;
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

import dao.HopDongDao;
import entity.HopDong;
import ui.App;

public class GD_HopDong extends JPanel implements ActionListener, MouseListener,KeyListener {
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
	private DefaultTableModel modelHopDong;
	private JTable tblHopDong;
	private JButton btnXemChiTiet;
	private int page = 1;
	private int maxPage = 0;
	private JComboBox<String> cboTimKiem;
	private static final int SIZE = 15;
	private HopDongDao hopDongDao;
	private List<HopDong> hopDongs;
	private LocalDate date;
	private JDateChooser txtNgay;
	private JButton btnBoLoc;

	/**
	 * Create the panel.
	 */
	public GD_HopDong() {

		hopDongDao = HopDongDao.getInstance();
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý hợp đồng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPaneHopDong = new JScrollPane();
		scrollPaneHopDong.setBounds(29, 213, 1736, 557);
		add(scrollPaneHopDong);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet
				.setIcon(new ImageIcon(GD_HopDong.class.getResource("/icon/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(1547, 805, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 83, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] {"Mã hợp đồng", "Mã hóa đơn", "Mã nhân viên", "Tên nhân viên lập", "Tên khách hàng", "Số điện thoại"}));
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
		separator.setBounds(29, 176, 1736, 11);
		add(separator);

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_HopDong.class.getResource("/icon/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(29, 805, 50, 40);
		add(btnDau);

		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_HopDong.class.getResource("/icon/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(102, 805, 50, 40);
		add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_HopDong.class.getResource("/icon/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(264, 805, 50, 40);
		add(btnSau);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_HopDong.class.getResource("/icon/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(342, 805, 50, 40);
		add(btnCuoi);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setColumns(10);
		txtTrang.setBounds(178, 806, 60, 40);
		add(txtTrang);

		String[] colHeaderHopDong = { "STT","Mã hợp đồng","Mã hóa đơn", "Mã nhân viên", "Tên nhân viên", "Tên khách hàng",
				"Số điện thoại KH", "ngày lập hóa đơn" };
		modelHopDong = new DefaultTableModel(colHeaderHopDong, 0);
		tblHopDong = new JTable(modelHopDong) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHopDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHopDong.setRowHeight(35);
		tblHopDong.getColumnModel().getColumn(0).setPreferredWidth(136);
		tblHopDong.getColumnModel().getColumn(1).setPreferredWidth(160);
		tblHopDong.getColumnModel().getColumn(2).setPreferredWidth(160);
		tblHopDong.getColumnModel().getColumn(3).setPreferredWidth(160);
		tblHopDong.getColumnModel().getColumn(4).setPreferredWidth(400);
		tblHopDong.getColumnModel().getColumn(5).setPreferredWidth(160);
		tblHopDong.getColumnModel().getColumn(6).setPreferredWidth(400);
		tblHopDong.getColumnModel().getColumn(7).setPreferredWidth(160);

//		center value in column
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tblHopDong.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tblHopDong.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		tblHopDong.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		tblHopDong.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		tblHopDong.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		tblHopDong.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
		scrollPaneHopDong.setViewportView(tblHopDong);

		JLabel lblTngThuTrong_1_1 = new JLabel("Ngày lập hợp đồng:");
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
				new ImageIcon(new ImageIcon(App.class.getResource("/icon/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1800, 133);
		pnlLogo.add(lblLogo);
		
		btnBoLoc = new JButton("Xóa tìm kiếm");
		btnBoLoc.setIcon(new ImageIcon(GD_HopDong.class.getResource("/icon/baseline_clear_all_white_18dp.png")));
		btnBoLoc.setForeground(Color.WHITE);
		btnBoLoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBoLoc.setBackground(Color.GRAY);
		btnBoLoc.setBounds(1547, 81, 218, 35);
		add(btnBoLoc);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblHopDong.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 21; i++) {
			modelHopDong.addRow(new Object[] { i, null, null, null });
		}
		dangKiSuKien();
		capNhatDuLieuTrongBangHopDong();

	}

	private void dangKiSuKien() {
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnTruoc.addActionListener(this);
		txtTimKiem.addKeyListener(this);
		txtNgay.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("date")) {
					date = txtNgay.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					capNhatDuLieuTrongBangHopDong();
				}

			}
		});

	}

	public void capNhatDuLieuTrongBangHopDong() {

		int from = (SIZE * (page - 1) + 1);
		int to = page * SIZE;
		String timKiem = txtTimKiem.getText();
		String field = cboTimKiem.getSelectedItem().toString();
		maxPage = hopDongDao.getMaxPageTimKiemHopDong(timKiem, field, date, SIZE);
		hopDongs = hopDongDao.timKiemHopDongs(timKiem, from, to, date, field);
		xoaDuLieuTrongBang();
		themHopDongsVaoBang();
		txtTrang.setText(this.page + "");

	}

	private void xoaDuLieuTrongBang() {
		while (modelHopDong.getRowCount() > 0) {
			modelHopDong.removeRow(0);
		}

	}

	private void themHopDongsVaoBang() {
		if (hopDongs != null) {
			for (HopDong hopDong : hopDongs) {
				themHopDonggVaoBang(hopDong);
			}
		}
	}

	private void themHopDonggVaoBang(HopDong hopDong) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Object[] object = new Object[8];
		object[0] = tblHopDong.getRowCount() + 1;
		object[1] = hopDong.getMaHopDong();
		object[2] = hopDong.getHoaDon().getMaHoaDon();
		object[3] = hopDong.getHoaDon().getNhanVienHanhChinh().getMaNVHanhChinh();
		object[4] = hopDong.getHoaDon().getNhanVienHanhChinh().getHoTenNV();
		object[5] = hopDong.getHoaDon().getKhachHang().getHoTenKH();
		object[6] = hopDong.getHoaDon().getKhachHang().getSoDienThoai();
		object[7] = simpleDateFormat.format(hopDong.getHoaDon().getNgayLap());

		modelHopDong.addRow(object);

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
			try {
				int row = tblHopDong.getSelectedRow();
				new GD_ChiTietHD(modelHopDong.getValueAt(row, 1).toString()).setVisible(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Chọn vào hợp đồng muốn xem");
			}
		}

		if (o == btnDau) {
			this.page = 1;
			capNhatDuLieuTrongBangHopDong();
		}

		if (o == btnCuoi) {
			this.page = maxPage;
			capNhatDuLieuTrongBangHopDong();
		}

		if (o == btnSau && page < maxPage) {
			this.page++;
			capNhatDuLieuTrongBangHopDong();

		}

		if (o == btnTruoc && page > 1) {
			this.page--;
			capNhatDuLieuTrongBangHopDong();
		}

		if (o == cboTimKiem) {
			txtTimKiem.setText("");
			this.page = 1;
			capNhatDuLieuTrongBangHopDong();
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
		this.page = 1;
		capNhatDuLieuTrongBangHopDong();
		
	}
}
