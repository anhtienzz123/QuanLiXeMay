package constant;

public class DongXeConstant {
	public static final String GET_DONG_XE = "select * from DongXe ";
	public static final String GET_DONG_XE_THEO_MA = "select *from DongXe where maDongXe = ? ";
	public static final String GET_DONG_XE_THEO_TEN = "select *from DongXe where tenDongXe = ? ";
	public static final String THEM_DONG_XE = "insert into DongXe values(?,?,?,?)";
	public static final String CAP_NHAP_DONG_XE= "update DongXe set tenDongXe = ?, thue = ? ,maHangXe = ? where maDongXe = ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maDongXe from DongXe\r\n" + 
    		"where maDongXe = ? ";
}
