package constant;

public class NhanVienHanhChinhConstant {
	
	public static final String GET_NHAN_VIEN_HANH_CHINH = "select * from NhanVienHanhChinh";
	public static final String GET_NHAN_VIEN_HANH_CHINH_THEO_MA = "select * from NhanVienHanhChinh where maNVHanhChinh = ?";
	public static final String GET_NHAN_VIEN_HANH_CHINH_THEO_TEN = "select *from NhanVienHanhChinh where hoTenNV like ? ";
	public static final String THEM_NHAN_VIEN_HANH_CHINH = "insert into NhanVienHanhChinh values(?,?,?,?,?,?,?,?,?)";
	public static final String CAP_NHAP_NHAN_VIEN_HANH_CHINH = "update NhanVienHanhChinh set hoTenNV = ?, matKhau = ?, ngaySinh = ?, soDienThoai = ?, diaChi = ?, chucVu= ?, trinhDoHocVan=?, vaiTro = ? where maNVHanhChinh = ?";
	public static final String XOA_NHAN_VIEN_HANH_CHINH = "delete from NhanVienHanhChinh where maNVHanhChinh = ?";
	public static final String GET_NHAN_VIEN_HANH_CHINHS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maNVHanhChinh) as row FROM NhanVienHanhChinh) a WHERE a.row >= ?  and a.row <= ?";

}
