package constant;

public class PhieuBaoHanhConstant {
	public static final String GET_PHIEU_BAO_HANH = "select * from PhieuBaoHanh";
	public static final String GET_PHIEU_BAO_HANH_THEO_MA = "select * from PhieuBaoHanh where maPhieuBaoHanh = ?";
	public static final String THEM_PHIEU_BAO_HANH = "insert into PhieuBaoHanh values(?,?,?,?)";
	public static final String CAP_NHAP_PHIEU_BAO_HANH = "update PhieuBaoHanh set maHopDong = ?,ngayBaoHanh = ?, maNVKiThuat where maPhieuBaoHanh = ?";
	public static final String GET_PHIEU_BAO_HANH_THEO_MA_HOP_DONG ="select * from PhieuBaoHanh where maHopDong = ?";
	public static final String GET_PHIEU_BAO_HANHS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHopDong) as row FROM HopDong) a WHERE a.row >= ?  and a.row <= ?";

	
}
