package ui.quanLyNhanVien;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import constant.TenEntity;
import dao.NhanVienKiThuatDao;
import entity.NhanVienKiThuat;
import other.CopyTask;
import other.RandomMa;
import ui.App;
import ui.quanLyXeMay.GD_ThemXeMay;

public class GD_SuaNhanVienKyThuat extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenNV;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private JTextField txtSoDienThoai;
	private JTextField txtAnh;
	private JTextField txtDiaChi;
	private JTextField txtNamKinhNghiem;
	private JPanel pnlNVKyThuat;
	private JButton btnChonFile;
	private JLabel lblAnh;
	private JPanel pnlAnh;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	private NhanVienKiThuatDao nhanVienKiThuatDao;
	private JLabel lblMaNV;
	private JDateChooser txtNgaySinh;
	private JComboBox<String> cboBacTho;

	/**
	 * Create the panel.
	 */
	public GD_SuaNhanVienKyThuat(String maNVThaoTac) {
		nhanVienKiThuatDao = NhanVienKiThuatDao.getInstance();
		NhanVienKiThuat nhanVienKiThuat = nhanVienKiThuatDao.getNVKiThuatTheoMa(maNVThaoTac);

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cập nhật thông tin nhân viên kỹ thuật");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JLabel lblTngThuTrong_1 = new JLabel("Mã nhân viên:");
		lblTngThuTrong_1.setBounds(41, 76, 126, 30);
		add(lblTngThuTrong_1);
		lblTngThuTrong_1.setForeground(Color.BLACK);
		lblTngThuTrong_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtTenNV = new JTextField(nhanVienKiThuat.getHoTen());
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenNV.setBounds(232, 136, 325, 30);
		add(txtTenNV);
		txtTenNV.setColumns(10);

		btnThem = new JButton("Sửa");
		btnThem.setToolTipText("Thêm nhân viên");
		btnThem.setIcon(new ImageIcon(
				GD_SuaNhanVienKyThuat.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1239, 753, 168, 40);
		add(btnThem);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 817, 1450, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/img/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1450, 133);
		pnlLogo.add(lblLogo);

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setToolTipText("Xóa trắng các trường nhập dữ liệu");
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setBounds(1041, 753, 168, 40);
		add(btnXoaRong);

		btnThoat = new JButton("Thoát");
		btnThoat.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(41, 753, 168, 40);
		add(btnThoat);

		// set ma nhan viene
		lblMaNV = new JLabel(nhanVienKiThuat.getMaNVKiThuat());
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(232, 76, 126, 30);
		add(lblMaNV);

		JLabel lblLNV = new JLabel("Loại nhân viên:");
		lblLNV.setForeground(Color.BLACK);
		lblLNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLNV.setBounds(615, 76, 147, 30);
		add(lblLNV);

		JLabel lblTNV = new JLabel("Tên nhân viên:");
		lblTNV.setForeground(Color.BLACK);
		lblTNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTNV.setBounds(41, 136, 139, 30);
		add(lblTNV);

		JLabel lblGT = new JLabel("Giới tính:");
		lblGT.setForeground(Color.BLACK);
		lblGT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGT.setBounds(615, 136, 147, 30);
		add(lblGT);

		pnlAnh = new JPanel();
		pnlAnh.setBackground(Color.WHITE);
		pnlAnh.setBounds(1082, 79, 325, 301);
		add(pnlAnh);
		pnlAnh.setLayout(null);

		lblAnh = new JLabel("");
		lblAnh.setIcon(new ImageIcon(GD_SuaNhanVienKyThuat.class.getResource("/img/pictures_folder_30px.png")));
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setBounds(0, 0, 325, 301);
		pnlAnh.add(lblAnh);

		// Kiểm tra xem ảnh có null không
		Optional<String> optional = Optional.ofNullable(nhanVienKiThuat.getTenAnh());
		if (!optional.isPresent()) {
			lblAnh.setIcon(new ImageIcon(new ImageIcon("ImgNhanVien/" + nhanVienKiThuat.getTenAnh().trim()).getImage()
					.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		} else {
			if (nhanVienKiThuat.isGioiTinh()) {
				lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png"))
						.getImage().getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			} else {
				lblAnh.setIcon(new ImageIcon(
						new ImageIcon(GD_ThemXeMay.class.getResource("/img/female-student-silhouette.png")).getImage()
								.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			}
		}

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNam.setBackground(Color.WHITE);
		rdbtnNam.setBounds(802, 142, 127, 25);
		add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNu.setBackground(Color.WHITE);
		rdbtnNu.setBounds(933, 142, 127, 25);
		add(rdbtnNu);

		if (nhanVienKiThuat.isGioiTinh() == true)
			rdbtnNam.setSelected(true);
		else
			rdbtnNu.setSelected(false);

		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbtnNu);
		btnG.add(rdbtnNam);

		JLabel lblNS = new JLabel("Ngày sinh:");
		lblNS.setForeground(Color.BLACK);
		lblNS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNS.setBounds(41, 205, 147, 30);
		add(lblNS);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.getCalendarButton().setBackground(Color.WHITE);
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgaySinh.setBounds(232, 205, 325, 30);
		txtNgaySinh.setDate(Calendar.getInstance().getTime());
		add(txtNgaySinh);

		JLabel lblSsss = new JLabel("Số điện thoại:");
		lblSsss.setForeground(Color.BLACK);
		lblSsss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSsss.setBounds(615, 205, 147, 30);
		add(lblSsss);

		// set so dien thoai
		txtSoDienThoai = new JTextField(nhanVienKiThuat.getSoDienThoai());
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(802, 205, 228, 30);
		add(txtSoDienThoai);

		JLabel lblanh = new JLabel("Ảnh:");
		lblanh.setForeground(Color.BLACK);
		lblanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblanh.setBounds(41, 350, 147, 30);
		add(lblanh);

		txtAnh = new JTextField(nhanVienKiThuat.getTenAnh());
		txtAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAnh.setColumns(10);
		txtAnh.setBounds(232, 350, 570, 30);
		add(txtAnh);

		btnChonFile = new JButton("Chọn file");
		btnChonFile.setToolTipText("Quay lại màn hình quản lý nhân viên");
		btnChonFile.setForeground(Color.WHITE);
		btnChonFile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChonFile.setBackground(Color.GRAY);
		btnChonFile.setBounds(862, 350, 168, 30);
		add(btnChonFile);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setForeground(Color.BLACK);
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaCh.setBounds(41, 279, 105, 30);
		add(lblaCh);

		txtDiaChi = new JTextField(nhanVienKiThuat.getDiaChi());
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(232, 279, 798, 30);
		add(txtDiaChi);

		JPanel pnlLoaiNV = new JPanel();
		pnlLoaiNV.setBackground(Color.WHITE);
		pnlLoaiNV.setBounds(12, 407, 1072, 273);
		add(pnlLoaiNV);
		pnlLoaiNV.setLayout(new CardLayout(0, 0));

		pnlNVKyThuat = new JPanel();
		pnlNVKyThuat.setBackground(Color.WHITE);
		pnlLoaiNV.add(pnlNVKyThuat, "name_191649957157600");
		pnlNVKyThuat.setLayout(null);

		JLabel lblSNKN = new JLabel("Số năm kinh nghiệm:");
		lblSNKN.setForeground(Color.BLACK);
		lblSNKN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSNKN.setBounds(29, 13, 189, 30);
		pnlNVKyThuat.add(lblSNKN);

		String soNamKNText = String.valueOf(nhanVienKiThuat.getSoNamKinhNghiem());
		txtNamKinhNghiem = new JTextField(soNamKNText);
		txtNamKinhNghiem.setHorizontalAlignment(SwingConstants.TRAILING);
		txtNamKinhNghiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNamKinhNghiem.setColumns(10);
		txtNamKinhNghiem.setBounds(221, 13, 61, 30);
		pnlNVKyThuat.add(txtNamKinhNghiem);

		JLabel lblNm = new JLabel("năm.");
		lblNm.setForeground(Color.BLACK);
		lblNm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNm.setBounds(294, 13, 55, 30);
		pnlNVKyThuat.add(lblNm);

		JLabel lblBcTh = new JLabel("Bậc thợ:");
		lblBcTh.setForeground(Color.BLACK);
		lblBcTh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBcTh.setBounds(615, 13, 152, 30);
		pnlNVKyThuat.add(lblBcTh);

		cboBacTho = new JComboBox<String>();
		cboBacTho.setBackground(Color.WHITE);
		String[] listBacTho = { "1", "2", "3", "4", "5", "6", "7" };
		cboBacTho.setModel(new DefaultComboBoxModel<String>(listBacTho));
		for (int i = 0; i < listBacTho.length; i++) {
			if (nhanVienKiThuat.getBacTho() == Integer.parseInt(listBacTho[i]))
				cboBacTho.setSelectedIndex(i);
		}
		;
		cboBacTho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboBacTho.setBounds(796, 13, 228, 30);
		pnlNVKyThuat.add(cboBacTho);

		JLabel lblThongBao = new JLabel("Thông báo: Ngày sinh không hợp lệ");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThongBao.setBounds(41, 693, 1043, 30);
		add(lblThongBao);

		JLabel lblLoaiNV = new JLabel("Nhân viên kỹ thuật");
		lblLoaiNV.setForeground(Color.BLACK);
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiNV.setBounds(802, 76, 228, 30);
		add(lblLoaiNV);

		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		btnChonFile.addActionListener(this);
		rdbtnNam.addMouseListener(this);
		rdbtnNu.addMouseListener(this);

	}

	private NhanVienKiThuat getNhanVienKiThuat() {
		String maNV = lblMaNV.getText();
		String tenNV = txtTenNV.getText();
		boolean gioiTinh = false;
		if (rdbtnNam.isSelected())
			gioiTinh = true;
		Date ngaySinh = new Date(txtNgaySinh.getDate().getTime());
		String sdt = txtSoDienThoai.getText();
		String diaChi = txtDiaChi.getText();
		int soNamKN = Integer.parseInt(txtNamKinhNghiem.getText());
		String bacThoText = (String) cboBacTho.getSelectedItem();
		int bacTho = Integer.parseInt(bacThoText);
		String tenAnh = txtAnh.getText();

		NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(maNV, tenNV, ngaySinh, sdt, diaChi, soNamKN, bacTho, true,
				tenAnh, gioiTinh);
		return nhanVienKiThuat;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		
		if (o.equals(rdbtnNam)) {
			lblAnh.setIcon(new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/male-user.png")).getImage()
					.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		}
		if (o.equals(rdbtnNu)) {
			lblAnh.setIcon(
					new ImageIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/female-student-silhouette.png"))
							.getImage().getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
		}

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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnChonFile)) {
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

					String to = f.getAbsolutePath().split("\\.")[1];
					CopyTask task = new CopyTask(f.getAbsolutePath(),
							"ImgNhanVien/" + lblMaNV.getText().trim() + "." + to);

					task.execute();
				}

				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

//				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lblAnh.setText("");
		}
		if (o.equals(btnThoat)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_NhanVien());
			this.validate();
			this.repaint();
		}

		if (o.equals(btnThem)) {
			NhanVienKiThuat nhanVienKiThuat = getNhanVienKiThuat();
			if (validateNVKiThuat(nhanVienKiThuat)) {
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn cập nhật không", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					nhanVienKiThuatDao.capNhatNhanVienKiThuat(nhanVienKiThuat);
					lblMaNV.setText(RandomMa.getMaNgauNhien(TenEntity.NHAN_VIEN_KI_THUAT));
					JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
				}
			}
		}

	}

	private boolean validateNVKiThuat(NhanVienKiThuat nhanVienKiThuat) {
		return true;
	}
}
