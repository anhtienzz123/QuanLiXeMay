package entity;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuBaoHanh {

	private String maPhieuBaoHanh;
	private HopDong hopDong;
	private Date ngayBaoHanh;
	private NhanVienKiThuat nhanVienKiThuat;
	private List<ChiTietBaoHanh> chiTietBaoHanhs;
	
	public PhieuBaoHanh(String maPhieuBaoHanh) {
	
		this.maPhieuBaoHanh = maPhieuBaoHanh;
	}
	
}


