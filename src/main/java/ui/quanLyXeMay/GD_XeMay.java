package ui.quanLyXeMay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GD_XeMay extends JPanel implements ActionListener, MouseListener{
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

	/**
	 * Create the panel.
	 */
	public GD_XeMay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JScrollPane scrollPaneXeMay = new JScrollPane();
		scrollPaneXeMay.setBounds(33, 272, 1385, 582);
		add(scrollPaneXeMay);

		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXemChiTiet.setBounds(641, 883, 218, 40);
		add(btnXemChiTiet);

		JLabel lblTngThuTrong_1 = new JLabel("Tìm kiếm:");
		lblTngThuTrong_1.setBounds(33, 83, 103, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Tên xe", "Mã xe" }));
		cboTimKiem.setBounds(151, 83, 120, 30);
		add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setBounds(302, 83, 311, 30);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel lblTngThuTrong_1_1 = new JLabel("Hãng:");
		lblTngThuTrong_1_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1.setBounds(676, 83, 83, 30);
		add(lblTngThuTrong_1_1);

		JComboBox cboHangXe = new JComboBox();
		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setBounds(771, 83, 245, 30);
		add(cboHangXe);
		
		JPopupMenu popupHang = new JPopupMenu();
		addPopup(cboHangXe, popupHang);
		
		 mntmHang = new JMenuItem("Quản lý hãng xe");
		mntmHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popupHang.add(mntmHang);

		JLabel lblTngThuTrong_1_1_1 = new JLabel("Loại xe:");
		lblTngThuTrong_1_1_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_1.setBounds(1071, 83, 83, 30);
		add(lblTngThuTrong_1_1_1);

		JComboBox cboLoaiXe = new JComboBox();
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(1173, 83, 245, 30);
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

		JComboBox cboDongXe = new JComboBox();
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(151, 142, 265, 30);
		add(cboDongXe);
		
		JPopupMenu popupDongXe = new JPopupMenu();
		addPopup(cboDongXe, popupDongXe);
		
		 mntmDongXe = new JMenuItem("Quản lý dòng xe");
		mntmDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		popupDongXe.add(mntmDongXe);

		JLabel lblTngThuTrong_1_1_2_1 = new JLabel("Xuất xứ:");
		lblTngThuTrong_1_1_2_1.setForeground(Color.BLACK);
		lblTngThuTrong_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTngThuTrong_1_1_2_1.setBounds(665, 142, 83, 30);
		add(lblTngThuTrong_1_1_2_1);

		JComboBox cboXuatXu = new JComboBox();
		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setBackground(Color.WHITE);
		cboXuatXu.setBounds(772, 142, 244, 30);
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
		separator.setBounds(33, 248, 1385, 11);
		add(separator);
		
		 btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setForeground(Color.WHITE);
		btnDau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDau.setBackground(Color.GRAY);
		btnDau.setBounds(33, 883, 50, 40);
		add(btnDau);
		
		  btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setForeground(Color.WHITE);
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTruoc.setBackground(Color.GRAY);
		btnTruoc.setBounds(106, 883, 50, 40);
		add(btnTruoc);
		
		  btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setForeground(Color.WHITE);
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSau.setBackground(Color.GRAY);
		btnSau.setBounds(268, 883, 50, 40);
		add(btnSau);
		
		  btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setForeground(Color.WHITE);
		btnCuoi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCuoi.setBackground(Color.GRAY);
		btnCuoi.setBounds(346, 883, 50, 40);
		add(btnCuoi);
		
		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setColumns(10);
		txtTrang.setBounds(182, 884, 60, 40);
		add(txtTrang);
		
		 btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1258, 883, 160, 40);
		add(btnThem);
		
		 btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_construction_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 102, 255));
		btnSua.setBounds(1071, 883, 160, 40);
		add(btnSua);
		
		 btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_XeMay.class.getResource("/img/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(886, 883, 160, 40);
		add(btnXoa);
		
		String[] colHeaderXeMay = { "STT", "Mã xe", "Tên xe", "hãng", "Màu sắc", "Số lượng", "Giá Bán", "Bảo hành" };
		modelXe = new DefaultTableModel(colHeaderXeMay, 0);
		tblXeMay = new JTable(modelXe) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblXeMay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblXeMay.setRowHeight(25);
		scrollPaneXeMay.setViewportView(tblXeMay);
		JTableHeader tableHeader2 = tblXeMay.getTableHeader();
		tableHeader2.setBackground(new Color(58, 181, 74));
		tableHeader2.setForeground(Color.white);
		tableHeader2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for(int i = 1; i<23; i++) {
			modelXe.addRow(new Object[] { i, null, null, null });
		}
				
		dangKiSuKien();

	}
	
	

	private void dangKiSuKien() {
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnXoa.addActionListener(this);
		mntmDongXe.addActionListener(this);
		mntmHang.addActionListener(this);
		mntmLoaiXe.addActionListener(this);
		mntmXuatXu.addActionListener(this);
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
	public void setManHinh(JPanel newPanel) {
		this.removeAll();
		this.setLayout(new BorderLayout());
		this.add(newPanel);
		this.validate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			setManHinh(new GD_ThemXeMay());
			
		}
		if (o.equals(btnSua)) {
			setManHinh(new GD_CapNhatXeMay());
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
