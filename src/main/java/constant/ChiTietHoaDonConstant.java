package constant;

public class ChiTietHoaDonConstant {

	public static final String GET_CHI_TIET_HOA_DON_THEO_MA_HOA_DON = "select maHoaDon, ChiTietHoaDon.maXeMay, tenXeMay, ChiTietHoaDon.giaBan, ChiTietHoaDon.soLuong from ChiTietHoaDon inner join XeMay on ChiTietHoaDon.maXeMay = XeMay.maXeMay\r\n"
			+ "where maHoaDon = ?";
	public static final String THEM_CHI_TIET_HOA_DON = "insert into ChiTietHoaDon values (?,?, ?, ?)";

}
