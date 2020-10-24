package constant;

public class HangXeConstant {
	public static final String GET_HANG_XE = "select * from HangXe ";
	public static final String GET_HANG_XE_THEO_MA = "select *from LoaiXe where maHangXe = ? ";
	public static final String THEM_HANG_XE = "insert into HangXe values(?,?)";
	public static final String CAP_NHAP_HANG_XE= "update HangXe set tenHangXe = ?, where maHangXe = ?";
}
