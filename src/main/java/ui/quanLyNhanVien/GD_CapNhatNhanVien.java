package ui.quanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class GD_CapNhatNhanVien extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlXeMay;
	private JLabel lblNhanVien;
	private JLabel lblTimKiem;
	private JComboBox<String> cboLoaiNV;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnQuayLai;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtQunL;
	private JTextField textField_4;
	private JTextField txtMatKhau;
	private JTextField txtTenNV;
	private JPanel pnlKyThuat;
	private JPanel pnlHanhChinh;
	private JTextField txtSoNamKN;

	/**
	 * Create the panel.
	 */
	public GD_CapNhatNhanVien() {
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

		lblNhanVien = new JLabel("Cập nhật nhân viên");
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

		lblTimKiem = new JLabel("Mã nhân viên: ");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setMaximumSize(new Dimension(150, 40));
		lblTimKiem.setPreferredSize(new Dimension(150, 40));
		horizontalBox_1.add(lblTimKiem);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);

		JLabel lblMaNV = new JLabel("HC123456");
		lblMaNV.setPreferredSize(new Dimension(120, 40));
		lblMaNV.setMaximumSize(new Dimension(150, 40));
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaNV);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);

		JLabel lblLoiNhnVin = new JLabel("Loại nhân viên:");
		lblLoiNhnVin.setPreferredSize(new Dimension(160, 40));
		lblLoiNhnVin.setMaximumSize(new Dimension(165, 40));
		lblLoiNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblLoiNhnVin);

		cboLoaiNV = new JComboBox<String>();
		cboLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiNV.setModel(new DefaultComboBoxModel(new String[] { "Nhân viên hành chính", "Nhân viên kỹ thuật" }));
		cboLoaiNV.setPreferredSize(new Dimension(100, 40));
		cboLoaiNV.setMaximumSize(new Dimension(32767, 40));
		horizontalBox_1.add(cboLoaiNV);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1);

		Component rigidArea_5_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_5_1_1);

		JLabel lblLoiNhnVin_1_1_3 = new JLabel("Tên nhân viên:");
		lblLoiNhnVin_1_1_3.setPreferredSize(new Dimension(150, 40));
		lblLoiNhnVin_1_1_3.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1_1.add(lblLoiNhnVin_1_1_3);

		txtTenNV = new JTextField();
		txtTenNV.setText("Nguyễn Trần Nhật Hào");
		txtTenNV.setPreferredSize(new Dimension(150, 40));
		txtTenNV.setMaximumSize(new Dimension(600, 40));
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setColumns(8);
		horizontalBox_1_1.add(txtTenNV);

		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_4_1);

		JLabel lblLoiNhnVin_1 = new JLabel("Ngày sinh:");
		lblLoiNhnVin_1.setPreferredSize(new Dimension(120, 40));
		lblLoiNhnVin_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1_1.add(lblLoiNhnVin_1);

		JDateChooser txtNgaySinh = new JDateChooser();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setMaximumSize(new Dimension(400, 40));
		txtNgaySinh.setPreferredSize(new Dimension(300, 40));
		txtNgaySinh.setDate(Calendar.getInstance().getTime());
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		horizontalBox_1_1.add(txtNgaySinh);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_3);

		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_1.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1_1);

		Box horizontalBox_1_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_2);

		Component rigidArea_4_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_2.add(rigidArea_4_2);

		JLabel lblLoiNhnVin_1_1 = new JLabel("Số điện thoại:");
		horizontalBox_1_2.add(lblLoiNhnVin_1_1);
		lblLoiNhnVin_1_1.setPreferredSize(new Dimension(150, 40));
		lblLoiNhnVin_1_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		txtSDT = new JTextField();
		horizontalBox_1_2.add(txtSDT);
		txtSDT.setText("0123456789");
		txtSDT.setPreferredSize(new Dimension(150, 40));
		txtSDT.setMaximumSize(new Dimension(600, 40));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(8);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_2.add(rigidArea_7);

		JLabel lblLoiNhnVin_1_2 = new JLabel("Địa chỉ:");
		horizontalBox_1_2.add(lblLoiNhnVin_1_2);
		lblLoiNhnVin_1_2.setPreferredSize(new Dimension(80, 40));
		lblLoiNhnVin_1_2.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));

		txtDiaChi = new JTextField();
		txtDiaChi.setText("Bình Thạnh");
		horizontalBox_1_2.add(txtDiaChi);
		txtDiaChi.setPreferredSize(new Dimension(400, 40));
		txtDiaChi.setMaximumSize(new Dimension(600, 40));
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(20);

		Component rigidArea_6_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_2.add(rigidArea_6_2);

		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1_2);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Box verticalBox_1 = Box.createVerticalBox();
		horizontalBox_2.add(verticalBox_1);

		pnlHanhChinh = new JPanel();
		pnlHanhChinh.setPreferredSize(new Dimension(1300, 150));
		pnlHanhChinh.setMaximumSize(new Dimension(32767, 150));
		pnlHanhChinh.setBackground(Color.WHITE);
		verticalBox_1.add(pnlHanhChinh);
		pnlHanhChinh.setLayout(new BoxLayout(pnlHanhChinh, BoxLayout.X_AXIS));

		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setPreferredSize(new Dimension(1300, 100));
		pnlHanhChinh.add(verticalBox_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_3);

		Box horizontalBox_3_1 = Box.createHorizontalBox();
		horizontalBox_3.add(horizontalBox_3_1);

		Component rigidArea_4_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_4_2_1);

		JLabel lblLoiNhnVin_1_1_1 = new JLabel("Chức vụ:");
		lblLoiNhnVin_1_1_1.setPreferredSize(new Dimension(150, 40));
		lblLoiNhnVin_1_1_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblLoiNhnVin_1_1_1);

		txtQunL = new JTextField();
		txtQunL.setText("Quản lý");
		txtQunL.setPreferredSize(new Dimension(150, 40));
		txtQunL.setMaximumSize(new Dimension(600, 40));
		txtQunL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtQunL.setColumns(8);
		horizontalBox_3.add(txtQunL);

		Component rigidArea_7_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_7_1);

		JLabel lblLoiNhnVin_1_2_1 = new JLabel("Trình độ học vấn:");
		lblLoiNhnVin_1_2_1.setPreferredSize(new Dimension(190, 40));
		lblLoiNhnVin_1_2_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblLoiNhnVin_1_2_1);

		textField_4 = new JTextField();
		textField_4.setText("12/12");
		textField_4.setPreferredSize(new Dimension(400, 40));
		textField_4.setMaximumSize(new Dimension(600, 40));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(20);
		horizontalBox_3.add(textField_4);

		Component rigidArea_6_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_6_2_1);

		Component rigidArea_1_2_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_2.setPreferredSize(new Dimension(20, 40));
		verticalBox_2.add(rigidArea_1_2_2);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_5);

		Box horizontalBox_3_2 = Box.createHorizontalBox();
		horizontalBox_5.add(horizontalBox_3_2);

		Component rigidArea_4_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_4_2_2);

		JLabel lblLoiNhnVin_1_1_2 = new JLabel("Vai trò:");
		lblLoiNhnVin_1_1_2.setPreferredSize(new Dimension(150, 40));
		lblLoiNhnVin_1_1_2.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblLoiNhnVin_1_1_2);

			
		JComboBox<String> cboVaiTro = new JComboBox<String>();
		cboVaiTro.setModel(new DefaultComboBoxModel<String>(new String[] {"User", "Admin"}));
		cboVaiTro.setPreferredSize(new Dimension(31, 40));
		cboVaiTro.setMaximumSize(new Dimension(32767, 40));
		cboVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_5.add(cboVaiTro);
		Component rigidArea_7_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_7_2);

		JLabel lblLoiNhnVin_1_2_2 = new JLabel("Mật khẩu:");
		lblLoiNhnVin_1_2_2.setPreferredSize(new Dimension(80, 40));
		lblLoiNhnVin_1_2_2.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_5.add(lblLoiNhnVin_1_2_2);

		txtMatKhau = new JTextField();
		txtMatKhau.setPreferredSize(new Dimension(400, 40));
		txtMatKhau.setMaximumSize(new Dimension(600, 40));
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setColumns(20);
		horizontalBox_5.add(txtMatKhau);

		Component rigidArea_6_2_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_5.add(rigidArea_6_2_2);

		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox_2.add(verticalGlue_1);

		pnlKyThuat = new JPanel();
		pnlKyThuat.setMaximumSize(new Dimension(32767, 150));
		pnlKyThuat.setPreferredSize(new Dimension(1300, 150));
		pnlKyThuat.setBackground(Color.WHITE);
		verticalBox_1.add(pnlKyThuat);
		pnlKyThuat.setLayout(new BoxLayout(pnlKyThuat, BoxLayout.X_AXIS));

		Box verticalBox_3 = Box.createVerticalBox();
		pnlKyThuat.add(verticalBox_3);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_7);

		Component rigidArea_4_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_4_2_2_1);

		JLabel lblLoiNhnVin_1_1_2_1 = new JLabel("Số năm kinh nghiệm:");
		lblLoiNhnVin_1_1_2_1.setPreferredSize(new Dimension(300, 40));
		lblLoiNhnVin_1_1_2_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblLoiNhnVin_1_1_2_1);

		txtSoNamKN = new JTextField();
		txtSoNamKN.setText("0123456789");
		txtSoNamKN.setPreferredSize(new Dimension(150, 40));
		txtSoNamKN.setMaximumSize(new Dimension(600, 40));
		txtSoNamKN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoNamKN.setColumns(8);
		horizontalBox_7.add(txtSoNamKN);

		Component rigidArea_7_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_7_2_1);

		JLabel lblLoiNhnVin_1_2_2_1 = new JLabel("Bậc thợ:");
		lblLoiNhnVin_1_2_2_1.setPreferredSize(new Dimension(150, 40));
		lblLoiNhnVin_1_2_2_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblLoiNhnVin_1_2_2_1);

		Component rigidArea_6_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_6_2_2_1);

		JComboBox<Integer> cboBacTho = new JComboBox<Integer>();
		cboBacTho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboBacTho.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7} ));
		cboBacTho.setPreferredSize(new Dimension(31, 40));
		horizontalBox_7.add(cboBacTho);
		cboBacTho.setMaximumSize(new Dimension(32767, 40));

		Component verticalGlue_2_1 = Box.createVerticalGlue();
		verticalBox_3.add(verticalGlue_2_1);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_8);

		Component rigidArea_1_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_2_1.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1_2_2_1);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12);

		btnQuayLai = new JButton("Quay lại");
		horizontalBox_4.add(btnQuayLai);
		btnQuayLai.setPreferredSize(new Dimension(270, 50));
		btnQuayLai.setMaximumSize(new Dimension(300, 50));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.LIGHT_GRAY);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_1);

		Component rigidArea_9_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_1_1);

		btnXoa = new JButton("Xóa rỗng");
		btnXoa.setIcon(new ImageIcon(GD_CapNhatNhanVien.class.getResource("/img/baseline_delete_sweep_white_18dp.png")));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setPreferredSize(new Dimension(170, 50));
		btnXoa.setMaximumSize(new Dimension(300, 50));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnXoa);

		Component rigidArea_9_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_3_1);

		Component rigidArea_9_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_2_1);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon(GD_CapNhatNhanVien.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setForeground(Color.WHITE);
		btnThem.setPreferredSize(new Dimension(140, 50));
		btnThem.setMaximumSize(new Dimension(300, 50));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnThem);

		Component rigidArea_10_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_10_1);

		Box horizontalBox_4_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4_1);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);

		dangKiSuKien();
		pnlKyThuat.setVisible(false);
	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnQuayLai.addActionListener(this);
		cboLoaiNV.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
//			chuyenManHinh(new GD_ThemNhanVien());
			// Custom button text
		} else if (o.equals(cboLoaiNV)) {
			if (cboLoaiNV.getSelectedIndex() == 1) {
				pnlHanhChinh.setVisible(false);
				pnlKyThuat.setVisible(true);
			} else {
				pnlHanhChinh.setVisible(true);
				pnlKyThuat.setVisible(false);
			}
		}else if (o.equals(btnQuayLai)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_NhanVien());
			this.validate();
			this.repaint();
		}

	}

}
