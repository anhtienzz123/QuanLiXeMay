package constant;

public class ThongKeNhanVienConstant {

	public static final String GET_DOANH_THU_THEO_NGAY = "select SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where maNVHanhChinh = ? and DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n"
			+ " group by DAY(HoaDon.ngayLap)";

	public static final String GET_DOANH_THU_THEO_THANG = "select SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where maNVHanhChinh = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + " group by MONTH(HoaDon.ngayLap)";

	public static final String GET_DOANH_THU_THEO_NAM = "select SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where maNVHanhChinh = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + " group by YEAR(HoaDon.ngayLap)";
	
	public static final String GET_SO_LUONG_XE_BAN_THEO_NGAY = "select SUM( soLuong ) as soLuongXe from\r\n" + 
			"HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where maNVHanhChinh = ? and  DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by DAY(HoaDon.ngayLap)";
	public static final String GET_SO_LUONG_XE_BAN_THEO_THANG = "select SUM( soLuong ) as soLuongXe from\r\n" + 
			"HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where maNVHanhChinh = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by MONTH(HoaDon.ngayLap)";
	public static final String GET_SO_LUONG_XE_BAN_THEO_NAM = "select SUM( soLuong ) as soLuongXe from\r\n" + 
			"HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where maNVHanhChinh = ?  and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by YEAR(HoaDon.ngayLap)";
	
	public static final String GET_HOA_DON_LAP_TRONG_NGAY = "select count(maHoaDon) as soLuong\r\n" + 
			"from HoaDon\r\n" + 
			"where HoaDon.maNVHanhChinh = ? and  DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?";
	public static final String GET_HOA_DON_LAP_TRONG_THANG = "select count(maHoaDon) as soLuong\r\n" + 
			"from HoaDon\r\n" + 
			"where HoaDon.maNVHanhChinh =  ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?";
	public static final String GET_HOA_DON_LAP_TRONG_NAM = "select count(maHoaDon) as soLuong\r\n" + 
			"from HoaDon\r\n" + 
			"where HoaDon.maNVHanhChinh =  ? and YEAR(HoaDon.ngayLap) = ?";
	
	public static final String GET_SO_LUONG_TON = "select COUNT(maXeMay) as soLuong\r\n" + 
			"from XeMay\r\n" + 
			"where soLuong > 0";
	
	// Danh sach hoa don
	public static final String GET_DANH_SACH_HOA_DON_LAP_TRONG_NGAY = "select *\r\n" + 
			"from HoaDon\r\n" + 
			"where maNVHanhChinh = ? and  DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?";
	
	public static final String GET_DANH_SACH_HOA_DON_LAP_TRONG_THANG = "select *\r\n" + 
			"from HoaDon\r\n" + 
			"where maNVHanhChinh = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?";
	
	public static final String GET_DANH_SACH_HOA_DON_LAP_TRONG_NAM = "select *\r\n" + 
			"from HoaDon\r\n" + 
			"where maNVHanhChinh = ? and YEAR(HoaDon.ngayLap) = ?";
	
	// Danh sach xe may ban ra
	public static final String GET_XE_MAY_BAN_RA_TRONG_NGAY = "select tenXeMay, SUM(ChiTietHoaDon.soLuong) as soLuong\r\n" + 
			"from HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			"where HoaDon.maNVHanhChinh = ? and DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by tenXeMay";
	
	public static final String GET_XE_MAY_BAN_RA_TRONG_THANG = "select tenXeMay, SUM(ChiTietHoaDon.soLuong) as soLuong\r\n" + 
			"from HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			"where HoaDon.maNVHanhChinh = ?  and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by tenXeMay";
	
	public static final String GET_XE_MAY_BAN_RA_TRONG_NAM = "select tenXeMay, SUM(ChiTietHoaDon.soLuong) as soLuong\r\n" + 
			"from HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			"where HoaDon.maNVHanhChinh = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + 
			"group by tenXeMay";
	
	
	
}
