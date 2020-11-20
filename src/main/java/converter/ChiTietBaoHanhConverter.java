package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DanhMucBaoHanhDao;
import entity.ChiTietBaoHanh;
import entity.ChiTietHoaDon;
import entity.DanhMucBaoHanh;
import entity.PhieuBaoHanh;

public class ChiTietBaoHanhConverter {
	private ChiTietBaoHanhConverter() {
		
	}
	
	public static ChiTietBaoHanh getChiTietBaoHanhTheoMaPhieuBaoHanh(ResultSet resultSet) throws SQLException {
		DanhMucBaoHanhDao danhMucBaoHanhDao = DanhMucBaoHanhDao.getInstance();
		
		
		PhieuBaoHanh phieuBaoHanh = new PhieuBaoHanh(resultSet.getString("maPhieuBaoHanh"));  
		DanhMucBaoHanh danhMucBaoHanh = danhMucBaoHanhDao.getDanhMucBaoHanhTheoMa(resultSet.getString("maDanhMucBaoHanh"));
		boolean trangThai = resultSet.getBoolean("trangThai");
		
		ChiTietBaoHanh chiTietBaoHanh = new ChiTietBaoHanh(phieuBaoHanh, danhMucBaoHanh, trangThai);
		return chiTietBaoHanh;
	}
	
	public static void themChiTietBaoHanh(PreparedStatement preparedStatement, ChiTietBaoHanh chiTietBaoHanh)
			throws SQLException {
		preparedStatement.setString(1, chiTietBaoHanh.getPhieuBaoHanh().getMaPhieuBaoHanh());
		preparedStatement.setString(2, chiTietBaoHanh.getDanhMucBaoHanh().getMaDanhMucBaoHanh());
		preparedStatement.setBoolean(3, chiTietBaoHanh.isTrangThai());
	}
}
