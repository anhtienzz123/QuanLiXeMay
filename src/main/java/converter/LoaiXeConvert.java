package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.LoaiXe;

public class LoaiXeConvert {
	
	private LoaiXeConvert(){
	}
	
	public static LoaiXe getLoaiXe(ResultSet resultSet) throws SQLException {
		String maLoaiXe = resultSet.getString("maLoaiXe");
		String tenLoaiXe = resultSet.getString("tenLoaiXe");
		
		LoaiXe loaiXe = new LoaiXe(maLoaiXe, tenLoaiXe);
		return loaiXe;
	}
	
	public static void themLoaiXe(PreparedStatement preparedStatement, LoaiXe loaiXe) throws SQLException {
		preparedStatement.setString(1, loaiXe.getMaLoaiXe());
		preparedStatement.setString(2, loaiXe.getTenLoaiXe());
	}
	
	public static void capNhatLoaiXe(PreparedStatement preparedStatement,  LoaiXe loaiXe) throws SQLException {
		preparedStatement.setString(1, loaiXe.getTenLoaiXe());
		preparedStatement.setString(2,loaiXe.getMaLoaiXe());
	}
}
