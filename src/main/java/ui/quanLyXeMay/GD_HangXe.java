package ui.quanLyXeMay;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GD_HangXe extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblMa;
	private JButton btnThoat;
	private JTextField txtTen;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_LoaiXe frame = new GD_LoaiXe();
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
	public GD_HangXe() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GD_LoaiXe.class.getResource("/img/baseline_receipt_long_white_36dp.png")));
		setTitle("Quản lý hãng xe");
		setSize(718, 428);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(58, 181, 74));
		panel.setBounds(0, 0, 708, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý hãng xe");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 0, 708, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_2 = new JLabel("Mã hãng xe:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(23, 65, 129, 30);
		contentPane.add(lblNewLabel_1_2);

		lblMa = new JLabel("LX123456");
		lblMa.setForeground(Color.BLACK);
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMa.setBounds(157, 65, 105, 30);
		contentPane.add(lblMa);

		JLabel lblNewLabel_1_2_5 = new JLabel("Tên hãng xe:");
		lblNewLabel_1_2_5.setForeground(Color.BLACK);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_5.setBounds(294, 65, 136, 30);
		contentPane.add(lblNewLabel_1_2_5);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setIcon(new ImageIcon(GD_LoaiXe.class.getResource("/img/baseline_close_white_24dp.png")));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThoat.setBounds(23, 334, 136, 30);
		contentPane.add(btnThoat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(23, 115, 660, 191);
		contentPane.add(scrollPane);

		String[] colHeader = { "STT", "Mã hãng xe", "Tên hãng xe" };
		model = new DefaultTableModel(colHeader, 0);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, EventObject e) { // Không cho chỉnh sửa giá trị trong table
				return false;
			}
		};
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		scrollPane.setViewportView(table);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTen.setBounds(428, 65, 256, 30);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBackground(new Color(58, 181, 74));
		btnThem.setBounds(547, 334, 136, 30);
		contentPane.add(btnThem);
		
		 btnSua = new JButton("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBackground(new Color(0, 153, 255));
		btnSua.setBounds(370, 334, 136, 30);
		contentPane.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(193, 334, 136, 30);
		contentPane.add(btnXoa);
		

		JTableHeader tableHearder = table.getTableHeader();
		tableHearder.setBackground(new Color(58, 181, 74));
		tableHearder.setForeground(Color.white);
		tableHearder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		for (int i = 1; i < 7; i++) {
			model.addRow(new Object[] { i, null, null });
		}
		
		dangKiSuKien();
	}

	private void dangKiSuKien() {
		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			
		}
		if(o.equals(btnXoa)) {
			
		}
		if(o.equals(btnSua)) {
			
		}
		if(o.equals(btnThoat)) {
			this.setVisible(false);
		}
	}
}
