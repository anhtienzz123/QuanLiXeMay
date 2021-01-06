package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDon {

	private HoaDon hoaDon;
	private XeMay xeMay;
	private double giaBan;
	private int soLuong;

	public double tinhTongTien() {

		return giaBan * soLuong;

	}

	public void tangSoLuong(int soLuong) {
		this.soLuong += soLuong;
	}
}
