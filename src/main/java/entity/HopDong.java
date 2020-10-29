package entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HopDong {

	private String maHopDong;
	private HoaDon hoaDon;
	private XeMay xeMay;
	private List<PhieuBaoHanh> phieuBaoHanhs;

	public HopDong(String maHopDong) {
		
		this.maHopDong = maHopDong;
	}

}
