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
}
