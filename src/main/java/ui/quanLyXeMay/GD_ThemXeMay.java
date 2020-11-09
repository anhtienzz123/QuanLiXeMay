package ui.quanLyXeMay;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventObject;
import java.util.List;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ui.App;
import ui.ChuyenManHinh;
import ui.DanhMuc;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Insets;

public class GD_ThemXeMay extends JPanel implements ActionListener, MouseListener {
	private JTextField txtTenXe;
	private JButton btnThem;
	private DefaultTableModel modelKhachHang;
	private JButton btnXoaRong;
	private JTextField txtSoLuong;
	private JTextField txtGiaNhap;
	private JTextField txtHeSoBan;
	private JTextField txtBaoHanh;
	private JTextField txtSoKhung;
	private JTextField txtSoSuon;
	private JTextField txtPath;
	private JLabel lblThongBao;
	private JLabel lblThngBo;
	private JButton btnChonFile;
	private JLabel lblAnh;
	private JPanel pnlAnh;
	private JButton btnImport;

	/**
	 * Create the panel.
	 */
	public GD_ThemXeMay() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1450, 950));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 1450, 50);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm xe máy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 1450, 50);
		panel.add(lblNewLabel);

		JLabel lblMaXe = new JLabel("XM123456");
		lblMaXe.setBounds(139, 113, 112, 30);
		add(lblMaXe);
		lblMaXe.setForeground(Color.BLACK);
		lblMaXe.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox cboTimKiem = new JComboBox();
		cboTimKiem.setBackground(Color.WHITE);
		cboTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboTimKiem.setModel(new DefaultComboBoxModel(
				new String[] { "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Số CMT" }));
		cboTimKiem.setBounds(1140, 113, 274, 30);
		add(cboTimKiem);

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
		separator.setBounds(29, 729, 1385, 11);
		add(separator);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(
				new ImageIcon(GD_ThemXeMay.class.getResource("/img/baseline_create_new_folder_white_18dp.png")));
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
		btnXoaRong.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/baseline_clear_all_white_18dp.png")));
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoaRong.setBackground(Color.RED);
		btnXoaRong.setBounds(1041, 753, 168, 40);
		add(btnXoaRong);

		JLabel lblTen = new JLabel("Tên xe:");
		lblTen.setForeground(Color.BLACK);
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTen.setBounds(428, 113, 111, 30);
		add(lblTen);

		JLabel lblHang = new JLabel("Hãng xe:");
		lblHang.setForeground(Color.BLACK);
		lblHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHang.setBounds(960, 113, 111, 30);
		add(lblHang);

		JLabel lblLoai = new JLabel("Loại xe:");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoai.setBounds(29, 174, 111, 30);
		add(lblLoai);

		JComboBox cboLoaiXe = new JComboBox();
		cboLoaiXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboLoaiXe.setBackground(Color.WHITE);
		cboLoaiXe.setBounds(136, 174, 205, 30);
		add(cboLoaiXe);

		JLabel lblDong = new JLabel("Dòng xe:");
		lblDong.setForeground(Color.BLACK);
		lblDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDong.setBounds(428, 174, 111, 30);
		add(lblDong);

		JComboBox cboDongXe = new JComboBox();
		cboDongXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboDongXe.setBackground(Color.WHITE);
		cboDongXe.setBounds(535, 174, 205, 30);
		add(cboDongXe);

		JLabel lblSoPhanKhoi = new JLabel("Số phân khối:");
		lblSoPhanKhoi.setForeground(Color.BLACK);
		lblSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoPhanKhoi.setBounds(960, 174, 171, 30);
		add(lblSoPhanKhoi);

		JComboBox cboSoPhanKhoi = new JComboBox();
		cboSoPhanKhoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboSoPhanKhoi.setBackground(Color.WHITE);
		cboSoPhanKhoi.setBounds(1140, 174, 205, 30);
		add(cboSoPhanKhoi);

		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setForeground(Color.BLACK);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoLuong.setBounds(29, 233, 111, 30);
		add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(136, 233, 73, 30);
		add(txtSoLuong);

		JLabel lblChiec = new JLabel("chiếc xe.");
		lblChiec.setForeground(Color.BLACK);
		lblChiec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiec.setBounds(218, 233, 87, 30);
		add(lblChiec);

		JLabel lblMau = new JLabel("Màu xe:");
		lblMau.setForeground(Color.BLACK);
		lblMau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMau.setBounds(428, 233, 111, 30);
		add(lblMau);

		JComboBox cboMauXe = new JComboBox();
		cboMauXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cboMauXe.setBackground(Color.WHITE);
		cboMauXe.setBounds(535, 233, 205, 30);
		add(cboMauXe);

		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setForeground(Color.BLACK);
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaNhap.setBounds(960, 233, 111, 30);
		add(lblGiaNhap);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(1140, 233, 205, 30);
		add(txtGiaNhap);

		JLabel lblVND = new JLabel("VNĐ.");
		lblVND.setForeground(Color.BLACK);
		lblVND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVND.setBounds(1351, 233, 87, 30);
		add(lblVND);

		JLabel lblHeSoBan = new JLabel("Hệ số bán:");
		lblHeSoBan.setForeground(Color.BLACK);
		lblHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeSoBan.setBounds(777, 293, 111, 30);
		add(lblHeSoBan);

		txtHeSoBan = new JTextField();
		txtHeSoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHeSoBan.setColumns(10);
		txtHeSoBan.setBounds(885, 293, 47, 30);
		add(txtHeSoBan);

		JLabel lblBaoHanh = new JLabel("Bảo hành:");
		lblBaoHanh.setForeground(Color.BLACK);
		lblBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBaoHanh.setBounds(960, 293, 111, 30);
		add(lblBaoHanh);

		txtBaoHanh = new JTextField();
		txtBaoHanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(1140, 293, 55, 30);
		add(txtBaoHanh);

		JLabel lblThang = new JLabel("tháng.");
		lblThang.setForeground(Color.BLACK);
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(1212, 293, 67, 30);
		add(lblThang);

		JLabel lblSoKhung = new JLabel("Số khung:");
		lblSoKhung.setForeground(Color.BLACK);
		lblSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoKhung.setBounds(29, 293, 111, 30);
		add(lblSoKhung);

		txtSoKhung = new JTextField();
		txtSoKhung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoKhung.setColumns(10);
		txtSoKhung.setBounds(136, 293, 205, 30);
		add(txtSoKhung);

		JLabel lblSoSuon = new JLabel("Số sườn:");
		lblSoSuon.setForeground(Color.BLACK);
		lblSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoSuon.setBounds(428, 293, 111, 30);
		add(lblSoSuon);

		txtSoSuon = new JTextField();
		txtSoSuon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoSuon.setColumns(10);
		txtSoSuon.setBounds(535, 293, 205, 30);
		add(txtSoSuon);

		JLabel lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setForeground(Color.BLACK);
		lblMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoTa.setBounds(535, 351, 111, 30);
		add(lblMoTa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(535, 396, 879, 310);
		add(scrollPane);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(txtMoTa);

		JLabel lblA = new JLabel("Ảnh:");
		lblA.setForeground(Color.BLACK);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblA.setBounds(29, 351, 47, 30);
		add(lblA);

		pnlAnh = new JPanel();
		pnlAnh.setBounds(136, 396, 298, 259);
		add(pnlAnh);
		pnlAnh.setLayout(null);

		lblAnh = new JLabel("img");
		lblAnh.setIcon(new ImageIcon(GD_ThemXeMay.class.getResource("/img/pictures_folder_30px.png")));
		lblAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnh.setForeground(new Color(58, 181, 74));
		lblAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnh.setBounds(0, 0, 298, 259);
		pnlAnh.add(lblAnh);

		txtPath = new JTextField();
		txtPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPath.setColumns(10);
		txtPath.setBounds(29, 676, 413, 30);
		add(txtPath);

		btnChonFile = new JButton("chọn file");
		btnChonFile.setForeground(Color.WHITE);
		btnChonFile.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnChonFile.setBackground(Color.GRAY);
		btnChonFile.setBounds(136, 351, 205, 30);
		add(btnChonFile);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(58, 181, 74));
		separator_1.setBounds(29, 89, 1385, 11);
		add(separator_1);

		JLabel lblThongTin = new JLabel("Thông tin xe máy:");
		lblThongTin.setForeground(new Color(58, 181, 74));
		lblThongTin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblThongTin.setBounds(29, 57, 211, 30);
		add(lblThongTin);

		lblThngBo = new JLabel("Thông báo:");
		lblThngBo.setForeground(Color.RED);
		lblThngBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngBo.setBounds(29, 753, 111, 30);
		add(lblThngBo);

		lblThongBao = new JLabel("Số khung không hợp lệ");
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblThongBao.setBounds(139, 753, 377, 30);
		add(lblThongBao);

		btnImport = new JButton("Import file");
		btnImport.setForeground(Color.WHITE);
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnImport.setBackground(Color.GRAY);
		btnImport.setBounds(846, 753, 168, 40);
		add(btnImport);

		dangKiSuKien();

	}

	private void dangKiSuKien() {
		btnThem.addActionListener(this);
		btnChonFile.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnImport.addActionListener(this);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {

		}
		if (o.equals(btnXoaRong)) {
			
		}
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
					txtPath.setText(f.getPath());
					lblAnh.setText("");
				}

				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

//				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnImport)) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter imgFilter = new FileNameExtensionFilter( "xlsx", "xls");
				fileChooser.setFileFilter(imgFilter);
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setPreferredSize(new Dimension(900, 600));
				if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
					File f = fileChooser.getSelectedFile();
					txtPath.setText(f.getPath());
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
}
