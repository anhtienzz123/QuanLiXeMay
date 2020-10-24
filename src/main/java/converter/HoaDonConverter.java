package converter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ChiTietHoaDonDao;
import dao.KhachHangDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVienHanhChinh;

public class HoaDonConverter {

	private HoaDonConverter() {

	}

	public static HoaDon getHoaDon(ResultSet resultSet) throws SQLException {

		String maHoaDon = resultSet.getString("maHoaDon");
		String maKhachHang = resultSet.getString("maKhachHang");
		String maNVHanhChinh = resultSet.getString("maNVHanhChinh");
		Date ngayLap = resultSet.getDate("ngayLap");

		KhachHangDao khachHangDao = KhachHangDao.getInstance();
		KhachHang khachHang = khachHangDao.getKhachHangTheoMa(maKhachHang);

		ChiTietHoaDonDao chiTietHoaDonDao = ChiTietHoaDonDao.getInstance();
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonDao.getChiTietHoaDonsTheoMaHoaDon(maHoaDon);

		HoaDon hoaDon = new HoaDon(maHoaDon, khachHang, new NhanVienHanhChinh(), chiTietHoaDons, ngayLap);
		return hoaDon;

	}

	public static void themHoaDon(PreparedStatement preparedStatement, HoaDon hoaDon) throws SQLException {

		preparedStatement.setString(1, hoaDon.getMaHoaDon());
		preparedStatement.setString(2, hoaDon.getKhachHang().getMaKhachHang());
		preparedStatement.setString(3, hoaDon.getNhanVienHanhChinh().getMaNVHanhChinh());
		preparedStatement.setDate(4, hoaDon.getNgayLap());

	}

}
