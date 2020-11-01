package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.HangXeDao;
import entity.DongXe;
import entity.HangXe;

public class DongXeConvert {
	
	private DongXeConvert() {
	}
	
	public static DongXe getDongXe(ResultSet resultSet) throws SQLException {
		HangXeDao hangXeDao = HangXeDao.getInstance();
		
		String maDongXe = resultSet.getString("maDongXe");
		String tenDongXe = resultSet.getString("tenDongXe");
		HangXe hangXe = hangXeDao.getHangXeTheoMa(resultSet.getString("maHangXe"));
		
		DongXe dongXe = new DongXe(maDongXe, tenDongXe,hangXe);
		return dongXe;
	}
	
	public static void themDongXe(PreparedStatement preparedStatement, DongXe dongXe) throws SQLException {
		preparedStatement.setString(1, dongXe.getMaDongXe());
		preparedStatement.setString(2, dongXe.getTenDongXe());
		preparedStatement.setString(3, dongXe.getHangXe().getMaHangXe());
	}
	
	public static void capNhatDongXe(PreparedStatement preparedStatement,  DongXe dongXe) throws SQLException {
		preparedStatement.setString(1, dongXe.getTenDongXe());
		preparedStatement.setString(2, dongXe.getHangXe().getMaHangXe());
		preparedStatement.setString(3,dongXe.getMaDongXe());
		
	}
}
