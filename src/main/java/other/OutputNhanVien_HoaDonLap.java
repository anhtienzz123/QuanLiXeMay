package other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputNhanVien_HoaDonLap {

	private String maNVHanhChinh;
	private String hoTenNV;
	private int soLuong;
	private double tongTien;
}
