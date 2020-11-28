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

	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	@Override
	public boolean equals(Object obj) {
		
		KhachHang khachHang = (KhachHang) obj;
		
		if( khachHang.getMaKhachHang().equalsIgnoreCase(maKhachHang) ||  khachHang.getSoCMT().equalsIgnoreCase(soCMT) || khachHang.getHoTenKH().equalsIgnoreCase(hoTenKH) || khachHang.getSoDienThoai().equalsIgnoreCase(soDienThoai)  )
			return true;
		
		return false;
	}


	@Override
	public int hashCode() {
		
		return super.hashCode();
	}
	

}
