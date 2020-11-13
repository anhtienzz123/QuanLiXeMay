package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import constant.DongXeConstant;
import converter.DongXeConvert;
import db.DatabaseConnect;
import entity.DongXe;
import entity.XeMay;

public class DongXeDao {
	private static DongXeDao instance;
	private Connection connection;

	private DongXeDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static DongXeDao getInstance() {
		if (instance == null)
			instance = new DongXeDao();
		return instance;
	}

	public List<DongXe> getDongXes() {

		List<DongXe> dongXes = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.GET_DONG_XE);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				DongXe dongXe = DongXeConvert.getDongXe(resultSet);
				dongXes.add(dongXe);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dongXes;
	}

	public DongXe getDongXeTheoMa(String maDongXe) {

		DongXe dongXe = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.GET_DONG_XE_THEO_MA);
			preparedStatement.setString(1, maDongXe);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				dongXe = DongXeConvert.getDongXe(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dongXe;
	}

	public DongXe getDongXeTheoTen(String tenDongXe) {

		DongXe dongXe = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.GET_DONG_XE_THEO_MA);
			preparedStatement.setString(1, tenDongXe);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				dongXe = DongXeConvert.getDongXe(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dongXe;
	}

	public boolean capNhatDongXe(DongXe dongXe) {

		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.CAP_NHAP_DONG_XE);
			DongXeConvert.capNhatDongXe(preparedStatement, dongXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean themDongXe(DongXe dongXe) {

		int n = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.THEM_DONG_XE);
			DongXeConvert.themDongXe(preparedStatement, dongXe);
			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean kiemTraMaKhongTrung(String maDongXe) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DongXeConstant.KIEM_TRA_MA_KHONG_TRUNG);
			preparedStatement.setString(1, maDongXe);

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
