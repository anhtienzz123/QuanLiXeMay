package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.DanhMucBaoHanh;

public class DanhMucBaoHanhConvert {
	private DanhMucBaoHanhConvert() {
	}

	public static DanhMucBaoHanh getDanhMucBaoHanh(ResultSet resultSet) throws SQLException {
		String maDanhMucBaoHanh = resultSet.getString("maDanhMucBaoHanh");
		String tenDanhMucBaoHanh = resultSet.getString("tenDanhMucBaoHanh");

		DanhMucBaoHanh danhMucBaoHanh = new DanhMucBaoHanh(maDanhMucBaoHanh, tenDanhMucBaoHanh);
		return danhMucBaoHanh;
	}

	public static void themDanhMucBaoHanh(PreparedStatement preparedStatement, DanhMucBaoHanh danhMucBaoHanh)
			throws SQLException {
		preparedStatement.setString(1, danhMucBaoHanh.getMaDanhMucBaoHanh());
		preparedStatement.setString(2, danhMucBaoHanh.getTenDanhMucBaoHanh());
	}

	public static void capDanhMucBaoHanh(PreparedStatement preparedStatement, DanhMucBaoHanh danhMucBaoHanh)
			throws SQLException {
		preparedStatement.setString(1, danhMucBaoHanh.getMaDanhMucBaoHanh());
		preparedStatement.setString(2, danhMucBaoHanh.getTenDanhMucBaoHanh());
	}
}
