package constant;

public class NhanVienKiThuatConstant {
	public static final String MA_NHAN_VIEN_KI_THUAT = "Mã nhân viên";
	public static final String TEN_NHAN_VIEN_KI_THUAT = "Tên nhân viên";
	public static final String SO_NAM_KINH_NGHIEM = "Số năm kinh nghiệm";
	public static final String BAC_THO = "Bậc thợ";

	public static final String GET_NHAN_VIEN_KI_THUAT = "select * from NhanVienKiThuat";
	public static final String GET_NHAN_VIEN_KI_THUAT_THEO_MA = "select * from NhanVienKiThuat where maNVKiThuat = ?";
	public static final String GET_NHAN_VIEN_KI_THUAT_THEO_TEN = "select *from NhanVienKiThuat where hoTen like ? ";
	public static final String THEM_NHAN_VIEN_KI_THUAT = "insert into NhanVienKiThuat values(?,?,?,?,?,?,?,?,?,?)";
	public static final String CAP_NHAP_NHAN_VIEN_KI_THUAT = "update NhanVienKiThuat set hoTen = ?,  ngaySinh = ?, soDienThoai = ?, diaChi = ?, soNamKinhNghiem = ?, bacTho = ?, trangThai = ?, tenAnh = ?, gioiTinh = ? where maNVKiThuat = ?";
	
	
	
	public static final String GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVKiThuat) as row FROM NhanVienKiThuat where maNVKiThuat like ? and trangThai = 1) a WHERE a.row >= ?  and a.row <= ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maNVKiThuat from NhanVienKiThuat\r\n"
			+ "where maNVKiThuat = ? ";

	public static final String TIM_KIEM_THEO_MA_NHAN_VIEN_KI_THUAT = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVKiThuat)\r\n"
			+ "as row FROM NhanVienKiThuat where maNVKiThuat like  ? and trangThai = 1) a where a.row between ?  and  ?";

	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN_KI_THUAT = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVKiThuat)\r\n"
			+ "as row FROM NhanVienKiThuat where hoTen like  ? and trangThai = 1) a where a.row between ?  and  ?";

	public static final String TIM_KIEM_THEO_SO_NAM_KINH_NGHIEM = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVKiThuat)\r\n"
			+ "as row FROM NhanVienKiThuat where soNamKinhNghiem like  ? and trangThai = 1) a where a.row between ?  and  ?";
	public static final String TIM_KIEM_THEO_BAC_THO = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVKiThuat)\r\n"
			+ "as row FROM NhanVienKiThuat where bacTho like  ? and trangThai = 1) a where a.row between ?  and  ?";
	
	//get maxpage
	
	public static final String GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG_MAX_PAGE = "select COUNT(maNVKiThuat) as total from NhanVienKiThuat where maNVKiThuat like ?";
	public static final String TIM_KIEM_THEO_MA_NHAN_KI_THUATS_MAX_PAGE = "select COUNT(maNVKiThuat) as total from NhanVienKiThuat where maNVKiThuat like ?";
	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN_KI_THUATS_MAX_PAGE = "select COUNT(maNVKiThuat) as total from NhanVienKiThuat where hoTen like ?";
	public static final String TIM_KIEM_THEO_SO_NAM_KINH_NGHIEM_MAX_PAGE = "select COUNT(maNVKiThuat) as total from NhanVienKiThuat where soNamKinhNghiem like ?";
	public static final String TIM_KIEM_THEO_CHUC_VU_BAC_THO_MAX_PAGE = "select COUNT(maNVKiThuat) as total from NhanVienKiThuat where bacTho like ?";
}
