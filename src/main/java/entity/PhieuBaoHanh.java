package entity;

import java.sql.Date;

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
	
}
