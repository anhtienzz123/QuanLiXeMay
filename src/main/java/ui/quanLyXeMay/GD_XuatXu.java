package ui.quanLyXeMay;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import constant.TenEntity;
import dao.XuatXuDao;
import entity.XuatXu;
import other.RandomMa;
import ui.GD_DangNhap;

public class GD_XuatXu extends JFrame implements ActionListener, MouseListener {

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

	private List<XuatXu> xuatXus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_XuatXu frame = new GD_XuatXu();
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
	public GD_XuatXu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GD_DangNhap.class.getResource("/icon/motorbike_helmet_100px.png")));
		setTitle("Quản lý xuất xứ");
		setSize(718, 428);
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
		panel.setBounds(0, 0, 708, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý xuất xứ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 708, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_2 = new JLabel("Mã xuất xứ:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 65, 129, 30);
		contentPane.add(lblNewLabel_1_2);

		lblMa = new JLabel("LX123456");
		lblMa.setForeground(Color.BLACK);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(148, 65, 136, 30);
		lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.XUAT_XU));
		contentPane.add(lblMa);

		JLabel lblNewLabel_1_2_5 = new JLabel("Xuất xứ:");
		lblNewLabel_1_2_5.setForeground(Color.BLACK);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(308, 65, 122, 30);
		contentPane.add(lblNewLabel_1_2_5);

		btnXoaRong = new JButton("Xóa trắng");
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setIcon(new ImageIcon(GD_XuatXu.class.getResource("/icon/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBounds(179, 334, 196, 30);
		contentPane.add(btnXoaRong);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 115, 660, 191);
		contentPane.add(scrollPane);

		String[] colHeader = { "STT", "Mã xuất xứ", "Tên xuất xứ" };
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
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		scrollPane.setViewportView(table);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setBounds(428, 65, 256, 30);
		contentPane.add(txtTen);
		txtTen.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_XuatXu.class.getResource("/icon/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(547, 334, 136, 30);
		contentPane.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GD_XuatXu.class.getResource("/icon/baseline_construction_white_18dp.png")));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(396, 334, 129, 30);
		contentPane.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_XuatXu.class.getResource("/icon/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(23, 334, 129, 30);
		contentPane.add(btnXoa);

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
	 * Cập nhật dữ liệu trong bảng
	 */
	private void capNhatBang() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		xuatXus = XuatXuDao.getInstance().getXuatXus();
		if (xuatXus != null) {
			for (XuatXu xuatXu : xuatXus) {
				Object[] datas = new Object[3];
				datas[0] = table.getRowCount() + 1;
				datas[1] = xuatXu.getMaXuatXu();
				datas[2] = xuatXu.getTenXuatXu();
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnThem)) {
			if(kiemTraKhongTrung()) {
				
				XuatXuDao xuatXuDao = XuatXuDao.getInstance();
				
				String tenXuatXu = txtTen.getText().trim();
				
				if(tenXuatXu.length() == 0) {
					JOptionPane.showMessageDialog(this, "Tên xuất xứ bị trống ");
					txtTen.requestFocus();
				}else {
					XuatXu xuatXu = new XuatXu(lblMa.getText().trim(), txtTen.getText().trim());
					
					if(xuatXuDao.themXuatXu(xuatXu)) {
						JOptionPane.showMessageDialog(this, "Thêm xuất xứ thành công");
						
						capNhatBang();
						xoaRong();
					}else {
						JOptionPane.showMessageDialog(this, "Thêm xuất xứ thất bại");
					}
						
				}
				
				
				

				
				
			}else {
				JOptionPane.showMessageDialog(this, "Tên xuất xứ bị trùng");
				txtTen.requestFocus();
			}
			
			
			
		}
		if (o.equals(btnXoa)) {
			try {
				int row = table.getSelectedRow();
				String xuatXu = (String) model.getValueAt(row, 1);
				XuatXuDao xuatXuDao = XuatXuDao.getInstance();
				int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có thực sự muốn xóa không!", "Chú ý",
						JOptionPane.YES_NO_OPTION);
				if (xacnhan == JOptionPane.YES_OPTION) {
					if (xuatXuDao.xoaXuatXu(xuatXu)) {
						JOptionPane.showMessageDialog(this, "Xóa thành công");
						capNhatBang();
						xoaRong();
					} else {
						JOptionPane.showMessageDialog(this, "Không thể xóa xuất xứ đang tồn tại xe máy !");
					}
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Chọn xuất xứ muốn xóa");
			}
		}
		if (o.equals(btnSua)) {

			if(kiemTraKhongTrung()) {
				XuatXuDao xuatXuDao = XuatXuDao.getInstance();

				XuatXu xuatXu = new XuatXu(lblMa.getText().trim(), txtTen.getText().trim());
				if (!xuatXu.getTenXuatXu().equals("")) {
					if (xuatXuDao.capNhatXuatXu(xuatXu)) {
						JOptionPane.showMessageDialog(this, "Sửa thành công");
						xoaRong();
					}
				} else {
					JOptionPane.showMessageDialog(this, "Tên xuất xứ trống");
					txtTen.requestFocus();
				}
				capNhatBang();
			}else {
				JOptionPane.showMessageDialog(this, "Tên xuất xứ bị trùng");
				txtTen.requestFocus();
			}

		}
		if (o.equals(btnXoaRong)) {
			xoaRong();
		}
	}
	
	private void xoaRong() {
		lblMa.setText(RandomMa.getMaNgauNhien(TenEntity.XUAT_XU));
		txtTen.setText("");
	}
	
	private boolean kiemTraKhongTrung() {
		
		String tenXuatXu =  (String) txtTen.getText();
		
		XuatXuDao xuatXuDao = XuatXuDao.getInstance();
		
		return xuatXuDao.kiemTraKhongTrungTenXuatXu(tenXuatXu);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		lblMa.setText(model.getValueAt(row, 1).toString().trim());
		txtTen.setText(model.getValueAt(row, 2).toString().trim());
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
}
