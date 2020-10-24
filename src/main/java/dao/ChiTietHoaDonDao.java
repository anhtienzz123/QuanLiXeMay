package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.ChiTietHoaDonConstant;
import converter.ChiTietHoaDonConverter;
import db.DatabaseConnect;
import entity.ChiTietHoaDon;

public class ChiTietHoaDonDao {

	private static ChiTietHoaDonDao instance;
	private Connection connection;

	private ChiTietHoaDonDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static ChiTietHoaDonDao getInstance() {
		if (instance == null)
			instance = new ChiTietHoaDonDao();
		return instance;
	}

	public List<ChiTietHoaDon> getChiTietHoaDonsTheoMaHoaDon(String maHoaDon) {

		List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ChiTietHoaDonConstant.GET_CHI_TIET_HOA_DON_THEO_MA_HOA_DON);

			preparedStatement.setString(1, maHoaDon);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ChiTietHoaDon chiTietHoaDon = ChiTietHoaDonConverter.getChiTietHoaDon(resultSet);
				chiTietHoaDons.add(chiTietHoaDon);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chiTietHoaDons;

	}

	public boolean themChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {

		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDons) {
			boolean temp = themChiTietHoaDon(chiTietHoaDon);
			if (temp == false)
				return false;
		}

		return true;

	}

	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ChiTietHoaDonConstant.THEM_CHI_TIET_HOA_DON);
			ChiTietHoaDonConverter.themChiTietHoaDon(preparedStatement, chiTietHoaDon);

			connection.setAutoCommit(false);
			
			n = preparedStatement.executeUpdate();
			
			//HopDong hopDong = new HopDong(maHopDong, hoaDon, xeMay, phieuBaoHanhs);
			
			HopDongDao hopDongDao = HopDongDao.getInstance();
			
			
			connection.commit();
			
			

		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		return n > 0;

	}

}
