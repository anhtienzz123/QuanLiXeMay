package constant;

public class XeMayConstant {
	public static final String GET_XE_MAY = "select * from XeMay";
	public static final String GET_XE_MAY_THEO_MA = "select * from XeMay where maXeMay = ?";
	public static final String GET_XE_MAY_THEO_TEN = "select * from XeMay where tenXeMay = ?";
	public static final String THEM_XE_MAY = "insert into XeMay values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String CAP_NHAP_XE_MAY = "update XeMay set tenXeMay = ?,  urlAnh = ?, soLuong = ?, giaNhap = ?, heSoBan = ?, thoiGianBaoHanh = ?,soKhung = ?, soPhanKhoi = ?, soSuon = ?, mauXe= ?,maLoaiXe = ?, maDongXe = ?, maXuatXu = ?, moTa= ?, maHangXe = ? where maXeMay = ?";
}
