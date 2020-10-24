package converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.NhanVienKiThuat;

public class NhanVienKiThuatConvert {
	public  NhanVienKiThuatConvert() {
	}
	
	
	public static NhanVienKiThuat getNhanVienKiThuat(ResultSet resultSet) throws SQLException {

		String maNVKiThuat = resultSet.getString("maNVKiThuat");
		String hoTen = resultSet.getString("hoTen");
		Date ngaySinh = resultSet.getDate("ngaySinh");
		String soDienThoai = resultSet.getString("soDienThoai");
		String diaChi = resultSet.getString("diaChi");
		int soNamKinhNghiem = resultSet.getInt("soNamKinhNghiem");
		int bacTho = resultSet.getInt("bacTho");

		NhanVienKiThuat NVKiThuat = new NhanVienKiThuat(maNVKiThuat, hoTen, ngaySinh, soDienThoai, diaChi, soNamKinhNghiem, bacTho);
		return NVKiThuat;
	}
	
	public static void themNhanVienKiThuat(PreparedStatement preparedStatement, NhanVienKiThuat NVKiThuat)
			throws SQLException {
		
		preparedStatement.setString(1, NVKiThuat.getMaNVKiThuat());
		preparedStatement.setString(2, NVKiThuat.getHoTen());
		preparedStatement.setDate(3, NVKiThuat.getNgaySinh());
		preparedStatement.setString(4, NVKiThuat.getSoDienThoai());
		preparedStatement.setString(5, NVKiThuat.getDiaChi());
		preparedStatement.setInt(6, NVKiThuat.getSoNamKinhNghiem());
		preparedStatement.setInt(7, NVKiThuat.getBacTho());

	}

	public static void capNhatNhanVienKiThuat(PreparedStatement preparedStatement, NhanVienKiThuat NVKiThuat)
			throws SQLException {
		
		preparedStatement.setString(1, NVKiThuat.getHoTen());
		preparedStatement.setDate(2, NVKiThuat.getNgaySinh());
		preparedStatement.setString(3, NVKiThuat.getSoDienThoai());
		preparedStatement.setString(4, NVKiThuat.getDiaChi());
		preparedStatement.setInt(5, NVKiThuat.getSoNamKinhNghiem());
		preparedStatement.setInt(6, NVKiThuat.getBacTho());
		preparedStatement.setString(7, NVKiThuat.getMaNVKiThuat());
	}

}
