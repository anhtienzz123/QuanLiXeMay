package constant;

public class LoaiXeConstant {
	public static final String GET_LOAI_XE = "select * from LoaiXe ";
	public static final String GET_LOAI_XE_THEO_MA = "select *from LoaiXe where maLoaiXe = ? ";
	public static final String GET_LOAI_XE_THEO_TEN = "select *from LoaiXe where tenLoaiXe like N'%";
	public static final String THEM_LOAI_XE = "insert into LoaiXe values(?,?)";
	public static final String CAP_NHAP_LOAI_XE= "update LoaiXe set tenLoaiXe = ?, where maLoaiXe = ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maLoaiXe from LoaiXe\r\n" + 
    		"where maLoaiXe = ? ";
}
