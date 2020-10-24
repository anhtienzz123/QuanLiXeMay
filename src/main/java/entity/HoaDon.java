package entity;

import java.sql.Date;
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
	
	
	public double tinhTongTienHoaDon() {
		double tongTien = 0;

		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {

			tongTien += chiTietHoaDon.tinhTongTien();
		}

		return tongTien;

	}




	
}
