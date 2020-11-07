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

}
