package ui.quanLyThongKe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ThongKeQuanLiDao;
import other.DinhDangTien;
import ui.App;

import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GD_ThongKeNamNV extends JPanel implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDate localDate;
	private ThongKeQuanLiDao thongKeDao;

	private JLabel lblDoanhThu;

	private JButton btnThoat;
	private JTable tblHoaDon;
	private JTable tblXe;

	private DefaultTableModel modelHoaDon;

	private DefaultTableModel modelXe;

	private JButton btnChiTiet;

	private JComboBox<String> cboNam;

	/**
	 * Create the panel.
	 */
	public GD_ThongKeNamNV() {

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		JLabel lblNgay = new JLabel("Chọn năm:");
		lblNgay.setForeground(new Color(58, 181, 74));
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNgay.setBounds(27, 77, 119, 30);
		add(lblNgay);

		JLabel lblTngDoanhTh = new JLabel("Tổng doanh thu:");
		lblTngDoanhTh.setForeground(new Color(58, 181, 74));
		lblTngDoanhTh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngDoanhTh.setBounds(318, 77, 174, 30);
		add(lblTngDoanhTh);

		lblDoanhThu = new JLabel("1.200.000.000 VNĐ");
		lblDoanhThu.setForeground(new Color(0, 0, 0));
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoanhThu.setBounds(488, 77, 404, 30);
		add(lblDoanhThu);

		JLabel lblHanLp_1 = new JLabel("Hóa đơn lập");
		lblHanLp_1.setForeground(new Color(58, 181, 74));
		lblHanLp_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHanLp_1.setBounds(27, 130, 174, 30);
		add(lblHanLp_1);

		JLabel lblHanLp = new JLabel("Xe máy bán ra");
		lblHanLp.setForeground(new Color(58, 181, 74));
		lblHanLp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHanLp.setBounds(954, 130, 174, 30);
		add(lblHanLp);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(27, 166, 803, 30);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(954, 166, 820, 30);
		add(separator_1);

		JScrollPane scrollPaneHoaDon = new JScrollPane();
		scrollPaneHoaDon.setBounds(27, 194, 803, 568);
		add(scrollPaneHoaDon);

		String[] colHeaderHoaDon = { "STT", "Mã hóa đơn", "Tổng tiền hóa đơn" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(35);
		scrollPaneHoaDon.setViewportView(tblHoaDon);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader2 = tblHoaDon.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		scrollPaneHoaDon.setViewportView(tblHoaDon);

		JScrollPane scrollPaneXe = new JScrollPane();
		scrollPaneXe.setBounds(954, 194, 820, 568);
		add(scrollPaneXe);
		
		String[] colHeaderXe = { "STT", "Tên xe máy", "Số lượng bán" };
		modelXe = new DefaultTableModel(colHeaderXe, 0);
		tblXe = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXe.setRowHeight(35);
		scrollPaneXe.setViewportView(tblXe);

		/**
		 * Đổi màu header cho table
		 */
		JTableHeader tableHeader1 = tblXe.getTableHeader();
		tableHeader1.setBackground(new Color(58, 181, 74));
		tableHeader1.setForeground(Color.white);
		tableHeader1.setFont(new Font("Tahoma", Font.PLAIN, 20));


		btnThoat = new JButton("Quay lại");
		btnThoat.setIcon(new ImageIcon(GD_ThongKeNamNV.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(1625, 807, 149, 35);
		add(btnThoat);

		 btnChiTiet = new JButton("Chi tiết");
		btnChiTiet.setIcon(new ImageIcon(GD_ThongKeNamNV.class.getResource("/icon/information_30px.png")));
		btnChiTiet.setForeground(Color.WHITE);
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChiTiet.setBackground(Color.GRAY);
		btnChiTiet.setBounds(679, 807, 149, 35);
		add(btnChiTiet);
		
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
		
		 cboNam = new JComboBox<String>();
		 cboNam.setBackground(Color.WHITE);
		 cboNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboNam.setModel(new DefaultComboBoxModel<String>(new String[] {"2018", "2019", "2020"}));
		cboNam.setBounds(143, 77, 110, 30);
		add(cboNam);

		khoiTao();
		dangKiSuKien();

	}

	public void dangKiSuKien() {
		btnThoat.addActionListener(this);
		btnChiTiet.addActionListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	private void khoiTao() {
		localDate = LocalDate.now();

		thongKeDao = ThongKeQuanLiDao.getInstance();
		Double ngay = thongKeDao.getDoanhThuTheoNgay(localDate.getDayOfMonth(), localDate.getMonthValue(),
				localDate.getYear());
		Double thang = thongKeDao.getDoanhThuTheoThang(localDate.getMonthValue(), localDate.getYear());
		Double nam = thongKeDao.getDoanhThuTheoNam(localDate.getYear());
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

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_ThongKeNV());
			this.validate();
			this.repaint();
		}
	}
}
