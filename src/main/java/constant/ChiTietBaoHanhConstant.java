package constant;

public class ChiTietBaoHanhConstant {
	public static final String GET_CHI_TIET_PHIEU_BAO_HANH_THEO_MA = "select * from ChiTietBaoHanh where maPhieuBaoHanh = ?";
	public static final String THEM_CHI_TIET_BAO_HANH = "insert into ChiTietBaoHanh values (?, ?, ?)";
}
