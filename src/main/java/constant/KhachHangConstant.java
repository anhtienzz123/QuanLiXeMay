package constant;

public class KhachHangConstant {

	public static final String MA_KHACH_HANG = "Mã khách hàng";
	public static final String SO_CMT = "Số CMT";
	public static final String TEN_KHACH_HANG = "Tên khách hàng";
	public static final String SO_DIEN_THOAI = "Số điện thoại";

	// Câu lệnh sql
	public static final String GET_KHACH_HANGS = "select * from KhachHang";
	public static final String GET_KHACH_HANGS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maKhachHang) as row FROM KhachHang where maKhachHang like ?) a WHERE a.row between ?  and  ?";
	public static final String GET_KHACH_HANG_THEO_MA = "select * from KhachHang where maKhachHang = ?";
	public static final String GET_KHACH_HANG_THEO_SO_DIEN_THOAI = "select * from KhachHang where soDienThoai = ?";
	public static final String GET_KHACH_HANG_THEO_SO_CMT = "select * from KhachHang where soCMT = ?";
	public static final String THEM_KHACH_HANG = "insert into KhachHang values(?,?,?,?,?,?, ?)";
	public static final String CAP_NHAP_KHACH_HANG = "update KhachHang set soCMT = ?, hoTenKH = ?,"
			+ " ngaySinh = ?, soDienThoai = ?, diaChiKH = ?, email = ? where maKhachHang = ?";
	public static final String XOA_KHACH_HANG = "delete from KhachHang where maKhachHang = ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maKhachHang from KhachHang\r\n"
			+ "where maKhachHang = ? ";
	public static final String KIEM_TRA_SO_DIEN_THOAI_KHONG_TRUNG = "select maKhachHang from KhachHang\r\n"
			+ "where soDienThoai = ? ";
	public static final String KIEM_TRA_SO_CMT_KHONG_TRUNG = "select maKhachHang from KhachHang\r\n"
			+ "where soCMT = ? ";

	// Phaan trang
	public static final String TIM_KIEM_THEO_MA_KHACH_HANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maKhachHang)\r\n"
			+ "as row FROM KhachHang where maKhachHang like  ?) a where a.row between ?  and  ?";

	public static final String TIM_KIEM_THEO_TEN_KHACH_HANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maKhachHang)\r\n"
			+ "as row FROM KhachHang where hoTenKH like  ?) a where a.row between ?  and  ?";

	public static final String TIM_KIEM_THEO_SO_DIEN_THOAI = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maKhachHang)\r\n"
			+ "as row FROM KhachHang where soDienThoai like  ?) a where a.row between ?  and  ?";

	public static final String TIM_KIEM_THEO_SO_CMT = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maKhachHang)\r\n"
			+ "as row FROM KhachHang where soCMT like  ?) a where a.row between ?  and  ?";
	// Max page
	public static final String GET_KHACH_HANGS_PHAN_TRANG_MAX_PAGE = "select COUNT(maKhachHang) as total from KhachHang where maKhachHang like ?";
	public static final String TIM_KIEM_THEO_MA_KHACH_HANG_MAX_PAGE = "select COUNT(maKhachHang) as total from KhachHang where maKhachHang like ?";
	public static final String TIM_KIEM_THEO_TEN_KHACH_HANG_MAX_PAGE = "select COUNT(maKhachHang) as total from KhachHang where hoTenKH like ?";
	public static final String TIM_KIEM_THEO_SO_DIEN_THOAI_MAX_PAGE = "select COUNT(maKhachHang) as total from KhachHang where soDienThoai like ?";
	public static final String TIM_KIEM_THEO_SO_CMT_MAX_PAGE = "select COUNT(maKhachHang) as total from KhachHang where soCMT like ?";
}
