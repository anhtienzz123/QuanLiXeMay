package converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.XeMayDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.XeMay;

public class ChiTietHoaDonConverter {

	private ChiTietHoaDonConverter() {

	}

	public static ChiTietHoaDon getChiTietHoaDon(ResultSet resultSet) throws SQLException {

		String maHoaDon = resultSet.getString("maHoaDon");
		String maXeMay = resultSet.getString("maXeMay");
		double giaBan = resultSet.getDouble("giaBan");
		int soLuong = resultSet.getInt("soLuong");

		HoaDon hoaDon = new HoaDon(maHoaDon);
		
		XeMayDao xeMayDao = XeMayDao.getInstance();
		XeMay xeMay = xeMayDao.getXeMayTheoMa(maXeMay);
		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoaDon, xeMay, giaBan, soLuong);

		return chiTietHoaDon;

	}

	public static void themChiTietHoaDon(PreparedStatement preparedStatement, ChiTietHoaDon chiTietHoaDon)
			throws SQLException {
		preparedStatement.setString(1, chiTietHoaDon.getHoaDon().getMaHoaDon());
		preparedStatement.setString(2, chiTietHoaDon.getXeMay().getMaXeMay());
		preparedStatement.setDouble(3, chiTietHoaDon.getGiaBan());
		preparedStatement.setDouble(4, chiTietHoaDon.getSoLuong());

	}
}
