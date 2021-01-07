package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.HangXe;

public class HangXeConvert {
	private HangXeConvert() {
	}

	public static HangXe getHangXe(ResultSet resultSet) throws SQLException {
		String maHangXe = resultSet.getString("maHangXe");
		String tenHangXe = resultSet.getString("tenHangXe");

		HangXe hangXe = new HangXe(maHangXe, tenHangXe);
		return hangXe;
	}

	public static void themHangXe(PreparedStatement preparedStatement, HangXe hangXe) throws SQLException {
		preparedStatement.setString(1, hangXe.getMaHangXe());
		preparedStatement.setString(2, hangXe.getTenHangXe());
	}

	public static void capNhatHangXe(PreparedStatement preparedStatement, HangXe hangXe) throws SQLException {
		preparedStatement.setString(1, hangXe.getTenHangXe());
		preparedStatement.setString(2, hangXe.getMaHangXe());
	}

}
