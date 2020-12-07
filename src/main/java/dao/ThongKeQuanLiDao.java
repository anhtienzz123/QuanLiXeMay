package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import constant.ThongKeQuanLiConstant;
import db.DatabaseConnect;
import other.OutputNhanVien_HoaDonLap;

public class ThongKeQuanLiDao {

	private static ThongKeQuanLiDao instance;
	private Connection connection;

	private ThongKeQuanLiDao() {
		connection = DatabaseConnect.getInstance();
	}

	public static ThongKeQuanLiDao getInstance() {
		if (instance == null)
			instance = new ThongKeQuanLiDao();
		return instance;
	}

	// Doanh thu So
	public Double getDoanhThuTheoNgay(int ngay, int thang, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(ThongKeQuanLiConstant.GET_DOANH_THU_THEO_NGAY);
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
			PreparedStatement preparedStatement = connection.prepareStatement(ThongKeQuanLiConstant.GET_DOANH_THU_THEO_THANG);
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
			PreparedStatement preparedStatement = connection.prepareStatement(ThongKeQuanLiConstant.GET_DOANH_THU_THEO_NAM);
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

	// Thống kê Map
	public Map<String, Double> getDoanhThuNgaysTheoThang(int thang, int nam) {

		Map<String, Double> doanhThuNgays = new TreeMap<>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.DOANH_THU_NGAYS_THEO_THANG);

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
					.prepareStatement(ThongKeQuanLiConstant.DOANH_THU_THANGS_THEO_NAM);

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

	// Thống kê hãng xe
	public Map<String, Long> thongKeHangXeTrongThang(int thang, int nam) {

		Map<String, Long> soLuongXeBans = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.THONG_KE_HANG_XE_TRONG_THANG);

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

	// Thống kê hãng xe
	public Map<String, Long> thongKeHangXeTrongNam(int nam) {

		Map<String, Long> soLuongXeBans = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.THONG_KE_HANG_XE_TRONG_NAM);

			preparedStatement.setInt(1, nam);

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

	// Thống kê dòng xe
	public Map<String, Long> thongKeDongXeTrongThang(int thang, int nam) {

		Map<String, Long> ketQua = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.THONG_KE_DONG_XE_TRONG_THANG);

			preparedStatement.setInt(1, thang);
			preparedStatement.setInt(2, nam);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String tenHangXe = resultSet.getString("tenDongXe");
				long soLuong = resultSet.getLong("soLuong");
				ketQua.put(tenHangXe, soLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	// Thống kê dòng xe
	public Map<String, Long> thongKeDongXeTrongNam(int nam) {

		Map<String, Long> ketQua = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.THONG_KE_DONG_XE_TRONG_NAM);
			preparedStatement.setInt(1, nam);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String tenHangXe = resultSet.getString("tenDongXe");
				long soLuong = resultSet.getLong("soLuong");
				ketQua.put(tenHangXe, soLuong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	// Top sản phẩm bán chạy
	public Map<String, Long> getTopXeBansTrongThang(int top, int thang, int nam) {

		System.out.println(top + " - " + thang + " - " + nam);
		Map<String, Long> topXeBans = new TreeMap<>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.GET_TOP_XE_BAN_CHAY_TRONG_THANG);

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
					.prepareStatement(ThongKeQuanLiConstant.GET_TOP_XE_BAN_CHAY_TRONG_NAM);

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

	public List<OutputNhanVien_HoaDonLap> thongKeHoaDonLapCuaNhanViensTrongNgay(LocalDate localDate) {

		List<OutputNhanVien_HoaDonLap> result = new ArrayList<OutputNhanVien_HoaDonLap>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.THONG_KE_NHAN_VIEN_LAP_HOA_DON_TRONG_NGAY);
			preparedStatement.setInt(1, localDate.getDayOfMonth());
			preparedStatement.setInt(2, localDate.getMonthValue());
			preparedStatement.setInt(3, localDate.getYear());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String maNVHanhChinh = resultSet.getString("maNVHanhChinh");
				String hoTenNV = resultSet.getString("hoTenNV");
				int soLuong = resultSet.getInt("soLuong");
				double tongTien = resultSet.getDouble("tongTien");
				OutputNhanVien_HoaDonLap outputNhanVien_HoaDonLap = new OutputNhanVien_HoaDonLap(maNVHanhChinh, hoTenNV,
						soLuong, tongTien);

				result.add(outputNhanVien_HoaDonLap);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public double getDoanhThuQuyTrongNam(int quy, int nam) {

		double doanhThu = 0;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(ThongKeQuanLiConstant.GET_DOANH_THU_QUY_THEO_NAM);
			int thang1 = (quy - 1) * 3 + 1;
			int thang2 = quy * 3;
			preparedStatement.setInt(1, thang1);
			preparedStatement.setInt(2, thang2);
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

	
}
