package ui.quanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class GD_NV extends JPanel implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTable tblNVHanhChinh;
	private JTextField txtTrang;
	private JPanel pnlXeMay;
	private JLabel lblNhanVien;
	private JLabel lblTimKiem;
	private JComboBox<String> cboTimKiem;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnXemChiTiet;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnThem;
	private JTable tblNVKyThuat;
	private DefaultTableModel modelNVHanhChinh;
	private DefaultTableModel modelNVKyThuat;

	/**
	 * Create the panel.
	 */
	public GD_NV() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1300, 900));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		pnlXeMay = new JPanel();
		pnlXeMay.setBackground(new Color(0, 128, 0));
		pnlXeMay.setPreferredSize(new Dimension(1300, 50));
		pnlXeMay.setMaximumSize(new Dimension(32767, 50));
		horizontalBox.add(pnlXeMay);
		pnlXeMay.setLayout(new BoxLayout(pnlXeMay, BoxLayout.X_AXIS));
		
		lblNhanVien = new JLabel("Quản lý nhân viên");
		lblNhanVien.setForeground(Color.WHITE);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setMaximumSize(new Dimension(37217, 50));
		lblNhanVien.setPreferredSize(new Dimension(1300, 50));
		pnlXeMay.add(lblNhanVien);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_4);
		
		lblTimKiem = new JLabel("Tìm kiếm: ");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setMaximumSize(new Dimension(150, 40));
		lblTimKiem.setPreferredSize(new Dimension(150, 40));
		horizontalBox_1.add(lblTimKiem);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);
		
		cboTimKiem = new JComboBox<String>();
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Mã nhân viên", "Tên nhân viên"}));
		cboTimKiem.setPreferredSize(new Dimension(200, 40));
		cboTimKiem.setMaximumSize(new Dimension(160, 40));
		horizontalBox_1.add(cboTimKiem);
		
		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setPreferredSize(new Dimension(500, 40));
		txtTimKiem.setMaximumSize(new Dimension(500, 40));
		horizontalBox_1.add(txtTimKiem);
		txtTimKiem.setColumns(15);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_8);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		horizontalBox_2.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Nhân viên hành chính", null, scrollPane, null);
		
		String[] colHeaderNVHanhChinh = { "STT", "Mã nhân viên", "Tên Nhân viên", "Chức vụ", "Trình độ học vấn"};
		modelNVHanhChinh = new DefaultTableModel(colHeaderNVHanhChinh, 0);
		tblNVHanhChinh = new JTable(modelNVHanhChinh) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblNVHanhChinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblNVHanhChinh.setRowHeight(30);
		scrollPane.setViewportView(tblNVHanhChinh);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Nhân viên kĩ thuật", null, scrollPane_1, null);
		
		tblNVKyThuat = new JTable();
		String[] colHeaderNVKyThuat = { "STT", "Mã nhân viên", "Tên Nhân viên", "Số năm kinh nghiệm", "Bậc thợ"};
		modelNVKyThuat = new DefaultTableModel(colHeaderNVKyThuat, 0);
		tblNVKyThuat = new JTable(modelNVKyThuat) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblNVKyThuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblNVKyThuat.setRowHeight(30);
		
		scrollPane_1.setViewportView(tblNVKyThuat);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_7);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_2);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12);
		
		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setBackground(Color.LIGHT_GRAY);
		btnDau.setMaximumSize(new Dimension(50, 50));
		btnDau.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnDau);
		
		Component rigidArea_12_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_1);
		
		btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setBackground(Color.LIGHT_GRAY);
		btnTruoc.setMaximumSize(new Dimension(50, 50));
		btnTruoc.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnTruoc);
		
		Component rigidArea_12_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_2);
		
		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setPreferredSize(new Dimension(50, 40));
		txtTrang.setMaximumSize(new Dimension(50, 50));
		horizontalBox_4.add(txtTrang);
		txtTrang.setColumns(3);
		
		Component rigidArea_12_3_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_3_2);
		
		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setBackground(Color.LIGHT_GRAY);
		btnSau.setMaximumSize(new Dimension(50, 50));
		btnSau.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnSau);
		
		Component rigidArea_12_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_3);
		
		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setBackground(Color.LIGHT_GRAY);
		btnCuoi.setMaximumSize(new Dimension(50, 50));
		btnCuoi.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnCuoi);
		
		Component rigidArea_12_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_3_1);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_1);
		
		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.LIGHT_GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setPreferredSize(new Dimension(200, 50));
		btnXemChiTiet.setMaximumSize(new Dimension(300, 50));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnXemChiTiet);
		
		Component rigidArea_9_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_1_1);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setPreferredSize(new Dimension(140, 50));
		btnXoa.setMaximumSize(new Dimension(300, 50));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnXoa);
		
		Component rigidArea_9_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_3_1);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_construction_white_18dp.png")));
		btnCapNhat.setBackground(new Color(30, 144, 255));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setPreferredSize(new Dimension(170, 50));
		btnCapNhat.setMaximumSize(new Dimension(300, 50));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnCapNhat);
		
		Component rigidArea_9_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_2_1);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GD_NV.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setForeground(Color.WHITE);
		btnThem.setPreferredSize(new Dimension(140, 50));
		btnThem.setMaximumSize(new Dimension(300, 50));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnThem);
		
		Component rigidArea_10_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_10_1);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		dangKiSuKien();
	}

	private void dangKiSuKien() {
		btnCapNhat.addActionListener(this);
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnThem.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnXoa.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			//this.add(new GD_TNV());
			this.validate();
			this.repaint();
			
		}else if (o.equals(btnCapNhat)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			//this.add(new GD_CapNhatNhanVien());
			this.validate();
			this.repaint();
		}else if (o.equals(btnXemChiTiet)) {
			//new GD_ChiTietNVHanhChinh().setVisible(true);
		}
		
	}

	

}
