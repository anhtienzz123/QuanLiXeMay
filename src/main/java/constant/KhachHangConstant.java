package constant;

public class KhachHangConstant {

	public static final String GET_KHACH_HANGS = "select * from KhachHang";
	public static final String GET_KHACH_HANGS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maKhachHang) as row FROM KhachHang) a WHERE a.row >= ?  and a.row <= ?";
	public static final String GET_KHACH_HANG_THEO_MA = "select * from KhachHang where maKhachHang = ?";
	public static final String THEM_KHACH_HANG = "insert into KhachHang values(?,?,?,?,?,?)";
	public static final String CAP_NHAP_KHACH_HANG = "update KhachHang set soCMT = ?, hoTenKH = ?,"
			+ " ngaySinh = ?, soDienThoai = ?, diaChiKH = ? where maKhachHang = ?";
	public static final String XOA_KHACH_HANG = "delete from KhachHang where maKhachHang = ?";
    public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maKhachHang from KhachHang\r\n" + 
    		"where maKhachHang = ? ";
}
