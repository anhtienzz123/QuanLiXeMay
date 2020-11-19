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
		boolean trangThai = resultSet.getBoolean("trangThai");
		boolean gioiTinh = resultSet.getBoolean("gioiTinh");
		String tenAnh = resultSet.getString("tenAnh");
		
		NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(maNVKiThuat, hoTen, ngaySinh, soDienThoai, diaChi, soNamKinhNghiem, bacTho, trangThai, tenAnh, gioiTinh);

		return nhanVienKiThuat;
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
		preparedStatement.setBoolean(8, NVKiThuat.isTrangThai());
		preparedStatement.setString(9, NVKiThuat.getTenAnh());
		preparedStatement.setBoolean(10, NVKiThuat.isGioiTinh());

	}

	public static void capNhatNhanVienKiThuat(PreparedStatement preparedStatement, NhanVienKiThuat NVKiThuat)
			throws SQLException {
		
		preparedStatement.setString(1, NVKiThuat.getHoTen());
		preparedStatement.setDate(2, NVKiThuat.getNgaySinh());
		preparedStatement.setString(3, NVKiThuat.getSoDienThoai());
		preparedStatement.setString(4, NVKiThuat.getDiaChi());
		preparedStatement.setInt(5, NVKiThuat.getSoNamKinhNghiem());
		preparedStatement.setInt(6, NVKiThuat.getBacTho());
		preparedStatement.setBoolean(7, NVKiThuat.isTrangThai());
		preparedStatement.setString(8, NVKiThuat.getTenAnh());
		preparedStatement.setBoolean(9, NVKiThuat.isGioiTinh());
		preparedStatement.setString(10, NVKiThuat.getMaNVKiThuat());
	}

}
