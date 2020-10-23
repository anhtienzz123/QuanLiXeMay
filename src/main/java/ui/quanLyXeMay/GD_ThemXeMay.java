package ui.quanLyXeMay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GD_ThemXeMay extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaXe;
	private JTextField txtTenXe;
	private JButton btnQuayLai;
	private JButton btnXoaRong;
	private JButton btnLuu;
	private JComboBox cboHang;
	private JComboBox cboDongXe;
	private JComboBox cboXuatXu;
	private JComboBox cboMauXe;
	private JTextField txtAnh;
	private JTextField txtGiaNhap;
	private JTextField txtBaoHanh;
	private JTextField txtSoLuong;
	private JTextField txtHeSoBan;
	private JTextField txtSoKhung;
	private JTextField txtSoSuon;
	private JButton btnChonFile;
	private JLabel lblAnh;
	private JPanel pnlAnh;

	/**
	 * Create the panel.
	 */
	public GD_ThemXeMay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1300, 900));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JPanel pnlThemXe = new JPanel();
		pnlThemXe.setBackground(new Color(0, 128, 0));
		pnlThemXe.setPreferredSize(new Dimension(1300, 50));
		pnlThemXe.setMaximumSize(new Dimension(32767, 50));
		horizontalBox.add(pnlThemXe);
		pnlThemXe.setLayout(new BoxLayout(pnlThemXe, BoxLayout.X_AXIS));

		JLabel lblThemXe = new JLabel("Thêm xe máy");
		lblThemXe.setMaximumSize(new Dimension(37217, 50));
		lblThemXe.setPreferredSize(new Dimension(1300, 50));
		lblThemXe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThemXe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemXe.setForeground(Color.WHITE);
		lblThemXe.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlThemXe.add(lblThemXe);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setMaximumSize(new Dimension(40, 40));
		rigidArea.setPreferredSize(new Dimension(40, 40));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_9);

		JLabel lblNewLabel = new JLabel("Mã xe");
		lblNewLabel.setPreferredSize(new Dimension(90, 40));
		lblNewLabel.setMaximumSize(new Dimension(100, 40));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10.setPreferredSize(new Dimension(10, 20));
		horizontalBox_1.add(rigidArea_10);

		txtMaXe = new JTextField();
		txtMaXe.setEditable(false);
		txtMaXe.setText("XM123456");
		txtMaXe.setMaximumSize(new Dimension(2147483647, 40));
		txtMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaXe.setPreferredSize(new Dimension(150, 40));
		horizontalBox_1.add(txtMaXe);
		txtMaXe.setColumns(7);

		Component rigidArea_9_8_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_8_2.setPreferredSize(new Dimension(30, 20));
		rigidArea_9_8_2.setMaximumSize(new Dimension(40, 20));
		horizontalBox_1.add(rigidArea_9_8_2);

		JLabel lblTnXe = new JLabel("Tên xe");
		lblTnXe.setMaximumSize(new Dimension(100, 40));
		lblTnXe.setPreferredSize(new Dimension(90, 40));
		lblTnXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblTnXe);

		Component rigidArea_10_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1.setPreferredSize(new Dimension(10, 20));
		horizontalBox_1.add(rigidArea_10_1);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_5);

		txtTenXe = new JTextField();
		txtTenXe.setMaximumSize(new Dimension(2147483647, 40));
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenXe.setPreferredSize(new Dimension(400, 40));
		txtTenXe.setColumns(10);
		horizontalBox_1.add(txtTenXe);

		Component rigidArea_9_7 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_7.setPreferredSize(new Dimension(35, 20));
		rigidArea_9_7.setMaximumSize(new Dimension(40, 20));
		horizontalBox_1.add(rigidArea_9_7);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setMaximumSize(new Dimension(100, 40));
		lblHng.setPreferredSize(new Dimension(70, 40));
		lblHng.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblHng);

		Component rigidArea_10_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_1.setPreferredSize(new Dimension(10, 20));
		horizontalBox_1.add(rigidArea_10_1_1);

		cboHang = new JComboBox();
		cboHang.setMaximumSize(new Dimension(32767, 40));
		cboHang.setModel(new DefaultComboBoxModel(new String[] { "Honda", "Yamaha", "SYM", "Suzuki", "Harley Davidson",
				"Ducati", "Kawasaki", "Piaggio" }));
		cboHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHang.setPreferredSize(new Dimension(180, 40));
		horizontalBox_1.add(cboHang);

		JPopupMenu popupMenuHangXe = new JPopupMenu();
		popupMenuHangXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addPopup(cboHang, popupMenuHangXe);

		JMenuItem mntmThemHangXe = new JMenuItem("Thêm hãng xe");
		mntmThemHangXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuHangXe.add(mntmThemHangXe);

		JMenuItem mntmSuaHangXe = new JMenuItem("Sửa hãng xe");
		mntmSuaHangXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuHangXe.add(mntmSuaHangXe);

		JMenuItem mntmXoaHangXe = new JMenuItem("Xóa hãng xe");
		mntmXoaHangXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuHangXe.add(mntmXoaHangXe);

		Component rigidArea_9_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_1.setMaximumSize(new Dimension(40, 20));
		horizontalBox_1.add(rigidArea_9_1);

		JLabel lblLoiXe = new JLabel("Loại xe");
		lblLoiXe.setPreferredSize(new Dimension(75, 40));
		lblLoiXe.setMaximumSize(new Dimension(100, 40));
		lblLoiXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblLoiXe);

		Component rigidArea_10_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_2.setPreferredSize(new Dimension(10, 20));
		horizontalBox_1.add(rigidArea_10_2);

		JComboBox cboLoaiXe = new JComboBox();
		cboLoaiXe.setModel(new DefaultComboBoxModel(new String[] { "Xe số", "Xe tay ga", "Xe côn tay", "Xe mô tô" }));
		cboLoaiXe.setPreferredSize(new Dimension(125, 40));
		cboLoaiXe.setMaximumSize(new Dimension(32767, 40));
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(cboLoaiXe);

		JPopupMenu popupMenuLoaiXe = new JPopupMenu();
		addPopup(cboLoaiXe, popupMenuLoaiXe);

		JMenuItem mntmThemLoaiXe = new JMenuItem("Thêm loại xe");
		mntmThemLoaiXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuLoaiXe.add(mntmThemLoaiXe);

		JMenuItem mntmSuaLoaiXe = new JMenuItem("Sửa loại xe");
		mntmSuaLoaiXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuLoaiXe.add(mntmSuaLoaiXe);

		JMenuItem mntmXoaLoaiXe = new JMenuItem("Xóa loại xe");
		mntmXoaLoaiXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuLoaiXe.add(mntmXoaLoaiXe);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_12);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setMaximumSize(new Dimension(40, 40));
		rigidArea_1.setPreferredSize(new Dimension(40, 40));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_9_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_9_5);

		JLabel lblDngXe = new JLabel("Dòng xe");
		lblDngXe.setMaximumSize(new Dimension(100, 40));
		lblDngXe.setPreferredSize(new Dimension(90, 40));
		lblDngXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblDngXe);

		Component rigidArea_10_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_2.setPreferredSize(new Dimension(10, 20));
		horizontalBox_2.add(rigidArea_10_1_2);

		cboDongXe = new JComboBox();
		cboDongXe.setModel(new DefaultComboBoxModel(new String[] { "Wave", "Winner", "SH", "Future", "Air Blade",
				"Vision", "Lead", "Cub", "Exciter", "Sirius", "Jupiter" }));
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setPreferredSize(new Dimension(200, 40));
		cboDongXe.setMaximumSize(new Dimension(200, 40));
		horizontalBox_2.add(cboDongXe);

		JPopupMenu popupMenuDongXe = new JPopupMenu();
		popupMenuDongXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addPopup(cboDongXe, popupMenuDongXe);

		JMenuItem mntmThemDongXe = new JMenuItem("Thêm dòng xe");
		mntmThemDongXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuDongXe.add(mntmThemDongXe);

		JMenuItem mntmSuaDongXe = new JMenuItem("Sửa dòng xe");
		mntmSuaDongXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuDongXe.add(mntmSuaDongXe);

		JMenuItem mntmXoaDongXe = new JMenuItem("Xóa dòng xe");
		mntmXoaDongXe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuDongXe.add(mntmXoaDongXe);

		Component rigidArea_9_8 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_8.setPreferredSize(new Dimension(50, 20));
		rigidArea_9_8.setMaximumSize(new Dimension(40, 20));
		horizontalBox_2.add(rigidArea_9_8);

		JLabel lblXutS = new JLabel("Xuất xứ");
		lblXutS.setMaximumSize(new Dimension(100, 40));
		lblXutS.setPreferredSize(new Dimension(90, 40));
		lblXutS.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblXutS);

		Component rigidArea_10_1_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_1_1.setPreferredSize(new Dimension(10, 20));
		horizontalBox_2.add(rigidArea_10_1_1_1);

		cboXuatXu = new JComboBox();
		cboXuatXu.setModel(new DefaultComboBoxModel(
				new String[] { "Việt nam", "Nhật Bản", "Trung Quốc", "Thái Lan", "Hàn Quốc", "Đức", "Mỹ" }));
		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setPreferredSize(new Dimension(218, 40));
		cboXuatXu.setMaximumSize(new Dimension(250, 40));
		horizontalBox_2.add(cboXuatXu);

		JPopupMenu popupMenuXuatXu = new JPopupMenu();
		popupMenuXuatXu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addPopup(cboXuatXu, popupMenuXuatXu);

		JMenuItem mntmThemXuatXu = new JMenuItem("Thêm xuất xứ");
		mntmThemXuatXu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuXuatXu.add(mntmThemXuatXu);

		JMenuItem mntmSuaXuatXu = new JMenuItem("Sửa xuất xứ");
		mntmSuaXuatXu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuXuatXu.add(mntmSuaXuatXu);

		JMenuItem mntmXoaXuatXu = new JMenuItem("Xóa xuất xứ");
		mntmXoaXuatXu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		popupMenuXuatXu.add(mntmXoaXuatXu);

		Component rigidArea_9_15 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_15.setPreferredSize(new Dimension(30, 20));
		rigidArea_9_15.setMaximumSize(new Dimension(40, 20));
		horizontalBox_2.add(rigidArea_9_15);

		JLabel lblPhnKhi = new JLabel("Số phân khối");
		lblPhnKhi.setMaximumSize(new Dimension(150, 40));
		lblPhnKhi.setPreferredSize(new Dimension(135, 40));
		lblPhnKhi.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblPhnKhi);

		Component rigidArea_10_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_3.setPreferredSize(new Dimension(10, 20));
		horizontalBox_2.add(rigidArea_10_3);

		JComboBox cboPhanKhoi = new JComboBox();
		cboPhanKhoi.setModel(new DefaultComboBoxModel(new String[] { "50", "110", "125", "150", "175" }));
		cboPhanKhoi.setPreferredSize(new Dimension(130, 40));
		cboPhanKhoi.setMaximumSize(new Dimension(250, 40));
		cboPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_2.add(cboPhanKhoi);

		Component rigidArea_9_9 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_9.setMaximumSize(new Dimension(40, 20));
		horizontalBox_2.add(rigidArea_9_9);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setPreferredSize(new Dimension(100, 40));
		lblSLng.setMaximumSize(new Dimension(100, 40));
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblSLng);

		Component rigidArea_10_1_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_1_2.setPreferredSize(new Dimension(25, 20));
		rigidArea_10_1_1_2.setMaximumSize(new Dimension(30, 20));
		horizontalBox_2.add(rigidArea_10_1_1_2);

		txtSoLuong = new JTextField();
		txtSoLuong.setPreferredSize(new Dimension(120, 40));
		txtSoLuong.setMaximumSize(new Dimension(200, 40));
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(6);
		horizontalBox_2.add(txtSoLuong);

		Component rigidArea_13 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_13);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setMaximumSize(new Dimension(40, 40));
		rigidArea_2.setPreferredSize(new Dimension(40, 40));
		verticalBox.add(rigidArea_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Component rigidArea_11_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_11_2);

		JLabel lblMuXe = new JLabel("Màu xe");
		lblMuXe.setPreferredSize(new Dimension(90, 40));
		lblMuXe.setMaximumSize(new Dimension(100, 40));
		lblMuXe.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblMuXe);

		Component rigidArea_10_1_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_3.setPreferredSize(new Dimension(10, 20));
		horizontalBox_3.add(rigidArea_10_1_3);

		cboMauXe = new JComboBox();
		cboMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMauXe.setModel(new DefaultComboBoxModel(
				new String[] { "Trắng", "Đen", "Đỏ", "Xanh dương", "Vàng", "Xanh lá", "Cam" }));
		cboMauXe.setPreferredSize(new Dimension(200, 40));
		cboMauXe.setMaximumSize(new Dimension(200, 40));
		horizontalBox_3.add(cboMauXe);

		Component rigidArea_9_8_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_8_1.setPreferredSize(new Dimension(50, 20));
		rigidArea_9_8_1.setMaximumSize(new Dimension(40, 20));
		horizontalBox_3.add(rigidArea_9_8_1);

		JLabel lblGiNhp = new JLabel("Giá nhập");
		lblGiNhp.setPreferredSize(new Dimension(90, 40));
		lblGiNhp.setMaximumSize(new Dimension(100, 40));
		lblGiNhp.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblGiNhp);

		Component rigidArea_10_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_4.setPreferredSize(new Dimension(10, 20));
		horizontalBox_3.add(rigidArea_10_4);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setMaximumSize(new Dimension(2000, 40));
		txtGiaNhap.setPreferredSize(new Dimension(250, 40));
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaNhap.setColumns(12);
		horizontalBox_3.add(txtGiaNhap);

		Component rigidArea_9_15_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_15_1.setPreferredSize(new Dimension(45, 20));
		rigidArea_9_15_1.setMaximumSize(new Dimension(40, 20));
		horizontalBox_3.add(rigidArea_9_15_1);

		JLabel lblBoHnh = new JLabel("Bảo hành");
		lblBoHnh.setMaximumSize(new Dimension(50, 40));
		lblBoHnh.setPreferredSize(new Dimension(120, 40));
		lblBoHnh.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblBoHnh);

		Component rigidArea_10_1_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_4.setPreferredSize(new Dimension(22, 20));
		horizontalBox_3.add(rigidArea_10_1_4);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setPreferredSize(new Dimension(50, 40));
		txtBaoHanh.setMaximumSize(new Dimension(50, 40));
		txtBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBaoHanh.setColumns(4);
		horizontalBox_3.add(txtBaoHanh);

		Component horizontalGlue_4_1 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_4_1);

		Component rigidArea_10_1_1_4_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_1_4_2.setPreferredSize(new Dimension(30, 20));
		horizontalBox_3.add(rigidArea_10_1_1_4_2);

		JLabel lblHSBn = new JLabel("Hệ số bán");
		lblHSBn.setPreferredSize(new Dimension(100, 40));
		lblHSBn.setMaximumSize(new Dimension(100, 40));
		lblHSBn.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblHSBn);

		Component rigidArea_10_1_1_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_1_2_1.setPreferredSize(new Dimension(30, 20));
		rigidArea_10_1_1_2_1.setMaximumSize(new Dimension(30, 20));
		horizontalBox_3.add(rigidArea_10_1_1_2_1);

		txtHeSoBan = new JTextField();
		txtHeSoBan.setPreferredSize(new Dimension(50, 40));
		txtHeSoBan.setMaximumSize(new Dimension(80, 40));
		txtHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHeSoBan.setColumns(3);
		horizontalBox_3.add(txtHeSoBan);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_4);

		Component rigidArea_13_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_13_1);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setMaximumSize(new Dimension(40, 40));
		rigidArea_3.setPreferredSize(new Dimension(40, 40));
		verticalBox.add(rigidArea_3);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		Component rigidArea_9_10 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_10);

		JLabel lblSKhung = new JLabel("Số khung");
		lblSKhung.setPreferredSize(new Dimension(100, 40));
		lblSKhung.setMaximumSize(new Dimension(100, 40));
		lblSKhung.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblSKhung);

		txtSoKhung = new JTextField();
		txtSoKhung.setPreferredSize(new Dimension(180, 40));
		txtSoKhung.setMaximumSize(new Dimension(190, 40));
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoKhung.setColumns(12);
		horizontalBox_4.add(txtSoKhung);
		
		Component rigidArea_9_8_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_9_8_1_1.setPreferredSize(new Dimension(50, 20));
		rigidArea_9_8_1_1.setMaximumSize(new Dimension(40, 20));
		horizontalBox_4.add(rigidArea_9_8_1_1);

		JLabel lblSSn = new JLabel("Số sườn");
		lblSSn.setPreferredSize(new Dimension(95, 40));
		lblSSn.setMaximumSize(new Dimension(100, 40));
		lblSSn.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblSSn);

		txtSoSuon = new JTextField();
		txtSoSuon.setPreferredSize(new Dimension(190, 40));
		txtSoSuon.setMaximumSize(new Dimension(190, 40));
		txtSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoSuon.setColumns(12);
		horizontalBox_4.add(txtSoSuon);

		Component rigidArea_13_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_13_2.setPreferredSize(new Dimension(40, 20));
		horizontalBox_4.add(rigidArea_13_2);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_1);

		JLabel lblnh = new JLabel("Ảnh");
		lblnh.setMaximumSize(new Dimension(100, 40));
		lblnh.setPreferredSize(new Dimension(40, 40));
		lblnh.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(lblnh);

		Component rigidArea_10_1_1_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_1_1_4.setPreferredSize(new Dimension(10, 20));
		horizontalBox_4.add(rigidArea_10_1_1_4);

		txtAnh = new JTextField();
		txtAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnh.setPreferredSize(new Dimension(650, 40));
		txtAnh.setMaximumSize(new Dimension(700, 40));
		txtAnh.setColumns(21);
		horizontalBox_4.add(txtAnh);

		Component rigidArea_9_12_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_12_1);

		btnChonFile = new JButton("Chọn file");
		btnChonFile.setPreferredSize(new Dimension(115, 25));
		btnChonFile.setMaximumSize(new Dimension(120, 40));
		btnChonFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_4.add(btnChonFile);

		Component rigidArea_9_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_12);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setMaximumSize(new Dimension(40, 40));
		rigidArea_4.setPreferredSize(new Dimension(40, 40));
		verticalBox.add(rigidArea_4);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);

		Component rigidArea_9_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_9_4_1);

		JLabel lblMT = new JLabel("Mô tả");
		lblMT.setVerticalAlignment(SwingConstants.TOP);
		lblMT.setMaximumSize(new Dimension(100, 400));
		lblMT.setPreferredSize(new Dimension(90, 200));
		lblMT.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_6.add(lblMT);

		Component rigidArea_10_5_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_10_5_1.setPreferredSize(new Dimension(10, 20));
		horizontalBox_6.add(rigidArea_10_5_1);

		JScrollPane scrollPane = new JScrollPane();
		horizontalBox_6.add(scrollPane);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(txtMoTa);

		Component rigidArea_14 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_14.setPreferredSize(new Dimension(30, 20));
		horizontalBox_6.add(rigidArea_14);

		pnlAnh = new JPanel();
		pnlAnh.setPreferredSize(new Dimension(300, 200));
		horizontalBox_6.add(pnlAnh);
		pnlAnh.setLayout(new BoxLayout(pnlAnh, BoxLayout.X_AXIS));

		lblAnh = new JLabel("IMG");
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnh.setMaximumSize(new Dimension(700, 700));
		lblAnh.setPreferredSize(new Dimension(190, 200));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		pnlAnh.add(lblAnh);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_5);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_6.setMaximumSize(new Dimension(40, 40));
		rigidArea_6.setPreferredSize(new Dimension(40, 40));
		verticalBox.add(rigidArea_6);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7);

		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_15);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setBackground(Color.RED);
		btnQuayLai.setPreferredSize(new Dimension(150, 50));
		btnQuayLai.setMaximumSize(new Dimension(150, 50));
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(btnQuayLai);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_7.add(horizontalGlue);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setPreferredSize(new Dimension(150, 50));
		btnXoaRong.setMaximumSize(new Dimension(120, 50));
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(btnXoaRong);

		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_17.setPreferredSize(new Dimension(30, 20));
		horizontalBox_7.add(rigidArea_17);

		btnLuu = new JButton("Lưu");
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setBackground(new Color(0, 128, 0));
		btnLuu.setPreferredSize(new Dimension(120, 50));
		btnLuu.setMaximumSize(new Dimension(120, 50));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(btnLuu);

		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_16);

		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_8);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);

		dangKiSuKien();
	}

	public void dangKiSuKien() {
		btnLuu.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnChonFile.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnQuayLai)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_XeMay());
			this.validate();
			this.repaint();
		} else if (o.equals(btnChonFile)) {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpg", "png", "jpg");
				fileChooser.setFileFilter(imgFilter);
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setPreferredSize(new Dimension(900, 600));
				if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					lblAnh.setIcon(new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage()
							.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
					txtAnh.setText(f.getPath());
				}
				
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				
//				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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
