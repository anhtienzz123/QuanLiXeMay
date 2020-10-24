package constant;

public class HoaDonConstant {

	public static final String GET_HOA_DONS = "select * from HoaDon";
	public static final String GET_HOA_DON_THEO_MA_HOA_DON = "select * from HoaDon where maHoaDon = ?";
	public static final String THEM_HOA_DON = "insert into HoaDon values(?, ?, ?, ?)";
}
