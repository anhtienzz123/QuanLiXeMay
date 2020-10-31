package constant;

public class NhanVienKiThuatConstant {
	public static final String GET_NHAN_VIEN_KI_THUAT = "select * from NhanVienKiThuat";
	public static final String GET_NHAN_VIEN_KI_THUAT_THEO_MA = "select * from NhanVienKiThuat where maNVKiThuat = ?";
	public static final String GET_NHAN_VIEN_KI_THUAT_THEO_TEN = "select *from NhanVienKiThuat where hoTen like ? ";
	public static final String THEM_NHAN_VIEN_KI_THUAT = "insert into NhanVienKiThuat values(?,?,?,?,?,?,?)";
	public static final String CAP_NHAP_NHAN_VIEN_KI_THUAT = "update NhanVienKiThuat set hoTen = ?,  ngaySinh = ?, soDienThoai = ?, diaChi = ?, soNamKinhNghiem = ?, bacTho = ? where maNVKiThuat = ?";
	public static final String GET_NHAN_VIEN_KI_THUATS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVKiThuat) as row FROM NhanVienKiThuat) a WHERE a.row >= ?  and a.row <= ?";
	
}
