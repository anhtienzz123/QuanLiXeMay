package constant;

public class HoaDonConstant {

	
	// các field
	public static final String MA_HOA_DON = "Mã hóa đơn";
	public static final String MA_NHAN_VIEN_LAP_HOA_DON = "Mã nhân viên lập hóa đơn";
	public static final String TEN_NHAN_VIEN_LAP_HOA_DON = "Tên nhân viên lập hóa đơn";
	public static final String MA_KHACH_HANG = "Mã khách hàng";
	public static final String TEN_KHACH_HANG = "Tên khách hàng";
	public static final String SO_DIEN_THOAI_KHACH_HANG = "Số điện thoại khách hàng";
	
	public static final String GET_HOA_DONS = "select * from HoaDon";
	public static final String GET_HOA_DONS_THEO_NGAY_LAP = "select * from HoaDon where DAY(ngayLap) = ? and MONTH(ngayLap) = ? and YEAR(ngayLap) = ?O";
	public static final String GET_HOA_DON_THEO_MA_HOA_DON = "select * from HoaDon where maHoaDon = ?";
	public static final String THEM_HOA_DON = "insert into HoaDon values(?, ?, ?, ?)";
	public static final String GET_HOA_DONS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) as row FROM HoaDon) a WHERE a.row >= ?  and a.row <= ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maHoaDon from HoaDon\r\n" + 
    		"where maHoaDon = ? ";
	

	// Phaan trang
	public static final String TIM_KIEM_THEO_MA_HOA_DON = "SELECT maHoaDon, a.maKhachHang, a.maNVHanhChinh, ngayLap FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) \r\n" + 
			"as row FROM HoaDon ) as a \r\n" + 
			"inner join NhanVienHanhChinh on a.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on a.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where a.row between ? and ? and maHoaDon like ? ";
	
	public static final String TIM_KIEM_THEO_MA_NHAN_VIEN = "SELECT maHoaDon, a.maKhachHang, a.maNVHanhChinh, ngayLap FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) \r\n" + 
			"as row FROM HoaDon ) as a \r\n" + 
			"inner join NhanVienHanhChinh on a.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on a.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where a.row between ? and ? and a.maNVHanhChinh like ?";
	
	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN = "SELECT maHoaDon, a.maKhachHang, a.maNVHanhChinh, ngayLap FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) \r\n" + 
			"as row FROM HoaDon ) as a \r\n" + 
			"inner join NhanVienHanhChinh on a.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on a.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where a.row between ? and ? and hoTenNV like ?";
	public static final String TIM_KIEM_THEO_MA_KHACH_HANG = "SELECT maHoaDon,a.maKhachHang, a.maNVHanhChinh, ngayLap FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) \r\n" + 
			"as row FROM HoaDon ) as a \r\n" + 
			"inner join NhanVienHanhChinh on a.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on a.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where a.row between ? and ? and a.maKhachHang like ?";
	public static final String TIM_KIEM_THEO_TEN_KHACH_HANG = "SELECT maHoaDon, a.maKhachHang, a.maNVHanhChinh, ngayLap FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) \r\n" + 
			"as row FROM HoaDon ) as a \r\n" + 
			"inner join NhanVienHanhChinh on a.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on a.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where a.row between ? and ? and hoTenKH like ? ";
	
	public static final String TIM_KIEM_THEO_SO_DIEN_THOAI = "SELECT maHoaDon, a.maKhachHang, a.maNVHanhChinh, ngayLap FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) \r\n" + 
			"as row FROM HoaDon ) as a \r\n" + 
			"inner join NhanVienHanhChinh on a.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on a.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where a.row between ? and ? and soDienThoai like ?";
	// Max page
	public static final String TIM_KIEM_THEO_MA_HOA_DON_MAX_PAGE = "select COUNT(maHoaDon) as total from \r\n" + 
			"HoaDon inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where maHoaDon like ?";
	public static final String TIM_KIEM_THEO_MA_NHAN_VIEN_MAX_PAGE = "select COUNT(maHoaDon) as total from \r\n" + 
			"HoaDon inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where HoaDon.maNVHanhChinh like ?";
	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN_MAX_PAGE = "select COUNT(maHoaDon) as total from \r\n" + 
			"HoaDon inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where hoTenNV like ?";
	
	public static final String TIM_KIEM_THEO_MA_KHACH_HANG_MAX_PAGE = "select COUNT(maHoaDon) as total from \r\n" + 
			"HoaDon inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where HoaDon.maKhachHang like ? ";
	
	public static final String TIM_KIEM_THEO_TEN_KHACH_HANG_MAX_PAGE = "select COUNT(maHoaDon) as total from \r\n" + 
			"HoaDon inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where hoTenKH like ? ";
	public static final String TIM_KIEM_THEO_SO_DIEN_THOAI_MAX_PAGE = "select COUNT(maHoaDon) as total from \r\n" + 
			"HoaDon inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where soDienThoai like ? ";
}
