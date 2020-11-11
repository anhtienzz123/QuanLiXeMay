package constant;

public class NhanVienHanhChinhConstant {

	public static final String MA_NHAN_VIEN_HANH_CHINH = "Mã nhân viên";
	public static final String TEN_NHAN_VIEN_HANH_CHINH = "Tên nhân viên";
	public static final String SO_DIEN_THOAI = "Số điện thoại";
	public static final String CHUC_VU = "Chức vụ";



	public static final String GET_NHAN_VIEN_HANH_CHINH = "select * from NhanVienHanhChinh";
	public static final String GET_NHAN_VIEN_HANH_CHINH_THEO_MA = "select *from NhanVienHanhChinh where maNVHanhChinh = ?";
	public static final String GET_NHAN_VIEN_HANH_CHINH_THEO_TEN = "select *from NhanVienHanhChinh where hoTenNV like ? ";
	public static final String THEM_NHAN_VIEN_HANH_CHINH = "insert into NhanVienHanhChinh values(?,?,?,?,?,?,?,?,?, ?,?,?)";
	public static final String CAP_NHAP_NHAN_VIEN_HANH_CHINH = "update NhanVienHanhChinh set hoTenNV = ?, matKhau = ?, gioiTinh = ?,ngaySinh = ?, soDienThoai = ?, diaChi = ?, tenAnh = ?,chucVu= ?, trinhDoHocVan=?, vaiTro = ?, trangThai = ? where maNVHanhChinh = ?";
	public static final String XOA_NHAN_VIEN_HANH_CHINH = "delete from NhanVienHanhChinh where maNVHanhChinh = ?";
	
	public static final String GET_NHAN_VIEN_HANH_CHINHS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVHanhChinh ) as row FROM NhanVienHanhChinh where maNVHanhChinh like ? and trangThai = 1) a WHERE a.row between ?  and  ? ";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maNVHanhChinh from NhanVienHanhChinh\r\n"
			+ "where maNVHanhChinh  = ? ";

	public static final String TIM_KIEM_THEO_MA_NHAN_VIEN_HANH_CHINH = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVHanhChinh)\r\n"
			+ "as row FROM NhanVienHanhChinh where maNVHanhChinh like  ? and trangThai = 1) a where a.row between ?  and  ?";
	public static final String TIM_KIEM_THEO_TEN_NHAN_VIEN_HANH_CHINH = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVHanhChinh)\r\n"
			+ "as row FROM NhanVienHanhChinh where hoTenNV like  ? and trangThai = 1) a where a.row between ?  and  ?";

	public static final String TIM_KIEM_THEO_SO_DIEN_THOAI = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVHanhChinh)\r\n"
			+ "as row FROM NhanVienHanhChinh where soDienThoai like  ? and trangThai = 1) a where a.row between ?  and  ?";
	public static final String TIM_KIEM_THEO_SO_CHUC_VU = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVHanhChinh)\r\n"
			+ "as row FROM NhanVienHanhChinh where chucVu like  ? and trangThai = 1) a where a.row between ?  and  ?";

}
