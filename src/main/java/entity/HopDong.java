package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

	public HopDong(String maHopDong, HoaDon hoaDon, XeMay xeMay) {
		super();
		this.maHopDong = maHopDong;
		this.hoaDon = hoaDon;
		this.xeMay = xeMay;
	}
	
	public List<Date> tinhThoiGianBaoHanh() {
		Calendar calendar = GregorianCalendar.getInstance();
		System.out.println();
		List<Date> listThoiGianBaoHanh = new ArrayList<Date>(Arrays.asList(hoaDon.getNgayLap()));
		for (int i = 1; i <= 6; i++) {
			calendar.setTime(listThoiGianBaoHanh.get(listThoiGianBaoHanh.size() - 1));
			calendar.add(GregorianCalendar.MONTH, 6);
			listThoiGianBaoHanh.add(calendar.getTime());
		}
		return listThoiGianBaoHanh;
		
	}
	
}
