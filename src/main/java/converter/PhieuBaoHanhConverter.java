package converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ChiTietBaoHanhDao;
import entity.ChiTietBaoHanh;
import entity.HopDong;
import entity.NhanVienKiThuat;
import entity.PhieuBaoHanh;

public class PhieuBaoHanhConverter {
	private PhieuBaoHanhConverter() {
	}

	public static PhieuBaoHanh getPhieuBaoHanh(ResultSet resultSet) throws SQLException {
		ChiTietBaoHanhDao chiTietBaoHanhDao = ChiTietBaoHanhDao.getInstance();
		
		String  maPhieuBaoHanh = resultSet.getString("maPhieuBaoHanh");
		HopDong hopDong = new HopDong(resultSet.getString("maHopDong"));
		Date ngayBaoHanh = resultSet.getDate("ngayBaoHanh");
		NhanVienKiThuat nhanVienKiThuat = new NhanVienKiThuat(resultSet.getString("maNVKiThuat")); 
		List<ChiTietBaoHanh> chiTietBaoHanhs = chiTietBaoHanhDao.getChiTietBaoHanhTheoMaPhieuBaoHanh(resultSet.getString("maPhieuBaoHanh")); 
		PhieuBaoHanh phieuBaoHanh = new PhieuBaoHanh(maPhieuBaoHanh, hopDong, ngayBaoHanh, nhanVienKiThuat, chiTietBaoHanhs);
		return phieuBaoHanh;
	}

	public static void themPhieuBaoHanh(PreparedStatement preparedStatement, PhieuBaoHanh phieuBaoHanh)
			throws SQLException {
		preparedStatement.setString(1, phieuBaoHanh.getMaPhieuBaoHanh());
		preparedStatement.setString(2, phieuBaoHanh.getHopDong().getMaHopDong());
		preparedStatement.setDate(3, phieuBaoHanh.getNgayBaoHanh());
		preparedStatement.setString(4, phieuBaoHanh.getNhanVienKiThuat().getMaNVKiThuat());
		
	}

	public static void capDanhMucBaoHanh(PreparedStatement preparedStatement, PhieuBaoHanh phieuBaoHanh)
			throws SQLException {
		preparedStatement.setString(1, phieuBaoHanh.getHopDong().getMaHopDong());
		preparedStatement.setDate(2, phieuBaoHanh.getNgayBaoHanh());
		preparedStatement.setString(3, phieuBaoHanh.getNhanVienKiThuat().getMaNVKiThuat());
		preparedStatement.setString(4, phieuBaoHanh.getMaPhieuBaoHanh());

	}
}
