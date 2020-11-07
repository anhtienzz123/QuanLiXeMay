package entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

	private String maHoaDon;
	private KhachHang khachHang;
	private NhanVienHanhChinh nhanVienHanhChinh;
	private List<ChiTietHoaDon> chiTietHoaDons;
	private Date ngayLap;

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public HoaDon(String maHoaDon, KhachHang khachHang, NhanVienHanhChinh nhanVienHanhChinh, Date ngayLap) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachHang = khachHang;
		this.nhanVienHanhChinh = nhanVienHanhChinh;
		this.ngayLap = ngayLap;

		this.chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
	}

	public double tinhTongTienHoaDon() {
		double tongTien = 0;

		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {

			tongTien += chiTietHoaDon.tinhTongTien();
		}

		return tongTien;

	}

	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {

		System.out.println(chiTietHoaDon.getXeMay().getMaXeMay());
		for (ChiTietHoaDon ctHoaDon : chiTietHoaDons) {
			
			if (ctHoaDon.getXeMay().getMaXeMay().equalsIgnoreCase(chiTietHoaDon.getXeMay().getMaXeMay())) {
				ctHoaDon.tangSoLuong(chiTietHoaDon.getSoLuong());
				System.out.println("Tim thay");
				return;
			}
		}

		this.chiTietHoaDons.add(chiTietHoaDon);
	}

}
