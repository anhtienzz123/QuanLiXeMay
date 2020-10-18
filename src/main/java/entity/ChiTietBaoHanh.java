package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietBaoHanh {

	private PhieuBaoHanh phieuBaoHanh;
	private DanhMucBaoHanh danhMucBaoHanh;
	private boolean trangThai;
}
