package constant;

public class ThongTinChungXeMayConstant {

	public static final String GET_THONG_TIN_XE_MAY_CHUNG_THEO_TEN_XE = "select tenXeMay, COUNT(XeMay.maXeMay) as soLuongXe\r\n" + 
			"from XeMay\r\n" + 
			"inner join LoaiXe on XeMay.maLoaiXe = LoaiXe.maLoaiXe\r\n" + 
			"inner join DongXe on XeMay.maDongXe = DongXe.maDongXe\r\n" + 
			"inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + 
			"where tenXeMay = ?\r\n" + 
			"group by tenXeMay";
	
	public static final String GET_CHI_TIET_THONG_TIN_XE_MAY_THEO_TEN = "select maXeMay, soKhung, soSuon, mauXe, tenXuatXu\r\n" + 
			"from XeMay inner join XuatXu on XeMay.maXuatXu = XuatXu.maXuatXu\r\n" + 
			"where tenXeMay = ?";
	
	public static final String CAP_NHAP_THONG_TIN_XE_MAY_CHUNG = "update XeMay\r\n" + 
			"set tenXeMay = ?, tenAnh = ?, giaNhap = ?, heSoBan = ?, thoiGianBaoHanh = ?, soPhanKhoi = ?, maLoaiXe = ?, maDongXe = ?, moTa = ? where tenXeMay = ?";
	
	
	
	
	private ThongTinChungXeMayConstant() {
		
	}
}
