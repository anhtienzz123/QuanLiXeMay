package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.ChiTietBaoHanhConstant;
import converter.ChiTietBaoHanhConverter;
import db.DatabaseConnect;
import entity.ChiTietBaoHanh;

public class ChiTietBaoHanhDao {
	private static ChiTietBaoHanhDao instance;
	private Connection connection;

	private ChiTietBaoHanhDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static ChiTietBaoHanhDao getInstance() {
		if (instance == null)
			instance = new ChiTietBaoHanhDao();
		return instance;
	}
	
	public List<ChiTietBaoHanh> getChiTietBaoHanhTheoMaPhieuBaoHanh(String maPhieuBaoHanh) {

		List<ChiTietBaoHanh> chiTietBaoHanhs = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ChiTietBaoHanhConstant.GET_CHI_TIET_PHIEU_BAO_HANH_THEO_MA);
			preparedStatement.setString(1, maPhieuBaoHanh);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ChiTietBaoHanh chiTietBaoHanh =  ChiTietBaoHanhConverter.getChiTietBaoHanhTheoMaPhieuBaoHanh(resultSet);
				chiTietBaoHanhs.add(chiTietBaoHanh);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return chiTietBaoHanhs;
	}
	
	public boolean themChiTietBaoHanhs(List<ChiTietBaoHanh> chiTietBaoHanhs) {

		for (ChiTietBaoHanh chiTietBaoHanh : chiTietBaoHanhs) {
			boolean temp = themChiTietBaoHanh(chiTietBaoHanh);
			if (temp == false)
				return false;
		}

		return true;

	}
	
	public boolean themChiTietBaoHanh(ChiTietBaoHanh chiTietBaoHanh) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ChiTietBaoHanhConstant.THEM_CHI_TIET_BAO_HANH);
			ChiTietBaoHanhConverter.themChiTietBaoHanh(preparedStatement, chiTietBaoHanh);

			connection.setAutoCommit(false);
			n = preparedStatement.executeUpdate();

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
