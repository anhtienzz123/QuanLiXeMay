package constant;

public class DongXeConstant {
	public static final String GET_DONG_XE = "select * from DongXe ";
	public static final String GET_DONG_XE_THEO_MA = "select *from DongXe where maDongXe = ? ";
	public static final String THEM_DONG_XE = "insert into DongXe values(?,?,?)";
	public static final String CAP_NHAP_DONG_XE= "update DongXe set tenDongXe = ?, maHangXe = ? where maDongXe = ?";
}
