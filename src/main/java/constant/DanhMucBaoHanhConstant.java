package constant;

public class DanhMucBaoHanhConstant {
	public static final String GET_DANH_MUC_BAO_HANH = "select * from DanhMucBaoHanh";
	public static final String GET_DANH_MUC_BAO_HANH_THEO_MA = "select * from DanhMucBaoHanh where maDanhMucBaoHanh = ?";
	public static final String THEM_DANH_MUC_BAO_HANH = "insert into DanhMucBaoHanh values(?,?)";
	public static final String CAP_NHAP_DANH_MUC_BAO_HANH = "update DanhMucBaoHanh set tenDanhMucBaoHanh = ?, where maDanhMucBaoHanh = ?";
	

}
