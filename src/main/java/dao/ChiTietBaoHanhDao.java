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
}
