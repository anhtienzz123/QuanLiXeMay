package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.HoaDonConstant;
import converter.HoaDonConverter;
import db.DatabaseConnect;
import entity.HoaDon;

public class OrderDao {

	private static OrderDao instance;
	private Connection connection;

	// pattern singleton: đảm bảo trong vòng đời 1 ứng dụng chỉ cho phép duy nhất 1
	// đối tượng này đc tạo ra --> đảm bảo tiết kiệm bộ nhớ, tính hiệu năng
	private OrderDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static OrderDao getInstance() {
		if (instance == null)
			instance = new OrderDao();
		return instance;
	}

	public List<HoaDon> getHoaDons() {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.GET_HOA_DONS);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				HoaDon hoaDon = HoaDonConverter.getHoaDon(resultSet);

				hoaDons.add(hoaDon);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hoaDons;

	}

	public HoaDon getHoaDonTheoMaHoaDon() {

		HoaDon hoaDon = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HoaDonConstant.GET_HOA_DON_THEO_MA_HOA_DON);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				hoaDon = HoaDonConverter.getHoaDon(resultSet);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hoaDon;

	}

	public boolean themHoaDon(HoaDon hoaDon) {

		ChiTietHoaDonDao chiTietHoaDonDao = ChiTietHoaDonDao.getInstance();

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.THEM_HOA_DON);

			connection.setAutoCommit(false);

			try {

				chiTietHoaDonDao.themChiTietHoaDons(hoaDon.getChiTietHoaDons());
				n = preparedStatement.executeUpdate();

				connection.commit();
			} catch (Exception e) {
				connection.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n > 0;

	}

}
