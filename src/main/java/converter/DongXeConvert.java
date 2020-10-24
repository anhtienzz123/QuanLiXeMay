package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.DongXe;

public class DongXeConvert {
	
	private DongXeConvert() {
	}
	
	public static DongXe getDongXe(ResultSet resultSet) throws SQLException {
		String maDongXe = resultSet.getString("maDongXe");
		String tenDongXe = resultSet.getString("tenDongXe");
		
		DongXe dongXe = new DongXe(maDongXe, tenDongXe);
		return dongXe;
	}
	
	public static void themDongXe(PreparedStatement preparedStatement, DongXe dongXe) throws SQLException {
		preparedStatement.setString(1, dongXe.getMaDongXe());
		preparedStatement.setString(2, dongXe.getTenDongXe());
	}
	
	public static void capNhatDongXe(PreparedStatement preparedStatement,  DongXe dongXe) throws SQLException {
		preparedStatement.setString(1, dongXe.getTenDongXe());
		preparedStatement.setString(2,dongXe.getMaDongXe());
	}
}
