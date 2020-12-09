package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.ThongKeNhanVienConstant;
import converter.HoaDonConverter;
import db.DatabaseConnect;
import entity.HoaDon;

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
	public Double getDoanhThuTheoNgay(String maNhanVienHanhChinh, int ngay, int thang, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeNhanVienConstant.GET_DOANH_THU_THEO_NGAY);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, ngay);
			preparedStatement.setInt(3, thang);
			preparedStatement.setInt(4, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				doanhThu = resultSet.getDouble("doanhThu");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doanhThu;

	}

	public Double getDoanhThuTheoThang(String maNhanVienHanhChinh, int thang, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeNhanVienConstant.GET_DOANH_THU_THEO_THANG);
			preparedStatement.setString(1, maNhanVienHanhChinh);
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

	public Double getDoanhThuTheoNam(String maNhanVienHanhChinh, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeNhanVienConstant.GET_DOANH_THU_THEO_NAM);
			preparedStatement.setString(1, maNhanVienHanhChinh);
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

	// Thong ke so luong xe ban ra

	public long getSoLuongXeTheoNgay(String maNhanVienHanhChinh, int ngay, int thang, int nam) {

		long result = 0;

		try {
			String sql = ThongKeNhanVienConstant.GET_SO_LUONG_XE_BAN_THEO_NGAY;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, ngay);
			preparedStatement.setInt(3, thang);
			preparedStatement.setInt(4, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuongXe");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	public long getSoLuongXeTheoThang(String maNhanVienHanhChinh, int thang, int nam) {

		long result = 0;

		try {

			String sql = ThongKeNhanVienConstant.GET_SO_LUONG_XE_BAN_THEO_THANG;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuongXe");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public long getSoLuongXeTheoNam(String maNhanVienHanhChinh, int nam) {

		long result = 0;

		try {
			String sql = ThongKeNhanVienConstant.GET_SO_LUONG_XE_BAN_THEO_NAM;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuongXe");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// Thong ke hoa don lap duoc
	public long getHoaDonLapTheoNgay(String maNhanVienHanhChinh, int ngay, int thang, int nam) {

		long result = 0;

		try {
			String sql = ThongKeNhanVienConstant.GET_HOA_DON_LAP_TRONG_NGAY;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, ngay);
			preparedStatement.setInt(3, thang);
			preparedStatement.setInt(4, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuong");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	public long getHoaDonLapTheoThang(String maNhanVienHanhChinh, int thang, int nam) {

		long result = 0;

		try {

			String sql = ThongKeNhanVienConstant.GET_HOA_DON_LAP_TRONG_THANG;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuong");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public long getHoaDonLapTheoNam(String maNhanVienHanhChinh, int nam) {

		long result = 0;

		try {
			String sql = ThongKeNhanVienConstant.GET_HOA_DON_LAP_TRONG_NAM;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuong");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public long getSoLuongTon() {

		long result = 0;

		try {
			String sql = ThongKeNhanVienConstant.GET_SO_LUONG_TON;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				result = resultSet.getLong("soLuong");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	// Thong ke danh sach hoa don
	public List<HoaDon> getHoaDonsTheoNgay(String maNhanVienHanhChinh, int ngay, int thang, int nam) {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			String sql = ThongKeNhanVienConstant.GET_DANH_SACH_HOA_DON_LAP_TRONG_NGAY;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, ngay);
			preparedStatement.setInt(3, thang);
			preparedStatement.setInt(4, nam);

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

	public List<HoaDon> getHoaDonsTheoThang(String maNhanVienHanhChinh, int thang, int nam) {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			String sql = ThongKeNhanVienConstant.GET_DANH_SACH_HOA_DON_LAP_TRONG_THANG;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

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

	public List<HoaDon> getHoaDonsTheoNam(String maNhanVienHanhChinh, int nam) {

		List<HoaDon> hoaDons = new ArrayList<>();

		try {
			String sql = ThongKeNhanVienConstant.GET_DANH_SACH_HOA_DON_LAP_TRONG_NAM;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, nam);

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

	// Thong ke danh sach so xe may ban ra trong
	public Map<String, Long> getXesBanRaTrongNgay(String maNhanVienHanhChinh, int ngay, int thang, int nam) {

		Map<String, Long> result = new HashMap<String, Long>();

		String sql = ThongKeNhanVienConstant.GET_XE_MAY_BAN_RA_TRONG_NGAY;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, ngay);
			preparedStatement.setInt(3, thang);
			preparedStatement.setInt(4, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				result.put(resultSet.getString("tenXeMay"), resultSet.getLong("soLuong"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public Map<String, Long> getXesBanRaTrongThang(String maNhanVienHanhChinh,  int thang, int nam) {

		Map<String, Long> result = new HashMap<String, Long>();

		String sql = ThongKeNhanVienConstant.GET_XE_MAY_BAN_RA_TRONG_THANG;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, thang);
			preparedStatement.setInt(3, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				result.put(resultSet.getString("tenXeMay"), resultSet.getLong("soLuong"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public Map<String, Long> getXesBanRaTrongNam(String maNhanVienHanhChinh, int nam) {

		Map<String, Long> result = new HashMap<String, Long>();

		String sql = ThongKeNhanVienConstant.GET_XE_MAY_BAN_RA_TRONG_NAM;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNhanVienHanhChinh);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				result.put(resultSet.getString("tenXeMay"), resultSet.getLong("soLuong"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
