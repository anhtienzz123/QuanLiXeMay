package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constant.ThongKeNhanVienConstant;
import db.DatabaseConnect;

public class ThongKeNhanVienDao {

	private static ThongKeNhanVienDao instance;
	private Connection connection;

	private ThongKeNhanVienDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static ThongKeNhanVienDao getInstance() {
		if (instance == null)
			instance = new ThongKeNhanVienDao();
		return instance;
	}

	// Doanh thu So
	public Double getDoanhThuTheoNgay(int ngay, int thang, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeNhanVienConstant.GET_DOANH_THU_THEO_NGAY);
			preparedStatement.setInt(1, ngay);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				doanhThu = resultSet.getDouble("doanhThu");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doanhThu;

	}

	public Double getDoanhThuTheoThang(int thang, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeNhanVienConstant.GET_DOANH_THU_THEO_THANG);
			preparedStatement.setInt(1, thang);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				doanhThu = resultSet.getDouble("doanhThu");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doanhThu;
	}

	public Double getDoanhThuTheoNam(int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeNhanVienConstant.GET_DOANH_THU_THEO_NAM);
			preparedStatement.setInt(1, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				doanhThu = resultSet.getDouble("doanhThu");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doanhThu;
	}
	
	

}
