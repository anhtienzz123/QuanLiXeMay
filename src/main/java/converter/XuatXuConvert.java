package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.XuatXu;

public class XuatXuConvert {
	
	private XuatXuConvert(){
	}
	
	public static XuatXu getXuatXu(ResultSet resultSet) throws SQLException {
		String maXuatXu = resultSet.getString("maXuatXu");
		String tenXuatXu = resultSet.getString("tenXuatXu");
		
		XuatXu xuatXu = new XuatXu(maXuatXu, tenXuatXu);
		return xuatXu;
	}
	
	public static void themXuatXu(PreparedStatement preparedStatement, XuatXu xuatXu) throws SQLException {
		preparedStatement.setString(1, xuatXu.getMaXuatXu());
		preparedStatement.setString(2, xuatXu.getTenXuatXu());
	}
	
	public static void capNhatXuatXu(PreparedStatement preparedStatement,  XuatXu xuatXu) throws SQLException {
		preparedStatement.setString(1, xuatXu.getTenXuatXu());
		preparedStatement.setString(2,xuatXu.getMaXuatXu());
	}
}
