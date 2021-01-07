package ui.quanLyBaoHanh;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import dao.DanhMucBaoHanhDao;
import entity.DanhMucBaoHanh;
import other.RandomMa;

public class GD_DanhMucBaoHanh extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblMa;
	private JButton btnThoat;
	private JTextField txtTen;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaRong;

	private List<DanhMucBaoHanh> danhMucBaoHanhs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_DanhMucBaoHanh frame = new GD_DanhMucBaoHanh();
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
	public GD_DanhMucBaoHanh() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GD_DanhMucBaoHanh.class.getResource("/icon/baseline_receipt_long_white_36dp.png")));
		setTitle("Danh mục bảo hành");
		setSize(1196, 661);
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
		panel.setBounds(0, 0, 1182, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh mục bảo hành");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1182, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_2 = new JLabel("Mã mục bảo hành:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 65, 197, 30);
		contentPane.add(lblNewLabel_1_2);

		lblMa = new JLabel("DMBBH123456");
		lblMa.setForeground(Color.BLACK);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(232, 65, 136, 30);
		contentPane.add(lblMa);
		lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.DANH_MUC_BAO_HANH));

		JLabel lblNewLabel_1_2_5 = new JLabel("Tên mục bảo hành:");
		lblNewLabel_1_2_5.setForeground(Color.BLACK);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(430, 65, 197, 30);
		contentPane.add(lblNewLabel_1_2_5);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(58, 181, 74));
		separator_2.setBorder(null);
		separator_2.setBounds(23, 130, 1128, 14);
		contentPane.add(separator_2);

		JLabel lblNewLabel_1_3 = new JLabel("Danh mục bảo hành");
		lblNewLabel_1_3.setForeground(new Color(58, 181, 74));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(23, 101, 249, 30);
		contentPane.add(lblNewLabel_1_3);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setIcon(new ImageIcon(GD_DanhMucBaoHanh.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(23, 566, 136, 30);
		contentPane.add(btnThoat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 157, 1128, 383);
		contentPane.add(scrollPane);

		String[] colHeader = { "STT", "Mã mục bảo hành", "Tên mục bảo hành" };
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
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(800);
		scrollPane.setViewportView(table);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setBounds(639, 65, 512, 30);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1015, 566, 136, 30);
		contentPane.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(670, 566, 136, 30);
		contentPane.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(498, 566, 136, 30);
		contentPane.add(btnXoa);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setBounds(843, 566, 136, 30);
		contentPane.add(btnXoaRong);

		JTableHeader tableHearder = table.getTableHeader();
		tableHearder.setBackground(new Color(58, 181, 74));
		tableHearder.setForeground(Color.white);
		tableHearder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 7; i++) {
			model.addRow(new Object[] { i, null, null });
		}

		dangKiSuKien();
		capNhatBang();

	}

	/**
	 * Đăng kí sự kiện
	 */
	private void dangKiSuKien() {
		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		table.addMouseListener(this);
	}

	/**
	 * Cập nhật dữ liệu trong bảng
	 */
	private void capNhatBang() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		danhMucBaoHanhs = DanhMucBaoHanhDao.getInstance().getDanhMucBaoHanhs();
		if (danhMucBaoHanhs != null) {
			for (DanhMucBaoHanh danhMucBaoHanh : danhMucBaoHanhs) {
				Object[] datas = new Object[3];
				datas[0] = table.getRowCount() + 1;
				datas[1] = danhMucBaoHanh.getMaDanhMucBaoHanh();
				datas[2] = danhMucBaoHanh.getTenDanhMucBaoHanh();
				model.addRow(datas);
			}
		}
		table.clearSelection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		/**
		 * Thêm
		 */
		if (o.equals(btnThem)) {
			DanhMucBaoHanh danhMucBaoHanh = new DanhMucBaoHanh(lblMa.getText().trim(), txtTen.getText().trim());
			if (DanhMucBaoHanhDao.getInstance().themDanhMucBaoHanh(danhMucBaoHanh)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			}
			lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.DANH_MUC_BAO_HANH));
			capNhatBang();
		}
		/**
		 * Xóa
		 */
		if (o.equals(btnXoa)) {
			JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xóa không","Chú ý",JOptionPane.YES_NO_OPTION);;

		}
		/**
		 * Xóa rỗng
		 */
		if (o.equals(btnXoaRong)) {
			lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.DANH_MUC_BAO_HANH));
			txtTen.setText("");

		}
		/**
		 * Sửa
		 */
		if (o.equals(btnSua)) {
			DanhMucBaoHanh danhMucBaoHanh = new DanhMucBaoHanh(lblMa.getText().trim(), txtTen.getText().trim());
			if (DanhMucBaoHanhDao.getInstance().capNhatDanhMucBaoHanh(danhMucBaoHanh)) {
				JOptionPane.showMessageDialog(this, "Sửa thành công");
			}
			capNhatBang();
		}
		/**
		 * Thoát
		 */
		if (o.equals(btnThoat)) {
			this.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		lblMa.setText(model.getValueAt(row, 1).toString().trim());
		txtTen.setText(model.getValueAt(row, 2).toString().trim());
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
}
