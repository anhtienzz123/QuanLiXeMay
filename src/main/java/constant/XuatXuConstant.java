package constant;

public class XuatXuConstant {
	public static final String GET_XUAT_XU_XE = "select * from XuatXu ";
	public static final String GET_XUAT_XU_THEO_MA = "select * from XuatXu where maXuatXu = ? ";
	public static final String GET_XUAT_XU_THEO_TEN = "select * from XuatXu where tenXuatXu like N'%";
	public static final String THEM_XUAT_XU = "insert into XuatXu values(?,?)";
	public static final String CAP_NHAP_XUAT_XU = "update XuatXu set tenXuatXu = ? where maXuatXu = ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maXuatXu from XuatXu\r\n" + 
    		"where maXuatXu = ? ";
	public static final String XOA_XUAT_XU = "delete from XuatXu where maXuatXu = ?";
	
	
}
