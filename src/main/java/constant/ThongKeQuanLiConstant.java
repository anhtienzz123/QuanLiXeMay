package constant;

public class ThongKeQuanLiConstant {

	private ThongKeQuanLiConstant() {

	}

	// Doanh thu số
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

	public static final String GET_DOANH_THU_QUY_THEO_NAM = "select SUM(giaBan * soLuong) as doanhThu   from\r\n" + 
			"HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where MONTH(HoaDon.ngayLap) between ? and ? and YEAR(HoaDon.ngayLap) = ?";
	
	// So Luong Xe
	
	public static final String GET_SO_LUONG_XE_BAN_TRONG_NGAY = "select COUNT(*) as soLuong\r\n" + 
			"from HoaDon\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?";
	
	public static final String GET_SO_LUONG_XE_BAN_TRONG_THANG = "select COUNT(*) as soLuong\r\n" + 
			"from HoaDon\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?";
	
	public static final String GET_SO_LUONG_XE_BAN_TRONG_NAM = "select COUNT(*) as soLuong\r\n" + 
			"from HoaDon\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where YEAR(HoaDon.ngayLap) = ?";
	
	
	// Doanh thu Map
	public static final String DOANH_THU_NGAYS_THEO_THANG = " select  DAY(HoaDon.ngayLap) as ngay , SUM(giaBan*soLuong)as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + " group by DAY(HoaDon.ngayLap)";

	public static final String DOANH_THU_THANGS_THEO_NAM = " select  MONTH(HoaDon.ngayLap) as thang , SUM( giaBan*soLuong ) as doanhThu from \r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " where YEAR(HoaDon.ngayLap) = ?\r\n" + " group by MONTH(HoaDon.ngayLap)";

	// Thống kê hãng xe
	public static final String THONG_KE_HANG_XE_TRONG_THANG = "select tenHangXe, SUM( ChiTietHoaDon.soLuong) as soLuong from\r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n"
			+ " inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n"
			+ " inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n"
			+ " where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + " group by HangXe.tenHangXe";
	public static final String THONG_KE_HANG_XE_TRONG_NAM = "select tenHangXe, SUM( ChiTietHoaDon.soLuong) as soLuong from\r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n"
			+ " inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n"
			+ " inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + " where YEAR(HoaDon.ngayLap) = ?\r\n"
			+ " group by HangXe.tenHangXe";

	// Thống kê dòng xe
	public static final String THONG_KE_DONG_XE_TRONG_THANG = "select top (?) tenDongXe, SUM( ChiTietHoaDon.soLuong) as soLuong from\r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n"
			+ " inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n"
			+ " where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + " group by DongXe.tenDongXe";

	public static final String THONG_KE_DONG_XE_TRONG_NAM = " select top (?) tenDongXe, SUM( ChiTietHoaDon.soLuong) as soLuong from\r\n"
			+ " HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ " inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n"
			+ " inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n" + " where YEAR(HoaDon.ngayLap) = ?\r\n"
			+ " group by DongXe.tenDongXe";

	// Top sản phẩm bán chạy
	public static final String GET_TOP_XE_BAN_CHAY_TRONG_THANG = "select top (?) tenXeMay, SUM( ChiTietHoaDon.soLuong ) as SoLuongXe from \r\n"
			+ "HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ "inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n"
			+ "where MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap) = ?\r\n" + "group by tenXeMay \r\n"
			+ "order by SoLuongXe desc";

	public static final String GET_TOP_XE_BAN_CHAY_TRONG_NAM = "select top (?) tenXeMay, SUM( ChiTietHoaDon.soLuong ) as SoLuongXe from \r\n"
			+ "HoaDon inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n"
			+ "inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + "where YEAR(HoaDon.ngayLap) = ?\r\n"
			+ "group by tenXeMay \r\n" + "order by SoLuongXe desc";
	
	// Thong ke nhan vien Lap hoa don
	public static final String THONG_KE_NHAN_VIEN_LAP_HOA_DON_TRONG_NGAY = "select NhanVienHanhChinh.maNVHanhChinh, hoTenNV, COUNT(NhanVienHanhChinh.maNVHanhChinh) as soLuong, SUM(giaBan*soLuong) as tongTien  from\r\n" + 
			"NhanVienHanhChinh inner join HoaDon on NhanVienHanhChinh.maNVHanhChinh = HoaDon.maNVHanhChinh\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where DAY(ngayLap) = ? and MONTH(ngayLap) = ? and YEAR(ngayLap) = ?\r\n" + 
			"group by NhanVienHanhChinh.maNVHanhChinh, hoTenNV";
	
	//Thong ke doanh thu ma nhan vien kiem duoc
	public static final String THONG_KE_DOANH_THU_NHAN_VIEN_TRONG_NGAY = "select NhanVienHanhChinh.maNVHanhChinh, SUM(ChiTietHoaDon.giaBan) as total\r\n" + 
			"from HoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where Day(HoaDon.ngayLap) = ? and Month(HoaDon.ngayLap) = ? and  Year(HoaDon.ngayLap) = ?\r\n" + 
			"group by NhanVienHanhChinh.maNVHanhChinh";
	
	public static final String THONG_KE_DOANH_THU_NHAN_VIEN_TRONG_THANG = "select NhanVienHanhChinh.maNVHanhChinh, SUM(ChiTietHoaDon.giaBan) as total\r\n" + 
			"from HoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where  Month(HoaDon.ngayLap) = ? and  Year(HoaDon.ngayLap) = ?\r\n" + 
			"group by NhanVienHanhChinh.maNVHanhChinh";
	
	public static final String THONG_KE_DOANH_THU_NHAN_VIEN_TRONG_NAM = "select NhanVienHanhChinh.maNVHanhChinh, SUM(ChiTietHoaDon.giaBan) as total\r\n" + 
			"from HoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"where Year(HoaDon.ngayLap) = ?\r\n" + 
			"group by NhanVienHanhChinh.maNVHanhChinh";
	
	public static final String THONG_KE_XE_BAN_TRONG_NGAY = "select tenXeMay, COUNT(tenXeMay) as total\r\n" + 
			"from HoaDon\r\n" + 
			"inner join ChiTietHoaDon on HoaDon.maHoaDon = ChiTietHoaDon.maHoaDon\r\n" + 
			"inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n" + 
			"where DAY(HoaDon.ngayLap) = ? and MONTH(HoaDon.ngayLap) = ? and YEAR(HoaDon.ngayLap)= ?\r\n" + 
			"group by tenXeMay";
	
	public static final String THONG_KE_SO_LUONG_XE_TON = "select tenXeMay, COUNT(*) as total\r\n" + 
			"from XeMay\r\n" + 
			"where soLuong > 0\r\n" + 
			"group by tenXeMay";
}
