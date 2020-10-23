package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.quanLyHoaDon.GD_HoaDon;
import ui.quanLyHopDong.GD_HopDong;
import ui.quanLyKhachHang.GD_KhachHang;
import ui.quanLyNhanVien.GD_NhanVien;
import ui.quanLyThongKe.GD_ThongKe;
import ui.quanLyXeMay.GD_XeMay;

public class ChuyenManHinh {
	private JPanel pnlMHChinh;
//	private NhanVien nhanVien;
	private String chonTrang = "";
	private List<DanhMuc> dSTrang = null;

//	public ChuyenManHinh(JPanel pnlMHChinh, NhanVien nhanVien) {
//		this.pnlMHChinh = pnlMHChinh;
//		this.nhanVien = nhanVien;
//	}
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
//				if(nhanVien.getQuyenTruyCap().trim().equals("Admin")) {
//					try {
//						node = new NhanVienJPanel();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					setPanel();
//				}
				node = new GD_NhanVien();
				setPanel();
//				else {
//					JOptionPane.showMessageDialog(null, "Chá»©c nÄƒng nÃ y chá»‰ dÃ nh cho ngÆ°á»�i quáº£n lÃ½");
//				}
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
				pnlChon.setBackground(new Color(76, 175, 80));
				lblChon.setBackground(new Color(96, 100, 191));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!chonTrang.equalsIgnoreCase(chon)) {
				pnlChon.setBackground(new Color(0, 128, 0));
				lblChon.setBackground(new Color(76, 175, 80));
			}
		}
	}

	private void setThayDoiNen(String chon) {
		for (DanhMuc danhMuc : dSTrang) {
			if (danhMuc.getChon().equalsIgnoreCase(chon)) {
				danhMuc.getPnl().setBackground(new Color(96, 100, 191));
				danhMuc.getLbl().setBackground(new Color(96, 100, 191));
			} else {
				danhMuc.getPnl().setBackground(new Color(0, 128, 0));
				danhMuc.getLbl().setBackground(new Color(76, 175, 80));
			}
		}
	}
}
