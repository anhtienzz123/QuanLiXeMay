package ui.quanLyXeMay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.TenEntity;
import dao.DongXeDao;
import dao.HangXeDao;
import entity.DongXe;
import entity.HangXe;
import other.RandomMa;
import other.XuLyChung;
import ui.GD_DangNhap;

public class GD_DongXe extends JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblMa;
	private JButton btnXoaRong;
	private JTextField txtTen;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JLabel lblNewLabel_1_2_1;
	private JTextField txtThue;
	private JTextField txtTimKiem;
	private JComboBox<String> cboHang;
	private JComboBox<String> cboTimKiem;

	private List<DongXe> dongXes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DongXe frame = new GD_DongXe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GD_DongXe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/icon/motorbike_helmet_100px.png")));
		setTitle("Quản lý dòng xe");
		setSize(952, 661);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 939, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý dòng xe");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 937, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_2 = new JLabel("Mã dòng xe:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 65, 136, 30);
		contentPane.add(lblNewLabel_1_2);

		lblMa = new JLabel("DX123456");
		lblMa.setForeground(Color.BLACK);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(169, 65, 112, 30);
		lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.DONG_XE));
		contentPane.add(lblMa);

		JLabel lblNewLabel_1_2_5 = new JLabel("Tên dòng xe:");
		lblNewLabel_1_2_5.setForeground(Color.BLACK);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(474, 65, 136, 30);
		contentPane.add(lblNewLabel_1_2_5);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(58, 181, 74));
		separator_2.setBorder(null);
		separator_2.setBounds(23, 152, 891, 14);
		contentPane.add(separator_2);

		btnXoaRong = new JButton("Xóa trắng");
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setIcon(new ImageIcon(GD_DongXe.class.getResource("/icon/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBounds(23, 566, 191, 30);
		contentPane.add(btnXoaRong);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 213, 892, 327);
		contentPane.add(scrollPane);

		String[] colHeader = { "STT", "Mã dòng xe", "Tên dòng xe", "Hãng", "Thuế" };
		model = new DefaultTableModel(colHeader, 0);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);

		scrollPane.setViewportView(table);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setBounds(622, 65, 293, 30);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_DongXe.class.getResource("/icon/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(778, 566, 136, 30);
		contentPane.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GD_DongXe.class.getResource("/icon/baseline_construction_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(601, 566, 136, 30);
		contentPane.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_DongXe.class.getResource("/icon/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(424, 566, 136, 30);
		contentPane.add(btnXoa);

		lblNewLabel_1_2_1 = new JLabel("Hãng:");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(23, 105, 87, 30);
		contentPane.add(lblNewLabel_1_2_1);

		cboHang = new JComboBox<String>();
		cboHang.setBackground(Color.WHITE);
		cboHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHang.setBounds(169, 105, 200, 30);
		contentPane.add(cboHang);
		HangXeDao hangXeDao = HangXeDao.getInstance();
		cboHang.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArray(
				hangXeDao.getHangXes().stream().map(s -> s.getTenHangXe()).collect(Collectors.toList()))));
		cboHang.removeItem("Tất cả");
//<<<<<<< HEAD
////		cboHang.setSelectedIndex(0);
//=======
//>>>>>>> 113643b7e450a830b4df0c9418bec8a52814b224
		cboHang.setSelectedItem("Honda");

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Thuế:");
		lblNewLabel_1_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_1.setBounds(474, 105, 87, 30);
		contentPane.add(lblNewLabel_1_2_1_1);

		txtThue = new JTextField();
		txtThue.setText("2");
		txtThue.setHorizontalAlignment(SwingConstants.CENTER);
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThue.setColumns(10);
		txtThue.setBounds(622, 105, 41, 30);
		contentPane.add(txtThue);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("%");
		lblNewLabel_1_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_1_1.setBounds(667, 105, 41, 30);
		contentPane.add(lblNewLabel_1_2_1_1_1);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Tìm kiếm:");
		lblNewLabel_1_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_2.setBounds(23, 170, 136, 30);
		contentPane.add(lblNewLabel_1_2_1_2);

		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] { "Tên dòng xe", "Mã dòng xe", "Hãng" }));
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setBounds(169, 170, 147, 30);
		contentPane.add(cboTimKiem);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(315, 170, 217, 30);
		contentPane.add(txtTimKiem);

		JTableHeader tableHearder = table.getTableHeader();
		tableHearder.setBackground(new Color(58, 181, 74));
		tableHearder.setForeground(Color.white);
		tableHearder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 7; i++) {
			model.addRow(new Object[] { i, null, null });
		}

		dongXes = DongXeDao.getInstance().getDongXes();
		dangKiSuKien();
		capNhatBang();
	}

	/**
	 * Cập nhật dữ liệu trong bảng
	 */
	private void capNhatBang() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();

		if (dongXes != null) {
			for (DongXe dongXe : dongXes) {
				Object[] datas = new Object[5];
				datas[0] = table.getRowCount() + 1;
				datas[1] = dongXe.getMaDongXe();
				datas[2] = dongXe.getTenDongXe();
				datas[3] = dongXe.getHangXe().getTenHangXe();
				datas[4] = dongXe.getThue();
				model.addRow(datas);
			}
		}
		table.clearSelection();

	}

	private void dangKiSuKien() {
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);

		table.addMouseListener(this);

		cboTimKiem.addActionListener(this);
		txtTimKiem.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {

			if (kiemTraHopLe()) {
				// kiem tra ma khong trung

				DongXeDao dongXeDao = DongXeDao.getInstance();

				if (dongXeDao.kiemTraKhongTrungTenDongXe(txtTen.getText().trim())) {
					HangXe hangXe = HangXeDao.getInstance()
							.getHangXeTheoTen(cboHang.getSelectedItem().toString().trim());
					DongXe dongXe = new DongXe(lblMa.getText().trim(), txtTen.getText().trim(),
							Double.parseDouble(txtThue.getText().trim()), hangXe);

					if (DongXeDao.getInstance().themDongXe(dongXe)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					}

					capNhatBang();
					xoaRong();
				} else {
					JOptionPane.showMessageDialog(this, "Tên dòng xe đã trùng");
				}

			} else {
				JOptionPane.showMessageDialog(this, "Thông tin dòng xe không hợp lệ");

			}

		}
		if (o.equals(btnXoa)) {

			int row = table.getSelectedRow();

			if (row != -1) {
				int flag = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa không ?", "Xóa hãng xe",
						JOptionPane.YES_NO_OPTION);

				DongXeDao dongXeDao = DongXeDao.getInstance();
				// da nhan ok
				if (flag == JOptionPane.YES_OPTION) {
					String maDongXe = (String) model.getValueAt(row, 1);

					if (dongXeDao.xoaDongXe(maDongXe)) {
						JOptionPane.showMessageDialog(null, "Xóa dòng xe thành công");
						capNhatBang();
						xoaRong();
					} else {
						JOptionPane.showMessageDialog(null, "Xóa dòng xe thất bại");
					}

				}
			}
		}

		if (o.equals(btnSua)) {
			if (kiemTraHopLe()) {
				HangXe hangXe = HangXeDao.getInstance().getHangXeTheoTen(cboHang.getSelectedItem().toString().trim());
				DongXe dongXe = new DongXe(lblMa.getText().trim(), txtTen.getText().trim(),
						Double.parseDouble(txtThue.getText().trim()), hangXe);

				if (DongXeDao.getInstance().capNhatDongXe(dongXe)) {
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				}

				capNhatBang();
				xoaRong();
			} else {
				JOptionPane.showMessageDialog(this, "Thông tin dòng xe không hợp lệ");
			}
		}

		if (o.equals(btnXoaRong)) {
			xoaRong();
		}
	}

	private void xoaRong() {
		lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.DONG_XE));
		txtThue.setText("2");
		txtTen.setText("");
		cboHang.setSelectedIndex(1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		lblMa.setText(model.getValueAt(row, 1).toString().trim());
		txtTen.setText(model.getValueAt(row, 2).toString().trim());
		cboHang.setSelectedItem(model.getValueAt(row, 3).toString().trim());
		txtThue.setText(model.getValueAt(row, 4).toString().trim());

	}

	private boolean kiemTraHopLe() {

		String tenDongXe = txtTen.getText().trim();

		if (tenDongXe.length() == 0)
			return false;

		String tien = txtThue.getText().trim();

		if (tien.length() == 0)
			return false;

		try {
			double thue = Double.valueOf(txtThue.getText().trim());

			if (thue < 0)
				return false;

		} catch (Exception e) {
			return false;
		}

		return true;
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
	public void keyReleased(KeyEvent e) {

		DongXeDao dongXeDao = DongXeDao.getInstance();

		String txtTimKiem = this.txtTimKiem.getText().trim();
		System.out.println(txtTimKiem);

		if (cboTimKiem.getSelectedItem().equals("Tên dòng xe")) {

			dongXes = dongXeDao.timKiemDongXeTheoTenDongXe(txtTimKiem);

		}

		if (cboTimKiem.getSelectedItem().equals("Mã dòng xe")) {

			dongXes = dongXeDao.timKiemDongXeTheoMaDongXe(txtTimKiem);

		}

		if (cboTimKiem.getSelectedItem().equals("Hãng")) {

			dongXes = dongXeDao.timKiemDongXeTheoHang(txtTimKiem);

		}

		capNhatBang();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
