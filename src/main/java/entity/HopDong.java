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


	public List<Date> getThoiGianBaoHanhDinhKis() {

		List<Date> ketQua = new ArrayList<Date>();

		Calendar ngayLapHopDong = Calendar.getInstance();
		ngayLapHopDong.setTime(hoaDon.getNgayLap());
		for (int i = 0; i < 6; i++) {
			ngayLapHopDong.add(Calendar.MONTH, 6);

			int ngay = ngayLapHopDong.get(Calendar.DAY_OF_MONTH);
			int thang = ngayLapHopDong.get(Calendar.MONTH);
			int nam = ngayLapHopDong.get(Calendar.YEAR);

			@SuppressWarnings("deprecation")
			Date temp = new Date(nam, thang, ngay);

			ketQua.add(temp);
		}

		return ketQua;
	}
	
	public int checkDot(Date thoiGian) {
		
		return 1;
	}

	@SuppressWarnings("deprecation")
	public boolean isCheckBaoHanh(Date thoiGian) {

		List<Date> thoiGianBaoHanhs = getThoiGianBaoHanhDinhKis();

		for (Date date : thoiGianBaoHanhs) {
			if(date.getDate() == thoiGian.getDate() && date.getMonth() == thoiGian.getMonth() && date.getYear() == thoiGian.getYear())
				return true;
				
		}

		return false;

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
