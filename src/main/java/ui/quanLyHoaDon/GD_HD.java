package ui.quanLyHoaDon;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ui.GD_TC;
import ui.quanLyXeMay.GD_CNX;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class GD_HD extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private JTable tblHoaDon;
	private JTextField txtTrang;
	private JPanel pnlXeMay;
	private JLabel lblXeMay;
	private JLabel lblTimKiem;
	private JComboBox<String> cboTimKiem;
	private JButton btnDau;
	private JButton btnTruoc;
	private JButton btnSau;
	private JButton btnCuoi;
	private JButton btnXemChiTiet;
	private DefaultTableModel modelHoaDon;
	private JDateChooser txtNgay;

	/**
	 * Create the panel.
	 */
	public GD_HD() {
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

		lblXeMay = new JLabel("Quản lý hóa đơn");
		lblXeMay.setForeground(Color.WHITE);
		lblXeMay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblXeMay.setHorizontalAlignment(SwingConstants.CENTER);
		lblXeMay.setMaximumSize(new Dimension(37217, 50));
		lblXeMay.setPreferredSize(new Dimension(1300, 50));
		pnlXeMay.add(lblXeMay);

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
		cboTimKiem.setModel(new DefaultComboBoxModel(new String[] { "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng",
				"Số điện thoại KH", "Tên nhân viên", "Tên khách hàng", "Ngày lập HD" }));
		cboTimKiem.setPreferredSize(new Dimension(200, 40));
		cboTimKiem.setMaximumSize(new Dimension(300, 40));
		horizontalBox_1.add(cboTimKiem);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTimKiem.setPreferredSize(new Dimension(500, 40));
		txtTimKiem.setMaximumSize(new Dimension(500, 50));
		horizontalBox_1.add(txtTimKiem);
		txtTimKiem.setColumns(15);

		txtNgay = new JDateChooser();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgay.setPreferredSize(new Dimension(200, 22));
		txtNgay.setMaximumSize(new Dimension(500, 40));
		txtNgay.setDateFormatString("dd-MM-yyyy");
		txtNgay.setVisible(false);
		horizontalBox_1.add(txtNgay);

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

		JScrollPane scrollPane = new JScrollPane();
		horizontalBox_2.add(scrollPane);

		String[] colHeaderHoaDon = { "STT", "Mã hóa đơn", "Mã nhân viên", "Tên Nhân viên", "Mã khách hàng",
				"Tên khách hàng", "Ngày lập" };
		modelHoaDon = new DefaultTableModel(colHeaderHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		tblHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tblHoaDon.setRowHeight(30);
		scrollPane.setViewportView(tblHoaDon);

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
		btnDau.setBackground(Color.LIGHT_GRAY);
		btnDau.setIcon(new ImageIcon(GD_HD.class.getResource("/img/baseline_fast_rewind_white_24dp.png")));
		btnDau.setMaximumSize(new Dimension(50, 50));
		btnDau.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnDau);

		Component rigidArea_12_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_1);

		btnTruoc = new JButton("");
		btnTruoc.setBackground(Color.LIGHT_GRAY);
		btnTruoc.setIcon(new ImageIcon(GD_HD.class.getResource("/img/baseline_skip_previous_white_24dp.png")));
		btnTruoc.setMaximumSize(new Dimension(50, 50));
		btnTruoc.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnTruoc);

		Component rigidArea_12_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_2);

		txtTrang = new JTextField();
		txtTrang.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrang.setText("1");
		txtTrang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTrang.setPreferredSize(new Dimension(50, 50));
		txtTrang.setMaximumSize(new Dimension(50, 50));
		horizontalBox_4.add(txtTrang);
		txtTrang.setColumns(3);

		Component rigidArea_12_3_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_3_2);

		btnSau = new JButton("");
		btnSau.setBackground(Color.LIGHT_GRAY);
		btnSau.setIcon(new ImageIcon(GD_HD.class.getResource("/img/baseline_skip_next_white_24dp.png")));
		btnSau.setMaximumSize(new Dimension(50, 50));
		btnSau.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnSau);

		Component rigidArea_12_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_3);

		btnCuoi = new JButton("");
		btnCuoi.setBackground(Color.LIGHT_GRAY);
		btnCuoi.setIcon(new ImageIcon(GD_HD.class.getResource("/img/baseline_fast_forward_white_24dp.png")));
		btnCuoi.setMaximumSize(new Dimension(50, 50));
		btnCuoi.setPreferredSize(new Dimension(50, 50));
		horizontalBox_4.add(btnCuoi);

		Component rigidArea_12_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12_3_1);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_1);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(GD_HD.class.getResource("/img/baseline_error_outline_white_18dp.png")));
		btnXemChiTiet.setBackground(Color.LIGHT_GRAY);
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setPreferredSize(new Dimension(200, 50));
		btnXemChiTiet.setMaximumSize(new Dimension(300, 50));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnXemChiTiet);

		Component rigidArea_10_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_10_1);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);

		dangKiSuKien();
	}

	public void dangKiSuKien() {
		btnCuoi.addActionListener(this);
		btnDau.addActionListener(this);
		btnSau.addActionListener(this);
		btnTruoc.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		cboTimKiem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXemChiTiet)) {
			new GD_ChiTietHoaDon().setVisible(true);
		}
		if(o.equals(cboTimKiem)) {
			if(cboTimKiem.getSelectedIndex() == 6) {
				txtTimKiem.setVisible(false);
				txtNgay.setVisible(true);
			}else {
				txtTimKiem.setVisible(true);
				txtNgay.setVisible(false);
			}
		}
	}

}
