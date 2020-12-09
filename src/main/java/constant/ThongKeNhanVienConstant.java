package constant;

public class ThongKeNhanVienConstant {

	public static final String GET_DOANH_THU_THEO_NGAY = "select SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n"
			+ " group by DAY(HoaDon.ngayLap)";

	public static final String GET_DOANH_THU_THEO_THANG = "select SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + " group by MONTH(HoaDon.ngayLap)";

	public static final String GET_DOANH_THU_THEO_NAM = "select SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where YEAR(HoaDon.ngayLap) = ?\r\n" + " group by YEAR(HoaDon.ngayLap)";
	
	
	
}
