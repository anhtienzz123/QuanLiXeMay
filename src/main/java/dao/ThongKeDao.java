package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import constant.ThongKeConstant;
import db.DatabaseConnect;

public class ThongKeDao {

	private static ThongKeDao instance;
	private Connection connection;

	private ThongKeDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static ThongKeDao getInstance() {
		if (instance == null)
			instance = new ThongKeDao();
		return instance;
	}

	public Map<String, Double> getDoanhThuNgaysTheoThang(int thang, int nam) {

		Map<String, Double> doanhThuNgays = new TreeMap<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeConstant.DOANH_THU_NGAYS_THEO_THANG);

			preparedStatement.setInt(1, thang);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String ngay = resultSet.getString("ngay");
				double doanhThu = resultSet.getDouble("doanhThu");
				doanhThuNgays.put(ngay, doanhThu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return doanhThuNgays;
	}

	public Map<String, Double> getDoanhThuThangsTheoNam(int nam) {

		Map<String, Double> doanhThuThangs = new TreeMap<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeConstant.DOANH_THU_THANGS_THEO_NAM);

			preparedStatement.setInt(1, nam);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String ngay = resultSet.getString("thang");
				double doanhThu = resultSet.getDouble("doanhThu");
				doanhThuThangs.put(ngay, doanhThu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doanhThuThangs;
	}

	public Map<String, Long> getSoLuongXeBanTheoHangTrongThang(int thang, int nam) {

		Map<String, Long> soLuongXeBans = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeConstant.SO_LUONG_XE_BAN_THEO_HANG_TRONG_THANG);

			preparedStatement.setInt(1, thang);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String tenHangXe = resultSet.getString("tenHangXe");
				long soLuong = resultSet.getLong("soLuong");
				soLuongXeBans.put(tenHangXe, soLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuongXeBans;
	}

	public Double getDoanhThuTheoNgay(int ngay, int thang, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(ThongKeConstant.GET_DOANH_THU_THEO_NGAY);
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
			PreparedStatement preparedStatement = connection.prepareStatement(ThongKeConstant.GET_DOANH_THU_THEO_NGAY);
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

	public Map<String, Long> getTopXeBansTrongThang(int top, int thang, int nam) {

		Map<String, Long> topXeBans = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeConstant.GET_TOP_XE_BAN_CHAY_TRONG_THANG);

			preparedStatement.setInt(1, top);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String tenXeMay = resultSet.getString("tenXeMay");
				long soLuong = resultSet.getLong("soLuongXe");
				topXeBans.put(tenXeMay, soLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topXeBans;
	}

	public Map<String, Long> getTopXeBansTrongNam(int top, int nam) {

		Map<String, Long> topXeBans = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeConstant.GET_TOP_XE_BAN_CHAY_TRONG_NAM);

			preparedStatement.setInt(1, top);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String tenXeMay = resultSet.getString("tenXeMay");
				long soLuong = resultSet.getLong("soLuongXe");
				topXeBans.put(tenXeMay, soLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topXeBans;
	}

}
