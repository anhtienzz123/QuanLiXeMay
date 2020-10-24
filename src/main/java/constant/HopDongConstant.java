package constant;

public class HopDongConstant {

	public static final String GET_HOP_DONGS = "select * from HopDong";
	public static final String GET_HOP_DONG_THEO_MA_HOP_DONG = "select * from HopDong where maHopDong = ?";
	public static final String THEM_HOP_DONG = "insert into HopDong values (?,?,?)";
	public static final String CAP_NHAT_HOP_DONG = "update HopDong set maHoaDon = ?, maXeMay = ? where maHopDong = ?";
	
	
}
