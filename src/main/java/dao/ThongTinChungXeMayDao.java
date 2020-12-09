package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.ThongTinChungXeMayConstant;
import constant.XeMayConstant;
import converter.ThongTinChungXeMayConverter;
import customoutput.ThongTinChiTietXeMay;
import customoutput.ThongTinChungXeMay;
import db.DatabaseConnect;
import entity.XeMay;

public class ThongTinChungXeMayDao {

	private static ThongTinChungXeMayDao instance;
	private Connection connection;

	private ThongTinChungXeMayDao() {
		try {
			DatabaseConnect.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DatabaseConnect.getInstance();
	}

	public static ThongTinChungXeMayDao getInstance() {
		if (instance == null)
			instance = new ThongTinChungXeMayDao();
		return instance;
	}

	public List<ThongTinChiTietXeMay> getThongTinChiTietXeMays(String tenXeMay) {

		String sql = ThongTinChungXeMayConstant.GET_CHI_TIET_THONG_TIN_XE_MAY_THEO_TEN;

		List<ThongTinChiTietXeMay> thongTinChiTietXeMays = new ArrayList<ThongTinChiTietXeMay>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, tenXeMay);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ThongTinChiTietXeMay thongTinChiTietXeMay = new ThongTinChiTietXeMay(resultSet.getString("maXeMay"),
						resultSet.getString("soKhung"), resultSet.getString("soSuon"), resultSet.getString("mauXe"),
						resultSet.getString("tenXuatXu"));

				thongTinChiTietXeMays.add(thongTinChiTietXeMay);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return thongTinChiTietXeMays;

	}

	public ThongTinChungXeMay getThongTinChungXeMayTheoTenXeMay(String tenXeMay) {

		XeMayDao xeMayDao = XeMayDao.getInstance();

		XeMay xeMay = xeMayDao.getThongXeMayChungTheoTen(tenXeMay);

		ThongTinChungXeMay thongTinChungXeMay = ThongTinChungXeMayConverter.toThongTinChiTietXeMay(xeMay);

		String sql = ThongTinChungXeMayConstant.GET_THONG_TIN_XE_MAY_CHUNG_THEO_TEN_XE;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tenXeMay);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				thongTinChungXeMay.setSoLuongXe(resultSet.getInt("soLuongXe"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thongTinChungXeMay.setThongTinChiTietXeMays(getThongTinChiTietXeMays(tenXeMay));

		return thongTinChungXeMay;

	}

	public List<ThongTinChungXeMay> getThongTinChungXeMayTheoTens(String tenXeMay) {

		List<ThongTinChungXeMay> listThongTin = new ArrayList<ThongTinChungXeMay>();
		List<String> listTenXe = new ArrayList<String>();
		XeMayDao xeMayDao = XeMayDao.getInstance();

		String sql = "select tenXeMay\r\n" + "from XeMay\r\n"
				+ "inner join LoaiXe on XeMay.maLoaiXe = LoaiXe.maLoaiXe \r\n"
				+ "inner join DongXe on XeMay.maDongXe = DongXe.maDongXe \r\n"
				+ "inner join HangXe on DongXe.maHangXe = HangXe.maHangXe\r\n" + "where tenXeMay like N'%" + tenXeMay
				+ "%'\r\n" + "group by tenXeMay";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				listTenXe.add(resultSet.getString("tenXeMay"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String tenXe : listTenXe) {
			XeMay xeMay = xeMayDao.getThongXeMayChungTheoTen(tenXe);

			ThongTinChungXeMay thongTinChungXeMay = ThongTinChungXeMayConverter.toThongTinChiTietXeMay(xeMay);
			thongTinChungXeMay.setThongTinChiTietXeMays(getThongTinChiTietXeMays(tenXeMay));

			listThongTin.add(thongTinChungXeMay);
		}
		return listThongTin;
	}

	public boolean capNhapThongTinChungXeMay(String tenXeMayCu, ThongTinChungXeMay thongTinChungXeMay) {

		int result = 0;

		String sql = ThongTinChungXeMayConstant.CAP_NHAP_THONG_TIN_XE_MAY_CHUNG;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ThongTinChungXeMayConverter.capNhapThongTinChungXeMay(preparedStatement, tenXeMayCu, thongTinChungXeMay);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result > 0;
	}

	public static void main(String[] args) {
		ThongTinChungXeMayDao dao = ThongTinChungXeMayDao.getInstance();
		dao.getThongTinChungXeMayTheoTens("A").forEach(s -> System.out.println(s));
	}

}
