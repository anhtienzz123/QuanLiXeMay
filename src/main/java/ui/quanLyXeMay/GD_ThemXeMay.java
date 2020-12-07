package ui.quanLyXeMay;

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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
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

import constant.TenEntity;
import dao.DongXeDao;
import dao.HangXeDao;
import dao.LoaiXeDao;
import dao.XeMayDao;
import dao.XuatXuDao;
import entity.DongXe;
import entity.LoaiXe;
import entity.XeMay;
import entity.XuatXu;
import other.BatRegex;
import other.CopyTask;
import other.ImportExcelFile;
import other.RandomMa;
import other.RandomThongTin;
import other.XuLyChung;
import ui.App;

public class GD_ThemXeMay extends JPanel implements ActionListener, KeyListener, FocusListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtTenXe;
	private JTextField txtSoLuong;
	private JTextField txtGiaNhap;
	private JTextField txtHeSoBan;
	private JTextField txtBaoHanh;
	private JTextField txtSoKhung;
	private JTextField txtSoSuon;
	private JTextField txtPath;

	private JTextArea txtMoTa;
	private JLabel lblAnh;
	private JLabel lblMaXe;

	private JPanel pnlAnh;

	private JComboBox<String> cboMauXe;
	private JComboBox<String> cboHangXe;
	private JComboBox<String> cboLoaiXe;
	private JComboBox<String> cboDongXe;
	private JComboBox<String> cboSoPhanKhoi;
	private JComboBox<String> cboXuatXu;

	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnImport;
	private JButton btnChonFile;

	private XeMayDao xeMayDao;

	private String filePath;

	private JTextArea txtThongBao;

	private boolean isTenXe = false;
	private boolean isSoLuong = false;
	private boolean isGiaNhap = false;
	private boolean isSoKhung = false;
	private boolean isSoSuon = false;
	private boolean isHeSoBan = false;
	private boolean isBaoHanh = false;

	/**
	 * Create the panel.
	 */
	public GD_ThemXeMay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1800, 1010));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1800, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1800, 50);
		panel.add(lblNewLabel);

		lblMaXe = new JLabel("XM123456");
		lblMaXe.setBounds(139, 113, 112, 30);
		add(lblMaXe);
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));

		cboHangXe = new JComboBox<String>();
		cboHangXe.setBackground(Color.WHITE);
		cboHangXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboHangXe.setBounds(139, 174, 202, 30);
		add(cboHangXe);

		txtTenXe = new JTextField();
		txtTenXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenXe.setBounds(535, 113, 345, 30);
		add(txtTenXe);
		txtTenXe.setColumns(10);

		JLabel lblMa = new JLabel("Mã xe:");
		lblMa.setForeground(Color.BLACK);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(29, 113, 111, 30);
		add(lblMa);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(58, 181, 74));
		separator.setBounds(29, 763, 1743, 11);
		add(separator);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon(GD_ThemXeMay.class.getResource("/icon/baseline_create_new_folder_white_18dp.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(1604, 805, 168, 40);
		add(btnThem);

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

		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setBounds(1182, 805, 168, 40);
		add(btnXoaRong);

		JLabel lblTen = new JLabel("Tên xe:");
		lblTen.setForeground(Color.BLACK);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(428, 113, 111, 30);
		add(lblTen);

		JLabel lblHang = new JLabel("Hãng xe:");
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBounds(29, 174, 111, 30);
		add(lblHang);

		JLabel lblLoai = new JLabel("Loại xe:");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoai.setBounds(428, 174, 111, 30);
		add(lblLoai);

		cboLoaiXe = new JComboBox<String>();
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(535, 174, 205, 30);
		add(cboLoaiXe);

		JLabel lblDong = new JLabel("Dòng xe:");
		lblDong.setForeground(Color.BLACK);
		lblDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDong.setBounds(29, 233, 111, 30);
		add(lblDong);

		cboDongXe = new JComboBox<String>();
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(136, 233, 205, 30);
		add(cboDongXe);

		JLabel lblSoPhanKhoi = new JLabel("Số phân khối:");
		lblSoPhanKhoi.setForeground(Color.BLACK);
		lblSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoPhanKhoi.setBounds(29, 293, 139, 30);
		add(lblSoPhanKhoi);

		cboSoPhanKhoi = new JComboBox<String>();
		cboSoPhanKhoi.setModel(
				new DefaultComboBoxModel<String>(new String[] { "50 cc", "110 cc", "125 cc", "150 cc", "175 cc" }));
		cboSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboSoPhanKhoi.setBackground(Color.WHITE);
		cboSoPhanKhoi.setBounds(209, 293, 132, 30);
		add(cboSoPhanKhoi);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setForeground(Color.BLACK);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(29, 353, 111, 30);
		add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setText("1");
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(136, 353, 73, 30);
		txtSoLuong.setEditable(false);
		add(txtSoLuong);

		JLabel lblChiec = new JLabel("chiếc xe.");
		lblChiec.setForeground(Color.BLACK);
		lblChiec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiec.setBounds(218, 353, 87, 30);
		add(lblChiec);

		JLabel lblMau = new JLabel("Màu xe:");
		lblMau.setForeground(Color.BLACK);
		lblMau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMau.setBounds(428, 293, 111, 30);
		add(lblMau);

		cboMauXe = new JComboBox<String>();
		cboMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMauXe.setBackground(Color.WHITE);
		cboMauXe.setBounds(535, 293, 205, 30);
		cboMauXe.addItem("Đỏ");
		cboMauXe.addItem("Đen");
		cboMauXe.addItem("Xanh dương");
		cboMauXe.addItem("Đỏ-đen");
		cboMauXe.addItem("Vàng");
		cboMauXe.addItem("Trắng");
		cboMauXe.addItem("Xanh lá");
		add(cboMauXe);

		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setForeground(Color.BLACK);
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(428, 353, 111, 30);
		add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(541, 353, 199, 30);
		add(txtGiaNhap);

		JLabel lblVND = new JLabel("VNĐ.");
		lblVND.setForeground(Color.BLACK);
		lblVND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVND.setBounds(752, 353, 87, 30);
		add(lblVND);

		JLabel lblHeSoBan = new JLabel("Hệ số bán:");
		lblHeSoBan.setForeground(Color.BLACK);
		lblHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeSoBan.setBounds(29, 464, 111, 30);
		add(lblHeSoBan);

		txtHeSoBan = new JTextField("2");
		txtHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHeSoBan.setColumns(10);
		txtHeSoBan.setBounds(137, 464, 47, 30);
		add(txtHeSoBan);

		JLabel lblBaoHanh = new JLabel("Bảo hành:");
		lblBaoHanh.setForeground(Color.BLACK);
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(428, 464, 111, 30);
		add(lblBaoHanh);

		txtBaoHanh = new JTextField("36");
		txtBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(541, 464, 55, 30);
		add(txtBaoHanh);

		JLabel lblThang = new JLabel("tháng.");
		lblThang.setForeground(Color.BLACK);
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(608, 464, 67, 30);
		add(lblThang);

		JLabel lblSoKhung = new JLabel("Số khung:");
		lblSoKhung.setForeground(Color.BLACK);
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoKhung.setBounds(29, 409, 111, 30);
		add(lblSoKhung);

		txtSoKhung = new JTextField();
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(136, 409, 205, 30);
		add(txtSoKhung);

		JLabel lblSoSuon = new JLabel("Số sườn:");
		lblSoSuon.setForeground(Color.BLACK);
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoSuon.setBounds(428, 409, 111, 30);
		add(lblSoSuon);

		txtSoSuon = new JTextField();
		txtSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoSuon.setColumns(10);
		txtSoSuon.setBounds(541, 409, 199, 30);
		add(txtSoSuon);

		JLabel lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setForeground(Color.BLACK);
		lblMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoTa.setBounds(29, 521, 111, 30);
		add(lblMoTa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 525, 741, 215);
		add(scrollPane);

		txtMoTa = new JTextArea();
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMoTa.setLineWrap(true);
		txtMoTa.setWrapStyleWord(true);
		scrollPane.setViewportView(txtMoTa);

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
		lblAnh.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/pictures_folder_30px.png")));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnh.setBounds(0, 0, 812, 565);
		pnlAnh.add(lblAnh);

		txtPath = new JTextField();
		txtPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPath.setColumns(10);
		txtPath.setBounds(1029, 710, 546, 30);
		add(txtPath);

		btnChonFile = new JButton("chọn ảnh");
		btnChonFile.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/opened_folder_26px.png")));
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

		btnImport = new JButton("Import file");
		btnImport.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/microsoft_excel_32px.png")));
		btnImport.setForeground(Color.WHITE);
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnImport.setBackground(Color.GRAY);
		btnImport.setBounds(1388, 805, 187, 40);
		add(btnImport);

		JLabel lblXutX = new JLabel("Xuất xứ:");
		lblXutX.setForeground(Color.BLACK);
		lblXutX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblXutX.setBounds(428, 233, 111, 30);
		add(lblXutX);

		cboXuatXu = new JComboBox<String>();
		cboXuatXu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboXuatXu.setBackground(Color.WHITE);
		cboXuatXu.setBounds(535, 233, 205, 30);
		add(cboXuatXu);

		dangKiSuKien();
		lblMaXe.setText(RandomMa.getMaNgauNhien(TenEntity.XE_MAY));
		xeMayDao = XeMayDao.getInstance();
		loadDuLieuVaoCombobox();
		cboHangXe.setSelectedItem("Honda");
		cboDongXe.setSelectedItem("Wave");
		cboLoaiXe.setSelectedItem("Xe số");
		cboSoPhanKhoi.setSelectedItem("110 cc");
		cboXuatXu.setSelectedItem("Việt Nam");

		txtSoSuon.setText(RandomThongTin.randomSoSuon());
		txtSoKhung.setText(RandomThongTin.randomSoKhungXeMay());

		txtThongBao = new JTextArea();
		txtThongBao.setEditable(false);
		txtThongBao.setForeground(Color.RED);
		txtThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		txtThongBao.setBounds(29, 769, 680, 107);
		add(txtThongBao);

	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnChonFile.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnImport.addActionListener(this);

		txtTenXe.addKeyListener(this);
		txtGiaNhap.addKeyListener(this);
		txtSoLuong.addKeyListener(this);
		txtSoKhung.addKeyListener(this);
		txtSoSuon.addKeyListener(this);
		txtHeSoBan.addKeyListener(this);
		txtBaoHanh.addKeyListener(this);
		txtPath.addKeyListener(this);

		cboMauXe.addActionListener(this);

		txtTenXe.addFocusListener(this);
		txtSoLuong.addFocusListener(this);
		txtGiaNhap.addFocusListener(this);
		txtSoKhung.addFocusListener(this);
		txtSoSuon.addFocusListener(this);
		txtHeSoBan.addFocusListener(this);
		txtBaoHanh.addFocusListener(this);
		
		txtSoLuong.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			themXe();
		}
		if (o.equals(btnXoaRong)) {
			xoaRong();
		}
		if (o.equals(btnChonFile)) {
			chonAnh();
		}
		if (o.equals(btnImport)) {
			importFileExcel();
		}
		if (o.equals(cboMauXe)) {
			if (cboMauXe.getSelectedItem() == "Khác") {
				String mau = JOptionPane.showInputDialog("Nhập màu xe: ").trim();
				if (!mau.equals("")) {
					cboMauXe.removeItem("Khác");
					cboMauXe.addItem(mau);
					cboMauXe.addItem("Khác");
					cboMauXe.setSelectedItem(mau);
				}
			}
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
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtGiaNhap.requestFocus();
			}
		}
		if(o.equals(txtSoLuong)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//				int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
//				if( soLuong > 1) {
//					for(int i = 1; i <= soLuong; i++) {
//						
//					}
//				}
				txtGiaNhap.requestFocus();
				txtSoLuong.setEditable(false);
			}
		}
		
		if (o.equals(txtGiaNhap)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtSoKhung.requestFocus();
			}
		}
		if (o.equals(txtSoLuong)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtGiaNhap.requestFocus();
			}
		}
		if (o.equals(txtSoKhung)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtSoSuon.requestFocus();
			}
		}
		if (o.equals(txtSoSuon)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtHeSoBan.requestFocus();
			}
		}
		if (o.equals(txtHeSoBan)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtBaoHanh.requestFocus();
			}
		}
		if (o.equals(txtBaoHanh)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtMoTa.requestFocus();
			}
		}
		if (o.equals(txtMoTa)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtPath.requestFocus();
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

		XuatXuDao xuatXuDao = XuatXuDao.getInstance();
		LoaiXeDao loaiXeDao = LoaiXeDao.getInstance();
		HangXeDao hangXeDao = HangXeDao.getInstance();
		DongXeDao dongXeDao = DongXeDao.getInstance();

		cboXuatXu.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				xuatXuDao.getXuatXus().stream().map(s -> s.getTenXuatXu()).collect(Collectors.toList()))));
		cboLoaiXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				loaiXeDao.getLoaiXes().stream().map(s -> s.getTenLoaiXe()).collect(Collectors.toList()))));
		cboHangXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				hangXeDao.getHangXes().stream().map(s -> s.getTenHangXe()).collect(Collectors.toList()))));
		cboDongXe.setModel(new DefaultComboBoxModel<String>(XuLyChung.doiListThanhArrayThemXe(
				dongXeDao.getDongXes().stream().map(s -> s.getTenDongXe()).collect(Collectors.toList()))));

		for (String mauXe : xeMayDao.getMauXes()) {
			cboMauXe.addItem(mauXe);
		}
		cboMauXe.addItem("Khác");

	}

	/**
	 * Thêm xe
	 */
	private void themXe() {

		if (txtPath.getText().trim().contains("\\")) {
			String fileNameExtentions = filePath.split("\\.")[1];
			CopyTask task = new CopyTask(filePath, "ImgXe/" + lblMaXe.getText().trim() + "." + fileNameExtentions);
			task.execute();
		}

		String tenXuatXu = cboXuatXu.getSelectedItem().toString().trim();
		String tenLoaiXe = cboLoaiXe.getSelectedItem().toString().trim();
		String tenDongXe = cboDongXe.getSelectedItem().toString().trim();
		String tenMauXe = cboMauXe.getSelectedItem().toString().trim();
		String soPhanKhoi = cboSoPhanKhoi.getSelectedItem().toString().trim().split(" ")[0];

		String path = txtPath.getText().trim();
		String tenAnh = null;
		if (!path.equals("")) {
			tenAnh = lblMaXe.getText().trim() + "." + path.split("\\.")[1];
		}

		XuatXu xuatXu = XuatXuDao.getInstance().getXuatXuTheoTen(tenXuatXu);
		LoaiXe loaiXe = LoaiXeDao.getInstance().getLoaiXeTheoTen(tenLoaiXe);
		DongXe dongXe = DongXeDao.getInstance().getDongXeTheoTen(tenDongXe);
		XeMay xeMay = new XeMay();

		xeMay.setMaXeMay(lblMaXe.getText().trim());
		xeMay.setTenXeMay(txtTenXe.getText().trim());
		xeMay.setTenAnh(txtPath.getText().trim());
		xeMay.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
		xeMay.setGiaNhap(Double.parseDouble(txtGiaNhap.getText().trim()));
		xeMay.setHeSoBan(Double.parseDouble(txtHeSoBan.getText().trim()));
		xeMay.setThoiGianBaoHanh(Integer.parseInt(txtBaoHanh.getText().trim()));
		xeMay.setSoKhung(txtSoKhung.getText().trim());
		xeMay.setSoPhanKhoi(Integer.parseInt(soPhanKhoi));
		xeMay.setSoSuon(txtSoSuon.getText().trim());
		xeMay.setMauXe(tenMauXe);
		xeMay.setLoaiXe(loaiXe);
		xeMay.setDongXe(dongXe);
		xeMay.setXuatXu(xuatXu);
		xeMay.setMoTa(txtMoTa.getText().trim());

		xeMay.setTenAnh(tenAnh);

		if (validateXeMay(xeMay)) {
			if (xeMayDao.themXeMay(xeMay)) {
				JOptionPane.showMessageDialog(this, "Thêm xe máy thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Thêm xe máy không thành công");
			}
		} else {
			isTenXe = true;
			isGiaNhap = true;
			isSoLuong = true;
			isSoKhung = true;
			isSoSuon = true;
			isHeSoBan = true;
			isBaoHanh = true;
			capNhatThongBaoLoi();
		}

	}

	/**
	 * Xóa rỗng
	 */
	private void xoaRong() {
		lblMaXe.setText(RandomMa.getMaNgauNhien(TenEntity.XE_MAY));
		txtTenXe.setText("");
		cboHangXe.setSelectedItem("Honda");
		cboDongXe.setSelectedItem("Wave");
		cboLoaiXe.setSelectedItem("Xe số");
		cboSoPhanKhoi.setSelectedItem("110 cc");
		cboXuatXu.setSelectedItem("Việt Nam");
		cboMauXe.setSelectedIndex(0);
		txtGiaNhap.setText("");
		txtSoLuong.setText("");
//		txtSoKhung.setText("");
		txtSoKhung.setText(RandomThongTin.randomSoKhungXeMay());
//		txtSoSuon.setText("");
		txtSoSuon.setText(RandomThongTin.randomSoSuon());
		txtHeSoBan.setText("2");
		txtBaoHanh.setText("36");
		txtPath.setText("");
		txtMoTa.setText("");
		lblAnh.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/icon/pictures_folder_30px.png")));
		lblAnh.setText("img");

	}

	/**
	 * Chọn ảnh
	 */
	private void chonAnh() {
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

	/**
	 * Import file excel
	 */
	private void importFileExcel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("xlsm", "xlsx", "xls");
			fileChooser.setFileFilter(imgFilter);
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.setPreferredSize(new Dimension(900, 600));
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				txtPath.setText(f.getPath());
				new ImportExcelFile();
				try {
					List<XeMay> listXeMay = ImportExcelFile.readExcel(f.getPath());
					for (XeMay xeMay : listXeMay) {
						xeMayDao.themXeMay(xeMay);
					}
					JOptionPane.showMessageDialog(this, "Xong!!!!!!!!!!");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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

		if (BatRegex.kiemTraTenXe(txtTenXe) && BatRegex.kiemTraSoLuong(txtSoLuong)
				&& BatRegex.kiemTraGiaNhap(txtGiaNhap) && BatRegex.kiemTraSoKhung(txtSoKhung)
				&& BatRegex.kiemTraSoSuon(txtSoSuon) && BatRegex.kiemTraHeSoBan(txtHeSoBan)
				&& BatRegex.kiemTraHeSoBan(txtBaoHanh))
			return true;

		return false;

	}

	private void capNhatThongBaoLoi() {

		txtThongBao.setText("");

		if (!BatRegex.kiemTraTenXe(txtTenXe) && isTenXe)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.TEN_XE + "\n");
		if (!BatRegex.kiemTraSoLuong(txtSoLuong) && isSoLuong)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.SO_LUONG + "\n");
		if (!BatRegex.kiemTraGiaNhap(txtGiaNhap) && isGiaNhap)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.GIA_NHAP + "\n");
		if (!BatRegex.kiemTraSoKhung(txtSoKhung) && isSoKhung)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.SO_KHUNG + "\n");
		if (!BatRegex.kiemTraSoSuon(txtSoSuon) && isSoSuon)
			txtThongBao.setText(txtThongBao.getText() + BatRegex.SO_SUON + "\n");
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

		if (source.equals(txtSoLuong))
			isSoLuong = true;

		if (source.equals(txtGiaNhap))
			isGiaNhap = true;
		if (source.equals(txtSoKhung))
			isSoKhung = true;
		if (source.equals(txtSoSuon))
			isSoSuon = true;
		if (source.equals(txtHeSoBan))
			isHeSoBan = true;
		if (source.equals(txtBaoHanh))
			isBaoHanh = true;

	}

	@Override
	public void focusLost(FocusEvent e) {
		capNhatThongBaoLoi();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			if(!txtSoLuong.isEditable())
				txtSoLuong.setEditable(true);
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
}
