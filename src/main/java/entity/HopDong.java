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
		super();
		this.maHopDong = maHopDong;
	}

	public HopDong(String maHopDong, HoaDon hoaDon, XeMay xeMay) {
		super();
		this.maHopDong = maHopDong;
		this.hoaDon = hoaDon;
		this.xeMay = xeMay;
	}
	
	

}
