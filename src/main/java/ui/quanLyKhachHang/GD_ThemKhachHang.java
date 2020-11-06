package ui.quanLyKhachHang;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import constant.TenEntity;
import dao.KhachHangDao;
import entity.KhachHang;
import other.RandomMa;

public class GD_ThemKhachHang extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThoat;
	private JLabel lblMaKH;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtSoCMT;
	private JTextField txtTenKH;
	private JDateChooser txtNgaySinh;
	private JButton btnXoaRong;
	private JButton btnThem;
	private KhachHangDao khachHangDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_ThemKhachHang frame = new GD_ThemKhachHang();
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
	public GD_ThemKhachHang() {
		khachHangDao = KhachHangDao.getInstance();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 540);
		setLocationRelativeTo(null);
		setTitle("Thông tin khách hàng");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBackground(new Color(0, 128, 0));
		panel.setPreferredSize(new Dimension(800, 50));
		horizontalBox.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setMaximumSize(new Dimension(37137, 50));
		lblNewLabel.setPreferredSize(new Dimension(800, 50));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1);

		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_15);

		lblMaKH = new JLabel();
		
		lblMaKH.setForeground(Color.BLACK);
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_1.add(lblMaKH);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);

		Component rigidArea_5_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_5_1);

		JLabel lblNewLabel_1_1 = new JLabel("Số CMT:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_1.add(lblNewLabel_1_1);

		Component rigidArea_15_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_15_1);

		txtSoCMT = new JTextField();
		txtSoCMT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoCMT.setPreferredSize(new Dimension(300, 40));
		txtSoCMT.setMaximumSize(new Dimension(2147483647, 40));
		txtSoCMT.setColumns(10);
		horizontalBox_1.add(txtSoCMT);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_1.add(rigidArea_6);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_7);

		JLabel lblNewLabel_1_2 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_2.add(lblNewLabel_1_2);

		Component rigidArea_15_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_15_2);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue_2);

		txtTenKH = new JTextField();
		txtTenKH.setText("");
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setPreferredSize(new Dimension(300, 40));
		txtTenKH.setMaximumSize(new Dimension(2147483647, 40));
		txtTenKH.setColumns(10);
		horizontalBox_2.add(txtTenKH);

		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_2.add(rigidArea_12);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_9);

		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_3);

		Component rigidArea_15_3 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_15_3);

		txtSoDienThoai = new JTextField();
		
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setPreferredSize(new Dimension(200, 40));
		txtSoDienThoai.setMaximumSize(new Dimension(2147483647, 40));
		txtSoDienThoai.setColumns(5);
		horizontalBox_3.add(txtSoDienThoai);

		Component rigidArea_5_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_5_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_3.add(lblNewLabel_1_1_1);

		Component rigidArea_15_1_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_15_1_1);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setPreferredSize(new Dimension(100, 40));
		txtNgaySinh.setMaximumSize(new Dimension(2147483647, 40));
		txtNgaySinh.setDate(Calendar.getInstance().getTime());
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		horizontalBox_3.add(txtNgaySinh);

		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_3.add(rigidArea_8);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_3.add(horizontalGlue_3);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7);

		Component rigidArea_20 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_20);

		JLabel lblNewLabel_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7.add(lblNewLabel_1_1_2);

		Component rigidArea_15_1_2 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_15_1_2);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setPreferredSize(new Dimension(300, 40));
		txtDiaChi.setMaximumSize(new Dimension(2147483647, 40));
		horizontalBox_7.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		horizontalBox_7.add(horizontalGlue_6);

		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7.add(rigidArea_11);

		Component rigidArea_3_1 = Box.createRigidArea(new Dimension(20, 20));
		verticalBox.add(rigidArea_3_1);

		Box horizontalBox_7_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_7_1);

		Component rigidArea_20_1 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7_1.add(rigidArea_20_1);

		JLabel lblThongBao = new JLabel("Thông báo: ");
		lblThongBao.setVerticalAlignment(SwingConstants.TOP);
		lblThongBao.setPreferredSize(new Dimension(120, 130));
		lblThongBao.setMaximumSize(new Dimension(120, 200));
		lblThongBao.setVerticalTextPosition(SwingConstants.TOP);
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.BOLD, 20));
		horizontalBox_7_1.add(lblThongBao);

		JTextArea txtThongBao = new JTextArea();
		txtThongBao.setPreferredSize(new Dimension(640, 130));
		txtThongBao.setMaximumSize(new Dimension(2147483647, 130));
		txtThongBao.setMargin(new Insets(10, 10, 10, 10));
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setText(
				"Số chứng minh thư phải gồm 9 hoặc 12 kí tự số.\r\nTên khách hàng không chứa số hoặc kí tự đặc biệt.\r\nKhách hàng phải >= 18 tuổi.\r\nSố điện thoại gồm có 10 kí tự số và bắt đầu bằng số 0.\r\nThêm khách hàng thành công.");
		txtThongBao.setBorder(null);
		txtThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		horizontalBox_7_1.add(txtThongBao);

		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_7_1.add(rigidArea_10);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_6);

		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_16);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setMaximumSize(new Dimension(97, 40));
		btnThoat.setPreferredSize(new Dimension(97, 40));
		horizontalBox_6.add(btnThoat);
		btnThoat.addActionListener(this);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_6.add(horizontalGlue);

		 btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setPreferredSize(new Dimension(140, 40));
		btnXoaRong.setMaximumSize(new Dimension(140, 40));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		horizontalBox_6.add(btnXoaRong);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_4);

		btnThem = new JButton("Thêm");
		btnThem.setPreferredSize(new Dimension(97, 40));
		btnThem.setMaximumSize(new Dimension(97, 40));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(0, 128, 0));
		horizontalBox_6.add(btnThem);

		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		horizontalBox_6.add(rigidArea_17);

		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		// tạo mã ngẫu nhiên
		lblMaKH.setText(RandomMa.getMaNgauNhien(TenEntity.KHACH_HANG));
	
		
		dangKiSuKien();
	}
	
	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoaRong.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(btnThoat)) {
			this.setVisible(false);
		}
		
		if(source == btnThem) {
			KhachHang khachHang = getKhachHang();
			
			if(validateKhachHang(khachHang)) {
				if(khachHangDao.themKhachHang(khachHang)) {
					JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công", "Thông báo thêm nhân viên", JOptionPane.INFORMATION_MESSAGE, null );
				}else {
					JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại", "Thêm nhân viên", JOptionPane.ERROR_MESSAGE, null );
				}
			}
			
		}
		
		if(source == btnXoaRong) {
			
		}
	}
	
	private KhachHang getKhachHang() {
		String maKhachHang = lblMaKH.getText();
		String soCMT = txtSoCMT.getText();
		String hoTenKH = txtTenKH.getText();
		String soDienThoai = txtSoDienThoai.getText();
		String ngaySinhString = txtNgaySinh.getName();
		System.out.println("ngay sinh string: " + ngaySinhString);
		String diaChiKH = txtDiaChi.getText();
		
		KhachHang khachHang = new KhachHang(maKhachHang, soCMT, hoTenKH, new Date(2020, 10, 11), soDienThoai, diaChiKH);
		return khachHang;
		
	}
	
	private boolean validateKhachHang(KhachHang khachHang) {
		
		return true;
	}

}
