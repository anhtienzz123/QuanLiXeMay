package entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {

	private String maKhachHang;
	private String soCMT;
	private String hoTenKH;
	private Date ngaySinh;
	private String soDienThoai;
	private String diaChiKH;
	private String email;

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public KhachHang(String maKhachHang, String hoTenKH) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTenKH = hoTenKH;
	}

	public KhachHang(String maKhachHang, String soCMT, String hoTenKH, Date ngaySinh, String soDienThoai,
			String diaChiKH) {
		super();
		this.maKhachHang = maKhachHang;
		this.soCMT = soCMT;
		this.hoTenKH = hoTenKH;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChiKH = diaChiKH;
	}

	@Override
	public boolean equals(Object obj) {

		KhachHang khachHang = (KhachHang) obj;

		if (khachHang.getMaKhachHang().equalsIgnoreCase(maKhachHang) || khachHang.getSoCMT().equalsIgnoreCase(soCMT)
				|| khachHang.getHoTenKH().equalsIgnoreCase(hoTenKH)
				|| khachHang.getSoDienThoai().equalsIgnoreCase(soDienThoai))
			return true;

		return false;
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

}
