package constant;

public class HoaDonConstant {

	public static final String GET_HOA_DONS = "select * from HoaDon";
	public static final String GET_HOA_DON_THEO_MA_HOA_DON = "select * from HoaDon where maHoaDon = ?";
	public static final String THEM_HOA_DON = "insert into HoaDon values(?, ?, ?, ?)";
	public static final String GET_HOA_DONS_PHAN_TRANG = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY maHoaDon) as row FROM HoaDon) a WHERE a.row >= ?  and a.row <= ?";
	public static final String KIEM_TRA_MA_KHONG_TRUNG = "select maHoaDon from HoaDon\r\n" + 
    		"where maHoaDon = ? ";
}
