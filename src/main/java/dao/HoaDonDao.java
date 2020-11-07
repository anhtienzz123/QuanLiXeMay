package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.HangXeConstant;
import constant.HoaDonConstant;
import constant.HopDongConstant;
import converter.HoaDonConverter;
import converter.HopDongConverter;
import db.DatabaseConnect;
import entity.HoaDon;
import entity.HopDong;

public class HoaDonDao {

	private static HoaDonDao instance;
	private Connection connection;

	// pattern singleton: đảm bảo trong vòng đời 1 ứng dụng chỉ cho phép duy nhất 1
	// đối tượng này đc tạo ra --> đảm bảo tiết kiệm bộ nhớ, tính hiệu năng
	private HoaDonDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static HoaDonDao getInstance() {
		if (instance == null)
			instance = new HoaDonDao();
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
	
	public List<HoaDon> getDons (int from, int to){
		
		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HoaDonConstant.GET_HOA_DONS_PHAN_TRANG);
			preparedStatement.setInt(1, from);
			preparedStatement.setInt(2, to);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HoaDon hoaDon = HoaDonConverter.getHoaDon(resultSet);
				hoaDons.add(hoaDon);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return hoaDons;
	}

	public HoaDon getHoaDonTheoMaHoaDon(String maHoaDon) {

		HoaDon hoaDon = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HoaDonConstant.GET_HOA_DON_THEO_MA_HOA_DON);

			preparedStatement.setString(1, maHoaDon);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				hoaDon = HoaDonConverter.getHoaDon(resultSet);

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
	
	public boolean kiemTraMaKhongTrung(String maHoaDon) {

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(HoaDonConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maHoaDon);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
