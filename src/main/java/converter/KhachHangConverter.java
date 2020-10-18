package converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.KhachHang;

public class KhachHangConverter {
	
	private KhachHangConverter() {

	}
	
	public static KhachHang getKhachHang(ResultSet resultSet) throws SQLException {

		String maKhachHang = resultSet.getString("maKhachHang");
		String soCMT = resultSet.getString("soCMT");
		String hotenKH = resultSet.getString("hoTenKH");
		Date ngaySinh = resultSet.getDate("ngaySinh");
		String soDienThoai = resultSet.getString("soDienThoai");
		String diaChiKH = resultSet.getString("diaChiKH");
		
		KhachHang khachHang = new KhachHang(maKhachHang, soCMT, hotenKH, ngaySinh, soDienThoai, diaChiKH);
		return khachHang;
	}
	
	public static void themKhachHang(PreparedStatement preparedStatement, KhachHang khachHang) throws SQLException {
		preparedStatement.setString(1, khachHang.getMaKhachHang());
		preparedStatement.setString(2, khachHang.getSoCMT());
		preparedStatement.setString(3, khachHang.getHoTenKH());
		preparedStatement.setDate(4, khachHang.getNgaySinh());
		preparedStatement.setString(5, khachHang.getSoDienThoai());
		preparedStatement.setString(6, khachHang.getDiaChiKH());
	}
	
	public static void capNhatKhachHang(PreparedStatement preparedStatement, KhachHang khachHang) throws SQLException {
		preparedStatement.setString(1, khachHang.getSoCMT());
		preparedStatement.setString(2, khachHang.getHoTenKH());
		preparedStatement.setDate(3, khachHang.getNgaySinh());
		preparedStatement.setString(4, khachHang.getSoDienThoai());
		preparedStatement.setString(5, khachHang.getDiaChiKH());
		preparedStatement.setString(6, khachHang.getMaKhachHang());
	}
}
