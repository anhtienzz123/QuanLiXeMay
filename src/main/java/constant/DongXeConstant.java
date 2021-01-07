package constant;

public class DongXeConstant {
	public static final String GET_DONG_XE = "select * from DongXe ";
	public static final String GET_DONG_XE_THEO_TEN_HANG_XE = "select DongXe.* from DongXe\r\n" + 
			"inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + 
			"where tenHangXe = ?";
	public static final String GET_DONG_XE_THEO_MA = "select *from DongXe where maDongXe = ? ";
	public static final String GET_DONG_XE_THEO_TEN = "select *from DongXe where tenDongXe like N'%";
	public static final String THEM_DONG_XE = "insert into DongXe values(?,?,?,?)";
	public static final String CAP_NHAP_DONG_XE= "update DongXe set tenDongXe = ?, thue = ? ,maHangXe = ? where maDongXe = ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maDongXe from DongXe\r\n" + 
    		"where maDongXe = ? ";
	public static final String XOA_DONG_XE = "";
}
