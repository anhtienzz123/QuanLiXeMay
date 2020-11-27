package constant;

public class HangXeConstant {
	public static final String GET_HANG_XE = "select * from HangXe ";
	public static final String GET_HANG_XE_THEO_MA = "select *from HangXe where maHangXe = ? ";
	public static final String GET_HANG_XE_THEO_TEN = "select *from HangXe where tenHangXe like N'%";
	public static final String THEM_HANG_XE = "insert into HangXe values(?,?)";
	public static final String CAP_NHAP_HANG_XE= "update HangXe set tenHangXe = ? where maHangXe = ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maHangXe from HangXe\r\n" + 
    		"where maHangXe = ? ";
}
