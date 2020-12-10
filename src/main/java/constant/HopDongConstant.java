package constant;

public class HopDongConstant {

	public static final String MA_HOP_DONG = "Mã hợp đồng";
	public static final String MA_HOA_DON = "Mã hóa đơn";
	public static final String MA_NHAN_VIEN = "Mã nhân viên";
	public static final String TEN_NHAN_VIEN = "Tên nhân viên lập";
	public static final String MA_KHACH_HANG = "Mã khách hàng";
	public static final String TEN_KHACH_HANG = "Tên khách hàng";
	public static final String SO_DIEN_THOAI = "Số điện thoại";

	public static final String GET_HOP_DONGS = "select * from HopDong";
	public static final String GET_HOP_DONG_THEO_MA_HOP_DONG = "select * from HopDong where maHopDong = ?";
	public static final String THEM_HOP_DONG = "insert into HopDong values (?,?,?)";
	public static final String CAP_NHAT_HOP_DONG = "update HopDong set maHoaDon = ?, maXeMay = ? where maHopDong = ?";
	public static final String GET_HOP_DONGS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHopDong) as row FROM HopDong) a WHERE a.row >= ?  and a.row <= ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maHoaDon from HoaDon\r\n" + "where maHoaDon = ? ";

	public static final String TIM_KIEM_THEO_MA_HOP_DONG = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where maHopDong like ?";

	public static final String TIM_KIEM_THEO_MA_HOA_DON = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where HopDong.maHoaDon like ?";

	public static final String TIM_KIEM_THEO_MA_NHAN_VIEN_HANH_CHINH = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where HoaDon.maNVHanhChinh like ?";

	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN_HANH_CHINH = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where NhanVienHanhChinh.hoTenNV like ?";

	public static final String TIM_KIEM_THEO_MA_KHACH_HANG = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where HoaDon.maKhachHang like ?";

	public static final String TIM_KIEM_THEO_TEN_KHACH_HANG = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, KhachHang.soDienThoai, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where KhachHang.hoTenKH like ?";

	public static final String TIM_KIEM_THEO_SO_DIEN_THOAI = "SELECT HopDong.*, HoaDon.maNVHanhChinh,HoaDon.ngayLap, NhanVienHanhChinh.hoTenNV, HoaDon.maKhachHang, KhachHang.hoTenKH, KhachHang.soDienThoai, ROW_NUMBER() OVER (ORDER BY maHopDong)\r\n" + 
			"as row FROM HopDong \r\n" + 
			"inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n" + 
			"inner join HoaDon on HopDong.maHoaDon = HoaDon.maHoaDon\r\n" + 
			"inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n" + 
			"inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n" + 
			"where KhachHang.soDienThoai like ?";

	// Max page
	public static final String GET_HOP_DONG_PHAN_TRANG_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n" + "where maHopDong like ?";

	public static final String TIM_KIEM_THEO_MA_HOA_DON_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n" + "where HoaDOn.maHoaDon like ?";

	public static final String TIM_KIEM_THEO_MA_NHAN_VIEN_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
			+ "inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n"
			+ "where NhanVienHanhChinh.maNVHanhChinh like ?\r\n" + "";

	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
			+ "inner join NhanVienHanhChinh on HoaDon.maNVHanhChinh = NhanVienHanhChinh.maNVHanhChinh\r\n"
			+ "where NhanVienHanhChinh.hoTenNV like ?\r\n" + "";

	public static final String TIM_KIEM_THEO_MA_KHACH_HANG_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
			+ "inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n"
			+ "where KhachHang.maKhachHang like ??";

	public static final String TIM_KIEM_THEO_TEN_KHACH_HANG_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
			+ "inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n"
			+ "where KhachHang.hoTenKH like ?";

	public static final String TIM_KIEM_THEO_SO_CMT_MAX_PAGE = "select COUNT(maHopDong) as total from \r\n"
			+ "HopDong inner join ChiTietHoaDon on HopDong.maHoaDon = ChiTietHoaDon.maHoaDon and HopDong.maXeMay = ChiTietHoaDon.maXeMay\r\n"
			+ "inner join HoaDon on ChiTietHoaDon.maHoaDon = HoaDon.maHoaDon\r\n"
			+ "inner join KhachHang on HoaDon.maKhachHang = KhachHang.maKhachHang\r\n"
			+ "where KhachHang.soDienThoai like ?";

}
