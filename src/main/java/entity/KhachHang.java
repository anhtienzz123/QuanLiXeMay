package entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {

	private String maKhachHang;
	private String soCMT;
	private String hoTenKH;
	private Date ngaySinh;
	private String soDienThoai;
	private String diaChiKH;
}
