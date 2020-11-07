package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.quanLyHoaDon.GD_HoaDon;
import ui.quanLyHoaDon.GD_LapHoaDon;
import ui.quanLyHopDong.GD_HopDong;
import ui.quanLyKhachHang.GD_KhachHang;
import ui.quanLyKhachHang.GD_ThemKhachHang;
import ui.quanLyNhanVien.GD_NhanVien;
import ui.quanLyNhanVien.GD_ThemNhanVien;
import ui.quanLyThongKe.GD_ThongKe;
import ui.quanLyXeMay.GD_ThemXeMay;
import ui.quanLyXeMay.GD_XeMay;

public class ChuyenManHinh {
	private JPanel pnlMHChinh;
	private String chonTrang = "";
	private List<DanhMuc> dSTrang = null;
	private JPanel pnlMenu;
	public ChuyenManHinh(JPanel pnlMHChinh) {
		this.pnlMHChinh = pnlMHChinh;
	}

	public void setManHinh(JPanel pnlChon, JLabel lblChon) {
		chonTrang = "TrangChu";
		pnlChon.setBackground(new Color(96, 100, 191));
		lblChon.setBackground(new Color(96, 100, 191));

		pnlMHChinh.removeAll();
		pnlMHChinh.setLayout(new BorderLayout());
		pnlMHChinh.add(new GD_TrangChu());
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
				node = new GD_TrangChu();
				setPanel();

				break;
			case "HoaDon":
				node = new GD_HoaDon();
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
				node = new GD_ThongKe();
				setPanel();

				break;
			case "NhanVien":
				node = new GD_NhanVien();
				setPanel();
				break;
				
				
			case "LapHoaDon":
				node = new GD_LapHoaDon();
				setPanel();
				break;
			case "ThemKhachHang":
				new GD_ThemKhachHang().setVisible(true);
//				setPanel();
				break;
			case "QuanLyHangXe":
//				node = new GD_NhanVien();
//				setPanel();
				break;
			case "ThemXeMay":
				node = new GD_ThemXeMay();
				setPanel();
				break;
			case "ThemNhanVien":
				node = new GD_ThemNhanVien();
				setPanel();
				break;
			case "DoanhSoTheoNgay":
//				node = new GD_NhanVien();
//				setPanel();
				break;
				
				
				
				
			case "DangXuat":
				break;
			default:
				node = new GD_TrangChu();

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
				setThayDoiKichThuocMenu(pnlMenu);
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

	private void setThayDoiKichThuocMenu(JPanel pnlMenu) {
//		App app = new App();
//		if (pnlMenu.getPreferredSize().width >= 120) {
//			pnlMenu.setPreferredSize(new Dimension(120, 900));
//			app.setPnlMenu(pnlMenu);
//		}
//		System.out.println(pnlMenu.getPreferredSize().width);
	}
}
