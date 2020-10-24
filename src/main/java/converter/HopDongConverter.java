package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.HoaDonDao;
import dao.XeMayDao;
import entity.HoaDon;
import entity.HopDong;
import entity.XeMay;

public class HopDongConverter {

	private HopDongConverter() {

	}

	public static HopDong getHopDong(ResultSet resultSet) throws SQLException {
		String maHopDong = resultSet.getString("maHopDong");
		String maHoaDon = resultSet.getString("maHoaDon");
		String maXeMay = resultSet.getString("maXeMay");

		HoaDonDao hoaDonDao = HoaDonDao.getInstance();
		HoaDon hoaDon = hoaDonDao.getHoaDonTheoMaHoaDon(maHoaDon);

		XeMayDao xeMayDao = XeMayDao.getInstance();
		XeMay xeMay = xeMayDao.getXeMayTheoMa(maXeMay);

		HopDong hopDong = new HopDong(maHopDong, hoaDon, xeMay, null);

		return hopDong;

	}

	public static void themHopDong(PreparedStatement preparedStatement, HopDong hopDong) throws SQLException {
		preparedStatement.setString(1, hopDong.getMaHopDong());
		preparedStatement.setString(2, hopDong.getHoaDon().getMaHoaDon());
		preparedStatement.setString(3, hopDong.getXeMay().getMaXeMay());
	}

	public static void capNhatHopDong(PreparedStatement preparedStatement, HopDong hopDong) throws SQLException {

		preparedStatement.setString(1, hopDong.getHoaDon().getMaHoaDon());
		preparedStatement.setString(2, hopDong.getXeMay().getMaXeMay());
		preparedStatement.setString(3, hopDong.getMaHopDong());
	}

}
