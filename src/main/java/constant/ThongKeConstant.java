package constant;

public class ThongKeConstant {

	public static final String DOANH_THU_NGAYS_THEO_THANG = " select  DAY(HoaDon.ngayLap) as ngay , SUM(giaBan*soLuong)as doanhThu from \r\n" + 
			" HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			" where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			" group by DAY(HoaDon.ngayLap)";
	
	public static final String DOANH_THU_THANGS_THEO_NAM = " select  MONTH(HoaDon.ngayLap) as thang , SUM( giaBan*soLuong ) as doanhThu from \r\n" + 
			" HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			" where YEAR(HoaDon.ngayLap) = ?\r\n" + 
			" group by MONTH(HoaDon.ngayLap)";
	
	public static final String SO_LUONG_XE_BAN_THEO_HANG_TRONG_THANG = "select tenHangXe, SUM( ChiTietHoaDon.soLuong) as soLuong from\r\n" + 
			" HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			" inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			" inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n" + 
			" inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + 
			" where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			" group by HangXe.tenHangXe";
	
	public static final String GET_DOANH_THU_THEO_NGAY = " select SUM( giaBan*soLuong ) as doanhThu from \r\n" + 
			" HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			" where DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			" group by DAY(HoaDon.ngayLap)";
	
	public static final String GET_DOANH_THU_THEO_THANG = "select SUM( giaBan*soLuong ) as doanhThu from \r\n" + 
			" HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			" where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			" group by MONTH(HoaDon.ngayLap)";
	
	public static final String GET_TOP_XE_BAN_CHAY_TRONG_THANG = "select top ? tenXeMay, SUM( ChiTietHoaDon.soLuong ) as SoLuongXe from \r\n" + 
			"HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			"where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by tenXeMay \r\n" + 
			"order by SoLuongXe desc"; 
	
	public static final String GET_TOP_XE_BAN_CHAY_TRONG_NAM = "select top ? tenXeMay, SUM( ChiTietHoaDon.soLuong ) as SoLuongXe from \r\n" + 
			"HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			"where YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by tenXeMay \r\n" + 
			"order by SoLuongXe desc";
}
