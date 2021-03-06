package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.NhanVienHanhChinhDao;
import entity.NhanVienHanhChinh;
import ui.HuongDanSuDung.GD_HuongDanSuDung;
import ui.quanLyBaoHanh.GD_QuanLyBaoHanh;
import ui.quanLyHoaDon.GD_HoaDon;
import ui.quanLyHoaDon.GD_LapHoaDon;
import ui.quanLyHopDong.GD_HopDong;
import ui.quanLyKhachHang.GD_KhachHang;
import ui.quanLyKhachHang.GD_ThemKhachHang;
import ui.quanLyNhanVien.GD_NhanVien;
import ui.quanLyNhanVien.GD_ThemNhanVien;
import ui.quanLyThongKe.GD_ThongKeNV;
import ui.quanLyThongKe.GD_ThongKeQL;
import ui.quanLyXeMay.GD_ThemXeMay;
import ui.quanLyXeMay.GD_XeMay;

public class ChuyenManHinh {
	private JPanel pnlMHChinh;
	private String chonTrang = "";
	private List<DanhMuc> dSTrang = null;
	private JPanel pnlMenu;
	private String maNV;
	private NhanVienHanhChinh nhanVienHanhChinh;

	public ChuyenManHinh(JPanel pnlMHChinh, String maNV, JPanel pnlMenu) {
		this.pnlMHChinh = pnlMHChinh;
		this.maNV = maNV;
		this.pnlMenu = pnlMenu;
	}

	public void setManHinh(JPanel pnlChon, JLabel lblChon) {
		chonTrang = "TrangChu";
		pnlChon.setBackground(new Color(96, 100, 191));
		lblChon.setBackground(new Color(96, 100, 191));
		pnlMHChinh.removeAll();
		pnlMHChinh.setLayout(new BorderLayout());
		pnlMHChinh.add(new GD_TrangChu(maNV, pnlMenu));
		pnlMHChinh.validate();
		pnlMHChinh.repaint();
	}

	public void setSuKien(List<DanhMuc> danhMuc) {
		this.dSTrang = danhMuc;
		for (DanhMuc lst : danhMuc) {
			lst.getLbl().addMouseListener(new LabelEvent(lst.getChon(), lst.getPnl(), lst.getLbl()));
		}

	}

	class LabelEvent implements MouseListener {

		private JPanel node;
		private String chon;

		private JPanel pnlChon;
		private JLabel lblChon;

		public LabelEvent(String chon, JPanel pnlChon, JLabel lblChon) {
			this.chon = chon;
			this.pnlChon = pnlChon;
			this.lblChon = lblChon;

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (chon) {
			case "TrangChu":
				node = new GD_TrangChu(maNV, pnlMenu);
				setPanel();

				break;
			case "HoaDon":
				node = new GD_HoaDon(maNV);
				setPanel();

				break;
			case "KhachHang":
				node = new GD_KhachHang();
				setPanel();

				break;
			case "XeMay":
				node = new GD_XeMay();
				setPanel();

				break;
			case "HopDong":
				node = new GD_HopDong();
				setPanel();

				break;
			case "ThongKe":
				nhanVienHanhChinh = NhanVienHanhChinhDao.getInstance().getNVHanhChinhTheoMa(maNV);
				if (nhanVienHanhChinh.isVaiTro()) {
					node = new GD_ThongKeQL();
					setPanel();
				} else {
					node = new GD_ThongKeNV();
					setPanel();
				}

				break;
			case "NhanVien":
				nhanVienHanhChinh = NhanVienHanhChinhDao.getInstance().getNVHanhChinhTheoMa(maNV);
				if (nhanVienHanhChinh.isVaiTro()) {
					node = new GD_NhanVien();
					setPanel();
				} else {
					JOptionPane.showMessageDialog(null, "Chức năng này chỉ dành cho người quản lý");
				}
				
				break;

			case "LapHoaDon":
				node = new GD_LapHoaDon(maNV);
				setPanel();
				break;
			case "ThemKhachHang":
				new GD_ThemKhachHang(null).setVisible(true);
				break;
			case "TroGiup":
				new GD_HuongDanSuDung().setVisible(true);
				break;
			case "ThemXeMay":
				node = new GD_ThemXeMay();
				setPanel();
				break;
			case "ThemNhanVien":
				nhanVienHanhChinh = NhanVienHanhChinhDao.getInstance().getNVHanhChinhTheoMa(maNV);
				if (nhanVienHanhChinh.isVaiTro()) {
					node = new GD_ThemNhanVien();
					setPanel();
				} else {
					JOptionPane.showMessageDialog(null, "Chức năng này chỉ dành cho người quản lý");
				}
				
				break;
			case "BaoHanh":
				node = new GD_QuanLyBaoHanh();
				setPanel();
				break;

			case "DangXuat":
				break;
			default:
				node = new GD_TrangChu(maNV, pnlMenu);

				break;
			}

			setThayDoiNen(chon);
		}

		public void setPanel() {

			if (!chon.equals("DangXuat")) {

				pnlMHChinh.removeAll();
				pnlMHChinh.setLayout(new BorderLayout());
				pnlMHChinh.add(node);
				pnlMHChinh.validate();
				pnlMHChinh.repaint();

				if (pnlMenu.getSize().getWidth() > 120) {
					pnlMenu.setSize(120, pnlMenu.getHeight());
					pnlMenu.setSize(300, pnlMenu.getHeight());
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			chonTrang = chon;
			pnlChon.setBackground(new Color(96, 100, 191));
			lblChon.setBackground(new Color(96, 100, 191));

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!chonTrang.equalsIgnoreCase(chon)) {
				pnlChon.setBackground(new Color(170, 213, 118));
				lblChon.setBackground(new Color(96, 100, 191));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!chonTrang.equalsIgnoreCase(chon)) {
				pnlChon.setBackground(new Color(58, 181, 74));
				lblChon.setBackground(new Color(170, 213, 118));
			}
		}
	}

	private void setThayDoiNen(String chon) {
		for (DanhMuc danhMuc : dSTrang) {
			if (danhMuc.getChon().equalsIgnoreCase(chon)) {
				danhMuc.getPnl().setBackground(new Color(96, 100, 191));
				danhMuc.getLbl().setBackground(new Color(96, 100, 191));
			} else {
				danhMuc.getPnl().setBackground(new Color(58, 181, 74));
				danhMuc.getLbl().setBackground(new Color(76, 175, 80));
			}
		}

	}
}
