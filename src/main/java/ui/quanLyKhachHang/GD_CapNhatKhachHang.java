package ui.quanLyKhachHang;

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

public class GD_CapNhatKhachHang extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlXeMay;
	private JLabel lblNhanVien;
	private JLabel lblTimKiem;
	private JButton btnLuu;
	private JButton btnQuayLai;
	private JTextField txtSDT;
	private JTextField txtTenNV;
	private JTextField txtCMT;
	private JTextField txtDiaChi;

	/**
	 * Create the panel.
	 */
	public GD_CapNhatKhachHang() {
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

		lblNhanVien = new JLabel("Cập nhật khách hàng");
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

		lblTimKiem = new JLabel("Mã khách hàng:");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimKiem.setMaximumSize(new Dimension(200, 40));
		lblTimKiem.setPreferredSize(new Dimension(180, 40));
		horizontalBox_1.add(lblTimKiem);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);

		JLabel lblMaKH = new JLabel("HC123456");
		lblMaKH.setPreferredSize(new Dimension(120, 40));
		lblMaKH.setMaximumSize(new Dimension(150, 40));
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaKH);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_2);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);

		JLabel lblLoiNhnVin = new JLabel("Số CMT:");
		lblLoiNhnVin.setPreferredSize(new Dimension(160, 40));
		lblLoiNhnVin.setMaximumSize(new Dimension(165, 40));
		lblLoiNhnVin.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblLoiNhnVin);
		
		txtCMT = new JTextField();
		txtCMT.setText("012345678912");
		txtCMT.setPreferredSize(new Dimension(300, 40));
		txtCMT.setMaximumSize(new Dimension(600, 40));
		txtCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCMT.setColumns(17);
		horizontalBox_1.add(txtCMT);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_1_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1_1);

		Component rigidArea_5_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_5_1_1);

		JLabel lblLoiNhnVin_1_1_3 = new JLabel("Tên khách hàng:");
		lblLoiNhnVin_1_1_3.setPreferredSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1_3.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1_1.add(lblLoiNhnVin_1_1_3);

		txtTenNV = new JTextField();
		txtTenNV.setText("Nguyễn Trần Nhật Hào");
		txtTenNV.setPreferredSize(new Dimension(300, 40));
		txtTenNV.setMaximumSize(new Dimension(600, 40));
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setColumns(17);
		horizontalBox_1_1.add(txtTenNV);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_1_1.add(horizontalGlue_4);

		Component rigidArea_4_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_1.add(rigidArea_4_1);

		JLabel lblLoiNhnVin_1 = new JLabel("Ngày sinh:");
		lblLoiNhnVin_1.setPreferredSize(new Dimension(120, 40));
		lblLoiNhnVin_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1_1.add(lblLoiNhnVin_1);

		JDateChooser txtNgaySinh = new JDateChooser();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setMaximumSize(new Dimension(300, 40));
		txtNgaySinh.setPreferredSize(new Dimension(300, 40));
		txtNgaySinh.setDate(Calendar.getInstance().getTime());
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		horizontalBox_1_1.add(txtNgaySinh);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_1_1.add(horizontalGlue_3);

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
		txtSDT.setMaximumSize(new Dimension(300, 40));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(8);
		
		Component horizontalGlue_8 = Box.createHorizontalGlue();
		horizontalBox_1_2.add(horizontalGlue_8);

		Component rigidArea_6_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1_2.add(rigidArea_6_2);

		Component rigidArea_1_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1_2);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
				Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
				horizontalBox_2.add(rigidArea_7);
		
		JLabel lblLoiNhnVin_1_2_1 = new JLabel("Địa chỉ:");
		lblLoiNhnVin_1_2_1.setPreferredSize(new Dimension(80, 40));
		lblLoiNhnVin_1_2_1.setMaximumSize(new Dimension(180, 40));
		lblLoiNhnVin_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblLoiNhnVin_1_2_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setText("Bình Thạnh");
		txtDiaChi.setPreferredSize(new Dimension(800, 40));
		txtDiaChi.setMaximumSize(new Dimension(800, 40));
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(35);
		horizontalBox_2.add(txtDiaChi);
		
		Component horizontalGlue_8_1 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_8_1);
		
		Component rigidArea_6_2_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_6_2_1);

		Component rigidArea_1_2_2_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1_2_2_1.setPreferredSize(new Dimension(20, 40));
		verticalBox.add(rigidArea_1_2_2_1);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_12);

		btnQuayLai = new JButton("Quay lại");
		horizontalBox_4.add(btnQuayLai);
		btnQuayLai.setPreferredSize(new Dimension(150, 50));
		btnQuayLai.setMaximumSize(new Dimension(300, 50));
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuayLai.setBackground(Color.LIGHT_GRAY);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_4.add(horizontalGlue_1);

		Component rigidArea_9_3_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_9_3_1);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(
				new ImageIcon(GD_CapNhatKhachHang.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnLuu.setBackground(new Color(0, 128, 0));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setPreferredSize(new Dimension(140, 50));
		btnLuu.setMaximumSize(new Dimension(300, 50));
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_4.add(btnLuu);

		Component rigidArea_10_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_4.add(rigidArea_10_1);

		Box horizontalBox_4_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4_1);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);

		dangKiSuKien();
	}

	private void dangKiSuKien() {
		btnLuu.addActionListener(this);
		btnQuayLai.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			
		} else if (o.equals(btnQuayLai)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_KhachHang());
			this.validate();
			this.repaint();
		}

	}

}
