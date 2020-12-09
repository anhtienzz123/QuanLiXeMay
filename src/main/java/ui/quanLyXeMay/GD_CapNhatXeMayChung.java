package ui.quanLyXeMay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DongXeDao;
import dao.HangXeDao;
import dao.LoaiXeDao;
import dao.XeMayDao;
import entity.DongXe;
import entity.LoaiXe;
import entity.XeMay;
import other.BatRegex;
import other.CopyTask;
import other.XuLyChung;
import ui.App;

public class GD_CapNhatXeMayChung extends JPanel implements ActionListener, KeyListener, FocusListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtTenXe;
	private JTextField txtGiaNhap;
	private JTextField txtHeSoBan;
	private JTextField txtBaoHanh;
	private JTextField txtPath;

	private JTextArea txtMoTa;
	private JLabel lblAnh;

	private JPanel pnlAnh;
	private JComboBox<String> cboHangXe;
	private JComboBox<String> cboLoaiXe;
	private JComboBox<String> cboDongXe;
	private JComboBox<String> cboSoPhanKhoi;

	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnChonFile;

	private XeMayDao xeMayDao;

	private String filePath;

	private JTextArea txtThongBao;
	private boolean isTenXe = false;
	private boolean isGiaNhap = false;
	private boolean isHeSoBan = false;
	private boolean isBaoHanh = false;

	/**
	 * Create the panel.
	 */
	public GD_CapNhatXeMayChung(XeMay xeMay) {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cập nhật xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		cboHangXe = new JComboBox<String>();
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBounds(139, 174, 272, 30);
		add(cboHangXe);

		txtTenXe = new JTextField();
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenXe.setBounds(136, 113, 744, 30);
		add(txtTenXe);
		txtTenXe.setColumns(10);
		txtTenXe.setText(xeMay.getTenXeMay().trim());

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 770, 1743, 11);
		add(separator);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(
				new ImageIcon(GD_ThemXeMay.class.getResource("/icon/baseline_create_new_folder_white_18dp.png")));
		btnLuu.setForeground(Color.WHITE);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLuu.setBackground(new Color(58, 181, 74));
		btnLuu.setBounds(1604, 805, 168, 40);
		add(btnLuu);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 877, 1800, 133);
		add(pnlLogo);
		pnlLogo.setLayout(null);

		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(new ImageIcon(App.class.getResource("/icon/motorcycle-logo-on-a-green-background2.jpg"))
						.getImage().getScaledInstance(pnlLogo.getPreferredSize().width,
								pnlLogo.getPreferredSize().height, Image.SCALE_DEFAULT)));
		lblLogo.setBounds(0, 0, 1800, 133);
		pnlLogo.add(lblLogo);

		btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon(GD_CapNhatXeMayChung.class.getResource("/icon/baseline_close_white_24dp.png")));
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHuy.setBackground(Color.RED);
		btnHuy.setBounds(1406, 805, 168, 40);
		add(btnHuy);

		JLabel lblTen = new JLabel("Tên xe:");
		lblTen.setForeground(Color.BLACK);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(29, 113, 111, 30);
		add(lblTen);

		JLabel lblHang = new JLabel("Hãng xe:");
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBounds(29, 174, 111, 30);
		add(lblHang);

		JLabel lblLoai = new JLabel("Loại xe:");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoai.setBounds(544, 174, 111, 30);
		add(lblLoai);

		cboLoaiXe = new JComboBox<String>();
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(641, 174, 239, 30);
		add(cboLoaiXe);

		JLabel lblDong = new JLabel("Dòng xe:");
		lblDong.setForeground(Color.BLACK);
		lblDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDong.setBounds(29, 233, 111, 30);
		add(lblDong);

		cboDongXe = new JComboBox<String>();
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(139, 233, 272, 30);
		add(cboDongXe);

		JLabel lblSoPhanKhoi = new JLabel("Số phân khối:");
		lblSoPhanKhoi.setForeground(Color.BLACK);
		lblSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoPhanKhoi.setBounds(544, 233, 139, 30);
		add(lblSoPhanKhoi);

		cboSoPhanKhoi = new JComboBox<String>();
		cboSoPhanKhoi.setModel(
				new DefaultComboBoxModel<String>(new String[] { "50 cc", "110 cc", "125 cc", "150 cc", "175 cc" }));
		cboSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboSoPhanKhoi.setBackground(Color.WHITE);
		cboSoPhanKhoi.setBounds(684, 233, 111, 30);
		add(cboSoPhanKhoi);
		cboSoPhanKhoi.setSelectedItem(xeMay.getSoPhanKhoi() + " cc");

		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setForeground(Color.BLACK);
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(29, 287, 111, 30);
		add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(139, 287, 272, 30);
		add(txtGiaNhap);
		DecimalFormat df = new DecimalFormat("###.##");
		txtGiaNhap.setText(df.format(xeMay.getGiaNhap()));

		JLabel lblVND = new JLabel("VNĐ.");
		lblVND.setForeground(Color.BLACK);
		lblVND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVND.setBounds(415, 287, 87, 30);
		add(lblVND);

		JLabel lblHeSoBan = new JLabel("Hệ số bán:");
		lblHeSoBan.setForeground(Color.BLACK);
		lblHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeSoBan.setBounds(544, 287, 111, 30);
		add(lblHeSoBan);

		txtHeSoBan = new JTextField();
		txtHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHeSoBan.setColumns(10);
		txtHeSoBan.setBounds(684, 287, 67, 30);
		add(txtHeSoBan);
		txtHeSoBan.setText(xeMay.getHeSoBan() + "");

		JLabel lblBaoHanh = new JLabel("Bảo hành:");
		lblBaoHanh.setForeground(Color.BLACK);
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(29, 341, 111, 30);
		add(lblBaoHanh);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(136, 341, 55, 30);
		add(txtBaoHanh);
		txtBaoHanh.setText(xeMay.getThoiGianBaoHanh() + "");

		JLabel lblThang = new JLabel("tháng.");
		lblThang.setForeground(Color.BLACK);
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(203, 341, 67, 30);
		add(lblThang);

		JLabel lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setForeground(Color.BLACK);
		lblMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoTa.setBounds(29, 408, 111, 30);
		add(lblMoTa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 408, 741, 332);
		add(scrollPane);

		txtMoTa = new JTextArea();
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(txtMoTa);
		txtMoTa.setText(xeMay.getMoTa());
		txtMoTa.setLineWrap(true);
		txtMoTa.setWrapStyleWord(true);

		JLabel lblA = new JLabel("Ảnh:");
		lblA.setForeground(Color.BLACK);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblA.setBounds(960, 710, 47, 30);
		add(lblA);

		pnlAnh = new JPanel();
		pnlAnh.setBounds(960, 113, 812, 565);
		add(pnlAnh);
		pnlAnh.setLayout(null);

		lblAnh = new JLabel("img");
		String anh = xeMay.getTenAnh();

		// Kiểm tra xem ảnh có null không
		Optional<String> optional = Optional.ofNullable(xeMay.getTenAnh());
		if (!optional.isPresent()) {
			lblAnh.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/pictures_folder_30px.png")));
			lblAnh.setText("img");
		} else {
			lblAnh.setIcon(new ImageIcon(new ImageIcon("ImgXe/" + anh).getImage().getScaledInstance(pnlAnh.getWidth(),
					pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
			lblAnh.setText("");
		}

		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnh.setBounds(0, 0, 812, 565);
		pnlAnh.add(lblAnh);

		txtPath = new JTextField();
		txtPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPath.setColumns(10);
		txtPath.setBounds(1029, 710, 545, 30);
		add(txtPath);
		txtPath.setText(anh);

		btnChonFile = new JButton("chọn ảnh");
		btnChonFile.setIcon(new ImageIcon(GD_CapNhatXeMayChung.class.getResource("/icon/opened_folder_26px.png")));
		btnChonFile.setForeground(Color.WHITE);
		btnChonFile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChonFile.setBackground(Color.GRAY);
		btnChonFile.setBounds(1604, 710, 168, 30);
		add(btnChonFile);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(29, 89, 1743, 11);
		add(separator_1);

		JLabel lblThongTin = new JLabel("Thông tin xe máy:");
		lblThongTin.setForeground(new Color(58, 181, 74));
		lblThongTin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblThongTin.setBounds(29, 57, 211, 30);
		add(lblThongTin);

		dangKiSuKien();
		xeMayDao = XeMayDao.getInstance();
		loadDuLieuVaoCombobox();

		cboHangXe.setSelectedItem(xeMay.getDongXe().getHangXe().getTenHangXe());
		cboLoaiXe.setSelectedItem(xeMay.getLoaiXe().getTenLoaiXe());
		cboDongXe.setSelectedItem(xeMay.getDongXe().getTenDongXe());

		txtThongBao = new JTextArea();
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtThongBao.setBounds(29, 773, 630, 101);
		add(txtThongBao);
		
		JLabel lblHeSoBan_1 = new JLabel("%");
		lblHeSoBan_1.setForeground(Color.BLACK);
		lblHeSoBan_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeSoBan_1.setBounds(763, 287, 47, 30);
		add(lblHeSoBan_1);

	}

	private void dangKiSuKien() {
		btnLuu.addActionListener(this);
		btnChonFile.addActionListener(this);
		btnHuy.addActionListener(this);

		txtTenXe.addKeyListener(this);
		txtGiaNhap.addKeyListener(this);
		txtHeSoBan.addKeyListener(this);
		txtBaoHanh.addKeyListener(this);
		txtPath.addKeyListener(this);

		txtTenXe.addFocusListener(this);
		txtGiaNhap.addFocusListener(this);
		txtHeSoBan.addFocusListener(this);
		txtBaoHanh.addFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			luuXe();
		}
		if (o.equals(btnHuy)) {
			this.removeAll();
			this.setLayout(new BorderLayout());
			this.add(new GD_XeMay());
			this.validate();
			this.repaint();
		}
		if (o.equals(btnChonFile)) {
			chonAnh();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if (o.equals(txtTenXe)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtGiaNhap.requestFocus();
			}
		}
		if (o.equals(txtHeSoBan)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtBaoHanh.requestFocus();
			}
		}
		if (o.equals(txtBaoHanh)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtPath.requestFocus();
			}
		}
		if (o.equals(txtPath)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtMoTa.requestFocus();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Load dữ liệu từ database vào combobox
	 */
	private void loadDuLieuVaoCombobox() {

		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		HangXeDao hangXeDao = HangXeDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();
		cboLoaiXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				loaiXeDao.getLoaiXes().stream().map(s -> s.getTenLoaiXe()).collect(Collectors.toList()))));
		cboHangXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				hangXeDao.getHangXes().stream().map(s -> s.getTenHangXe()).collect(Collectors.toList()))));
		cboDongXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				dongXeDao.getDongXes().stream().map(s -> s.getTenDongXe()).collect(Collectors.toList()))));


	}

	/**
	 * Lưu xe
	 */
	private void luuXe() {

		if (txtPath.getText().trim().contains("\\")) {
			String fileNameExtentions = filePath.split("\\.")[1];
			CopyTask task = new CopyTask(filePath, "ImgXe/" + txtTenXe.getText().trim() + "." + fileNameExtentions);
			task.execute();
		}

		String tenLoaiXe = cboLoaiXe.getSelectedItem().toString().trim();
		String tenDongXe = cboDongXe.getSelectedItem().toString().trim();
		String soPhanKhoi = cboSoPhanKhoi.getSelectedItem().toString().trim().split(" ")[0];

		String path = txtPath.getText().trim();
		String tenAnh = null;
		if (!path.equals("")) {
			tenAnh = txtTenXe.getText().trim() + "." + path.split("\\.")[1];
		}

		LoaiXe loaiXe = LoaiXeDao.getInstance().getLoaiXeTheoTen(tenLoaiXe);
		DongXe dongXe = DongXeDao.getInstance().getDongXeTheoTen(tenDongXe);
		XeMay xeMay = new XeMay();

		xeMay.setTenXeMay(txtTenXe.getText().trim());
		xeMay.setGiaNhap(Double.parseDouble(txtGiaNhap.getText().trim()));
		xeMay.setHeSoBan(Double.parseDouble(txtHeSoBan.getText().trim()));
		xeMay.setThoiGianBaoHanh(Integer.parseInt(txtBaoHanh.getText().trim()));
		xeMay.setSoPhanKhoi(Integer.parseInt(soPhanKhoi));
		xeMay.setLoaiXe(loaiXe);
		xeMay.setDongXe(dongXe);
		xeMay.setMoTa(txtMoTa.getText().trim());

		xeMay.setTenAnh(tenAnh);

		if (validateXeMay(xeMay)) {
			if (xeMayDao.capNhatXeMay(xeMay))
				JOptionPane.showMessageDialog(this, "Lưu thành công");
			else
				JOptionPane.showMessageDialog(this, "Lưu không thành công");

		} else {
			isTenXe = true;
			isGiaNhap = true;
			isHeSoBan = true;
			isBaoHanh = true;
			capNhatThongBaoLoi();
		}

	}

	/**
	 * Chọn ảnh
	 */
	private void chonAnh() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFileChooser fileChooser = new JFileChooser();
//			Định dạng file ảnh cho chương trình
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpg", "png", "jpg");
			fileChooser.setFileFilter(imgFilter);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.setPreferredSize(new Dimension(900, 600));
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				lblAnh.setIcon(new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage()
						.getScaledInstance(pnlAnh.getWidth(), pnlAnh.getHeight(), Image.SCALE_DEFAULT)));
				txtPath.setText(f.getPath());
				lblAnh.setText("");

				filePath = f.getAbsolutePath();

			}

			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private boolean validateXeMay(XeMay xeMay) {

		if (BatRegex.kiemTraTenXe(txtTenXe) && BatRegex.kiemTraGiaNhap(txtGiaNhap)
				&& BatRegex.kiemTraHeSoBan(txtHeSoBan) && BatRegex.kiemTraHeSoBan(txtBaoHanh))
			return true;

		return false;

	}

	private void capNhatThongBaoLoi() {

		txtThongBao.setText("");

		if (!BatRegex.kiemTraTenXe(txtTenXe) && isTenXe)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.TEN_XE + "\n");
		if (!BatRegex.kiemTraGiaNhap(txtGiaNhap) && isGiaNhap)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.GIA_NHAP + "\n");
		if (!BatRegex.kiemTraHeSoBan(txtHeSoBan) && isHeSoBan)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.HE_SO_BAN + "\n");
		if (!BatRegex.kiemTraBaoHanh(txtBaoHanh) && isBaoHanh)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.BAO_HANH + "\n");

	}

	@Override
	public void focusGained(FocusEvent e) {
		Object source = e.getSource();

		if (source.equals(txtTenXe))
			isTenXe = true;
		if (source.equals(txtGiaNhap))
			isGiaNhap = true;
		if (source.equals(txtHeSoBan))
			isHeSoBan = true;
		if (source.equals(txtBaoHanh))
			isBaoHanh = true;
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
}
