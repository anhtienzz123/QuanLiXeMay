package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.HangXeConstant;
import converter.HangXeConvert;
import db.DatabaseConnect;
import entity.HangXe;

public class HangXeDao {

	private static HangXeDao instance;
	private Connection connection;

	private HangXeDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static HangXeDao getInstance() {
		if (instance == null)
			instance = new HangXeDao();
		return instance;
	}

	public List<HangXe> getHangXes() {

		List<HangXe> hangXes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HangXeConstant.GET_HANG_XE);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				HangXe hangXe = HangXeConvert.getHangXe(resultSet);
				hangXes.add(hangXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return hangXes;
	}

	public HangXe getHangXeTheoMa(String maHangXe) {

		HangXe hangXe = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HangXeConstant.GET_HANG_XE_THEO_MA);
			preparedStatement.setString(1, maHangXe);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				hangXe = HangXeConvert.getHangXe(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hangXe;
	}

	public HangXe getHangXeTheoTen(String tenHangXe) {

		HangXe hangXe = null;

		try {
			String sql = HangXeConstant.GET_HANG_XE_THEO_TEN + tenHangXe + "%'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				hangXe = HangXeConvert.getHangXe(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hangXe;
	}

	public boolean capNhatHangXe(HangXe hangXe) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HangXeConstant.CAP_NHAP_HANG_XE);
			HangXeConvert.capNhatHangXe(preparedStatement, hangXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean themHangXe(HangXe hangXe) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HangXeConstant.THEM_HANG_XE);
			HangXeConvert.themHangXe(preparedStatement, hangXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean kiemTraMaKhongTrung(String maHangXe) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(HangXeConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maHangXe);

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
